package com.example.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ConstallationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constallation)

        val btnGoResult = findViewById<Button>(R.id.btnGoResult)
        btnGoResult.setOnClickListener {
            startActivity(Intent(this,ResultActivity::class.java))
        }

    }
}