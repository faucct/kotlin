/*
 * Copyright 2010-2023 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package kotlin

@PublishedApi
internal expect fun uintRemainder(v1: UInt, v2: UInt): UInt

@PublishedApi
internal expect fun ulongRemainder(v1: ULong, v2: ULong): ULong

@PublishedApi
internal expect fun uintDivide(v1: UInt, v2: UInt): UInt

@PublishedApi
internal expect fun ulongDivide(v1: ULong, v2: ULong): ULong

@PublishedApi
internal expect fun uintCompare(v1: Int, v2: Int): Int

@PublishedApi
internal expect fun ulongCompare(v1: Long, v2: Long): Int

@PublishedApi
internal expect fun ubyteToByte(value: UByte): Byte

@PublishedApi
internal expect fun ushortToShort(value: UShort): Short

@PublishedApi
internal expect fun uintToInt(value: UInt): Int

@PublishedApi
internal expect fun intToUInt(value: Int): UInt

@PublishedApi
internal expect fun uintToULong(value: Int): ULong

@PublishedApi
internal expect fun uintToLong(value: Int): Long

@PublishedApi
internal expect fun uintToFloat(value: Int): Float

@PublishedApi
internal expect fun floatToUInt(value: Float): UInt

@PublishedApi
internal expect fun uintToDouble(value: Int): Double

@PublishedApi
internal expect fun doubleToUInt(value: Double): UInt

@PublishedApi
internal expect fun ulongToLong(value: ULong): Long

@PublishedApi
internal expect fun longToULong(value: Long): ULong

@PublishedApi
internal expect fun ulongToFloat(value: Long): Float

@PublishedApi
internal expect fun floatToULong(value: Float): ULong

@PublishedApi
internal expect fun ulongToDouble(value: Long): Double

@PublishedApi
internal expect fun doubleToULong(value: Double): ULong

@PublishedApi
internal expect fun ulongToString(value: Long): String

@PublishedApi
internal expect fun ulongToString(value: Long, base: Int): String
