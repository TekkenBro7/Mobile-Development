package com.example.calculator.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculator.R
import com.example.calculator.utils.DialogHelper
import com.example.calculator.utils.LevelPopup
import com.example.calculator.utils.LevelSensor

class LevelActivity : AppCompatActivity() {
    private lateinit var sensorManager: LevelSensor
    private lateinit var levelPopup: LevelPopup
    private lateinit var tvAngle: TextView
    private lateinit var tvAccuracyMode: TextView
    private lateinit var btnClose: ImageButton
    private lateinit var btnToggleSensor: Button
    private lateinit var btnChangeAccuracy: Button
    private lateinit var btnAddToCalc: Button
    private lateinit var btnInfo: ImageButton
    private var isSensorPaused = false
    private var savedAngle: Float = 0f
    private val dialogHelper: DialogHelper by lazy { DialogHelper(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_level)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.levelLayout)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnClose = findViewById(R.id.btnClose)
        tvAngle = findViewById(R.id.tvAngle)
        tvAccuracyMode = findViewById(R.id.tvAccuracyMode)
        btnChangeAccuracy = findViewById(R.id.btnChangeAccuracy)
        btnAddToCalc = findViewById(R.id.btnAddToCalc)
        btnInfo = findViewById(R.id.btnInfo)
        btnToggleSensor = findViewById(R.id.btnToggleSensor)

        sensorManager = LevelSensor(this)
        sensorManager.tvAngle = tvAngle
        sensorManager.tvAccuracyMode = tvAccuracyMode

        levelPopup = LevelPopup(this)

        btnChangeAccuracy.setOnClickListener {
            sensorManager.toggleSensorAccuracy()
            isSensorPaused = false
        }

        btnInfo.setOnClickListener {
            levelPopup.showInfoPopup()
        }

        btnToggleSensor.setOnClickListener {
            if (isSensorPaused) {
                sensorManager.registerSensors()
                btnToggleSensor.text = "Остановить датчик"
                isSensorPaused = false
            } else {
                sensorManager.unregisterSensors()
                btnToggleSensor.text = "Возобновить датчик"
                isSensorPaused = true
            }
        }

        btnAddToCalc.setOnClickListener {
            savedAngle = sensorManager.currentAngle
            dialogHelper.showFunctionSelectionDialog(savedAngle) { selectedFunction ->
                val intent = Intent()
                intent.putExtra("FUNCTION_RESULT", selectedFunction)
                intent.putExtra("ANGLE_RESULT", savedAngle)
                setResult(RESULT_OK, intent)
                finish()
            }
        }

        btnClose.setOnClickListener {
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        sensorManager.registerSensors()
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterSensors()
    }
}