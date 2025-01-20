import classes.Tiempo

fun main() {

    // Instancia de clase tiempo con input del usuario
    val (hora, minuto, segundo) = pedirHora()
    val tiempo = Tiempo(hora, minuto, segundo)
    println(tiempo)
}


// Valida la entrada del usuario.
fun validarHora(tiempoTotal: List<Int>): Boolean {
    if (tiempoTotal.size != 3)
        return false // Verificar tamaño.
    return tiempoTotal[0] in 0..23
}


// Función para pedir la hora, retornando una lista mutable.
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