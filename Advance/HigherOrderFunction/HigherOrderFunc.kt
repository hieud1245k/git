fun main() {
    showMessage("Hello ", "World", {str: String -> println(str)})
 }
 
 fun showMessage(m : String, message: String, myFunc: (String) -> Any) {
     print(m)
     myFunc(message)
 }