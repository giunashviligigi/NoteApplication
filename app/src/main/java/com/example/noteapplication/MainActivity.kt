package com.example.noteapplication

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var noteEditText: EditText
    private lateinit var noteTextView: TextView
    private lateinit var button: Button

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        noteEditText = findViewById(R.id.noteEditText)
        noteTextView = findViewById(R.id.noteTextView)
        button = findViewById(R.id.button)

        sharedPreferences = getSharedPreferences("MY_SHARED_PREF", MODE_PRIVATE)
        val notes = sharedPreferences.getString("NOTES","")
        noteTextView.text = notes

        button.setOnClickListener{
            val note = noteEditText.text.toString()

            val notes = noteTextView.text.toString()

            val result = notes + "\n" + note

            noteTextView.text = result
            noteEditText.setText("")

            sharedPreferences.edit()
                .putString("NOTES",result)
                .apply()
        }
    }
}