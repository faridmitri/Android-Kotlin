package com.fm.apireadgithub.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fm.apireadgithub.Network.RetroInstance
import com.fm.apireadgithub.Network.RetroService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelGit: ViewModel(){

    lateinit var recyclerListData: MutableLiveData<ModelGit>


    init {
        recyclerListData = MutableLiveData()
    }

    fun getRecyclerListDataObserver(): MutableLiveData<ModelGit> {
        return recyclerListData
    }

    fun makeAPICall(q:String,sort:String,order:String) {

        val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
        val call = retroInstance.getApiResult(q,sort,order)
        call.enqueue(object : Callback<ModelGit> {
            override fun onFailure(call: Call<ModelGit>, t: Throwable) {
                recyclerListData.postValue(null)
            }

            override fun onResponse(call: Call<ModelGit>, response: Response<ModelGit>) {
                if(response.isSuccessful){
                    recyclerListData.postValue(response.body())
                } else {
                    recyclerListData.postValue(null)
                }
            }
        })
    }

}

