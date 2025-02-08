package com.example.calculator.utils

import android.content.Intent
import android.widget.Toast
import androidx.biometric.BiometricPrompt
import com.example.calculator.activities.AuthActivity
import com.example.calculator.activities.LogoActivity

fun biometricAuth(activity: AuthActivity) {
    val biometricAuthPrompt = BiometricPrompt(activity, activity.executor,
        object : BiometricPrompt.AuthenticationCallback() {
            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)
                Toast.makeText(activity.applicationContext, "Ошибка авторизации: $errString", Toast.LENGTH_SHORT).show()
            }
            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                Toast.makeText(activity.applicationContext, "Авторизация успешна", Toast.LENGTH_SHORT).show()
                activity.startActivity(Intent(activity, LogoActivity::class.java))
                activity.finish()
            }
            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
                Toast.makeText(activity.applicationContext, "Авторизация неуспешна", Toast.LENGTH_SHORT).show()
            }
        })
    val authPromptInfo = BiometricPrompt.PromptInfo.Builder()
        .setTitle("Подтверждение биометрии")
        .setSubtitle("Приложите палец к сканеру")
        .setNegativeButtonText("Отмена")
        .build()
    biometricAuthPrompt.authenticate(authPromptInfo)
}

fun showBiometricConfirmationDialog(activity: AuthActivity, newPin: String) {
    val biometricPrompt = BiometricPrompt(activity, activity.executor,
        object : BiometricPrompt.AuthenticationCallback() {
            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)
                Toast.makeText(activity.applicationContext, "Ошибка авторизации: $errString", Toast.LENGTH_SHORT).show()
            }
            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                PinUtils.savePin(activity, newPin)
                activity.storedPin = newPin
                Toast.makeText(activity.applicationContext, "PIN обновлен успешно", Toast.LENGTH_SHORT).show()
            }
            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
                Toast.makeText(activity.applicationContext, "Авторизация неуспешна", Toast.LENGTH_SHORT).show()
            }
        })
    val promptInfo = BiometricPrompt.PromptInfo.Builder()
        .setTitle("Подтвердите смену PIN")
        .setSubtitle("Приложите палец к сканеру")
        .setNegativeButtonText("Отмена")
        .build()
    biometricPrompt.authenticate(promptInfo)
}

fun showPinWithUtils(activity: AuthActivity) {
    val biometricPrompt = BiometricPrompt(activity, activity.executor,
        object : BiometricPrompt.AuthenticationCallback() {
            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)
                Toast.makeText(activity.applicationContext, "Ошибка авторизации: $errString", Toast.LENGTH_SHORT).show()
            }
            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                activity.storedPin?.let { pin ->
                    Toast.makeText(activity.applicationContext, "PIN: $pin", Toast.LENGTH_SHORT).show()
                } ?: run {
                    Toast.makeText(activity.applicationContext, "PIN не установлен", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
                Toast.makeText(activity.applicationContext, "Авторизация неуспешна", Toast.LENGTH_SHORT).show()
            }
        })
    val promptInfo = BiometricPrompt.PromptInfo.Builder()
        .setTitle("Подтвердите свою личность")
        .setSubtitle("Приложите палец к сканеру")
        .setNegativeButtonText("Отмена")
        .build()
    biometricPrompt.authenticate(promptInfo)
}