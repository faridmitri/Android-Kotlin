package com.fm.bodytracker.database

import androidx.room.*

@Dao
interface ProfileDao {

    @Insert
    suspend fun insert (Profile: Profile)

    @Update
    suspend  fun update (Profile: Profile)

    @Query("SELECT * FROM profileTable ORDER BY id DESC LIMIT 1")
    suspend fun getProfile():  Profile?

    @Query("DELETE FROM profileTable")
    suspend fun delete (Profile: Profile)
}