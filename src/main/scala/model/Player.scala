package model

sealed trait Player:
  def symbol : String

case class  HumanPlayer(symbol : String) extends Player
case class  BotPlayer(symbol: String) extends Player
