// MUTE_EXPECT_ACTUAL_CLASSES_WARNING
// MODULE: m1-common
// FILE: common.kt

open class Base {
    open var red1: String = ""
    open lateinit var red2: String
    open lateinit var green: String
}

expect open class Foo : Base {
}

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt

actual open <!ACTUAL_CLASSIFIER_MUST_HAVE_THE_SAME_MEMBERS_AS_NON_FINAL_EXPECT_CLASSIFIER!>class Foo<!> : Base() {
    override <!LATEINIT_CHANGED_IN_NON_FINAL_EXPECT_CLASSIFIER_ACTUALIZATION!>lateinit<!> var red1: String
    override var <!LATEINIT_CHANGED_IN_NON_FINAL_EXPECT_CLASSIFIER_ACTUALIZATION!>red2<!>: String = ""
    override lateinit var green: String
}
