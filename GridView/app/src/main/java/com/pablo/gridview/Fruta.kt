package com.pablo.gridview

import android.media.Image

class Fruta(nombre: String, imagen: Int, celda: Int) {
    var nombre: String = ""
    var imagen: Int = 0
    var celda: Int = 0

    init {
        this.nombre = nombre
        this.imagen = imagen
        this.celda = celda
    }
}