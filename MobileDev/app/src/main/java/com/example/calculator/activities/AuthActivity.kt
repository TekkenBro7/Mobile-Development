package com.example.calculator.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculator.R
import com.example.calculator.databinding.ActivityAuthBinding
import com.example.calculator.utils.PinUtils
import com.example.calculator.utils.biometricAuth
import com.example.calculator.utils.showBiometricConfirmationDialog
import com.example.calculator.utils.showPinWithUtils
import java.util.concurrent.Executor

private const val SHIFT = 3
private const val KEY_NAME = "pin_key"

class AuthActivity : AppCompatActivity() {

    lateinit var binding : ActivityAuthBinding
    lateinit var executor: Executor

    lateinit var pinInputTextView: TextView
    val MAX_PIN_LENGTH = 4
    var storedPin: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        pinInputTextView = findViewById(R.id.pinInputTextView)
        executor = ContextCompat.getMainExecutor(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        loadStoredPin()
    }
    fun biometricAuth(view: View) {
        biometricAuth(this)
    }
    fun showPin(view: View) {
        showPinWithUtils(this)
    }
    private fun loadStoredPin() {
        storedPin = PinUtils.getPin(this)
    }
    fun appendDigit(view: View) {
        if (pinInputTextView.text.length < MAX_PIN_LENGTH) {
            val digit = (view as Button).text
            pinInputTextView.append(digit)
        }
    }
    fun deleteDigit(view: View) {
        val pin = pinInputTextView.text.toString()
        if (pin.isNotEmpty()) {
            pinInputTextView.text = pin.dropLast(1)
        }
    }
    fun deleteAll(view: View) {
        pinInputTextView.text = ""
    }
    fun setPin(view: View) {
        val enteredPin = pinInputTextView.text.toString()
        if (enteredPin.length == MAX_PIN_LENGTH) {
            if (storedPin == null) {
                PinUtils.savePin(this, enteredPin)
                Toast.makeText(this, "PIN-код сохранен!", Toast.LENGTH_SHORT).show()
                storedPin = enteredPin
            } else {
                showBiometricConfirmationDialog(this, enteredPin)
            }
            deleteAll(view)
        } else {
            Toast.makeText(this, "PIN-код должен содержать $MAX_PIN_LENGTH цифры!", Toast.LENGTH_SHORT).show()
        }
    }
    fun login(view: View) {
        val enteredPin = pinInputTextView.text.toString()
        if (storedPin == null) {
            Toast.makeText(this, "Сначала установите PIN-код!", Toast.LENGTH_SHORT).show()
            return
        }
        else if (PinUtils.isPinCorrect(this, enteredPin)) {
            Toast.makeText(this, "Успешный вход!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, LogoActivity::class.java))
            finish()
        } else {
            Toast.makeText(this, "Неверный PIN!", Toast.LENGTH_SHORT).show()
        }
    }
}