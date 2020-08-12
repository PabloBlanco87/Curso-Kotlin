package com.pablo.navegarentreactividades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class ActividadC : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_c)

        val mensaje = intent.getStringExtra("MENSAJE")
        val boton = findViewById<Button>(R.id.boton_atras)

        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()

        //esta sería la mejor forma de eliminar una actividad del stack, no es óptimo volver a enviar intents
        boton.setOnClickListener {
            finish()
        }

    }
}