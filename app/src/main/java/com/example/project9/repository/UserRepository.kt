package com.example.project9.repository

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.project9.local_db.entity.User

interface UserRepository {

    suspend fun insertNewUser(user: User)

    suspend fun deleteUser(user: User)

    fun getAllUsers(): LiveData<List<User>>
}