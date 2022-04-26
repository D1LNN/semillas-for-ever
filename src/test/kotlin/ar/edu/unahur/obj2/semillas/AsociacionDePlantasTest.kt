package ar.edu.unahur.obj2.semillas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue

class AsociacionDePlantasTest: DescribeSpec ({
    var parcelaEco  = ParcelaEcologica(20.0, 1.0,12)
    var parcelaInd = ParcelaIndustrial(20.0, 1.0,9)

    val soja = Soja(1.1, 2009)
    val soja2 = Soja(0.9, 2009)
    val quinoa = Quinoa(0.2, 1.2, 2010)

    describe("Parcela Ecologica") {
        it("Soja se asocia bien"){
            parcelaEco.seAsociaBien(soja).shouldBeTrue()
        }
        it("Soja2 se asocia bien") {
            parcelaEco.seAsociaBien(soja2).shouldBeFalse()
        }
    }
    describe("Parcela Industrial") {
        it("Soja se asocia bien en Parcela con 2 plantas"){
            parcelaInd.plantar(soja2)
            parcelaInd.plantar(quinoa)
            parcelaInd.seAsociaBien(soja).shouldBeTrue()
        }
        it("Soja no se asocia bien en Parcela con 1 planta") {
            parcelaInd.plantar(quinoa)
            parcelaInd.seAsociaBien(soja).shouldBeFalse()
        }
    }
})