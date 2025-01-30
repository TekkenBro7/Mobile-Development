package com.example.calculator.utils

import android.widget.LinearLayout
import androidx.core.view.isVisible

object CalculatorUtils {

    fun areParenthesesBalanced(expression: String): Boolean {
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
    fun toggleExtraColumn(extraColumn: LinearLayout) {
        extraColumn.isVisible = !extraColumn.isVisible
    }
}