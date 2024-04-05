package gui

import model.TicTacToeModel

import java.awt.{BorderLayout, Dimension}
import javax.swing.{JButton, JFrame, WindowConstants}

class MainWindow extends Runnable{

  override def run(): Unit = {
    val model = new TicTacToeModel
    val gridViewController = new GridViewController(model)
    val controllerMenu = new ControlerMenu(model)
    val resetButton = new JButton("Reset")
    val currentPlayerView = new CurrentPlayerView(model.currentPlayer)
    model.subscribe(currentPlayerView)
    resetButton.setActionCommand("reset")
    resetButton.addActionListener(controllerMenu)
    val table = new JFrame("Morpion")
    table.getContentPane.add(gridViewController)
    table.getContentPane.add(resetButton,BorderLayout.SOUTH)
    table.getContentPane.add(currentPlayerView,BorderLayout.NORTH)
    table.setPreferredSize(new Dimension(500,500))
    table.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)
    table.pack()
    table.setVisible(true)
  }
}
