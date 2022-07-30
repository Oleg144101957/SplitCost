package com.vishnevskiypro.splitcost.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "cost_table")
data class Cost(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val date: String,
    val description: String,
    val amount: String,
    val user_id: String,
    val trip_id: String
) : Parcelable