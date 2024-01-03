// !LANGUAGE: +ContextReceivers

class Ctx

fun Ctx.foo() {}
fun Ctx.context() {}

context(Ctx)
class A {
    fun bar(body: Ctx.() -> Unit) {
        foo()
        body<!NO_VALUE_FOR_PARAMETER!>()<!>
    }
}

context(Ctx)
fun foo(body: Ctx.() -> Unit) {
    context()
    body<!NO_VALUE_FOR_PARAMETER!>()<!>
}

context(Ctx)
fun bar(context: Ctx.() -> Int) {
    val res: Int = <!TYPE_MISMATCH!>context()<!>
}