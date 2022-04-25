package ar.edu.unahur.obj2.semillas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

class ParcelasIdeales : DescribeSpec({

    val menta = Menta(1.0, 2021)
    val parcela1 = Parcela(7.0, 1.0, 10)
    val parcela2 = Parcela(6.0, 1.0, 10)
    val peperina = Peperina(1.0, 2000)
    val quinoa = Quinoa(0.2, 1.2, 2010)
    val parcela3 = Parcela(6.0, 1.0, 6)
    val quinoa2 = Quinoa(0.2, 1.6, 2010)
    var soja1=Soja(0.4,2021)
    var soja2=Soja(0.5,2021)
    var sojaTransgenica=SojaTransgenica(1.0,2022)
    val parcela4 = Parcela(5.0, 1.0, 6)

    describe("Menta") {

        it("es ideal") {
            parcela1.superficie().shouldBe(7)
            menta.esIdeal(parcela1).shouldBeTrue()
        }
        it("no es ideal"){
            parcela2.superficie().shouldBe(6)
            menta.esIdeal(parcela2).shouldBeFalse()

        }
    }
    describe("Peperina") {

        it("es ideal") {
            parcela1.superficie().shouldBe(7)
            peperina.esIdeal(parcela1).shouldBeTrue()
        }
        it("no es ideal"){
            parcela2.superficie().shouldBe(6)
            peperina.esIdeal(parcela2).shouldBeFalse()

        }
    }
    describe("Quinoa") {

        it("es ideal") {
            parcela2.plantar(quinoa)
            parcela2.tienePlantasMayoresA(1.5).shouldBeFalse()
            quinoa2.esIdeal(parcela2).shouldBeTrue()

        }
        it("no es ideal"){
            parcela1.plantar(quinoa2)
            parcela1.tienePlantasMayoresA(1.5).shouldBeTrue()
            quinoa.esIdeal(parcela1).shouldBeFalse()
        }
    }

    describe("Soja común") {

        it("es ideal") {
            soja1.esIdeal(parcela3).shouldBeTrue()

        }
        it("no es ideal"){
            soja2.esIdeal(parcela3).shouldBeFalse()

        }
    }

    describe("Soja Transgenica") {

        it("es ideal") {
            parcela4.cantidadDePlantasQueTolera().shouldBe(1.0)
            sojaTransgenica.esIdeal(parcela4).shouldBeTrue()

        }
        it("no es ideal"){
            sojaTransgenica.esIdeal(parcela3).shouldBeFalse()

        }
    }

})