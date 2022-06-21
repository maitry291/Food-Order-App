package com.example.foodapp

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.foodapp.database.DBHelper
import kotlinx.android.synthetic.main.activity_detailed_food.*

class DetailedFood : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_food)

//here we are using intent from which we started this activity(from recipe adapter
        //we are setting values which we get from intent.
        foodimage.setImageResource(intent.getIntExtra("image",0))
        foodname.setText(intent.getStringExtra("name"))
        foodprice.setText(intent.getStringExtra("price"))
        fooddescription.setText(intent.getStringExtra("description"))

        val helper=DBHelper(this)  //created object of database helper class to insert order details

        //to take order
        takeorder.setOnClickListener {
            if(PersonName.text.toString().equals("") && Phone.text.toString().equals(""))
                Toast.makeText(this, "Please enter Name and number", Toast.LENGTH_SHORT).show()
            else {
                val t = helper.insertOrder(
                    PersonName.text.toString(), Phone.text.toString(),
                    intent.getIntExtra("image", 0), intent.getStringExtra("price")?.toInt(),
                    intent.getStringExtra("description"), intent.getStringExtra("name")
                )
                if (t) {
                    Toast.makeText(this, "Order Successful", Toast.LENGTH_SHORT).show()
                    val i=Intent(this,OrderActivity::class.java)
                    startActivity(i)
                } else
                    Toast.makeText(this, "Not successful", Toast.LENGTH_SHORT).show()

            }
        }

        //to get all order information which are in database table
        getOrderInfo.setOnClickListener {
            var res:Cursor=helper.getAllData()
            if(res.count==0){   //res.count will give the total number of rows present in database table.
                //show message
                    getMessage("ERROR","Found nothing")
                return@setOnClickListener
            }
            else{
                var buffer:StringBuffer= StringBuffer()
                while(res.moveToNext()){
                    buffer.append("ID : "+res.getString(0) +"\n") //0 is the column index for "id"
                    buffer.append("Name : "+res.getString(1)+"\n")
                    buffer.append("Phone : "+res.getString(2)+"\n")
                    buffer.append("Image code : "+res.getString(3)+"\n")
                    buffer.append("Price : "+res.getString(4)+"\n")
                    buffer.append("Description : "+res.getString(5)+"\n")
                }
                //show all data
                getMessage("Data",buffer.toString())
            }
        }

        //to update or delete any data given before
        /*delete.setOnClickListener {
           // val isUpdate=helper.updateData(isUpdated.text.toString(),PersonName.text.toString(),Phone.text.toString())
            val isDelete=helper.deleteTask(isUpdated.text.toString())
            if(isDelete)
                Toast.makeText(this, "Updated", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "Not Updated", Toast.LENGTH_SHORT).show()
        }*/
    }
    //to get message on alert dialogue box
    fun getMessage(title:String,msg:String){
       val box: AlertDialog.Builder=AlertDialog.Builder(this)
        box.setCancelable(true)
        box.setTitle(title)
        box.setMessage(msg)
        box.show()
    }

}