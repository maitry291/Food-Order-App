package com.example.foodapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodapp.adapters.RecipeAdapter
import com.example.foodapp.models.RecipeModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val list=ArrayList<RecipeModel>()

        list.add(RecipeModel(R.drawable.f0,"Pasta Pizza","399","combination of olive oil, oregano, " +
                "tomato, olives, mozzarella or other cheese, and many other ingredients"))
        list.add(RecipeModel(R.drawable.f1,"Special Lunch dish","459","Dal-Roti , Rice, paneer sabji+masala papad" +
                "salad"))
        list.add(RecipeModel(R.drawable.f2,"Burger+Fries","299"," consisting of one or more cooked " +
                "patties—usually ground meat, typically beef—placed inside a sliced bread roll or bun." ))
        list.add(RecipeModel(R.drawable.f3,"Grilled Sandwich","149","filled with layers of" +
                " various ingredients such as meat, cheese, tomatoes, lettuce, and condiments."))
        list.add(RecipeModel(R.drawable.f4,"Nachoz+Burger combo","359"," Mexican regional dish" +
                " from northern Mexico that consists of heated tortilla chips or totopos covered with melted cheese"))
        list.add(RecipeModel(R.drawable.f5,"Veggie Special","200","Perfect for breakfast contains carrots, beat,brocoli"))
        list.add(RecipeModel(R.drawable.f6,"Frenkie","99","a big, fat roll stuffed with veggies, paneer," +
                " Noodles mounted with variety of sauces. ..."))
        list.add(RecipeModel(R.drawable.f7,"Dosa+Sambhar","249","Very delicious south indian recipe with the goodness of " +
                "coconut chatni and sambhar."))
        list.add(RecipeModel(R.drawable.f8,"Spicy Noodles","179","spicy and delicious with the goodness" +
                " of fresh spring vegetables like snow peas, sweet corn, carrots, baby corn, broccoli"))
        list.add(RecipeModel(R.drawable.f9,"Non-veg Pizza","350","Decorated with Egg and cheese."))

        val adapter=RecipeAdapter(this,list)
        recyclerView.adapter=adapter

        val manager= LinearLayoutManager(this)
        recyclerView.layoutManager=manager

        cart.setOnClickListener(){
            val t= Intent(this,OrderActivity::class.java)
            startActivity(t)
        }

    }
}