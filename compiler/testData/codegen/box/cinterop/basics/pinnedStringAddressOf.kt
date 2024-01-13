/*
 * Copyright 2010-2023 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the LICENSE file.
 */
// TARGET_BACKEND: NATIVE
@file:OptIn(kotlinx.cinterop.ExperimentalForeignApi::class)

import kotlin.test.*
import kotlinx.cinterop.*

fun box(): String {
    val str = "0000000000"
    str.usePinned {
        it.addressOf(0)
        it.addressOf(9)
        assertFailsWith<IndexOutOfBoundsException> {
            it.addressOf(10)
        }
        assertFailsWith<IndexOutOfBoundsException> {
            it.addressOf(-1)
        }
        assertFailsWith<IndexOutOfBoundsException> {
            it.addressOf(Int.MAX_VALUE)
        }
        assertFailsWith<IndexOutOfBoundsException> {
            it.addressOf(Int.MIN_VALUE)
        }
    }
    return "OK"
}
