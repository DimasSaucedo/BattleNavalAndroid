package com.example.battleship

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class campoBatalla : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_campo_batalla)

        val pierde: Button = findViewById(R.id.pierde)
        val gana: Button = findViewById(R.id.gana)

        gana.setOnClickListener{
            val intent: Intent = Intent(this,victoria::class.java)
            startActivity(intent)
        }
        pierde.setOnClickListener{
            val intent: Intent = Intent(this,perdida::class.java)
            startActivity(intent)
        }
    }
}