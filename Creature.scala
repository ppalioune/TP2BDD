class Creature(val nom: String, var armure: Int, var pointDeVie: Int, val typeAttaque: Attaque,var positionX:Double, var speed:Int) extends Serializable {
  //definition des accesseurs

  override def toString: String = s"$nom  a $armure armure, $pointDeVie point de vie   , est à une position de $positionX, a une vitesse de $speed"

  def getNom() : String = {
    return this.nom
  }
  def getArmure(): Int = {
    return  this.armure
  }
  def getPointDeVie(): Int = {
    return this.pointDeVie
  }
  def GettypeAttaque(): Attaque ={
    return this.typeAttaque
  }
  def getPositionX():Double = {
    return this.positionX
  }

  //Methode pour attaquer une créature
  def attaquer(c:Creature) = {
    //recuper la valeur du domage
    val dmgAttaque = this.typeAttaque.degats();
    //recupere l'armure de l'adversaire
    val armureCreature = c.getArmure()
    //Si la valeur de l'attaque est supérieur à l'armure de l'adversaire
    //Il est bléssé
    /*
    if (dmgAttaque > armureCreature){
      println("Votre adversaire est touché !!!!!")
      //On change le point de vit de l'adversaire
      c.pointDeVie = pointDeVie -  int (dmgAttaque) //A revoir
    }else{
      println("Votre adversaire n'est pas touché !!!!!")
    }*/


  }
  //Methode pour déplacer la créature si distance minimal pas atteint
  def deplacer(c1:Creature, c2:Creature)={
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
  }
}
