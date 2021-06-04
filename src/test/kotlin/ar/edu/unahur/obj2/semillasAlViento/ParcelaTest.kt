package ar.edu.unahur.obj2.semillasAlViento

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf

class ParcelaTest: DescribeSpec({
    describe("Una parcela:"){
        describe("Se debe poder crear una parcela"){
            val parcelaDeLaAbuela = Parcela(10,15,8)
            it("una parcela posee ancho,largo y horas de sol.") {
                parcelaDeLaAbuela.ancho.shouldBe(10)
                parcelaDeLaAbuela.largo.shouldBe(15)
                parcelaDeLaAbuela.horasSolPorDia.shouldBe(8)
            }
            it("Tambien posee plantas."){
                parcelaDeLaAbuela.plantas.shouldBeInstanceOf<List<Planta>>()
            }
        }
        describe("De una parcela se debe conocer:"){
            it("Se debe conocer la superficie:"){
                val parcelaDeMarcela = Parcela(15,20,12)
                parcelaDeMarcela.superficie().shouldBe(300) }
            describe("Se debe conocer la cantidad de plantas que tolera:"){
                it("Largo mayor que ancho."){
                    val parcelaLarga = Parcela(5,6,12)
                    // 30 / 3 + 6
                    parcelaLarga.cantidadMaximaPlantas().shouldBe(16)
                }
                it("Ancho mayor que largo."){
                    val parcelaAncha = Parcela(6,5,12)
                    // 30 / 5
                    parcelaAncha.cantidadMaximaPlantas().shouldBe(6)
                }
            }
            it("Se debe saber si la parcela tiene complicaciones:"){
                val parcelaDeMarcela = Parcela(15,20,12)
                /*ERROR DE PLANTA: no estoy pudiendo asignarle ningun valor a la
                * altura. deberia ser un int, a lo sumo un double. */
                //val plantita = Menta(2000,0.5)
            }
            it("Se debe poder plantar una planta:"){
                val parcelaDeMarcela = Parcela(15,20,12)
                /*Mismo error de planta: Altura es un float.*/
                //val plantitaDeSoja = Soja(2000,0.7,false)
            }
        }
    }

})