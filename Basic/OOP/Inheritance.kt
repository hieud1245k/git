open class Person {

    private var name: String = ""
    protected var age : Int = 0
    public var identityCard: String = ""
    constructor(name: String, age: Int, identityCard: String) {
        this.age = age
        this.name = name
        this.identityCard = identityCard
    }

    protected fun toShow() : String {
        return "Name: " + this.name + ", Age: " + this.age + ", Indentity card: " + this.identityCard
    }

}

class Student(var name: String, age: Int, identityCard: String): Person(name,age,identityCard) {

    override fun toString(): String {
        return toShow()
    }
}

fun main() {
   var student = Student("hieu", 20, "102")
   println(student.toString())
}
