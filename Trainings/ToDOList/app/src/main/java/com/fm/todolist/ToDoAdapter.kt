package com.fm.todolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ToDoAdapter (var toDoList: MutableList<ToDo>):RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>() {

    class ToDoViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {

        var nameText: TextView = itemView.findViewById(R.id.title)
        var edtimg : ImageView = itemView.findViewById(R.id.edtIcon)
        var dltimg : ImageView = itemView.findViewById(R.id.deleteIcon)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.to_do_item,parent,false)
        return ToDoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        val toDo = toDoList[position]
        holder.nameText.text = toDo.name
    }

    override fun getItemCount(): Int {
        return toDoList.size
    }


}