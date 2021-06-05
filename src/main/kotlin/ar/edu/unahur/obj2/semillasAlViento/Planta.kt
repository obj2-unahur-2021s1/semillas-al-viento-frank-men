package ar.edu.unahur.obj2.semillasAlViento

abstract class Planta(val anioObtencionSemilla: Int, var altura: Float) { //Altura deberia ser VAL, no var.
  fun esFuerte() = this.horasDeSolQueTolera() > 10

  fun parcelaTieneComplicaciones(parcela: Parcela) = //probablemente sea un acoplamiento innecesario.
    parcela.plantas.any { it.horasDeSolQueTolera() < parcela.horasSolPorDia }

  abstract fun horasDeSolQueTolera(): Int
  abstract fun daSemillas(): Boolean //aca se podria evitar redundancia.
}


class Menta(anioObtencionSemilla: Int, altura: Float) : Planta(anioObtencionSemilla, altura) {
  override fun horasDeSolQueTolera() = 6
  override fun daSemillas() = this.esFuerte() || altura > 0.4F
}

class Soja(anioObtencionSemilla: Int, altura: Float, val esTransgenica: Boolean) : Planta(anioObtencionSemilla, altura) {
  override fun horasDeSolQueTolera(): Int  {
    // ¡Magia de Kotlin! El `when` es como un `if` pero más poderoso:
    // evalúa cada línea en orden y devuelve lo que está después de la flecha.
    val horasBase = when {
      altura < 0.5  -> 6
      altura < 1    -> 7
      else          -> 9
    }

    return if (esTransgenica) horasBase * 2 else horasBase
  }


  override fun daSemillas(): Boolean  {
    if (this.esTransgenica) {
      return false
    }

    return this.esFuerte() || (this.anioObtencionSemilla > 2007 && this.altura > 1)
  }
}


//--------------------------------------------------------------------------------------------------//
//----------------------------------COSAS-A-MEJORAR-EN-CLASE-PLANTA---------------------------------//
//--------------------------------------------------------------------------------------------------//
//                                                                                                  //
// Linea 3: Clase Planta: El enunciado dice que altura es una medida                                //
// en metros, y que *NUNCA* cambia. deberia ser val.                                                //
//                                                                                                  //
// Linea 6: función parcelaTieneComplicaciones debe estar en la clase parcela. (Desacoplamiento)    //
//                                                                                                  //
// Linea 10: Da semillas: para que una planta de nuevas semillas, la planta debe ser                //
// fuerte *O* debe cumplir una condicion extra. Ser fuerte, al ser una posibilidad siempre,         //
// deberia estar dentro de la funcion, luego se le agregaria la otra posibilidad con un supe).      //
//                                                                                                  //
// Linea 19: Soja transgenica: La soja transgenica a mi parecer deberia ser una clase nueva,        //
// El codigo seria mas robusto y legible, y al mismo tiempo, implementarlo no requiere mucho        //
// codigo, basta con hacer que herede de la soja e implemente esas 2 diferencias.                   //
//--------------------------------------------------------------------------------------------------//
//--------------------------------------------------------------------------------------------------//