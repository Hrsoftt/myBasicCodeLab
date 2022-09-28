fun main() {
    val text = readln()
    val regex = ".*Computer.*".toRegex()
    println(regex.matches(text))
}