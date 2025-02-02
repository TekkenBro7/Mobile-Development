package com.example.calculator.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.calculator.Firebase.FireStoreCalc
import com.example.calculator.R
import com.example.calculator.utils.HistoryAdapter

class HistoryActivity : AppCompatActivity() {

    private lateinit var historyTextView: TextView
    private lateinit var btnClose: ImageButton
    private lateinit var btnClearHistory: Button
    private lateinit var firestoreUtils: FireStoreCalc
    private lateinit var recyclerViewHistory: RecyclerView
    private lateinit var adapter: HistoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_history)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnClose = findViewById(R.id.btnClose)
        btnClearHistory = findViewById(R.id.btnClearHistory)
        recyclerViewHistory = findViewById(R.id.recyclerViewHistory)
        firestoreUtils = FireStoreCalc(this)

        setupRecyclerView()
        loadHistory()

        btnClose.setOnClickListener {
            finish()
        }

        btnClearHistory.setOnClickListener {
            clearHistory()
        }
    }

    fun hideClearHistoryButton() {
        btnClearHistory.visibility = Button.GONE
    }

    private fun setupRecyclerView() {
        recyclerViewHistory.layoutManager = LinearLayoutManager(this)
    }
    private fun loadHistory() {
        firestoreUtils.loadHistoryFromFirestore { historyList ->
            adapter = HistoryAdapter(historyList) { calculation ->
                val intent = Intent()
                intent.putExtra("expression", calculation.expression)
                intent.putExtra("result", calculation.result)
                setResult(RESULT_OK, intent)
                finish()
            }
            recyclerViewHistory.adapter = adapter
        }
    }
    private fun clearHistory() {
        firestoreUtils.clearHistory {
            historyTextView.text = "История результатов будет здесь"
            Toast.makeText(this, "История очищена", Toast.LENGTH_SHORT).show()
        }
    }
}