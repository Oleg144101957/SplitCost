package com.vishnevskiypro.splitcost.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MydbHelper(context: Context) : SQLiteOpenHelper(context,
    DbConstants.DB_NAME, null,
    DbConstants.DB_VERSION) {


    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(DbConstants.CREATE_TRIP_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(DbConstants.DROP_TRIP_TABLE)
        onCreate(db)
    }
}