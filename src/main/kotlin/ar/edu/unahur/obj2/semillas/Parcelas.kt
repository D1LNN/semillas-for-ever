package ar.edu.unahur.obj2.semillas

class Parcela(var ancho: Double, var largo: Double, var horasDeSol: Int) {
    val plantasQueTiene = mutableListOf<Planta>()

    fun superficie(): Double = ancho * largo

    fun cantidadDePlantasQueTolera(): Double = if (ancho > largo) superficie() / 5 else superficie() / 3 + largo

    fun tieneComplicaciones() = plantasQueTiene.any { p: Planta -> p.horasDeSolTolera() < horasDeSol }

    fun plantar(planta: Planta) {
        if (cantidadDePlantasQueTolera() > plantasQueTiene.size || (horasDeSol - planta.horasDeSolTolera()) < 2) {
            plantasQueTiene.add(planta)
        }
        else {
            error("Se supera el maximo de plantas de la parcela o la parcela recibe al menos 2 horas mas de sol que los que la planta tolera.")
        }
    }
}