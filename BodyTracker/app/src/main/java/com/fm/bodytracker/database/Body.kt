package com.fm.bodytracker.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bodyCompositionTable")
data class Body (
    @PrimaryKey(autoGenerate = true)  val id: Int,
    @ColumnInfo(name = "height") val height: Float?,
    @ColumnInfo(name = "fatMass") val fatMass: Float?,
    @ColumnInfo(name = "muscleMass") val muscleMass: Float?,
    @ColumnInfo(name = "bodyWater") val bodyWater: Float?,
    @ColumnInfo(name = "boneMass") val boneMass: Float?,
    @ColumnInfo(name = "date")  val date : String?

)