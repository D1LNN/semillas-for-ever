package ar.edu.unahur.obj2.semillas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.shouldBe

class VariedadesTest: DescribeSpec( {
    val sojaTransgenica = SojaTransgenica(0.6, 2009)
    val peperina = Peperina(1.0, 2000)
    describe("Creación de las plantas") {
        sojaTransgenica.daSemillas().shouldBeFalse()
    }
    describe("peperina") {
        peperina.espacio().shouldBe(4.0)
    }
})

