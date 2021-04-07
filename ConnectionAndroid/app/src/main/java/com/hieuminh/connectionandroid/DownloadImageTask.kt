package com.hieuminh.connectionandroid

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.util.Log
import android.widget.ImageView
import com.hieuminh.connectionandroid.utils.IOUtils
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL


class DownloadImageTask(private var imageView: ImageView) : AsyncTask<String?, Void?, Bitmap?>() {

    override fun onPostExecute(result: Bitmap?) {
        if (result != null) {
            imageView.setImageBitmap(result)
        } else {
            Log.e("MyMessage", "Failed to fetch data!")
        }
    }

    override fun doInBackground(vararg params: String?): Bitmap? {
        val imageUrl = params[0]
        var `in`: InputStream? = null
        try {
            val url = URL(imageUrl)
            val httpConn: HttpURLConnection = url.openConnection() as HttpURLConnection
            httpConn.requestMethod = "GET"
            httpConn.connect()
            val resCode: Int = httpConn.responseCode
            `in` = if (resCode == HttpURLConnection.HTTP_OK) {
                httpConn.inputStream
            } else {
                return null
            }
            return BitmapFactory.decodeStream(`in`)
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            `in`?.let { IOUtils.closeQuietly(it) }
        }
        return null
    }
}