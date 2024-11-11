package com.example.edittextbuttononclick

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val editTextView = findViewById<EditText>(R.id.editText)
        val resultView = findViewById<TextView>(R.id.result_view)
        val symbolCountView = findViewById<TextView>(R.id.symbols_count_view)
        val convertButton = findViewById<Button>(R.id.convert_button)
        convertButton.setOnClickListener{
            resultView.text = editTextView.text.reversed()
            val res = resultView.text.filter { it != ' ' }.length
            symbolCountView.text = getString(R.string.symbols_count_view_text, res.toString())
        }
    }
}