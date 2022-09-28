fun main() {
    val text = readln().split(" ")
    val regexWithGroups = "(pa)+".toRegex()
    for (i in text) {
        if (i.contains(regexWithGroups)) {
            println(i)
        }
    }
}