package com.example.wgg_v01.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.wgg_v01.data.realtions.UserExerciseRef
import com.example.wgg_v01.data.realtions.UserWithExercises
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.Flow


class UserViewModel(application: Application): AndroidViewModel(application) {

    val readALlData: LiveData<List<User>>

    val readAllExe: LiveData<List<Exercise>>

    val getExercisesOfUsers: LiveData<List<UserExerciseRef>>

    private val repository: UserRepository

    private val _userData = MutableLiveData<List<UserExerciseRef>>()
    val userData: LiveData<List<UserExerciseRef>>
        get() = _userData


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

    fun getPerfData(userId: Int, exerciseName: String): LiveData<List<UserExerciseRef>>{
        return repository.getPerfData(userId,exerciseName)
    }

    fun readAllData(username: String, password: String){
        println(readALlData)
    }

    fun readAllExe(){
        println(readAllExe)
    }


}