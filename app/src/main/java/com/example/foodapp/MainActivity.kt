package com.example.foodapp

import android.content.Intent
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.foodapp.ui.login.LoginActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //supportActionBar?.hide()

        //button.getBackground().setColorFilter(0xFFFF0000.toInt(), PorterDuff.Mode.MULTIPLY);

       button.setOnClickListener {
           val j=Intent(this, LoginActivity::class.java)
           startActivity(j)
       }
        register.setOnClickListener {
           val k=Intent(this, RegisterActivity::class.java)
           startActivity(k)
       }

        skip.setOnClickListener {
            val i=Intent(this,MainActivity3::class.java)
            startActivity(i)
        }

    }
}