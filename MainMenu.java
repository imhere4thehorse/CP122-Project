//CLASS FOR MAINMENU THAT PLAYERS WILL FIRST SEE- can start new game or quit game
import java.awt.*;//imports everything under awt
import java.awt.event.*;
import javax.swing.*; //imports everything under swing

import java.awt.BorderLayout.*;
import java.awt.Container.*; //can contain other awt objects

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
//CLASS FOR MAIN MENU WHICH LEADS TO THE GAME

@SuppressWarnings("serial") //surpresses the warning: [serial] serializable class MainMenu has no definition of serialVersionUID
public class MainMenu extends JPanel implements ActionListener{
  JButton newGame;
  JButton quitGame;
  Image img;
  JFrame frame;
//setting the picture and buttons that will show up on the mainmenu
  public MainMenu(JFrame parent){ //what you want JFrame to look like should be in constructor
        frame = parent; //frame is the new window
        this.setLayout(new GridLayout(4,7));
        JPanel buttonPane = new JPanel(); //panel is the part in the new window

        newGame = new JButton("New Game"); //button allows user to click it
        newGame.addActionListener(this);

        quitGame = new JButton("Quit Game");
        quitGame.addActionListener(this); //this refers to quitGame


        JLabel background = new JLabel(); //jLabel used to display text or image icon
        background.setIcon(new ImageIcon("/Users/kalie_chang/Documents/Project/title.png"));
        Dimension size = background.getPreferredSize();
        background.setBounds(50,60, size.width, size.height);
        Container c = parent.getContentPane(); //contains the jframe and contentpane(layer used to hold image)
        c.add(background); //adds it to background


        buttonPane.add(newGame); //adds the button to the panel on the frame
        buttonPane.add(quitGame);
        this.add(buttonPane); //adds panel to frame
      }
//if new game is clicked then startGame is created which is a new jframe that has the game panel on it
   public void actionPerformed(ActionEvent e){ //basically, if user clicks on quitGame, the system closes
     if (e.getSource() == quitGame){
      System.exit(0);
     }
    if (e.getSource() == newGame) { //if user clicks on new game, it goes to the startGame file
      frame.dispose();
      startGame game = new startGame();
    }
  }
//drawing the image onto the main menu
   public void paintComponent(Graphics g){ //it paints the background image
      super.paintComponent(g);
      g.drawImage(img,0,0,this);
    }
  }
