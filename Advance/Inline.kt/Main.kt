fun main(){
    doSomeThing()
}

fun doSomeThing() {
    println("Text 1")
    doSomethingElse({
        println("Hello")
        //return //error: 'return' is not allowed here
    })
    println("Text 2")
}

inline fun doSomethingElse(
    crossinline abc: () -> Unit
) {
    abc()
}

fun doSomething() {
    print("doSomething start")
    doSomethingElse()
    print("doSomething end")
}

inline fun doSomethingElse() {
    print("doSomethingElse")
}
