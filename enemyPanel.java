import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import java.io.*;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JOptionPane;
//main panel for the fight scene
@SuppressWarnings("serial")
public class enemyPanel extends JPanel implements Runnable { //runnable is an interface whose instances can run as a thread
//setting the dimensions for the screensize
  public final int tileSize = 144; //basing the screen size based off of "tiles"
  public final int maxScreenColumn = 16;
  public final int maxScreenRow = 12; //16 x 12 tiles
  public final int screenWidth = tileSize * maxScreenColumn;
  public final int screenHeight = tileSize * maxScreenRow;

  TileManagerFight tiles = new TileManagerFight(this);
  buttonHandler buttH;
  Thread gameThread; //in order to have the game keep refreshing while the thread is running
  PlayerFight playerFight;
  startEnemy start;

  JButton punchButton, kickButton, specButt;
  int fps = 60; //to update screen 60 times per second (60 frames per second)
  //constructor to initialize variables and set the screen of the fight
  public enemyPanel()throws IOException{
    punchButton = new JButton("PUNCH");
    kickButton = new JButton("KICK");
    specButt = new JButton("SPECIAL");
    buttH = new buttonHandler(punchButton, kickButton, specButt);
    playerFight = new PlayerFight(this, buttH);
    punchButton.addActionListener(buttH);
    kickButton.addActionListener(buttH);
    specButt.addActionListener(buttH);
    this.setPreferredSize(new Dimension(screenWidth, screenHeight));
    this.setDoubleBuffered(true);
    this.setFocusable(true); //so panel can be focused to receive keyinput
  }
//starting thread because we need to keep drawing images over and over
  public void startGameThread(){
    gameThread = new Thread(this); //passing GamePanel into Thread
    gameThread.start();//when start is called, it will go to run method which calls game thread
}

//run will call the game thread and
@Override
public void run(){
  //try catch is needed to implement Thread.sleep()
  try{
    //in order to control refresh rate so its not doing it at insane speeds
    double drawInterval = 1_000/fps; //divding billion seconds (nanoseconds) by 60 fps (this will be refresh rate per sec)
    double delta = 0;
    long lastTime = System.currentTimeMillis();
    long currentTime;
    //GAME LOOP
    //where we will update character position and draw new screen with updated information
    //as long as the thread is running, the program will keep updating and repainting images
    while (gameThread != null){
      currentTime = System.currentTimeMillis();
      delta += (currentTime - lastTime) / drawInterval;
      lastTime = currentTime;
//getting time in order to keep updating and repainting
      if(delta >= 1){
        update();
        repaint();
//in order to prevent player or enemy from infinitely doing a punch/kick/special attack, we put in thread.sleep so they attack only once per second even if the button is quickly clicked multiple times
        if (playerFight.combat.equals("punch") || playerFight.combat.equals("kick") || playerFight.combat.equals("special")||playerFight.combat1.equals("punch1") || playerFight.combat1.equals("kick1") || playerFight.combat1.equals("special1")){
          Thread.sleep(1000);
          }
        delta--;
      }

//if win status is met then a new win game window will pop up
if(playerFight.enemyHealth <= 0){
  gameThread = null;//game thread set as null when enemyhealth is <= 0  in order to determine that player won game
  System.out.println("game over");
  WinGame window = new WinGame();
  }

//if lose status is met then a new lose game window will pop up
if(playerFight.playerHealth <= 0){
    gameThread = null; //game thread set as null when playerhealth is <= 0  in order to determine that player lost game
    System.out.println("game over");
    LoseGame loseWindow = new LoseGame();
    }
  }

  }catch(Exception e){
    e.printStackTrace();
    }
  }
//this method calls update of playerFight which enables all the attacks of player and enemy
  public void update(){
    playerFight.update(); //using update method in player to update key inputs to move player
  }
/*this method draws the images of the background of the fight, the player and enemy,
and also gets rid of images when they are not being drawn (such as when player makes a move and the image is changed)*/
  public void paintComponent(Graphics g) { //part of JPanel, so we have to extend JPanel to get paint paintComponent
    super.paintComponent(g); //in order to clear screen every time image buffers
    Graphics2D g2d = (Graphics2D)g;
    tiles.draw(g2d); //call TileManager before Player.draw because it is like layers
    playerFight.draw(g2d); // drawing character onto screen
    g2d.dispose();
  }
}
