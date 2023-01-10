package com.example.wgg_v01.data.realtions

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date


@Entity(tableName = "usersRef")
data class UserExerciseRef(
    @PrimaryKey(autoGenerate = true)
    val userExId: Int,
    val userId: Int,
    val exerciseName: String,
    val exercisePart: String,
    val date: String,
    val weight: Int,
    val series: Int,
    val reps: Int,
)
