fun main() {
    val text = readln()
    val result = text.split("[ADGC]m?".toRegex())
    val b = result.joinToString(" ")
    println(b.split(" "))

}