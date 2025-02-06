package com.example.calculator.activities

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculator.R
import com.example.calculator.models.Calculator
import com.example.calculator.utils.ButtonHandlers
import com.example.calculator.utils.CalculatorUtils.toggleExtraColumn
import com.google.firebase.FirebaseApp
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {
    private  lateinit var  expression: TextView
    private  lateinit var  result: TextView
    private  lateinit var  clear: Button
    private  lateinit var  backSpace: Button
    private  lateinit var  percent: Button
    private  lateinit var  divide: Button
    private  lateinit var  multiply: Button
    private  lateinit var  add: Button
    private  lateinit var  subtract: Button
    private  lateinit var  equal: Button
    private  lateinit var  dot: Button
    private  lateinit var  zero: Button
    private  lateinit var  doubleZero: Button
    private  lateinit var  one: Button
    private  lateinit var  two: Button
    private  lateinit var  three: Button
    private  lateinit var  four: Button
    private  lateinit var  five: Button
    private  lateinit var  six: Button
    private  lateinit var  seven: Button
    private  lateinit var  eight: Button
    private  lateinit var  nine: Button
    private  lateinit var  leftscob: Button
    private  lateinit var  rightscob: Button
    private  lateinit var  sin: Button
    private  lateinit var  cos: Button
    private  lateinit var  sqrt: Button
    private  lateinit var  e: Button
    private  lateinit var  ln: Button
    private  lateinit var  tg: Button
    private  lateinit var  ctg: Button
    private  lateinit var  pi: Button

    private  lateinit var toggleColumnButton: ImageButton
    private lateinit var extraColumn: LinearLayout
    private lateinit var extraColumn2: LinearLayout

    private lateinit var calculator: Calculator

    private lateinit var buttons: List<Button>
    private lateinit var levelButton: Button
    private lateinit var historyButton: Button
    private lateinit var qrButton: Button
    private lateinit var buttonTheme: Button


    private val buttonColorDisabled = Color.GRAY
    private  val buttonColorEnabled = Color.parseColor("#EE7002")

    companion object {
        private const val REQUEST_ANGLE = 1
        private const val REQUEST_HISTORY = 2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        FirebaseApp.initializeApp(this)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initViews()
        calculator = Calculator(expression, result, this)
        setupButtonListeners()


        buttonTheme = findViewById(R.id.button_theme)
//        buttonTheme.setOnClickListener {
//            showThemeSelectionDialog(this) { theme ->
//                changeTheme(theme)
//            }
//        }


        FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w("FCM", "Ошибка получения токена", task.exception)
                return@addOnCompleteListener
            }
            val token = task.result
            Log.d("FCM", "Токен устройства: $token")
        }
        FirebaseMessaging.getInstance().subscribeToTopic("news")
            .addOnCompleteListener { task ->
                var msg = "Подписка успешна"
                if (!task.isSuccessful) {
                    msg = "Подписка не удалась"
                }
                Log.d("FCM", msg)
        }
    }

    fun setButtonsEnabled(enabled: Boolean) {
        val color = if (!enabled) buttonColorEnabled else buttonColorDisabled
        buttons.forEach { button ->
            button.isEnabled = !enabled
            button.setTextColor(color)
        }
    }

    private fun initViews() {
        expression = findViewById(R.id.expression)
        expression.isActivated = true
        expression.isPressed = true

        toggleColumnButton = findViewById(R.id.toggleColumnButton)
        extraColumn = findViewById(R.id.extra_column)
        extraColumn2 = findViewById(R.id.extra_column2)

        result = findViewById(R.id.result)
        clear = findViewById(R.id.clear)
        backSpace = findViewById(R.id.backSpace)
        percent = findViewById(R.id.percent)
        divide = findViewById(R.id.divide)
        multiply = findViewById(R.id.multiply)
        add = findViewById(R.id.add)
        subtract = findViewById(R.id.subtract)
        equal = findViewById(R.id.equal)
        dot = findViewById(R.id.dot)
        zero = findViewById(R.id.zero)
        doubleZero = findViewById(R.id.doublezero)
        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three = findViewById(R.id.three)
        four = findViewById(R.id.four)
        five = findViewById(R.id.five)
        six = findViewById(R.id.six)
        seven = findViewById(R.id.seven)
        eight = findViewById(R.id.eight)
        nine = findViewById(R.id.nine)
        leftscob = findViewById(R.id.leftscob)
        rightscob = findViewById(R.id.rightscob)
        sin = findViewById(R.id.sin)
        cos = findViewById(R.id.cos)
        sqrt = findViewById(R.id.sqrt)
        e = findViewById(R.id.e)
        ln = findViewById(R.id.ln)
        tg = findViewById(R.id.tg)
        ctg = findViewById(R.id.ctg)
        pi = findViewById(R.id.pi)

        buttons = listOf(
            backSpace,
            percent,
            divide,
            multiply,
            add,
            subtract,
            leftscob,
            rightscob,
            sin,
            cos,
            sqrt,
            e,
            ln,
            tg,
            ctg
        )
        levelButton = findViewById(R.id.levelButton)
        historyButton = findViewById(R.id.history)
        qrButton = findViewById(R.id.QrButton)
    }

    private fun setupButtonListeners() {
        val buttons = mapOf(
            R.id.zero to "0", R.id.doublezero to "00", R.id.one to "1",
            R.id.two to "2", R.id.three to "3", R.id.four to "4",
            R.id.five to "5", R.id.six to "6", R.id.seven to "7",
            R.id.eight to "8", R.id.nine to "9", R.id.dot to ".",
            R.id.pi to "π", R.id.e to "e"
        )
        val operations = mapOf(
            R.id.add to "+", R.id.subtract to "-", R.id.multiply to "*",
            R.id.divide to "/", R.id.percent to "%", R.id.equal to "="
        )
        val functions = mapOf(
            R.id.clear to "clear", R.id.backSpace to "backspace",
            R.id.sin to "sin", R.id.cos to "cos", R.id.sqrt to "sqrt",
            R.id.leftscob to "(", R.id.rightscob to ")", R.id.tg to "tg",
            R.id.ctg to "ctg", R.id.ln to "ln"
        )
        buttons.forEach { (id, value) ->
            findViewById<Button>(id)?.let { ButtonHandlers.setNumberButtonListener(it, calculator, value) }
        }
        operations.forEach { (id, value) ->
            findViewById<Button>(id)?.let { ButtonHandlers.setOperationButtonListener(it, calculator, value) }
        }
        functions.forEach { (id, value) ->
            findViewById<Button>(id)?.let { ButtonHandlers.setFunctionButtonListener(it, calculator, value) }
        }
        toggleColumnButton.setOnClickListener {
            toggleExtraColumn(extraColumn)
            toggleExtraColumn(extraColumn2)
        }
        levelButton.setOnClickListener {
            val intent = Intent(this, LevelActivity::class.java)
            startActivityForResult(intent, REQUEST_ANGLE)
        }
        qrButton.setOnClickListener {
            val intent = Intent(this, QrScannerActivity::class.java)
            startActivity(intent)
        }
        historyButton.setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java)
            startActivityForResult(intent, REQUEST_HISTORY)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            REQUEST_ANGLE -> {
                if (resultCode == RESULT_OK) {
                    val functionResult = data?.getStringExtra("FUNCTION_RESULT")
                    val expressionText = expression.text.toString()
                    if (functionResult != null) {
                        if (expressionText == "0")
                            expression.text = "$functionResult"
                        else
                            expression.text = "${expressionText}$functionResult"
                    }
                }
            }
            REQUEST_HISTORY -> {
                if (resultCode == RESULT_OK) {
                    val expressionText = data?.getStringExtra("expression")
                    val resultText = data?.getStringExtra("result")

                    if (!expressionText.isNullOrEmpty() && !resultText.isNullOrEmpty()) {
                        expression.text = expressionText
                        result.text = resultText
                    } else {
                        expression.text = "0"
                    }
                }
            }
        }
    }
}