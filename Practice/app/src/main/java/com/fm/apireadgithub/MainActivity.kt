package com.fm.apireadgithub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.fm.apireadgithub.model.ModelGit
import com.fm.apireadgithub.model.ViewModelGit
import kotlinx.android.synthetic.main.activity_main.*
import android.R.string.no
import com.fm.apireadgithub.model.Items


class MainActivity : AppCompatActivity() {

    lateinit var recyclerViewAdapter: AdapterGit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initRecyclerView()
        createData()
    }

    private fun initRecyclerView() {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            recyclerViewAdapter = AdapterGit()
            adapter = recyclerViewAdapter

            val decoration = DividerItemDecoration(applicationContext, VERTICAL)
            addItemDecoration(decoration)
        }
    }
    private fun createData() {

        val viewModel = ViewModelProvider(this).get(ViewModelGit::class.java)
        viewModel.getRecyclerListDataObserver().observe(this, {

            if (it != null) {
                recyclerViewAdapter.setUpdatedData(it.item)

            } else {
                Toast.makeText(this, "Error in getting data from api.", Toast.LENGTH_LONG).show()
            }
        })
        viewModel.makeAPICall()


    }


}

