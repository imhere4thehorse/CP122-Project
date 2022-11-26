import javax.swing.JPanel; //extends JPanel
import javax.swing.JFrame; //for JFrame leave
import java.awt.*; //import everything under awt
import java.io.*; //for IOException

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Rectangle; //for rectangles for collision
import javax.swing.JOptionPane; //for showMessageDialog

//GamePanel2 runs the objects and tiles in the second room
@SuppressWarnings("serial")
public class GamePanel2 extends JPanel implements Runnable{ //runnable is an interface whose instances can run as a thread
  public final int tileSize = 144;
  public final int maxScreenColumn = 16;
  public final int maxScreenRow = 12; //16 x 12 tiles
  public final int screenWidth = tileSize * maxScreenColumn;
  public final int screenHeight = tileSize * maxScreenRow;

  Tiles2 tiles = new Tiles2(this);
  Thread gameThread; //use thread because we are running multiple things at the same time to process efficiency
  //it's like cramming 50 cars into one lane when you could put them into 5. It would make the travel time much faster
  Player2 player2;
  Supermarket shop;
  Fire fire;
  Fire2 fires;
  Restaurant eating;
  Girl chunLi;
  Guy ken;
  Enemy akuma;

  int fps = 60;

  //this initializes all the objects within the window
  public GamePanel2()throws IOException{
    player2 = new Player2(this);
    shop = new Supermarket(this, "/Users/kalie_chang/Documents/Project/supermarket.png", player2);
    fire = new Fire(this, "/Users/kalie_chang/Documents/Project/fire.png", player2);
    fires = new Fire2(this, "/Users/kalie_chang/Documents/Project/fire.png", player2);
    eating = new Restaurant(this, "/Users/kalie_chang/Documents/Project/restaurant.png", player2);
    chunLi = new Girl(this, "/Users/kalie_chang/Documents/Project/chunLi.png", player2);
    ken = new Guy(this, "/Users/kalie_chang/Documents/Project/Ken.png", player2);
    akuma = new Enemy(this, "/Users/kalie_chang/Documents/Project/Enemy.png", player2);

//this is for implementing key inputs and allowing the player to control the movement of the main character
    addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				player2.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				player2.keyPressed(e);
			}
		});
		setFocusable(true);
    setPreferredSize(new Dimension(screenWidth, screenHeight));
    setDoubleBuffered(true);
  }
//thread will be created because we will be drawing images over and over
  public void startGameThread(){
    gameThread = new Thread(this); //passing GamePanel into Thread
    gameThread.start();
  }

  @Override
  public void run(){
    //in order to control refresh rate so its not doing it at insane speeds
    double drawInterval = 1000000000/fps; //divding billion seconds by 60 fps (this will be refresh rate per sec)
    double delta = 0;
    long lastTime = System.nanoTime();
    long currentTime;
    //where we will update character position and draw new screen with updated information
    while (gameThread != null){
      currentTime = System.nanoTime();
      delta += (currentTime - lastTime) / drawInterval;
      lastTime = currentTime;

      if(delta >= 1){
        update();
        repaint();
        delta--;
      }
    }
  }
  //displaying message when objects collide
  public void SuperMarkets(){
    Thread shopping = new Thread(new Runnable(){
      public void run(){
          JOptionPane.showMessageDialog(null, "You ignored the cries of the people and got groceries.");
      }
  });
shopping.start();
}
public void chaos(){
  Thread burning = new Thread(new Runnable(){
    public void run(){
        JOptionPane.showMessageDialog(null, "Ouch! That hurts! Go beat up the guy that set it!");
    }
});
burning.start();
}
public void getChaos(){
  Thread burnings = new Thread(new Runnable(){
    public void run(){
        JOptionPane.showMessageDialog(null, "Ouch! That hurts! Go beat up the guy that set it!");
    }
});
burnings.start();
}

public void fineDining(){
  Thread eatMe = new Thread(new Runnable(){
    public void run(){
        JOptionPane.showMessageDialog(null, "Did you really go and eat fillet mignon at a 5 star restaurant while people are dying?");
    }
});
eatMe.start();
}

public void Women(){
  Thread ladies = new Thread(new Runnable(){
    public void run(){
        JOptionPane.showMessageDialog(null, "Hey! We can't fight him on our own! You have to help us!");
    }
});
ladies.start();
}

public void Men(){
  Thread boy = new Thread(new Runnable(){
    public void run(){
        JOptionPane.showMessageDialog(null, "Beat him up! You got this! We have to save town!");
    }
});
boy.start();
}
public void Akuma(){
  JFrame fight = new JFrame();
  fight.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  fight.setResizable(false);
  fight.setTitle("Gettin' to a Street Fight!");
  fight.getContentPane().add(new FightEnemy(fight));
  fight.pack();
  fight.setSize(400,200);
  fight.setVisible(true);
}
  public void update(){
    player2.move(); //using update method in player to update key inputs to move player
    shop.move();
    fire.move();
    fires.move();
    eating.move();
    chunLi.move();
    ken.move();
    akuma.move();
  }

  public void paintComponent(Graphics g) { //part of JPanel, so we have to extend JPanel to get paint paintComponent
    super.paintComponent(g); //in order to clear screen every time image buffers
    Graphics2D g2d = (Graphics2D)g;

    tiles.draw(g2d); //call TileManager before Player.draw because it is like layers
    shop.draw(g2d, 0, 0);
    fire.draw(g2d, 200, 0);
    fires.draw(g2d, 500, 800);
    eating.draw(g2d, 800, 0);
    chunLi.draw(g2d, 0, 400);
    ken.draw(g2d, 700, 800);
    akuma.draw(g2d, 1500, 400);

    player2.draw(g2d); // drawing character onto screen
    g2d.dispose();
  }
}

//same structure as GamePanel
