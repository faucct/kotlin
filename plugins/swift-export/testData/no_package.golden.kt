import kotlin.native.internal.ExportedBridge

@ExportedBridge("root_meaningOfLife")
public fun root_meaningOfLife(): Int {
    val result = meaningOfLife()
    return result
}
