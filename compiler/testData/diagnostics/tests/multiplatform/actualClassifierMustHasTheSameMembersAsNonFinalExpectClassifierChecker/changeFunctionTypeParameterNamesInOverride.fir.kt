// MUTE_EXPECT_ACTUAL_CLASSES_WARNING
// MODULE: m1-common
// FILE: common.kt

open class Base {
    <!INCOMPATIBLE_MATCHING{JVM}!>open fun <T> foo(t: T) {}<!>
}

<!INCOMPATIBLE_MATCHING{JVM}!>expect open class Foo : Base<!>

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt

actual open class Foo : Base() {
    override fun <R> foo(t: R) {}
}
