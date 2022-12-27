package com.example.wgg_v01.data.realtions

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.wgg_v01.data.Exercise
import com.example.wgg_v01.data.User

data class UserWithExercises(
    @Embedded val user: User,
    @Relation(
        parentColumn = "userId",
        entityColumn = "exerciseId",
        associateBy = Junction(UserExerciseRef::class)
    )
    val exercises: List<Exercise>
)