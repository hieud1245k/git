class Location(var wards: String,var  district: String, var province: String) {
    // var address : String = ""
    // get() = "Adrdess: " + wards + "-" + district + "-" + province + field
    // set(value) {
    //     var words = value.split(",")
    //     wards = words[0]
    //     field = value
    //     district = words[1]
    //     province = words[2]
    // }
}

val Location.address : String
    get() = "Adrdess: " + this.toString()
 

//     var Location.idInOut : String
//     get() = "$id + $name"
//     set(value) {
//         var words = value.split(",")
//         wards = words[0]
//         district = words[1]
//         province = words[2]
//     }

// override fun get

fun main() {
    var location = Location("a","b","c")
    location.address = "Binh Son, Hiep Duc, Quang Nam"
    println(location.address)
    println(location.wards)
    println(location.district)
    println(location.province)
}

