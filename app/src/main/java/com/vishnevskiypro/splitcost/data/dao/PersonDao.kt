package com.vishnevskiypro.splitcost.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.vishnevskiypro.splitcost.model.Person


@Dao
interface PersonDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addPerson(person: Person)

    @Delete
    fun deletePerson(person: Person)

    @Update
    fun updatePerson(person: Person)

    @Query("SELECT * FROM person_table")
    fun readAllPersons(): LiveData<List<Person>>



}