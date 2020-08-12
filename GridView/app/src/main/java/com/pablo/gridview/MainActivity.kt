package com.pablo.gridview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.Toast
import androidx.core.view.get

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val grid: GridView = findViewById(R.id.grid)


        //ASÍ ES PARA EL SIMPLE ADAPTER

        //Creamos el arraylist de datos
//        var frutas: ArrayList<String> = ArrayList()
//        frutas.add("Manzana")
//        frutas.add("Pera")
//        frutas.add("Plátano")
//        frutas.add("Sandía")
//        frutas.add("Melón")
//
//        var grid: GridView = findViewById(R.id.grid)
//
//        //Creamos el adaptador, indicamos contexto, tipo de presentación y datos a mostrar
//        val adaptador = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, frutas)
//        grid.adapter = adaptador

        //CREAMOS EL CUSTOMADAPTER
        var frutas: ArrayList<Fruta> = ArrayList()
        frutas.add(Fruta("Manzana", R.drawable.manzana, frutas.count()))
        frutas.add(Fruta("Pera", R.drawable.pera, frutas.count()))
        frutas.add(Fruta("Plátano", R.drawable.platano, frutas.count()))
        frutas.add(Fruta("Sandía", R.drawable.sandia, frutas.count()))
        frutas.add(Fruta("Melón", R.drawable.melon, frutas.count()))

        val adaptador = AdaptadorCustom(this, frutas)
        grid.adapter = adaptador

        //Configuramos el listener para acceder a cada uno de los elementos del arraylist
        grid.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, frutas.get(position).nombre, Toast.LENGTH_LONG).show()
        }

    }
}