package com.hieuminh.connectionandroid.utils

import java.io.InputStream
import java.io.Reader
import java.lang.Exception

class IOUtils {

    companion object {
        fun closeQuietly(inputStream : InputStream)  {
            try {
                inputStream.close()
            } catch (e: Exception) {}
        }

        fun closeQuietly(reader: Reader) {
            try {
                reader.close()
            } catch (e : Exception) {}
        }
    }
}