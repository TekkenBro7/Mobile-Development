package com.example.calculator.utils

import android.widget.Button
import com.example.calculator.models.Calculator

object ButtonHandlers {
    fun setNumberButtonListener(button: Button, calculator: Calculator, number: String) {
        button.setOnClickListener {
            when (number) {
                "1" -> calculator.one()
                "2" -> calculator.two()
                "3" -> calculator.three()
                "4" -> calculator.four()
                "5" -> calculator.five()
                "6" -> calculator.six()
                "7" -> calculator.seven()
                "8" -> calculator.eight()
                "9" -> calculator.nine()
                "0" -> calculator.zero()
                "00" -> calculator.doubleZero()
                "." -> calculator.dot()
            }
        }
    }
    fun setOperationButtonListener(button: Button, calculator: Calculator, operation: String) {
        button.setOnClickListener {
            when (operation) {
                "+" -> calculator.add()
                "-" -> calculator.subtract()
                "*" -> calculator.multiply()
                "/" -> calculator.divide()
                "%" -> calculator.percent()
                "=" -> calculator.equal()
            }
        }
    }
    fun setFunctionButtonListener(button: Button, calculator: Calculator, function: String) {
        button.setOnClickListener {
            when (function) {
                "clear" -> calculator.clear()
                "backspace" -> calculator.backSpace()
                "sin" -> calculator.sin()
                "cos" -> calculator.cos()
                "sqrt" -> calculator.sqrt()
                "(" -> calculator.leftscob()
                ")" -> calculator.rightscob()
            }
        }
    }
}
