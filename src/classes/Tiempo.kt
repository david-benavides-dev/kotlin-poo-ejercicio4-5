package classes

class Tiempo(hora: Int = 0, var minuto: Int = 0, var segundo: Int = 0) {

    var hora: Int = hora
        set(value) {
            if (value < 0 || value >= 24) {
                throw IllegalArgumentException("La hora debe estar entre 0 y 23.")
            }
            field = value
            normalizar()
        }


    constructor(hora: Int) : this(hora, 0, 0)


    constructor(hora: Int, minuto: Int) : this(hora, minuto, 0)


    private fun normalizar() {
        minuto += segundo / 60
        segundo %= 60

        hora += minuto / 60
        minuto %= 60

        if (hora >= 24) {
            throw IllegalArgumentException("La hora no puede pasar de 23:59:59.")
        }
    }


     //  Incrementa en t, el total del tiempo que almacena el objeto que recibe el mensaje, devolviendo false si al incrementar se superan las 23:59:59, en
     //  cuyo caso no cambiaría nada del objeto que recibe el mensaje. En el programa principal,
     //  debe solicitar por teclado hora, minuto y segundo del objeto t. Mostrará por pantalla el resultado obtenido al incrementar en t el tiempo, mostrando un mensaje de error si devuelve false.
    fun incrementar(t:Tiempo):Boolean {
        if (t.hora + hora > 24) {
            return false
        } else if ()

    }


    fun decrementar(t:Tiempo):Boolean {

    }


    fun comparar(t:Tiempo):Int {
        return when {
            hora < t.hora || (hora <= t.hora && minuto < t.minuto) || (hora <= t.hora && minuto <= t.minuto && segundo < t.segundo) -> -1
            hora == t.hora && minuto == t.minuto && segundo == t.segundo -> 0
            else -> 1
        }
    }


    fun copiar():Tiempo {
        return Tiempo(hora, minuto, segundo)
    }


    fun copiar(t:Tiempo) {
        hora = t.hora
        minuto = t.minuto
        segundo = t.segundo
    }


    fun sumar(t:Tiempo):Tiempo? {

    }


    fun restar(t:Tiempo):Tiempo? {

    }

    fun esMayorQue(t:Tiempo):Boolean {

    }

    fun esMenorQue(t:Tiempo):Boolean {

    }

    override fun toString(): String {
        return "%02dh %02dm %02ds".format(hora, minuto, segundo)
    }
}