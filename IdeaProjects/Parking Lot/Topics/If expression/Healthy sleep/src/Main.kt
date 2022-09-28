fun main() {    
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()
    val c = readLine()!!.toInt()

    println(if (c > b) "Excess" else if (c < a) "Deficiency" else "Normal")
}
