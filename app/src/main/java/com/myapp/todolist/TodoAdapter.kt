package com.myapp.todolist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.todo_recyclerview_item_row.view.*
import java.text.FieldPosition

class TodoAdapter(val todos: List<String>) : RecyclerView.Adapter<TodoAdapter.TextHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): TextHolder {
        return TextHolder(LayoutInflater.from(parent.context).inflate(R.layout.todo_recyclerview_item_row, parent, false))
    }

    override fun getItemCount(): Int {
        return todos.count()
    }

    override fun onBindViewHolder(holder: TextHolder, position: Int) {
        val todo = todos[position]
        holder.bindTodo(todo)
    }

    class TextHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        var view : View = v
        var todo : String = ""

        init {
            v.setOnClickListener(this)
        }

        fun bindTodo(todo:String) {
            this.todo = todo
            view.todoItemTextView.text = todo
        }
        override fun onClick(v: View?) {
            println("clicked")
        }

    }
}