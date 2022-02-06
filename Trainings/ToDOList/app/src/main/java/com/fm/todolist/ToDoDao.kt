package com.fm.todolist

import androidx.room.Dao
import androidx.room.Insert


@Dao
interface ToDoDao {

    @Insert
   suspend fun insertTodo (todo: ToDo) : Long
}