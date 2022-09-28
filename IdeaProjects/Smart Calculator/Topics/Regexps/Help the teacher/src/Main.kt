fun main() {
    val report = readLine()!!
    val regex = Regex("\\d wrong answer.?")
    println(report.matches(regex))
//    val report = readln().split(" ")
//    val num = 1..9
//    val regex = Regex("wrong answers?")
//    if (report[0].toInt() < 10) {
//        val value = report.toMutableList()
//        value.removeAt(0)
//        println(regex.matches(value.joinToString(" ")))
//    } else {
//        println(false)
//    }


}