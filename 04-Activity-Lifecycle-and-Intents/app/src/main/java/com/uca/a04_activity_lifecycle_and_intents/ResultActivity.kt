package com.uca.a04_activity_lifecycle_and_intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    // UI elements
    private lateinit var shareButton: Button

    //values
    var nameValue: String = ""
    var emailValue: String = ""
    var phoneValue: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        supportActionBar!!.hide()

        nameValue = intent.getStringExtra("name") ?: ""
        emailValue = intent.getStringExtra("email") ?: ""
        phoneValue = intent.getStringExtra("phone") ?: ""

        findViewById<TextView>(R.id.name_text_view)?.let { it.text = nameValue }
        findViewById<TextView>(R.id.email_text_view)?.let { it.text = emailValue }
        findViewById<TextView>(R.id.phone_text_view)?.let { it.text = phoneValue }

        bind()
        addListener()
    }

    private fun bind() {
        shareButton = findViewById(R.id.share_button)
    }

    private fun addListener() {
        shareButton.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, getString(R.string.share_text, nameValue, emailValue, phoneValue))
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }
    }
}