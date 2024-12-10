package com.example.myapplication.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "theater")
data class Theater(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val theaterName: String,
    val branchCode: String
)