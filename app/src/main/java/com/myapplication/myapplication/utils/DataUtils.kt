package com.myapplication.myapplication.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

class DataUtils {

    companion object { // Equivalent of static

        fun isInternetAvailable(context: Context): Boolean {
            return getConnectionStatus(context) == NetworkStatusCodes.NET_CONNECTED
        }

        fun getConnectionStatus(context: Context): Int {
            val conMgr = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = conMgr.activeNetworkInfo
            if (networkInfo != null && networkInfo.isAvailable) {
                if (networkInfo.isConnected) {
                    return NetworkStatusCodes.NET_CONNECTED
                } else if (networkInfo.state == NetworkInfo.State.CONNECTING) {
                    return NetworkStatusCodes.NET_CONNECTING
                }
            }
            return NetworkStatusCodes.NET_DISCONNECTED
        }
    }
}