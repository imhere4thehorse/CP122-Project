import java.io.*;//for throws IOException
import java.awt.Rectangle;

public class Fire2 extends SuperObject2{ //second fire image
  private static final int WIDTH = 40;
  private static final int HEIGHT = 40;
  boolean burns = true; //prevents player from colliding infinitely with fire2
  //Fire2 has the same parameters as the abstract class SuperObject2 because it is a subclass of SuperObject2

  public Fire2(GamePanel2 panel2, String fileName, Player2 player2) throws IOException{
    super(panel2, fileName, player2);
  }
  //This constructor gets the x and y position and the width and height of the rectangle
  public Rectangle getBounds() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
  //This constructor returns either true or false whether the player object intersects with the fire object
  private boolean collision() {
		return this.panel2.player2.getBounds().intersects(getBounds());
	}
  //This constructor does not return because it is void, but it is the condition of whether the collision
  //occurs and if the boolean burns is true. If it collides, then it will call the method getChaos() from
  //gamePanel and then burns will be set to false so it player does not infinitely collide with fire2
  void move() {
		if (collision() && burns){
      this.panel2.getChaos();
      burns = false;
		}
	}
}
