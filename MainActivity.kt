package com.example.startingservices

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.startingservices.ui.theme.StartingServicesTheme

class MainActivity : ComponentActivity() {

    private lateinit var editTextNumber: EditText
    private lateinit var buttonStart: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextNumber = findViewById(R.id.editText)
        buttonStart = findViewById(R.id.button)

        buttonStart.setOnClickListener {
            val countdownTime = editTextNumber.text.toString().toIntOrNull()
            if (countdownTime != null) {
                val intent = Intent(this, TpService::class.java)
                intent.putExtra("countdown_time", countdownTime)
                startService(intent)
            } else {
                editTextNumber.error = "Please enter a valid number"
            }

        }
    }
}


