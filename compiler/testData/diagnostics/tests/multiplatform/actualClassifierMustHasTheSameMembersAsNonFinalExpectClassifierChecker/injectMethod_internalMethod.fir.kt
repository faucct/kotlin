// MUTE_EXPECT_ACTUAL_CLASSES_WARNING
// MODULE: m1-common
// FILE: common.kt

expect open class Foo {
    fun existingMethod()
    val existingParam: Int
}

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt

actual open class Foo {
    actual fun existingMethod() {}
    actual val existingParam: Int = 904

    internal fun injectedMethod() {} // accidential override can happen with this injected fun. That's why it's prohibited
}
