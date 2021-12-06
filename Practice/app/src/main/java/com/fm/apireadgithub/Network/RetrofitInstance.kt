package com.fm.apireadgithub.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    companion object{
        fun getRetrofitInstance():Retrofit{
            var address = URLApi()
            return Retrofit.Builder().
                baseUrl(address.baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}