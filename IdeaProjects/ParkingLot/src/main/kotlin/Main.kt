import java.io.File
import java.math.BigInteger


//class CustomException1: Exception {
//    constructor() ; super()
//    constructor(message: String?) ; super(message)
//    constructor(message: String?, cause: Throwable?) ; super(message, cause)
//    constructor(cause: Throwable?) ; super(cause)
//}
//
//
//class CustomException2(): Exception {
//    constructor(message: String?) : super(message)
//    constructor(message: String?, cause: Throwable?) : super(message, cause)
//    constructor(cause: Throwable?) : super(cause)
//}
//
//

class MyCustomException : Exception {
    constructor() : super()  // No parameters
    constructor(message: String?) : super(message)  // Only the String parameter
    constructor(message: String?, cause: Throwable?) : super(message, cause) // Both parameters
    constructor(cause: Throwable?) : super(cause)  // Only the exception parameter
}

class CustomException3 : Exception {
    constructor() : super()
    constructor(cause: Throwable?) : super(cause)
}

//
//
//class CustomException4: Exception {
//    constructor() : super()
//    constructor() : super(message: String?)
//    constructor() : super(cause: Throwable?)
class Cat(val name: String, val age: Int) {
    val enoughCat = false // Of course, it's a false, there are never enough cats!

    init {
        check(!enoughCat) { "You cannot add a new cat" } // IllegalStateException
        require(age >= 0) { "Invalid age: $age" }        // IllegalArgumentException
    }
}
//}

fun fibonacci() {
    var prev = 0
    var current = 1
    for (i in 0..24) {
        val swap = prev
        prev = current
        current += swap
        println(current)
    }
}

fun modifyString(initialString: String): String {
    var modifiedString = initialString

    modifiedString = modifiedString.removeRange(2, 10) // 1
    if (modifiedString.contains(" ")) // 2
        modifiedString += "ABC"
    modifiedString = modifiedString.substringAfter(" ") + modifiedString.substringBefore(" ") // 3
    if (modifiedString.contains("a")) // 4
        modifiedString.plus("1248")
    modifiedString = modifiedString.replaceFirst(" ", "$") // 5
    if (modifiedString.length < 15) // 6
        modifiedString = modifiedString.reversed()
    modifiedString += "18B20" // 7
    modifiedString = modifiedString.substringAfter("1") + modifiedString.substringBefore("5") // 8
    modifiedString.dropLast(4) // 9

    return modifiedString
}

fun isPrime(number: Int): Boolean {
    for (i in 2..(number / 2)) {
        if (number % i != 0)
            continue
        else
            return false
    }
    return true
}

object Test {
    init {
        println("sum")
    }

    var a: Int = 9
    var b: Int = 1

    fun makeMe12(): Int {
        val tot = a + b
        return tot
    }
}

lateinit var EVERYONE: Array<String>

//private lateinit var CRITERIA: Criteria
private val EVERYONE_MAP = mutableMapOf<String, MutableList<Int>>()
private fun initialize(fileName: String) {
    val muteLines = mutableListOf<String>()
    var count = 0

    File(fileName).forEachLine {
        muteLines.add(it)

        val split = splitToArray(it)
        for (word in muteLines) {
            if (EVERYONE_MAP.containsKey(word)) {
                EVERYONE_MAP[word]?.add(count)
            } else EVERYONE_MAP[word] = mutableListOf(count)
        }
        count++
    }
    println(EVERYONE_MAP)
    println(muteLines)
    EVERYONE = muteLines.toTypedArray()
}

fun splitToArray(it: String) {
    val a = mutableListOf<String>()
    println(it.split(" "))
//    for (i in it){
//        println(i)
//    }
}

fun index(people: List<String>): Map<String, Set<Int>> {
    val invertedIndex = mutableMapOf<String, MutableSet<Int>>()
    people.forEachIndexed { index, line ->
        line.split(" ").forEach { word ->
            invertedIndex.getOrPut(word) { mutableSetOf() }.add(index)
        }
    }

    return invertedIndex
}

fun buildInvertedIndex(lines: List<String>): Map<String, Set<Int>> {
    val index = mutableMapOf<String, MutableSet<Int>>()
    for (line in lines.withIndex()) {
        val parts = line.value.split(" ")
        for (part in parts) {
            val list = index.getOrDefault(part, mutableSetOf())
            list.add(line.index)
            index[part] = list
        }
    }
    return index
}

fun plan(people: List<String>, searchName: String, strategy: String) {
    val (match, nonMatch) = people.partition { it.contains(searchName, true) }
    when (strategy) {
        "ALL" -> {
            println(match.joinToString("\n"))
        }
        "ANY" -> {
            println(match.joinToString("\n"))
        }
        "NONE" -> {
            println(nonMatch.joinToString("\n"))
        }
    }
//    if (match.isNotEmpty()) {
//        println("${match.size} People found:")
//        println(match.joinToString("\n"))
//    } else {
//        println("No matching people found.")
//    }
}

fun findPerson(people: List<String>, index: Map<String, Set<Int>>) {
    val strategy = getStrategy()

    println("Enter a name or email to search all suitable people.")
    val queryParts = readLine()!!.split(" ")

    val matchesInIndex = when (strategy) {
        "ALL" -> {
            queryParts.map { getFromIndex(index, it) }.reduce { acc, set -> acc.intersect(set).toMutableSet() }
        }
        "ANY" -> {
            queryParts.map { getFromIndex(index, it) }.reduce { acc, set -> acc.union(set).toMutableSet() }
        }
        "NONE" -> {
            var allLines = people.indices.toMutableSet()
            for (query in queryParts) {
                allLines = allLines.minus(getFromIndex(index, query)).toMutableSet()
            }
            allLines
        }
        else -> emptySet()
    }

    if (matchesInIndex.isNotEmpty()) {
        matchesInIndex.forEach { println(people[it]) }
    } else {
        println("No matching people found.")
    }
}

fun getFromIndex(index: Map<String, Set<Int>>, query: String): Set<Int> {
    return index[query] ?: emptySet()
}

fun getStrategy(): String {
    while (true) {
        println("Select a matching strategy: ALL, ANY, NONE")

        val strategy = readLine()!!
        if (strategy in listOf("ALL", "ANY", "NONE")) {
            return strategy
        }
    }
}

fun enqueue(element: Int) {
    val array = arrayOf(5)
}

fun main() {
    val a = MutableList(readln().toInt()) { readln().toInt() }
    val m = readln().toInt()
    if (a.contains(m)) println("YES") else println("NO")

//    a.add(0, a.last()).also { a.removeAt(a.lastIndex) }
//    println(a.joinToString(" "))

//    println(a.lastIndex)
//    val regexWithGroups = """(ho)+""".toRegex()
//    val text = "ho hoho hohoho"
//
//    val resultWithGroups = regexWithGroups.findAll(text)
//    for (res in resultWithGroups) println(res.value)

//    function enqueue(int element):
//    if (size(q) != maximum_size) then
//    queue[tail] = element
//    tail = (tail + 1) % maximum_size


//    val read = readln()
//    println(read.contains("/"))
//    val regex = "[\\d +-]+".toRegex()
//    println(regex.matches(read))

//    val withDigits = "The first test flight of Falcon 9 was on June 4, 2010, " +
//            "from Cape Canaveral, Florida, and the first resupply mission " +
//            "to the ISS was made on October 7, 2012."
//    val processedString = withDigits.replace("\\d+".toRegex(), "\\S")
//    println(processedString)


//    fun String.replace(oldValue: String, newValue: String, ignoreCase: Boolean = false): String

//    fun CharSequence.split(regex: Regex, limit): List
//
//    fun String.find(input: CharSequence, startIndex: Int = 0): String
//
//    fun String.replace(oldValue: String, newValue: String): String
//
//    fun CharSequence.split(regex: Regex, limit: Int = 0): List {
//
//    }
//
//    fun String.find(input: CharSequence, startIndex: Int = 0): MatchResult?

//    val regex = """\d{4}-\d{2}-\d{2}""".toRegex() // date template in format YYYY-MM-DD
//    val matchResult =
//        regex.findAll("Harry was born 1980-07-31 in the Godric's Hollow."
//                + "In 1997-12-24, on Christmas Eve, he returned there"
//                + "for the legendary Gryffindor sword")
//    for (matches in matchResult) println(matches.value)

//
//    val regex = """[+]?[(]?[0-9]{1,4}[)]?[-0-9]*""".toRegex() // phone number template
//    val matchResult = regex.find("Her phone number is +1-234-567-89-01. You can also call the second one: +1-111-568-01-01")!!
//    print(matchResult.value) // +1-234-567-89-01
//
//    val number = "This   is a      text with   many     spaces"
//    val brackets = "+1-(213)-345-6789"
//// splitting all substrings in number with brackets
//    val splitBrackets = brackets.split("(-\\(|\\)-|-)".toRegex(), ) // {"+1", "213", "345", "6789"}
//
//// splitting only two substring
//    val splitFirstBrackets = number.split("\\s+".toRegex(), 0) // {"+1", "213-345-6789"}
//    println(splitFirstBrackets.joinToString("\n"))
//// splitting all substrings in number without brackets
//    val splitNumber = number.split("(-\\(|\\)-|-)".toRegex()) // {"+1", "213", "345", "6789"}
//

//    val regex = "(-\\(|\\)-|-)".toRegex()
//
//    val johnRegex = "[0-9a-f]{8}-[0-9a-f]{4}-4[0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}".toRegex() // it matches all strings containing the substring "John"
//
//    val textWithJohn = "1c1a3de4-c711-4e9c-bed2-e75fd69ce920"
//    println(johnRegex.matches(textWithJohn))
//    1c1a3de4-c711-4e9c-bed2-e75fd69ce920
//
//    ad9e03f0-4bd4-46db-k79e-94ca17d4b74f
//
//            f66024c3_50f8_442e_9387_28746581f472
//
//    92ae7a-94f-40c-a22-de4b42dd13
//
//    f087d9fc-xyz3-4a3f-93e0-bdb8d9b68268
//    val regex = "a+b*b{2}c".toRegex() // four digits
//
//    println(regex.matches(""))

//    bbbbbbbc
//
//    abbc
//
//    abc
//
//    bbc

//    val johnRegex = ".*John.*".toRegex() // it matches all strings containing the substring "John"
//
//    val textWithJohn = "My friend John is a computer programmer"
//
//    johnRegex.matches(textWithJohn) // true
//
//    val john = "John"
//
//    johnRegex.matches(john) // true
//
//    val textWithoutJohn = "My friend is a computer programmer"
//
//    johnRegex.matches(textWithoutJohn) // false
//
//    val regex = "A[0-3]*".toRegex()
//
//    println(regex.matches("AAA")) // true because the pattern matches zero or more occurrences
//    println(regex.matches("A444")) // true
//    println(regex.matches("A111222333")) // true

//    val regex = Regex(".?cat") // creating the "cat." regex
//
//    val stringCat = "cat."
//    val stringEmotionalCat = "cat!"
//    val stringCatWithSpace = "bcat"
//    val stringCatN = "cat\n"
//
//    println(regex.matches(stringCat))   // true
//    println(regex.matches(stringEmotionalCat))   // true
//    println(regex.matches(stringCatWithSpace))  // true
//    println(regex.matches(stringCatN))  //false
//    print(!readln().matches(Regex("\\d{2}.+")))
//    var input = ""
//    while (true) {
//        input = readln()
//        var result = 0
//        if (input.isEmpty()) continue
//        else if (input == "/exit") {
//            print("Bye!")
//            break
//        } else if (input == "/help") {
//            println("The program calculates the sum and sub of numbers")
//            continue
//        } else if (input.split(" ").size == 1) {
//            println(input.toInt())
//            continue
//        }
//        val list = input.split("\\s+".toRegex()).toMutableList()
//        result += list[0].toInt()
//        resultLoop@ for (i in 1 until list.size) {
//            if ("+" in list[i]) result += list[i + 1].toInt()
//            else if ("-" in list[i]) {
//                if (list[i].length % 2 == 0) result += list[i + 1].toInt()
//                else result -= list[i + 1].toInt()
//            }
//        }
//        println(result)
//    }
}

