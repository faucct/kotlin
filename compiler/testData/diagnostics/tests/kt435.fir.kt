// COMPARE_WITH_LIGHT_TREE
fun Any.foo1() : (i : Int) -> Unit {
    return {}
}

fun test(a : Any) {
    <!NO_VALUE_FOR_PARAMETER{LT}!><!NO_VALUE_FOR_PARAMETER{PSI}!>a.foo1()<!>()<!>
}
