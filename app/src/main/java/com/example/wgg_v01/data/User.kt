package com.example.wgg_v01.data


import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    val userId: Int,
    val username: String,
    val password: String,
)
