package com.example.foodapp.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.DetailedFood
import com.example.foodapp.R
import com.example.foodapp.models.RecipeModel

class RecipeAdapter(var context:Context,var list:ArrayList<RecipeModel>):
    RecyclerView.Adapter<RecipeAdapter.viewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeAdapter.viewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.recipe_layout,parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder:  RecipeAdapter.viewHolder, position: Int) {
        val model:RecipeModel=list.get(position)
        holder.imageView.setImageResource(model.pic)
        holder.name.text=model.name
        holder.price.text=model.price
        holder.str.text=model.str

        holder.itemView.setOnClickListener(){
            //when we click on any food item we will be redirected to any activity as per given context to intent.
            //we have to pass some details of food while clicking with intent so we used putExtra method
            //and using this method we are passing food image,name,price and description with intent to another activity.

            val i=Intent(context,DetailedFood::class.java)
            i.putExtra("image",model.pic)    //
            i.putExtra("name",model.name)
            i.putExtra("price",model.price)
            i.putExtra("description",model.str)

            context.startActivity(i)
        }
    }


    override fun getItemCount(): Int {
        return list.size
    }

     open class viewHolder(itemView:View):  RecyclerView.ViewHolder(itemView) {
        val imageView:ImageView=itemView.findViewById(R.id.image)
        var name:TextView=itemView.findViewById(R.id.name)
        var price:TextView=itemView.findViewById(R.id.price)
        var str:TextView=itemView.findViewById(R.id.description)
    }

}