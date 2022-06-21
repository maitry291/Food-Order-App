package com.example.foodapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*
import java.lang.Exception
import java.lang.Thread.sleep

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

       // supportActionBar?.hide()
      //used animation
        animation_view.playAnimation()

        val t=Thread(Runnable {
            try {
               sleep(1300)
            }
            catch (e:Exception){
                println(e)
            }
            finally {
                val i=Intent(this,MainActivity::class.java)
                startActivity(i)
            }
        })
        t.start()
    }
}