package com.example.battleship

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class jugadoresLista : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jugadores_lista)

        val btnDisenar:Button= findViewById(R.id.iniBatalla)

        btnDisenar.setOnClickListener{
            val intent: Intent = Intent(this,crea_tablero::class.java)
            startActivity(intent)
        }
    }
}