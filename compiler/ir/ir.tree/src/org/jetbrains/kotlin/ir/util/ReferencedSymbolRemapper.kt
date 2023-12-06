/*
 * Copyright 2010-2023 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.ir.util

import org.jetbrains.kotlin.ir.declarations.*
import org.jetbrains.kotlin.ir.expressions.*
import org.jetbrains.kotlin.ir.symbols.*
import org.jetbrains.kotlin.ir.types.IrSimpleType
import org.jetbrains.kotlin.ir.types.IrTypeAbbreviation

/**
 * Used to replace symbols that represent references to declarations other than the symbol's owner.
 */
interface ReferencedSymbolRemapper {

    /**
     * Remaps symbols stored in the following properties:
     * - [IrClass.sealedSubclasses]
     * - [IrScript.targetClass]
     * - [IrGetObjectValue.symbol]
     * - [IrCall.superQualifierSymbol]
     * - [IrInstanceInitializerCall.classSymbol]
     */
    fun getReferencedClass(symbol: IrClassSymbol): IrClassSymbol

    /**
     * Remaps symbols stored in the following properties:
     * - [IrFunctionWithLateBinding.correspondingPropertySymbol]
     * - [IrField.correspondingPropertySymbol]
     * - [IrScript.providedProperties]
     * - [IrScript.resultProperty]
     * - [IrSimpleFunction.correspondingPropertySymbol]
     * - [IrPropertyReference.symbol]
     */
    fun getReferencedProperty(symbol: IrPropertySymbol): IrPropertySymbol

    /**
     * Remaps symbols stored in the following properties:
     * - [IrScript.importedScripts]
     * - [IrScript.earlierScripts]
     */
    fun getReferencedScript(symbol: IrScriptSymbol): IrScriptSymbol

    /**
     * Remaps symbols stored in the following properties:
     * - [IrConstructorCall.symbol]
     * - [IrConstantObject.constructor]
     * - [IrDelegatingConstructorCall.symbol]
     * - [IrEnumConstructorCall.symbol]
     */
    fun getReferencedConstructor(symbol: IrConstructorSymbol): IrConstructorSymbol

    /**
     * Remaps symbols stored in the following properties:
     * - [IrGetEnumValue.symbol]
     */
    fun getReferencedEnumEntry(symbol: IrEnumEntrySymbol): IrEnumEntrySymbol

    /**
     * Remaps symbols stored in the following properties:
     * - [IrRawFunctionReference.symbol]
     * - [IrFunctionReference.symbol]
     */
    fun getReferencedFunction(symbol: IrFunctionSymbol): IrFunctionSymbol

    /**
     * Remaps symbols stored in the following properties:
     * - [IrCall.symbol]
     * - [IrPropertyReference.getter]
     * - [IrPropertyReference.setter]
     * - [IrLocalDelegatedPropertyReference.getter]
     * - [IrLocalDelegatedPropertyReference.setter]
     */
    fun getReferencedSimpleFunction(symbol: IrSimpleFunctionSymbol): IrSimpleFunctionSymbol

    /**
     * Remaps symbols stored in the following properties:
     * - [IrPropertyReference.field]
     * - [IrGetField.symbol]
     * - [IrSetField.symbol]
     */
    fun getReferencedField(symbol: IrFieldSymbol): IrFieldSymbol

    /**
     * Remaps symbols stored in the following properties:
     * - [IrLocalDelegatedPropertyReference.symbol]
     */
    fun getReferencedLocalDelegatedProperty(symbol: IrLocalDelegatedPropertySymbol): IrLocalDelegatedPropertySymbol

    /**
     * Remaps symbols stored in the following properties:
     * - [IrLocalDelegatedPropertyReference.delegate]
     */
    fun getReferencedVariable(symbol: IrVariableSymbol): IrVariableSymbol

    /**
     * Remaps symbols stored in the following properties:
     * - [IrClassReference.symbol]
     * - [IrSimpleType.classifier]
     */
    fun getReferencedClassifier(symbol: IrClassifierSymbol): IrClassifierSymbol

    /**
     * Remaps symbols stored in the following properties:
     * - [IrReturn.returnTargetSymbol]
     */
    fun getReferencedReturnTarget(symbol: IrReturnTargetSymbol): IrReturnTargetSymbol

    /**
     * Remaps symbols stored in the following properties:
     * - [IrGetValue.symbol]
     * - [IrSetValue.symbol]
     */
    fun getReferencedValue(symbol: IrValueSymbol): IrValueSymbol

    /**
     * Remaps symbols stored in the following properties:
     * - [IrTypeAbbreviation.typeAlias]
     */
    fun getReferencedTypeAlias(symbol: IrTypeAliasSymbol): IrTypeAliasSymbol
}
