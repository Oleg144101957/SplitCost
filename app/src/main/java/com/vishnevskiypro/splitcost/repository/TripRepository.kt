package com.vishnevskiypro.splitcost.repository

import androidx.lifecycle.LiveData
import com.vishnevskiypro.splitcost.data.dao.TripDao
import com.vishnevskiypro.splitcost.model.Trip

class TripRepository(private val tripDao: TripDao) {


    val readAllTrips : LiveData<List<Trip>> = tripDao.readAllTrips()


    fun addTrip(trip: Trip){
        tripDao.addTrip(trip)
    }

    fun deleteTrip(trip: Trip){
        tripDao.deleteTrip(trip)
    }

    fun updateTrip(trip: Trip){
        tripDao.updateTrip(trip)
    }


}