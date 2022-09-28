package svcs

import java.io.File
import java.security.MessageDigest


class Version(private val args: Array<String>) {
    var param = ""

    init {
        param = try {
            args[1]
        } catch (e: Exception) {
            ""
        }

        vcsDir.mkdir()
        commitDir.mkdir()
        configFile.createNewFile()
        indexFile.createNewFile()
        logFile.createNewFile()
    }

    companion object {
        val vcsDir = File("vcs")
        val commitDir = File("vcs\\commits\\")
        val configFile = File("vcs\\config.txt")
        val indexFile = File("vcs\\index.txt")
        val logFile = File("vcs\\log.txt")
        var name = ""
    }

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

    private fun hash(string: String): String {
        val bytes = string.toByteArray()
        val md = MessageDigest.getInstance("SHA-256")
        val digest = md.digest(bytes)
        return digest.fold("") { str, it -> str + "%02x".format(it) }
    }


    private fun config(args: Array<String>) {
        val configFile = File("vcs/config.txt")
        try {
            configFile.writeText(args[1])
            println("The username is ${args[1]}.")
        } catch (e: Exception) {
            if (configFile.length() == 0L) {
                println("Please, tell me who you are.")
            } else {
                println("The username is ${configFile.readText()}.")
            }
        }

    }
    fun getUser(): String {
        val name = configFile.readText()
        if (name.isEmpty()) {
            error("??????")
        } else {
            return name
        }
    }

    private fun add(args: Array<String>) {
        val addFile = File("vcs/index.txt")
        try {
            if (!File(args[1]).exists()) {
                println("Can't find '${args[1]}'.")
            } else {
                addFile.appendText("${args[1]}\n")
                println("The file '${args[1]}' is tracked.")
                val a = File(args[1]).readText()
            }
        } catch (e: Exception) {
            if (addFile.length() == 0L) {
                println("Add a file to the index.")
            } else {
                println("Tracked files:")
                println(addFile.readText())
            }
        }

    }

    private fun commandLog() {
        val logLines = logFile.readText().trim()
        if (logLines.isEmpty()) {
            println("No commits yet.")
        } else {
            println("$logLines\n")
        }
    }

    private fun commit() {
        if (param == "") {
            println("Message was not passed.")
        } else {
            val trackedFiles = indexFile.readLines()
            if (trackedFiles.isEmpty()) {
                println("Nothing to commit.")
            } else {

                val foundChanges = checkForChanges()
                if (foundChanges) {
                    doCommit()
                    println("Changes are committed.")
                } else {
                    println("Nothing to commit.")
                }
            }
        }
    }

    private fun doCommit() {
        val commitId = commitId()
        val commitDirectory = "vcs\\commits\\"
        /* Create Commit Folder */
        File(commitDirectory + commitId).mkdir()
        val myFile = File(commitDirectory + commitId)
        myFile.createNewFile()

        /* Copy Files and Log */
        for (fileName in indexFile.readLines()) {
            val fileIn = File(fileName)
            val fileOut = File(commitDirectory + "$commitId\\$fileName")
            fileIn.copyTo(fileOut, overwrite = true)
        }
        val buffer = logFile.readText() // Purpose of buffer it is, so we can have the latest log on top

        logFile.writeText("commit $commitId\n")
        logFile.appendText("Author: ${getUser()}\n")
        logFile.appendText(param + "\n")
        logFile.appendText(buffer)
    }

    private fun checkForChanges(): Boolean {
        val commitDirIds = commitDir.listFiles()!!.map { it.name }
        if (commitDirIds.isEmpty()) {
            return true
        } else {
            val commitId = commitId()

            if (!commitDirIds.contains(commitId)) {
                return true
            }
        }
        return false
    }

    private fun commitId(): String {
        var textContent = ""
        val indexItems = indexFile.readLines()
        for (fileName in indexItems) {
            textContent += File(fileName).readText()
            textContent += fileName
        }
        return hash(textContent)
    }

    private fun checkOut(args: Array<String>){
        val commitDirIds = commitDir.listFiles()!!.map { it.name }
        try {
            if(commitDirIds.contains(args[1])){
                println("Switched to commit ${args[1]}.")
                val buffer = logFile.readText()
                logFile.writeText("commit ${args[1]}\n")
                logFile.appendText("Author: ${getUser()}\n")
                logFile.appendText(buffer)
            }else {
                println("Commit does not exist.")
            }
        }catch (e: Exception){
            println("Commit id was not passed.")
        }
    }

