import java.io.File
import java.security.MessageDigest

const val FOLDER = "vcs"
const val LOG = "log"
private val LOG_FILE = File("$FOLDER/$LOG.txt")
const val ADD = "add"
private val INDEX = File("$FOLDER/index.txt")
const val CONFIG = "config"
private val CONFIG_FILE = File("$FOLDER/$CONFIG.txt")
const val COMMIT = "commit"
const val CHECKOUT = "checkout"
private const val COMMIT_FOLDER = "$FOLDER/commits"
private const val HELP = "--help"
private const val MAX_SPACE = 11 // largest command length in HELP_MAP + 3
private val HELP_MAP = mapOf(
    CONFIG to "Get and set a username.",
    ADD to "Add a file to the index.",
    LOG to "Show commit logs.",
    COMMIT to "Save changes.",
    CHECKOUT to "Restore a file."
)

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
fun config(userName: String) {
    val name = if (userName.isNotEmpty()) {
        CONFIG_FILE.writeText(userName)
        userName
    } else getUserName()

    println(if (name.isEmpty()) "Please, tell me who you are." else "The username is $name.")
}

fun getUserName() = if (CONFIG_FILE.isFile) CONFIG_FILE.readText() else ""

fun help(command: String) {
    if (command.isEmpty() || command == HELP) {
        println("These are SVCS commands:")
        HELP_MAP.forEach { (command, description) ->
            println("$command${" ".repeat(MAX_SPACE - command.length)}$description")
        }
    } else {
        println(HELP_MAP.getOrDefault(command, "'$command' is not a SVCS command."))
    }
}

fun addToIndex(fileName: String) = if (fileName.isNotEmpty()) addFile(fileName) else printIndex()

fun getIndexFiles(): List<File>? {
    return if (INDEX.isFile) {
        val list = INDEX.readLines().map { File(it) }.filter { it.isFile }
        list.ifEmpty { null }
    } else null
}

private fun addFile(fileName: String) {
    if (File(fileName).isFile) {
        if (INDEX.isFile && INDEX.readLines().contains(fileName)) {
            println("$fileName is already added.")
        } else {
            INDEX.appendText("$fileName\n")
            println("The file '$fileName' is tracked.")
        }
    } else println("Can't find '$fileName'.")
}

private fun printIndex() {
    if (INDEX.isFile) {
        println("Tracked files:")
        print(INDEX.readText())
    } else help(ADD)
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


fun main(args: Array<String>) {
    val command = args.getOrNull(0) ?: ""
    val secondArgument = args.getOrNull(1) ?: ""
    val commands = listOf(CONFIG, ADD, COMMIT, LOG, CHECKOUT)

    if (!File(FOLDER).isDirectory && commands.contains(command)) File(FOLDER).mkdir()
    when (command) {
        CONFIG -> config(secondArgument)
        ADD -> addToIndex(secondArgument)
        COMMIT -> commit(secondArgument)
        LOG -> log()
        CHECKOUT -> checkout(secondArgument)
        else -> help(command)
    }
}