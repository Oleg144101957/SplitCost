package com.vishnevskiypro.splitcost.data

import androidx.room.TypeConverter
import com.vishnevskiypro.splitcost.model.Person
import java.util.*

class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let {
            Date(it)
        }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long?{
        return date?.time?.toLong()
    }

    @TypeConverter
    fun fromListPersons(listOfPersons: List<Person>) : String {
        return listOfPersons.joinToString("-")
    }

    @TypeConverter
    fun toListOfPersons(stringOfData: String) : List<Person> {

        return emptyList()
    }


}