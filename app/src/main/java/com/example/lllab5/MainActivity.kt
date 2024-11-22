package com.example.lllab5

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pagesEditText = findViewById<EditText>(R.id.pagesEditText)
        val formatRadioGroup = findViewById<RadioGroup>(R.id.formatRadioGroup)
        val calculateButton = findViewById<Button>(R.id.calculateButton)

        calculateButton.setOnClickListener {
            val pages = pagesEditText.text.toString().toIntOrNull() ?: 0
            val selectedId = formatRadioGroup.checkedRadioButtonId
            val radioButton = findViewById<RadioButton>(selectedId)
            val pricePerPage = when (radioButton?.text) {
                "А4 (10 руб.)" -> 10
                "А3 (30 руб.)" -> 30
                "А1 (100 руб.)" -> 100
                else -> 0 // Default case, should not happen
            }
            val total = pages * pricePerPage

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("total", total)
            startActivity(intent)
        }
    }
}