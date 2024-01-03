// !LANGUAGE: +ContextReceivers

class Ctx

fun Ctx.foo() {}
fun Ctx.context() {}

context(Ctx)
class A {
    fun bar(body: Ctx.() -> Unit) {
        foo()
        body()
    }
}

context(Ctx)
fun foo(body: Ctx.() -> Unit) {
    context()
    body()
}

context(Ctx)
fun bar(context: Ctx.() -> Int) {
    val res: Int = context()
}