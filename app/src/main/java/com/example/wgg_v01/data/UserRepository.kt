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
    suspend fun updatePerf(crossRef: UserExerciseRef){
        userDao.updatePerf(crossRef)
    }
    suspend fun deletePerf(crossRef: UserExerciseRef){
        userDao.deletePerf(crossRef)
    }

    fun getPerfData(userId: Int, exerciseName: String, date: String): LiveData<List<UserExerciseRef>>{
        return userDao.getPerfData(userId,exerciseName, date)
    }
    fun getExeData(userId: Int, exerciseName: String): LiveData<List<UserExerciseRef>>{
        return userDao.getExeData(userId,exerciseName)
    }
}