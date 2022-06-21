package com.example.foodapp.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.*
import com.example.foodapp.database.DBHelper
import com.example.foodapp.models.OrderModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class OrderAdapter(var context: Context,var list:ArrayList<OrderModel>) :
    RecyclerView.Adapter<OrderAdapter.viewHolder>() {

    open class viewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var imageView: ImageView =itemView.findViewById(R.id.img)
        var name: TextView =itemView.findViewById(R.id.customername)
        var price: TextView =itemView.findViewById(R.id.value)
        var str: TextView =itemView.findViewById(R.id.id)
        var foodname: TextView =itemView.findViewById(R.id.ordername)
        var phone: TextView =itemView.findViewById(R.id.customerphone)
        var update:Button=itemView.findViewById(R.id.update)
        var delete:Button=itemView.findViewById(R.id.delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.order_food_layout,parent,false)

        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val model:OrderModel=list.get(position)
        holder.imageView.setImageResource(model.pic)
        holder.foodname.text=model.foodname
        holder.str.text=model.id.toString()
        holder.price.text= model.price
        holder.name.text=model.name
        holder.phone.text=model.phone
        val helper:DBHelper= DBHelper(context)
        holder.update.setOnClickListener {
          /*  //for fragment
             val k=it.context as AppCompatActivity
            val sheet=UpdateOrder()
            k.supportFragmentManager.beginTransaction().replace(R.id.rec,sheet).commit()
            //for bottomsheet fragment
//             val s=BottomSheetDialogFragment()
//            s.show(k.supportFragmentManager,s.tag)*/
            val t= Intent(context, Update::class.java)
            context.startActivity(t)
        }
        holder.delete.setOnClickListener {
            val isDelete=helper.deleteTask(model.id.toString())
            if(isDelete) {
                val t= Intent(context, MainActivity3::class.java)
                context.startActivity(t)
                Toast.makeText(context, "Order Deleted", Toast.LENGTH_SHORT).show()
            }
            else
                Toast.makeText(context, "Not deleted", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}