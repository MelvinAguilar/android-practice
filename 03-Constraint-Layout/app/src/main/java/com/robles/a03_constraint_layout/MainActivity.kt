package com.robles.a03_constraint_layout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // UI elements
    private lateinit var countTextView: TextView
    private lateinit var fiveCentsImageVIew: ImageButton
    private lateinit var tenCentsImageVIew: ImageButton
    private lateinit var quarterImageVIew: ImageButton
    private lateinit var oneDollarImageVIew: ImageButton

    // data element
    private var moneyCount = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()
        bind()
        addListeners()
    }

    private fun bind() {
        countTextView = findViewById(R.id.count_text)
        fiveCentsImageVIew = findViewById(R.id.five_cents_button)
        tenCentsImageVIew = findViewById(R.id.ten_cents_button)
        quarterImageVIew = findViewById(R.id.quarter_button)
        oneDollarImageVIew = findViewById(R.id.one_dollar_button)
    }

    private fun addListeners() {
        fiveCentsImageVIew.setOnClickListener { addMoney(0.05) }
        tenCentsImageVIew.setOnClickListener { addMoney(0.10) }
        quarterImageVIew.setOnClickListener { addMoney(0.25) }
        oneDollarImageVIew.setOnClickListener { addMoney(1.00) }
    }

    private fun addMoney(amount: Double) {
        moneyCount += amount
        countTextView.text = getString(R.string.money_value, String.format("%.2f", moneyCount))
    }
}