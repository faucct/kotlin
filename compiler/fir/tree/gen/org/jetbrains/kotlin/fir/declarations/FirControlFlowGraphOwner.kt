/*
 * Copyright 2010-2023 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

// This file was generated automatically. See compiler/fir/tree/tree-generator/Readme.md.
// DO NOT MODIFY IT MANUALLY.

package org.jetbrains.kotlin.fir.declarations

import org.jetbrains.kotlin.KtSourceElement
import org.jetbrains.kotlin.fir.FirElementInterface
import org.jetbrains.kotlin.fir.references.FirControlFlowGraphReference

/**
 * Generated from: [org.jetbrains.kotlin.fir.tree.generator.FirTreeBuilder.controlFlowGraphOwner]
 */
interface FirControlFlowGraphOwner : FirElementInterface {
    override val source: KtSourceElement?
    val controlFlowGraphReference: FirControlFlowGraphReference?

    fun replaceControlFlowGraphReference(newControlFlowGraphReference: FirControlFlowGraphReference?)
}
