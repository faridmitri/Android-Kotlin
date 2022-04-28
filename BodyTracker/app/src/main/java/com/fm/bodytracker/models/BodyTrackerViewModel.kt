package com.fm.bodytracker.models

import android.util.Log
import androidx.lifecycle.*
import com.fm.bodytracker.database.Profile
import com.fm.bodytracker.database.ProfileDao
import kotlinx.coroutines.launch

class BodyTrackerViewModel (private val profileDao: ProfileDao): ViewModel() {

    private val _birthdaydte = MutableLiveData<String?>()
       val birthdaydte:LiveData<String?>  = _birthdaydte

    private val _gender = MutableLiveData<String?>()
        val gender:LiveData<String?> = _gender

    private val _unitHeight = MutableLiveData<String?>()
    val unitHeight:LiveData<String?> = _unitHeight


    fun selectUnit(unitSelected: String) {
        _unitHeight.value = unitSelected
         Log.i("item",unitHeight.value.toString())
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

    //check if fields are not empty
    fun isEntryValid(name: String, height: String, hUnit: String,dateOfBirth:String,gender:String): Boolean {
        if (name.isBlank() || height.isBlank() || hUnit.isBlank()|| dateOfBirth.isBlank() || gender.isBlank()) {
            return false
        }
        return true
    }
    //Interact with database View Model

    private fun insertProfile(profile: Profile){
        viewModelScope.launch { profileDao.insert(profile) }
    }


    private fun getNewItemEntry(name: String, height: String, hUnit: String,dateOfBirth:String,gender:String): Profile {
        return Profile(
            name = name,
            height = height.toFloat(),
            hUnit = hUnit,
            dateOfBirth = dateOfBirth,
            gender = gender
        )
    }

    fun addNewItem(name: String, height: String, hUnit: String,dateOfBirth:String,gender:String) {
        val newItem = getNewItemEntry(name, height, hUnit,dateOfBirth,gender)
        insertProfile(newItem)
    }



}


class BodyTrackerViewModelFactory(private val profileDao:ProfileDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BodyTrackerViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return BodyTrackerViewModel(profileDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

    private fun insertItem(profile: Profile) {


    }

}