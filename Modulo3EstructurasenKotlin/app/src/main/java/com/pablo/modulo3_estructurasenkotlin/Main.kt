package com.pablo.modulo3_estructurasenkotlin

fun main(args: Array<String>) {

    //Kotlin permite tener variables sin inicializar, pero en el momento que las requieras debes inicilizarlas
    ///////////
    //If-else//
    ///////////

//    var a = 10
//    var b = 11
//    var c = 5
//    var numeroMayor: Int
    //Si solo quieres saber el valor de la variable mayor, no te interesa saber si es la a o la b
//    numeroMayor = if(a>b && a>c) a else if(b>a && b>c) b else c
//    println("El numero mayor de todas mis variables es: $numeroMayor")

//    if (a > b) {
//        println("la variable a es mayor que la variable b")
//    } else {
//        println("la variable b es mayor que la variable a")
//    }

    //Esto se puede sustituir por una línea
//    if (a > b) println("la variable a es mayor que la variable b") else println("la variable b es mayor que la variable a")

    //**ejercicio: pasa de la línea 8 a la 14 en 3 o 4 líneas de código**

    var array = intArrayOf(11, 12, 12)
    var numeroMayor: Int =
        if (array[0] >= array[1] && array[0] >= array[2]) array[0] else if (array[1] >= array[0] && array[1] >= array[2]) array[1] else array[2]
    println("El numero mayor de todas mis variables es: $numeroMayor")

    ///////////////////////////////////////////////////////////////////
    //When (muy parecida a switch en otros lenguajes de programacion)//
    ///////////////////////////////////////////////////////////////////

    val calificacion = 3
    var resena: String

    when (calificacion) {
        1, 2 -> {
            println("El cliente calificó con $calificacion estrellas:")
            resena = "No me gustó la comida"
        }
        3 -> {
            println("El cliente calificó con 3 estrellas")
            resena = "Mediocre"
        }
        4 -> resena = "Me gustó pero puede mejorar"
        5 -> resena = "La mejor comida de toda la ciudad"
        else -> resena = "Reseña mal escrita"
    }
    print(resena)

    //Se puede hacer por rangos
    when (calificacion) {
        in 1..5 -> {
            println("El cliente calificó con $calificacion estrellas:")
            resena = "Mediocre"
        }
        else -> resena = "Reseña mal escrita"
    }
    print(resena)

    when {
        calificacion >= 1 -> {
            println("El cliente calificó con $calificacion estrellas:")
            resena = "Me gustó la comida"
        }
        else -> resena = "Reseña mal escrita"
    }
    print(resena)

    val calificacion2 = 'A'

    when (calificacion2) {
        'E' -> resena = "No me gustó la comida"
        'D' -> resena = "Mediocre"
        'C' -> resena = "Puede mejorar bastante"
        'B' -> resena = "Me gustó pero puede mejorar"
        'A' -> resena = "La mejor comida de toda la ciudad"
        else -> resena = "Reseña mal escrita"
    }
    println(resena)

    //////////////
    //Ciclos For//
    /////////////

    for (i in 1..10) print("$i ")

    for (i in 1..10) {
        println("Esta es la vez numero $i que entro al bloque de código")
    }

    //si tuviesemos este bloque for, no tendría sentido, ya que la i no nos indica el numero de veces que entra:
    for (i in 4..18) {
        println("Esta es la vez numero $i que entro al bloque de código")
    }
    //para ello se hace esto
    for ((indice, valor) in (4..18).withIndex()) {
        println("Esta es la vez numero  ${indice + 1} que entro al bloque de código con valor de $valor")
    }

    //Bucles while y do-while

    var x = 0

    while (x <= 10) {
        print(x)
        break
    }
    println()

    //también se puede hacer esto
    while (x <= 10) {
        print(x)
        x = x + 1
    }
    println()
    //combinar bucles y condiciones
    x = 0
    while (x <= 10) {
        if (x == 8) print(x)
        x = x + 1
    }

    var y = 1
    do {
        println("Estoy dentro del do-while")
    } while (y != 1)

    //Funcion que solo retornan una impresion por pantalla
    sumar(3, 5)
    sumar(x, y)

    //Funcion que retorna un valor

    var resultado = sumarRetornaValor(3, 5)
    var resultado2 = sumarRetornaValor(x, y)

    println(resultado)
    println(resultado2)

    val cosenoUno = Math.cos(1.0)
    println(cosenoUno)
}

//Funcion que no devuelve nada, solo imprime
fun sumar(a: Int, b: Int) {
    var c = a + b
    println("La suma es: $c")
}

fun sumarRetornaValor(a: Int, b: Int): Int {
    var c = a + b
    return c
}
