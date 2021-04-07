package com.hieuminh.connectionandroid

import android.os.AsyncTask
import android.util.Log
import android.widget.TextView
import com.hieuminh.connectionandroid.utils.IOUtils
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class DownloadJsonTask(private var textView: TextView) : AsyncTask<String, Void, String>() {

    override fun doInBackground(vararg params: String?): String {
        val textUrl = params[0]!!

        var `in`: InputStream? = null
        var br: BufferedReader? = null
        try {
            val url = URL(textUrl)
            val httpConn = url.openConnection() as HttpURLConnection
            httpConn.requestMethod = "GET"
            httpConn.connect()
            val resCode = httpConn.responseCode
            return if (resCode == HttpURLConnection.HTTP_OK) {
                `in` = httpConn.inputStream
                br = BufferedReader(InputStreamReader(`in`))
                val sb = StringBuilder()
                var s: String? = null
                while (br.readLine().also { s = it } != null) {
                    sb.append(s)
                    sb.append("\n")
                }
                sb.toString()
            } else {
                return ""
            }
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            `in`?.let { IOUtils.closeQuietly(it) }
            br?.let { IOUtils.closeQuietly(it) }
        }
        return ""
    }

    override fun onPostExecute(result: String?) {
        if(result  != null){
            this.textView.setText(result);
        } else{
            Log.e("MyMessage", "Failed to fetch data!");
        }
    }
}