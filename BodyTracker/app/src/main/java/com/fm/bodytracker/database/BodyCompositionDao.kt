package com.fm.bodytracker.database

import android.content.ClipData
import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface BodyCompositionDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(body: Body)

    @Update
    suspend fun update(body: Body)

    @Query ("Select * From bodyCompositionTable Where id= :id")
    fun getdata(id:Int): Flow<Body>

    @Query ("Select * From bodyCompositionTable Order By date ASC ")
    fun getAllData(): Flow<List<Body>>


}