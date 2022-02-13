package com.fm.todolist

interface ToDoInterface {

    fun updateToDoText(todo:ToDo)
    fun onDeleteToDo(todo: ToDo,position:Int)
}