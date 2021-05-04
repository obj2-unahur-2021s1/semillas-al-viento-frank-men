package ar.edu.unahur.obj2.semillasAlViento

class Parcela(val ancho: Int, val largo: Int, val horasSolPorDia: Int) {
  val plantas = mutableListOf<Planta>()
  var cantidadPlantas = 0 //podria pedirle size a plantas.

  fun superficie() = ancho * largo

  fun cantidadMaximaPlantas() =
    if (ancho > largo) ancho * largo / 5 else ancho * largo / 3 + largo

  fun plantar(planta: Planta) { //hacelo pero comentado
    if (cantidadPlantas == this.cantidadMaximaPlantas()) {
      println("Ya no hay lugar en esta parcela")
    } else if (horasSolPorDia > planta.horasDeSolQueTolera() + 2) {
      println("No se puede plantar esto acá, se va a quemar")
    } else {
      plantas.add(planta)
      cantidadPlantas += 1
    }
  }
}

class Agricultora(val parcelas: MutableList<Parcela>) {
  var ahorrosEnPesos = 20000 //innecesario

  // Suponemos que una parcela vale 5000 pesos
  fun comprarParcela(parcela: Parcela) { //innecesario
    if (ahorrosEnPesos >= 5000) {
      parcelas.add(parcela)
      ahorrosEnPesos -= 5000
    }
  }

  fun parcelasSemilleras() =
    parcelas.filter {
      parcela -> parcela.plantas.all {
        planta -> planta.daSemillas()
      }
    }

  fun plantarEstrategicamente(planta: Planta) { //se puede hacer una comprobacion anti-null en la propia funcion, evitando el !!
    val laElegida = parcelas.maxBy { it.cantidadMaximaPlantas() - it.cantidadPlantas }!!
    laElegida.plantas.add(planta)
  }
}

//------------------------------------------------------------------------------------------------
// COSAS A MEJORAR EN CLASE PARCELA:
//
// Linea 3: Parcela: Me parece que, para mantener la cohesion, el ancho y largo de
// parcela deberia ser tambien un float.
//
// Linea 5: cantidad plantas: Seria mas correcto que sea una funcion, y que esta
// le pida el tamaño a la coleccion plantas, teniendo mas robustez.
//
// Linea 10: cantidad maxima de plantas: Para empezar, en la primera parte de la funcion,
// no es necesario hacer ancho por largo, se puede llamar a this.superficie(), luego,
// estaria bueno separar el codigo en lineas ya que es muy poco legible tal y como esta. Redundancia
//
// Parcela: Tiene Complicaciones: el comando no esta implementado en la parcela, en cambio se opto
// por hacerlo en las plantas, generando un acoplamiento innecesario.
// Una mejor implementacion seria tener tieneComplicaciones() en la parcela, y que esta
// haga la comprobacion comparando su atributo horasDeSol con las horas de sol de la planta.
//
// Linea 11: Plantar:
//
// Linea 24: Agricultoras: Para empezar, seria mucho mas elegante que las agricultoras
// tengan su propio archivo dentro del package, y segundo, en el enunciado nos dice que
// no pueden ni vender ni comprar tierras, que una agricultora ya se configura con sus tierras,
// el enunciado nos da a entender que es una coleccion inmutable, por lo cual por simplicidad
// deberia ser una lista normal, no mutable.
//
// Linea 25: Variable no requerida. Simplicidad
//
// Linea 27: Simplicidad. No se debe agregar funcion si no es requerida haciendo el código mas simple
//
// Linea 34: Desacoplar - se puede agregar la funcion esSemillera() en Parcela,
// dejando un codigo mas legible y ordenado.
//
// Linea 41: Funcion poco consistente y confusa, No respeta la forma de plantar
//
//------------------------------------------------------------------------------------------------