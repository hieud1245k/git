fun main() {
    doSomeThingWithNumber(1000, ::proccessWithResult)
}

fun doSomeThingWithNumber(number: Int, receive: (String?) -> Unit) {
    var result: String? = number.toString()
    println("ham dc goi")
    receive(result)
}

fun proccessWithResult(result: String?):Unit {
    println(result)
}