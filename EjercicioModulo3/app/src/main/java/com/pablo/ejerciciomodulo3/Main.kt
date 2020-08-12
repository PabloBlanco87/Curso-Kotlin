package com.pablo.ejerciciomodulo3

fun main(args: Array<String>) {
    /*Imprimir los primeros 18 números de la serie Fibonacci en consola utilizando
    todo lo aprendido hasta el momento*/

    var a = 0
    var b = 1
    var c: Int

    for (i in 1..18) {
        if (i == 1) {
            println(a)
            println(b)
        } else {
            c = a
            a = b
            b = a + c
            println(b)
        }
    }
}

