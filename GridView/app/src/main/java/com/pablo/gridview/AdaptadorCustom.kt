package com.pablo.gridview

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class AdaptadorCustom(var context: Context, items: ArrayList<Fruta>) : BaseAdapter() {

    var items: ArrayList<Fruta>? = null

    init {
        this.items = items
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var holder: ViewHolder? = null
        var vista: View? = convertView

        if (position % 2 == 0) {
            holder?.celda?.setBackgroundColor(Color.BLUE)
        }

        if (vista == null) {
            vista = LayoutInflater.from(context).inflate(R.layout.templategrid, null)
            holder = ViewHolder(vista)
            vista.tag = holder
        } else {
            holder = vista.tag as? ViewHolder
        }

        val item = getItem(position) as Fruta
        holder?.nombre?.text = item.nombre
        holder?.imagen?.setImageResource((item.imagen))




        return vista!!
    }

    override fun getItem(position: Int): Any {
        return items?.get(position)!!
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return items?.count()!!
    }

    private class ViewHolder(vista: View) {
        var nombre: TextView? = null
        var imagen: ImageView? = null
        var celda: LinearLayout? = null

        init {
            nombre = vista.findViewById(R.id.nombre)
            imagen = vista.findViewById(R.id.imagen)
            celda = vista.findViewById(R.id.celda)


        }

    }
}