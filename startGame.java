import javax.swing.JFrame;
import java.io.*; //for exception IOException
//CLASS FOR IMPLEMENTING THE GAME PANEL ONTO JFRAME
public class startGame{
    JFrame window = new JFrame();
    GamePanel gamePanel; //refers to the GamePanel file
    //adding gamepanel to a jframe
    startGame(){
       try{ //try catch to catch the IO Exception, defines code below to be tested for errors
         gamePanel = new GamePanel();
         window.add(gamePanel); //window refers to Menu window
         window.pack(); //sizes frame so contents are in preferred size
         window.setLocationRelativeTo(null);
         window.setVisible(true);
         gamePanel.startGameThread();

       }catch (IOException e){
         System.out.println("Bad Start Game"); //print this on terminal if there is errors

    }
  }
}
