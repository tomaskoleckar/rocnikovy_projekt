package com.example.wgg_v01.data

import android.content.Context
import android.service.autofill.UserData
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.wgg_v01.data.realtions.UserExerciseRef
import com.example.wgg_v01.data.realtions.UserWithExercises


@Database(entities = [User::class,Exercise::class,UserExerciseRef::class], version = 1, exportSchema = false)
abstract class UserDataBase: RoomDatabase(){

    abstract fun userDao(): UserDao

    companion object{
        @Volatile
        private var INSTANCE: UserDataBase? = null


    fun getDatabase(context: Context): UserDataBase{
        val tempInstance = INSTANCE
        if(tempInstance != null){
            return tempInstance
        }
        synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                UserDataBase::class.java,
                "users"
            ).createFromAsset("database/users.db").build()
            INSTANCE = instance
            return instance
        }
        }
    }

}