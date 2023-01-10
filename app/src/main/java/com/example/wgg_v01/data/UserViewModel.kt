package com.example.wgg_v01.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.wgg_v01.data.realtions.UserExerciseRef
import com.example.wgg_v01.data.realtions.UserWithExercises
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class UserViewModel(application: Application): AndroidViewModel(application) {

    val readALlData: LiveData<List<User>>

    val readAllExe: LiveData<List<Exercise>>

    val getExercisesOfUsers: LiveData<List<UserExerciseRef>>

    private val repository: UserRepository


    init{
        val userDao = UserDataBase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        readALlData = repository.readAllData
        readAllExe = repository.readAllExe
        getExercisesOfUsers = repository.getExercisesOfUsers
    }

    fun addUser(user: User){
        viewModelScope.launch(Dispatchers.IO){
            repository.addUser(user)
        }
    }

    fun insertUserExerciseRef(userExerciseRef: UserExerciseRef){
        viewModelScope.launch(Dispatchers.IO){
            repository.insertUserExerciseRef(userExerciseRef)
        }
    }

    fun readAllData(username: String, password: String){
        println(readALlData)
    }

    fun readAllExe(){
        println(readAllExe)
    }


}