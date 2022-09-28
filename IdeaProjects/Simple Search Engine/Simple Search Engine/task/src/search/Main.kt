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
