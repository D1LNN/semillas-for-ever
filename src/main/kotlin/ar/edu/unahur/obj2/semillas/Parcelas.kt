package ar.edu.unahur.obj2.semillas

open class Parcela(var ancho: Double, var largo: Double, var horasDeSol: Int) {
    val plantasQueTiene = mutableListOf<Planta>()

    fun superficie(): Double = ancho * largo

    fun cantidadDePlantasQueTolera(): Double = if (ancho > largo) superficie() / 5 else superficie() / 3 + largo

    fun tieneComplicaciones() = plantasQueTiene.any { p: Planta -> p.horasDeSolTolera() < horasDeSol }

    fun plantar(planta: Planta) {

        if ((plantasQueTiene.size * 1.0) == cantidadDePlantasQueTolera()) {
            error("Ya no hay lugar en esta parcela")
        } else if (horasDeSol >= planta.horasDeSolTolera() + 2) {
            error("No se puede plantar esto acá, se va a quemar")
        } else {
            plantasQueTiene.add(planta)
        }
    }

    open fun seAsociaBien(planta: Planta) = true

    fun tienePlantasMayoresA(medida: Double)=plantasQueTiene.any { p:Planta -> p.altura > medida}

    fun porcentajeDeBienAsociadas(): Double = if (plantasQueTiene.size > 0) {
        ((plantasQueTiene.count { p: Planta -> seAsociaBien(p) }) * 100).toDouble() / plantasQueTiene.size.toDouble()
    }
    else {
        0.0
    }

}

class ParcelaEcologica(ancho: Double, largo: Double, horasDeSol: Int): Parcela(ancho, largo, horasDeSol) {
    override fun seAsociaBien(planta: Planta) = ! tieneComplicaciones() && planta.esIdeal(this)

}

class ParcelaIndustrial(ancho: Double, largo: Double, horasDeSol: Int): Parcela(ancho, largo, horasDeSol) {
    override fun seAsociaBien(planta: Planta) = plantasQueTiene.size <= 2 && planta.esFuerte()

}