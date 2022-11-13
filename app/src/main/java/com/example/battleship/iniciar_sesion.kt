package com.example.battleship

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class iniciar_sesion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iniciar_sesion)

        val btnLog:Button= findViewById(R.id.btnLog)
        val btnRegistrar:Button= findViewById(R.id.btnRegistro)

        btnLog.setOnClickListener{
            val intent: Intent = Intent(this,modo_juego::class.java)
            startActivity(intent)
        }
        btnRegistrar.setOnClickListener{
            val intent: Intent = Intent(this,registro::class.java)
            startActivity(intent)
        }
    }
}