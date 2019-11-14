class Attaque(val nomAttaque: String, val attaque: List[Int], val positionX:Double,val positionY:Double){
  //definition des accesseurs
  def getNomAttaque() : String = {
    return this.nomAttaque
  }
  def getAttaque(): List[Int] = {
    return  this.attaque
  }
  def getPositionX():Double = {
    return this.positionX
  }
  def getPositionY():Double = {
    return this.positionY
  }

  //Methode pour chaque créature
  def degats(a:Attaque) = {
  }







}
