package com.fm.apireadgithub.Network

import com.fm.apireadgithub.model.ModelGit
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {

    @GET("repositories")
    fun getApiResult(
        @Query("q") q: String?,
        @Query("sort") sort:String?,
        @Query("order") order:String?,
        ): Call<ModelGit>
}