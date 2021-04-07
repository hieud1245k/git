fun main() {
    val square : (Int) -> Int = { value -> value * value }
    val nine = square(3)
    println(nine)

    var doNothing :(Int) -> Int = {value -> value}
    println(doNothing(1))

    var sum : (Int , Int) -> Int = {a, b -> a + b}
    var result = sum(1,2)

    var a  : () -> Unit

    println(result)
    println(sum(2,4))
    println(sum.invoke(1,3))
}
