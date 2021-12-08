package com.fm.apireadgithub.model



import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fm.apireadgithub.Network.RetroInstance
import com.fm.apireadgithub.Network.RetroService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*


class ViewModelGit: ViewModel(){

    private var recyclerListData: MutableLiveData<ModelGit> = MutableLiveData()


    fun getRecyclerListDataObserver(): MutableLiveData<ModelGit> {
        return recyclerListData
    }

    fun makeAPICall() {
        val time:String=getPast30Days()
        viewModelScope.launch (Dispatchers.IO) {
            val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
            val response =  retroInstance.getApiResult(time)
            recyclerListData.postValue(response)


        }

    }


    //function to get the last 30 days
    private fun getPast30Days():String{
        var past30days=""
        val calendar= Calendar.getInstance()
        calendar.add(Calendar.DAY_OF_YEAR,-30)
        val formatter= SimpleDateFormat("yyyy-MM-dd")
        past30days=formatter.format(calendar.time)
        return "created>$past30days"
    }

}

