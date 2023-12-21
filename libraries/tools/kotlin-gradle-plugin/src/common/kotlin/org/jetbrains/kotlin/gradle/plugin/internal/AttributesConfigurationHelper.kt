/*
 * Copyright 2010-2023 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.gradle.plugin.internal

import org.gradle.api.Project
import org.gradle.api.attributes.Attribute
import org.gradle.api.attributes.HasAttributes
import org.gradle.api.provider.ProviderFactory
import org.jetbrains.kotlin.gradle.plugin.VariantImplementationFactories
import org.jetbrains.kotlin.gradle.plugin.variantImplementationFactory

/**
 * Gradle 7.4 has introduced a way configuring attribute using provider. Since Gradle 8.3 using eager way to configure attribute causes
 * eager task realization (see KT-60664).
 */
interface AttributesConfigurationHelper {
    fun <T : Any> setAttribute(
        attributesContainer: HasAttributes,
        key: Attribute<T>,
        attribute: () -> T
    )

    interface AttributeConfigurationHelperVariantFactory : VariantImplementationFactories.VariantImplementationFactory {
        fun getInstance(providerFactory: ProviderFactory): AttributesConfigurationHelper
    }
}

internal class DefaultAttributesConfigurationHelper(
    private val providerFactory: ProviderFactory
) : AttributesConfigurationHelper {
    override fun <T : Any> setAttribute(
        attributesContainer: HasAttributes,
        key: Attribute<T>,
        attribute: () -> T
    ) {
        attributesContainer.attributes.attributeProvider(
            key,
            providerFactory.provider { attribute() }
        )
    }
}

internal class DefaultAttributeConfigurationHelperVariantFactory :
    AttributesConfigurationHelper.AttributeConfigurationHelperVariantFactory {
    override fun getInstance(
        providerFactory: ProviderFactory
    ): AttributesConfigurationHelper = DefaultAttributesConfigurationHelper(providerFactory)
}

internal val Project.attributesConfigurationHelper
    get() = variantImplementationFactory<AttributesConfigurationHelper.AttributeConfigurationHelperVariantFactory>()
        .getInstance(providers)
