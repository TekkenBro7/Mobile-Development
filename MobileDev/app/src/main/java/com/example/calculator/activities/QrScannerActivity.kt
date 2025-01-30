package com.example.calculator.activities

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Intent
import android.content.pm.ActivityInfo
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculator.R
import com.google.zxing.integration.android.IntentIntegrator

import com.journeyapps.barcodescanner.CaptureActivity

class CaptureActivityPortrait : CaptureActivity()

class QrScannerActivity : AppCompatActivity() {
    private lateinit var resultEditText: EditText
    private lateinit var scanButton: Button
    private lateinit var copyButton: Button
    private lateinit var btnOpenMain: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_qrscanner)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        resultEditText = findViewById(R.id.resultEditText)
        scanButton = findViewById(R.id.scanButton)
        copyButton = findViewById(R.id.copyButton)
        btnOpenMain = findViewById(R.id.btnOpenMain)
        scanButton.setOnClickListener {
            startQrScan()
        }
        copyButton.setOnClickListener {
            copyToClipboard(resultEditText.text.toString())
        }
        btnOpenMain.setOnClickListener {
            finish()
        }
    }
    private fun startQrScan() {
        val integrator = IntentIntegrator(this)
        integrator.setPrompt("Сканируйте QR-код")
        integrator.setBeepEnabled(true)
        integrator.setCameraId(0)
        integrator.setCaptureActivity(CaptureActivityPortrait::class.java)
        integrator.initiateScan()
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents == null) {
                Toast.makeText(this, "Сканирование отменено", Toast.LENGTH_SHORT).show()
            } else {
                resultEditText.setText(result.contents)
                if (isValidUrl(result.contents)) {
                    openUrl(result.contents)
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
    private fun isValidUrl(url: String): Boolean {
        return try {
            Uri.parse(url)
            true
        } catch (e: Exception) {
            false
        }
    }
    private fun openUrl(url: String) {
        try {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(this, "Невозможно открыть ссылку", Toast.LENGTH_SHORT).show()
        }
    }
    private fun copyToClipboard(text: String) {
        val clipboard = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("QR Result", text)
        clipboard.setPrimaryClip(clip)
        Toast.makeText(this, "Скопировано в буфер обмена", Toast.LENGTH_SHORT).show()
    }
}