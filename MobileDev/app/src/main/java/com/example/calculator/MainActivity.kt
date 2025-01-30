package com.example.calculator

import android.graphics.Color
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.example.calculator.models.Calculator
import com.example.calculator.utils.ButtonHandlers
import net.objecthunter.exp4j.ExpressionBuilder
import net.objecthunter.exp4j.Expression
import kotlin.math.exp
import com.example.calculator.utils.CalculatorUtils
import com.example.calculator.utils.CalculatorUtils.areParenthesesBalanced
import com.example.calculator.utils.CalculatorUtils.toggleExtraColumn

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

    private  lateinit var toggleColumnButton: Button
    private lateinit var extraColumn: LinearLayout

    private lateinit var calculator: Calculator

    private lateinit var buttons: List<Button>

    private val buttonColorDisabled = Color.GRAY
    private  val buttonColorEnabled = Color.parseColor("#EE7002")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initViews()
        calculator = Calculator(expression, result, this)
        setupButtonListeners()
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
        expression.movementMethod = ScrollingMovementMethod()
        expression.isActivated = true
        expression.isPressed = true

        toggleColumnButton = findViewById(R.id.toggleColumnButton)
        extraColumn = findViewById(R.id.extra_column)

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
            sqrt
        )
    }

    private fun setupButtonListeners() {
        val buttons = mapOf(
            R.id.zero to "0", R.id.doublezero to "00", R.id.one to "1",
            R.id.two to "2", R.id.three to "3", R.id.four to "4",
            R.id.five to "5", R.id.six to "6", R.id.seven to "7",
            R.id.eight to "8", R.id.nine to "9", R.id.dot to "."
        )
        val operations = mapOf(
            R.id.add to "+", R.id.subtract to "-", R.id.multiply to "*",
            R.id.divide to "/", R.id.percent to "%", R.id.equal to "="
        )
        val functions = mapOf(
            R.id.clear to "clear", R.id.backSpace to "backspace",
            R.id.sin to "sin", R.id.cos to "cos", R.id.sqrt to "sqrt",
            R.id.leftscob to "(", R.id.rightscob to ")"
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
        }
    }
}