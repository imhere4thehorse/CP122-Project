import java.io.*;//for throws IOException
import java.awt.Rectangle;

public class BathObject extends SuperObject{
  private static final int WIDTH = 40;
  private static final int HEIGHT = 40;
  boolean bathe = true;

  //BathObject has the same parameters as the abstract class SuperObject because it is a subclass of SuperObject
  public BathObject(GamePanel panel, String fileName, Player player) throws IOException{
    super(panel, fileName, player);
  }
  //This constructor gets the x and y position and the width and height of the rectangle
  public Rectangle getBounds() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
  //This constructor returns either true or false whether the player object intersects with the bathtub object
  private boolean collision() {
		return this.panel.player.getBounds().intersects(getBounds());
	}
  //This constructor does not return because it is void, but it is the condition of whether the collision
  //occurs and if the boolean bathe is true. If it collides, then it will call the method getBath() from
  //gamePanel and then bathe will be set to false so it player does not infinitely collide with bathtub
  void move() {
		if (collision() && bathe){
      this.panel.getBath();
      bathe = false;
		}
	}
}