    fun run() {
        val dir = File("vcs")
        if (!dir.exists()) dir.mkdir()
        dir.resolve("config.txt").createNewFile()
        dir.resolve("index.txt").createNewFile()
        dir.resolve("commits").mkdir()

        if (args.isEmpty()) {
            println("These are SVCS commands:")
            info(map)
        } else {
            when (args.first()) {
                "config" -> config(args)
                "add" -> add(args)
                "log" -> commandLog()
                "commit" -> commit()
                "checkout" -> checkOut(args)
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
}

fun main(args: Array<String>) {
    val vsc = Version(args)
    vsc.run()
}







//
//import java.io.File
//const val VCS_DIR_NAME = "vcs"
//const val CONFIG_FILE_NAME = "config.txt"
//const val INDEX_FILE_NAME = "index.txt"
//val COMMANDS_HELP = mapOf(
//    "config" to "Get and set a username.",
//    "add" to "Add a file to the index.",
//    "log" to "Show commit logs.",
//    "commit" to "Save changes.",
//    "checkout" to "Restore a file.",
//)
//fun printHelp() {
//    println("These are SVCS commands:")
//    for ((commandName, helpLine) in COMMANDS_HELP) {
//        println("${commandName.padEnd(10)} $helpLine")
//    }
//}
//fun getVcsDir(): File {
//    val vcsDir = File(VCS_DIR_NAME)
//    if (!vcsDir.exists()) vcsDir.mkdir()
//    assert(vcsDir.isDirectory) { "cannot create '$VCS_DIR_NAME' directory - there's such file" }
//    return vcsDir
//}
//
//fun getVcsFile(fileName: String): File {
//    fun getVcsSettingsFile(fileName: String): File {
//        val file = getVcsDir().resolve(File(fileName))
//        if (!file.exists()) file.createNewFile()
//
//        assert(file.isFile) { "cannot create '$fileName' file - there's such directory in '$VCS_DIR_NAME'"}
//        return file
//    }
//
//    fun getConfigFile() = getVcsFile(CONFIG_FILE_NAME)
//    fun getConfigFile() = getVcsSettingsFile(CONFIG_FILE_NAME)
//
//    fun getIndexFile() = getVcsFile(INDEX_FILE_NAME)
//    fun getIndexFile() = getVcsSettingsFile(INDEX_FILE_NAME)
//
//    fun config(name: String?) {
//        val configFile = getConfigFile()
//        val nameInConfig = configFile.readText()
//        if (name == null && nameInConfig.isEmpty()) {
//            println("Please, tell me who you are.")
//        } else if (name == null) {
//            println("The username is $nameInConfig.")
//        } else {
//            configFile.writeText(name)
//            println("The username is $name.")
//        }
//    }
//    fun add(newFilename: String?) {
//        val indexFile = getIndexFile()
//        val filenamesInIndex = indexFile.readLines()
//        if (newFilename == null && filenamesInIndex.isEmpty()) {
//            println(COMMANDS_HELP["add"])
//        } else if (newFilename == null) {
//            println("Tracked files:")
//            filenamesInIndex.forEach(::println)
//        } else {
//            val newFile = File(newFilename)
//            if (newFile.exists()) {
//                indexFile.appendText("$newFilename\n")
//                println("The file '$newFilename' is tracked.")
//            } else {
//                println("Can't find '$newFilename'.")
//            }
//        }
//    }
//    fun log() = println(COMMANDS_HELP["log"])
//    fun commit() = println(COMMANDS_HELP["commit"])
//    fun checkout() = println(COMMANDS_HELP["checkout"])
//    fun main(args: Array<String>) {
//        val command = args.firstOrNull()
//        val argument = args.elementAtOrNull(1)
//        when (command) {
//            "--help", null -> printHelp()
//            "config" -> config(argument)
//            "add" -> add(argument)
//            "log" -> log()
//            "commit" -> commit()
//            "checkout" -> checkout()
//            else -> println("'$command' is not a SVCS command.")
//        }
//    }