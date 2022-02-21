package com.example.project9.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project9.local_db.UserDAO
import com.example.project9.local_db.entity.User
import com.example.project9.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val repo: UserRepository
) : ViewModel() {

    val users = repo.getAllUsers()

    fun deleteUserFromDB(user: User) = viewModelScope.launch {
        repo.deleteUser(user)
    }

    fun insertUserToDB(user: User) = viewModelScope.launch {
        repo.insertNewUser(user)
    }
}