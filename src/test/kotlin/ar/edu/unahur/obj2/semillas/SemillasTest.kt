package ar.edu.unahur.obj2.semillas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe
import kotlin.math.ceil

class SemillasTest : DescribeSpec ({
    // hay una clase Planta que tiene por atributos
    // anioSemilla, altura
    describe("Creación de las plantas") {
        val menta = Menta(1.0, 2021)
        val mentita = Menta(0.3, 2021)
        val soja = Soja(0.6, 2009)
        val quinoa = Quinoa(0.2, 1.2, 2010)
        val quinoa2 = Quinoa(0.9, 0.5, 2006)
        val sojaTransgenica = SojaTransgenica(0.6, 2009)
        val peperina = Peperina(1.0, 2000)

        it("probamos los atributos altura  y anioSemilla") {
            menta.altura.shouldBe(1.0)
            menta.anioSemilla.shouldBe(2021)
        }

        it("verificar si da semillas") {
            menta.daSemillas().shouldBeTrue()
            mentita.daSemillas().shouldBeFalse()
            soja.daSemillas().shouldBeFalse()
            quinoa.daSemillas().shouldBeTrue()
            quinoa2.daSemillas().shouldBeTrue()
            sojaTransgenica.daSemillas().shouldBeFalse()
        }

        it("es fuerte") {
            menta.esFuerte().shouldBeFalse()
            soja.esFuerte().shouldBeFalse()
        }

        it("espacio") {
            menta.espacio().shouldBe(2.0)
            mentita.espacio().shouldBe(1.3)
            soja.espacio().shouldBe(0.3)
            peperina.espacio().shouldBe(4.0)
        }

        it("verifico la suma de varias") {
            val superficie = mutableListOf(
                soja.espacio(),
                menta.espacio(),
                mentita.espacio()
            ).sum()
            ceil(superficie).shouldBe(4)   //Math.ceil(num) redondea el numero dado
        }

        it ("Verifico las horas de sol toleradas") {
            menta.horasDeSolTolera().shouldBe(7)
            soja.horasDeSolTolera().shouldBe(8)
            quinoa.horasDeSolTolera().shouldBe(10)
            quinoa2.horasDeSolTolera().shouldBe(7)
        }
    }

    describe("Parcelas") {
        val parcela1 = Parcela(20.0, 1.0,10)

        val soja2 = Soja(2.0, 2009)
        val soja3 = Soja(1.5, 2009)
        val soja4 = Soja(2.1, 2009)
        val soja5 = Soja(1.1, 2009)
        val soja6 = Soja(1.1, 2009)

        it("probamos los atributos") {
            parcela1.ancho.shouldBe(20.0)
            parcela1.largo.shouldBe(1.0)
            parcela1.horasDeSol.shouldBe(10)
        }

        it("Superficie") { parcela1.superficie().shouldBe(20.0) }

        it("Maximo de plantas") { parcela1.cantidadDePlantasQueTolera().shouldBe(4) }

        it ("Plnatamos planta en parcela") {
            parcela1.plantar(soja2)
            parcela1.plantar(soja3)
            parcela1.plantar(soja4)
            parcela1.plantar(soja5)
        }

        it ("Parcela tiene complicaciones") {
            parcela1.tieneComplicaciones().shouldBeFalse()
        }
    }
})