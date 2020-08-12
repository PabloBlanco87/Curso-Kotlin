package com.pablo.iniciocurso

fun main(args: Array<String>) {

    //Imprimir por pantalla
    println("Hola mundo!")

    //Variables
    println("\nVariables:")
    var edadFirulais = 18
    println(edadFirulais)
    edadFirulais = 15
    println(edadFirulais)

    //Constantes
    println("\nConstantes:")
    val nombreFirulais = "Zizou"
    println(nombreFirulais)

    /*Tipos de Datos:
    Tipos Numericos Bit ancho
    Double              64
    Float               32
    Long                64
    Int                 32
    Short               16
    Byte                 8
    */

    //Asignacion de tipo de datos
    var numero: Int = 18
    //Si ponemos 18.1 daría error, ya que está explícitamente declarado como Int
    var numeroFloat = 15.5f

    //Characters
    println("\nCharacters:")
    var char: Char = 'a'
    println(char)

    var caracter = '8'
    var charToInt = caracter.toInt()
    println(charToInt)  //Output=56, que es su representación decimal, ¿Cómo podemos transformarlo a 8?
    //Le quitamos el desfase
    charToInt = charToInt - 48
    println(charToInt)

    var suma = charToInt + 15
    println(suma)

    //Strings
    println("\nStrings:")
    var cadena: String = "Pablo"
    println(cadena)
    println(cadena[0])  //Output = P

    //Hay dos tipos de Strings
    //Strings con secuencia de escape
    println("\nStrings con secuencia de escape:")
    var cadena2 = "Pablo\nBlanco"
    println(cadena2)
    cadena2 = "Pablo\n\tBlanco"
    println(cadena2)

    //Strings puros (raw Strings)
    println("\nStrings puros o raw Strings:")
    var cadena3 = """Pablo
        |
        |                Blanco
            Hernández""".trimMargin()
    println(cadena3)

    //Longitud de la cadena
    println("\nLongitud de cadena:")
    println(cadena.length)
    //Concatenar
    println("\nConcatenaciones:")
    var cadena4 = "Hola"
    var cadena5 = "Qué tal"
    println(cadena4 + " " + cadena5)

    println("Mi nombre es $cadena y tiene ${cadena.length} caracteres")

    var dinero: Int = 10
    println("Mi nombre es $cadena y tengo $10 dolares")
    println("Mi nombre es $cadena y tengo $$dinero dolares")
    println("Mi nombre es $cadena y tengo ${'$'}$dinero dolares")

    //Arrays
    println("\nArrays:")
    var i = 1
    var arreglo: Array<Int> = arrayOf(1, 2, 3);
    println(arreglo[2])

    var arreglo2 = arrayOf("Seat", "Audi", "Mercedes", "Volkswagen")
    println(arreglo2[1])

    var arreglo3 = intArrayOf(21, 54, 86, 9, 10)

    var cualquiera: Any = 18   //vale para poner cualquier tipo de dato

    //Operadores aritméticos, comparación y lógicos
    // + - * /
    println("\nOperadores aritméticos:")
    var compuesto = 15 * 4
    println(compuesto)

    // < > == <= >= !=
    println("\nOperadores de comparación:")
    var a = 5
    var b = 8
    var datoBoleano = a != b
    println(datoBoleano)
    println(a <= b)

    // ! && ||
    println("\nOperadores lógicos:")
    var c = 7
    println(a == b && c > a)
                //true        &&  false  Output:false
    println((a != b || c < a) && (b == c))

    //Ejercicios
    a = 5
    b = 3
    c = -12

    /*
a) a > 3 true         b) a > b    true           c) a < c false
d) c < b     true                  e) b != a       true            f) a == 8  false
g) b * c == 18     false        h) a * b == -30      false        i) c / b < a true
j) c / b == -11       false      k) c / b == -4    true      l) a + c + b == 5 false
m) (a+b == 8) && (a-b == 2)  true   n) (a+b == 8) || (a-b == 6)  true
o) a > 3 && b > 4 && c < 3   false     p) a > 3 && b >= 3 && c < -3  true
*/
}