// MUTE_EXPECT_ACTUAL_CLASSES_WARNING
// MODULE: m1-common
// FILE: common.kt

<!NO_ACTUAL_FOR_EXPECT!>expect enum class En(x: Int) {
    E1,
    E2(42),
    ;

    constructor(s: String)
}<!>

<!NO_ACTUAL_FOR_EXPECT!>expect enum class En2 {
    E1()
}<!>
