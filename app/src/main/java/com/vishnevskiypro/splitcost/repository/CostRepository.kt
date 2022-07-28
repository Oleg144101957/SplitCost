package com.vishnevskiypro.splitcost.repository

import androidx.lifecycle.LiveData
import com.vishnevskiypro.splitcost.data.dao.CostDao
import com.vishnevskiypro.splitcost.model.Cost

class CostRepository(private val costDao: CostDao) {

    val readAllCosts : LiveData<List<Cost>> = costDao.readAllCostOfTrip()

    fun addCost(cost: Cost){
        costDao.addCost(cost)
    }

    fun updateCost(cost: Cost){
        costDao.updateCost(cost)
    }

    fun deleteCost(cost: Cost){
        costDao.deleteCost(cost)
    }



}