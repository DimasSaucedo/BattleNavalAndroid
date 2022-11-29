package com.example.battleship

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.battleship.clasesBD.UserDBHelper
import com.example.battleship.clasesBD.UserModel

class registro : AppCompatActivity() {

    lateinit var usersDBHelper : UserDBHelper

    lateinit var txtUser:TextView
    lateinit var txtPass:TextView
    lateinit var txtAge:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        txtUser= findViewById(R.id.nameReg)
        txtPass= findViewById(R.id.pwdReg)
        txtAge = findViewById(R.id.ageReg)

    }

    //creamos una funcion para mandar los datos
    fun agregaUser(v: View){
        var nom:String= txtUser.text.toString()
        var age:String= txtAge.text.toString()
        var pass:String= txtPass.text.toString()

        if(nom.length==0){
            Toast.makeText(this,"El usuario esta vacio", Toast.LENGTH_SHORT).show()
        }
        if(pass.length==0){
            Toast.makeText(this,"Ingrese una contraseña", Toast.LENGTH_SHORT).show()
        }
        if(age.length==0){
            Toast.makeText(this,"Ingrese una referencia", Toast.LENGTH_SHORT).show()
        }
        if((nom.length!=0)&&(pass.length!=0)&&(age.length!=0)) {
            if(usersDBHelper.buscar(nom)){
                Toast.makeText(this,"Ese nombre ya existe. Intente con algo diferente", Toast.LENGTH_LONG).show()
            }else{
                val res = usersDBHelper.insertUser(UserModel(name = nom, pass = pass, age = age))

                if (res) {
                    Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, DibujarTablero1::class.java).apply{
                        putExtra(EXTRA_MESSAGE, nom)
                    }
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Fallo en el registro. Intente de nuevo", Toast.LENGTH_LONG)
                        .show()
                    limpiarDatos()
                }
            }


        }

    }
    fun limpiarDatos(){
        txtUser.setText("")
        txtPass.setText("")
        txtAge.setText("")
    }
}