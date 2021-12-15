package com.example.mylistpharmacie.db

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import androidx.room.Entity


@Entity(tableName = "pharmacie_table")
data class Pharmacie (

    @PrimaryKey(autoGenerate = true)
    var pharmacieId: Long = 0L,

    @ColumnInfo(name = "name")
    var name: String = "",

    @ColumnInfo(name = "address")
    var address: String = "",

    @ColumnInfo(name = "phone")
    var phone: String = "",
)