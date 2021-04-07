package com.hieuminh.connectionandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.File
import java.io.FileInputStream
import java.io.IOException
import java.io.InputStream


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var json : String? = null
        try {

            var inputStream = assets.open("user_profile.json")
            var size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, charset("UTF-8"))
        } catch (e : IOException) {
            e.printStackTrace()
        }

        var jsonObject : JSONObject = JSONObject(json)

        var name : String = jsonObject.getString("name")
        var userId : String = jsonObject.getString("user_id")
        var role : String = jsonObject.getString("role")

        tv_userId.setText(userId)
        tv_name.setText(name)
        tv_role.setText(role)
    }
}