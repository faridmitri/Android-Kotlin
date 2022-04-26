package com.fm.bodytracker.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ProfileDao {

    @Insert
    fun insert (Profile: Profile)

    @Update
    fun update (Profile: Profile)

    @Query("SELECT * FROM profile ORDER BY id DESC LIMIT 1")
    fun getTonight():  Profile?
}