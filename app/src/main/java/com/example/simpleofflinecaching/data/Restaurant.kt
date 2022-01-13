package com.example.simpleofflinecaching.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "restaurant")
data class Restaurant(
    @PrimaryKey val name: String,
    val address: String, val logo: String, val type: String
)
