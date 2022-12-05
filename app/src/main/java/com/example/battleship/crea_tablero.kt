package com.example.battleship

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.SYSTEM_UI_FLAG_FULLSCREEN
import android.widget.Button

class crea_tablero : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        var canvas = DibujarTablero1(this)
//        canvas.systemUiVisibility = SYSTEM_UI_FLAG_FULLSCREEN
//        setContentView(canvas)
        setContentView(R.layout.activity_crea_tablero)

        var button  = findViewById<Button>(R.id.btnNext)

        button.setOnClickListener {
            var tablero_enemigo = Intent (this,Tablero_enemigo::class.java)
            startActivity(tablero_enemigo)
        }
    }
}