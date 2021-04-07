 open class Person(var fullName: String) {

    open fun toShow() : String {
        return "Name: " + this.fullName;
    }
}

class Student(var id:String, fullName: String): Person(fullName) {

    // override
    override fun toShow() : String {
        return super.toShow() + ", MSSV: " + this.id
    }
}

fun main() {
    var student = Student("Hieu Nguyen", "123");
    println(student.toShow())  
}
