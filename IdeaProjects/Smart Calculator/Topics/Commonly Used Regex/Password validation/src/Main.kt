fun main() {
    val regex = Regex("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?\\d).{8,}$")
    val input = readln()

    if (input.matches(regex)) println("Password saved") else println("Password is too simple")
}