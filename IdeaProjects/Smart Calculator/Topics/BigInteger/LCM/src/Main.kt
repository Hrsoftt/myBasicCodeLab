import java.math.BigInteger

fun main() {
    val input1 = BigInteger(readln())
    val input2 = BigInteger(readln())
    val lcm = input1 * input2 / input1.gcd(input2)
    println(lcm)
}
