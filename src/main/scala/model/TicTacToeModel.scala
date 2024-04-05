package model

class TicTacToeModel extends Publisher {
  private var turn = 0

  private val players: Array[String] = Array("X","O")
  private val grid: Array[CaseModel] = Array.tabulate(9)(i => new CaseModel(i))

  def currentPlayer: String = {
    players(turn)
  }

  def init() : Unit = {
    turn = 0
    grid.foreach(_.setSymbol(""))
  }

  def getCase(index : Int): CaseModel = grid(index)

  def checkAndPut(numCase: Int): Boolean = {
    if (grid(numCase).getSymbol == "") {
      grid(numCase).setSymbol(currentPlayer)
      true
    } else false
  }

  def changeTurn() : Unit = {
    turn = (turn+1)%2
    publish()
  }
  private def isGridFull  = !grid.exists(c => c.getSymbol == "")

  def getStatus: String ={

    val str = grid.map(_.getSymbol).sliding(3,3).toArray
    val hor = str.map(_.count(_ == currentPlayer)).contains(3)
    val ver = str.transpose.map(_.count(_ == currentPlayer)).contains(3)
    val diag1 = currentPlayer == str(0)(0) && currentPlayer == str(1)(1) && currentPlayer == str(2)(2)
    val diag2 = currentPlayer == str(0)(2) && currentPlayer == str(1)(1) && currentPlayer == str(2)(0)

    (hor || ver || diag1 || diag2 ,isGridFull, currentPlayer) match {
      case (true, _ , curr) => curr
      case (false, true, _) => "."
      case _ => "_"
    }

  }





}
