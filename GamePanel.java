/* if button is clicked then it will go to the appropriate method*/
import javax.swing.JPanel; //extends JPanel
import javax.swing.JFrame; //for JFrame leave
import java.awt.*; //import everything under awt
import java.io.*; //for IOException

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Rectangle; //for rectangles for collision
import javax.swing.JOptionPane; //for showMessageDialog

//GamePanel controls all the objects within the first room
@SuppressWarnings("serial")
public class GamePanel extends JPanel implements Runnable{ //runnable is an interface whose instances can run as a thread
  public final int tileSize = 144; //144 x 144 tile size
  public final int maxScreenColumn = 12; //column size
  public final int maxScreenRow = 7; //row size
  public final int screenWidth = tileSize * maxScreenColumn;
  public final int screenHeight = tileSize * maxScreenRow;

  TileManager tiles = new TileManager(this);
  Thread gameThread; //use thread because we are running multiple things at the same time to process efficiency
  //it's like cramming 50 cars into one lane when you could put them into 5. It would make the travel time much faster
  Player player;
  DoorObject objDoor;
  DogObject dog;
  BedObject bed;
  LivingRoom living;
  TableObject table;
  BathObject bathtub;

  int fps = 60; //60 frames displayed per second refresh rate

//this initializes all the objects within the window
  public GamePanel()throws IOException{
    player = new Player(this);
    bed = new BedObject(this, "/Users/kalie_chang/Documents/Project/bed.png", player);
    dog = new DogObject(this, "/Users/kalie_chang/Documents/Project/dog.png", player);
    living = new LivingRoom(this, "/Users/kalie_chang/Documents/Project/livingRoom.png", player);
    table = new TableObject(this, "/Users/kalie_chang/Documents/Project/table.png", player);
    bathtub = new BathObject(this, "/Users/kalie_chang/Documents/Project/bathtub.png", player);
    objDoor = new DoorObject(this, "/Users/kalie_chang/Documents/Project/Door.png", player);

    addKeyListener(new KeyListener() { //this is for the player control movement, add it so it can recognize keys
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) { //keyReleased on Player.java
				player.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) { //keyPressed on Player.java
				player.keyPressed(e);
			}
		});
		setFocusable(true); //sets focus on Player so player can move
    setPreferredSize(new Dimension(screenWidth, screenHeight)); //set size of screen
    setDoubleBuffered(true); //redraws image using secondary buffer to prevent flickering when moving
  }

  public void startGameThread(){
    gameThread = new Thread(this); //passing GamePanel into Thread
    gameThread.start(); //begin thread execution
  }

  @Override
  public void run(){
    //in order to control refresh rate so its not doing it at insane speeds
    double drawInterval = 1000000000/fps; //divding billion seconds by 60 fps (this will be refresh rate per sec)
    double delta = 0;
    long lastTime = System.nanoTime(); //using nanoseconds in order to calculate the time because it's more precise, but we most likely could've done the same with ms
    long currentTime;
    //where we will update character position and draw new screen with updated information
    while (gameThread != null){
      currentTime = System.nanoTime();
      delta += (currentTime - lastTime) / drawInterval;
      lastTime = currentTime; //updating current time while game is running

      if(delta >= 1){
        update();
        repaint(); //game will keep updating and redrawing images
        delta--;
      }
    }
  }
//displaying message when objects collide
  public void getSleep(){ //for each object, this allows a messagedialogue window to pop up and show that you collided
    Thread sleepNow = new Thread(new Runnable(){ //creating new thread in order to determine when objects collide
      public void run(){
          JOptionPane.showMessageDialog(null, "You went to sleep and dreamt about fighting!");
        }
    });
  sleepNow.start();
}
//displaying message when objects collide
  public void petsDog(){
     Thread petPitbull = new Thread(new Runnable(){ //creating new thread in order to determine when objects collide
       public void run(){
           JOptionPane.showMessageDialog(null, "You pet your dog Sweetie! She loves you too!");
         }
     });
   petPitbull.start();
}
//displaying message when objects collide
  public void tvWatch(){
    Thread watchTV = new Thread(new Runnable(){ //creating new thread in order to determine when objects collide
      public void run(){
          JOptionPane.showMessageDialog(null, "You chilled and watched TV!");
        }
    });
  watchTV.start();
}
//displaying message when objects collide
public void getTable(){
   Thread eat = new Thread(new Runnable(){ //creating new thread in order to determine when objects collide
     public void run(){
         JOptionPane.showMessageDialog(null, "You ate breakfast! You feel physically and emotionally nourished.");
       }
   });
 eat.start();
}
//displaying message when objects collide
public void getBath(){
  Thread shower = new Thread(new Runnable(){ //creating new thread in order to determine when objects collide
    public void run(){
        JOptionPane.showMessageDialog(null, "You took a bath and feel refreshed!");
      }
  });
  shower.start();
 }
//this method is called when collision with door occurs which then pops up a new window that redirects to outside the house
  public void openDoor(){
    JFrame leave = new JFrame(); //declare JFrame as window
    leave.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    leave.setResizable(false); //the frame cannot be resizable, the size stays how it is
    leave.setTitle("Gettin' to a Street Fight!"); //title of the game at the top white bar
    leave.getContentPane().add(new LeaveHouse(leave));//getting main menu class
    leave.pack(); //sets the frame so that the content within it is at preferred size
    leave.setSize(400,200); //set size to this many pixels (width and height)
    leave.setVisible(true); //set visibility of JFrame to be true
 }

 //update method updates the position of the player and objects' rectangles for the collisions
  public void update(){
    player.move(); //using update method in player to update key inputs to move player
    bed.move(); //updates the position of the rectangle in the object bed for player to collide with it
    dog.move();
    living.move();
    table.move();
    bathtub.move();
    objDoor.move();
  }

//paints the image onto the screen
  public void paintComponent(Graphics g) { //part of JPanel, so we have to extend JPanel to get paint paintComponent
    super.paintComponent(g); //in order to clear screen every time image buffers
    Graphics2D g2d = (Graphics2D)g;

    tiles.draw(g2d); //call TileManager before Player.draw because it is like layers

    objDoor.draw(g2d, 1628, 400); //draws the object and its position
    dog.draw(g2d, 400, 500);
    living.draw(g2d, 800, 800);
    table.draw(g2d, 1550, 0);
    bed.draw(g2d, 0, 0);
    bathtub.draw(g2d, 0, 800);

    player.draw(g2d); // drawing character onto screen
  }
}
