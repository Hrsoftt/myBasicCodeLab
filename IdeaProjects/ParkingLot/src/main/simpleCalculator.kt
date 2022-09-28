class simpleCalculator {
    package calculator

    import java.util.*

    class UnknownVariableException : Exception("Unknown variable")
    class UnknownOperatorException : Exception("Unknown operator")

    fun main() {
        Calculator().run()
    }


    class Calculator {
        private val variables = emptyMap<String, Int>().toMutableMap()
        fun run() {
            while (true) {
                val input = readln()
                if (input.isEmpty()) {
                    continue
                } else if (input == "/exit") {
                    println("Bye!")
                    break
                } else if (input == "/help") {
                    println("The program calculates the sum of numbers")
                    continue
                } else if (input.contains("/")) {
                    println("Unknown command")
                } else {
                    processInput(input)
                }
            }
        }

        private fun processInput(input: String) {
            try {
                if (input.contains("=")) {
                    assignVariable(input)
                } else {
                    println(calculate(input))
                }
            } catch (e: UnknownVariableException) {
                println(e.message)
            }

        }


        private fun calculate(input: String): Int {
            val operation = Stack<String>()
            val stack = Stack<Int>()

            val tokens = input.trim().split(" ").toMutableList()
            while (tokens.isNotEmpty()) {
                var token = tokens.removeAt(0)

                token = cleanupRedundantSigns(token)

                if (token in "+-*/") {
                    operation.push(token)
                } else {
                    if (operation.isEmpty()) {
                        stack.push(getValue(token))
                    } else {
                        when (operation.pop()) {
                            "+" -> stack.push(stack.pop() + getValue(token))
                            "-" -> stack.push(stack.pop() - getValue(token))
                            "*" -> stack.push(stack.pop() * getValue(token))
                            "/" -> stack.push(stack.pop() / getValue(token))
                            else -> throw UnknownOperatorException()
                        }
                    }
                }
            }
            return stack.pop()
        }

        private fun cleanupRedundantSigns(token: String): String {
            return when {
                // even multiple of minus signs --> +
                token.matches(Regex("(--)*")) -> "+"
                // multiple minus signs (can only be odd number!)
                token.matches(Regex("-*")) -> "-"
                // multiple plus signs
                token.matches(Regex("\\+*")) -> "+"
                else -> token.trim()
            }
        }

        private fun assignVariable(input: String) {
            val variable = input.substringBefore("=").trim()
            if (!isValidVariableName(variable)) {
                println("Invalid identifier")
                return
            }

            val value = input.substringAfter("=").trim()
            if (!isNumber(value) && !isValidVariableName(value)) {
                println("Invalid identifier")
                return
            }

            variables[variable] = getValue(value)
        }

        private fun isValidVariableName(name: String): Boolean {
            return name.matches("[a-z]*".toRegex())
        }

        private fun isNumber(name: String): Boolean {
            return name.toIntOrNull() != null
        }

        private fun getValue(token: String): Int {
            return token.toIntOrNull() ?: variables[token] ?: throw UnknownVariableException()
        }

    }
}