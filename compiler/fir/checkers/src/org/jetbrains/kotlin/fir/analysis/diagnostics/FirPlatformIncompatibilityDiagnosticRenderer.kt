/*
 * Copyright 2010-2016 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.kotlin.fir.analysis.diagnostics

import org.jetbrains.kotlin.diagnostics.rendering.ContextIndependentParameterRenderer
import org.jetbrains.kotlin.fir.symbols.FirBasedSymbol
import org.jetbrains.kotlin.fir.symbols.impl.FirCallableSymbol
import org.jetbrains.kotlin.fir.symbols.impl.FirRegularClassSymbol
import org.jetbrains.kotlin.resolve.multiplatform.ExpectActualCheckingCompatibility
import org.jetbrains.kotlin.resolve.multiplatform.ExpectActualCompatibility
import org.jetbrains.kotlin.resolve.multiplatform.ExpectActualMemberDiff
import java.text.MessageFormat

class FirPlatformIncompatibilityDiagnosticRenderer(
    private val mode: MultiplatformDiagnosticRenderingMode
) : ContextIndependentParameterRenderer<Map<out ExpectActualCompatibility<FirBasedSymbol<*>>, Collection<FirBasedSymbol<*>>>> {
    override fun render(
        obj: Map<out ExpectActualCompatibility<FirBasedSymbol<*>>, Collection<FirBasedSymbol<*>>>,
    ): String {
        if (obj.isEmpty()) return ""

        return buildString {
            mode.newLine(this)
            renderIncompatibilityInformation(obj, "", mode)
        }
    }

    companion object {
        @JvmField
        val TEXT = FirPlatformIncompatibilityDiagnosticRenderer(MultiplatformDiagnosticRenderingMode())
    }
}

class FirIncompatibleExpectedActualClassScopesRenderer(
    private val mode: MultiplatformDiagnosticRenderingMode
) : ContextIndependentParameterRenderer<List<Pair<FirBasedSymbol<*>, Map<out ExpectActualCompatibility.MismatchOrIncompatible<FirBasedSymbol<*>>, Collection<FirBasedSymbol<*>>>>>> {
    override fun render(
        obj: List<Pair<FirBasedSymbol<*>, Map<out ExpectActualCompatibility.MismatchOrIncompatible<FirBasedSymbol<*>>, Collection<FirBasedSymbol<*>>>>>
    ): String {
        if (obj.isEmpty()) return ""

        return buildString {
            mode.newLine(this)
            renderIncompatibleClassScopes(obj, "", mode)
        }
    }

    companion object {
        @JvmField
        val TEXT = FirIncompatibleExpectedActualClassScopesRenderer(MultiplatformDiagnosticRenderingMode())
    }
}

class FirExpectActualScopeDiffsRenderer(
    private val mode: MultiplatformDiagnosticRenderingMode,
) : ContextIndependentParameterRenderer<Set<ExpectActualMemberDiff<FirCallableSymbol<*>, FirRegularClassSymbol>>> {
    override fun render(obj: Set<ExpectActualMemberDiff<FirCallableSymbol<*>, FirRegularClassSymbol>>): String {
        check(obj.isNotEmpty())
        return buildString {
            mode.renderList(this, obj.toList().map { diff ->
                {
                    appendLine()
                    appendLine(FirExpectActualScopeDiffRenderer.render(diff))
                }
            })
        }
    }

    companion object {
        @JvmField
        val TEXT = FirExpectActualScopeDiffsRenderer(MultiplatformDiagnosticRenderingMode())
    }
}

object FirExpectActualScopeDiffRenderer : ContextIndependentParameterRenderer<ExpectActualMemberDiff<FirCallableSymbol<*>, FirRegularClassSymbol>> {
    override fun render(obj: ExpectActualMemberDiff<FirCallableSymbol<*>, FirRegularClassSymbol>): String = MessageFormat.format(
        obj.kind.rawMessage,
        FirDiagnosticRenderers.SYMBOL.render(obj.actualMember),
        FirDiagnosticRenderers.SYMBOL.render(obj.expectClass)
    )
}

class FirListRenderer<T>(
    private val elementRenderer: ContextIndependentParameterRenderer<T>,
    private val elemProcessor: (String) -> String = { it },
) : ContextIndependentParameterRenderer<List<T>> {
    override fun render(obj: List<T>): String = obj.joinToString { elemProcessor(elementRenderer.render(it)) }
}

open class MultiplatformDiagnosticRenderingMode {
    open fun newLine(sb: StringBuilder) {
        sb.appendLine()
    }

    open fun renderList(sb: StringBuilder, elements: List<() -> Unit>) {
        sb.appendLine()
        for (element in elements) {
            element()
        }
    }

    open fun renderSymbol(sb: StringBuilder, symbol: FirBasedSymbol<*>, indent: String) {
        sb.append(indent)
        sb.append(INDENTATION_UNIT)
        sb.appendLine(FirDiagnosticRenderers.SYMBOL.render(symbol))
    }
}

private fun StringBuilder.renderIncompatibilityInformation(
    map: Map<out ExpectActualCompatibility<FirBasedSymbol<*>>, Collection<FirBasedSymbol<*>>>,
    indent: String,
    mode: MultiplatformDiagnosticRenderingMode
) {
    for ((compatibility, descriptors) in map) {
        append(indent)
        append("The following declaration")
        if (descriptors.size == 1) append(" is") else append("s are")
        append(" incompatible")
        (compatibility as? ExpectActualCompatibility.MismatchOrIncompatible)?.reason?.let { append(" because $it") }
        append(":")

        mode.renderList(this, descriptors.map { descriptor ->
            { mode.renderSymbol(this, descriptor, indent) }
        })

        if (compatibility is ExpectActualCheckingCompatibility.ClassScopes) {
            append(indent)
            append("No actual members are found for expected members listed below:")
            mode.newLine(this)
            renderIncompatibleClassScopes(compatibility.unfulfilled, indent, mode)
        }
    }
}

private fun StringBuilder.renderIncompatibleClassScopes(
    unfulfilled: List<Pair<FirBasedSymbol<*>, Map<out ExpectActualCompatibility<FirBasedSymbol<*>>, Collection<FirBasedSymbol<*>>>>>,
    indent: String,
    mode: MultiplatformDiagnosticRenderingMode
) {
    mode.renderList(this, unfulfilled.indices.map { index ->
        {
            val (descriptor, mapping) = unfulfilled[index]
            mode.renderSymbol(this, descriptor, indent)
            if (mapping.isNotEmpty()) {
                mode.newLine(this)
                renderIncompatibilityInformation(mapping, indent + INDENTATION_UNIT, mode)
            }
            if (index != unfulfilled.lastIndex) {
                mode.newLine(this)
            }
        }
    })
}

internal const val INDENTATION_UNIT = "    "
