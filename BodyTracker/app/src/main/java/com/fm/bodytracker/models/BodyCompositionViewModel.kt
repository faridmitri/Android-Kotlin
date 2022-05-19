package com.fm.bodytracker.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.fm.bodytracker.database.Body
import com.fm.bodytracker.database.ProfileDao
import kotlinx.coroutines.launch

class BodyCompositionViewModel (private val profileDao: ProfileDao) : ViewModel(){

    private fun insertItem(body: Body) {
        viewModelScope.launch {
            profileDao.insert(body)
        }
    }

    private fun getNewItemEntry(id:Int,height:Float,fatMass:Float,muscleMass:Float,bodyWater:Float,boneMass:Float,date:String): Body{
        return Body(
            id = id,
            height = height,
            fatMass = fatMass,
            muscleMass = muscleMass,
            bodyWater = bodyWater,
            boneMass = boneMass,
            date = date
        )
    }

    fun addNewItem(id:Int,height:Float,fatMass:Float,muscleMass:Float,bodyWater:Float,boneMass:Float,date:String) {
        val newItem = getNewItemEntry(id,height,fatMass,muscleMass,bodyWater,boneMass,date)
        insertItem(newItem)
    }


}

class BodyCompositionFactory(private val profileDao: ProfileDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BodyCompositionViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return BodyCompositionViewModel(profileDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}
