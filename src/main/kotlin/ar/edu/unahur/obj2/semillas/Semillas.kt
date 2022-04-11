package ar.edu.unahur.obj2.semillas

class Menta(altura: Double, anioSemilla: Int): Planta(altura, anioSemilla) {

    override fun condicionAlternativa() = altura > 0.4

    override fun espacio(): Double = altura + 1.0

}

class Soja(altura: Double, anioSemilla: Int): Planta(altura, anioSemilla) {
    override fun horasDeSolTolera(): Int = if (altura < 0.5) 6 else if (altura < 1.0) 8 else 12

    override fun condicionAlternativa() = anioSemilla < 2007 && 0.75 <= altura && altura >= 0.9

    override fun espacio(): Double = altura / 2
}

open class Planta(var altura: Double, val anioSemilla: Int) {
    object Constates {      // Companion Objects
        val umbralDeHorasDeSol = 9
    }

    open fun horasDeSolTolera(): Int = 7

    fun esFuerte() = horasDeSolTolera() > Planta.Constates.umbralDeHorasDeSol

    open fun espacio(): Double = 0.0

    fun daSemillas() = esFuerte() || condicionAlternativa()

    open fun condicionAlternativa(): Boolean = false
}