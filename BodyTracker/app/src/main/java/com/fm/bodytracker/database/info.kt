package com.fm.bodytracker.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.DateFormat

@Entity (tableName = "profile")
data class info(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "userName") val name:String?,
    @ColumnInfo(name = "height") val height:Float?,
    @ColumnInfo(name = "heightUnit") val hUnit:String?,
    @ColumnInfo(name = "DateOfBirth")  val DateOfBirth : String?,
    @ColumnInfo(name= "Gender") val Gender:String?
    
)
