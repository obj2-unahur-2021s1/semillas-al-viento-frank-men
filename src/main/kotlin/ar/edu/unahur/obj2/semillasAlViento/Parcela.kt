package ar.edu.unahur.obj2.semillasAlViento

class Parcela(val ancho: Int, val largo: Int, val horasSolPorDia: Int) {
  private val plantas = mutableListOf<Planta>()

  fun cantidadPlantas() = plantas.size

  fun superficie() = ancho * largo

  fun cantidadMaximaPlantas() =
    if (ancho > largo) this.superficie() / 5 else this.superficie() / 3 + largo

  fun parcelaTieneComplicaciones() =
    this.plantas.any { it.horasDeSolQueTolera() < this.horasSolPorDia }

  fun plantar(planta: Planta) {
    check((this.cantidadPlantas() <= this.cantidadMaximaPlantas())) {
      "Ya no hay lugar en esta parcela"
    }
    check(horasSolPorDia > planta.horasDeSolQueTolera() + 2) {
      "No se puede plantar esto acá, se va a quemar"
    }
    plantas.add(planta)
  }
  fun esSemillera() = plantas.all { it.daSemillas() }
}

class Agricultora() {
  val parcelas = mutableListOf<Parcela>()

  fun parcelasSemilleras() =
    parcelas.filter { it.esSemillera() }

  fun plantarEstrategicamente(planta: Planta) = parcelaConMasEspacio()?.plantar(planta)

  fun parcelaConMasEspacio(): Parcela? {
    check(parcelas.isEmpty()){
      "No hay parcelas"
    }
    return parcelas.maxByOrNull { it.cantidadMaximaPlantas() - it.cantidadPlantas() }
  }
}
