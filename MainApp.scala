import scala.collection.mutable.ArrayBuffer
object MainApp {
  def main(args: Array[String]): Unit = {
    println("Hello  World")

    //Instancier les creatures dans un tableau
    var creatures = new ArrayBuffer[Creature]()
    //Creation de: 1x Solar ,  1x Warlord, 4x Barbares Orcs et 9x Worgs Rider
    //Quoi mettre pour les attaques???
    var Solar = new Creature(nom = "Solar", pointDeVie = 363, armure = 44, typeAttaque = " ", positionX = 100, positionY = 100)
    creatures += Solar

    var Warlord = new Creature(nom = "Warlord", pointDeVie = 141, armure = 27, typeAttaque = " ", positionX = 100, positionY =100)
    creatures += Warlord

    for (i <- 1 to 4) {
      creatures += new Creature(nom = "Barbares Orcs", pointDeVie = 142, armure = 17, typeAttaque = " ", positionX = 100, positionY = 100)
    }
    for (i <- 1 to 9) {
      creatures += new Creature(nom = "Worgs Rider", pointDeVie = 13, armure = 18, typeAttaque = " ", positionX = 100, positionY = 100)
    }
   println(creatures(1))

  }
  }