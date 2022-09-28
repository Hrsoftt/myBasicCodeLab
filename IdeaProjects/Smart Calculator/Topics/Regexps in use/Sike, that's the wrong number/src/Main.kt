fun main() {
    val number = readln()
    val newNum = number.replace("[a-zA-Z]+".toRegex(), "")
    println(newNum)
}