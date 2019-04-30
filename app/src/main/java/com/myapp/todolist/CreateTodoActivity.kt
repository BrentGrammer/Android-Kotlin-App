package com.myapp.todolist

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_create_todo.*

class CreateTodoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_todo)

        saveButton.setOnClickListener {
            var title = ""
            if (importantCheckBox.isChecked) {
                title = "❗ " + titleEditText.text.toString()
            } else {
                title = titleEditText.text.toString()
            }

            var prefs = getSharedPreferences(getString(R.string.SHARED_PREF_NAME), Context.MODE_PRIVATE)
            // second arg is a default value (an empty set here)
            var todos = prefs.getStringSet(getString(R.string.TODO_STRINGS), setOf()).toMutableSet()
            // add the title to todos:
            todos.add(title)

            prefs.edit().putStringSet(getString(R.string.TODO_STRINGS), setOf(title)).apply()

            // finish moves back to the previous activity:
            finish()
        }
    }
}



