package com.example.foodapp;

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodapp.adapters.OrderAdapter
import com.example.foodapp.database.DBHelper
import kotlinx.android.synthetic.main.activity_order.*

class OrderActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)


        val helper= DBHelper(this)

        val list=helper.getOrders()

        orderrecycler.adapter= OrderAdapter(this,list)

        val manager= LinearLayoutManager(this)
        orderrecycler.layoutManager=manager

        var sum =0
        var i=0
        while(i<list.size){
            sum+=list[i].price.toInt()
            i++
        }
        total.text= "Total Rs.$sum"

    }
}