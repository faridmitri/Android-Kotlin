package com.fm.apireadgithub

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.fm.apireadgithub.Network.InterfaceApi
import com.fm.apireadgithub.Network.RetrofitInstance
import com.fm.apireadgithub.Network.URLApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ViewModelGit(application: Application):AndroidViewModel(application) {
    lateinit var mutableLiveData: MutableLiveData<ModelGit>

    init{
        mutableLiveData = MutableLiveData()
    }

    fun getRecyclerListDataObserver():MutableLiveData<ModelGit>{
        return mutableLiveData
    }

    fun gitRepos(page:Int = 1){
        val address = URLApi()
        val retrofitInstance = RetrofitInstance.getRetrofitInstance().create(InterfaceApi::class.java)
        val call = retrofitInstance.getApiResult(address.q,address.sort,address.order,page)
        call.enqueue(object:Callback<ModelGit>{
            override fun onResponse(call: Call<ModelGit>, response: Response<ModelGit>) {
                Log.d("log","Running")
                mutableLiveData.postValue(response.body())
                Log.d("log",response.body().toString())
            }

            override fun onFailure(call: Call<ModelGit>, t: Throwable) {
                Log.e("log","Error")
            }


        })
        }

}