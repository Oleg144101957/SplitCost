package com.vishnevskiypro.splitcost.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "trip_table")
data class Trip(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val tripName: String,
    val tripPerson: String,
    val avatarTrip: String
) : Parcelable