package com.fm.apireadgithub.model

data class ModelGit(val item:ArrayList<Items>)
data class Items(val name:String, val owner: Owners, val description:String, val stargazers_count:Int)
data class Owners(val login:String, val avatar_url:String)