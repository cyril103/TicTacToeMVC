package model

enum Player:
  def symbol : String
  case Human(symbol: String)
  case Bot(symbol: String)


