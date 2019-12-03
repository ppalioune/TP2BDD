class Attaque(val nomAttaque: String, val attaque: Int) extends Serializable {
  //definition des accesseurs
  def getNomAttaque(): String = {
    return this.nomAttaque
  }

  def getAttaque(): Int = {
    return this.attaque
  }

  //Methode pour chaque créature
  //def degats():List[Attaque]  = {
    //return List(this)
  //}

  def attaquer(c1:Creature, c2:Creature) = {
    //recupere la valeur du dommage
    var dmgAttaque = this.getAttaque();

    //recupere l'armure de l'adversaire
    val armureCreature = c2.getArmure()

    var start1 = 0
    var end1 = 0
    val rnd1 = new scala.util.Random
    var r1 =0

    if (c1 == "Solar") {
      start1 = 2
      end1 = 6
      var r1 = start1 + rnd1.nextInt((end1 - start1) + 1)
      r1 = r1 + 14
    }

    if (c1 == "Warlord") {
      start1 = 1
      end1 = 8
      var r1 = start1 + rnd1.nextInt((end1 - start1) + 1)
      r1 = r1 + 10
    }

    if (c1 == "Barbares Orcs") {
      start1 = 1
      end1 = 8
      var r1 = start1 + rnd1.nextInt((end1 - start1) + 1)
      r1 = r1 + 10
    }

    if (c1 == "Worgs Rider") {
      start1 = 1
      end1 = 8
      var r1 = start1 + rnd1.nextInt((end1 - start1) + 1)
      r1 = r1 + 2
    }

    dmgAttaque = dmgAttaque + r1

    //Si la valeur de l'attaque est supérieur à l'armure de l'adversaire
    //Il est bléssé
    if (dmgAttaque > armureCreature){
      println("Votre adversaire est touché !!!!!")
      //On change le point de vit de l'adversaire
      c2.pointDeVie = c2.pointDeVie -  dmgAttaque //A revoir
    }else{
      println("Votre adversaire n'est pas touché !!!!!")
    }
  }


}