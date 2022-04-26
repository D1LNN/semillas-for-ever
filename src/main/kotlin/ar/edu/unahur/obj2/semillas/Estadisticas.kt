package ar.edu.unahur.obj2.semillas


object INTA {
    val listaDeParcela = mutableListOf<Parcela>()

    fun agregarParcela(parcela:Parcela) {listaDeParcela.add(parcela)}

    fun cantidadPlantaPorParcela():Double = listaDeParcela.sumBy { p->p.plantasQueTiene.size }.toDouble()

    fun promedioDePlantasPorParcela():Double = (cantidadPlantaPorParcela()).toDouble()/(listaDeParcela.size).toDouble()

    fun parcelaMasAutosustentable(): Parcela? = listaDeParcela.filter { pcl: Parcela -> pcl.plantasQueTiene.size > 4 }.maxByOrNull{ pcl: Parcela -> pcl.porcentajeDeBienAsociadas() }

}

