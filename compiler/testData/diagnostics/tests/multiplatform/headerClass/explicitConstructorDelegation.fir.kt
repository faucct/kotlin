// MUTE_EXPECT_ACTUAL_CLASSES_WARNING
// MODULE: m1-common
// FILE: common.kt
<!NO_ACTUAL_FOR_EXPECT!>expect open class A {
    constructor(s: String)

    constructor(n: Number) : <!EXPECTED_CLASS_CONSTRUCTOR_DELEGATION_CALL!>this<!>("A")
}<!>

<!NO_ACTUAL_FOR_EXPECT!>expect class B : A {
    constructor(i: Int)

    constructor() : <!EXPECTED_CLASS_CONSTRUCTOR_DELEGATION_CALL!>super<!>("B")
}<!>
