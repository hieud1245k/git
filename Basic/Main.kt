fun main() {
    println("Kotlin is interesting.")
    var fullName : String = "Hieu Nguyen"
    println(fullName)

    
}


// Khai bao bien
// var [tênBiến]: [kiểuDữLiệu] = [giáTrịKhởiTạo]

// Khai bao constant
// val PI = 3.14
// val aLongValue = 1_000L

// Để khai báo một biến có thể null hay không, ta thêm dấu chấm hỏi (?) vào sau kiểu dữ liệu:
// var canBeNull: String? = "SomeString" // Biến này có thể null
// var cannotBeNull: String = "SomeString"

// canBeNull = null // Không lỗi vì biến này có thể null
// cannotBeNull = null // IDE sẽ báo lỗi ngay lập tức

// Elvis Operator: kie, tra null va gan gia tri
// var someThing = canBeNull ?: "some default string"

