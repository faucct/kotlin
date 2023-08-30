// MUTE_EXPECT_ACTUAL_CLASSES_WARNING
// MODULE: m1-common
// FILE: common.kt

expect class Foo
expect class Bar()
expect class Baz constructor()
expect class FooBar {
    constructor()
}

fun test() {
    <!EXPECT_CLASS_AS_FUNCTION!>Foo<!>()
    Bar()
    Baz()
    FooBar()
}

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt

actual class Foo
actual class Bar
actual class Baz
actual class FooBar
