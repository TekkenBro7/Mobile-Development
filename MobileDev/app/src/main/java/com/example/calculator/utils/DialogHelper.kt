package com.example.calculator.utils

import android.app.AlertDialog
import android.content.Context
import com.example.calculator.R
import kotlin.math.ceil

class DialogHelper(private val context: Context) {

    fun showFunctionSelectionDialog(angle: Float, onFunctionSelected: (String) -> Unit) {
        val functions = arrayOf("sin", "cos", "tan", "cot")

        AlertDialog.Builder(context)
            .setTitle("Выберите функцию")
            .setItems(functions) { _, which ->
                val selectedFunction = functions[which]
                onFunctionSelected("$selectedFunction(π*${ceil(angle)}/180")
            }
            .setNegativeButton("Отмена", null)
            .show()
    }
}