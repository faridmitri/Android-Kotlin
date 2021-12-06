package com.fm.apireadgithub.Network

import java.text.SimpleDateFormat
import java.util.*

class URLApi {
    val past30days:String
    init {
        val calender = Calendar.getInstance()
        calender.add(Calendar.DAY_OF_YEAR,-30)
        val format = SimpleDateFormat("yyyy-mm-dd")
        past30days = format.format(calender.time)
    }


    val baseURL:String = "https://api.github.com/search"
    val q:String = "created%3A>$past30days"
    val sort:String = "stars"
    val order:String = "desc"

}