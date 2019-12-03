class Creature(val nom: String, var armure: Int, var pointDeVie: Int,val attaque: Int) extends Serializable {
  //definition des accesseurs

  override def toString: String = s"$nom  a $armure armure, $pointDeVie point de vie "

  def getNom() : String = {
    return this.nom
  }
  def getArmure(): Int = {
    return  this.armure
  }
  def getPointDeVie(): Int = {
    return this.pointDeVie
  }
  def getAttaque(): Int = {
    return this.attaque
  }


  def attaquer( c2:Creature) = {
    //recupere la valeur du dommage
    var dmgAttaque = this.getAttaque()

    //recupere l'armure de l'adversaire
    val armureCreature = c2.getArmure()

    var start1 = 0
    var end1 = 0
    val rnd1 = new scala.util.Random
    var r1 =0

    if (this.getNom() == "Solar") {
      start1 = 2
      end1 = 6
      var r1 = start1 + rnd1.nextInt((end1 - start1) + 1)
      r1 = r1 + 14
    }

    if (this.getNom()== "Warlord") {
      start1 = 1
      end1 = 8
      var r1 = start1 + rnd1.nextInt((end1 - start1) + 1)
      r1 = r1 + 10
    }

    if (this.getNom()== "Barbares Orcs") {
      start1 = 1
      end1 = 8
      var r1 = start1 + rnd1.nextInt((end1 - start1) + 1)
      r1 = r1 + 10
    }

    if (this.getNom() == "Worgs Rider") {
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




  //Methode pour attaquer une créature
  /*
    //Methode pour déplacer la créature si distance minimal pas atteint
   // def deplacer(c1:Creature, c2:Creature)={
      //Calcule de la distance entre les deux créatures
      var différence = c2.positionX - c1.positionX
      //La distance minimal pour toucher un adversaire
      var distanceMin = 180 // A voir
      if (différence - c2.speed <= distanceMin){
        println("Combat entre "+ c1 + " l'adversaire"+ c2)
        //nouvelle position de c2
        c2.positionX -=  c2.speed
      }else{
        //Avancer la créature 2 jusqu'a atteindre la distance minimal
        c2.positionX = c2.positionX -(différence-distanceMin) // ex: dif = 20 MIN 18
        println(c2.getNom()+" se se déplace vers "+c1.getNom())
        println(c2.getNom()+ "se trouve a une distance de "+ c2.positionX)
      }
    }*/
}