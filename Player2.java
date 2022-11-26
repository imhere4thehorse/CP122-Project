import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//functions the same as Player.java, but Player2.java is meant for the second room
//and corresponds with GamePanel2
public class Player2{
  int Y = 0;
  private static final int WIDTH = 60;
  private static final int HEIGHT = 10;
  int x = 0;
  int xa = 300; //x axis
  int ya = 200; //y axis
  private GamePanel2 panel2;
  BufferedImage character2;
  String direction;
  int speed = 4;

  public Player2(GamePanel2 panel2) {
		this.panel2 = panel2;

    getPlayerImage();
	}

  public void move() {
    if (x + xa > 0 && x + xa < panel2.getWidth() - WIDTH)
      x = x + xa;
      if (Y + ya > 0 && Y + ya < panel2.getHeight() - HEIGHT)
        Y = Y + ya;
  }
  public void keyReleased(KeyEvent e) {
    xa = 0;
    ya = 0;
  }

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

  public Rectangle getBounds() {
    return new Rectangle(x, Y, WIDTH, HEIGHT);
  }

  public void getPlayerImage(){
    try{
      character2 = ImageIO.read(new File("/Users/kalie_chang/Documents/Project/character.png"));

    }catch(IOException e){
      e.printStackTrace();
    }
  }

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

  public void draw(Graphics2D g2){
    BufferedImage image2 = null;
    image2 = character2;
    g2.drawImage(image2, x, Y, panel2.tileSize, panel2.tileSize, null);
    }
  }
