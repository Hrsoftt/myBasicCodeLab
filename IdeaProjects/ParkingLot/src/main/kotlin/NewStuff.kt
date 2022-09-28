

package search

import java.io.File

fun menu() {
    println("=== Menu ===")
    println(
        "1. Find a person\n" +
                "2. Print all people\n" +
                "0. Exit"
    )
}

//fun getFromIndex(index: Map<String, Set<Int>>, query: String): Set<Int> {
//    return index[query] ?: emptySet()
//}
//
//fun findPerson(people: List<String>, index: Map<String, Set<Int>>) {
//    println("Select a matching strategy: ALL, ANY, NONE")
//    val strategy = readln()
//    println("Enter a name or email to search all matching people.")
//    val querys = readln().split(" ")
//
//    val matchesInIndex = when (strategy) {
//        "ALL" -> {
//            querys.map { getFromIndex(index, it) }.reduce { acc, set -> acc.intersect(set).toMutableSet() }
//        }
//        "ANY" -> {
//            querys.map { getFromIndex(index, it) }.reduce { acc, set -> acc.union(set).toMutableSet() }
//        }
//        "NONE" -> {
//            var allLines = people.indices.toMutableSet()
//            for (query in querys) {
//                allLines = allLines.minus(getFromIndex(index, query)).toMutableSet()
//            }
//            allLines
//        }
//        else -> emptySet()
//    }
//
//
//    if (matchesInIndex.isNotEmpty()) {
//        println("${matchesInIndex.size} persons found:")
//        matchesInIndex.forEach { println(people[it]) }
//    } else {
//        println("No matching people found.")
//    }
//
//}
//
//fun index(people: List<String>): Map<String, Set<Int>> {
//    val invertedIndex = mutableMapOf<String, MutableSet<Int>>()
//    people.forEachIndexed { index, line ->
//        line.split(" ").forEach { word ->
//            invertedIndex.getOrPut(word) { mutableSetOf() }.add(index)
//        }
//    }
//    return invertedIndex
//}
fun index(lines: List<String>): Map<String, Set<Int>> {
    val index = mutableMapOf<String, MutableSet<Int>>()
    for (line in lines.withIndex()) {
        val parts = line.value.split(" ")
        for (part in parts) {
            val list = index.getOrDefault(part.lowercase(), mutableSetOf())
            list.add(line.index)
            index[part.lowercase()] = list
        }
    }
    return index
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
    return index[query.lowercase()] ?: emptySet()
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

fun printAll(people: List<String>) {
    println("=== List of people ===")
    people.forEach { println(it) }
}
fun main(args: Array<String>) {
    val file = File(args[1]).readLines()

    val index = index(file)
    while (true) {
        menu()
        when (readln()) {
            "1" -> findPerson(file, index)
            "2" -> printAll(file)
            "0" -> {
                println("Bye!")
                break
            }
            else -> {
                println("Incorrect option! Try again.")
                continue
            }
        }
    }

}


//===============================================================================================================================
//
//import utility.*
//import java.io.File
//
//private lateinit var EVERYONE: Array<String>
//private lateinit var CRITERIA: Criteria
//private val EVERYONE_MAP = mutableMapOf<String, MutableList<Int>>()
//
//fun main(args: Array<String>) {
//    val filename: String
//    var fileFound = true
//
//    try {
//        if (args[0] != "--data" || !File(args[1]).isFile) fileFound = false
//    } catch (e: Exception) {
//        fileFound = false
//    }
//
//    filename = if (!fileFound) {
//        print(if (args.isNotEmpty() && args.size == 2) "Loading ${args[1]} failed." else "No filename provided.")
//        println(" Loading default file names.txt for searching.\n")
//        "src/names.txt"
//    } else args[1]
//
//    initialize(filename)
//    menu()
//    println("\nBye!")
//}
//
//private fun initialize(fileName: String) {
//    val muteLines = mutableListOf<String>()
//    var count = 0
//
//    File(fileName).forEachLine {
//        muteLines.add(it)
//        val split = splitToArray(it)
//        for (word in split) {
//            if (EVERYONE_MAP.containsKey(word)) {
//                EVERYONE_MAP[word]?.add(count)
//            } else EVERYONE_MAP[word] = mutableListOf(count)
//        }
//        count++
//    }
//    EVERYONE = muteLines.toTypedArray()
//}
//
//private fun menu() {
//    val menu = "=== Menu ===\n1. Find a person\n2. Print all people\n0. Exit"
//    var read = getString(menu)
//    val num = { read.toIntOrNull() ?: getNum(read, true) }
//    var exit = false
//
//    while (!exit) {
//        when (num()) {
//            1 -> find()
//            2 -> printAll()
//            0 -> exit = true
//            else -> incorrectOption()
//        }
//        if (!exit) read = getString("\n$menu")
//    }
//}
//
//private fun find() {
//    CRITERIA = when (getString("\nSelect a matching strategy: ALL, ANY, NONE").toLowerCase().trim()) {
//        "all" -> Criteria.ALL
//        "any" -> Criteria.ANY
//        "none" -> Criteria.NONE
//        else -> {
//            incorrectOption()
//            find()
//            return
//        }
//    }
//    findCriteria()
//}
//
//private fun findCriteria() {
//    var found = true
//    val search = splitToArray(getString("\nEnter a name or email to search all suitable people.").toLowerCase())
//    var indexes = listOf<Int>()
//
//    for (word in search) {
//        if (EVERYONE_MAP.containsKey(word)) {
//            if (indexes.isEmpty()) indexes = EVERYONE_MAP[word]!! else {
//                if (CRITERIA == Criteria.ALL) {
//                    indexes = indexes.intersect(EVERYONE_MAP[word]!!).toList()
//                    if (indexes.isEmpty()) break
//                } else indexes = indexes.union(EVERYONE_MAP[word]!!).toList()
//            }
//        } else if (CRITERIA == Criteria.ALL) {
//            found = false
//            break
//        }
//    }
//    if (found && indexes.isEmpty() && CRITERIA != Criteria.NONE) found = false
//    if (found) CRITERIA.print(indexes.toTypedArray(), EVERYONE) else println("\nNo matching people found.")
//}
//
//private fun printAll() {
//    println("\n=== List of people ===")
//    EVERYONE.forEach { println(it) }
//}
//
//private fun incorrectOption() = println("\nIncorrect option! Please try again.")
//
//
//////
//////
////
////
////
////package svcs
////
////import java.io.File
////import java.math.BigInteger
////import java.security.MessageDigest
////import kotlin.system.exitProcess
////
////const val VCS_DIRECTORY = "vcs"
////const val COMMIT_DIRECTORY = "vcs\\commits\\"
////const val CONFIG_FILE = "vcs\\config.txt"
////const val INDEX_FILE = "vcs\\index.txt"
////const val LOG_FILE = "vcs\\log.txt"
////
////class Vsc (args: Array<String>) {
////    val configFile:File = File(CONFIG_FILE)
////    val indexFile:File = File(INDEX_FILE)
////    val logFile:File = File(LOG_FILE)
////    val vcsDir:File = File(VCS_DIRECTORY)
////    val commitDir:File = File(COMMIT_DIRECTORY)
////
////    var command = ""
////    var param = ""
////
////    val menu = mapOf(
////        "config" to "Get and set a username.",
////        "add" to "Add a file to the index.",
////        "log" to "Show commit logs.",
////        "commit" to "Save changes.",
////        "checkout" to "Restore a file.",
////    )
////
////    init {
////        if (args.isNotEmpty()) {
////            command = args[0]
////            if (args.size == 2) {
////                param = args[1]
////            }
////        }
////
////        /*
////         * Create VCS Structure
////         */
////        vcsDir.mkdir()
////        commitDir.mkdir()
////        configFile.createNewFile()
////        indexFile.createNewFile()
////        logFile.createNewFile()
////    }
////
////    fun deleteAll() {
////        configFile.delete()
////        indexFile.delete()
////        logFile.delete()
////        commitDir.deleteRecursively()
////        vcsDir.delete()
////    }
////
////    fun run() {
////        if (command.isEmpty()){
////            println(commandHelp())
////            exitProcess(0)
////        }
////
////        (when (command) {
////            "--help" -> println(commandHelp())
////            "config" -> println(commandConfig(param))
////            "add" -> println(commandAdd(param))
////            "log" -> commandLog()
////            "commit" -> commandCommit()
////            "checkout" -> println(commandCheckout())
////            else ->  println("'${command}' is not a SVCS command.")
////        })
////    }
////
////    fun commandHelp():String = """
////        These are SVCS commands:
////        config     ${menu["config"].toString()}
////        add        ${menu["add"].toString()}
////        log        ${menu["log"].toString()}
////        commit     ${menu["commit"].toString()}
////        checkout   ${menu["checkout"].toString()}
////    """.trimIndent()
////
////    /**
////     * commitId is made up of the concat filename and text in file for all files in indexFiles.
////     * and then hashed
////     */
////    fun getCommitId(): String {
////        var textContent = ""
////        val indexItems = indexFile.readLines()
////        for (fileName in indexItems) {
////            textContent += File(fileName).readText()
////            textContent += fileName
////        }
////
////        return textContent.md5()
////    }
////
////    fun String.md5(): String {
////        val md = MessageDigest.getInstance("MD5")
////        return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
////    }
////
////    fun String.sha256(): String {
////        val md = MessageDigest.getInstance("SHA-256")
////        return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
////    }
////
////    fun commandConfig(option: String): String {
////        if (option == "") {
////            val name = configFile.readText()
////            return if (name.isEmpty()) "Please, tell me who you are." else "The username is $name."
////        } else {
////            configFile.writeText(option)
////            return "The username is ${option}."
////        }
////    }
////
////    fun getUser(): String {
////        val name = configFile.readText()
////        if (name.isEmpty()) {
////            error("??????")
////        } else {
////            return name
////        }
////    }
////
////    fun commandAdd(param: String): String = if (param == "") showIndexFiles() else addFiles(param)
////
////    /**
////     * Read log File and print
////     */
////    fun commandLog() {
////        val logLines = logFile.readText().trim()
////        if (logLines.isEmpty()) {
////            println("No commits yet.")
////        } else {
////            println("$logLines\n")
////        }
////    }
////
////    fun commandCommit() {
////        if (param == "") {
////            println("Message was not passed.")
////        } else {
////            val trackedFiles = indexFile.readLines()
////            if (trackedFiles.isEmpty()) {
////                println("Nothing to commit.")
////            } else {
////
////                val foundChanges = checkForChanges()
////                if (foundChanges) {
////                    doCommit()
////                    println("Changes are committed.")
////                } else {
////                    println("Nothing to commit.")
////                }
////            }
////        }
////    }
////
////    fun doCommit() {
////        val commitId = getCommitId()
////
////        /* Create Commit Folder */
////        File(COMMIT_DIRECTORY + commitId).mkdir()
////        val myFile = File(COMMIT_DIRECTORY + commitId)
////        myFile.createNewFile()
////
////        /* Copy Files and Log */
////        for (fileName in indexFile.readLines()) {
////            val fileIn = File(fileName)
////            val fileOut = File(COMMIT_DIRECTORY + "$commitId\\$fileName")
////            fileIn.copyTo(fileOut, overwrite = true)
////        }
////        val buffer = logFile.readText() // Purpose of buffer it is, so we can have the latest log on top
////
////        logFile.writeText("commit $commitId\n")
////        logFile.appendText("Author: "+getUser()+"\n")
////        logFile.appendText(param+"\n")
////        logFile.appendText(buffer)
////    }
////
////    fun commandCheckout():String = menu["checkout"].toString()
////
////    fun showIndexFiles(): String {
////        val nameList = indexFile.readLines()
////        return if (nameList.isEmpty()) {
////            menu["add"].toString()
////        } else {
////            var tmpStr = "Tracked files:"
////            for (name in nameList){
////                tmpStr += "\n$name"
////            }
////            tmpStr
////        }
////    }
////
////    fun checkForChanges() : Boolean {
////        val commitDirIds = commitDir.listFiles()!!.map{it.name}
////        if (commitDirIds.isEmpty()){
////            return true
////        } else {
////            val commitId = getCommitId()
////
////            if (!commitDirIds.contains(commitId)){
////                return true
////            }
////        }
////        return false
////    }
////
////    fun addFiles(fileName: String): String {
////        val addFile = File(fileName)
////
////        return if (addFile.exists()){
////            val nameList = indexFile.readLines()
////            if (!nameList.contains(fileName)) {
////                if (nameList.isEmpty()) {
////                    indexFile.appendText(fileName)
////                } else {
////                    indexFile.appendText("\n" + fileName)
////                }
////            }
////
////            "The file '${fileName}' is tracked."
////        } else {
////            "Can't find '${fileName}'."
////        }
////    }
////}
////
////fun main(args: Array<String>) {
////    // Test Cases on my PC
////    //var args = arrayOf("xxx")
////    //args = arrayOf("config") // Please, tell me who you are.
////    //args = arrayOf("config", "max") // The username is max.
////    //args = arrayOf("commit", "nothing yet") // Nothing to commit.
////    //args = arrayOf("add")
////    //args = arrayOf("add", "file1.txt") // The file 'file1.txt' is tracked.
////    //args = arrayOf("add") //Tracked files:\n file1.txt
////    //args = arrayOf("add", "file2.txt") // //Tracked files:\n file2.txt
////    //args = arrayOf("add") //Tracked files:\n file1.txt\n file2.txt
////    //args = arrayOf("commit") // Message was not passed.
////    //args = arrayOf("log") // No commits yet.
////    //args = arrayOf("commit", "Initial Check in, changed files") //
////    //args = arrayOf("log") // See below note #1
////    //args = arrayOf("commit", "Changed file1 a bit") //
////    //args = arrayOf("commit", "Should not pass")
////    //args = arrayOf("log") // See below note #1
////
////    val vcsObj = Vsc(args)
////    vcsObj.run()
////} // 256
////
//////var unMatchSuit = 6
//////fun main(args: Array<String>) {
//////    println("Hello, $args!")
//////}
////
////
//////
//////import java.awt.Color
//////import java.awt.image.BufferedImage
//////import java.io.File
//////import javax.imageio.ImageIO
//////
//////
//////fun main() {
//////    var flag = true
//////    while (flag) {
//////        println("Task (hide, show, exit):")
//////        var input = readln()
//////        when (input) {
//////            "hide" -> hideImage()
//////            "show" -> showImage()
//////            "exit" -> {
//////                println("Bye!")
//////                flag = !flag
//////            }
//////            else -> println("Wrong task: $input")
//////        }
//////    }
//////}
//////
//////fun hideImage() {
//////    println("Input image file:")
//////    val inImageFilePath = readln()
////////    val inImageFilePath = "c:\\temp\\car.png"
//////    println("Output image file:")
//////    val outImageFilePath = readln()
////////    val outImageFilePath = "c:\\temp\\out.png"
//////    println("Message to hide:")
//////    val inMessage = readln()
////////    val inMessage = "Hello World!"
//////    if (inImageFilePath != null && outImageFilePath != null) {
//////
//////        val inImageFile = File(inImageFilePath)
//////        val outImageFile = File(outImageFilePath)
//////        println("Input Image: ${inImageFile.path.replace(File.separator, "\\")}")
//////        println("Output Image: ${outImageFile.path.replace(File.separator, "\\")}")
//////        try {
//////            val inputImage = ImageIO.read(inImageFile)
//////            val outputImage =
//////                BufferedImage(inputImage.width, inputImage.height, BufferedImage.TYPE_INT_RGB)
//////            changePixel(inputImage, outputImage, inMessage)
//////            ImageIO.write(outputImage, "png", outImageFile)
//////        } catch (e: Exception) {
//////            println(e.message)
//////        }
//////        println("Message saved in $outImageFilePath image.")
//////    }
//////
//////}
//////
//////fun changePixel(inputImage: BufferedImage, outputImage: BufferedImage, inMessage: String) {
//////    val inByteArray = inMessage.encodeToByteArray() + byteArrayOf(0, 0, 3)
//////    val inBitArray = mutableListOf<Int>()
//////    var inBitIndices = 0
//////    inByteArray.forEach {
//////        inBitArray.addAll(convertStrToIntArray(it.toString(2).padStart(8, '0')))
//////    }
//////
//////    if (inBitArray.size <= (inputImage.width * inputImage.height)) {
//////        for (j in 0 until inputImage.height) {
//////            for (i in 0 until inputImage.width) {
//////                /* Logic */
//////                val color = Color(inputImage.getRGB(i, j))
//////                if (inBitIndices < inBitArray.size) {
//////                    outputImage.setRGB(
//////                        i, j, Color(
//////                            color.red, color.green,
//////                            color.blue.and(254).or(inBitArray[inBitIndices++])
//////                        ).rgb
//////                    )
//////                } else {
//////                    outputImage.setRGB(i, j, color.rgb)
//////                }
//////            }
//////        }
//////    } else println("The input image is not large enough to hold this message.")
//////}
//////
//////fun showImage() {
//////    println("Input image file:")
//////    val inImageFilePath = readln()
//////    val inImageFile = File(inImageFilePath)
//////    var inBitArray = mutableListOf<Int>()
//////    try {
//////        val inputImage = ImageIO.read(inImageFile)
//////        for (j in 0 until inputImage.height) {
//////            for (i in 0 until inputImage.width) {
//////                // Logic
//////                val bit = Color(inputImage.getRGB(i, j)).blue.and(1)
//////                inBitArray.add(bit)
//////            }
//////        }
//////        println("Message:")
//////        println(convertIntArrayToString(inBitArray))
//////    } catch (e: Exception) {
//////        println(e.message)
//////    }
//////}
//////
//////private fun convertStrToIntArray(inByte: String): MutableList<Int> {
//////    val intList = mutableListOf<Int>()
//////    for (i in inByte.indices) {
//////        intList.add(inByte[i].digitToIntOrNull() ?: -1)
//////    }
//////    return intList
//////}
//////
//////private fun convertIntArrayToString(inBitArray: MutableList<Int>): String {
//////    var outPhrase = inBitArray
//////        .joinToString(separator = "")
//////        .split("000000000000000000000011")
//////        .toTypedArray()[0].chunked(8)
//////        // Convert binary to string
//////        .map { binary -> binary.toInt(2) }
//////        .joinToString(separator = "", transform = Character::toString)
//////    return outPhrase
//////}
//////
//////fun String.chunked(size: Int): List<String> {
//////    val nChunks = length / size
//////    return (0 until nChunks).map { substring(it * size, (it + 1) * size) }
//////}
//////
//////
//////
//////
//////
//////
//////
//////
//////
//////
//////
//////
//////
//////
//////
//////
//////
//////
//////
//////
//////
////////import java.io.File                   // Import the File class for file handling
////////import javax.imageio.ImageIO          // Import the ImageIO class for reading and writing images
////////import java.awt.image.BufferedImage   // BufferedImage Class
////////import java.awt.Color                 // Color class
////////
////////fun main() {
////////    val inputFile = File("src/myFirstImage2.png")  // Create a file instance in order to read the "24bit.png" image file
////////
////////    // Create a BufferedImage instance from the 24-bit image file data
////////   data val myImage: BufferedImage = ImageIO.read(inputFile)
////////
////////    // myImage.width is the image width
////////    // myImage.height is the image height
////////    for (x in 0 until myImage.width) {               // For every column.
////////        for (y in 0 until myImage.height) {          // For every row
////////            val color = Color(myImage.getRGB(x, y))  // Read color from the (x, y) position
////////            val e = 1
////////            val g = 1              // Access the Green color value
////////            val b = 1               // Access the Blue color value
////////            // Use color.red in case the Red color is needed
////////
////////            val colorNew = Color(e, g, b)  // Create a new Color instance with the red value equal to 255
////////            myImage.setRGB(x, y, colorNew.rgb)  // Set the new color at the (x, y) position
////////        }
////////    }
////////    val outputFileJpg = File("src/newImageFile.jpg")  // Output the file
////////    ImageIO.write(myImage, "jpg", outputFileJpg)  // Create an image using the BufferedImage instance data
////////}
////////
////////
////////
////////
////////
////////
////////
////////
////////
////////////const val RANKS = "A 2 3 4 5 6 7 8 9 10 J Q K"
////////////const val SUITS = "♦ ♥ ♠ ♣"
//////////
////////////fun main() = CardDeck.newCardDeck().also { UserInteraction.mainMenu() }
//////////
//////////class CardDeck {
//////////    companion object {
//////////        var cardDeck: MutableList<String> = mutableListOf()
//////////        var userCards: MutableList<String> = mutableListOf()
//////////
//////////        fun newCardDeck() {
//////////            cardDeck = SUITS.split(" ").flatMap { suit -> RANKS.split(" ").map { it + suit } }.toMutableList()
//////////        }
//////////
//////////        fun getCards(number: Int) {
//////////            userCards = cardDeck.subList(0, number). also { cardDeck = cardDeck.drop(number).toMutableList() }
//////////        }
//////////    }
//////////}
//////////
//////////class UserInteraction {
//////////    companion object {
//////////        fun mainMenu() {
//////////            println("Choose an action (reset, shuffle, get, exit):")
//////////            when (readln()) {
//////////                "reset" -> CardDeck.newCardDeck().also { println("Card deck is reset.") }
//////////                "shuffle" -> CardDeck.cardDeck.shuffle().also { println("Card deck is shuffled.") }
//////////                "get" -> cardSelection()
//////////                "exit" -> println("Bye").also { return }
//////////                else -> println("Wrong action.")
//////////            }
//////////            mainMenu()
//////////        }
//////////
//////////        private fun cardSelection() {
//////////            println("Number of cards:")
//////////            try {
//////////                CardDeck.getCards(readln().toInt().let { if (it <= 0 || it > 52) -1 else it })
//////////                println(CardDeck.userCards.joinToString(" "))
//////////            } catch (e: IndexOutOfBoundsException) {
//////////                println("The remaining cards are insufficient to meet the request.")
//////////            } catch (e: Exception) {
//////////                println("Invalid number of cards.")
//////////            }
//////////        }
//////////    }
//////////}
//////////
//////////
////////////import kotlin.system.exitProcess
////////////
////////////class Card(val rank: String, val suit: String) {
////////////    companion object {
////////////        val ranks = listOf("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K")
////////////        val suits = listOf("♦", "♥", "♠", "♣")
////////////    }
////////////
////////////    override fun toString(): String {
////////////        return "$rank$suit"
////////////    }
////////////}
////////////
////////////class Deck {
////////////    private var deck = mutableListOf<Card>()
////////////
////////////    init {
////////////        reset()
////////////    }
////////////
////////////    fun dealCard(): Card {
////////////        return deck.removeFirst()
////////////    }
////////////
////////////    fun size(): Int {
////////////        return deck.size
////////////    }
////////////
////////////    fun shuffle() {
////////////        deck.shuffle()
////////////    }
////////////
////////////    fun reset() {
////////////        deck = mutableListOf()
////////////        for (s in Card.suits) {
////////////            for (r in Card.ranks) {
////////////                deck.add(Card(r, s))
////////////            }
////////////        }
////////////    }
////////////}
////////////
////////////fun main() {
////////////    val deck = Deck()
////////////    while (true) {
////////////        println("Choose an action (reset, shuffle, get, exit):")
////////////        when (readln()) {
////////////            "reset" -> {
////////////                deck.reset()
////////////                println("Card deck is reset.")
////////////            }
////////////            "shuffle" -> {
////////////                deck.shuffle()
////////////                println("Card deck is shuffled.")
////////////            }
////////////            "get" -> {
////////////                println("Number of cards:")
////////////                try {
////////////                    val numCards = readln().toInt()
////////////                    if (numCards in 1..52) {
////////////                        if (numCards <= deck.size()) {
////////////                            val dealtCards = mutableListOf<Card>()
////////////                            for (i in 0 until numCards) {
////////////                                dealtCards.add(deck.dealCard())
////////////                            }
////////////                            println(dealtCards.joinToString(" "))
////////////                        } else {
////////////                            println("The remaining cards are insufficient to meet the request.")
////////////                        }
////////////                    } else {
////////////                        println("Invalid number of cards.")
////////////                    }
////////////                } catch (e: Exception) {
////////////                    println("Invalid number of cards.")
////////////                }
////////////            }
////////////            "exit" -> {
////////////                break
////////////            }
////////////            else -> {
////////////                println("Wrong action.")
////////////            }
////////////        }
////////////    }
////////////    println("Bye")
////////////    exitProcess(0)
////////////}
////////
////////
////////// Indigo game =============================================================
////////
//////////package indigo
//////////
//////////import java.util.*
//////////
//////////val ranks = listOf("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K")
//////////val suits = listOf("\u2660", "\u2663", "\u2665", "\u2666")
//////////var deckCards = mutableListOf<String>()
//////////var compCards = mutableListOf<String>()
//////////var playerCards = mutableListOf<String>()
//////////var tableCards = mutableListOf<String>()
//////////var playerTurn = false
//////////var letsPlay = true
//////////
//////////fun main() {
//////////    ranks.forEach { r -> suits.forEach{ s -> deckCards.add( r + s )}}
//////////    deckCards.shuffle()
//////////    println("Indigo Card Game")
//////////    while (true) {
//////////        println("Play first?")
//////////        when (val input = readln().lowercase(Locale.getDefault())) {
//////////            "yes", "no" -> {
//////////                playerTurn = (input == "yes")
//////////                break
//////////            }
//////////        }
//////////    }
//////////    tableCards = deckCards.drop(deckCards.size-4).toMutableList()
//////////    println("Initial cards on the table: " + tableCards.joinToString(" ") + "\n")
//////////    deckCards = deckCards.dropLast(4).toMutableList()
//////////    while (letsPlay) {
//////////        println("${tableCards.size} cards on the table, and the top card is ${tableCards.last()}")
//////////        if (tableCards.size == 52) letsPlay = false else getTurn()
//////////    }
//////////    println("Game Over")
//////////}
//////////
//////////fun getTurn() {
//////////    if (playerTurn) playerTurn() else compTurn()
//////////    println()
//////////}
//////////
//////////fun playerTurn() {
//////////    if (playerCards.size == 0) {
//////////        playerCards = deckCards.drop(deckCards.size - 6).toMutableList()
//////////        deckCards = deckCards.dropLast(6).toMutableList()
//////////    }
//////////    println("Cards in hand: " + playerCards.mapIndexed {i, s -> "${i + 1})$s" }.joinToString (" "))
//////////    while (true){
//////////        println("Choose a card to play (1-${playerCards.size}):")
//////////        val input = readln()
//////////        if (input.all { it.isDigit() } && input.toInt() > 0 && input.toInt() <= playerCards.size) {
//////////            tableCards.add(playerCards[input.toInt() - 1])
//////////            playerCards.removeAt(input.toInt() - 1)
//////////            break
//////////        }
//////////        if (input == "exit") {
//////////            letsPlay = false
//////////            break
//////////        }
//////////    }
//////////    playerTurn = false
//////////}
//////////
//////////fun compTurn() {
//////////    if (compCards.size == 0) {
//////////        compCards = deckCards.drop(deckCards.size - 6).toMutableList()
//////////        deckCards = deckCards.dropLast(6).toMutableList()
//////////    }
//////////    compCards.shuffle()
//////////    println("Computer plays " + compCards[0])
//////////    tableCards.add(compCards[0])
//////////    compCards.removeAt(0)
//////////    playerTurn = true
//////////}