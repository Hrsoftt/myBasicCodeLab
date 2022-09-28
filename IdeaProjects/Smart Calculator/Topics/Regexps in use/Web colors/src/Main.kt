fun main() {
    val text = readLine()!!
    val regexColors = "#[\\da-fA-F]{6}\\b".toRegex()

    val result = regexColors.findAll(text)
    for (i in result) println(i.value)
}