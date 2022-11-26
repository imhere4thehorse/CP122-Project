import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//main player that is able to be controlled
public class Player{
  int Y = 0;
  private static final int WIDTH = 60;
  private static final int HEIGHT = 10;
  int x = 0;
  int xa = 300;
  int ya = 200;
  private GamePanel panel;
  BufferedImage character;
  String direction;
  int speed = 4;
//initialize panel and getting the player image
  public Player(GamePanel panel) {
		this.panel = panel;

    getPlayerImage();
	}
//setting how the playing is going to move when keys are keyPressed
//x and y variables are constantly changed in order to make it seem like player is moving
  public void move() {
    if (x + xa > 0 && x + xa < panel.getWidth() - WIDTH)
      x = x + xa;
      if (Y + ya > 0 && Y + ya < panel.getHeight() - HEIGHT)
        Y = Y + ya;
  }
  //if key isnt being pressed then player will stop moving
  public void keyReleased(KeyEvent e) {
    xa = 0;
    ya = 0;
  }
//if key is being pressed then this is how player will move
  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_W)
      ya = -4;
      ya -= speed;
    if (e.getKeyCode() == KeyEvent.VK_A)
      xa = -4;
      xa -= speed;
    if (e.getKeyCode() == KeyEvent.VK_S)
      ya = 1;
      ya += speed;
    if (e.getKeyCode() == KeyEvent.VK_D)
      xa = 1;
      xa += speed;
  }
//rectangle of player in order to determine collisions
  public Rectangle getBounds() {
    return new Rectangle(x, Y, WIDTH, HEIGHT);
  }
//getting player image
  public void getPlayerImage(){
    try{
      character = ImageIO.read(new File("/Users/kalie_chang/Documents/Project/character.png"));

    }catch(IOException e){
      e.printStackTrace();
    }
  }
//in order to make sure player cant go continuously off the screen
 public void update(){
    if (xa<0){
      xa = 0;
    }
    if (ya < 0){
      ya = 0;
    }
    if (xa > 1628){
      xa = 1628;
    }
    if (ya > 800){
      ya = 800;
    }
}
//drawing player image onto screen
  public void draw(Graphics2D g2){
    BufferedImage image = null;
    image = character;
    g2.drawImage(image, x, Y, panel.tileSize, panel.tileSize, null);
    }
  }
