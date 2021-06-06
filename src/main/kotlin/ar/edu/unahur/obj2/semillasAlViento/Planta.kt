package ar.edu.unahur.obj2.semillasAlViento

abstract class Planta(val anioObtencion: Int, val altura: Double) {
  fun esFuerte() = this.horasDeSolQueTolera() > 10

  abstract fun horasDeSolQueTolera(): Int
  open fun daSemillas(): Boolean = this.esFuerte()
}


class Menta(anioObtencion: Int, altura: Double) : Planta(anioObtencion, altura) {
  override fun horasDeSolQueTolera() = 6
  override fun daSemillas() = super.daSemillas() || altura > 0.4
}

open class Soja(anioObtencion: Int, altura: Double) : Planta(anioObtencion, altura) {
  override fun horasDeSolQueTolera(): Int {
    val horasBase = when {
      altura < 0.5 -> 6
      altura < 1 -> 7
      else -> 9
    }
    return horasBase
  }

  override fun daSemillas(): Boolean {
    return super.daSemillas() || (this.anioObtencion > 2007 && this.altura > 1)
  }
}

class SojaTransgenica(anioObtencion: Int, altura: Double) : Soja(anioObtencion, altura) {
  override fun daSemillas() = false

  override fun horasDeSolQueTolera(): Int {
    return super.horasDeSolQueTolera() * 2
  }
}