package ar.edu.unahur.obj2.semillas

open class Menta(altura: Double, anioSemilla: Int): Planta(altura, anioSemilla) {

    override fun condicionAlternativa() = altura > 0.4

    override fun espacio(): Double = altura + 1.0
    override fun esIdeal(parcela: Parcela) = parcela.superficie() > 6
}

open class Soja(altura: Double, anioSemilla: Int): Planta(altura, anioSemilla) {
    override fun horasDeSolTolera(): Int = if (altura < 0.5) 6 else if (altura < 1.0) 8 else 12

    override fun condicionAlternativa() = anioSemilla < 2007 && altura in 0.75..0.9     // 0.75 <= altura && altura <= 0.9

    override fun espacio(): Double = altura / 2

    override fun esIdeal(parcela: Parcela) = horasDeSolTolera() == parcela.horasDeSol

    }

class Quinoa(var espacio: Double, altura: Double, anioSemilla: Int): Planta(altura, anioSemilla) {
    override fun horasDeSolTolera(): Int = if (espacio < 0.3) 10 else super.horasDeSolTolera()

    override fun condicionAlternativa(): Boolean = anioSemilla in 2001..2008    // 2001 <= altura && altura <= 2009
    override fun esIdeal(parcela: Parcela)=!parcela.tienePlantasMayoresA(1.5)
    }

open class Planta(var altura: Double, val anioSemilla: Int) {
    object Constates {      // Companion Objects
        val umbralDeHorasDeSol = 9
    }

    open fun horasDeSolTolera(): Int = 7

    fun esFuerte() = horasDeSolTolera() > Constates.umbralDeHorasDeSol

    open fun espacio(): Double = 0.0

    open fun daSemillas() = esFuerte() || condicionAlternativa()

    open fun condicionAlternativa(): Boolean = false

    open fun esIdeal(parcela: Parcela): Boolean = true
}