package com.vishnevskiypro.splitcost.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.vishnevskiypro.splitcost.model.Trip


@Dao
interface TripDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addTrip(trip: Trip)

    @Delete
    fun deleteTrip(trip: Trip)

    @Update
    fun updateTrip(trip: Trip)

    @Query("SELECT * FROM trip_table ORDER BY id ASC")
    fun readAllTrips() : LiveData<List<Trip>>

}