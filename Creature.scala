class Creature(val mom: String, val armure: String, var pointDeVie: Int, val typeAttaque: String,val positionX:Double,val positionY:Double) {
  //definition des accesseurs
  def getNom() : String = {
    return this.nom
  }
  def getArmure(): String = {
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
  def getPositionY():Double = {
    return this.positionY
  }

  //Methode pour chaque créature
  def attaquer(c:Creature) = {
  }
  def deplacer(c:Creature)={
  }

}
