// WITH_STDLIB

// FILE: test.kt
fun box() {
    val map: Map<String, String> = mapOf("1" to "23")

    for
            (
    (
        a
            ,
        b
    )
    in
    map
    )
    {
        a + b
    }
}

// EXPECTATIONS JVM_IR JVM_IR +USE_INLINE_SCOPES_NUMBERS
// test.kt:5 box:
// test.kt:15 box: map:java.util.Map=java.util.Collections$SingletonMap
// EXPECTATIONS FIR JVM_IR JVM_IR +USE_INLINE_SCOPES_NUMBERS
// test.kt:9 box: map:java.util.Map=java.util.Collections$SingletonMap
// EXPECTATIONS JVM_IR JVM_IR +USE_INLINE_SCOPES_NUMBERS
// test.kt:10 box: map:java.util.Map=java.util.Collections$SingletonMap
// test.kt:12 box: map:java.util.Map=java.util.Collections$SingletonMap, a:java.lang.String="1":java.lang.String
// test.kt:18 box: map:java.util.Map=java.util.Collections$SingletonMap, a:java.lang.String="1":java.lang.String, b:java.lang.String="23":java.lang.String
// test.kt:15 box: map:java.util.Map=java.util.Collections$SingletonMap
// test.kt:20 box: map:java.util.Map=java.util.Collections$SingletonMap

// EXPECTATIONS JS_IR
// test.kt:5 box:
// test.kt:5 box:
// test.kt:15 box: map=kotlin.collections.HashMap
// test.kt:15 box: map=kotlin.collections.HashMap
// test.kt:18 box: map=kotlin.collections.HashMap, a="1":kotlin.String, b="23":kotlin.String
// test.kt:15 box: map=kotlin.collections.HashMap, a="1":kotlin.String, b="23":kotlin.String
// test.kt:20 box: map=kotlin.collections.HashMap, a="1":kotlin.String, b="23":kotlin.String
