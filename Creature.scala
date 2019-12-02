class Creature(val nom: String, var armure: Int, var pointDeVie: Int, val typeAttaque: Attaque, var speed:Int) extends Serializable {
  //definition des liens entre les creations
  var adjlist = new Array[Int](13)
  //definition des accesseurs
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
  override def toString: String = s"$nom  a $armure armure, $pointDeVie point de vie, a une vitesse de $speed"
}
