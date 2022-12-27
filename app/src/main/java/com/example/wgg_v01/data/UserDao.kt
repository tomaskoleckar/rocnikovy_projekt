package com.example.wgg_v01.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.wgg_v01.data.realtions.UserExerciseRef
import com.example.wgg_v01.data.realtions.UserWithExercises



@Dao
interface UserDao {



    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addUser(user: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserExerciseRef(crossRef: UserExerciseRef)

    @Query("SELECT * FROM users ORDER BY userId ASC")
    fun readAllData(): LiveData<List<User>>

    @Query("SELECT * FROM users WHERE username = :username AND password = :password")
    suspend fun findUser(username: String, password: String): User

    @Query("SELECT * FROM exercises ORDER BY part ASC")
    fun readAllExe(): LiveData<List<Exercise>>

    @Transaction
    @Query("SELECT * FROM users WHERE username = :username")
    suspend fun getExercisesOfUsers(username: String): List<UserWithExercises>

}