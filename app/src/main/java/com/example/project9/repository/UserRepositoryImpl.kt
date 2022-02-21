package com.example.project9.repository

import androidx.lifecycle.LiveData
import com.example.project9.local_db.UserDAO
import com.example.project9.local_db.entity.User

class UserRepositoryImpl(
    private val dao: UserDAO
) : UserRepository {

    override suspend fun insertNewUser(user: User) {
        dao.insertNewUser(user)
    }

    override suspend fun deleteUser(user: User) {
        dao.deleteUser(user)
    }

    override fun getAllUsers(): LiveData<List<User>> {
        return dao.getAllUsers()
    }


}