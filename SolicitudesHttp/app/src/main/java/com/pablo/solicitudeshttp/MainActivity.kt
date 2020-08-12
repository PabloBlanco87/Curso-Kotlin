package com.pablo.solicitudeshttp

import android.app.DownloadManager
import android.os.AsyncTask.execute
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import okhttp3.Call
import okhttp3.OkHttpClient
import java.io.IOException
import java.io.InputStream
import java.lang.Exception
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class MainActivity : AppCompatActivity(), CompletadoListener {

    override fun descargaCompleta(resultado: String) {
        Log.d("descargaCompleta", resultado)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnValidarRed = findViewById<Button>(R.id.btValidarRed)
        val btnSolicitudHttp = findViewById<Button>(R.id.btnSolicitudHttp)
        val btnVolley = findViewById<Button>(R.id.btn_Volley)
        val btnOKhttp = findViewById<Button>(R.id.btnOK)


        btnValidarRed.setOnClickListener {
            // código para validar red
            if (Network.hayRed(this)) {
                Toast.makeText(this, "Si hay red", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "No hay conexión", Toast.LENGTH_LONG).show()
            }
        }

        btnSolicitudHttp.setOnClickListener {
            if (Network.hayRed(this)) {
                //Log.d("bSolicitudOnClick", descargarDatos("https://www.google.com"))
                DescargaURL(this).execute("https://www.google.com")
            } else {
                Toast.makeText(this, "No hay conexión", Toast.LENGTH_LONG).show()
            }
        }

        btnVolley.setOnClickListener {
            if (Network.hayRed(this)) {
                solicitudHTTPVolley("https://www.google.com")
            } else {
                Toast.makeText(this, "No hay conexión", Toast.LENGTH_LONG).show()
            }
        }

        btnOKhttp.setOnClickListener {
            if (Network.hayRed(this)) {
                solicitudHTTPOkHTTP("https://www.google.com")
            } else {
                Toast.makeText(this, "No hay conexión", Toast.LENGTH_LONG).show()
            }
        }

    }

    //Método para Volley
    private fun solicitudHTTPVolley(url: String) {
        val queue = Volley.newRequestQueue(this)
        val solicitud =
            StringRequest(Request.Method.GET, url, Response.Listener<String> { response ->
                try {
                    Log.d("solicitudHTTPVolley", response)
                } catch (e: Exception) {

                }
            }, Response.ErrorListener { })
        queue.add(solicitud)
    }

    //Método para OkHttp
    private fun solicitudHTTPOkHTTP(url: String) {
        val cliente = OkHttpClient()
        val solicitud = okhttp3.Request.Builder().url(url).build()

        cliente.newCall(solicitud).enqueue(object:okhttp3.Callback{
            override fun onFailure(call: Call, e: IOException) {
                //Implementar error en caso que la solicitud falle
            }

            override fun onResponse(call: Call?, response: okhttp3.Response) {
                val resultado= response.body()?.string()

                this@MainActivity.runOnUiThread {
                    try {
                        Log.d("Solicitud okHTTP",resultado)
                    }catch (e:Exception){

                    }
                }
            }
        })
    }


}