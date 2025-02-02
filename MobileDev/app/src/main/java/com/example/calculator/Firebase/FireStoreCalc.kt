package com.example.calculator.Firebase

import android.content.Context
import android.icu.text.SimpleDateFormat
import android.widget.Toast
import com.example.calculator.activities.HistoryActivity
import com.example.calculator.utils.isInternetAvailable
import com.example.calculator.utils.showNoInternetMessage
import com.google.firebase.firestore.FirebaseFirestore
import java.util.Locale

class FireStoreCalc(private val context: Context) {
    private val db = FirebaseFirestore.getInstance()
    private val calculationsCollection = db.collection("calculations")

    fun saveCalculationToFirestore(expression: String, result: String) {
        if (!isInternetAvailable(context)) {
            showNoInternetMessage(context)
            return
        }
        val currentDateTime = System.currentTimeMillis()
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
        val formattedDate = dateFormat.format(currentDateTime)
        val calcData = hashMapOf(
            "expression" to expression,
            "result" to result,
            "timestamp" to formattedDate
        )
        calculationsCollection.add(calcData)
            .addOnSuccessListener {
                Toast.makeText(context, "Результат сохранен в Firestore", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(context, "Ошибка при сохранении в Firestore", Toast.LENGTH_SHORT).show()
            }
    }

    fun loadHistoryFromFirestore(onSuccess: (List<Calculation>) -> Unit) {
        if (!isInternetAvailable(context)) {
            showNoInternetMessage(context)
            (context as? HistoryActivity)?.hideClearHistoryButton()
            return
        }
        calculationsCollection
            .orderBy("timestamp")
            .get()
            .addOnSuccessListener { documents ->
                val historyList = mutableListOf<Calculation>()
                for (document in documents) {
                    val expression = document.getString("expression") ?: ""
                    val result = document.getString("result") ?: ""
                    val timestamp = document.getString("timestamp") ?: ""
                    historyList.add(Calculation(expression, result, timestamp))
                }
                onSuccess(historyList)
            }
            .addOnFailureListener {
                Toast.makeText(context, "Ошибка при загрузке истории из Firestore", Toast.LENGTH_SHORT).show()
            }
    }

    fun clearHistory(onSuccess: () -> Unit) {
        calculationsCollection
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    document.reference.delete()
                }
                onSuccess()
            }
            .addOnFailureListener {
                Toast.makeText(context, "Ошибка при удалении истории", Toast.LENGTH_SHORT).show()
            }
    }

    data class Calculation(
        val expression: String,
        val result: String,
        val timestamp: String
    )
}