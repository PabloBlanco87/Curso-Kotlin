package com.pablo.listviewsimpleadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Inicializamos el listview
        val lista = findViewById<ListView>(R.id.lista)

        /*ASÍ ES PARA EL SIMPLE ADAPTER

        //Creamos el arraylist de datos
        var frutas: ArrayList<String> = ArrayList()
        frutas.add("Manzana")
        frutas.add("Pera")
        frutas.add("Plátano")
        frutas.add("Sandía")
        frutas.add("Melón")

        //Creamos el adaptador, indicamos contexto, tipo de presentación y datos a mostrar
        val adaptador = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, frutas)
        //Linqueamos el adaptador a nuestra lista
        lista.adapter = adaptador

        //Configuramos el listener para acceder a cada uno de los elementos del arraylist
        lista.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, frutas.get(position), Toast.LENGTH_LONG).show()
        }

         */

        //CREAMOS EL CUSTOMADAPTER
        var frutas: ArrayList<Fruta> = ArrayList()
        frutas.add(Fruta("Manzana", R.drawable.manzana))
        frutas.add(Fruta("Pera", R.drawable.pera))
        frutas.add(Fruta("Plátano", R.drawable.platano))
        frutas.add(Fruta("Sandía", R.drawable.sandia))
        frutas.add(Fruta("Melón", R.drawable.melon))

        val adaptador = AdaptadorCustom(this, frutas)
        lista.adapter = adaptador

        //Configuramos el listener para acceder a cada uno de los elementos del arraylist
        lista.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, frutas.get(position).nombre, Toast.LENGTH_LONG).show()
        }

    }
}