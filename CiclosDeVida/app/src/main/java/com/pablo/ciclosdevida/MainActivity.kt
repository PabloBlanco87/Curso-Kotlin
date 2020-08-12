package com.pablo.ciclosdevida

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var nombre = "Marcos"
    val NOMBRE = "nombre"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boton = findViewById<Button>(R.id.boton)

        //Toast.makeText(this, nombre, Toast.LENGTH_SHORT).show()

        boton.setOnClickListener {
            nombre = "Sergio"
            Toast.makeText(this, nombre, Toast.LENGTH_SHORT).show()
        }

        //Si giramos la pantalla, nos va a seguir apareciendo Marcos
        //para ello las dos siguientes funciones:
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        nombre=savedInstanceState?.getString(NOMBRE)!!
        Toast.makeText(this, nombre, Toast.LENGTH_SHORT).show()
    }

    //Para guardar el valor de la variable
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState?.putString(NOMBRE, nombre)
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "En transición", Toast.LENGTH_SHORT).show()
    }

    //Cuando el usuario deja de ver la aplicación en la pantalla
    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "Aplicativo oculto", Toast.LENGTH_SHORT).show()
    }

    //Cuando el usuario vuelve a estar visible para el usuario
    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "Aplicativo visible", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "App destruída", Toast.LENGTH_SHORT).show()
    }
}