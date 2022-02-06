package com.fm.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var toDoAdapter: ToDoAdapter
    lateinit var toDoDatabase: ToDoDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fab: FloatingActionButton = findViewById(R.id.addToDo)

        fab.setOnClickListener {
            val intent = Intent(this,CreateToDo::class.java)
            startActivity(intent  )
        }

        toDoDatabase = Room.databaseBuilder(applicationContext, toDoDatabase::class.java, ToDoDatabase.DB_NAME).build()
        val list = mutableListOf<ToDo>()
        recyclerView = findViewById(R.id.recycler_view)
    }
}