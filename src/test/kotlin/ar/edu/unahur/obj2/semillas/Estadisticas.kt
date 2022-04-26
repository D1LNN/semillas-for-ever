package ar.edu.unahur.obj2.semillas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Estadisticas: DescribeSpec({

    val parcela1 = ParcelaEcologica(20.0, 1.0,12)
    val parcela2 = ParcelaEcologica(6.0, 1.0, 10)
    val parcela3 = ParcelaEcologica(6.0, 1.0, 6)
    val parcela4 = ParcelaEcologica(5.0, 1.0, 6)
    val soja = Soja(1.6, 2009)
    val quinoa = Quinoa(0.2, 1.2, 2010)
    val parcelaEco1 = ParcelaEcologica(20.0, 1.0,12)
    val parcelaEco2 = ParcelaEcologica(6.0, 1.0, 12)
    val parcelaEco3 = ParcelaEcologica(6.0, 1.0, 6)
    val parcelaEco4 = ParcelaEcologica(5.0, 1.0, 6)

    describe("Estadisticas") {
        it("Promedio de plantas por parcela"){
            parcela1.plantar(soja)
            INTA.agregarParcela(parcela1)
            parcela2.plantar(soja)
            INTA.agregarParcela(parcela2)
            parcela3.plantar(quinoa)
            INTA.agregarParcela(parcela3)
            INTA.agregarParcela(parcela4)
            INTA.cantidadPlantaPorParcela().shouldBe(3)
            INTA.listaDeParcela.size.shouldBe(4)
            INTA.promedioDePlantasPorParcela().shouldBe(0.75)
        }
        it("Parcela mas autosustentable") {
            INTA.listaDeParcela.clear()

            parcelaEco1.plantar(soja)
            INTA.agregarParcela(parcelaEco1)
            parcelaEco2.plantar(soja)
            parcelaEco2.plantar(soja)
            parcelaEco2.plantar(soja)
            parcelaEco2.plantar(soja)
            INTA.agregarParcela(parcelaEco2)
            parcelaEco3.plantar(quinoa)
            parcelaEco3.plantar(quinoa)
            parcelaEco3.plantar(quinoa)
            parcelaEco3.plantar(quinoa)
            parcelaEco3.plantar(quinoa)
            INTA.agregarParcela(parcelaEco3)
            INTA.agregarParcela(parcelaEco4)

            parcelaEco1.plantasQueTiene.size.shouldBe(1)
            parcelaEco2.plantasQueTiene.size.shouldBe(4)
            parcelaEco3.plantasQueTiene.size.shouldBe(5)
            parcelaEco4.plantasQueTiene.size.shouldBe(0)

            parcelaEco1.porcentajeDeBienAsociadas().shouldBe(100.0)
            parcelaEco2.porcentajeDeBienAsociadas().shouldBe(100.0)
            parcelaEco3.porcentajeDeBienAsociadas().shouldBe(100.0)
            parcelaEco4.porcentajeDeBienAsociadas().shouldBe(0.0)
            INTA.parcelaMasAutosustentable().shouldBe(parcelaEco3)
        }
    }
})