fun bill(priceList: Map<String, Int>, shoppingList: MutableList<String>): Int {
    var price = 0
    for (i in shoppingList) {
        price += if (priceList.containsKey(i)) {
            priceList[i]!!
        } else {
            0
        }
    }
    return price
}