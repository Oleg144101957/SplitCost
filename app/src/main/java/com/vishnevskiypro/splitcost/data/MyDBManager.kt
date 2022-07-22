package com.vishnevskiypro.splitcost.data

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class MyDBManager(context: Context) {

    val myDBHelper: MydbHelper = MydbHelper(context)
    var db: SQLiteDatabase? = null

    fun openDb(){
        db = myDBHelper.writableDatabase
    }

    fun insertToTripTable(name: String, avatar: String){
        val cv = ContentValues()
        cv.put(DbConstants.TRIP_NAME, name)
        cv.put(DbConstants.TRIP_AVATAR, avatar)
        db?.insert(DbConstants.TABLE_TRIP, null, cv)

    }

    fun getFromDb() : List<String>{
        val tempList = ArrayList<String>()
        val cursor: Cursor? = db?.query(
            DbConstants.TABLE_TRIP,
            null,
            null,
            null,
            null,
            null,
            null
        )

        if (cursor != null) {
            while (cursor.moveToNext()){
                val nameText = cursor.getString(cursor.getColumnIndexOrThrow(DbConstants.TRIP_NAME))
                tempList.add(nameText)
            }
        }
        cursor?.close()
        return tempList
    }

    fun closeDB(){
        myDBHelper.close()
    }

}