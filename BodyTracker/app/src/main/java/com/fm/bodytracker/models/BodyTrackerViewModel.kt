package com.fm.bodytracker.models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BodyTrackerViewModel : ViewModel() {

    private val _birthdaydte = MutableLiveData<String?>()
       val birthdaydte:LiveData<String?>  = _birthdaydte

    private val _gender = MutableLiveData<String?>()
        val gender:LiveData<String?> = _gender


    fun selectUnit(unitSelected: String) {
          Log.i("item",unitSelected)
    }

    fun birthday(year:Int,month:Int,day:Int) {

        val selectedMonth = month + 1
        _birthdaydte.value = year.toString() + "-" + selectedMonth .toString() + "-" + day.toString()
        //Log.i("time", year.toString() + "-" + selectedMonth.toString() + "-" + day.toString())
    }

    fun gender(gender:String?) {
        _gender.value = gender
        Log.i("Gender",gender.toString())
    }

}