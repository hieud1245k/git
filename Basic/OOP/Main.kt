fun main() {
    println(sum(3,4))
    println(sum(3,4,5))
}

// overloading
fun sum(a: Int, b:Int): Int {
    return a + b
}

fun sum(a: Int, b: Int, c: Int): Int {
    return a + b + c
}
