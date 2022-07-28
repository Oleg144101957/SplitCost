package com.vishnevskiypro.splitcost.repository

import androidx.lifecycle.LiveData
import com.vishnevskiypro.splitcost.data.dao.PersonDao
import com.vishnevskiypro.splitcost.model.Person

class PersonRepository(private val personDao: PersonDao) {

    val readAllPersons: LiveData<List<Person>> = personDao.readAllPersons()

    fun addPerson(person: Person){
        personDao.addPerson(person)
    }

    fun deletePerson(person: Person){
        personDao.deletePerson(person)
    }

    fun updatePerson(person: Person){
        personDao.updatePerson(person)
    }

}