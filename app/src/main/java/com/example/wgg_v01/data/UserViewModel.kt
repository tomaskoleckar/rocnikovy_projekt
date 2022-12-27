package com.example.wgg_v01.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class UserViewModel(application: Application): AndroidViewModel(application) {

    val readALlData: LiveData<List<User>>

    val readAllExe: LiveData<List<Exercise>>

    private val repository: UserRepository


    init{
        val userDao = UserDataBase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        readALlData = repository.readAllData
        readAllExe = repository.readAllExe
    }

    fun addUser(user: User){
        viewModelScope.launch(Dispatchers.IO){
            repository.addUser(user)
        }
    }

    fun readAllData(username: String, password: String){
        println(readALlData)
    }

    fun readAllExe(){
        println(readAllExe)
    }

}