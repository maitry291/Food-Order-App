package com.example.foodapp.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.foodapp.models.OrderModel

class DBHelper(var context: Context?) : SQLiteOpenHelper(context,"foodOrders.db",null,5) {

    //when we call constructor of this class , super class constructor will be called and it will create
    //the database of name which we have given in constructor i.e."foodOrders.db" .

    val TABLE_NAME="Orders"
    val COL_1="id"
    val COL_2="name"
    val COL_3="phone"
    val COL_4="image"
    val COL_5="price"
    val COL_6="description"
    val COL_7="foodname"

    //if database with given name is not created before then this method will be called and will create
    //database of that name.
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("CREATE TABLE "+TABLE_NAME+"(id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "name TEXT,"+"phone TEXT,"+"image INTEGER,"+"price INTEGER,"+"description TEXT,"+"foodname TEXT)")
    }

    //if database of given name already exists then this method will be called
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("DROP TABLE IF EXISTS orders")
        onCreate(p0)
    }

    //when we want to enter row in database table then we should use this method.
    fun insertOrder(name:String, phone:String, image:Int, price: Int?, description:String?, foodname:String?):Boolean{
        val db:SQLiteDatabase=this.writableDatabase
        var id:Long=0

        val values: ContentValues = ContentValues()
        values.put(COL_2, name)
        values.put(COL_3, phone)
        values.put(COL_4, image)
        values.put(COL_5, price)
        values.put(COL_6, description)
        values.put(COL_7, foodname)

            id = db.insert(TABLE_NAME, null, values)

            return id>0
    }

    //method to show all data which we stored in database table.
    fun getAllData():Cursor{
        val db:SQLiteDatabase =this.writableDatabase
        var res:Cursor=db.rawQuery("select * from $TABLE_NAME",null)
        // select * means all columns from the row.
        return res
    }

    //to update previously added data with giving id(to reach at tht data)
    fun updateData(id:String?,name:String, phone:String):Boolean{
        val db:SQLiteDatabase=this.writableDatabase

        val values: ContentValues = ContentValues()
        values.put(COL_2, name)
        values.put(COL_3, phone)

        db.update(TABLE_NAME,values,COL_1+"=?", arrayOf(id))
        return true
    }

    //to delete row
    fun deleteTask(_id: String): Boolean {
        val db = this.writableDatabase
        val success = db.delete(TABLE_NAME, "$COL_1=?", arrayOf(_id.toString())).toLong()
        db.close()
        return Integer.parseInt("$success") != -1
    }

    //to take order in the cart
    fun getOrders() : ArrayList<OrderModel>{
        val orders=ArrayList<OrderModel>()
        val db:SQLiteDatabase=this.writableDatabase
        val cursor:Cursor=db.rawQuery("select id,name,phone,image,price,foodname  from $TABLE_NAME",null)

       // if(cursor.moveToFirst()){  this skips first order
            while (cursor.moveToNext()){
                 val order= OrderModel(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getInt(3),
                          cursor.getString(4),cursor.getString(5))
//                order.id= cursor.getInt(0)      this type of assign will produce crash
//                order.name= cursor.getString(1)
//                order.phone= cursor.getString(2)
//                order.pic= cursor.getInt(3)
//                order.price= cursor.getString(4)
//                order.foodname= cursor.getString(5)

                orders.add(order)

            }
      //  }
        return orders
    }
}