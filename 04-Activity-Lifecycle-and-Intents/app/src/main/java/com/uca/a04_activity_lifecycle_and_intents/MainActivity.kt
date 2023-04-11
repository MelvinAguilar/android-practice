package com.uca.a04_activity_lifecycle_and_intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    // UI elements
    private lateinit var nameInput : TextInputEditText
    private lateinit var emailInput: TextInputEditText
    private lateinit var phoneInput: TextInputEditText
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()

        bind()
        addListener()
    }

    private fun bind() {
        nameInput = findViewById(R.id.name_text_field)
        emailInput = findViewById(R.id.email_text_field)
        phoneInput = findViewById(R.id.phone_text_field)
        saveButton= findViewById(R.id.save_button)
    }

    private fun addListener() {
        saveButton.setOnClickListener {
            val intent = Intent(MainActivity@this, ResultActivity::class.java)

            val nameValue = nameInput.text.toString()
            val emailValue = emailInput.text.toString()
            val phoneValue = phoneInput.text.toString()

            intent.putExtra("name", nameValue)
            intent.putExtra("email", emailValue)
            intent.putExtra("phone", phoneValue)

            startActivity(intent)
        }
    }
}