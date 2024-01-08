// TARGET_BACKEND: JVM_IR

// WITH_STDLIB

import kotlinx.serialization.*

@Serializable(with = PolymorphicSerializer::class)
interface ExplicitlyPolymorphic

fun box(): String {
    val kind = ExplicitlyPolymorphic.serializer().descriptor.kind.toString()
    if (kind != "OPEN") return kind
    return "OK"
}