// FIR_IDENTICAL
// WITH_STDLIB

interface I

enum class MyEnum : I {
    EnumEntry
}

open class Foo<P>(val data: Map<P, Any?>) where P : Enum<P>, P : I

private fun test(node: Foo<*>) {
    node.data.get(MyEnum.EnumEntry)
}