package com.vishnevskiypro.splitcost.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.vishnevskiypro.splitcost.model.Cost


@Dao
interface CostDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addCost(cost: Cost)

    @Update
    fun updateCost(cost: Cost)

    @Delete
    fun deleteCost(cost: Cost)

    @Query("SELECT * FROM cost_table ORDER BY id ASC")
    fun readAllCostOfTrip() : LiveData<List<Cost>>



}