package com.example.mylistpharmacie.listpharmacie


import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mylistpharmacie.db.PharmacieDao

class ListPharmacieFactory (
    private val dataSource: PharmacieDao,
    private val context: Context,
): ViewModelProvider.Factory {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListPharmacieViewModel::class.java)) {
            return ListPharmacieViewModel(dataSource,context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}