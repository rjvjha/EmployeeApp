package com.rjvjha.android.employee.utils.common

import android.content.Context
import java.io.File

object FileUtils {

    fun getDirectory(context: Context, dirName: String): File {
        val file = File(context.filesDir.path + File.separator + dirName)
        if (!file.exists()) file.mkdir()
        return file
    }

}