// IGNORE_INLINER: IR
// WITH_STDLIB
// FILE: test.kt

import kotlin.coroutines.intrinsics.*

private suspend inline fun foo() {
    suspendCoroutineUninterceptedOrReturn<Any?> { ucont ->
        Unit
    }
}

private suspend inline fun bar() {
    foo()
}

private suspend inline fun baz() {
    bar()
}

suspend fun box() {
    val a = baz()
}

// EXPECTATIONS JVM_IR_WITH_INLINE_SCOPES
// test.kt:21 box:
// test.kt:22 box: $continuation:kotlin.coroutines.Continuation=TestKt$box$1, $result:java.lang.Object=null
// test.kt:18 box: $continuation:kotlin.coroutines.Continuation=TestKt$box$1, $result:java.lang.Object=null, $i$f$baz\1\22:int=0:int
// test.kt:14 box: $continuation:kotlin.coroutines.Continuation=TestKt$box$1, $result:java.lang.Object=null, $i$f$baz\1\22:int=0:int, $i$f$bar\2\78:int=0:int
// test.kt:8 box: $continuation:kotlin.coroutines.Continuation=TestKt$box$1, $result:java.lang.Object=null, $i$f$baz\1\22:int=0:int, $i$f$bar\2\78:int=0:int, $i$f$foo\3\79:int=0:int
// test.kt:9 box: $continuation:kotlin.coroutines.Continuation=TestKt$box$1, $result:java.lang.Object=null, $i$f$baz\1\22:int=0:int, $i$f$bar\2\78:int=0:int, $i$f$foo\3\79:int=0:int, $i$a$-suspendCoroutineUninterceptedOrReturn-TestKt$foo$2\4\80\3:int=0:int
// EXPECTATIONS ClassicFrontend JVM_IR_WITH_INLINE_SCOPES
// test.kt:10 box: $continuation:kotlin.coroutines.Continuation=TestKt$box$1, $result:java.lang.Object=null, $i$f$baz\1\22:int=0:int, $i$f$bar\2\78:int=0:int, $i$f$foo\3\79:int=0:int, $i$a$-suspendCoroutineUninterceptedOrReturn-TestKt$foo$2\4\80\3:int=0:int
// EXPECTATIONS JVM_IR_WITH_INLINE_SCOPES
// test.kt:8 box: $continuation:kotlin.coroutines.Continuation=TestKt$box$1, $result:java.lang.Object=null, $i$f$baz\1\22:int=0:int, $i$f$bar\2\78:int=0:int, $i$f$foo\3\79:int=0:int
// test.kt:11 box: $continuation:kotlin.coroutines.Continuation=TestKt$box$1, $result:java.lang.Object=null, $i$f$baz\1\22:int=0:int, $i$f$bar\2\78:int=0:int, $i$f$foo\3\79:int=0:int
// test.kt:15 box: $continuation:kotlin.coroutines.Continuation=TestKt$box$1, $result:java.lang.Object=null, $i$f$baz\1\22:int=0:int, $i$f$bar\2\78:int=0:int
// test.kt:19 box: $continuation:kotlin.coroutines.Continuation=TestKt$box$1, $result:java.lang.Object=null, $i$f$baz\1\22:int=0:int
// test.kt:22 box: $continuation:kotlin.coroutines.Continuation=TestKt$box$1, $result:java.lang.Object=null
// test.kt:23 box: $continuation:kotlin.coroutines.Continuation=TestKt$box$1, $result:java.lang.Object=null

// EXPECTATIONS JVM_IR
// test.kt:21 box:
// test.kt:22 box: $continuation:kotlin.coroutines.Continuation=TestKt$box$1, $result:java.lang.Object=null
// test.kt:18 box: $continuation:kotlin.coroutines.Continuation=TestKt$box$1, $result:java.lang.Object=null, $i$f$baz\1:int=0:int
// test.kt:14 box: $continuation:kotlin.coroutines.Continuation=TestKt$box$1, $result:java.lang.Object=null, $i$f$baz\1:int=0:int, $i$f$bar\2:int=0:int
// test.kt:8 box: $continuation:kotlin.coroutines.Continuation=TestKt$box$1, $result:java.lang.Object=null, $i$f$baz\1:int=0:int, $i$f$bar\2:int=0:int, $i$f$foo\3:int=0:int
// test.kt:9 box: $continuation:kotlin.coroutines.Continuation=TestKt$box$1, $result:java.lang.Object=null, $i$f$baz\1:int=0:int, $i$f$bar\2:int=0:int, $i$f$foo\3:int=0:int, $i$a$-suspendCoroutineUninterceptedOrReturn-TestKt$foo$2\4\3:int=0:int
// EXPECTATIONS ClassicFrontend JVM_IR
// test.kt:10 box: $continuation:kotlin.coroutines.Continuation=TestKt$box$1, $result:java.lang.Object=null, $i$f$baz\1:int=0:int, $i$f$bar\2:int=0:int, $i$f$foo\3:int=0:int, $i$a$-suspendCoroutineUninterceptedOrReturn-TestKt$foo$2\4\3:int=0:int
// EXPECTATIONS JVM_IR
// test.kt:8 box: $continuation:kotlin.coroutines.Continuation=TestKt$box$1, $result:java.lang.Object=null, $i$f$baz\1:int=0:int, $i$f$bar\2:int=0:int, $i$f$foo\3:int=0:int
// test.kt:11 box: $continuation:kotlin.coroutines.Continuation=TestKt$box$1, $result:java.lang.Object=null, $i$f$baz\1:int=0:int, $i$f$bar\2:int=0:int, $i$f$foo\3:int=0:int
// test.kt:15 box: $continuation:kotlin.coroutines.Continuation=TestKt$box$1, $result:java.lang.Object=null, $i$f$baz\1:int=0:int, $i$f$bar\2:int=0:int
// test.kt:19 box: $continuation:kotlin.coroutines.Continuation=TestKt$box$1, $result:java.lang.Object=null, $i$f$baz\1:int=0:int
// test.kt:22 box: $continuation:kotlin.coroutines.Continuation=TestKt$box$1, $result:java.lang.Object=null
// test.kt:23 box: $continuation:kotlin.coroutines.Continuation=TestKt$box$1, $result:java.lang.Object=null

// EXPECTATIONS JS_IR
// test.kt:31 doResume:
// test.kt:31 doResume:
// test.kt:22 doResume:
// test.kt:23 doResume: a=Unit
