//CLASS FOR MAINMENU THAT PLAYERS WILL FIRST SEE- can start new game or quit game
//package start;
import java.awt.*;//imports everything under awt
import java.awt.event.*;
import javax.swing.*; //imports everything under swing

import java.awt.BorderLayout.*;
import java.awt.Container.*; //can contain other awt objects

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.io.*;


@SuppressWarnings("serial") //surpresses the warning: [serial] serializable class MainMenu has no definition of serialVersionUID
public class Win extends JPanel implements ActionListener{
  JButton quitGame;
  JButton credits;
  Image img;
  JFrame frame;

  public Win(JFrame parent){ //what you want JFrame to look like should be in constructor
        frame = parent; //frame is the new window
        this.setLayout(new GridLayout(4,7));
        JPanel buttonPane = new JPanel(); //panel is the part in the new window

        quitGame = new JButton("Quit Game"); //button allows user to click it
        quitGame.addActionListener(this);

        credits = new JButton("Credits");
        credits.addActionListener(this); //this refers to quitGame


        JLabel background = new JLabel(); //jLabel used to display text or image icon
        background.setIcon(new ImageIcon("/Users/kalie_chang/Documents/Ending/youWin.jpeg"));
        Dimension size = background.getPreferredSize();
        background.setBounds(50,60, size.width, size.height);
        Container c = parent.getContentPane(); //contains the jframe and contentpane(layer used to hold image)
        c.add(background); //adds it to background


        buttonPane.add(quitGame); //adds the button to the panel on the frame
        buttonPane.add(credits);
        this.add(buttonPane); //adds panel to frame
      }

   public void actionPerformed(ActionEvent e){ //basically, if user clicks on quitGame, the system closes
     try{
      if (e.getSource() == quitGame){
        System.exit(0);
       }
    if (e.getSource() == credits) { //if user clicks on new game, it goes to the startGame file
      frame.dispose();
      Credits credits = new Credits(); }
      //startGame game = new startGame();
    }catch (FileNotFoundException x){

    }
}

   public void paintComponent(Graphics g){ //it paints the background image
      super.paintComponent(g);
      g.drawImage(img,0,0,this);
    }
  }
