package com.example.battleship

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class perfil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        val btnBack:Button= findViewById(R.id.btnBack)
        val btnBorraProgreso:Button= findViewById(R.id.btnResetProgreso)

        btnBack.setOnClickListener{
            val intent: Intent = Intent(this,campoBatalla::class.java)
            startActivity(intent)
        }
        btnBorraProgreso.setOnClickListener{
            //elimina el puntaje de la base de datos
        }
    }
}