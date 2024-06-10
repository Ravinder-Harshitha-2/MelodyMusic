package com.example.melodymusic

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class NameScreen : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var enterButton: Button
    private lateinit var clearButton: Button
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name_screen)

        editText = findViewById(R.id.editText)
        enterButton = findViewById(R.id.enterButton)
        clearButton = findViewById(R.id.clearButton)

        // Shared preferences
        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        // On click listener function :
        enterButton.setOnClickListener {
            val inputText = editText.text.toString()

            // to display toast message if no text is entered
            if (inputText.isEmpty()) {
                Toast.makeText(this, "Please enter your name.", Toast.LENGTH_SHORT).show()
            }

            // if text is entered then take the user to the home screen
            else {
                val editor = sharedPreferences.edit()
                editor.putString("text", inputText)
                editor.apply()

                val intent = Intent(this, HomeScreen::class.java)
                startActivity(intent)
            }
        }

        // function to clear text in edit text
        clearButton.setOnClickListener {
            editText.text.clear()
        }
    }
}