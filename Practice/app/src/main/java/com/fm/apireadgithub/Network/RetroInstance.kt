package com.fm.apireadgithub.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {

    companion object{
        private const val Base_Url = "https://api.github.com/search/"

        fun getRetroInstance(): Retrofit {

            return Retrofit.Builder()
                .baseUrl(Base_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

}