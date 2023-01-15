package com.example.wgg_v01.data.realtions

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.Date

@Parcelize
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
): Parcelable
