package model

class TicTacToeModel extends Publisher :
  private var turn = 0

  private val players: Array[Player] = Array(HumanPlayer("X"),HumanPlayer("O"))
  private val grid: Array[CaseModel] = Array.tabulate(9)(i => new CaseModel(i))

  def currentPlayer: Player =
    players(turn)

  def init() : Unit =
    turn = 0
    grid.foreach(_.setSymbol(""))

  def getCase(index : Int): CaseModel = grid(index)

  def checkAndPut(numCase: Int): Boolean =
    if grid(numCase).getSymbol == ""  then 
      grid(numCase).setSymbol(currentPlayer.symbol)
      true
      else false

  def changeTurn() : Unit =
    turn = (turn+1)%2
    publish()

  def getStatus: String =    
    val isGridFull  = !grid.exists(c => c.getSymbol == "")
    val gridSymbol = grid.map(_.getSymbol).sliding(3,3).toArray
    val isSameSymbolHorizontal = gridSymbol.map(_.count(_ == currentPlayer.symbol)).contains(3)
    val isSameSymbolVertical = gridSymbol.transpose.map(_.count(_ == currentPlayer.symbol)).contains(3)
    val isSameSymbolDiagonal1 = currentPlayer.symbol == gridSymbol(0)(0) && currentPlayer.symbol == gridSymbol(1)(1) && currentPlayer.symbol == gridSymbol(2)(2)
    val isSameSymbolDiagonal2 = currentPlayer.symbol == gridSymbol(0)(2) && currentPlayer.symbol == gridSymbol(1)(1) && currentPlayer.symbol == gridSymbol(2)(0)
    val hasAWinner = isSameSymbolHorizontal || isSameSymbolVertical || isSameSymbolDiagonal1 || isSameSymbolDiagonal2
    if hasAWinner then currentPlayer.symbol
    else if !hasAWinner && isGridFull then  "."
    else "_"    
  end getStatus  
end TicTacToeModel

