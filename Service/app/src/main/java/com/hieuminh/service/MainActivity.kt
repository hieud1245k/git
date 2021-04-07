package com.hieuminh.service

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    lateinit var intentt: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        intentt = Intent(this@MainActivity, MyService::class.java)
    }

    fun startService(view: View) {
        startService(intentt)
    }
    fun stopService(view: View) {
        stopService(intentt)
    }
}