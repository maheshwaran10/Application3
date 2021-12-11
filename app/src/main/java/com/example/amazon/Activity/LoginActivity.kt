package com.example.amazon.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.amazon.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()



        val password= findViewById<EditText>(R.id.password)
        val mobile =findViewById<EditText>(R.id.mobile)
        val passwordPattern = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$"
        val button=findViewById<Button>(R.id.buttonCheck)

        button.setOnClickListener {
            val name = mobile.text.toString()
            val pass = password.text.toString()


            if(TextUtils.isEmpty(name)){//name.isEmpty()
                mobile.error = "Enter Phone Number"
                return@setOnClickListener
            }
            if (name.length<10){
                mobile.error = "Enter 10digit"
                return@setOnClickListener
            }
            if(TextUtils.isEmpty(pass)){//pass.isEmpty()
                password.error = "Enter Password"
                return@setOnClickListener
            }

            if (pass.matches(passwordPattern.toRegex())) {
                Toast.makeText(this," Login Success", Toast.LENGTH_SHORT).show()
            }
            else {
                password.error="InValid eg:Ma@1"
                return@setOnClickListener
            }
            val intent = Intent(this@LoginActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()

        }
    }
}