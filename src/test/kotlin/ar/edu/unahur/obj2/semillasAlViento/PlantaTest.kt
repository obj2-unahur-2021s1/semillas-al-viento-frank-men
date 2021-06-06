package ar.edu.unahur.obj2.semillasAlViento

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

class PlantaTest: DescribeSpec({
    describe("Plantas - Sol"){
        it("Menta: cuantas horas de sol tolera"){
            /*Es necesario modificar los tests, debido a que no
            se contemplo la situacion de cambiar el tipo de
            dato de altura (float a double).    */
            val mentaBaja = Menta(2016,0.4)
            mentaBaja.horasDeSolQueTolera().shouldBe(6)
        }
        it("Soja: cuantas horas de sol tolera"){
            val sojaBaja = Soja(2007, 0.4)
            val sojaMedia = Soja(2010, 0.7)
            val sojaAlta = Soja(2010, 1.5)
            sojaBaja.horasDeSolQueTolera().shouldBe(6)
            sojaMedia.horasDeSolQueTolera().shouldBe(7)
            sojaAlta.horasDeSolQueTolera().shouldBe(9)
        }
        it("Soja Trans: cuantas horas de sol tolera") {
            val sojaTransBaja = SojaTransgenica(2007, 0.4)
            val sojaTransMedia = SojaTransgenica(2010, 0.7)
            val sojaTransAlta = SojaTransgenica(2010, 1.5)
            sojaTransBaja.horasDeSolQueTolera().shouldBe(12)
            sojaTransMedia.horasDeSolQueTolera().shouldBe(14)
            sojaTransAlta.horasDeSolQueTolera().shouldBe(18)
        }
    }
    describe("Plantas - Fortaleza"){
        it("Menta: Es fuerte"){
            val mentaBaja = Menta(2016,0.4)
            mentaBaja.esFuerte().shouldBeFalse()
        }
        it("Soja: Es fuerte") {
            val sojaBaja = Soja(2007, 0.4)
            val sojaMedia = Soja(2010, 0.7)
            val sojaAlta = Soja(2010, 1.5)
            sojaBaja.esFuerte().shouldBeFalse()
            sojaMedia.esFuerte().shouldBeFalse()
            sojaAlta.esFuerte().shouldBeFalse()
        }
        it("Soja Trans: Es fuerte") {
            val sojaTransBaja = SojaTransgenica(2007, 0.4)
            val sojaTransMedia = SojaTransgenica(2010, 0.7)
            val sojaTransAlta = SojaTransgenica(2010, 1.5)
            sojaTransBaja.esFuerte().shouldBeTrue()
            sojaTransMedia.esFuerte().shouldBeTrue()
            sojaTransAlta.esFuerte().shouldBeTrue()
        }
    }
    describe("Plantas - Semillas"){
        it("Menta: Da semillas"){
            val mentaBaja = Menta(2016,0.3)
            val mentaAlta = Menta(2016,0.9)
            mentaBaja.daSemillas().shouldBeFalse()
            mentaAlta.daSemillas().shouldBeTrue()
        }
        it("Soja: Da semillas") {
            val sojaBaja = Soja(2007, 0.4)
            val sojaMedia = Soja(2010, 0.7)
            val sojaAlta = Soja(2010, 1.5)
            sojaBaja.daSemillas().shouldBeFalse()
            sojaMedia.esFuerte().shouldBeFalse()
            sojaAlta.daSemillas().shouldBeTrue()
        }
        it("Soja Trans: Da semillas") {
            val sojaTransBaja = SojaTransgenica(2007, 0.4)
            val sojaTransMedia = SojaTransgenica(2010, 0.7)
            val sojaTransAlta = SojaTransgenica(2010, 1.5)
            sojaTransBaja.daSemillas().shouldBeFalse()
            sojaTransMedia.daSemillas().shouldBeFalse()
            sojaTransAlta.daSemillas().shouldBeFalse()
        }
    }
})