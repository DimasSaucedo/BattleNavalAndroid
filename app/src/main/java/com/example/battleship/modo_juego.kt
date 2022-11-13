package com.example.battleship

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class modo_juego : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modo_juego)

        val btnBack:Button= findViewById(R.id.back)
        val btnLogin:Button= findViewById(R.id.btn_cuentaMJ)
        val btn2p:Button= findViewById(R.id.dosJugadores)
        val btn1p:Button= findViewById(R.id.unJugador)

        btnBack.setOnClickListener{
            val intent: Intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        btnLogin.setOnClickListener{
            val intent: Intent = Intent(this,iniciar_sesion::class.java)
            startActivity(intent)
        }
        btn2p.setOnClickListener{
            val intent: Intent = Intent(this,jugadoresLista::class.java)
            startActivity(intent)
        }
        btn1p.setOnClickListener{
            val intent: Intent = Intent(this,crea_tablero::class.java)
            startActivity(intent)
        }

    }
}