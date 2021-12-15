package com.example.mylistpharmacie.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Pharmacie::class], version = 1, exportSchema = false)
abstract class PharmacieDB :RoomDatabase() {

    abstract fun PharmacieDao() : PharmacieDao


    companion object {
        private var INSTANCE: PharmacieDB? = null

        fun getInstance(context: Context): PharmacieDB? {
            if (INSTANCE == null) {
                synchronized(PharmacieDB::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        PharmacieDB::class.java, "Pharmacie.db")
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}