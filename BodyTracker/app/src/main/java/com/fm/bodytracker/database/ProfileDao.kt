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

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(body: Body)

    @Update
    suspend fun update(body: Body)

    @Query ("Select * From bodyCompositionTable Where id= :id")
    fun getdata(id:Int): Flow<Body>

    @Query ("Select * From bodyCompositionTable Order By date ASC ")
    fun getAllData(): Flow<List<Body>>
}