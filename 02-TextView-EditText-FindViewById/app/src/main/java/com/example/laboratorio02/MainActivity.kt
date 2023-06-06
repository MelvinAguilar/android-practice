package com.example.laboratorio02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    // UI elements
    private lateinit var weightEditText: EditText
    private lateinit var heightEditText: EditText
    private lateinit var bmiTextView: TextView
    private lateinit var weightClassTextView: TextView
    private lateinit var rangeBMITextView: TextView
    private lateinit var actionCalculateButton: Button

    // data element
    private var height = 0.0
    private var weight = 0.0
    private var bmi  = 0.0
    private var range_information = ""
    private var bmi_person = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.hide()

        bind()
        actionCalculateButton.setOnClickListener{
            weight = weightEditText.text.toString().toDouble();
            height = heightEditText.text.toString().toDouble();

            if(weight != 0.0 && height != 0.0) BMICalculator()
        }

    }

    private fun bind(){
        weightEditText = findViewById(R.id.weight_edit_text)
        heightEditText = findViewById(R.id.height_edit_text)
        rangeBMITextView = findViewById(R.id.range_bmi_edit_text)
        bmiTextView = findViewById(R.id.bmi_text_view)
        weightClassTextView = findViewById(R.id.weight_class_text_view)
        actionCalculateButton = findViewById(R.id.action_calculate_button)
    }

    private fun BMICalculator() {
        bmi = weight / Math.pow(height/100, 2.0);
        bmiTextView.text = String.format("%.2f", bmi)

        asignData()
        weightClassTextView.text = bmi_person
        rangeBMITextView.text = getString(R.string.bmi_description, range_information)
    }

    private fun asignData() {
        val (bmi_person, colorResource, range_information) = when (bmi) {
            in Double.MIN_VALUE..18.49 -> Triple("Underweight", R.color.under_weight, "Less than 18.5")
            in 18.5..24.99 -> Triple("Healthy", R.color.normal_weight, "18.5 - 24.99")
            in 25.0..29.99 -> Triple("Overweight", R.color.over_weight, "25 - 29.99")
            else -> Triple("Obese", R.color.obese, "Greater than 30")
        }
        weightClassTextView.setTextColor(resources.getColor(colorResource))
        this.bmi_person = bmi_person
        this.range_information = range_information
    }


}