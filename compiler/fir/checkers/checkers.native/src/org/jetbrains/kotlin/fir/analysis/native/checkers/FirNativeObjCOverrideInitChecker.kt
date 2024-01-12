/*
 * Copyright 2010-2022 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.fir.analysis.native.checkers

import org.jetbrains.kotlin.diagnostics.DiagnosticReporter
import org.jetbrains.kotlin.diagnostics.reportOn
import org.jetbrains.kotlin.fir.*
import org.jetbrains.kotlin.fir.analysis.checkers.MppCheckerKind
import org.jetbrains.kotlin.fir.analysis.checkers.context.CheckerContext
import org.jetbrains.kotlin.fir.analysis.checkers.getOverriddenSymbols
import org.jetbrains.kotlin.fir.analysis.checkers.declaration.FirClassChecker
import org.jetbrains.kotlin.fir.analysis.diagnostics.native.FirNativeErrors
import org.jetbrains.kotlin.fir.backend.native.interop.getObjCInitMethod
import org.jetbrains.kotlin.fir.backend.native.interop.isKotlinObjCClass
import org.jetbrains.kotlin.fir.declarations.*
import org.jetbrains.kotlin.fir.declarations.utils.isExpect
import org.jetbrains.kotlin.fir.resolve.ScopeSession
import org.jetbrains.kotlin.fir.resolve.getSuperClassSymbolOrAny
import org.jetbrains.kotlin.fir.symbols.SymbolInternals
import org.jetbrains.kotlin.fir.symbols.impl.FirConstructorSymbol
import org.jetbrains.kotlin.fir.types.*
import org.jetbrains.kotlin.name.NativeStandardInteropNames.objCOverrideInitClassId

object FirNativeObjCOverrideInitChecker : FirClassChecker(MppCheckerKind.Common) {
    @OptIn(SymbolInternals::class)
    override fun check(declaration: FirClass, context: CheckerContext, reporter: DiagnosticReporter) {
        val session = context.session

        fun FirConstructor.overridesConstructor(other: FirConstructor): Boolean {
            if (valueParameters.size != other.valueParameters.size)
                return false
            return valueParameters.zip(other.valueParameters).all { (thisParameter, otherParameter) ->
                thisParameter.name == otherParameter.name && thisParameter.returnTypeRef.coneType == otherParameter.returnTypeRef.coneType
            }
        }

        fun checkCanGenerateOverrideInit(firClass: FirClass, constructor: FirConstructor) {
            val superClass = (firClass as FirRegularClass).symbol.getSuperClassSymbolOrAny(session)
            val superConstructors = superClass.fir.constructors(session).filter {
                constructor.overridesConstructor(it.fir)
            }.toList()

            val superConstructor: FirConstructorSymbol = superConstructors.singleOrNull() ?: run {
                if (superConstructors.isEmpty())
                    reporter.reportOn(
                        constructor.source,
                        FirNativeErrors.CONSTRUCTOR_DOES_NOT_OVERRIDE_ANY_SUPER_CONSTRUCTOR,
                        objCOverrideInitClassId.asSingleFqName(),
                        context
                    )
                else
                    reporter.reportOn(
                        constructor.source,
                        FirNativeErrors.CONSTRUCTOR_MATCHES_SEVERAL_SUPER_CONSTRUCTORS,
                        objCOverrideInitClassId.asSingleFqName(),
                        context
                    )
                return
            }

            val initMethod = superConstructor.fir.getObjCInitMethod(session, ScopeSession())!!

            // Remove fake overrides of this init method, also check for explicit overriding:
            firClass.declarations.forEach {
                if (it is FirSimpleFunction && initMethod.symbol in it.getOverriddenSymbols(context) && !it.isSubstitutionOrIntersectionOverride) {
                    reporter.reportOn(
                        constructor.source,
                        FirNativeErrors.CONSTRUCTOR_OVERRIDES_ALREADY_OVERRIDDEN_OBJC_INITIALIZER,
                        objCOverrideInitClassId.asSingleFqName(),
                        context
                    )
                }
            }
        }

        fun checkKotlinObjCClass(firClass: FirClass) {
            for (decl in firClass.declarations) {
                if (decl is FirConstructor && decl.annotations.hasAnnotation(objCOverrideInitClassId, session))
                    checkCanGenerateOverrideInit(firClass, decl)
            }
        }

        if (!declaration.isExpect && declaration.symbol.isKotlinObjCClass(context.session)) {
            checkKotlinObjCClass(declaration)
        }
    }
}
