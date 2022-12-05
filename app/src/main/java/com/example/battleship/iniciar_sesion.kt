package com.example.battleship

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.battleship.clasesBD.UserDBHelper
import com.example.battleship.clasesBD.UserModel

class iniciar_sesion : AppCompatActivity() {
    //declaraciones para la BD
    lateinit var usersDBHelper : UserDBHelper
    private lateinit var usI: TextView
    private lateinit var pwdI: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iniciar_sesion)

        //declaraciones para la BD
        usI = findViewById(R.id.usuIngreso)
        pwdI = findViewById(R.id.pwdIngreso)
        usersDBHelper = UserDBHelper(this)

        val btnRegistrar:Button= findViewById(R.id.btnRegistrate)

        btnRegistrar.setOnClickListener{
            val intent: Intent = Intent(this,registro::class.java)
            startActivity(intent)
        }
    }
    fun leerUser(v: View) {
        var e1:Int=usI.text.toString().length
        var e2:Int=pwdI.text.toString().length
        if (e1 == 0) {
            Toast.makeText(this, "El usuario esta vacio", Toast.LENGTH_SHORT).show()
        }
        if (e2 == 0) {
            Toast.makeText(this, "La contraseña esta vacia", Toast.LENGTH_SHORT).show()
        }
        if ((e1 != 0) && (e2 != 0)) {
            val res: ArrayList<UserModel> = usersDBHelper.readUser(usI.text.toString())
            var nom = ""
            var pas = ""

            res.forEach {
                nom = it.name
                pas = it.pass
            }
            if ((res != null) && (pwdI.text.toString() == pas)) {
                val intent = Intent(this, crea_tablero::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Contraseña Incorrecta", Toast.LENGTH_LONG).show()
            }

            if (res == null) {
                Toast.makeText(this, "El usuario no existe", Toast.LENGTH_LONG).show()
            }
        }
    }
}