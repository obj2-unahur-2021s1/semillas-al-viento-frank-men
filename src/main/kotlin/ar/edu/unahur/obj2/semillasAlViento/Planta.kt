package ar.edu.unahur.obj2.semillasAlViento

abstract class Planta(val anioObtencion: Int, val altura: Double) { //Altura deberia ser VAL, no var.
  fun esFuerte() = this.horasDeSolQueTolera() > 10

  abstract fun horasDeSolQueTolera(): Int
  open fun daSemillas(): Boolean = this.esFuerte()
}


class Menta(anioObtencion: Int, altura: Double) : Planta(anioObtencion, altura) {
  override fun horasDeSolQueTolera() = 6
  override fun daSemillas() = super.daSemillas() || altura > 0.4
}

class Soja(anioObtencion: Int, altura: Double, val esTransgenica: Boolean) : Planta(anioObtencion, altura) {
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
    return this.esFuerte() || (this.anioObtencion > 2007 && this.altura > 1)
  }
}


//--------------------------------------------------------------------------------------------------//
//----------------------------------COSAS-A-MEJORAR-EN-CLASE-PLANTA---------------------------------//
//--------------------------------------------------------------------------------------------------//
//                                                                                                  //
// Linea 3: Clase Planta: El enunciado dice que altura es una medida                                //
// en metros, y que *NUNCA* cambia. deberia ser val.          check                                 //
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