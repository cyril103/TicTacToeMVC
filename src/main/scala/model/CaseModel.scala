package model

class CaseModel (val index : Int) extends Publisher:
  private var symbol = ""
  
  def isEmpty: Boolean = symbol == ""
  def getSymbol: String = symbol
  def setSymbol(s:String): Unit =
    symbol = s
    publish()