//fun findPerson(people: List<String>, index: Map<String, List<Int>>) {
//    println("Select a matching strategy: ALL, ANY, NONE")
//    val  strategy = readln()
//    println("Enter a name or email to search all matching people.")
//    val query = readln()
//    plan(people,query,strategy)

//    when (strategy){
//        "ALL" ->{
//            if (index.containsKey(query)) {
//                val listOfMatches = index[query]
//                listOfMatches?.forEach { println(people[it]) }
//            } else {
//                println("No matching people found.")
//            }
//        }
//        "ANY" -> {
//            if (index.containsKey(query)) {
//                val listOfMatches = index[query]
//                listOfMatches?.forEach { println(people[it]) }
//            } else {
//                println("No matching people found.")
//            }
//        }
//        "NONE" -> {
//            if (!index.containsKey(query)) {
//                val listOfMatches = index[query]
//                listOfMatches?.forEach { println(people[it]) }
//            } else {
//                println("No matching people found.")
//            }
//        }
//    }

//    if (index.containsKey(query)) {
//        val listOfMatches = index[query]
//        listOfMatches?.forEach { println(people[it]) }
//    } else {
//        println("No matching people found.")
//    }
//    println("Enter a name or email to search all matching people.")
//    val searchName = readln()
//    val (match, nonMatch) = people.partition { it.contains(searchName, true) }
//    if (match.isNotEmpty()) {
//        println("${match.size} People found:")
//        println(match.joinToString("\n"))
//    } else {
//        println("No matching people found.")
//    }
//}

//fun main() {
//    val file = File("src/myFile.txt").readLines()
//    val name = readln().split(" ")
//    val whip = name.map { getFromIndex(index(file), it) }.reduce { acc, set -> acc.intersect(set).toMutableSet() }
//    println(whip)
//    whip.forEach { file[it] }
//    findPerson(file,index(file))

//val (found, not) = file.partition { it.contains("Erick", true)}
// initialize("src/myFile.txt")
//    println(index(file))
//    println("========================================================")
//    println(buildInvertedIndex(file))
//    file.forEachIndexed { index, line ->
//        println("index: $index, line: $line")
//    }


//println(file.joinToString("\n"))
//    val result: Int
//
//    result = Test.makeMe12()
//    println("result = $result")
//    val array1 = arrayOf(8, 19, 12, 7, 6, 5)
//    val num =
//        "6 3 5 3 4 6 0 8 7 3 7 2 1 5 1 3 5 5 8 6 2 4 8 1 9 3 0 6 4 2 2 2 4 1 3 8 9 7 2 7 8 4 0 6 7 7 9 2 6 8 0 6 2 2 9 6 3 4 7 2 9 0 4 8 2 4 6 7 3 3 3 6 0 3 7 2 1 4 8 1 1 0 3 8 3 9 4 9 2 1 3 1 1 0 2 6 9 7 7 4"
//    val list = num.split(" ").map { it.toInt() }.toMutableList()
//    val array2 = arrayOf(2, 3, 3, 7, 6, 4, 0, 2, 9, 6)
//    var steps = 0
//
//    for (v1 in list) {
//        if (v1 == 0) {
//            steps++
//        }
//    }
//    println(steps)


//    val b = listOf(8, 19, 12, 7, 6, 5)
//    val a = MutableList<List<Int>>(7) { listOf() }.apply {
//        this[0] = listOf(19, 6, 5)
//        this[1] = listOf(19, 6, 5, 10)
//        this[2] = listOf(19, 6, 3, 5)
//        this[3] = listOf(6, 9, 5, 19)
//        this[4] = listOf(9, 19, 5, 6)
//        this[5] = listOf(5, 6, 2, 19, 1)
//        this[6] = listOf(6, 19, 1, 2, 5)
//    }
//    val result = mutableListOf<Int>()
//    for (j in a.indices) {
//        var res = 0
//        for (i in b) {
//            for (k in a[j]) {
//                res++
//                if (i == k) break
//            }
//        }
//        result.add(res)
//    }
//    println(a.joinToString(", "))


