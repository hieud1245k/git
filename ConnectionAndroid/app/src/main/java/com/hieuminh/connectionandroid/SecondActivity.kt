package com.hieuminh.connectionandroid

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.activity_second.view.*

class SecondActivity : AppCompatActivity() {

    companion object {
        val jsonURL = "https://raw.githubusercontent.com/DevTides/DogsApi/master/dogs.json"
        var imageURL = "https://raw.githubusercontent.com/DevTides/DogsApi/master/1.jpg"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        bt_download_json.setOnClickListener {
            downLoadJsonAndShow(it)
        }

        bt_dowload_image.setOnClickListener {
            downloadImageAndShow(it)
        }
    }

    private fun downloadImageAndShow(it: View?) {
        if(!checkInternetConnection())
            return
        var task = DownloadImageTask(iv_image)
        task.execute(imageURL)
    }

    private fun checkInternetConnection() : Boolean {
        var connManager  = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        var netWorkInfo = connManager.activeNetworkInfo
        if (netWorkInfo == null) {
            Toast.makeText(this, "No default network is currently active", Toast.LENGTH_LONG).show();
            return false;
        }

        if (!netWorkInfo.isConnected()) {
            Toast.makeText(this, "Network is not connected", Toast.LENGTH_LONG).show();
            return false;
        }

        if (!netWorkInfo.isAvailable()) {
            Toast.makeText(this, "Network not available", Toast.LENGTH_LONG).show();
            return false;
        }
        Toast.makeText(this, "Network OK", Toast.LENGTH_LONG).show();
        return true;
    }

    private fun downLoadJsonAndShow(view : View) {
        if(!checkInternetConnection())
            return

        var task = DownloadJsonTask(tv_json)

        task.execute(jsonURL)
    }
}