package com.example.foodapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //supportActionBar?.hide()

        reg.setOnClickListener {
            Toast.makeText(this, "Successfully registered", Toast.LENGTH_SHORT).show()
            val i= Intent(this,MainActivity3::class.java)
            startActivity(i)
        }
    }
}