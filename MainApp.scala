import scala.collection.mutable.ArrayBuffer
import org.apache.spark.{SparkConf}
import org.apache.spark.SparkContext
import scala.util.Random
import org.apache.spark.graphx.{Edge, EdgeContext, Graph, _}


object MainApp {

  def main(args: Array[String]): Unit = {
    //spark conf
    val conf = new SparkConf()
      .setAppName("Devoir 2")
      .setMaster("local[*]")
    val sc = new SparkContext(conf)
    sc.setLogLevel("ERROR")

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

    println("***************La liste de tous les créatures au début du combat ***************************")
    println(tab)

    //iterations de combat
    var a = 0
    var nb = 100
    // for loop execution with a range
    var continue = 0
    while (continue == 0) {
      for (a <- 1 to nb) {
        println("ITERATION >> " + a)

        //FONCTION POUR QUE LE SOLAR FAIT ATTAQUE
        def solarAttaque(): Unit ={
          val start1 = 1
          val end1 = tab.length
          val rnd1 = new scala.util.Random
          val r1 = start1 + rnd1.nextInt((end1 - start1) + 1)

          println("# Le solar attaque un " +tab(r1).nom)
          tab(0).attaquer(tab(r1))
          //Si les pointDeVie de l'ennemie <= 0, la fin du jeu et on le supprime du tableau
          if (tab(r1).pointDeVie <= 0){
            println("# la créature "+tab(r1).nom + " est éliminé XXXXXXXXXXXX")
            tab.remove(r1)
          }
        }
        //Fonction pour choisir
        // qui attaque le solar
        def ennemiAttaque(): Unit ={
          val start2 = 1
          val end2 = tab.length
          val rnd2 = new scala.util.Random
          val r2 = start2 + rnd2.nextInt((end2 - start2) + 1)

          println("# L'ennemi " + tab(r2).nom + " attaque " + tab(0).nom)
          tab(r2).attaquer(tab(0))
          //Si pointDeVie solar <= 0, c'est la fin du combat et on supprime son indice
          if (tab(0).pointDeVie <= 0){
            println("# la créature "+tab(0).nom + " est éliminé XXXXXXXXXXXXX")
            println("# GAME OVER")
            tab.remove(0)
          }
        }
        //Choisir qui fait l'attaque
        val min = 1
        val max = 2
        val rnd2 = new scala.util.Random
        val r2 = min + rnd2.nextInt((max - min) + 1)

        //Si r2 = 1 le solar attaque et Si r2 =2 l'equipe adservaire fait l'attaque
        if (r2 == 1){
          println("# Le solar fait l'attaque")
          solarAttaque()
        }
        if (r2 == 2){
          println("# Un ennemi fait l'attaque")
          ennemiAttaque()
        }
        //QUITTER LE JEU SI LE POINT DE VIE DU SOLAR <= 0
        if (tab(0).pointDeVie <= 0) {
          println("Le Solar a perdu")
          continue = 1
        }

        //AFFICHER LA LISTE DES SURVIVANTS A CHAQUE ITERATION
        println(tab)
      }
    }
  }
}