////import kotlin.math.*
////import kotlin.random.Random
//import java.io.*
//import java.util.*
//
//import java.awt.Color
//import java.awt.image.BufferedImage
//import java.io.File
//import javax.imageio.ImageIO
//
//import java.security.MessageDigest
////import javax.xml.bind.DatatypeConverter
//
////object Utils {
////
////    fun sha1(input: String) = hashString("SHA-1", input)
////    fun md5(input: String) = hashString("MD5", input)
////
////    private fun hashString(type: String, input: String): String {
////        val bytes = MessageDigest
////            .getInstance(type)
////            .digest(input.toByteArray())
////        return
////    }
////}
//
//fun saveImage(image: BufferedImage, imageFile: File) {
//    ImageIO.write(image, "png", imageFile)
//}
//
//fun bill(priceList: Map<String, Int>, shoppingList: MutableList<String>): Int {
//    var price = 0
//    for (i in shoppingList) {
//        price += if (priceList.containsKey(i)) {
//            priceList[i]!!
//        } else {
//            0
//        }
//    }
//    return price
//}
//
////fun info(map: Map<String, String>) {
////    for (i in map) {
////        println(i.key + (" ".repeat(12 - i.key.length)) + i.value)
////    }
////}
//
//fun ByteArray.toHex(): String {
//    return joinToString("") { "%02x".format(it) }
//}
//val HEX_CHARS = "0123456789ABCDEF".toCharArray()
//
//fun printHexBinary(data: ByteArray): String {
//    val r = StringBuilder(data.size * 2)
//    data.forEach { b ->
//        val i = b.toInt()
//        r.append(HEX_CHARS[i shr 4 and 0xF])
//        r.append(HEX_CHARS[i and 0xF])
//    }
//    return r.toString()
//}
//fun hash(string: String): String {
//    val bytes = string.toString().toByteArray()
//    val md = MessageDigest.getInstance("SHA-256")
//    val digest = md.digest(bytes)
//    return digest.fold("") { str, it -> str + "%02x".format(it) }
//}
//
//fun main(args: Array<String>) {
//
////    val hash = "Added several lines of code to the file1.txt".toByteArray()
////    println(printHexBinary(hash))
//    println(hash("hello"))
////    println(hash("hello"))
//
//    val text = "Book"
//    val myFile = File("src/myFile.txt")
//    println(hash(myFile.readText()))
////    myFile.appendText(text)
////    myFile.appendText("hello")
////    if (myFile.length() == 0L){
////        println("empty")
////    }
////    println(myFile.readText())
//
////    val outDir = File("Projects")
////    println(outDir.exists())    // false
////    outDir.mkdir()
////    val bb = outDir.resolve("Programming")
////    bb.mkdir()
////    println(bb)
////    println(bb.isDirectory)
////    outDir.resolve("project1")
////    println(outDir)
////    println(outDir.exists())    // true
////    println(outDir.isDirectory)
//
//
////    val mainDirectory = File("/Projects/Programming")
////    mainDirectory.mkdir()
////    val reportFile = mainDirectory.resolve("Report.pdf")
////    reportFile.createNewFile()
////    val labDirectory = mainDirectory.resolve("Project1")
////    labDirectory.mkdir()
////    val mainDirectory = File("/Projects")
////    mainDirectory.mkdir()
////    val labDirectory = mainDirectory.resolve("Programming")
////    labDirectory.mkdir()
////    val reportFile = labDirectory.resolve("Report.pdf")
////    reportFile.createNewFile()
////    val project1 = labDirectory.resolve("Project1")
////    project1.mkdir()
//////    val files = mainDirectory.walkTopDown()
////    // do not touch the lines below
////    files.forEach {
////        if (it.path == "/Projects/Programming" && it.isDirectory) {
////            print("true")
////        } else if (it.path == "/Projects/Programming/Project1" && it.isDirectory) {
////            print("true")
////        } else if (it.path == "/Projects/Programming/Report.pdf" && it.isFile) {
////            print("true")
////        } else {
////            print("false")
////        }
////    }
//}
////    val rootDir = File("C:/Users/hp/Downloads/basedir (1)/basedir")
////    rootDir.walkTopDown()
////        .forEach {
////            if (it.isDirectory){
////                if (it.listFiles().isEmpty()){
////                    print(it.name)
////                }
////            }
////        }
//
////    val file  = File("C:/Users/hp/Downloads/basedir/basedir")
//////    val maxLength = file.walkBottomUp().forEach { if (it.path.length == 147) it.name }
////    var longest = file.walkBottomUp().maxByOrNull { it.path.split("/").size }
////    println(longest)
//
//
////    val map = mapOf(
////        "config" to "Get and set a username.",
////        "add" to "Add a file to the index.",
////        "log" to "Show commit logs.",
////        "commit" to "Save changes.",
////        "checkout" to "Restore a file."
////    )
////    if (args.isNotEmpty()) {
////        info(map)
////    } else {
////        when (args[0]) {
////            "config" -> println(map[args[0]])
////            "add" -> println(map[args[0]])
////            "log" -> println(map[args[0]])
////            "commit" -> println(map[args[0]])
////            "checkout" -> println(map[args[0]])
////            "--help", "" -> {
////                println("These are SVCS commands:")
////                info(map)
////            }
////            else -> {
////                println("'${args[0]}' is not a SVCS command.")
////            }
////
////        }
////    }
////    println(map)
//
////var counte = 6
////fun main(args: Int) {
////    print(args)
////}
////fun main() {
////    if(counte == 0) return
////    counte -= 1
////    main(counte)
////    main()
////val graphics = image.createGraphics()
////    graphics.drawString("Playing with images", 80, 80)
////
////    graphics.color = Color.ORANGE
////
////    graphics.drawArc(200, 200, 100, 250, 45, 90)
//
////    fun printARGB() {
////        try {
////            val (a, r, g, b) = readln().split(" ").map { it.toInt() }
////            println("$a\n$r\n$g\n$b")
////            val color = Color(r, g, b, a)
////            println(color.rgb.toUInt())
////        } catch (e: java.lang.IllegalArgumentException) {
////            println("Invalid input")
////        }
////    }
////    printARGB()
//
//
////    val height: Int = 800
////    val width: Int = 600
////
////    val image = BufferedImage(width, height, BufferedImage.TYPE_INT_RGB)
////    val imageFile = File("src/myFirstImage.png")
////
////    saveImage(image, imageFile)
//
//
////    val imageFile = File("src/myFirstImage.png")
////
////    val image: BufferedImage = ImageIO.read(imageFile)
////
////    val graphics = image.createGraphics()
////
////    graphics.color = Color.BLUE
////    graphics.drawPolygon(intArrayOf(10, 20, 30), intArrayOf(100, 20, 100), 3)
////    saveImage(image, imageFile)
//
////    val image = BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB)
////    val imageFile = File("src/myFirstImage2.png")
////    val graphics = image.createGraphics()
////    graphics.color = Color.RED
////    graphics.drawString("Hello, images!", 50, 50)
////    graphics.color = Color.GREEN
////    graphics.drawString("Hello, images!", 51, 51)
////    graphics.color = Color.BLUE
////    graphics.drawString("Hello, images!", 52, 52)
//
////    a green one, at position (51, 51)
////    a blue one, at position (52, 52)
//
////    graphics.color = Color.GREEN
////    graphics.drawLine(200, 0, 0, 200)
////    saveImage(image, imageFile)
//
//
////        Write a function that returns a buffered image of size 200x200.
////
////    The image should have TYPE_INT_RGB color components, and it should contain two lines drawn in this exact order:
////
////    a red one, starting at position (0, 0) and ending at position (200, 200);
////    a green one, starting at position (200, 0) and ending at position (0, 200).
////    The return value of the function should be a BufferedImage with the following contents:
////    // Create a new BufferedImage instance with image size 256 X 256
////    // The first parameter is the image width, while the second is the image height
////    // The third parameter should be BufferedImage.TYPE_INT_ARGB for a 32-bit image
////    // or BufferedImage.TYPE_INT_RGB for a 24-bit image
////    val myImage: BufferedImage = BufferedImage(256, 256, BufferedImage.TYPE_INT_ARGB)
////
////    for (i in 0 until myImage.width) {
////        for (j in 0 until myImage.height) {
////            myImage.setRGB(i, j, Color(0, 255, 0, j).rgb)  // Green color with alpha channel value equal to j
////        }
////    }
////    val outputFile = File("alpha.png")         // Output the image
////    ImageIO.write(myImage, "png", outputFile)  // Create an image using the BufferedImage
////
////
////    // Get alpha value from Color instance
////    val c = Color(255, 0, 0, 127)  // Create a color instance, with alpha equal to 127
////    val alpha = c.alpha            // Get alpha channel value
//
//// Create Color instance for pixel at (x, y) position, alpha channel is also set
////    val color = Color(bI.getRGB(x, y), true)  // where bI is a BufferedImage instance
//
//
////fun main() {
////    val inputFile = File("24bit.png")  // Create a file instance in order to read the "24bit.png" image file
////
////    // Create a BufferedImage instance from the 24-bit image file data
////    val myImage: BufferedImage = ImageIO.read(inputFile)
////
////    // myImage.width is the image width
////    // myImage.height is the image height
////    for (x in 0 until myImage.width) {               // For every column.
////        for (y in 0 until myImage.height) {          // For every row
////            val color = Color(myImage.getRGB(x, y))  // Read color from the (x, y) position
////
////            val g = color.green              // Access the Green color value
////            val b = color.blue               // Access the Blue color value
////            // Use color.red in case the Red color is needed
////
////            val colorNew = Color(255, g, b)  // Create a new Color instance with the red value equal to 255
////            myImage.setRGB(x, y, colorNew.rgb)  // Set the new color at the (x, y) position
////        }
////    }
////    val outputFileJpg = File("newImageFile.jpg")  // Output the file
////    ImageIO.write(myImage, "jpg", outputFileJpg)  // Create an image using the BufferedImage instance data
////}
//
////fun main() {
//////    var sum = 1
//////    val fileName = "src/text.txt"
//////    val line = File(fileName)
//////    for (i in line){
//////        sum++
//////    }
//////    println(sum)sum
////
////    val text = readln()
////    val myFile = File("MyFile.txt")
////    myFile.appendText("$text$text")
//
////    val myFile = File("MyCases.txt")
////    myFile.appendText("\nThe Sign of the Four")
//
////    val fileName = "src/new.txt"
////    val linesLength = File(fileName)
////    val lines = File(fileName)
////    lines.writeText("\"Just \nlook\n at\n that!")
////    val fileName = "src/myFile.txt"
////File(fileName).appendText(", Donald E. Knuth said.")
//
////val arrayOfBytes = byteArrayOf(1, 2, 3) // create an array
//// another way:
//// val arrayOfBytes = mutableListOf<Byte>(1, 2, 3).toByteArray()
//
//// File(fileName).writeBytes(arrayOfBytes)
////    val arrayOfBytes = byteArrayOf(0, 1, 2)
////    File(fileName).appendBytes(arrayOfBytes)
//
//
////    val file = "src/main/kotlin/text.txt"
////    var count = 0
////    File(file).readText().split(" ").toMutableList().forEach { _ -> count += 1 }
////    print(count)
////}
//
////    var inputArray: Array<Array<String>> = arrayOf()
////    val n = readLine()!!.toInt()
////    for (i in 0 until n) {
////        val strings = readLine()!!.split(' ').toTypedArray()
////        inputArray += strings
////    }
////    println(inputArray[2].joinToString())
////    val empty2DInt = arrayOf<Array<Int>>()
////
////    val firstArray = readLine()!!.split(' ').map { it }.toTypedArray()
////    val secondArray = readLine()!!.split(' ').map { it }.toTypedArray()
////    val both = firstArray + secondArray
////    println(both.joinToString())
//
////    val long = longArrayOf(100_000_000_001, 100_000_000_002, 100_000_000_003)
////    val numbers = IntArray(100)
////    numbers[0] = 1
////    numbers[9] = 10
////    numbers[99] = 100
////    println(numbers[-1])
////    println(numbers.joinToString())
////    val a = getScoringFunction(true)
////    println(a(9.5))
////    println(applyAndSum(3, 5, ::getGradeWithPenalty))
////    val increment = placeArgument(1, ::sum)
////    val triple = placeArgument(3, mul2)
////    println(increment(40))
////    println(triple(10))
////    val lambda: (Long, Long) -> Long = { a: Long, b: Long -> (a..b).reduce { a, b -> a * b } }
////    println(lambda(1,2))
//
////    val a = 1
////    val b = 2
////    val c = 3
////    val lambda: (Int, Int) -> Int = { a: Int, b: Int -> if (a > b) a else b }
////    println(lambda(2, 3))
////    val numbers = readln().split(" ").map { it.toInt() }.toTypedArray()
////    println(numbers.joinToString())
//
////    val numbers = IntArray(5) { readln().toInt() } // on each line single numbers from 1 to 5
////    println(numbers.joinToString())
//
////fun first(value: Int, func: (Int) -> Int): Int = func(value)
////fun second(func: (Int) -> Int, value: Int): Int = func(value)
////
////var counter: () -> Int = { -42 }
////
////fun reinitializeCounter(): Int {
////    var value = 0
////    counter = { ++value }
////    return value
////}
////
////fun sum(a: Int, b: Int): Int = a + b
////val mul2 = { a: Int, b: Int -> a * b }
////
////fun placeArgument(value: Int, f: (Int, Int) -> Int): (Int) -> Int {
////    return { i -> f(value, i) }
////}
////
////val originalText = "I don't know... what to say..."
////val textWithoutDots = originalText.filter { it != '.' }
////
////fun composition(value: Int, y: (Int) -> Int, g: (Int) -> Int): Int {
////    return y(g(value))
////}
////
////fun square(value: Int, context: Any, continuation: (Int, Any) -> Unit) {
////    val square = value * value
////    continuation(square, context)
////}
////
////
////fun identity(x: Int): Int = x
////fun half(x: Int): Int = x / 2
////fun zero(x: Int): Int = 0
////
////fun generate(functionName: String): (Int) -> Int {
////    return when (functionName) {
////        "identity" -> ::identity
////        "half" -> ::half
////        "zero" -> ::zero
////        else -> ::zero
////    }
////}
////
////fun applyAndSum(a: Int, b: Int, transformation: (Int) -> Int): Int {
////    return transformation(a) + transformation(b)
////}
////
////fun getRealGrade(x: Double) = x
////fun getGradeWithPenalty(x: Int) = x - 1
////
////fun getScoringFunction(isCheater: Boolean): (Double) -> Double {
////    if (isCheater) {
////        // return ::getGradeWithPenalty
////    }
////
////    return ::getRealGrade
////}
//
//
////class Size(val width: Int, val height: Int) {
////    var area: Int = width * height
////
////    init {
////        println("Object with area equal to $area is created")
////    }
//
////   constructor(width: Int, height: Int, outerSize: Size) : this(width, height) {
////        outerSize.area -= this.area
////        println("Updated outer object's area is equal to ${outerSize.area}")
////   }
////}
//
//
////class EspressoMachine {
////    val costPerServing: Float
////
////    constructor(coffeeCapsulesCount: Int, totalCost: Float) {
////        this.costPerServing = totalCost / coffeeCapsulesCount
////    }
////
////    constructor(coffeeBeansWeight: Float, totalCost: Float) {
////        val numOfServings = coffeeBeansWeight / 10
////        this.costPerServing = totalCost / numOfServings
////    }
////}
//
////class Fabric(var color: String) {
////    var pattern: String = "none"
////    var patternColor: String = "none"
////
////    init {
////        println("$color fabric is created")
////    }
////
////    constructor(color: String, pattern: String, patternColor: String) : this(color) {
////        this.pattern = pattern
////        this.patternColor = patternColor
////        println("$patternColor $pattern pattern is printed on the fabric")
////    }
////}
//
////Write the class IceCreamOrder that has one Int property: price. The class must have two secondary constructors.
////
////The first one takes one Int argument: popsicles, which signifies the number of popsicles the customer wants. The price is calculated as 7 currency units per popsicle.
////
////The second constructor takes two Int arguments: scoops and toppings, which signifies the number of ice cream scoops and the number
////of different toppings that the customer wants in the order. The price is calculated as 5 currency units per scoop plus 2 currency units per topping.
////
////Note, code style checker may prompt you to use a data class. This is a convenient way to create a class with some basic functionality and we will discuss it later.
////Until then, try to practice using the secondary constructor!
//
////class IceCreamOrder {
////    val price: Int
////
////    constructor(popsicles: Int) {
////        price = popsicles * 7
////    }
////
////    constructor(scoop: Int, toppings: Int) {
////        price = scoop * 5 + toppings * 2
////    }
////}
//
////class Client {
////    var name = "Unknown"
////    var age = 10
////        set(value) {
////            field = if (value < 0) {
////                println("Age cannot be negative. Set to $defaultAge")
////                defaultAge
////            } else
////                value
////        }
////    val defaultAge = 18
////}
//
//
////class Example(val hand: MutableList<String>)
////fun main() {
////    val scanner = Scanner(File("book.txt"))
////    var count = 0;
////    while (scanner.hasNext()) {
////        scanner.use {
////            println(scanner.nextLine())
////            count++
////        }
////    }
////    println(count)
////}
//
////fun main() {
////
////    fun doTask(): File {
////        val scanner = Scanner(System.`in`)
////        val name = scanner.next();
////        var writer = FileWriter(name);
////        writer.use {
////            writer.write("i've done it!")
////        }
////        return File(name);
////    }
////
////
////    var reader = FileReader("somefile.txt")
////    val text = reader.readText()
////    reader.close()
//
////    val element = 1 // the element we care about
////    val words = listOf("a", "abc", "ab", "def", "abcd")
////    val byLength = words.groupBy { it.length }
////    println(byLength[3])
//
////    val onesInData = data.count { it == element}
//
////    val value = mutableListOf<String>()
////    val secVAl = mutableListOf<String>()
////    val list = listOf("oe", "ae", "pe", "ba", "wr", "bd", "aa")
////    var max = mutableListOf<String>()
////    list
////        .groupBy { it.last() }
////        .forEach {
////
////            if (it.value.size >= 3) {
////                value.addAll(it.value)
////            } else if (it.value.size == 2) {
////                secVAl.addAll(it.value)
////            } else {
////                max.addAll(it.value)
////            }
////        }
////    println(value)
////    println(secVAl)
////    println(max)
////    val fib = mutableListOf(0, 1, 1, 2, 3, 5, 8) // array with the name fib
////    for( i in 0 until fib.size){
////        print(fib[i])
////    }
////    val a = mutableListOf(7,1,9,6,10,5,8,2,3,4)
////
////    fun po(a: MutableList<Int>,  t: Int) {
////        for(j in 0 until t) {
////            val x = a[0]
////            for(i in 0 until  a.size - 1) {
////                a[i] = a[i + 1]
////            }
////            a[a.size - 1] = x
////        }
////        for(i in 0 until  a.size) {
////            if(i == a.size - 1) print(a[i]) else print("${a[i]}, ")
////        }
////    }
////    po(a, 5)
//
//
////function po(a, t):
////
////for j in [1, t]:
////x = a[1]
////for i in [1, len(a)-1]:
////a[i] = a[i+1]
////a[len(a)] = x
////
////for i in [1, n]:
////if i == n then
////print(a[i])
////else:
////print (a[i], ", ")
//
////    fun jedi(x:Int, p:Int, t:Int){
////        val a = mutableListOf<Int>()
////        a.add(x)
////
////        for(i in 2.. t){
////            a[i] = a[i - 1] * x
////        }
////        for(i in p.. t){
////            if(i == t) print(a[i]) else print("${a[i]}, ")
////        }
////
////    }
////    jedi(2, 3, 6)
//
////    val newNUm=num.filterValues { it > 2 }
////    println(num.size)
//////    for (i in list){list
////
////
////
////        if (i.endsWith(i.last())){
////            value.add(i)
////        }
//////        if (i.contains(i.last())){
//////            value.add(i)
//////        }
////    }
////    println(value)
////println(list.groupingBy { it.last() }.eachCount().filter { it.value > 1 })
////    println(list.any { it. })
////
////    list.forEach{it.last()}
////    val cardOn = listOf("eg","bf")
////    val a = mutableListOf("ad","cd","ef","qd")
////    val sameSuit = mutableListOf<String>()
////    val sameRank = mutableListOf<String>()
////    var value = ""
////    for (i in a){
////        a.remove(i)
////        for (j in a){
////            if (i.last() == j.last()){
////                sameSuit.add(i)
////                value = sameSuit.random()
////            }else if (i.first() == j.first()){
////                sameRank.add(i)
////                value = sameRank.random()
////            }
////            a.add(i)
////        }
////    }
////    println(value)
////    var deck = mutableListOf("a", "b", "c", "d", "e", "f", "g", "h", "i")
////    val testClass = Example(deck.subList(0, 6))
////    deck = deck.filter { it !in deck.subList(0,6) }.toMutableList()
////    println(deck)
////    println(testClass.hand)
////    deck.mapIndexed { index, card -> "${index + 1})$card" }.joinToString(" ")
//// For loop
//
//
////fun main() {
////    val smartOne = Smartphone("Ericsong")
////    smartOne.price = -24
////    val smartTwo = Smartphone("iNokhe")
////    print(smartTwo.price - smartOne.price)
////}
////
////class Smartphone(val name: String) {
////    var price: Int = -5
////        get() = name.length - field
////}
//
//
////    val outerObject = Size(5, 8)
////    val innerObject = Size(2, 3, outerObject)
//
//
////data class Box(val height: Int, val length: Int, val width: Int)
//
////class Cat(val name: String) {
////    inner class Bow(val color: String) {
////        fun printColor() {
////            println("The cat named $name has a $color bow.")
////        }
////    }
////}
//
////class Vehicle(val name: String) {
////    inner class Engine(val horsePower: Int) {
////        fun start() {
////            println("RRRrrrrrrr....")
////        }
////        fun printHorsePower(){
////            println("The $name vehicle has $horsePower horsepower.")
////        }
////    }
////}
////class Pumpkin(val type: String, val isForHalloween: Boolean) {
////    fun addCandle(){
////        if (isForHalloween) Candle().burning() else println("We don't need a candle.")
////    }
////
////    inner class Candle {
////        fun burning() {
////            println("The candle is burning inside this spooky $type pumpkin! Boooooo!")
////        }
////    }
////}
////
////class Cat(val name: String, val color: String, val size: Int) {
////
////    fun sayMeow() {
////        println("$name says: \"Meow\".")
////    }
////
////    inner class Bow(val color: String, val size: Int) {
////        fun printColor() {
////            print("The cat named $name is $color. ")
////            print("The size of $name is $size. ")
////            print("The cat named $name has a ${this.color} bow. ")
////            print("The size of the bow is ${this.size}.")
////        }
////    }
////}
////class Vehicle {
////    inner class Engine {
////        fun start() {
////            println("RRRrrrrrrr....")
////        }
////    }
////}
//
////class Player(val id: Int) {
////    object Properties {
////        /* Default player speed in playing field – 7 cells per turn */
////        val defaultSpeed = 7
////
//////        fun calcMovePenalty(cell: Int): Int {
//////            /* calc move speed penalty */
//////        }
////    }
////
////    /* creates a new instance of Player */
////    object Factory {
////        fun create(playerId: Int): Player {
////            return Player(playerId)
////        }
////    }
////}
////
////
////class Cell {
////    object BaseProperties {
////        var width = 10
////        var height = 10
////    }
////    val newWidth = BaseProperties.width
////    val  newHeight = BaseProperties.height
////
////    object PlayingField {
////        object Size {
////            var width: Int = 0
////            var height: Int = 0
////        }
////        fun changeSize(newWidth: Int, newHeight: Int) {
////            Size.width = newWidth
////            Size.height = newHeight
////        }
////    }
////
////    object Me {
////        const val CURRENT_AGE = 18
////        const val EYES_COLOR = "green"
////        const val HEIGHT = 188
////    }
////}
//
////object Math {
////    fun abs(value: Int): Int{
////        return kotlin.math.abs(value)
////    }
////    fun abs(value: Double): Double{
////        return kotlin.math.abs(value)
////    }
////}
//
////You want to create a singleton Manager that can solve some tasks. Let's write a skeleton for it.
////
////First, you have a class Task with one field name. Second, you need to create a singleton Manager with a function solveTask() and an Int property solvedTask.
////
////The function solveTask() receives an instance of the Task class and prints a line "Task NAME solved!", where NAME is the name of the task.
////
////Also, you should increase the solvedTask property by one each time you solve a task. Good luck!
//
////class Task(val name: String)
////
////object Manager {
////    var solvedTask = 0
////    fun solveTask(value: Task) {
////        println("Task ${value.name} solved!")
////        solvedTask++
////    }
////}
//
////class Player(val id: Int, val name: String, val hp: Int) {
////    companion object {
////        var id = 0
////        const val HP = 100
////        fun create(name: String): Player {
////            id++
////            return Player(id, name, HP)
////        }
////    }
////}
//
////enum class DangerLevel(val num: Int) {
////    HIGH(3),
////    MEDIUM(2),
////    LOW(1);
////
////    fun getLevel(): Int {
////        return num
////    }
////}
////
////enum class Rainbow(val colorName: String) {
////
////    RED("Red"),
////    ORANGE("Orange"),
////    YELLOW("Yellow"),
////    GREEN("Green"),
////    BLUE("Blue"),
////    INDIGO("Indigo"),
////    VIOLET("Violet"),
////    NULL("");
////
////    companion object {
////
////        fun findByName(name: String): Rainbow {
////            for (color in values()) {
////                if (name == color.colorName.lowercase()) return color
////            }
////            return NULL
////        }
////    }
////}
////
////fun main() {
////    val color = Rainbow.findByName(readln().lowercase())
////    println(color.ordinal + 1)
////}
////    val vehicle = Vehicle("Benz")
////    val start = vehicle.Engine(20)
////    start.printHorsePower()
////    val height = readln().toInt()
////    val length = readln().toInt()
////    val newLength = readln().toInt()
////    val width = readln().toInt()
////
////    val box = Box(height, length, width)
////    val box1 = box.copy(length = newLength)
////    println(box.toString())
////    println(box1.toString()
////   )
////    val a = "white"
////    println(a.uppercase())
////    print("Hello Lakan")
////    println(1 + 1)
//
////    val inputList = mutableListOf(
////        mutableListOf('P', 'R', 'O', 'G', 'R', 'A', 'M', 'M', 'I', 'N', 'G'),
////        mutableListOf('I', 'S'),
////        mutableListOf('M', 'A', 'G', 'I', 'C')
////    )
////    val newInput = mutableListOf(
////        inputList[2]
////    )
////    println(inputList[2].joinToString())
//
////    val list = List
////    val  iterator = list.iterator()
////    iterator.forEach {
////        if (it == 2){
////            println(it)
////        }
////    }
////    //println(solution(MutableList,1))
//
////    val cat = Cat("Bob")
////    val bow = cat.Bow("red")
////
////    bow.printColor()
//
//
////    val List = listOf(1, 2, 3, 4)
////    val MutableList = mutableListOf("hello", "boss", "dick", "dick")
////
////
////    fun solution(elements: MutableList<String>, index: Int): MutableList<String> {
////        elements.removeAt(index)
////        return elements
////    }
////fun solution(strings: MutableList<String>, str: String): MutableList<String> {
////    // put your code here
////    return strings.joinToString(" ").replace(str, "Banana").split(" ").toMutableList()
////}
//
////fun solution(strings: MutableList<String>, str: String): MutableList<String> {
////    for (string in strings) {
////        if (str == string) {
////            strings[strings.indexOf(str)] = "Banana"
////        }
////    }
////    return strings
////}
//
//
////fun solution(numbers: List<Int>, number: Int): MutableList<Int> {
////    val newNumber = numbers.toMutableList()
////    newNumber.add(number)
////    return newNumber
////}
////fun solution(first: List<Int>, second: List<Int>): MutableList<Int> {
////    val num = first + second
////    return num.toMutableList()
////}
//
////fun solution(numbers: List<Int>) {
////    val num = mutableListOf<Int>()
////    for (i in numbers) {
////        if (i % 2 == 0) {
////            num.add(i)
////        }
////    }
////    println(num.joinToString(" "))
////}
////fun solution(strings: List<String>, str: String): Int {
////    val predicate: (String) -> Boolean = { it.contains(str) }
////    return strings.count(predicate)
////}
//
////fun solution(numbers: List<Int>): Int {
////    var num = 0
////    for (i in numbers) {
////        num += i
////    }
////    return num
////}
//
////data class Client(val name: String, val age: Int, val balance: Int) {
////    override fun equals(other: Any?): Boolean {
////        other as Client
////
////        if (name != other.name) return false
////        if (age != other.age) return false
////
////        return true
////    }
////
////}
////
////fun main() {
////    val bob = Client("Bob", 29, 10)
////    val john = bob.copy(name = "John", age = 21)
////    val robert = john.copy(name = "Robert")
////    println(bob.age + john.age + robert.age)
////    val name = readln()
////    val age = readln().toInt()
////    val balance = readln().toInt()
////    val name1 = readln()
////    val age1 = readln().toInt()
////    val balance1 = readln().toInt()
////
////    val person = Client(name, age, balance)
////    val person1 = Client(name1, age1, balance1)
////
////    println(person == person1)
////}
//
//
////Write a program that reads six values (name, age, balance, name, age, balance) and uses all of them as fields of a data class, that is, Client.
////
////Change this given data class in order to check two different clients disregarding their balances.
////It means that two clients are equal if they have the same name and age. Print the result as true or false.
//
//
////class Client(val name: String, val age: Int, val gender: String) {
////    override fun equals(other: Any?): Boolean {
////        if (this === other) return true
////        if (javaClass != other?.javaClass) return false
////
////        other as Client
////
////        if (name != other.name) return false
////        if (age != other.age) return false
////        if (gender != other.gender) return false
////
////        return true
////    }
////
////    override fun hashCode(): Int {
////        var result = name.hashCode()
////        result = 31 * result + age
////        result = 31 * result + gender.hashCode()
////        return result
////    }
////}
//
//
////fun main(){
////    val rock = "R"
////    val paper = "P"
////    val scissors = "S"
////
////    val computerResult = mutableListOf("Rock","Paper","Scissors")
////
////    var condition = true
////
////    while (condition){
////        val input = readln()
////        val random = computerResult.random()
////        val pRockWin = input == rock && random == "Scissors"
////        val cRockWin = input == scissors && random == "Rock"
////        val pPaperWin = input == paper && random == "Rock"
////        val cPaperWin = input == rock && random == "Paper"
////        val pScissorsWin = input == scissors && random == "Paper"
////        val cScissorsWIn = input == paper && random == "Scissors"
////        val player = when(input){
////            "R" -> "Rock"
////            "P" -> "Paper"
////            "S" -> "scissors"
////            else -> "error"
////        }
////        if (pRockWin || cRockWin){
////            println("Player($player): CPU($random)")
////            condition = false
////        }else if (pPaperWin || cPaperWin){
////            println("Player($player): CPU($random)")
////            condition = false
////        }else if (pScissorsWin || cScissorsWIn){
////            println("Player($player): CPU($random)")
////            condition = false
////        }else{
////            println("Player($player): CPU($random)")
////        }
////    }
////}
//
////fun main() {
////    val factory = FactoryWithRoof(3, 2, 23000)
////    print(factory.employeesPerFloor())
////}
////
////open class Facility(val floors: Byte) {
////    fun addFloors(num: Byte): Int = floors + num
////}
////
////open class Factory(floors: Byte, val employees: Short, val roof: Byte) : Facility(floors) {
////    fun buildRoof(): Int = super.addFloors(roof)
////    open fun employeesPerFloor(): Int = employees / floors
////}
////
////open class FactoryWithRoof(floors: Byte, roof: Byte, employees: Short) : Factory(floors, employees, roof) {
////    override fun employeesPerFloor(): Int = employees / (floors + super.buildRoof())
////}
//
//
////fun main() {
////    val leatherCase = LeatherCase(190, "brown")
////    val softCase = SoftCase(120, "yellow")
////    val woodCase = WoodCase(230, "orange")
////    println(getCaseTax(leatherCase))
////    println(getCaseTax(softCase))
////    println(getCaseTax(woodCase))
////    println(getCaseTax(leatherCase) + getCaseTax(softCase) + getCaseTax(woodCase))
////}
////
////open class Case(val cost: Int) {
////    fun getFullInfo(): String = "$$cost cost" + getTax()
////
////    open fun getTax(): Int = (cost * 0.25).roundToInt()
////}
////
////open class SoftCase(cost: Int, val color: String) : Case(cost) {
////    override fun getTax(): Int = super.getTax() + 100
////}
//////130 + 66.5
////open class WoodCase(cost: Int, val color: String) : Case(cost)
////
////open class LeatherCase(cost: Int, color: String) : SoftCase(cost, color) {
////    override fun getTax(): Int = (cost * 0.35).roundToInt()
////}
////
////fun getCaseTax(case: Case): Int = case.getTax()
//
//
////open class Gadget(price: Int, brand: String)
////class Headphones() : Gadget(price: Int, brand: String)
////class Headphones(price: Int, brand: String, type: String) : Gadget(price: Int, brand: String)
////class Headphones(price: Int, brand: String, val type: String) : Gadget(price, brand)
////class Headphones(price, brand, val type: String) : Gadget(price, brand)
//
//
////open class Wood(val age: Int) {
////    fun getWoodInfo(): String {
////        return "age $age"
////    }
////}
////
////class Pine(val isSpiny: Boolean, age: Int) : Wood(age) {
////    fun getPineInfo(): String {
////        return getWoodInfo() + ", spiny $isSpiny"
////    }
////}
////
////fun main() {
////    val pine = Pine(true, 3)
////    println(pine.getPineInfo() + ", " + pine.getWoodInfo())
////}
//
//
////open class Vehicle(val name: String, val wheelsNum: Int = 0)
////
////open class Car(name: String, wheelsNum: Int, val spareWheelsNum: Int = 0)
////    : Vehicle(name, wheelsNum)
////
////open class Truck(name: String, wheelsNum: Int, spareWheelsNum: Int, val type: String)
////    : Car(name, wheelsNum, spareWheelsNum)
////
////fun wheelsNum(vehicle: Vehicle): Int {
////    return if (vehicle.wheelsNum < 0) 0 else vehicle.wheelsNum
////}
////
////fun totalWheelsNum(car: Car): Int {
////    return car.wheelsNum + car.spareWheelsNum
////}
////
////fun spareWheelsNum(car: Car): Int {
////    return totalWheelsNum(car) - wheelsNum(car)
////}
////
////fun main() {
////    val car = Car("Edison", 4, 2)
////    val truck = Truck("Riebhell", 8, 2, "Heavy")
////    println(spareWheelsNum(car) + spareWheelsNum(truck))
////}
//
////const val MAX_PRICE = 1_000_000
////const val MIN_PRICE = 0
////fun main() {
////    val rooms = readLine()!!.toInt()
////    val price = readLine()!!.toInt()
////    val house = House(rooms, price)
////    println(house.totalPrice())
////}
////
////class House(private val rooms: Int, private val price: Int) {
////    private var newPrice = if (price > MAX_PRICE) MAX_PRICE else if (price < MIN_PRICE) MIN_PRICE else price
////
////    fun totalPrice(): Any {
////        val rooms = rooms
////        val result = when {
////            rooms <= 1 -> cabin()
////            rooms in 2..3 -> bungalow()
////            rooms == 4 -> cottage()
////            rooms in 5..7 -> mansion()
////            else -> palace()
////        }
////        return result
////    }
////
////    private fun cabin(): Int {
////        return newPrice * 1
////
////    }
////
////    private fun bungalow(): Int {
////        return (newPrice * 1.2).toInt()
////    }
////
////    private fun cottage(): Int {
////        return (newPrice * 1.25).toInt()
////    }
////
////    private fun mansion(): Int {
////        return (newPrice * 1.4).toInt()
////    }
////
////    private fun palace(): Int {
////        return (newPrice * 1.6).toInt()
////    }
////}
//
//
////1 for Cabin,2-3 for Bungalow, 4 for Cottage, 5-7 for Mansion, 8-10 for Palace. If the number is lower than 1,
////it's a Cabin. If the number is greater than 10, it's a Palace.
////The second one is the base price of this house. If this price is lower than 0, this house costs 0,
////if it is greater than 1_000_000, the base price is 1_000_000.
//
////There is also a coefficient per each class: 1 for Cabin, 1.2 for Bungalow, 1.25 for Cottage, 1.4 for Mansion, 1.6 for Palace.
////
////The program should define which house needs to be built and calculate the final price of this house according to the next rule: base price * coefficient.
//
//
////fun main() {
////    val productType = readln()
////    val price = readln().toInt()
////    val product = Product(price, productType)
////    println(product.totalPrice())
////}
////
////class Product(private val price: Int, private val productType: String) {
////    fun totalPrice(): Int {
////        val num = when (productType) {
////            "headphones" -> price + price * 0.11
////            "smartphone" -> price + price * 0.15
////            "tv" -> price + price * 0.17
////            "laptop" -> price + price * 0.19
////            else -> -1
////        }
////        return num.toInt()
////    }
////}
//
//
//////import kotlin.math.pow
////import java.io.IOException
////import java.lang.ArithmeticException
////
//////fun main() {
//////    val scanner = Scanner(System.`in`)
//////
//////    val a = scanner.nextInt()
//////    val b = scanner.nextInt()
//////    val c = scanner.nextInt()
//////    val d = scanner.nextInt()
//////    val e = scanner.nextInt()
//////    val f = scanner.nextInt()
//////    var rows = mutableListOf("")
//////    var column = mutableListOf("")
//////
//////    for (i in 1..5) {
//////        if (a == i || c == i || e == i) continue else rows += i.toString()
//////
//////    }
//////
//////    for (i in 1..5) {
//////        if (b == i || d == i || f == i) continue else column += i.toString()
//////    }
//////
//////    println(rows.joinToString(" ").trimIndent())
//////    println(column.joinToString(" ").trimIndent())
//////}
////
////const val FIVE_CELLS = 5
////const val THREE_INPUTS = 3
////
////fun doComputations(value: Int) {
////    if (value / 2 == 1) {
////        throw Exception("Divided by 2!")
////    } else if (value + 2 / 2 == 1) {
////        throw Exception("Some computations here")
////    } else {
////        throw Exception("No computations")
////    }
////}
////
////fun returnValue(): Int {
////    val value = readln().toInt()
////    if (value > 0) {
////        throw Exception("It's too big")
////    }
////    return value
////}
////
////fun findCar(): String {
////    val maxSpeed = readln().toInt()
////    val accTime = readln().toInt()
////
////    if (maxSpeed < 120 || accTime !in 1..4) {
////        throw Exception("The race can't be won with this car")
////    }
////    return "I will definitely win!"
////
////
////}
////
////fun parseCardNumber(cardNumber: String): Long {
////    if (!cardNumber.matches(Regex("(\\d{4} ){3}\\d{4}"))) {
////        throw Exception("invalid card number format")
////    }
////    return cardNumber.split(" ").joinToString("").toLong()
////}
////
//////fun parseCardNumber(cardNumber: String): Long {
////////    infix fun CharSequence.matches(regex: Regex): Boolean {}
//////    val (whitespaces, notWhitespaces) = cardNumber.partition { it.isWhitespace() }
//////    if (whitespaces.length  > 3 || whitespaces.length < 3) {
//////        throw Exception("Space should be 3")
//////    }
//////    val number = cardNumber.split(" ")
//////    for (i in number) {
//////        if (i.length > 4 || i.length < 4) {
//////            throw Exception("Check again")
//////        }
//////    }
//////    return number.joinToString("").toLong()
//////}
////fun round(number: Int): Int? {
////    return if (number >= 1000) null else number
////}
////
////
////// do not change function below
////
////fun check(name: String): String? {
////    return if (name.length > 5) null else name
////}
////
////fun intDivision(x: String, y: String): Int {
////    var result = 0
////    try {
////        result = x.toInt() / y.toInt()
////    } catch (e: ArithmeticException) {
////        println("division by zero!")
////
////    } catch (e: NumberFormatException) {
////        println("Read values are not integers.")
////    }
////    return result
////
////}
////
////fun printFifthCharacter(input: String): String {
////    var string = ""
////    try {
////        string = "The fifth character of the entered word is ${input[4]}"
////    } catch (e: StringIndexOutOfBoundsException) {
////        println("The input word is too short!")
////    }
////    return string
////}
////
////fun convertStringToDouble(input: String): Double {
////    var value = 0.0
////    try {
////        return input.toDouble()
////    } catch (e: NumberFormatException) {
////        value = 0.0
////    }
////    return value
////}
////
////fun isNumber(input: String): Any {
////    val num = input.toIntOrNull()
////    return num ?: input
////}
////
////fun pepTalk(name: String): String {
////    val array = name.split(" ").toTypedArray()
////    val firstName = array[0]
////    val secondName = array[1]
////    return "Don't lose the towel, traveler $firstName $secondName!"
////}
////
////
////fun suspiciousFunction(param: Int) {
////    when (param) {
////        0 -> throw Exception("Some exceptions?")
////        1 -> throw ArithmeticException("Division by zero")
////        2 -> throw Exception("An exception occurred here")
////        3 -> throw IOException()
////    }
////}
////
////fun calculateBrakingDistance(v1: String, a: String): Int {
////    val v2 = 0
////
////    val result = try {
////        (v2 * v2 - v1.toInt() * v1.toInt()) / (2 * a.toInt())
////    } catch (e: NumberFormatException) {
////        println(e.message)
////        -1
////    } catch (e: ArithmeticException) {
////        println("The car does not slow down!")
////        -1
////    }
////    return result
////}
//////class Counter(var value: Int) {
//////
//////    fun increment() {
//////        ++value
//////    }
//////}
////
////class Car(val make: String, val year: Int) {
////
////    var speed: Int = 0
////
////    fun accelerate() {
////        speed += 5
////    }
////
////    fun decelerate() {
////        if (speed >= 5) {
////            speed -= 5
////        } else {
////            speed = 0
////        }
////    }
////}
////
////fun main() {
////    var thirteen = 13L
////    for (i in 2..10) {
////        thirteen *= 13
////        println(thirteen)
////    }
////
//////    println(calculateBrakingDistance("6", "book"))
//////    try {
//////        suspiciousFunction(data)
//////    } catch (e: IOException) {
//////        println(" The IOException occurred")
//////    } catch (e: ArithmeticException) {
//////        println(e.message)
//////    } catch (e: Exception) {
//////        println(e.message)
//////    } finally {
//////        println("Will be executed in any case")
//////    }
////
////
////}
////
//////    val answer: Int = try {
//////        readLine()!!.toInt()
//////    } catch (e: NumberFormatException) {
//////        42
//////    } finally {
//////        println("The answer is a number")
//////    }
//////    println(answer)
////
//////    val name = readLine()!!
//////    val advice = try {
//////        pepTalk(name)
//////    } catch (e: IndexOutOfBoundsException) {
//////        "Don't lose the towel, nameless one."
//////    } finally {
//////        println("Good luck!")
//////    }
//////    print(advice)
////
//////    println(isNumber("b"))
//////
//////    val argument = readLine()!!
//////    println(check(argument)?.length ?: 0)
////
////
////// do not change function below
////
////
//////    val value = readlnOrNull()
//////    val result = value ?: throw IllegalStateException()
//////    println("Elvis says: $result")
//////    println("Elvis says: ${readLine() ?: error("IllegalStateException")}")
//////    val length: Int = name?.length
//////        ?: throw Exception("The name is null")
////
//////    val line: String? = readLine()
//////
//////    val b = line?.length ?: -1
//////    print(b)
////
//////   println(parseCardNumber("1334 2345 2344 2125")
////
////
//////    Imagine that you are choosing a car for a race. The maximum speed of your car must be at least 120 km/h,
//////    and the acceleration time to full speed must not exceed four seconds. The acceleration time can't be lower than one second.
//////
//////    If one of these conditions is violated, then an exception must be thrown with the message The race can't be won with this car; otherwise, return I will definitely win!.
////
////
//////    val index = readLine()!!.toInt()
//////    val word = readLine()!!
//////
//////    if (index !in word.indices) {
//////        println("There isn't such an element in the given string, please fix the index!")
//////    } else {
//////        println(word[index])
//////    }
////
////
//////    val numbersMap = mapOf("boa" to 1, "bob" to 2, "boc" to 3, "bod" to 9)
//////    println(numbersMap.mapKeys { it.key.uppercase() })
//////    println(numbersMap.mapValues { it.value + it.key.length })
////
//////    val numbers = setOf(1, 2, 3, 4, 5)
//////    println(numbers.map { it * 3 })
//////    println(numbers.mapIndexed { idx, value -> value * idx })
////
//////    val numbers = setOf(1, 2, 3)
//////    println(numbers.mapNotNull { if ( it == 2) null else it * 3 })
//////    println(numbers.mapIndexedNotNull { idx, value -> if (idx == 0) null else value * idx })
////
//////    val regex = "\\s+".toRegex()
//////    val input = MutableList(6) {readln().split(regex)}
//////
//////    println(input)
////
////
//////    val freeX = MutableList(FIVE_CELLS) { i -> i + 1 }
//////    val freeY = MutableList(FIVE_CELLS) { i -> i + 1 }
//////    List(THREE_INPUTS) {
//////        readln().split(" ").let {
//////            freeX.remove(it.first().toInt())
//////            freeY.remove(it.last().toInt())
//////        }
//////    }
//////    println(freeX.joinToString(" "))
//////    println(freeY.joinToString(" "))
////
////
//////    val a = "hello"
//////    val b =  a.length
//////    println(b)
////
////
//////import kotlin.random.Random
//////
//////const val ROWS = 9
//////const val COLUMNS = 9
//////const val MINE = 'X'
//////const val SAFECELL = '.'
//////const val MARKEDCELL = '*'
//////
//////fun main() {
//////    println("How many mines do you want on the field?")
//////    val input = readLine()!!.toInt()
//////    val mines = Mines(input)
//////    mines.processMineField()
//////    val hiddenMines = mines.mineField
//////    val displayedMineField = mines.duplicateMine
//////    displayedMineField.forEach{
//////        for(i in it.indices) {
//////            if(it[i] == MINE) {
//////                it[i] = SAFECELL
//////            } else continue
//////        }
//////    }
//////    printField(displayedMineField)
//////
//////    var inputMine = input
//////    while (inputMine > 0) {
//////        println("Set/delete mines marks (x and y coordinates): ")
//////        val (x, y) = readLine()!!.split(" ")
//////        val xCor = x.toInt() - 1
//////        val yCor = y.toInt() - 1
//////        when {
//////            hiddenMines[yCor][xCor].isDigit() -> {
//////                println("There is a number here!")
//////            }
//////            hiddenMines[yCor][xCor] == MINE -> {
//////                displayedMineField[yCor][xCor] = MARKEDCELL
//////                printField(displayedMineField)
//////                --inputMine
//////            }
//////            hiddenMines[yCor][xCor] == SAFECELL
//////                    && displayedMineField[yCor][xCor] == SAFECELL -> {
//////                displayedMineField[yCor][xCor] = MARKEDCELL
//////                printField(displayedMineField)
//////                ++inputMine
//////            }
//////            displayedMineField[yCor][xCor] == MARKEDCELL -> {
//////                if(hiddenMines[yCor][xCor] == SAFECELL) {
//////                    displayedMineField[yCor][xCor] = SAFECELL
//////                    printField(displayedMineField)
//////                    --inputMine
//////                }
//////            }
//////            else -> continue
//////        }
//////    }
//////    println("Congratulations! You found all the mines!")
//////}
//////
//////// A class to create an instance of a field containing a number of mines stated by the player
//////class Mines(private var input: Int) {
//////    // A 2-D list to represent the minefield
//////    val mineField = MutableList(ROWS) { MutableList(COLUMNS) { SAFECELL } }
//////    val duplicateMine = MutableList(ROWS) { MutableList(COLUMNS) { SAFECELL } }
//////
//////    fun processMineField() {
//////        while (input > 0) {
//////            val iRows = Random.nextInt(0, ROWS)
//////            val iColumns = Random.nextInt(0, COLUMNS)
//////            if (mineField[iRows][iColumns] != MINE) {
//////                mineField[iRows][iColumns] = MINE
//////                duplicateMine[iRows][iColumns] = MINE
//////                input--
//////            }
//////        }
//////        for (index in mineField.indices) {
//////            addHints(mineField, mineField[index], index)
//////            addHints(duplicateMine, duplicateMine[index], index)
//////        }
//////    }
//////
//////    private fun addHints(field: MutableList<MutableList<Char>>, list: MutableList<Char>, index: Int) {
//////        for (columnIndex in list.indices) {
//////            var count = 0
//////            if (isMine(field, index, columnIndex)) {
//////                list[columnIndex] = MINE
//////                continue
//////            }
//////            if (isMine(field, index - 1, columnIndex - 1)) count++
//////            if (isMine(field, index - 1, columnIndex + 1)) count++
//////            if (isMine(field, index - 1, columnIndex)) count++
//////            if (isMine(field, index + 1, columnIndex - 1)) count++
//////            if (isMine(field, index + 1, columnIndex + 1)) count++
//////            if (isMine(field, index + 1, columnIndex)) count++
//////            if (isMine(field, index, columnIndex - 1)) count++
//////            if (isMine(field, index, columnIndex + 1)) count++
//////            if (count > 0 && list[columnIndex] != MINE) {
//////                field[index][columnIndex] = count.toString().first()
//////            }
//////        }
//////    }
//////
//////    // Check for the index to not throw the indexOutOfBounds error
//////    private fun isMine(field: MutableList<MutableList<Char>>, rowIndex: Int, columnIndex: Int): Boolean {
//////        return if (
//////            rowIndex == -1
//////            || rowIndex == field.size
//////            || columnIndex == -1
//////            || columnIndex == field[rowIndex].size
//////        ) {
//////            false
//////        } else {
//////            field[rowIndex][columnIndex] == MINE
//////        }
//////    }
//////}
//////
//////private fun printField(field: MutableList<MutableList<Char>>) {
//////    println(" |123456789|")
//////    println("—|—————————|")
//////    field.forEachIndexed {index, list ->
//////        println("${index + 1}|${list.joinToString("")}|")
//////    }
//////    println("—|—————————|")
//////}
//////
////////fun main() {
////////
////////    val scanner = Scanner(System.`in`)
////////
////////
////////
////////    val input = MutableList(6) { scanner.nextInt()}
//////    println(input)
//////
//////    var rows = ""
//////    var column = ""
//////
//////    for (x in 1..5) {
//////        if ()
//////    }
//////
//////    for (x in 1..5){
//////
//////    }
////
////
//////    1) You can create an array of size: 6 or you can create six variables to get the input.
//////    2) Create two variables using var one for rows and one for columns. Initialize both of them with "".
//////    3) Create two for loops with conditions (x in 1..5) and (y in 1..5) respectively, one for adding elements in rows variable
//////    and another for adding elements in column variable. These loops should be independent from each other and not nested in each other.
//////    4) Nest one if statement in each loop with condition for "continue statement", then add elements to variables of step (2).
//////    5) Outside these loops at last, use two println() in separate lines to print rows.trim() and columns.trim().
////
//////    for (i in 1..4) {
//////        loop@ for (j in 1..3) {
//////            for (k in 1..2) {
//////                if (i == 2 || j == 3 || k == 2) break@loop
//////                print("$k")
//////            }
//////        }
//////    }
//////    for (i in 1..3) {
//////        if (i == 1) continue
//////        print(1)
//////        loop@ for (j in 1..2) {
//////            for (k in 1..2) {
//////                if (i == 2 || j == 3) break@loop
//////                print(2)
//////            }
//////            if (j == 1) return
//////            print(3)
//////        }
//////    }
////
////
//////    while (true){
//////        for (i in 'a'..'z'){
//////            if (i !in input)
//////
//////    }
////
////
//////    loop@ for (i in 'a'..'z') {
//////        for (j in input) {
//////            if (i == j) {
//////                continue@loop
//////            }
//////
//////        }
//////        print(i)
//////    }
////
//////    val input = readln()
//////
//////    for (i in 'a'..'z') {
//////        if (i !in input) print(i) else break
//////    }
////
//////println(result)
//////    Write a program that reads a word and prints all the alphabet letters that are not used in this word.
//////
//////    Only lowercase letters are counted.
////
//////    val timerValue = readLine()!!.toInt()
//////    val timer = ByteTimer(timerValue)
//////    println(timer.time)
////
//////    val value = readln()
//////    var num = 0
//////    for (i in value) {
//////        if (value.count { it == i } > 1){
//////            num++
//////        }
//////    }
//////    println(num)
//////    val inp = readln()
//////    var count = 0
//////    for (i in inp) {
//////        if (inp.count { it == i } == 1) {
//////            count++
//////        }
//////    }
//////    println(count)
//////    val s = readln()
//////    var distinct = s.length
//////
//////    loop@for (i in s.indices) {
//////
//////        for (j in s.indices) {
//////
//////            if (s[i] == s[j] && i != j) {
//////                distinct--
//////                continue@loop
//////            }
//////        }
//////    }
//////    println(distinct)
////
////
//////I call this hint a piece of advice, and it is based on the given theory and the learned syntax so far.
//////
//////Get the user input.
//////Create a variable and put the length of the user input.
//////Create two for loops (nested; outer is labeled and inner is not) and iterate by using indices of the user input.
//////The two variables came from two for loops are int data type. Use it to make a condition.
//////The condition is if input[outer for loop variable] is equal to input[inner for loop variable] and outer for loop variable is not equal to inner for loop variable,
//////then we can start counting.
//////The technique in counting is backward.
//////Print it and show the world how beautiful you are.
////
//////class ByteTimer(var time: Int) {
//////
//////    init {
//////        time = when {
//////            time > 127 -> 127
//////            time < -128 -> -128
//////            else -> time
//////        }
//////    }
//////}
////
//////There is a program that reads a number. If the number is less than -128, then the property time of a ByteTimer class must be -128.
//////If it's greater than 127, then it must be 127, otherwise, it must be its raw value.
//////
//////Fix the ByteTimer class.
////
//////fun main() {
//////    when (readln()) {
//////        "amount" -> println(interest(amount = readln().toInt()))
//////        "percent" -> println(interest(yearlyPercent = readln().toInt()))
//////        "years" -> println(interest(years = readln().toInt()))
//////        else -> println(interest())
//////    }
//////}
////
//////fun interest(amount: Int = 1000, yearlyPercent: Int = 5, years: Int = 10): Int {
//////    val result = amount * (1 + (yearlyPercent.toDouble()) / 100).pow(years)
//////    return result.toInt()
//////}
////
//////This equation shows how much money a customer should earn for a given starting amount, a yearly percent and a number of years for holding a deposit in the bank.
//////The common arguments are $1000 for the starting amount, 5% for yearly percent, and 10 years for a deposit.
//////
//////One of the banks asks you to create a program for bank employees. This program will help to calculate the final amount for non-default parameters.
//////The employee will input one parameter that they want to change: the name of the parameter (amount, percent, or years) and a new value of this parameter.
//////Try to use named parameters to solve this problem!
//////
//////You need to create a program that reads the name and the value of a new parameter, calculates the compound interest, and prints the final amount for this new parameter.
//////
//////Input: the first line of the input contains the parameter that a customer changed: amount for the starting amount, percent for yearly percent, or years for the number of years.
//////The next line contains a single integer number: the value of the parameter.
//////
//////Output: the integer part of the sum.
////
////
//////fun speedLimit(carSpeed: Int, roadLimit: Int = 60): String {
//////    return if (carSpeed > roadLimit) {
//////        "Exceeds the limit by ${carSpeed - roadLimit} kilometers per hour"
//////    } else {
//////        "Within the limit"
//////    }
//////}
////
//////Create a program that checks whether a car exceeds a speed limit. The limit is 60 kilometers per hour.
//////
//////Output Exceeds the limit by N kilometers per hour where N is kilometers per hour above the limit. If everything's OK, output Within the limit.
//////
//////The first line of the input contains the actual speed of the car. The second line of the input contains the limit on the road. If there is no special restriction,
////// the line reads no limit. In this case, you must apply the default limit.
//////
//////Try to use named parameters to solve this problem.
////
////
//////fun url(host: String = "localhost", port: Int = 443): String {
//////    return "https://$host:$port"
//////}
////
//////fun foo(a: Int, b: Int = a, c: Int = b) = ...
//////
//////fun foo(a: Int, b: Int = a, c: Int = a) = ...
//////
//////fun foo(a: Int = c, b: Int = c, c: Int) = ...
//////
//////fun foo(a: Int, b: Int = c, c: Int = b) = ...
//////
//////fun foo(a: Int = a, b: Int = b, c: Int) = ...
////
//////fun f(a: Int, b: Int, c: Int) = println(a+b+c)
//////fun polynomial(x: Int = 0, c: Int = 0, b: Int = 0, a: Int = 0): Int {
//////    return a * x * x + b * x + c
//////}
////
//////fun sum5(a1: Int, a2: Int, a3: Int = 0, a4: Int = 0, a5: Int = 0): Int {
//////    return a1 + a2 + a3 + a4 + a5
//////}
////
//////fun getVolume(length: Int, width: Int = 1, height: Int = 1): Int {
//////    return length * width * height
//////}
////
//////Create a function called getVolume, that takes 3 Int arguments that supposed to be a length,
//////a width and a height of an object and returns the volume of the cuboid with these sides.
//////If the third or the second dimensions are not specified, they should be 1 by default.
////
//////fun tip(bill: Int, percentage: Int = 10): Int {
//////    return (bill * percentage) / 100
//////
//////}
////
//////Create a function called tip that calculates the tip. The function has two parameters bill and percentage and returns the amount of tip.
//////The tip size varies greatly from country to country, so 10% of the total amount of a customer’s check is a more or less universal solution.
//////So, if the percentage is not specified, set it at 10. Return only the integer part of gratuity.
////
////// fun printLine(line: String = "", end: String = "\n") = print("$line$end")
//////fun f(x: Double): Double {
//////    return when {
//////        x <= 0 -> f1(x)
//////        x < 1 -> f2(x)
//////        else -> f3(x)
//////    }
//////}
//////
//////fun f1(x: Double): Double = x * x + 1
//////
//////fun f2(x: Double): Double = 1 / (x * x)
//////
//////fun f3(x: Double): Double = x * x - 1
////
////
//////fun createFullName(fname: String, lname: String) {
//////    println("$fname $lname")
//////}
//////
//////fun subtractTwoNumbers(a: Long, b: Long) {
//////    println(a - b)
//////}
//////
//////fun sumTwoNumbers(a: Long, b: Long) {
//////    println(a + b)
//////}
//////
//////fun divideTwoNumbers(a: Long, b: Long) {
//////    val divisor = b.toInt()
//////    if (divisor != 0) {
//////        println(a / b)
//////    } else {
//////        println("Division by 0!")
//////    }
//////}
//////
//////fun multiplyTwoNumbers(a: Long, b: Long) {
//////    println(a * b)
//////}
////
////
//////Take a look at the template and decompose calculator operations into four functions: subtractTwoNumbers(a: Long, b: Long) for subtraction,
////// sumTwoNumbers(a: Long, b: Long) for addition, divideTwoNumbers(a: Long, b: Long) for integer division and multiplyTwoNumbers(a: Long, b: Long)
////// for multiplication. Each function should print the calculation result.
//////
//////Note that you can't divide by zero. In case your second argument is zero in the corresponding function, print the message "Division by 0!".
//////fun getFullNames() {
//////    val firstName1 = readLine()
//////    val lastName1 = readLine()
//////    println("$firstName1 $lastName1")
//////
//////    val firstName2 = readLine()
//////    val lastName2 = readLine()
//////    println("$firstName2 $lastName2")
//////
//////    val firstName3 = readLine()
//////    val lastName3 = readLine()
//////    println("$firstName3 $lastName3")
//////}
//////
//////// implement your function here
//////fun createFullName...
////
//////class OperatingSystem{
//////    var name: String = "name"
//////}
//////class DualBoot{
//////
//////    var primaryOs: OperatingSystem = OperatingSystem()
//////    var secondaryOs: OperatingSystem = OperatingSystem()
//////}
////
//////OperatingSystem with a single String property name.
//////DualBoot with two OperatingSystem properties primaryOs and secondaryOs.
//////All the properties are to support reassignment. You can use whichever default values you want.
////
//////class Rectangle(val width: Int, val height: Int)
//////
//////fun printArea(rectangle: Rectangle) {
//////    rectangle.width * rectangle.height
//////}
//////
//////
//////fun main() {
//////    val a = readLine()!!.toInt()
//////    val b = readLine()!!.toInt()
//////    val c = readLine()!!.toInt()
//////    println(isRightEquation(a, b, c))
//////
//////
//////}
////
//////fun isRightEquation(a: Int, b: Int, c: Int): Boolean {
//////    return a * b == c
//////}
////
//////fun getLastDigit(a: Int) = (a % 10).absoluteValue
////
//////fun divide(a: Long, b: Long) = a.toDouble() / b.toDouble()
////
//////fun isVowel(letter: Char): Boolean {
//////    val vowels = listOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
//////    return letter in vowels
//////}
////
////
//////    Write a program that reads the shape number: 1 – a square, 2 – a circle, 3 – a triangle, 4 – a rhombus,
//////    and prints the text You have chosen a square (or circle, or triangle, or rhombus, depending on the number).
//////    If the input is a number that doesn't correspond to any of the listed shapes, output There is no such shape!
////
//////    val result = when (readln()) {
//////        "gryffindor" -> "bravery"
//////        "hufflepuff" -> "loyalty"
//////        "slytherin" -> "cunning"
//////        "ravenclaw" -> "intellect"
//////        else -> "not a valid house"
//////    }
//////    println(result)
////
////
//////    when (readln().toInt()) {
//////        1 -> println("You have chosen a square")
//////        2 -> println("You have chosen a circle")
//////        3 -> println("You have chosen a triangle")
//////        4 -> println("You have chosen a rhombus")
//////        else -> println("There is no such shape!")
//////    }
//////}
////
//////if it is gryffindor, output bravery;
//////if it is hufflepuff, output loyalty;
//////if it is slytherin, output cunning;
//////if it is ravenclaw, output intellect;
//////if otherwise, output not a valid house
////
//////    var condition = true
//////    var sum = 0
//////    do {
//////        val number = readln().toInt()
//////        if (number != 0) {
//////            sum += number
//////        } else {
//////            condition = false
//////        }
//////    } while (condition)
//////    println(sum)
////
//////    for (i in 1..number) {
//////        val num = i * i
//////        if (num <= number) {
//////            println(num)
//////        }
//////    }
////
//////    while (number != 1) {
//////        print("$number ")
//////
//////        number = if (number % 2 == 0) {
//////            number / 2
//////        } else {
//////            number * 3 + 1
//////        }
//////
//////    }
//////    print("$number")
////
//////    def collatz(n)
//////    while n > 1
//////    print(n, end=' ')
//////    if (n % 2)
//////    # n is odd
//////    n = 3*n + 1
//////    else
//////    # n is even
//////    n = n//2
//////    print(1, end='')
//////
//////
//////    n = int(input('Enter n '))
//////    print('Sequence ', end='')
//////    collatz(n)
////
//////    You have a natural number n. Generate a sequence of integers, described in the Collatz conjecture
//////
//////    If n is an even number, divide it in half, if it is odd, multiply it by 3 and add 1. Repeat this operation until you get 1 as a result.
//////
//////    For example, if n is 17, then the sequence would look like this
//////
//////    17 52 26 13 40 20 10 5 16 8 4 2 1
//////    This sequence should stop at 1 for any primary natural number n.
//////
//////    Output format
//////    A sequence of integers in a single line, separated by spaces.
////
////
//////    var value = false
//////    while (value){
//////        val num = readln().toInt()
//////
//////    }
////
////
//////    var i = 0
//////    while (i < 10) {
//////        i++
//////        if (i % 2 == 0) {
//////            print("$i ")
//////        }
//////    }
////
////
//////    println(readln().split(" ").maxByOrNull { it.length }!!)
////
////
//////    val a = readln().split(" ")
//////    var max = a.maxByOrNull  {it.length}!!
////
//////    for (i in a){
//////        if (i > max){
//////            max = i
//////        }
//////    }
//////    println(max)
////
//////    val (a, b, c) = readln().split("-")
//////    println("$b/$c/$a")
////
//////    val str1 = "aaabbcccdaa"
//////    var str2 = " "
//////    println(str2.last())
//////
//////    for (ch in str1) {
//////        if (ch != str2.last()) {
//////            str2 += ch
//////        }
//////    }
//////    println(str2)
////
//////    val str = "Hello, Kotlin"
//////    var i = str.lastIndex
//////    while (i >= 1) {
//////        print(str[i])
//////        i--
//////    }
//////    println(i)
//////    println(str)
////
//////    val w = readLine()!!.map { it.digitToInt() }.toList()
//////    val a = w[0]
//////    val b = w[1]
//////    val c = w[2]
//////    val d = w[w.size - 3]
//////    val e = w[w.size - 2]
//////    val f = w[w.size - 1]
//////    val equal = a + b + c == d + e + f
//////    if (equal) println("Lucky") else println("Regular")
////
////
//////    val num = world.subList(0, 3) == world.subList(world.size-3, world.size)
//////    if (num){
//////        println("Lucky")
//////    }else{
//////        println("Regular")
//////    }
////
//////    val first = a.subList(0, 2).toList()
//////    println(first)
////
////
//////    for (i in a) {
//////        print("$i$i")
//////    }
////
////
//////    val chars = charArrayOf('H', 'Y', 'P', 'E', 'R', '-', 'S', 'K', 'I', 'L', 'L' )
//////
//////    val stringFromChars = String(chars)
//////
//////    val strings = stringFromChars.split("-")
//////
//////    println(strings[1])
////
////// println("result".substring(1, 4).substring(1, 2))
////
//////    val example = "Kotlin is a language"
//////    example.replace(" language", "n island")
//////    println(example)
////
////
//////    val a = readln().uppercase()
//////    val b = readln().uppercase()
//////
//////    println(a == b)
////
////
//////    println(readln().last() - 1)
////
////
//////    val numbers = MutableList(size) { readln().toInt() }
//////    val maxNum = numbers.maxOrNull()
//////
//////    println(numbers.indexOf(maxNum))
////
//////    for (i in numbers.indices) {
//////        println(numbers[i])
//////    }
//////
//////      for (i in 10 downTo 0 step 2)
//////    val capital = mutableListOf("Tokyo", "Moscow", "Paris", "Washington", "Beijing")
////// numbers.clear()
////
//////println(capital)
////// println(numbers.joinToString())
////
//////    val numbers = readLine()!!.split(' ').map { it.toInt() }.toMutableList()
//////    val num = numbers.lastIndex
//////    val first = numbers.first()
//////    val last = numbers.last()
//////    numbers[0] = last
//////    numbers[num] = first
//////
//////    println(numbers.joinToString(separator = " "))
//////
//////    println(numbers[numbers.lastIndex])
//////
//////    println(numbers.last())
//////
//////    println(numbers[numbers.size - 1])
//////
//////    println(numbers[numbers.size - 2])
////
//////    println(numbers[numbers.size])
////
//////    println(numbers[-1])
////
//////    println(numbers[numbers.size + 1])
////
//////    val numbers = MutableList(100) { 0 }
//////
//////    numbers[0] = 1
//////    numbers[9] = 10
//////    numbers[99] = 100
//////
//////    println(numbers.joinToString())
////
////
//////    val a = readln().toInt()
//////    val b = readln().toInt()
//////    val n = readln().toInt()
//////
//////    var sum = 0
//////
//////    for (i in a..b) {
//////
//////        if (i % n == 0) {
//////            sum++
//////        }
//////
//////    }
//////    println(sum)
////
////
//////    Fizz Buzz is a classic programming problem. Here is its slightly modified version.
//////
//////    Write a program that takes the input of two integers the beginning and the end of the interval (both numbers belong to the interval).
//////
//////    The program is to output the numbers  this interval, but if the number is divisible by 3, you should output Fizz instead of it; if the number is
//////    divisible by 5, output Buzz, and if it is divisible both by 3 and by 5, output FizzBuzz.
//////
//////    Output each number or word on a separate line.
////
////
//////    result = a * (x * x * x) + b * (x * x) + c * (x) + d
////
////
//////    val a = readln().toInt()
//////    val b = readln().toInt()
//////    val c = readln().toInt()
//////    val d = readln().toInt()
//////    val e = readln().toInt()
//////
//////    println(e in a..b || e in c..d)
////
//////    for (i in 1..3) {
//////        for (j in 1..i) {
//////            println(j)
//////        }
//////    }
//////    val pirateJackSparrow = Sailor("None")
//////    val captainJackSparrow = Sailor("None")
//////    println(pirateJackSparrow === captainJackSparrow)
////
//////    var captain = Pirate("Hector Barbossa")
//////    println(captain.name)
//////
//////    captain = Pirate("Jack Sparrow")
//////    println(captain.name)
////
////
//////fun main() {
//////    val times = readln().toInt()
//////    var num = 0
//////
//////    repeat(times) {
//////        val input = readln().toInt()
//////        if (input > 0) {
//////            num++
//////        }
//////    }
////
////// println(num)
//////    val n = readln().toInt()
//////    var max = 0
//////
//////    repeat(n) {
//////        var num = readln().toInt()
//////
//////        if (num % 4 == 0 && num > max) {
//////            max = num
//////        }
//////    }
//////
//////    println(max)
////
////
//////    repeat(n) {
//////        var num = readln().toInt()
//////        when (num) {
//////
//////            -1 -> b++
//////
//////            0 -> c++
//////
//////            1 -> d++
//////
//////        }
//////    }
////
//////    println("$d $c $b")
////
////
//////    val a = readLine()!!.toInt()
//////    val b = readLine()!!.toInt()
//////    val c = readLine()!!.toInt()
//////
//////    println(
//////        if (a > c && a > b) {
//////            a
//////        } else if (b > c && b > a) {
//////            b
//////        } else {
//////            c
//////        }
//////    )
////
////
//////    val a = readln().toInt()
//////    println(if (a <= 0) "NO" else "YES" )
////
//////    val a = readln().toInt()
//////    println(if (a == 0) "zero" else if (a < 0) "negative" else "positive")
////
////
//////    val b = readLine()!!.toInt()
//////    val c = readLine()!!.toInt()
//////
//////    println(if (c > b) "Excess" else if (c < a) "Deficiency" else "Normal")
////
//////println(if (true)  if (false) { "A" } else "B")
////
//////        If Ann's sleep schedule complies with the requirements of that TV program – print "Normal". If Ann sleeps less than AA hours,
//////        output “Deficiency”, if she sleeps more than BB hours, output “Excess”.
////
//////println(if (a > b) a else b)
////
////
//////println(readln().toInt() < 10)
////
////
//////    val a = readln().toInt()
//////    val b = readln().toInt()
//////    val c = readln().toInt()
//////    val x = a + b == 20 || b + c  == 20 || c + b == 20
//////    println(x)
////
//////    val magic = 2_000_000_000
//////    val giant  = 3_000_000_000
//////
//////    val x Int= magic + magic + 1
////
//////    val l Int= 100L - magic
//////
//////    val p Int= giant - magic
//////
//////    val v Int = (magic + giant) % 10
////
//////println(x)
////
//////    val data = """
//////        {
//////            "firstName" "John",
//////            "lastName" "Smith",
//////            "age" 35,
//////            "phoneNumbers" [
//////                {
//////                    "type" "mobile",
//////                    "number" "123 567-7890"
//////                }
//////            ]
//////        }
//////    """.trimIndent()
//////
//////    println(data)
////
//////    val a = 14
//////    val b = 11
//////
//////    println("$a+$b")
//////    val (a, b, c) = readln().split(' ')
//////    val (d, e, f) = readln().split(' ')
//////    println("$a$b$c $d/$e/$f")
//////    val a = readln()
//////    val no = a.length
//////    println("$no repetitions of the word $a ${a.repeat(no)}")
////
//////    val n = 1234
//////
//////    println( n / 10 % 10)
//////
//////    println( n % 100 / 10)
//////
//////    println( n % 10 / 10)
////
//////    val b0 Byte = 2
//////    val s0 Short = 10
//////    val n0 Int = 5
//////    val l0 Long = 14
//////    val f0 Float = 11.4f
//////
//////    val b Byte = 5                 //1
//////    val s Short = 2 + b0           //2
//////    val n Int = s0.toByte() + 2    //3
//////    val l Long = n0 + 4            //4
//////    val f Float = l0.toFloat() + 1 //5
//////    val d Double = f0 / 1          //6
////
//////    var a = 5
//////    val b = 9
//////    val c = 3
//////    val d = a++ //+ (b / 2) - c - 4
//////    println(d)   // this is 2
////
//////    var a = 5
//////    var b = 0
//////    val c = a++ * 1 - b--
//////    println(a)
////
//////    println((readln().toInt()%100/10).toFloat())
////
//////    val duration = readln().toInt()
//////    val  foodPerDay= readln().toInt()
//////    val flightCost = readln().toInt()
//////    val hotelPerNight = readln().toInt()
//////
//////    println(foodPerDay * duration + flightCost * 2 + hotelPerNight *(duration - 1))
////
////
//////    duration in days
//////    total food cost per day
//////    one-way flight cost
//////    cost of one night in a hotel (the number of nights is the duration minus one)
////
//////    var num = 10
//////    while (input < 1000){
//////        num = input % num
//////        println(num)
//////        num++
//////    }
////
//////    if (input % 2 != 0) {
//////        println(++input)
//////    } else {
//////        println(input + 2)
//////    }
////
//////print(readln().toDouble().toLong())
//////    val first = readln()
//////    val second = readln()
//////    val third = readln()
//////    val fourth = readln()
//////    val fifth = readln()
//////
//////    println("$first$second$third$fourth$fifth")
//////println("99" + "" + "99")
////
////
//////    val num1  = readln().toLong()
//////    val num2 = readln().toLong()
//////
//////    println(num1+num2)
////
////
//////    val d Double = 10.0
//////
//////    val i = d.toInt()    // 1
//////    val s = d.toString() // 2
//////    val f = d.toFloat()  // 3
//////    println(f)
////
////
//////    1000000000000000
//////    2222222222222222
////
////
//////    val something = readln()
//////
//////    val d = something.toInt()
//////    val f = d.toDouble()
//////    val i = f.toString().toBoolean()
//////
//////    println("$d\n$f\n$i")
////
//////    val scanner = Scanner(System.`in`)
//////    val a = scanner.next()
//////    val b = scanner.next()
//////    val c = scanner.next()
//////    val d = scanner.next()
//////    val e = scanner.next()
//////
//////    println("$a\n$b\n$c\n$d\n$e")
////
////
//////    This course
//////    teach you Kotlin
////
////
//////fun main() = print(readln().split(Regex("\\s+")).take(SIZE).joinToString("\n"))
////
//////fun main() {
//////    val scanner = Scanner(System.`in`)
//////    for (i in 0..3) {
//////        if (i < 2) {
//////            println(scanner.next())
//////        } else {
//////            println(scanner.nextInt())
//////        }
//////    }