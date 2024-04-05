package gui

 import model.TicTacToeModel

 import java.awt.GridLayout
 import java.awt.event.{ActionEvent, ActionListener}
 import javax.swing.{JOptionPane, JPanel}

class GridViewController(model : TicTacToeModel) extends JPanel with ActionListener  {
  setLayout(new GridLayout(3,3))

  private val cases: Array[CaseView] = Array.tabulate(9)(i => new CaseView(i))
  (0 to 8).foreach(i => model.getCase(i).subscribe(cases(i)))

  cases.foreach{b =>
    b.setActionCommand(b.getName)
    b.addActionListener(this)
    add(b)
  }

  private def handleGameEnd(result : String) : Unit = {
    val message = result match {
      case player@("X" | "O") => s"$player gagne"
      case "." => "match nul"
      case _ => throw  new IllegalArgumentException("must be X O or .")
    }
    JOptionPane.showMessageDialog(this,message,"resultat",JOptionPane.INFORMATION_MESSAGE)
    model.init()

  }

  override def actionPerformed(e: ActionEvent): Unit = {
    e.getActionCommand match {
      case n =>
        val canChangeTurn = model.checkAndPut(n.toInt)
        if (canChangeTurn){
          val status = model.getStatus
          status match {
            case result@("X"| "O" | ".") => handleGameEnd(result)
            case _ => model.changeTurn()
          }
        }
      }
    }
}
