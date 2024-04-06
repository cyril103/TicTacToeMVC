package view

import model.{Publisher, Subscriber, TicTacToeModel}

import javax.swing.JLabel

class CurrentPlayerView(currentPlayer : String) extends JLabel(currentPlayer) with Subscriber {

  override def handler(publisher: Publisher): Unit = {
    publisher match {
      case model : TicTacToeModel => setText(model.currentPlayer)
    }
  }
}