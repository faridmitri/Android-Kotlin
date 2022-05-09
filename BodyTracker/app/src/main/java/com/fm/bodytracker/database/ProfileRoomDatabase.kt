package com.fm.bodytracker.database


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Profile::class,Body::class], version = 1, exportSchema = false)
abstract class  ProfileRoomDatabase :RoomDatabase(){

abstract fun profileDao() : ProfileDao
abstract fun bodyCompositionDao() : BodyCompositionDao

    companion object {
        @Volatile
        private var INSTANCE: ProfileRoomDatabase? = null

        fun getDatabase(context: Context): ProfileRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProfileRoomDatabase::class.java,
                    "profile_database"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }

    }

}