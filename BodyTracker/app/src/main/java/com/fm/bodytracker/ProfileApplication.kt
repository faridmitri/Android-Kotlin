package com.fm.bodytracker

import android.app.Application
import com.fm.bodytracker.database.ProfileRoomDatabase

class ProfileApplication : Application() {
    val database : ProfileRoomDatabase by lazy{ProfileRoomDatabase.getDatabase(this)}
}