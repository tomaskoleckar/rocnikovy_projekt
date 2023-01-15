package com.example.wgg_v01.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.wgg_v01.data.realtions.UserExerciseRef
import com.example.wgg_v01.data.realtions.UserWithExercises
import java.util.concurrent.Flow


@Dao
interface UserDao {



    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addUser(user: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserExerciseRef(crossRef: UserExerciseRef)

    @Update
    suspend fun updatePerf(crossRef: UserExerciseRef)

    @Delete
    suspend fun deletePerf(crossRef: UserExerciseRef)

    @Query("SELECT * FROM users ORDER BY userId ASC")
    fun readAllData(): LiveData<List<User>>

    @Query("SELECT * FROM users WHERE username = :username AND password = :password")
    suspend fun findUser(username: String, password: String): User

    @Query("SELECT * FROM exercises ORDER BY part ASC")
    fun readAllExe(): LiveData<List<Exercise>>

    @Transaction
    @Query("SELECT * FROM usersRef ORDER BY date DESC,exercisePart")
    fun getExercisesOfUsers(): LiveData<List<UserExerciseRef>>

    @Query("SELECT * FROM usersRef WHERE userId = :userId AND exerciseName = :exerciseName AND date = :date ORDER BY userExId")
    fun getPerfData(userId: Int, exerciseName: String, date: String): LiveData<List<UserExerciseRef>>

    @Query("SELECT * FROM usersRef WHERE userId = :userId AND exerciseName = :exerciseName ORDER BY userExId DESC")
    fun getExeData(userId: Int, exerciseName: String): LiveData<List<UserExerciseRef>>

    @Query("SELECT * FROM exercises WHERE name LIKE :searchQuery OR part LIKE :searchQuery")
    fun searchExe(searchQuery: String): LiveData<List<Exercise>>
}