package com.example.calculator.utils

import android.content.Context
import androidx.security.crypto.MasterKey
import androidx.security.crypto.EncryptedSharedPreferences

object PinUtils {
    private const val PREFS_NAME = "secure_prefs"
    private const val KEY_PIN = "pin_key"

    private fun getPrefs(context: Context) =
        EncryptedSharedPreferences.create(
            context,
            PREFS_NAME,
            MasterKey.Builder(context).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build(),
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )

    fun savePin(context: Context, pin: String) {
        getPrefs(context).edit().putString(KEY_PIN, pin).apply()
    }

    fun getPin(context: Context): String? {
        return getPrefs(context).getString(KEY_PIN, null)
    }

    fun clearPin(context: Context) {
        getPrefs(context).edit().remove(KEY_PIN).apply()
    }

    fun isPinCorrect(context: Context, enteredPin: String): Boolean {
        return getPin(context) == enteredPin
    }

    fun isPinSet(context: Context): Boolean {
        return getPin(context) != null
    }
}