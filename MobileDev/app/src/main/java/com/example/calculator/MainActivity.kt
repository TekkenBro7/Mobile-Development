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
import net.objecthunter.exp4j.ExpressionBuilder
import net.objecthunter.exp4j.Expression
import kotlin.math.exp

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
    private var isColumnVisible = false

    private var isCalculationComplete = false
    private var hasLettersInResult = false
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
        expression = findViewById(R.id.expression)
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

        expression.movementMethod = ScrollingMovementMethod()
        expression.isActivated = true
        expression.isPressed = true
        var str:String

        toggleColumnButton = findViewById(R.id.toggleColumnButton)
        extraColumn = findViewById(R.id.extra_column)
        toggleColumnButton.setOnClickListener {
            toggleExtraColumn()
        }

        clear.setOnClickListener {
            expressionText("0")
            expression.textSize = 60F
            result.textSize = 30F
            resultText()

            hasLettersInResult = false
            setButtonsEnabled(hasLettersInResult)
        }
        backSpace.setOnClickListener {
            if (expression.text.toString().isNotEmpty() && expression.text.toString() != "0") {
                if(expression.text.toString().length == 1) {
                    str = "0"
                    expressionText(str)
                    resultText()
                }
                else {
                    val lastIndex = expression.text.toString().lastIndex
                    str = expression.text.toString().substring(0, lastIndex)
                    expressionText(str)
                    resultText()
                }
            }
        }
        percent.setOnClickListener {
            if (isCalculationComplete) {
                expression.textSize = 60F
                result.textSize = 30F
                isCalculationComplete = false
                str = result.text.toString().substring(1) + "%"
                expressionText(str)
            } else {
                if (expression.text.toString().endsWith("%") || expression.text.toString()
                        .endsWith("/") || expression.text.toString()
                        .endsWith("*") || expression.text.toString()
                        .endsWith("+") || expression.text.toString()
                        .endsWith("-") || expression.text.toString().endsWith(".")
                ) {
                    str = expression.text.toString()
                    expressionText(str)
                } else {
                    str = expression.text.toString() + "%"
                    expressionText(str)
                }
            }
        }
        divide.setOnClickListener {
            if (isCalculationComplete) {
                expression.textSize = 60F
                result.textSize = 30F
                isCalculationComplete = false
                str = result.text.toString().substring(1) + "/"
                expressionText(str)
            } else {
                if (expression.text.toString().endsWith("%") || expression.text.toString()
                        .endsWith("/") || expression.text.toString()
                        .endsWith("*") || expression.text.toString()
                        .endsWith("+") || expression.text.toString()
                        .endsWith("-") || expression.text.toString().endsWith(".")
                ) {
                    str = expression.text.toString()
                    expressionText(str)
                } else {
                    str = expression.text.toString() + "/"
                    expressionText(str)
                }
            }
        }
        multiply.setOnClickListener {
            if (isCalculationComplete) {
                expression.textSize = 60F
                result.textSize = 30F
                isCalculationComplete = false
                str = result.text.toString().substring(1) + "*"
                expressionText(str)
            } else {
                if (expression.text.toString().endsWith("%") || expression.text.toString()
                        .endsWith("/") || expression.text.toString()
                        .endsWith("*") || expression.text.toString()
                        .endsWith("+") || expression.text.toString()
                        .endsWith("-") || expression.text.toString().endsWith(".")
                ) {
                    str = expression.text.toString()
                    expressionText(str)
                } else {
                    str = expression.text.toString() + "*"
                    expressionText(str)
                }
            }
        }
        add.setOnClickListener {
            if (isCalculationComplete) {
                expression.textSize = 60F
                result.textSize = 30F
                isCalculationComplete = false
                str = result.text.toString().substring(1) + "+"
                expressionText(str)
            } else {
                if (expression.text.toString().endsWith("%") || expression.text.toString().endsWith("/") || expression.text.toString().endsWith("*") || expression.text.toString().endsWith("+") || expression.text.toString().endsWith("-") || expression.text.toString().endsWith(".")) {
                    str = expression.text.toString()
                    expressionText(str)
                } else {
                    str = expression.text.toString() + "+"
                    expressionText(str)
                }
            }
        }
        subtract.setOnClickListener {
            if (isCalculationComplete) {
                expression.textSize = 60F
                result.textSize = 30F
                isCalculationComplete = false
                str = result.text.toString().substring(1) + "-"
                expressionText(str)
            } else {
                if (expression.text.toString().endsWith("%") || expression.text.toString()
                        .endsWith("/") || expression.text.toString()
                        .endsWith("*") || expression.text.toString()
                        .endsWith("+") || expression.text.toString()
                        .endsWith("-") || expression.text.toString().endsWith(".")
                ) {
                    str = expression.text.toString()
                    expressionText(str)
                } else {
                    str = expression.text.toString() + "-"
                    expressionText(str)
                }
            }
        }
        equal.setOnClickListener {
            expression.textSize = 30F
            result.textSize = 60F
            isCalculationComplete = true

            val resultText = result.text.toString()
            hasLettersInResult = resultText.any { it.isLetter() }

            setButtonsEnabled(hasLettersInResult)
        }
        dot.setOnClickListener {
            if (isCalculationComplete) {
                expression.textSize = 60F
                result.textSize = 30F
                isCalculationComplete = false
                str = "0."
                result.text = "=0"
                expressionText(str)
            }
            else {
                if (expression.text.toString().endsWith("%") || expression.text.toString()
                        .endsWith("/") || expression.text.toString()
                        .endsWith("*") || expression.text.toString()
                        .endsWith("+") || expression.text.toString()
                        .endsWith("-") || expression.text.toString().endsWith(".")
                ) {
                    str = expression.text.toString()
                    expressionText(str)
                } else {
                    str = expression.text.toString() + "."
                    expressionText(str)
                }
            }
        }
        zero.setOnClickListener {
            if (isCalculationComplete) {
                expression.textSize = 60F
                result.textSize = 30F
                isCalculationComplete = false
                str = "0"
                expressionText(str)
                resultText()
            } else {
                if (expression.text.toString()
                        .startsWith("0") && expression.text.toString().length < 2 &&
                    expression.text.toString().getOrNull(1) != '.'
                ) {
                    str = expression.text.toString().replace("0", "") + "0"
                    expressionText(str)
                    resultText()
                } else {
                    str = expression.text.toString() + "0"
                    expressionText(str)
                    resultText()
                }
            }
        }
        doubleZero.setOnClickListener {
            if (isCalculationComplete) {
                expression.textSize = 60F
                result.textSize = 30F
                isCalculationComplete = false
                str = "0"
                expressionText(str)
                resultText()
            } else {
                if (expression.text.toString() != "0") {
                    str = expression.text.toString() + "00"
                    expressionText(str)
                    resultText()
                }
            }
        }
        one.setOnClickListener {
            if (isCalculationComplete) {
                expression.textSize = 60F
                result.textSize = 30F
                isCalculationComplete = false
                str = "1"
                expressionText(str)
                resultText()
            } else {
                if (expression.text.toString()
                        .startsWith("0") && expression.text.toString().length <= 2 &&
                    expression.text.toString().getOrNull(1) != '.'
                ) {
                    str = expression.text.toString().replace("0", "") + "1"
                    expressionText(str)
                    resultText()
                } else {
                    str = expression.text.toString() + "1"
                    expressionText(str)
                    resultText()
                }
            }
        }
        two.setOnClickListener {
            if (isCalculationComplete) {
                expression.textSize = 60F
                result.textSize = 30F
                isCalculationComplete = false
                str = "2"
                expressionText(str)
                resultText()
            } else {
                if (expression.text.toString()
                        .startsWith("0") && expression.text.toString().length <= 2 &&
                    expression.text.toString().getOrNull(1) != '.'
                ) {
                    str = expression.text.toString().replace("0", "") + "2"
                    expressionText(str)
                    resultText()
                } else {
                    str = expression.text.toString() + "2"
                    expressionText(str)
                    resultText()
                }
            }
        }
        three.setOnClickListener {
            if (isCalculationComplete) {
                expression.textSize = 60F
                result.textSize = 30F
                isCalculationComplete = false
                str = "3"
                expressionText(str)
                resultText()
            } else {
                if (expression.text.toString()
                        .startsWith("0") && expression.text.toString().length <= 2 &&
                    expression.text.toString().getOrNull(1) != '.'
                ) {
                    str = expression.text.toString().replace("0", "") + "3"
                    expressionText(str)
                    resultText()
                } else {
                    str = expression.text.toString() + "3"
                    expressionText(str)
                    resultText()
                }
            }
        }
        four.setOnClickListener {
            if (isCalculationComplete) {
                expression.textSize = 60F
                result.textSize = 30F
                isCalculationComplete = false
                str = "4"
                expressionText(str)
                resultText()
            } else {
                if (expression.text.toString()
                        .startsWith("0") && expression.text.toString().length <= 2 &&
                    expression.text.toString().getOrNull(1) != '.'
                ) {
                    str = expression.text.toString().replace("0", "") + "4"
                    expressionText(str)
                    resultText()
                } else {
                    str = expression.text.toString() + "4"
                    expressionText(str)
                    resultText()
                }
            }
        }
        five.setOnClickListener {
            if (isCalculationComplete) {
                expression.textSize = 60F
                result.textSize = 30F
                isCalculationComplete = false
                str = "5"
                expressionText(str)
                resultText()
            } else {
                if (expression.text.toString()
                        .startsWith("0") && expression.text.toString().length <= 2 &&
                    expression.text.toString().getOrNull(1) != '.'
                ) {
                    str = expression.text.toString().replace("0", "") + "5"
                    expressionText(str)
                    resultText()
                } else {
                    str = expression.text.toString() + "5"
                    expressionText(str)
                    resultText()
                }
            }
        }
        six.setOnClickListener {
            if (isCalculationComplete) {
                expression.textSize = 60F
                result.textSize = 30F
                isCalculationComplete = false
                str = "6"
                expressionText(str)
                resultText()
            } else {
                if (expression.text.toString()
                        .startsWith("0") && expression.text.toString().length <= 2 &&
                    expression.text.toString().getOrNull(1) != '.'
                ) {
                    str = expression.text.toString().replace("0", "") + "6"
                    expressionText(str)
                    resultText()
                } else {
                    str = expression.text.toString() + "6"
                    expressionText(str)
                    resultText()
                }
            }
        }
        seven.setOnClickListener {
            if (isCalculationComplete) {
                expression.textSize = 60F
                result.textSize = 30F
                isCalculationComplete = false
                str = "7"
                expressionText(str)
                resultText()
            } else {
                if (expression.text.toString()
                        .startsWith("0") && expression.text.toString().length <= 2 &&
                    expression.text.toString().getOrNull(1) != '.'
                ) {
                    str = expression.text.toString().replace("0", "") + "7"
                    expressionText(str)
                    resultText()
                } else {
                    str = expression.text.toString() + "7"
                    expressionText(str)
                    resultText()
                }
            }
        }
        eight.setOnClickListener {
            if (isCalculationComplete) {
                expression.textSize = 60F
                result.textSize = 30F
                isCalculationComplete = false
                str = "8"
                expressionText(str)
                resultText()
            } else {
                if (expression.text.toString()
                        .startsWith("0") && expression.text.toString().length <= 2 &&
                    expression.text.toString().getOrNull(1) != '.'
                ) {
                    str = expression.text.toString().replace("0", "") + "8"
                    expressionText(str)
                    resultText()
                } else {
                    str = expression.text.toString() + "8"
                    expressionText(str)
                    resultText()
                }
            }
        }
        nine.setOnClickListener {
            if (isCalculationComplete) {
                expression.textSize = 60F
                result.textSize = 30F
                isCalculationComplete = false
                str = "9"
                expressionText(str)
                resultText()
            } else {
                if (expression.text.toString()
                        .startsWith("0") && expression.text.toString().length <= 2 &&
                    expression.text.toString().getOrNull(1) != '.'
                ) {
                    str = expression.text.toString().replace("0", "") + "9"
                    expressionText(str)
                    resultText()
                } else {
                    str = expression.text.toString() + "9"
                    expressionText(str)
                    resultText()
                }
            }
        }
        leftscob.setOnClickListener {
            if (isCalculationComplete) {
                expression.textSize = 60F
                result.textSize = 30F
                isCalculationComplete = false
                str = "("
                expressionText(str)
                result.text = "=0"
            } else {
                if (expression.text.toString()
                        .startsWith("0") && expression.text.toString().length <= 2 &&
                    expression.text.toString().getOrNull(1) != '.'
                ) {
                    str = expression.text.toString().replace("0", "") + "("
                    expressionText(str)
                } else {
                    str = expression.text.toString() + "("
                    expressionText(str)
                }

            }
        }
        rightscob.setOnClickListener {
            if (isCalculationComplete) {
                expression.textSize = 60F
                result.textSize = 30F
                isCalculationComplete = false
                str = ")"
                expressionText(str)
                result.text = "=0"
            } else {
                if (expression.text.toString()
                        .startsWith("0") && expression.text.toString().length <= 2 &&
                    expression.text.toString().getOrNull(1) != '.'
                ) {
                    str = expression.text.toString().replace("0", "") + ")"
                    expressionText(str)
                    resultText()
                } else {
                    str = expression.text.toString() + ")"
                    expressionText(str)
                    resultText()
                }
            }
        }
        sin.setOnClickListener {
            if (isCalculationComplete) {
                expression.textSize = 60F
                result.textSize = 30F
                isCalculationComplete = false
                str = "sin("
                expressionText(str)
                result.text = "=0"
            } else {
                if (expression.text.toString()
                        .startsWith("0") && expression.text.toString().length <= 2 &&
                    expression.text.toString().getOrNull(1) != '.'
                ) {
                    str = expression.text.toString().replace("0", "") + "sin("
                    expressionText(str)
                } else {
                    str = expression.text.toString() + "sin("
                    expressionText(str)
                }
            }
        }
        cos.setOnClickListener {
            if (isCalculationComplete) {
                expression.textSize = 60F
                result.textSize = 30F
                isCalculationComplete = false
                str = "cos("
                expressionText(str)
                result.text = "=0"
            } else {
                if (expression.text.toString()
                        .startsWith("0") && expression.text.toString().length <= 2 &&
                    expression.text.toString().getOrNull(1) != '.'
                ) {
                    str = expression.text.toString().replace("0", "") + "cos("
                    expressionText(str)
                } else {
                    str = expression.text.toString() + "cos("
                    expressionText(str)
                }
            }
        }
        sqrt.setOnClickListener {
            if (isCalculationComplete) {
                expression.textSize = 60F
                result.textSize = 30F
                isCalculationComplete = false
                str = "sqrt("
                expressionText(str)
                result.text = "=0"
            } else {
                if (expression.text.toString()
                        .startsWith("0") && expression.text.toString().length <= 2 &&
                    expression.text.toString().getOrNull(1) != '.'
                ) {
                    str = expression.text.toString().replace("0", "") + "sqrt("
                    expressionText(str)
                } else {
                    str = expression.text.toString() + "sqrt("
                    expressionText(str)
                }
            }
        }
    }

    private fun expressionText(str: String) {
        expression.text = str
    }

    private fun resultText() {
        val expressionText = expression.text.toString()
        if (!areParenthesesBalanced(expressionText)) {
            result.text = "Ошибка: несбалансированные скобки"
            return
        }
        val exp: Expression = ExpressionBuilder(expressionText).build()
        try {
            val resultValue = exp.evaluate()
            if (resultValue.toString().endsWith(".0")) {
                result.text = "=" + resultValue.toString().replace(".0", "")
            } else {
                result.text = "=$resultValue"
            }
        } catch (e: Exception) {
            result.text = "Ошибка, сообщение ${e.message}"
        }
    }

    fun setButtonsEnabled(enabled: Boolean) {
        val color = if (!enabled) buttonColorEnabled else buttonColorDisabled
        backSpace.isEnabled = !enabled
        percent.isEnabled = !enabled
        divide.isEnabled = !enabled
        multiply.isEnabled = !enabled
        add.isEnabled = !enabled
        subtract.isEnabled = !enabled
        leftscob.isEnabled = !enabled
        rightscob.isEnabled = !enabled
        sin.isEnabled = !enabled
        cos.isEnabled = !enabled
        sqrt.isEnabled = !enabled

        backSpace.setTextColor(color)
        percent.setTextColor(color)
        divide.setTextColor(color)
        multiply.setTextColor(color)
        add.setTextColor(color)
        subtract.setTextColor(color)
        leftscob.setTextColor(color)
        rightscob.setTextColor(color)
        sin.setTextColor(color)
        cos.setTextColor(color)
        sqrt.setTextColor(color)
    }

    private fun areParenthesesBalanced(expression: String): Boolean {
        var balance = 0
        for (char in expression) {
            when (char) {
                '(' -> balance++
                ')' -> balance--
            }
            if (balance < 0) {
                return false
            }
        }
        return balance == 0
    }

    private fun toggleExtraColumn() {
        isColumnVisible = !isColumnVisible
        extraColumn.isVisible = isColumnVisible
    }
}