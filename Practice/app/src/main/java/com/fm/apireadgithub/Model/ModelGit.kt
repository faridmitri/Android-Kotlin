package com.fm.apireadgithub

data class ModelGit(val item:Items)
data class Items(val name:String,val owner:Owners,val description:String,val stargazers_count:Int)
data class Owners(val login:String, val avatar_url:String)