package ar.edu.unahur.obj2.semillasAlViento

class Parcela(val ancho: Int, val largo: Int, val horasSolPorDia: Int) {
  val plantas = mutableListOf<Planta>()

  fun cantidadPlantas() = plantas.size

  fun superficie() = ancho * largo

  fun cantidadMaximaPlantas() =
    if (ancho > largo) this.superficie() / 5 else this.superficie() / 3 + largo

  fun plantar(planta: Planta) {
    check((this.cantidadPlantas() <= this.cantidadMaximaPlantas())) {
      "Ya no hay lugar en esta parcela"
    }
    check(horasSolPorDia > planta.horasDeSolQueTolera() + 2) {
      "No se puede plantar esto acá, se va a quemar"
    }
    plantas.add(planta)
  }
}

class Agricultora(val parcelas: MutableList<Parcela>) {


  fun parcelasSemilleras() =
    parcelas.filter {
      parcela -> parcela.plantas.all {
        planta -> planta.daSemillas()
      }
    }

  fun plantarEstrategicamente(planta: Planta) { //se puede manejar de otras formas el !!.
    val laElegida = parcelas.maxByOrNull { it.cantidadMaximaPlantas() - it.cantidadPlantas() }!!
    laElegida.plantas.add(planta) //no se cumple ninguna condicion de plantar().
}
}


//--------------------------------------------------------------------------------------------------//
//---------------------------------COSAS-A-MEJORAR-EN-CLASE-PARCELA---------------------------------//
//--------------------------------------------------------------------------------------------------//
//                                                                                                  //
// Linea 3: Parcela: Me parece que, para mantener la cohesion, el ancho y largo de                  //
// parcela deberia ser tambien un float.                                                            //
//                                                                                                  //
// Linea 5: cantidad plantas: Seria mas correcto que sea una funcion, y que esta                    //
// le pida el tamaño a la coleccion plantas, dando al codigo mas coherencia.                        //
//                                                                                                  //
// Linea 10: cantidad maxima de plantas: Para empezar, en la primera parte de la funcion,           //
// no es necesario hacer ancho por largo, se puede llamar a this.superficie(), lo cual              //
// reduciria la redundancia. Luego, estaria bueno separar el codigo en lineas                       //
// ya que es muy poco legible tal y como esta.                                                      //
//                                                                                                  //
// Parcela: Tiene Complicaciones: el comando no esta implementado en la parcela, en cambio se       //
// opto por hacerlo en las plantas, generando un acoplamiento innecesario.                          //
// Una mejor implementacion seria tener tieneComplicaciones() en la parcela, y que esta             //
// haga la comprobacion comparando su atributo horasDeSol con las horas de sol de la planta.        //
//                                                                                                  //
// Linea 11: Plantar: En el enunciado se esta pidiendo que la funcion tire un error, en cambio,     //
// la implementacion tira un print. Segundo, no es necesario tener un if elseif, Se podria          //
// tener un if condicion1 OR condicion2 y ya, codigo mucho mas sencillo y legible.                  //
//                                                                                                  //
// Linea 24: Agricultoras: Para empezar, seria mucho mas elegante que las agricultoras              //
// tengan su propio archivo dentro del package, y segundo, en el enunciado nos dice que             //
// no pueden ni vender ni comprar tierras, que una agricultora ya se configura con sus tierras,     //
// el enunciado nos da a entender que es una coleccion inmutable, por lo cual por simplicidad       //
// deberia ser una lista normal, no mutable.                                                        //
//                                                                                                  //
// Linea 25: Variable no requerida. (Simplicidad)                                                   //
//                                                                                                  //
// Linea 27: No se debe agregar funcionalidad si no es requerida, dejando el código mas simple.     //
//                                                                                                  //
// Linea 34: Desacoplar - se puede agregar la funcion esSemillera() en Parcela,                     //
// dejando un codigo mas legible y ordenado.                                                        //
//                                                                                                  //
// Linea 42: Plantar Estrategicamente: Lo primero es que la funcion, al agregar la planta a la      //
// parcela lo hace de forma directa, sin llamar a la propia funcion Plantar(), y segundo,           //
// hay mejores formas de manejar una non-null asserted call. Por ejemplo, se podria realizar        //
// un if comprobando que la lista parcelas no este vacia, o, se podria especificar que              //
// val laElegida es de tipo (Parcela?).                                                             //
//                                                                                                  //
//--------------------------------------------------------------------------------------------------//
//--------------------------------------------------------------------------------------------------//