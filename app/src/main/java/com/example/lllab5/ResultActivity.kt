package com.example.lllab5

import android.os.Bundle

import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val total = intent.getIntExtra("total", 0)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)
        resultTextView.text = "Сумма заказа = $total руб."

    }
}