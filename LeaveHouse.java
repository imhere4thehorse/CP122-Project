import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//Pulls up the window that prompts players to leave house
@SuppressWarnings("serial")
public class LeaveHouse extends JPanel implements ActionListener{
  JButton leave;
  JFrame frame;

//sets up the buttons on the panel on the window (frame)
  public LeaveHouse(JFrame second){
        frame = second;
        this.setLayout(new GridLayout(3,3)); //this refers to LeaveHouse
        JPanel buttonPane = new JPanel();

        leave = new JButton("Leave House");
        leave.addActionListener(this);
        buttonPane.add(leave);
        this.add(buttonPane);
      }

//this means if the reader presses the button, it will take them to the second room
   public void actionPerformed(ActionEvent e){
    if (e.getSource() == leave) {
      frame.dispose();
      Level2 part2 = new Level2();
    }
  }
}
