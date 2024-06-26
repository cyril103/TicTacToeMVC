package controler

import model.{GameStatus, TicTacToeModel}
import model.GameStatus.*

import java.awt.event.{ActionEvent, ActionListener}
import javax.swing.JOptionPane

class GridController(model : TicTacToeModel) extends ActionListener:
  private def handleGameEnd(result : GameStatus) : Unit = 
    val message = result match 
      case X_WIN => "X gagne"
      case O_WIN => "O gagne"
      case TIE => "match nul"
      case _ => throw  new IllegalArgumentException("must be X O or .")
    
    JOptionPane.showMessageDialog(null,message,"resultat",JOptionPane.INFORMATION_MESSAGE)
    model.init()

  override def actionPerformed(e: ActionEvent): Unit = 
    val index = e.getActionCommand.toInt
    if model.boxIsEmpty(index) then
      model.put(index)
      model.getStatus match
      case result@(X_WIN | O_WIN | TIE) => handleGameEnd(result)
      case NOT_FINISH => model.changeTurn()
          