package com.example.wgg_v01.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "exercises")
data class Exercise(
    @PrimaryKey(autoGenerate = true)
    val exerciseId: Int,
    val name: String,
    val part: String,
)