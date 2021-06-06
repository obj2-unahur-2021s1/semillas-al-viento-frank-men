package ar.edu.unahur.obj2.semillasAlViento

import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.shouldBe

class ParcelaTest: DescribeSpec({
    describe("Una parcela:"){
        describe("Se debe poder crear una parcela"){
            val parcelaDeLaAbuela = Parcela(10,15,8)
            it("una parcela posee ancho,largo y horas de sol.") {
                parcelaDeLaAbuela.ancho.shouldBe(10)
                parcelaDeLaAbuela.largo.shouldBe(15)
                parcelaDeLaAbuela.horasSolPorDia.shouldBe(8)
            }
        }
        describe("De una parcela se debe conocer:"){
            it("La superficie:"){
                val parcelaDeMarcela = Parcela(15,20,12)
                parcelaDeMarcela.superficie().shouldBe(300) }

            it("Cantidad Maxima deplantas"){
                val parcelaLarga = Parcela(5,6,12)
                // 30 / 3 + 6
                parcelaLarga.cantidadMaximaPlantas().shouldBe(16)
                val parcelaAncha = Parcela(6,5,12)
                // 30 / 5
                parcelaAncha.cantidadMaximaPlantas().shouldBe(6)
            }

            it("Si tiene complicaciones:"){
                val parcelaDeMarcela = Parcela(15,20,9)
                val plantita = Menta(2000,0.5)
                parcelaDeMarcela.plantar(plantita)
                parcelaDeMarcela.parcelaTieneComplicaciones().shouldBeTrue()
            }
            it("Si se puede plantar:"){
                val parcelaDeMarcela = Parcela(15, 20, 10)
                val plantitaDeSoja = Soja(2000, 0.7)
                val sojaTrans = SojaTransgenica(2000, 0.7)
                parcelaDeMarcela.plantar(plantitaDeSoja)
                shouldThrowAny { parcelaDeMarcela.plantar(sojaTrans) }
                parcelaDeMarcela.cantidadPlantas().shouldBe(1)
            }
        }
    }
    describe("Agricultoras"){
        val parcela = Parcela(10,10,9)
        val parcela1 = Parcela(1,2,6)
        val menta = Menta(2017,0.5)
        val agricultora = Agricultora()
        agricultora.parcelas.add(parcela)
        agricultora.parcelas.add(parcela1)
        it("parcelas semilleras"){
            parcela.plantar(menta)
            agricultora.parcelasSemilleras().shouldContain(parcela)
        }
        it("plantar estratégicamente"){
            agricultora.plantarEstrategicamente(menta)
            parcela.cantidadPlantas().shouldBe(1)
        }
    }
})