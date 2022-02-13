package com.fm.todolist

import androidx.room.*


@Dao
interface ToDoDao {

    @Insert
   suspend fun insertTodo (todo: ToDo) : Long
   @Query("select * from" + ToDoDatabase.TABLE_NAME )
   suspend fun fetchList():MutableList<ToDo>

   @Update
   suspend fun updateTodo(todo: ToDo)

   @Delete
   suspend fun deleteTodo(todo: ToDo)

   @Query("Delete * From" + ToDoDatabase.TABLE_NAME )
   suspend fun clear()
}