import classes.Tiempo

fun main() {

    // * Instancias de la clase Tiempo con la hora, minutos y segundos proporcionados por el usuario.
    val (hora1, minuto1, segundo1) = pedirHora()
    val tiempo1 = Tiempo(hora1,minuto1,segundo1)
    val (hora2, minuto2, segundo2) = pedirHora()
    val tiempo2 = Tiempo(hora2,minuto2,segundo2)


    // * Incremento de hora a tiempo1 con mensaje de error si no ha sido posible incrementarla.
    if (tiempo1.incrementar(tiempo2)) {
        println("La hora se incrementó correctamente. Nueva hora: $tiempo1")
    } else {
        println("No es posible incrementar la hora.")
    }


    println("*****************************")


    // * Decremento de hora a tiempo1 con mensaje de error si no ha sido posible decrementarla.
    val (horaD, minutoD, segundoD) = pedirHora()
    val decrementarTiempo = Tiempo(horaD,minutoD,segundoD)
    if (tiempo1.decrementar(decrementarTiempo)) {
        println("La hora se decrementó correctamente. Nueva hora: $tiempo1")
    } else {
        println("No es posible decrementar la hora.")
    }


    println("*****************************")


    // * Compara dos objetos tiempo y muestra un mensaje si el objeto tiempo
    // * a comparar es mayor, menor o igual.
    val (horaC, minutoC, segundoC) = pedirHora()
    val compararTiempo = Tiempo(horaC,minutoC,segundoC)
    when (tiempo2.comparar(compararTiempo)) {
        1 -> println("Es tiempo actual mayor.")
        0 -> println("Los dos tiempos son iguales.")
        -1 -> println("El tiempo actual es menor.")
    }


    println("*****************************")


    // * Copia el tiempo de un objeto tiempo a una nueva, mostrándolo por pantalla.
    val tiempoCopia = tiempo1.copiar()
    println("Tiempo copiado: $tiempoCopia")


    println("*****************************")


    // * Reemplaza el tiempo de una clase por otra dada.
    val tiempoReemplazo = Tiempo(10,10,10)
    tiempoReemplazo.copiar(tiempo1)
    println("Tiempo reemplazado: $tiempoReemplazo")


    println("*****************************")


    // * Suma el tiempo de una clase tiempo a otra.
    val tiempoSuma = Tiempo(3,44,15)
    val tiempo10 = tiempo1.sumar(tiempoSuma)
    if (tiempo10 == null) {
        println("No se ha podido sumar el tiempo correctamente.")
    } else {
        println("Tiempo sumado correctamente: $tiempo10")
    }

    println("*****************************")


    // * Resta el tiempo de una clase tiempo a otra
    val tiempoResta = Tiempo(8,14,33)
    val tiempo15 = tiempo1.restar(tiempoResta)
    if (tiempo15 == null) {
        println("No se ha podido restar el tiempo.")
    } else {
        println("Tiempo restado correctamente: $tiempo15")
    }


    println("*****************************")


    // * Compara si una clase tiempo es mayor que otra proporcionada.
    if (tiempo1.esMayorQue(tiempo2)) {
        println("El tiempo es mayor.")
    }


    println("*****************************")


    // * Compara si una clase tiempo es menor que otra proporcionada.
    if (tiempo1.esMenorQue(tiempo2)) {
        println("El tiempo es menor.")
    }
}

fun validarHora(tiempoTotal: List<Int>): Boolean {
    if (tiempoTotal.size != 3)
        return false // Verificar tamaño.
    return tiempoTotal[0] in 0..23
}

fun pedirHora(): List<Int> {
    while (true) {
        try {
            print("Introduce la hora (formato HH,MM,SS separados por comas) >> ")
            val time = readln().split(",").map { it.trim().toInt() }.toMutableList()

            if (validarHora(time)) {
                return time
            } else {
                println("*ERROR* La hora introducida no es correcta: formato HH,MM,SS.")
            }
        } catch (e: Exception) {
            println("*ERROR* Entrada inválida. Debes introducir números separados por comas.")
        }
    }
}