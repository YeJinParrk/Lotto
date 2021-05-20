package com.example.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val constellationCard = findViewById<CardView>(R.id.cardview2)
        val nameCard = findViewById<CardView>(R.id.cardview3)

        constellationCard.setOnClickListener {
            startActivity(Intent(this, ConstallationActivity::class.java))
        }
        nameCard.setOnClickListener {
            startActivity(Intent(this, NameActivity::class.java))
        }
    }
}