package ar.edu.unahur.obj2.semillasAlViento

import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.collections.shouldContainExactly
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
                val plantita = Menta(2000,0.5F)
                parcelaDeMarcela.plantar(plantita)
                plantita.parcelaTieneComplicaciones(parcelaDeMarcela).shouldBeTrue()
            }
//            it("Si se puede plantar:"){
//                val parcelaDeMarcela = Parcela(15,20,9)
//                val plantitaDeSoja = Soja(2000,0.7F,false)
//                val menta = Menta(2010,0.3F)
//                //parcelaDeMarcela.plantar(plantitaDeSoja)
//                shouldThrowAny {parcelaDeMarcela.plantar(menta)}
//                //parcelaDeMarcela.plantas.size.shouldBe(1)
//            }
        }
    }
    describe("Agricultoras"){
        it("parcelas semilleras"){
            val parcela = Parcela(10,10,9)
            val listParcel = mutableListOf<Parcela>()
            val menta = Menta(2017,0.5F)
            parcela.plantar(menta)
            listParcel.add(parcela)
            val agricultora = Agricultora(listParcel)
            agricultora.parcelasSemilleras().shouldContainExactly(listParcel)
        }
        it("plantar estratégicamente"){
            val parcela = Parcela(5,5,6)
            val parcela1 = Parcela(1,2,6)
            val listParcel = mutableListOf<Parcela>()
            val menta = Menta(2017,0.5F)
            listParcel.add(parcela)
            listParcel.add(parcela1)
            val agricultora = Agricultora(listParcel)
            agricultora.plantarEstrategicamente(menta)
            parcela.plantas.size.shouldBe(1)
        }
    }
})