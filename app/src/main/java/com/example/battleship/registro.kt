package com.example.battleship

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class registro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        val btnEnviar: Button = findViewById(R.id.btnEnviar)
        var nombre: TextView = findViewById(R.id.reg_nom)
        var correo: TextView = findViewById(R.id.reg_correo)
        var pwd: TextView = findViewById(R.id.reg_password)

        //recolectamos los datos ingresados para mandarlos a la BD
        var nom:String= nombre.text.toString()
        var email:String= correo.text.toString()
        var pass:String= pwd.text.toString()


        btnEnviar.setOnClickListener{
            val intent: Intent = Intent(this,modo_juego::class.java)
            startActivity(intent)
        }

        //creamos una funcion para mandar los datos

    }
}