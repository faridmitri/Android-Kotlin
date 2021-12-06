package com.fm.apireadgithub.Network

import com.fm.apireadgithub.ModelGit
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface InterfaceApi {
    @GET("repositories")
    fun getApiResult(
        @Query("q") q: String?,
        @Query("sort") sort:String?,
        @Query("order") order:String?,
        @Query("page") page:Int?,

    ): Call<ModelGit>
}