package org.themoviedb.app.util

import android.content.Context
import android.net.ConnectivityManager

/**
 * Created by Andre on 11/09/17.
 */
object AppUtil {

    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

}