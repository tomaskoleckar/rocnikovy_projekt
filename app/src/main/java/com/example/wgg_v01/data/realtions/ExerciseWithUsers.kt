package com.example.wgg_v01.data.realtions

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.wgg_v01.data.Exercise
import com.example.wgg_v01.data.User

data class ExerciseWithUsers(
    @Embedded val exercise: Exercise,
    @Relation(
        parentColumn = "exerciseId",
        entityColumn = "userId",
        associateBy = Junction(UserExerciseRef::class)
    )
    val users: List<User>
)