package com.vishnevskiypro.splitcost.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "cost_table")
class Cost(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val date: String,
    val description: String,
    val amount: Float,
    val user_id: Int,
    val trip_id: Int
) : Parcelable