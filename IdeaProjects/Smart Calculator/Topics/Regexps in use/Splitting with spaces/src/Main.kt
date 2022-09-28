fun main() {
    val string = readln()
    val n = readln().toInt()
    val result = string.split("\\s+".toRegex(), n)
    println(result.joinToString("\n"))
}