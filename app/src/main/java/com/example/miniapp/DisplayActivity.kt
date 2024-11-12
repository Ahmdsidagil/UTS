package com.example.miniapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DisplayActivity : AppCompatActivity() {
    private lateinit var nameTextView: TextView
    private lateinit var ageTextView: TextView
    private lateinit var genderTextView: TextView
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        nameTextView = findViewById(R.id.nameTextView)
        ageTextView = findViewById(R.id.ageTextView)
        genderTextView = findViewById(R.id.genderTextView)
        backButton = findViewById(R.id.backButton)

        val name = intent.getStringExtra("name") ?: "Tidak ada nama"
        val age = intent.getIntExtra("age", 0)
        val gender = intent.getStringExtra("gender") ?: "Tidak ditentukan"

        nameTextView.text = "Nama: $name"
        ageTextView.text = "Usia: $age"
        genderTextView.text = "Jenis Kelamin: $gender"


        backButton.setOnClickListener {
            finish()
        }
    }
}