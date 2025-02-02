package com.example.calculator.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar


fun isInternetAvailable(context: Context): Boolean {
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork = connectivityManager.activeNetworkInfo
    return activeNetwork != null && activeNetwork.isConnected
}

fun showNoInternetMessage(context: Context) {
    Handler(Looper.getMainLooper()).postDelayed({
        Toast.makeText(context, "Нет подключения к интернету", Toast.LENGTH_LONG).show()
    }, 1000)
}