package com.example.project9.local_db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.project9.local_db.entity.User

//data access objext -> isinya function buat ngubah' database
@Dao
interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("SELECT * FROM orang_ngutang")
    fun getAllUsers(): LiveData<List<User>>
//    suspend fun getAllUsers(): List<User>
}