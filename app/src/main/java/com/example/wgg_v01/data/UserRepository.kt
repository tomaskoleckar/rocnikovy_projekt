package com.example.wgg_v01.data

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.readAllData()

    val readAllExe: LiveData<List<Exercise>> = userDao.readAllExe()

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }
}