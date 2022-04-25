package ar.edu.unahur.obj2.semillas

import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.assertions.throwables.shouldThrowMessage
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

class ParcelasTest: DescribeSpec ({
    val parcela1 = Parcela(20.0, 1.0,10)
    val soja2 = Soja(2.0, 2009)
    val soja3 = Soja(1.5, 2009)
    val soja4 = Soja(2.1, 2009)
    val soja5 = Soja(1.1, 2009)
    val soja6 = Soja(1.1, 2009)

    describe("probamos los atributos") {
        parcela1.ancho.shouldBe(20.0)
        parcela1.largo.shouldBe(1.0)
        parcela1.horasDeSol.shouldBe(10)
    }

    describe("Superficie de parcela") {
        parcela1.superficie().shouldBe(20.0)
    }

    describe("Cantidad maxima de plantas") {
        parcela1.cantidadDePlantasQueTolera().shouldBe(4)
    }

    describe("Tiene complicaciones") {

        it("Agrego Plantas y no tiene complicaciones") {
            // Agrego Plantas
            parcela1.plantar(soja2)
            parcela1.plantar(soja3)
            parcela1.plantar(soja4)
            parcela1.plantar(soja5)
            // Debera dar Falso

            parcela1.tieneComplicaciones().shouldBeFalse()
        }

        it("Y si agrego otras, tiene complicaciones") {
            shouldThrowAny { parcela1.plantar(soja6) }
        }
    }
})

