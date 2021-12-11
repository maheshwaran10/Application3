package com.example.amazon.Activity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.amazon.R

class HomeDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_detail)
        supportActionBar?.hide()

        val textView = findViewById<TextView>(R.id.issue)
        val textV = findViewById<TextView>(R.id.textView2)
        val des = findViewById<TextView>(R.id.text)
        val img = findViewById<ImageButton>(R.id.btn)
        val navigate =findViewById<TextView>(R.id.map)

        navigate.movementMethod = LinkMovementMethod.getInstance()
        navigate.setLinkTextColor(Color.BLUE)

        val intent = intent
        val aTitle = intent.getStringExtra("iTitle")
        val aText = intent.getStringExtra("iText")
        val aDes = intent.getStringExtra("iDes")
        val aImage = intent.getIntExtra("iImage", 0)

        textView.text = aTitle
        textV.text = aText
        des.text = aDes
        img.setImageResource(aImage)

        val button = findViewById<ImageButton>(R.id.imButton)
        val button1 = findViewById<Button>(R.id.buttonCheck)
        button.setOnClickListener {
           finish()

        }

        button1.setOnClickListener {
            finish()

        }
        navigate.setOnClickListener {
            val intent = Intent (this@HomeDetailActivity ,NavigateActivity::class.java)
            startActivity(intent)
        }


    }
}