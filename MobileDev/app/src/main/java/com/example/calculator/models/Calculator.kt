package com.example.calculator.models

import android.widget.TextView
import com.example.calculator.Firebase.FireStoreCalc
import com.example.calculator.activities.MainActivity
import com.example.calculator.utils.CalculatorUtils.areParenthesesBalanced
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder
import com.google.firebase.firestore.FirebaseFirestore

class Calculator(private val expression: TextView, private val result: TextView,
                 private val activity: MainActivity
) {
    private var isCalculationComplete = false
    private var hasLettersInResult = false
    private var str: String = ""


    fun one() {
        if (isCalculationComplete) {
            expression.textSize = 60F
            result.textSize = 30F
            isCalculationComplete = false
            str = "1"
            expressionText(str)
            resultText()
        } else {
            if (expression.text.toString()
                    .startsWith("0") && expression.text.toString().length < 2 &&
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
    fun two() {
        if (isCalculationComplete) {
            expression.textSize = 60F
            result.textSize = 30F
            isCalculationComplete = false
            str = "2"
            expressionText(str)
            resultText()
        } else {
            if (expression.text.toString()
                    .startsWith("0") && expression.text.toString().length < 2 &&
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
    fun three() {
        if (isCalculationComplete) {
            expression.textSize = 60F
            result.textSize = 30F
            isCalculationComplete = false
            str = "3"
            expressionText(str)
            resultText()
        } else {
            if (expression.text.toString()
                    .startsWith("0") && expression.text.toString().length < 2 &&
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
    fun four() {
        if (isCalculationComplete) {
            expression.textSize = 60F
            result.textSize = 30F
            isCalculationComplete = false
            str = "4"
            expressionText(str)
            resultText()
        } else {
            if (expression.text.toString()
                    .startsWith("0") && expression.text.toString().length < 2 &&
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
    fun five() {
        if (isCalculationComplete) {
            expression.textSize = 60F
            result.textSize = 30F
            isCalculationComplete = false
            str = "5"
            expressionText(str)
            resultText()
        } else {
            if (expression.text.toString()
                    .startsWith("0") && expression.text.toString().length < 2 &&
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
    fun six() {
        if (isCalculationComplete) {
            expression.textSize = 60F
            result.textSize = 30F
            isCalculationComplete = false
            str = "6"
            expressionText(str)
            resultText()
        } else {
            if (expression.text.toString()
                    .startsWith("0") && expression.text.toString().length < 2 &&
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
    fun seven() {
        if (isCalculationComplete) {
            expression.textSize = 60F
            result.textSize = 30F
            isCalculationComplete = false
            str = "7"
            expressionText(str)
            resultText()
        } else {
            if (expression.text.toString()
                    .startsWith("0") && expression.text.toString().length < 2 &&
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
    fun eight() {
        if (isCalculationComplete) {
            expression.textSize = 60F
            result.textSize = 30F
            isCalculationComplete = false
            str = "8"
            expressionText(str)
            resultText()
        } else {
            if (expression.text.toString()
                    .startsWith("0") && expression.text.toString().length < 2 &&
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
    fun nine() {
        if (isCalculationComplete) {
            expression.textSize = 60F
            result.textSize = 30F
            isCalculationComplete = false
            str = "9"
            expressionText(str)
            resultText()
        } else {
            if (expression.text.toString()
                    .startsWith("0") && expression.text.toString().length < 2 &&
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
    fun zero() {
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
    fun doubleZero() {
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
    fun dot() {
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

    fun add() {
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
    fun subtract() {
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
    fun multiply() {
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
    fun divide() {
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
    fun percent() {
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
    fun equal() {
        expression.textSize = 30F
        result.textSize = 60F
        isCalculationComplete = true

        val resultText = result.text.toString()
        hasLettersInResult = resultText.any { it.isLetter() && it != 'e' && it != 'E' }

        activity.setButtonsEnabled(hasLettersInResult)

        if (!hasLettersInResult && resultText.isNotBlank() && resultText != "Ошибка" && resultText != "=0") {
            val firestore = FireStoreCalc(activity) 
            firestore.saveCalculationToFirestore(expression.text.toString(), resultText)
        }
    }

    fun clear() {
        expression.text = "0"
        result.text = "=0"
        expression.textSize = 60F
        result.textSize = 30F
        isCalculationComplete = false
        hasLettersInResult = false
        activity.setButtonsEnabled(hasLettersInResult)
    }
    fun backSpace() {
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
    fun sin() {
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
    fun cos() {
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
    fun sqrt() {
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
    fun leftscob() {
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
    fun rightscob() {
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
    fun tg() {
        if (isCalculationComplete) {
            expression.textSize = 60F
            result.textSize = 30F
            isCalculationComplete = false
            str = "tan("
            expressionText(str)
            result.text = "=0"
        } else {
            if (expression.text.toString()
                    .startsWith("0") && expression.text.toString().length <= 2 &&
                expression.text.toString().getOrNull(1) != '.'
            ) {
                str = expression.text.toString().replace("0", "") + "tan("
                expressionText(str)
            } else {
                str = expression.text.toString() + "tan("
                expressionText(str)
            }
        }
    }
    fun ctg() {
        if (isCalculationComplete) {
            expression.textSize = 60F
            result.textSize = 30F
            isCalculationComplete = false
            str = "cot("
            expressionText(str)
            result.text = "=0"
        } else {
            if (expression.text.toString()
                    .startsWith("0") && expression.text.toString().length <= 2 &&
                expression.text.toString().getOrNull(1) != '.'
            ) {
                str = expression.text.toString().replace("0", "") + "cot("
                expressionText(str)
            } else {
                str = expression.text.toString() + "cot("
                expressionText(str)
            }
        }
    }
    fun ln() {
        if (isCalculationComplete) {
            expression.textSize = 60F
            result.textSize = 30F
            isCalculationComplete = false
            str = "log("
            expressionText(str)
            result.text = "=0"
        } else {
            if (expression.text.toString()
                    .startsWith("0") && expression.text.toString().length <= 2 &&
                expression.text.toString().getOrNull(1) != '.'
            ) {
                str = expression.text.toString().replace("0", "") + "log("
                expressionText(str)
            } else {
                str = expression.text.toString() + "log("
                expressionText(str)
            }
        }
    }
    fun pi() {
        if (isCalculationComplete) {
            expression.textSize = 60F
            result.textSize = 30F
            isCalculationComplete = false
            str = "π"
            expressionText(str)
            resultText()
        } else {
            if (expression.text.toString()
                    .startsWith("0") && expression.text.toString().length < 2 &&
                expression.text.toString().getOrNull(1) != '.'
            ) {
                str = expression.text.toString().replace("0", "") + "π"
                expressionText(str)
                resultText()
            } else {
                str = expression.text.toString() + "π"
                expressionText(str)
                resultText()
            }
        }
    }
    fun e() {
        if (isCalculationComplete) {
            expression.textSize = 60F
            result.textSize = 30F
            isCalculationComplete = false
            str = "e"
            expressionText(str)
            resultText()
        } else {
            if (expression.text.toString()
                    .startsWith("0") && expression.text.toString().length < 2 &&
                expression.text.toString().getOrNull(1) != '.'
            ) {
                str = expression.text.toString().replace("0", "") + "e"
                expressionText(str)
                resultText()
            } else {
                str = expression.text.toString() + "e"
                expressionText(str)
                resultText()
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
        try {
            val exp: Expression = ExpressionBuilder(expressionText).build()
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
}