package com.vishnevskiypro.splitcost.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.vishnevskiypro.splitcost.data.dao.CostDao
import com.vishnevskiypro.splitcost.data.dao.PersonDao
import com.vishnevskiypro.splitcost.data.dao.TripDao
import com.vishnevskiypro.splitcost.model.Cost
import com.vishnevskiypro.splitcost.model.Person
import com.vishnevskiypro.splitcost.model.Trip


@Database(
    entities =[Trip::class, Person::class, Cost::class],
    version = 1,
    exportSchema = false)
abstract class SplitCostDatabase : RoomDatabase(){

    abstract fun personDao(): PersonDao
    abstract fun tripDao(): TripDao
    abstract fun costDao(): CostDao

    companion object{

        @Volatile
        private var INSTANCE: SplitCostDatabase? = null

        fun getDatabase(context: Context) : SplitCostDatabase {
            val tempInstance = INSTANCE

            if (tempInstance != null){
                return tempInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SplitCostDatabase::class.java,
                    "split_cost_db"
                ).build()

                INSTANCE = instance
                return instance
            }

        }

    }

}