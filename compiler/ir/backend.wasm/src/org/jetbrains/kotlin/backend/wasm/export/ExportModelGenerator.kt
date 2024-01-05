/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.backend.wasm.export

import org.jetbrains.kotlin.backend.wasm.WasmBackendContext
import org.jetbrains.kotlin.backend.wasm.ir2wasm.isExported
import org.jetbrains.kotlin.backend.wasm.lower.KOTLIN_TO_JS_CLOSURE_ORIGIN
import org.jetbrains.kotlin.config.CommonConfigurationKeys
import org.jetbrains.kotlin.descriptors.ClassKind
import org.jetbrains.kotlin.ir.backend.js.export.*
import org.jetbrains.kotlin.ir.backend.js.utils.getFqNameWithJsNameWhenAvailable
import org.jetbrains.kotlin.ir.declarations.*
import org.jetbrains.kotlin.ir.symbols.IrClassSymbol
import org.jetbrains.kotlin.ir.symbols.IrTypeParameterSymbol
import org.jetbrains.kotlin.ir.types.*
import org.jetbrains.kotlin.ir.util.*
import org.jetbrains.kotlin.serialization.js.ModuleKind
import org.jetbrains.kotlin.utils.memoryOptimizedFlatMap
import org.jetbrains.kotlin.utils.memoryOptimizedMap

class ExportModelGenerator(val context: WasmBackendContext) {
    fun generateExport(modules: Iterable<IrModuleFragment>): ExportedModule =
        ExportedModule(
            context.configuration[CommonConfigurationKeys.MODULE_NAME]!!,
            ModuleKind.ES,
            modules.flatMap { it.files }.memoryOptimizedFlatMap {
                generateExport(it)
            }
        )


    private fun generateExport(file: IrPackageFragment): List<ExportedDeclaration> =
        file.declarations.memoryOptimizedFlatMap { declaration -> listOfNotNull(exportDeclaration(declaration)) }

    private fun exportDeclaration(declaration: IrDeclaration): ExportedDeclaration? {
        val candidate = getExportCandidate(declaration) ?: return null
        return when (candidate) {
            is IrSimpleFunction -> exportFunction(candidate)
            else -> error("Can't export declaration $candidate")
        }.withAttributesFor(candidate)
    }

    private fun exportFunction(function: IrSimpleFunction): ExportedFunction =
        ExportedFunction(
            function.getExportedIdentifier(),
            returnType = exportType(function.returnType),
            typeParameters = function.typeParameters.memoryOptimizedMap(::exportTypeParameter),
            ir = function,
            isProtected = false,
            parameters = (listOfNotNull(function.extensionReceiverParameter) + function.valueParameters)
                .memoryOptimizedMap { exportParameter(it) },
        )

    private fun exportParameter(parameter: IrValueParameter): ExportedParameter =
        ExportedParameter(
            parameter.name.asString(),
            exportType(parameter.type),
            parameter.defaultValue != null
        )

    private val currentlyProcessedTypes = hashSetOf<IrType>()

    private fun exportType(type: IrType): ExportedType {
        if (type in currentlyProcessedTypes)
            return ExportedType.Primitive.Any

        if (type !is IrSimpleType)
            return ExportedType.ErrorType("NonSimpleType ${type.render()}")

        currentlyProcessedTypes.add(type)

        val classifier = type.classifier
        val isMarkedNullable = type.isMarkedNullable()
        val nonNullType = type.makeNotNull() as IrSimpleType
        val jsRelatedSymbols = context.wasmSymbols.jsRelatedSymbols

        val exportedType = when {
            nonNullType.isBoolean() || nonNullType == jsRelatedSymbols.jsBooleanType -> ExportedType.Primitive.Boolean
            nonNullType.isLong() || nonNullType == jsRelatedSymbols.jsBigIntType -> ExportedType.Primitive.BigInt
            nonNullType.isPrimitiveType() && !nonNullType.isChar() || nonNullType == jsRelatedSymbols.jsNumberType ->
                ExportedType.Primitive.Number
            nonNullType == jsRelatedSymbols.jsStringType -> ExportedType.Primitive.String
            nonNullType == jsRelatedSymbols.jsAnyType -> ExportedType.Primitive.Unknown
            nonNullType.isUnit() || nonNullType == context.wasmSymbols.voidType -> ExportedType.Primitive.Unit
            nonNullType.isFunction() -> ExportedType.Function(
                parameterTypes = nonNullType.arguments.dropLast(1).memoryOptimizedMap { exportTypeArgument(it) },
                returnType = exportTypeArgument(nonNullType.arguments.last())
            )

            classifier is IrTypeParameterSymbol -> ExportedType.TypeParameter(classifier.owner.name.identifier)

            classifier is IrClassSymbol -> {
                val klass = classifier.owner
                if (klass.symbol == jsRelatedSymbols.jsReferenceClass) return ExportedType.Primitive.Unknown
                if (klass.isValue) return exportType(klass.primaryConstructor!!.valueParameters.first().type)
                if (!klass.isExternal) return error("Unexpected class: ${klass.symbol}")
                val name = klass.getFqNameWithJsNameWhenAvailable(shouldIncludePackage = false).asString()

                when (klass.kind) {
                    ClassKind.OBJECT ->
                        ExportedType.TypeOf(name)

                    ClassKind.CLASS,
                    ClassKind.INTERFACE ->
                        ExportedType.ClassType(
                            name,
                            type.arguments.memoryOptimizedMap { exportTypeArgument(it) },
                            klass
                        )
                    else -> error("Unexpected class kind ${klass.kind}")
                }
            }

            else -> error("Unexpected classifier $classifier")
        }

        return exportedType.withNullability(isMarkedNullable)
            .also { currentlyProcessedTypes.remove(type) }
    }

    private fun exportTypeArgument(type: IrTypeArgument): ExportedType {
        if (type is IrTypeProjection)
            return exportType(type.type)

        if (type is IrType)
            return exportType(type)

        return ExportedType.ErrorType("UnknownType ${type.render()}")
    }

    private fun exportTypeParameter(typeParameter: IrTypeParameter): ExportedType.TypeParameter {
        val constraint = typeParameter.superTypes.asSequence()
            .filter { it != context.irBuiltIns.anyNType }
            .map {
                val exportedType = exportType(it)
                if (exportedType is ExportedType.ImplicitlyExportedType && exportedType.exportedSupertype == ExportedType.Primitive.Any) {
                    exportedType.copy(exportedSupertype = ExportedType.Primitive.Unknown)
                } else {
                    exportedType
                }
            }
            .filter { it !is ExportedType.ErrorType }
            .toList()

        return ExportedType.TypeParameter(
            typeParameter.name.identifier,
            constraint.run {
                when (size) {
                    0 -> null
                    1 -> single()
                    else -> reduce(ExportedType::IntersectionType)
                }
            }
        )
    }

    private fun getExportCandidate(declaration: IrDeclaration): IrDeclarationWithName? =
        (declaration as? IrSimpleFunction)?.takeIf { it.isExported() && it.origin != KOTLIN_TO_JS_CLOSURE_ORIGIN }
}