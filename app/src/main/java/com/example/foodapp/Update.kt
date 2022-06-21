package com.example.foodapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.foodapp.database.DBHelper
import kotlinx.android.synthetic.main.fragment_update_order.*

class Update : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        val db = DBHelper(this)
        finalUpdate.setOnClickListener {
            val isUpdated = db.updateData(
                originalId.text.toString(),
                editPersonName.text.toString(),
                editPersonPhone.text.toString()
            )
            if (isUpdated) {
                val t= Intent(this, OrderActivity::class.java)
                startActivity(t)
                Toast.makeText(this, "updated data", Toast.LENGTH_SHORT).show()
            } else
                Toast.makeText(this, "updated data", Toast.LENGTH_SHORT).show()
        }
    }
}
