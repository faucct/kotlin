/*
 * Copyright 2010-2018 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.library.metadata

import org.jetbrains.kotlin.library.KLIB_PROPERTY_METADATA_VERSION
import org.jetbrains.kotlin.library.KotlinLibrary
import org.jetbrains.kotlin.metadata.deserialization.BinaryVersion

/**
 * The version for `KlibMetadataProtoBuf.proto`. If you do any incompatible changes in the proto then you must bump the version.
 *
 * The version bump must obey [org.jetbrains.kotlin.metadata.deserialization.BinaryVersion] rules (See BinaryVersion KDoc).
 */
class KlibMetadataVersion(vararg numbers: Int) : BinaryVersion(*numbers) {

    override fun isCompatible(): Boolean = isCompatibleTo(INSTANCE)

    companion object {
        @JvmField
        val INSTANCE = KlibMetadataVersion(1, 4, 1)

        @JvmField
        val INVALID_VERSION = KlibMetadataVersion()

        fun parse(plainString: String): KlibMetadataVersion? = parseVersionArray(plainString)?.let { KlibMetadataVersion(*it) }
    }
}

val KotlinLibrary.metadataVersion: KlibMetadataVersion?
    get() {
        val versionString = manifestProperties.getProperty(KLIB_PROPERTY_METADATA_VERSION) ?: return null
        val versionIntArray = BinaryVersion.parseVersionArray(versionString) ?: return null
        return KlibMetadataVersion(*versionIntArray)
    }
