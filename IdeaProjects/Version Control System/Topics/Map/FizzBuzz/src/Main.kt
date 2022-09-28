fun iterator(map: Map<String, Int>) {
    for (i in map.values) {
        if (i % 3 == 0) {
            println("Fizz")
        } else if (i % 5 == 0) {
            println("Buzz")
        } else {
            println("FizzBuzz")
        }
    }
}