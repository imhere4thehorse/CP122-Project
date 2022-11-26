import javax.swing.JFrame;
import java.io.*;

//function similarly to startGame.java
public class Level2{
    JFrame leave = new JFrame();
    GamePanel2 gamePanel2;

    Level2(){
       try{
         gamePanel2 = new GamePanel2();
         leave.add(gamePanel2);

         leave.pack();

         leave.setLocationRelativeTo(null);
         leave.setVisible(true);

         gamePanel2.startGameThread();

       }catch (IOException e){
         System.out.println("Bad Start Game");
    }
  }
}
