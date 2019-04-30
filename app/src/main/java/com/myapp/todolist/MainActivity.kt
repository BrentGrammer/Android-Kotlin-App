package com.myapp.todolist

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    lateinit var layoutManager : LinearLayoutManager
    lateinit var adapter : TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            val intent = Intent(this, CreateTodoActivity::class.java)
            startActivity(intent)
        }

        var prefs = getSharedPreferences(getString(R.string.SHARED_PREF_NAME), Context.MODE_PRIVATE)
        var todos = prefs.getStringSet(getString(R.string.TODO_STRINGS), setOf("No Todos Found")).toMutableSet()

        println(todos)

        layoutManager = LinearLayoutManager(this)
        todoRecyclerView.layoutManager = layoutManager
        adapter = TodoAdapter(todos.toList())
        todoRecyclerView.adapter = adapter
    }

    // onResume is a lifecycle hook that runs when app comes back from another activity or for the first time.
    override fun onResume() {
        super.onResume()

        var prefs = getSharedPreferences("com.myapp.todolist.sharedprefs", Context.MODE_PRIVATE)
        var todos = prefs.getStringSet("todostrings", setOf()).toMutableSet()
        println(todos)

    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
