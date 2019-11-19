import scala.collection.mutable.ArrayBuffer
object MainApp {
  def main(args: Array[String]): Unit = {


    //Creation de: 1x Solar ,  1x Warlord, 4x Barbares Orcs et 9x Worgs Rider
    //Instancier les creatures dans un tableau
    var creatures = new ArrayBuffer[Creature]()
    //on suppose que les vitesse sont mesurés par pied
    var attaqueSolar = new Attaque(nomAttaque = "Arc", attaque = List(31,26,21,16), distanceAttaque = 110 )
    var Solar = new Creature(nom = "Solar", pointDeVie = 363, armure = 44, typeAttaque = " ", positionX = 0, speed = 0)
    creatures += Solar

    var attaqueWarlord =new Attaque(nomAttaque = "Epee warlord", attaque = List(20,15,10,0), distanceAttaque = 10)
    var Warlord = new Creature(nom = "Warlord", pointDeVie = 141, armure = 27, typeAttaque = " ", positionX =300, speed = 30)
    creatures += Warlord

    var attaqueBarbares =new Attaque(nomAttaque = "Epee Barbares", attaque = List(6,0,0,0), distanceAttaque = 10)
    for (i <- 1 to 4) {
      var BarbaresOrcs = new Creature(nom = "Barbares Orcs", pointDeVie = 142, armure = 17, typeAttaque = " ", positionX = 200,speed = 40)
      creatures += BarbaresOrcs
    }

    var attaqueWorgs =new Attaque(nomAttaque = "Epee Worgs", attaque = List(19,14,9,0), distanceAttaque = 10)
    for (i <- 1 to 9) {
      var WorgsRider = new Creature(nom = "Worgs Rider", pointDeVie = 13, armure = 18, typeAttaque = " ", positionX = 150, speed = 20)
      creatures += WorgsRider
    }

    //afficher les creatures
   creatures.foreach (println)

    //5 iterations de combat
    for (i <- 1 to 5) {
      println(s"############################ COMBAT $i###########################")
      // le solar ne se place pas, les autres creatures seulement se deplace
     Warlord.deplacer(Warlord)
      cre

    }
  }
}