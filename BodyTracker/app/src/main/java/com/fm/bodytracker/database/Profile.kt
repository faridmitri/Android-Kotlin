package com.fm.bodytracker.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.DateFormat

@Entity (tableName = "profile")
data class Profile(
    @PrimaryKey (autoGenerate = true) val id: Long = 0L,
    @ColumnInfo(name = "userName") val name:String?,
    @ColumnInfo(name = "height") val height:Float?,
    @ColumnInfo(name = "heightUnit") val hUnit:String?,
    @ColumnInfo(name = "DateOfBirth")  val DateOfBirth : String?,
    @ColumnInfo(name= "Gender") val Gender:String?
    
)