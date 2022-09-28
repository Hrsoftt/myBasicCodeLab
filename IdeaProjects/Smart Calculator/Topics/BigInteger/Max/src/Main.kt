import java.math.BigInteger

fun main() {
    val input1 = BigInteger(readln())
    val input2 = BigInteger(readln())

    val addedVal = input1 + input2
    val absolut = (input1 - input2).abs()
    val result = (addedVal + absolut) / BigInteger.TWO
    println(result)
}