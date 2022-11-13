package com.example.battleship

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnIniciar: Button= findViewById(R.id.btn_Iniciar)
        val btnAjustes: Button= findViewById(R.id.btn_ajustes)
        val btnLogin: Button= findViewById(R.id.btn_login)

//        var buttonLinea = findViewById<Button>(R.id.buttonEntrar)
//        var Nombre = findViewById<EditText>(R.id.ButtonName)
//
//        buttonLinea.setOnClickListener {
//            database = Firebase.database.reference
//            var id = ""
//            for(i in 1..5){
//                var numero = (0..10).random()
//                id += numero
//            }
//            val user = Usuario(Nombre.toString(),id.toInt(),"00-00--")
//
//            database.child("Jugador").setValue(user)
//
//        }

        btnIniciar.setOnClickListener{
            val intent: Intent = Intent(this,modo_juego::class.java)
            startActivity(intent)
        }
        btnAjustes.setOnClickListener{
            val intent: Intent = Intent(this,ajustes::class.java)
            startActivity(intent)
        }
        btnLogin.setOnClickListener{
            val intent: Intent = Intent(this,iniciar_sesion::class.java)
            startActivity(intent)
        }

    }



}