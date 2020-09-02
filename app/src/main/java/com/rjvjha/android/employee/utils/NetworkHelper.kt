package com.rjvjha.android.employee.utils

import android.content.Context
import com.rjvjha.android.employee.di.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkHelper @Inject constructor(
    @ApplicationContext private val context: Context ) {

    // will check for network connectivity
    fun isNetworkConnected() : Boolean = false

}