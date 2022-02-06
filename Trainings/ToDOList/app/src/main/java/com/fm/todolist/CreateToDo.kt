package com.fm.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.DocumentsContract
import android.provider.Settings
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CreateToDo : AppCompatActivity() {

    lateinit var toDoDatabase: ToDoDatabase
    lateinit var editText: EditText
    lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_to_do)

        toDoDatabase = Room.databaseBuilder(applicationContext, toDoDatabase::class.java, ToDoDatabase.DB_NAME).build()
        editText = findViewById(R.id.edittext)
        saveButton = findViewById(R.id.saveButton)

        saveButton.setOnClickListener {
            val enteredText = editText.text.toString()

            if (TextUtils.isEmpty(enteredText)) {
                Toast.makeText(this,"text should not be empty",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else {
                val todo = ToDo()
                todo.name = enteredText
                insertRow(todo)
            }
        }
    }

    private fun insertRow(todo: ToDo) {
        GlobalScope.launch (Dispatchers.IO){
            // inserting Data on Background Thread
            val id = toDoDatabase.toDoAppDao().insertTodo(todo )
            println("Insert thread: ${Thread.currentThread().name}")
            launch(Dispatchers.Main) {
                //UI related
                println("For the intent ${Thread.currentThread().name}")
                todo.todoID = id

                val intent = Intent(this@CreateToDo,MainActivity::class.java)
                startActivity(intent)
                finish()

            }
        }

    }
}