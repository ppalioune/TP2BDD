class Attaque(val nomAttaque: String, val attaque: List[Int], val distanceAttaque:Double) extends Serializable {
  //definition des accesseurs
  def getNomAttaque(): String = {
    return this.nomAttaque
  }

  def getAttaque(): List[Int] = {
    return this.attaque
  }

  //Methode pour chaque créature
  def degats():List[Attaque]  = {
    return List(this)
  }
}