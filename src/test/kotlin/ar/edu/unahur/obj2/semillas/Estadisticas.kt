package ar.edu.unahur.obj2.semillas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class Estadisticas: DescribeSpec({

    val parcela1 = Parcela(20.0, 1.0,10)
    val parcela2 = Parcela(6.0, 1.0, 10)
    val parcela3 = Parcela(6.0, 1.0, 6)
    val parcela4 = Parcela(5.0, 1.0, 6)
    val menta = Menta(1.0, 2021)
    val mentita = Menta(0.3, 2021)
    val soja = Soja(1.6, 2009)
    val quinoa = Quinoa(0.2, 1.2, 2010)
    val quinoa2 = Quinoa(0.9, 0.5, 2006)
    val quinoa3 = Quinoa(0.2, 1.6, 2010)
    val peperina = Peperina(1.0, 2000)
    var soja1=Soja(0.4,2021)
    var soja2=Soja(0.5,2021)
    var sojaTransgenica=SojaTransgenica(1.0,2022)

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
    }
    })