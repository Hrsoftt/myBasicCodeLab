package search

fun main() {
    println("Enter the number of people:")
    val noOfPeople = readln().toInt()
    println("Enter all people:")
    val people = MutableList(noOfPeople) { readln() }
    println("Enter the number of search queries:")
    val noOfQueries = readln().toInt()
    val findName = mutableListOf<String>()
    for (i in 1..noOfQueries) {
        println("Enter data to search people:")
        val searchName = readln()
        val (match, nonMatch) = people.partition { it.contains(searchName, true) }
        if (match.isNotEmpty()) {
            println("People found:")
            println(match.joinToString("\n"))
        } else {
            println("No matching people found.")
        }
//        people.forEach { list ->
//            if (list.replace(",", "").trim().contains(searchName, ignoreCase = true)) {
//                findName.add(list)
//            }
//        }
//        for (name in people){
//            if (name.contains(searchName, true)){
//                findName.add(name)
//            }
//        }
//        if (findName.isNotEmpty()){
//            println("People found:")
//            println(findName.joinToString("\n"))
//            findName.clear()
//        }else{
//           println("No matching people found.")
//        }
    }
}

[19, 6, 5], [19, 6, 5, 10], [19, 6, 3, 5], [6, 9, 5, 19], [9, 19, 5, 6], [5, 6, 2, 19, 1], [6, 19, 1, 2, 5]

Process finished with exit code 0
