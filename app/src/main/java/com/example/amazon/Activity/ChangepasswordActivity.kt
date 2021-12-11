package com.example.amazon.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.example.amazon.R

class ChangepasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_changepassword)
        supportActionBar?.hide()

        val old = findViewById<EditText>(R.id.mobile)
        val new = findViewById<EditText>(R.id.password)
        val confirm = findViewById<EditText>(R.id.newPassword)
        val changeBtn = findViewById<Button>(R.id.buttonCheck)
        val back =findViewById<ImageButton>(R.id.imButton)
        val passwordPattern = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$"

        changeBtn.setOnClickListener {

            val oldP =old.text.toString()
            val newP = new.text.toString()
            val confirmP = confirm.text.toString()

            if (TextUtils.isEmpty(oldP)) {
                old.error = "Enter Old Password"
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(newP)) {
                new.error ="Enter New Password"
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(confirmP)) {
                confirm.error ="Enter Confirm Password"
                return@setOnClickListener
            }
            if(newP.equals(confirmP)){
                new.clearFocus()
            }else{
                confirm.error="Password Not Matched"
                return@setOnClickListener
            }
            if (newP.matches(passwordPattern.toRegex())) {
                Toast.makeText(this,"Password Changed", Toast.LENGTH_SHORT).show()
            }
            else {
                new.error="InValid eg:Ma@1"
                return@setOnClickListener
            }

            finish()

        }

        back.setOnClickListener {
            finish()
        }


    }
}