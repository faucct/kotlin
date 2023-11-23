/*
 * Copyright 2010-2023 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

// This file was generated automatically. See compiler/fir/tree/tree-generator/Readme.md.
// DO NOT MODIFY IT MANUALLY.

package org.jetbrains.kotlin.fir.declarations

import org.jetbrains.kotlin.KtSourceElement
import org.jetbrains.kotlin.fir.visitors.FirTransformer

/**
 * Generated from: [org.jetbrains.kotlin.fir.tree.generator.FirTreeBuilder.typeParametersOwner]
 */
sealed interface FirTypeParametersOwner : FirTypeParameterRefsOwner {
    override val source: KtSourceElement?
    override val typeParameters: List<FirTypeParameter>

    override fun <D> transformTypeParameters(transformer: FirTransformer<D>, data: D): FirTypeParametersOwner
}
