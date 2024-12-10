package com.example.myapplication.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TheaterDao {
    @Insert
    suspend fun insertTheater(theater: Theater): Long


}