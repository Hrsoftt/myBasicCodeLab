import java.io.File
import java.security.MessageDigest
const val FOLDER = "vcs"
const val LOG = "log"
private val LOG_FILE = File("$FOLDER/$LOG.txt")
const val COMMIT = "commit"
const val CHECKOUT = "checkout"
private val INDEX = File("$FOLDER/index.txt")
private const val COMMIT_FOLDER = "$FOLDER/commits"

fun info(map: Map<String, String>) {
    for (i in map) {
        println(i.key + (" ".repeat(12 - i.key.length)) + i.value)
    }
}
val map = mapOf(
    "config" to "Get and set a username.",
    "add" to "Add a file to the index.",
    "log" to "Show commit logs.",
    "commit" to "Save changes.",
    "checkout" to "Restore a file."
)
fun config(args: Array<String>){
    val configFile = File("$FOLDER/config.txt")
    try {
        configFile.writeText(args[1])
        println("The username is ${args[1]}.")
    }catch (e: Exception){
        if (configFile.length() == 0L){
            println("Please, tell me who you are.")
        }else{
            println("The username is ${configFile.readText()}.")
        }
    }

}
fun add(args: Array<String>){
    val addFile = File("vcs/index.txt")
    try {
        if (!File(args[1]).exists()){
            println("Can't find '${args[1]}'.")
        }else{
            addFile.appendText("${args[1]}\n")
            println("The file '${args[1]}' is tracked.")
        }
    }catch (e: Exception){
        if (addFile.length() == 0L){
            println("Add a file to the index.")
        }else{
            println("Tracked files:")
            println(addFile.readText())
        }
    }

}

fun getIndexFiles(): List<File>? {
    return if (INDEX.isFile) {
        val list = INDEX.readLines().map { File(it) }.filter { it.isFile }
        list.ifEmpty { null }
    } else null
}
fun getUserName(): String {
    val name = File("$FOLDER/config.txt").readText()
    if (name.isEmpty()) {
        error("??????")
    } else {
        return name
    }
}

fun log() = if (LOG_FILE.isFile) LOG_FILE.forEachLine { println(it) } else println("No commits yet.")

fun addLog(commit: String, message: String) {
    val previous = File("$FOLDER/temp.txt")
    val commitStr = "commit $commit\n"
    val authorStr = "Author: ${getUserName()}\n"

    if (LOG_FILE.isFile) LOG_FILE.copyTo(previous, true)
    LOG_FILE.writeText(commitStr + authorStr + "$message\n\n")
    if (previous.isFile) {
        previous.forEachBlock(DEFAULT_BUFFER_SIZE) { buffer, bytesRead ->
            LOG_FILE.appendBytes(buffer.copyOfRange(0, bytesRead))
        }
        previous.delete()
    }
}

fun lastLogCommit() = if (LOG_FILE.isFile) LOG_FILE.bufferedReader().use { it.readLine().split(" ").last() } else ""


fun commit(message: String) {
    var response = if (message.isEmpty()) "Message was not passed." else "Nothing to commit."

    if (message.isNotEmpty()) {
        getIndexFiles()?.let { files ->
            val hash = hashFiles(files)

            if (hash != lastLogCommit()) {
                addLog(hash, message)
                copyFiles(files, "$COMMIT_FOLDER/$hash")
                response = "Changes are committed."
            }
        }
    }
    println(response)
}

private fun hashFiles(files: List<File>): String {
    val hash: MessageDigest = MessageDigest.getInstance("SHA-256")

    files.forEach { file ->
        hash.update(file.name.toByteArray())
        file.forEachBlock(DEFAULT_BUFFER_SIZE) { buffer, bytesRead -> hash.update(buffer, 0, bytesRead) }
    }
    return hash.digest().joinToString("") { String.format("%02x", it) }
}

private fun copyFiles(files: List<File>, directory: String) {
    if (!File(directory).isDirectory) {
        files.forEach { file ->
            file.copyTo(File("$directory/$file"))
        }
    }
}

fun checkout(hash: String) = println(if (hash.isEmpty()) "Commit id was not passed." else revertToCommit(hash))

fun revertToCommit(hash: String): String {
    val directory = File("$COMMIT_FOLDER/$hash")

    return if (!directory.isDirectory) "Commit does not exist." else {
        directory.copyRecursively(File("./"), true)
        "Switched to commit $hash."
    }
}

fun main(args: Array<String>) {
    val dir = File("vcs")
    if (!dir.exists()) dir.mkdir()
    dir.resolve("config.txt").createNewFile()
    dir.resolve("index.txt").createNewFile()

    if (args.isEmpty()) {
        println("These are SVCS commands:")
        info(map)
    } else {
        when (args.first()) {
            "config" -> {
                config(args)
            }
            "add" -> {
                add(args)
            }
            "log" -> log()
            "commit" -> commit(args[1])
            "checkout" -> println(map[args[0]])
            "--help" -> {
                println("These are SVCS commands:")
                info(map)
            }
            else -> {
                println("'${args[0]}' is not a SVCS command.")
            }

        }
    }
}