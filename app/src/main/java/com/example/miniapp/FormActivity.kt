package com.example.miniapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class FormActivity : AppCompatActivity() {
    private lateinit var nameEditText: EditText
    private lateinit var ageEditText: EditText
    private lateinit var genderRadioGroup: RadioGroup
    private lateinit var submitButton: Button
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        nameEditText = findViewById(R.id.nameEditText)
        ageEditText = findViewById(R.id.ageEditText)
        genderRadioGroup = findViewById(R.id.genderRadioGroup)
        submitButton = findViewById(R.id.submitButton)
        backButton = findViewById(R.id.backButton)

        submitButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val age = ageEditText.text.toString().toIntOrNull() ?: 0
            val selectedGenderId = genderRadioGroup.checkedRadioButtonId
            val gender = if (selectedGenderId != -1) {
                findViewById<RadioButton>(selectedGenderId).text.toString()
            } else {
                "Tidak ditentukan"
            }

            val intent = Intent(this, DisplayActivity::class.java).apply {
                putExtra("name", name)
                putExtra("age", age)
                putExtra("gender", gender)
            }
            startActivity(intent)
        }

        backButton.setOnClickListener {
            finish()
        }
    }
}