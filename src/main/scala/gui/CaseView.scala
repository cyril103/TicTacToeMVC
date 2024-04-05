package gui

import model.{CaseModel, Publisher, Subscriber, TicTacToeModel}

import javax.swing.JButton

class CaseView(val index: Int) extends JButton with Subscriber{

  setText("")
  setName(index.toString)

  override def handler(publisher: Publisher): Unit = {
    publisher match {
      case m : CaseModel => setText(m.getSymbol)
      case _ =>
    }
  }
}
