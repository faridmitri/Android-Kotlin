package com.fm.apireadgithub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fm.apireadgithub.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var myadapter : AdapterGit
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       initRecyclerView(binding.recyclerView)
    }


    fun initRecyclerView(recyclerView: RecyclerView){
            recyclerView.apply{
            layoutManager = LinearLayoutManager(context)
            myadapter = AdapterGit()
            adapter = myadapter

        }
    }
}

