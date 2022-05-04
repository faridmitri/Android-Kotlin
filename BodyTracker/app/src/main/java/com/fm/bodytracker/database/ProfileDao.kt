package com.fm.bodytracker.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ProfileDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert  (profile: Profile)

    @Update
    suspend  fun update (profile: Profile)

    @Query("SELECT * FROM profileTable WHERE id = :id")
     fun getProfile(id:Int): Flow<Profile>


}