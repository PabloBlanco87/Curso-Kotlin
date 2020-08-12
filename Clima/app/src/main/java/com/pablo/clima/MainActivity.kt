package com.pablo.clima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.pablo.clima.com.pablo.clima.Ciudad
import com.pablo.clima.com.pablo.clima.Network
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    var tvCiudad: TextView? = null
    var tvGrados: TextView? = null
    var tvEstatus: TextView? = null
    var tvViento: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvCiudad = findViewById(R.id.tvCiudad)
        tvGrados = findViewById(R.id.tvGrados)
        tvEstatus = findViewById(R.id.tvEstado)
        tvViento = findViewById(R.id.tvViento)

        val ll: ConstraintLayout = findViewById(R.id.fondoPantalla)

        val ciudad = intent.getStringExtra("com.pablo.clima.ciudades.CIUDAD")

        Toast.makeText(this, ciudad, Toast.LENGTH_SHORT).show()

        if (Network.hayRed(this)) {
            //Ejecutar solicitud http
            solicitudHTTPVolley(
                "http://api.openweathermap.org/data/2.5/weather?id=" + ciudad +
                        "&appid=30fa88204b8d279ae67ca0a09f7491b6&units=metric&lang=es"
            )

            //30fa88204b8d279ae67ca0a09f7491b6
            //id comunidad de madrid= 3117732
        } else {
            //mostrar mensaje de error
            Toast.makeText(this, "No hay red", Toast.LENGTH_SHORT).show()
        }

    }

    //Método para Volley
    private fun solicitudHTTPVolley(url: String) {
        val queue = Volley.newRequestQueue(this)
        val solicitud =
            StringRequest(Request.Method.GET, url, Response.Listener<String> { response ->
                try {
                    Log.d("solicitudHTTPVolley", response)

                    val gson = Gson()
                    val ciudad = gson.fromJson(response, Ciudad::class.java)
                    tvCiudad?.text = ciudad.name

                    var grados = ciudad.main?.temp.toString()
                    var contador: Int = 1
                    for (i in 0..grados.length) {
                        contador++
                        if (grados[i] == '.')
                            break
                    }

                    grados = grados.substring(0, contador)

                    tvGrados?.text = grados + "º"
                    tvEstatus?.text = ciudad.weather?.get(0)?.description
                    tvViento?.text = "Viento: " + ciudad.wind?.speed.toString()

                } catch (e: Exception) {

                }
            }, Response.ErrorListener { })
        queue.add(solicitud)
    }
}