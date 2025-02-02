package com.example.calculator.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.calculator.Firebase.FireStoreCalc
import com.example.calculator.R

class HistoryAdapter(
    private val calculations: List<FireStoreCalc.Calculation>,
    private val onItemClick: (FireStoreCalc.Calculation) -> Unit
) : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    inner class HistoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val expressionText: TextView = view.findViewById(R.id.text_expression)
        val resultText: TextView = view.findViewById(R.id.text_result)
        val timestampText: TextView = view.findViewById(R.id.text_timestamp)
        init {
            itemView.setOnClickListener {
                onItemClick(calculations[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_history, parent, false)
        return HistoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val calculation = calculations[position]
        holder.expressionText.text = calculation.expression
        holder.resultText.text = calculation.result
        holder.timestampText.text = calculation.timestamp
    }

    override fun getItemCount(): Int = calculations.size
}