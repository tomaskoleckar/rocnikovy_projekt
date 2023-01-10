package com.example.wgg_v01.data

import androidx.lifecycle.LiveData
import com.example.wgg_v01.MyApp.Companion.loggedUser
import com.example.wgg_v01.data.realtions.UserExerciseRef

class UserRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.readAllData()

    val readAllExe: LiveData<List<Exercise>> = userDao.readAllExe()

    val getExercisesOfUsers: LiveData<List<UserExerciseRef>> = userDao.getExercisesOfUsers()

    fun addUser(user: User){
        userDao.addUser(user)
    }
    suspend fun insertUserExerciseRef(crossRef: UserExerciseRef){
        userDao.insertUserExerciseRef(crossRef)
    }
    suspend fun getPerfData(userId: Int, exerciseName: String): LiveData<List<UserExerciseRef>>{
        return userDao.getPerfData(userId,exerciseName)
    }
}