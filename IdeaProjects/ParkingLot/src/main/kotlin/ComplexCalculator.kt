class ComplexCalculator {

    fun main() {


    }
    class calculator {


        fun run (){
            val regex = "[\\d +-]+".toRegex()
            while (true) {
                val input = readln()

                if (input.isEmpty()){
                    continue
                } else if (input == "/exit"){
                    println("Bye!")
                    break
                }else if (input == "/help") {
                    println("The program calculates the sum of numbers")
                    continue
                }else if (input.contains("/")){
                    println("Unknown command")
                }else  {
                    if (regex.matches(input)) {
                        if (input.last() in "+-") println("Invalid expression") else numberCheck(input)
                    }else{
                        println("Invalid expression")
                    }
                }

            }

        }

        fun numberCheck(input: String) {
            var operation = "+"
            var sum = 0
            val line = input.split(" ").toMutableList()
            while (line.isNotEmpty()) {
                var value = line.removeAt(0)

                when {
                    // even multiple of minus signs --> +
                    value.matches(Regex("(--)*")) -> value = "+"
                    // multiple minus signs (can only be odd number!)
                    value.matches(Regex("-*")) -> value = "-"
                    // multiple plus signs
                    value.matches(Regex("\\+*")) -> value = "+"
                }
                if (value in "+-") {
                    operation = value
                } else {
                    try {
                        when (operation) {
                            "+" -> sum += value.toInt()
                            "-" -> sum -= value.toInt()
                        }
                    } catch (e: NumberFormatException) {
                        println("$value is not a valid number!")
                    }
                }

            }
            println(sum)
        }
    }
}