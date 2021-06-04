package ar.edu.unahur.obj2.semillasAlViento

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

class PlantaTest: DescribeSpec({
    describe("Plantas - Sol"){
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
        it("Soja Trans: cuantas horas de sol tolera"){
            val sojaBaja = Soja(2007,0.4F,true)
            val sojaMedia = Soja(2010,0.7F,true)
            val sojaAlta = Soja(2010,1.5F,true)
            sojaBaja.horasDeSolQueTolera().shouldBe(12)
            sojaMedia.horasDeSolQueTolera().shouldBe(14)
            sojaAlta.horasDeSolQueTolera().shouldBe(18)
        }
    }
    describe("Plantas - Fortaleza"){
        it("Menta: Es fuerte"){
            val mentaBaja = Menta(2016,0.4F)
            mentaBaja.esFuerte().shouldBeFalse()
        }
        it("Soja: Es fuerte"){
            val sojaBaja = Soja(2007,0.4F,false)
            val sojaMedia = Soja(2010,0.7F,false)
            val sojaAlta = Soja(2010,1.5F,false)
            sojaBaja.esFuerte().shouldBeFalse()
            sojaMedia.esFuerte().shouldBeFalse()
            sojaAlta.esFuerte().shouldBeFalse()
        }
        it("Soja Trans: Es fuerte"){
            val sojaBaja = Soja(2007,0.4F,true)
            val sojaMedia = Soja(2010,0.7F,true)
            val sojaAlta = Soja(2010,1.5F,true)
            sojaBaja.esFuerte().shouldBeTrue()
            sojaMedia.esFuerte().shouldBeTrue()
            sojaAlta.esFuerte().shouldBeTrue()
        }
    }
    describe("Plantas - Semillas"){
        it("Menta: Da semillas"){
            val mentaBaja = Menta(2016,0.3F)
            val mentaAlta = Menta(2016,0.9F)
            mentaBaja.daSemillas().shouldBeFalse()
            mentaAlta.daSemillas().shouldBeTrue()
        }
        it("Soja: Da semillas"){
            val sojaBaja = Soja(2007,0.4F,false)
            val sojaMedia = Soja(2010,0.7F,false)
            val sojaAlta = Soja(2010,1.5F,false)
            sojaBaja.daSemillas().shouldBeFalse()
            sojaMedia.esFuerte().shouldBeFalse()
            sojaAlta.daSemillas().shouldBeTrue()
        }
        it("Soja Trans: Da semillas"){
            val sojaBaja = Soja(2007,0.4F,true)
            val sojaMedia = Soja(2010,0.7F,true)
            val sojaAlta = Soja(2010,1.5F,true)
            sojaBaja.daSemillas().shouldBeFalse()
            sojaMedia.daSemillas().shouldBeFalse()
            sojaAlta.daSemillas().shouldBeFalse()
        }
    }
})