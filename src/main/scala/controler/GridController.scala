package controler

import model.TicTacToeModel

import java.awt.event.{ActionEvent, ActionListener}
import javax.swing.JOptionPane

class GridController(model : TicTacToeModel) extends ActionListener:
  private def handleGameEnd(result : String) : Unit = 
    val message = result match 
      case player@("X" | "O") => s"$player gagne"
      case "." => "match nul"
      case _ => throw  new IllegalArgumentException("must be X O or .")
    
    JOptionPane.showMessageDialog(null,message,"resultat",JOptionPane.INFORMATION_MESSAGE)
    model.init()

  override def actionPerformed(e: ActionEvent): Unit = 
    e.getActionCommand match 
      case n =>
        val canChangeTurn = model.checkAndPut(n.toInt)
        if canChangeTurn then 
          val status = model.getStatus
          status match 
            case result@("X"| "O" | ".") => handleGameEnd(result)
            case _ => model.changeTurn()
          