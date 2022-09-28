fun main() {
    val studentsMarks = mutableMapOf<String, Int>()
    while (true) {
        val name = readln()
        if (name == "stop") {
            break
        } else {
            val score = readln().toInt()
            if (!studentsMarks.keys.contains(name)) {
                studentsMarks[name] = score
            }
        }
    }
    println(studentsMarks)

}