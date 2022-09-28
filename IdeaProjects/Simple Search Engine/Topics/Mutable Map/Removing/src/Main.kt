fun removing(currentMap: MutableMap<Int, String>, value: String): MutableMap<Int, String> {
    val resultingMap = mutableMapOf<Int, String>()
    currentMap.forEach { (key, _value) ->
        if (_value != value) {
            resultingMap[key] = _value
        }
    }
    return resultingMap
}