package com.example.mamamboga

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoAdapter = TodoAdapter(mutableListOf())

        rvorderedItems.adapter = todoAdapter
        rvorderedItems.layoutManager = LinearLayoutManager(this)

        btnAddInventory.setOnClickListener {
            val todoTitle = etorderTitle.text.toString()
            if(todoTitle.isNotEmpty()) {
                val todo = ToDo(todoTitle)
                todoAdapter.addTodo(todo)
                etorderTitle.text.clear()
            }
        }
        btnDeleteCLearStock.setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }
    }
}