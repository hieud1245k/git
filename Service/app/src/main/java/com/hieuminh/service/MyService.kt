package com.hieuminh.service

import android.app.AlertDialog
import android.app.Dialog
import android.app.Service
import android.content.Intent
import android.os.CountDownTimer
import android.os.IBinder
import android.widget.Toast
import java.lang.UnsupportedOperationException

class MyService : Service() {

    companion object {
        var count = 0
    }
    var timer: CountDownTimer? = null

    override fun onCreate() {
        super.onCreate()
        Toast.makeText(applicationContext, "Service is started", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        Toast.makeText(applicationContext, "Service is destroyed", Toast.LENGTH_SHORT).show()
        timer?.cancel()
        super.onDestroy()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        timer = object : CountDownTimer(3000000,1000) {
            override fun onTick(millisUntilFinished: Long) {
                Toast.makeText(applicationContext, "Service is starting ${count++}", Toast.LENGTH_SHORT).show()
            }

            override fun onFinish() {
                Toast.makeText(applicationContext, "Service finish count number", Toast.LENGTH_SHORT).show()
            }
        }.apply { start() }

        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent): IBinder {
        throw UnsupportedOperationException("Not yet implemented")
    }
}