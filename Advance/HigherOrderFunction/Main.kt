
fun main() {
    fun add(x: Int, y : Int) = x + y
    var add2: (x: Int, y: Int) -> Int = {x, y -> x - y}

    var add3 = fun(x: Int, y: Int): Int{
        return x + y
    }
    add3(2,3)
    add3 = add2
 
    fun isOdd(x: Int) = x % 2 != 0
    fun isOdd(s: String) = s == "brillig" || s == "slithy" || s == "tove"

    val numbers = listOf(1, 2, 3)
    println(numbers.filter(::isOdd)) // refers to isOdd(x: Int) // [1, 3]

    var a = returnMeAddFunction() // a = Add(a,b)

    var b = ::add;

    println(add3(2,3))
    println(a(2,3)) // 5

    println(a.invoke(2,4))

    println(returnMeAddFunction().invoke(2, 7)) // 9

}

fun returnMeAddFunction(): ((Int, Int) -> Int) {
    return ::add
}

fun add(a: Int, b: Int) : Int = a + b

// companion : kotlin = static : java