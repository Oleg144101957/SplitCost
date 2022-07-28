package com.vishnevskiypro.splitcost.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.vishnevskiypro.splitcost.data.SplitCostDatabase
import com.vishnevskiypro.splitcost.model.Trip
import com.vishnevskiypro.splitcost.repository.TripRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TripViewModel(application: Application) : AndroidViewModel(application) {

    val readAllTrips: LiveData<List<Trip>>
    private val repositoryTrip: TripRepository

    init {
        val tripDao = SplitCostDatabase.getDatabase(application).tripDao()
        repositoryTrip = TripRepository(tripDao)
        readAllTrips = repositoryTrip.readAllTrips
    }

    fun addTripToTable(trip: Trip){
        viewModelScope.launch (Dispatchers.IO){
            repositoryTrip.addTrip(trip)
        }
    }



}