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
    var attaqueSolar = new Attaque(nomAttaque = "Arc", attaque = 31)
    var attaqueWarlord =new Attaque(nomAttaque = "Epee warlord", attaque = 20)
    var attaqueBarbares =new Attaque(nomAttaque = "Epee Barbares", attaque = 19)
    var attaqueWorgs =new Attaque(nomAttaque = "Epee Worgs", attaque = 6)

    //Creation des sommets
    // on suppose que les vitesse sont mesurés par pied
    //Creation de: 1x Solar ,  1x Warlord, 4x Barbares Orcs et 9x Worgs Rider
    var verticesCreatures = sc.makeRDD(ArrayBuffer(
      (1L, new Creature(nom = "Solar", pointDeVie = 363, armure = 44, typeAttaque = attaqueSolar)),
      (2L, new Creature(nom = "Warlord", pointDeVie = 141, armure = 27, typeAttaque = attaqueWarlord)),
      (3L, new Creature(nom = "Barbares Orcs", pointDeVie = 142, armure = 17, typeAttaque = attaqueBarbares)),
      (4L, new Creature(nom = "Barbares Orcs", pointDeVie = 142, armure = 17, typeAttaque = attaqueBarbares)),
      (5L, new Creature(nom = "Barbares Orcs", pointDeVie = 142, armure = 17, typeAttaque = attaqueBarbares)),
      (6L, new Creature(nom = "Barbares Orcs", pointDeVie = 142, armure = 17, typeAttaque = attaqueBarbares)),
      (7L, new Creature(nom = "Worgs Rider", pointDeVie = 13, armure = 18, typeAttaque = attaqueWorgs)),
      (8L, new Creature(nom = "Worgs Rider", pointDeVie = 13, armure = 18, typeAttaque = attaqueWorgs)),
      (9L, new Creature(nom = "Worgs Rider", pointDeVie = 13, armure = 18, typeAttaque = attaqueWorgs)),
      (10L, new Creature(nom = "Worgs Rider", pointDeVie = 13, armure = 18, typeAttaque = attaqueWorgs)),
      (11L, new Creature(nom = "Worgs Rider", pointDeVie = 13, armure = 18, typeAttaque = attaqueWorgs)),
      (12L, new Creature(nom = "Worgs Rider", pointDeVie = 13, armure = 18, typeAttaque = attaqueWorgs)),
      (13L, new Creature(nom = "Worgs Rider", pointDeVie = 13, armure = 18, typeAttaque = attaqueWorgs)),
      (14L, new Creature(nom = "Worgs Rider", pointDeVie = 13, armure = 18, typeAttaque = attaqueWorgs))
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