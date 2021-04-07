package com.hieuminh.broadcastrecevice

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var action = "com.hieuminh.broadcastreceive.SEND"

    lateinit var receive : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        receive = tv_receive
        var filter = IntentFilter(action)
        registerReceiver(broadCast, filter)
    }

    private var broadCast  = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            var bundle = intent!!.extras
            var text = bundle!!.getString("key")
            receive.text = text
        }
    }
}
