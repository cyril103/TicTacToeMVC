package view

import java.awt.GridLayout
import javax.swing.JPanel

class GridView extends JPanel:
  setLayout(new GridLayout(3,3))
  private val cases: Array[CaseView] = Array.tabulate(9)(i => new CaseView(i))
  cases.foreach{ b =>
    b.setActionCommand(b.getName)
    add(b)
  }
  def getCaseAtIndex(index : Int) : CaseView = cases(index)

