// CHECK_TYPESCRIPT_DECLARATIONS
// TARGET_BACKEND: WASM
// MODULE: main

// FILE: first.kt
external interface Bar {
    val bar: Int
}

external interface Baz<T: JsAny?> : Bar {
    val baz: T
}

// FILE: second.kt
package org.second

import Bar
import Baz

external object Foo : Baz<JsString> {
    override val bar: Int
    override val baz: JsString
}

external abstract class BaseResult<T: JsAny>(foo: Foo)

external class Result<T: JsAny> : BaseResult<T>

fun getResultInternal(): Result<JsString> = js("({})")

@JsExport
fun getResult(): Result<JsString> = getResultInternal()

// FILE: entry.mjs

import main from "./index.mjs";

if (JSON.stringify(main.getResult()) != "{}") throw new Error("Unexpected result")