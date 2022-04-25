package ar.edu.unahur.obj2.semillas

class SojaTransgenica(altura: Double, anioSemilla: Int): Soja(altura, anioSemilla) {
    override fun daSemillas(): Boolean = false
    override fun esIdeal(parcela: Parcela)=parcela.cantidadDePlantasQueTolera()==1.0
}

class Peperina(altura: Double, anioSemilla: Int): Menta(altura, anioSemilla) {
    override fun espacio(): Double = super.espacio() * 2
}