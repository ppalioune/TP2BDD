class Creature(val nom: String, var armure: Int, var pointDeVie: Int, val typeAttaque: String,var positionX:Double, var speed:Int) {
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
  def GettypeAttaque(): String ={
    return this.typeAttaque
  }
  def getPositionX():Double = {
    return this.positionX
  }

  //Methode pour chaque créature
  def attaquer(c:Creature) = {
  }
  def deplacer(c:Creature)={
    positionX = positionX - speed
  }

}
