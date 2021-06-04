package ar.edu.unahur.obj2.semillasAlViento

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class PlantaTest: DescribeSpec({
    describe("Plantas de "){
        it("Menta: cuantas horas de sol tolera"){
            val mentaBaja = Menta(2016,0.4F)
            mentaBaja.horasDeSolQueTolera().shouldBe(6)
        }
        it("Soja: cuantas horas de sol tolera"){
            val sojaBaja = Soja(2007,0.4F,false)
            val sojaMedia = Soja(2010,0.7F,false)
            val sojaAlta = Soja(2010,1.5F,false)
            sojaBaja.horasDeSolQueTolera().shouldBe(6)
            sojaMedia.horasDeSolQueTolera().shouldBe(7)
            sojaAlta.horasDeSolQueTolera().shouldBe(9)
        }
    }
})