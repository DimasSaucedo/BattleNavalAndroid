package com.example.battleship

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class crea_tablero : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crea_tablero)

        val btnNext:Button=findViewById(R.id.btnNext)
        val btnBorrar:Button=findViewById(R.id.btnNext)

        btnNext.setOnClickListener{
            val intent: Intent = Intent(this,campoBatalla::class.java)
            startActivity(intent)
        }
        btnBorrar.setOnClickListener{
            //borrar todas las naves
        }
    }
}