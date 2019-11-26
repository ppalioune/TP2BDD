import scala.collection.mutable.ArrayBuffer
import org.apache.spark.{SparkConf}
import org.apache.spark.SparkContext
import org.apache.spark.graphx.{Edge, EdgeContext, Graph, _}


object MainApp {
  def main(args: Array[String]): Unit = {
    //spark conf
    val conf = new SparkConf()
      .setAppName("Devoir 2")
      .setMaster("local[*]")
    val sc = new SparkContext(conf)
    sc.setLogLevel("ERROR")

    //Instancier les différentes attaques
    var attaqueSolar = new Attaque(nomAttaque = "Arc", attaque = List(31,26,21,16), distanceAttaque = 110 )
    var attaqueWarlord =new Attaque(nomAttaque = "Epee warlord", attaque = List(20,15,10,0), distanceAttaque = 10)
    var attaqueBarbares =new Attaque(nomAttaque = "Epee Barbares", attaque = List(6,0,0,0), distanceAttaque = 10)
    var attaqueWorgs =new Attaque(nomAttaque = "Epee Worgs", attaque = List(19,14,9,0), distanceAttaque = 10)

    //Creation des sommets
    // on suppose que les vitesse sont mesurés par pied
    //Creation de: 1x Solar ,  1x Warlord, 4x Barbares Orcs et 9x Worgs Rider
    var verticesCreatures = sc.makeRDD(ArrayBuffer(
      (1L, new Creature(nom = "Solar", pointDeVie = 363, armure = 44, typeAttaque = attaqueSolar, positionX = 0, speed = 0)),
      (2L, new Creature(nom = "Warlord", pointDeVie = 141, armure = 27, typeAttaque = attaqueWarlord, positionX =300, speed = 30)),
      (3L, new Creature(nom = "Barbares Orcs", pointDeVie = 142, armure = 17, typeAttaque = attaqueBarbares, positionX = 200,speed = 40)),
      (4L, new Creature(nom = "Barbares Orcs", pointDeVie = 142, armure = 17, typeAttaque = attaqueBarbares, positionX = 200,speed = 40)),
      (5L, new Creature(nom = "Barbares Orcs", pointDeVie = 142, armure = 17, typeAttaque = attaqueBarbares, positionX = 200,speed = 40)),
      (6L, new Creature(nom = "Barbares Orcs", pointDeVie = 142, armure = 17, typeAttaque = attaqueBarbares, positionX = 200,speed = 40)),
      (7L, new Creature(nom = "Worgs Rider", pointDeVie = 13, armure = 18, typeAttaque = attaqueWorgs, positionX = 150, speed = 20)),
      (8L, new Creature(nom = "Worgs Rider", pointDeVie = 13, armure = 18, typeAttaque = attaqueWorgs, positionX = 150, speed = 20)),
      (9L, new Creature(nom = "Worgs Rider", pointDeVie = 13, armure = 18, typeAttaque = attaqueWorgs, positionX = 150, speed = 20)),
      (10L, new Creature(nom = "Worgs Rider", pointDeVie = 13, armure = 18, typeAttaque = attaqueWorgs, positionX = 150, speed = 20)),
      (11L, new Creature(nom = "Worgs Rider", pointDeVie = 13, armure = 18, typeAttaque = attaqueWorgs, positionX = 150, speed = 20)),
      (12L, new Creature(nom = "Worgs Rider", pointDeVie = 13, armure = 18, typeAttaque = attaqueWorgs, positionX = 150, speed = 20)),
      (13L, new Creature(nom = "Worgs Rider", pointDeVie = 13, armure = 18, typeAttaque = attaqueWorgs, positionX = 150, speed = 20)),
      (14L, new Creature(nom = "Worgs Rider", pointDeVie = 13, armure = 18, typeAttaque = attaqueWorgs, positionX = 150, speed = 20))
    ))

    //Création des relations RDD with srcid, destid, distance
    var relationShips = sc.makeRDD(ArrayBuffer(
      Edge(1L,2L,300),
      Edge(1L,3L,200), Edge(1L,4L,200),Edge(1L,5L,200), Edge(1L,6L,200),
      Edge(1L,7L,150), Edge(1L,8L,150), Edge(1L,9L,150), Edge(1L,10L,150),
      Edge(1L,11L,150), Edge(1L,12L,150), Edge(1L,13L,150), Edge(1L,14L,150)
    ))

    //Defition du graphe initial
    var graphCombat = Graph(verticesCreatures,relationShips)
    //afficher le graphe de créature
    graphCombat.vertices.collect.foreach(println)
    graphCombat.edges.collect.foreach(println)
  }
}