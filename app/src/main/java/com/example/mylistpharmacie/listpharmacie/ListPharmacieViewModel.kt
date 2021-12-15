package com.example.mylistpharmacie.listpharmacie

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mylistpharmacie.db.Pharmacie
import com.example.mylistpharmacie.db.PharmacieDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListPharmacieViewModel(private val database: PharmacieDao, private val context: Context?) : ViewModel() {
    var pharmacies = database.getAllPharmacies()
    private var pref : SharedPreferences? = null

    init {
        initializePharmacie()
    }
    private fun initializePharmacie() {
        this. pref = context?.getSharedPreferences("firstTime", Context.MODE_PRIVATE)

        if(getData() != null && getData()!! ){
            for (i in 1..10){
                val pharmacie = Pharmacie()
                pharmacie.name = "Pharmacie $i"
                pharmacie.phone = "123456789"
                pharmacie.address = "Algiers, Algeria"
                viewModelScope.launch {
                    insert(pharmacie)
                }
            }
            saveData(false)
            viewModelScope.launch {
                pharmacies = database.getAllPharmacies()
            }
        }else{
            viewModelScope.launch {
                pharmacies = database.getAllPharmacies()
            }
        }


    }


    private suspend fun insert(operationSyntax: Pharmacie) {
        withContext(Dispatchers.IO) {
            database.insert(operationSyntax)
        }
    }






    private fun saveData(firstTime:Boolean){
        val editor : SharedPreferences.Editor? = this.pref?.edit()
        editor?.apply{
            putBoolean("firstTime",firstTime)
        }?.apply()
    }
    private fun getData(): Boolean? {
        return this.pref?.getBoolean("firstTime",true)
    }
}