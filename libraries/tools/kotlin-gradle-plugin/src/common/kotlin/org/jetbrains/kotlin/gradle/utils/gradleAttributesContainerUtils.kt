/*
 * Copyright 2010-2023 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.gradle.utils

import org.gradle.api.Project
import org.gradle.api.attributes.Attribute
import org.gradle.api.attributes.AttributeContainer
import org.gradle.api.attributes.HasAttributes
import org.jetbrains.kotlin.gradle.plugin.internal.attributesConfigurationHelper

/**
 * KGP's internal analog of [org.gradle.api.internal.attributes.AttributeContainerInternal.asMap]
 * Can be used to compare attributes
 */
internal fun AttributeContainer.toMap(): Map<Attribute<*>, Any?> {
    val result = mutableMapOf<Attribute<*>, Any?>()
    for (key in keySet()) {
        result[key] = getAttribute(key)
    }

    return result
}

internal fun <T : Any> HasAttributes.setAttribute(
    project: Project,
    key: Attribute<T>,
    attribute: () -> T
) {
    project.attributesConfigurationHelper.setAttribute(this, key, attribute)
}

internal fun <T : Any> HasAttributes.copyAttributeTo(
    project: Project,
    dest: HasAttributes,
    key: Attribute<T>,
) {
    dest.setAttribute(project, key) {
        attributes.getAttribute(key) ?: throw IllegalStateException("Failed to get ${key.name} attribute! Container doesn't have it.")
    }
}

internal fun HasAttributes.copyAttributesTo(
    project: Project,
    dest: HasAttributes,
    keys: Iterable<Attribute<*>> = attributes.keySet(),
) {
    for (key in keys) {
        copyAttributeTo(project, dest, key)
    }
}
