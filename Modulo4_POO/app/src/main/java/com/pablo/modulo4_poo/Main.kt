package com.pablo.modulo4_poo

fun main(args: Array<String>) {
    var manzana = Frutas("Rojo", "Dulce", 4, 10)
    println("La fruta tiene un color ${manzana.color}")
    manzana.imprimeFrescura()
    manzana.pudrirse()
    manzana.imprimeFrescura()
    manzana.pudrirse()
    manzana.imprimeFrescura()

    var aguacate = FrutasConGrasa(10)
    println(aguacate.cantidadGrasa)
    aguacate.color = "Verde"
    println("La fruta tiene un color ${aguacate.color}")
    aguacate.pudrirse()
    aguacate.imprimeFrescura()

}

open class Frutas() {
    var color: String = ""
    var sabor: String = ""
    var precio: Int = 21
    var frescura: Int = 81
    var numHojas: Int = 0

    constructor(color: String, sabor: String, precio: Int) : this() {
        this.color = color
        this.sabor = sabor
        this.precio = precio
    }

    constructor(color: String, sabor: String, precio: Int, numHojas: Int) : this() {
        this.color = color
        this.sabor = sabor
        this.precio = precio
        this.numHojas = numHojas
    }

    constructor(color: String, sabor: String, precio: Int, frescura: Int, numHojas: Int) : this() {
        this.color = color
        this.sabor = sabor
        this.precio = precio
        this.frescura = frescura
        this.numHojas = numHojas
    }

    constructor(color: String, sabor: String) : this() {
        this.color = color
        this.sabor = sabor
        this.precio = precio
    }

    fun pudrirse() {
        if (frescura > 20)
            frescura -= 20
        else
            frescura = 0
    }

    fun imprimeFrescura() {
        if (frescura != 0)
            println("La frescura de la fruta es de un ${frescura}%")
        else
            println("La fruta está prodrida")
    }

}

//Herencia
class FrutasConGrasa() : Frutas() {
    var cantidadGrasa: Int = 0

    constructor(cantidadGrasa: Int) : this() {
        this.cantidadGrasa = cantidadGrasa
    }
}

//Crear una clase en Kotlin y utilizar init
//class Frutas(color: String, sabor: String, precio: Int, frescura: Int) {
//
//    var color: String = ""
//    var sabor: String = ""
//    var precio: Int = 0
//    var frescura: Int = 100
//
//El init se puede utilizar en caso que no quieras pasar argumentos o parametros a tu objeto, solo inicializar valores
//    init {
//        this.color = color
//        this.sabor = sabor
//        this.precio = precio
//        this.frescura = frescura
//    }
//}

