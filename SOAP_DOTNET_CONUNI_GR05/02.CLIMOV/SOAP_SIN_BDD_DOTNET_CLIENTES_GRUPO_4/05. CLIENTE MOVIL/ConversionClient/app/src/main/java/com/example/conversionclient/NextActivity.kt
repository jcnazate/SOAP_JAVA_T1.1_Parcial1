package com.example.conversionclient

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class NextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        val buttonInchesToCentimeters = findViewById<Button>(R.id.buttonInchesToCentimeters)
        buttonInchesToCentimeters.setOnClickListener {
            val intent = Intent(this, InchesToCentimeters::class.java)
            startActivity(intent)
        }

        val buttonCentimetersToInches = findViewById<Button>(R.id.buttonCentimetersToInches)
        buttonCentimetersToInches.setOnClickListener {
            val intent = Intent(this, CentimetersToInches::class.java)
            startActivity(intent)
        }
    }
}
