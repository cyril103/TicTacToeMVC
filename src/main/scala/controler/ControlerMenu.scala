package controler

import model.TicTacToeModel

import java.awt.event.{ActionEvent, ActionListener}

class ControlerMenu (model: TicTacToeModel) extends ActionListener{

  override def actionPerformed(e: ActionEvent): Unit = {
    e.getActionCommand match {
      case "reset" =>
        model.init()
    }
  }
}
