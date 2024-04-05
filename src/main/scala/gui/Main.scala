package gui

import javax.swing.SwingUtilities

object Main {

  def main(args: Array[String]): Unit = {

    SwingUtilities.invokeLater(new MainWindow)

  }

}
