package com.vishnevskiypro.splitcost.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.vishnevskiypro.splitcost.data.SplitCostDatabase
import com.vishnevskiypro.splitcost.model.Cost
import com.vishnevskiypro.splitcost.repository.CostRepository

class CostViewModel(application: Application) : AndroidViewModel(application) {
    val readAllCosts: LiveData<List<Cost>>
    private val repositoryCost: CostRepository

    init {
        val costDao = SplitCostDatabase.getDatabase(application).costDao()
        repositoryCost = CostRepository(costDao)
        readAllCosts = repositoryCost.readAllCosts
    }
}