package com.vishnevskiypro.splitcost.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.vishnevskiypro.splitcost.data.SplitCostDatabase
import com.vishnevskiypro.splitcost.model.Person
import com.vishnevskiypro.splitcost.repository.PersonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PersonViewModel(application: Application) : AndroidViewModel(application){

    val readAllPersonsData: LiveData<List<Person>>
    private val repositoryPerson: PersonRepository

    init{
        val personDao = SplitCostDatabase.getDatabase(application).personDao()
        repositoryPerson = PersonRepository(personDao)
        readAllPersonsData = repositoryPerson.readAllPersons
    }

    fun addPerson(person: Person){
        viewModelScope.launch (Dispatchers.IO){
            repositoryPerson.addPerson(person)
        }
    }

    fun updatePerson(person: Person){
        viewModelScope.launch (Dispatchers.IO){
            repositoryPerson.updatePerson(person)
        }
    }

    fun deletePerson(person: Person){
        viewModelScope.launch (Dispatchers.IO){  }
        repositoryPerson.deletePerson(person)
    }


}