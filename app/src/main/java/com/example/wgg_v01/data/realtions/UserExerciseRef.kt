package com.example.wgg_v01.data.realtions

import androidx.room.Entity
import java.util.Date


@Entity(primaryKeys = ["userId", "exerciseId"])
data class UserExerciseRef(
    val userId: Int,
    val exerciseId: Int,
    val date: String,
    val weight: Int,
    val series: Int,
    val reps: Int,
)
