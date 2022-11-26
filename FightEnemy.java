import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//this class is the window that pops up when you collide with the enemy in the second window
@SuppressWarnings("serial")
public class FightEnemy extends JPanel implements ActionListener{
  JButton fight;
  JFrame frame;

//setting the new frame that will appear upon the collision. It will have a button that
//prompts the player to fight the enemy.
  public FightEnemy(JFrame battle){
        frame = battle;
        this.setLayout(new GridLayout(3,3)); //this refers to LeaveHouse
        JPanel buttonPane = new JPanel();
        fight = new JButton("Fight Enemy");
        fight.addActionListener(this);
        buttonPane.add(fight);
        this.add(buttonPane);
      }
//if player clicks the fight button on the window then they will be redirected to the fight
//the fight is at the startEnemy class
   public void actionPerformed(ActionEvent e){
    if (e.getSource() == fight){
      frame.dispose();
      startEnemy battleEnemy = new startEnemy();
    }
    }
  }
