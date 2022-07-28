package com.vishnevskiypro.splitcost.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "person_table")
class Person(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val avatar: String
) : Parcelable