package com.example.amazon.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import com.example.amazon.R

class CompletedDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_completed_detail)
        supportActionBar?.hide()

        val title = findViewById<TextView>(R.id.issue)
        val text1 = findViewById<TextView>(R.id.textView2)


        val intent = intent
        val aTitle = intent.getStringExtra("iTitle")
        val aText = intent.getStringExtra("iText")

        title.text =aTitle
        text1.text=aText

        val button = findViewById<ImageButton>(R.id.imButton)
        button.setOnClickListener {
            finish()
        }
    }
}