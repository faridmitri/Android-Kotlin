package com.fm.bodytracker.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.DateFormat

@Entity (tableName = "profileTable")
data class Profile(
    @PrimaryKey  val id: Int,
    @ColumnInfo(name = "userName") val name:String?,
    @ColumnInfo(name = "height") val height:String?,
    @ColumnInfo(name = "heightUnit") val hUnit:String?,
    @ColumnInfo(name = "DateOfBirth")  val dateOfBirth : String?,
    @ColumnInfo(name= "Gender") val gender:String?
    
)
