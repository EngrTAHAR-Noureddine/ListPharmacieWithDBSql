package com.example.mylistpharmacie.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PharmacieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(pharmacie: Pharmacie)

    @Query("SELECT * FROM pharmacie_table ORDER BY pharmacieId ASC ")
    fun getAllPharmacies(): LiveData<List<Pharmacie>>

}