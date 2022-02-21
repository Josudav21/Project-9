package com.example.project9.local_db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "orang_ngutang")
data class User(
    @PrimaryKey(autoGenerate = true)
//    @ColumnInfo(name = "use_id")
    val id: Int? = null,
    val name: String,
    val email: String,
    @ColumnInfo(name = "phone_number")
    val phoneNumber: String
)
