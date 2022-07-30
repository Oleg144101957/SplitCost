package com.vishnevskiypro.splitcost.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.vishnevskiypro.splitcost.data.SplitCostDatabase
import com.vishnevskiypro.splitcost.model.Cost
import com.vishnevskiypro.splitcost.repository.CostRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CostViewModel(application: Application) : AndroidViewModel(application) {
    val readAllCosts: LiveData<List<Cost>>
    private val repositoryCost: CostRepository

    init {
        val costDao = SplitCostDatabase.getDatabase(application).costDao()
        repositoryCost = CostRepository(costDao)
        readAllCosts = repositoryCost.readAllCosts
    }

    fun addCostToTable(cost: Cost){
        viewModelScope.launch (Dispatchers.IO){
            repositoryCost.addCost(cost)
        }
    }
}