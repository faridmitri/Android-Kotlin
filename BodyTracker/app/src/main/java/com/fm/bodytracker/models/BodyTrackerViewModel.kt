package com.fm.bodytracker.models

import android.util.Log
import android.view.View
import android.widget.AdapterView
import androidx.lifecycle.ViewModel

class BodyTrackerViewModel : ViewModel() {


    fun selectUnit(unitSelected: String) {
          Log.i("item",unitSelected)

    }

}