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
    // var attaqueSolar = new Attaque(nomAttaque = "Arc", )
    //var attaqueWarlord =new Attaque(nomAttaque = "Epee warlord", attaque = 20)
    //var attaqueBarbares =new Attaque(nomAttaque = "Epee Barbares", attaque = 19)
    //var attaqueWorgs =new Attaque(nomAttaque = "Epee Worgs", attaque = 6)

    //Creation des sommets
    // on suppose que les vitesse sont mesurés par pied
    //Creation de: 1x Solar ,  1x Warlord, 4x Barbares Orcs et 9x Worgs Rider
    var tab = ArrayBuffer(
      new Creature(nom = "Solar", pointDeVie = 363, armure = 44, attaque = 31),
      new Creature(nom = "Warlord", pointDeVie = 141, armure = 27, attaque = 20),
      new Creature(nom = "Barbares Orcs", pointDeVie = 142, armure = 17, attaque = 19),
      new Creature(nom = "Barbares Orcs", pointDeVie = 142, armure = 17, attaque = 19),
      new Creature(nom = "Barbares Orcs", pointDeVie = 142, armure = 17, attaque = 19),
      new Creature(nom = "Barbares Orcs", pointDeVie = 142, armure = 17, attaque = 19),
      new Creature(nom = "Worgs Rider", pointDeVie = 13, armure = 18, attaque = 6),
      new Creature(nom = "Worgs Rider", pointDeVie = 13, armure = 18, attaque = 6),
      new Creature(nom = "Worgs Rider", pointDeVie = 13, armure = 18, attaque = 6),
      new Creature(nom = "Worgs Rider", pointDeVie = 13, armure = 18,attaque = 6),
      new Creature(nom = "Worgs Rider", pointDeVie = 13, armure = 18, attaque = 6),
      new Creature(nom = "Worgs Rider", pointDeVie = 13, armure = 18, attaque = 6),
      new Creature(nom = "Worgs Rider", pointDeVie = 13, armure = 18, attaque = 6),
      new Creature(nom = "Worgs Rider", pointDeVie = 13, armure = 18, attaque = 6)
    )

    // var verticesCreatures = sc.parallelize(tab)


    //Création des relations RDD with srcid, destid, distance

    //Defition du graphe initial
    //var graphCombat = Graph(verticesCreatures)
    //afficher le graphe de créature

    // graphCombat.edges.collect.foreach(println)




    //iterations de combat
    var a = 0
    var nb = 5
    // for loop execution with a range
    var continue = 0
    while (continue == 0) {
      for (a <- 1 to nb) {
        println("ITERATION >> " + a)
        println(tab)

        //Generer un nombre aléatoire pour choisir le défenseur
        val start1 = 1
        val end1 = tab.length
        val rnd1 = new scala.util.Random
        val r1 = start1 + rnd1.nextInt((end1 - start1) + 1)
        tab(0).attaquer(tab(r1))

        //Generer un nombre aléatoire pour choisir l'attaquant
        val start2 = 1
        val end2 = tab.length
        val rnd2 = new scala.util.Random
        val r2 = start2 + rnd2.nextInt((end2 - start2) + 1)
        tab(r2).attaquer(tab(0))

        if (tab(0).getPointDeVie() == 0) {
          println("Le Solar a perdu")
          continue = 1
        }

        if (tab.length == 1) {
          println("Le Solar a gagné")
          continue  = 1
        }

        var i = 0
        for (i <- 0 to 14) {
          if (tab(i).getPointDeVie() == 0) {
            tab.remove(i)
          }
        }


      }
    }


  }

}
