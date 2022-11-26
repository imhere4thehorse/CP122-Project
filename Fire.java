import java.io.*;//for throws IOException
import java.awt.Rectangle;
//
public class Fire extends SuperObject2{
  private static final int WIDTH = 40;
  private static final int HEIGHT = 40;
  boolean burn = true;//prevents player from colliding infinitely with fire
  //Fire has the same parameters as the abstract class SuperObject2 because it is a subclass of SuperObject2

  public Fire(GamePanel2 panel2, String fileName, Player2 player2) throws IOException{
    super(panel2, fileName, player2);
  }
//This constructor gets the x and y position and the width and height of the rectangle
  public Rectangle getBounds() { //collisions use rectangles
		return new Rectangle(x, y, WIDTH, HEIGHT); //size of rectangle and x and y axis
	}
//This constructor returns either true or false whether the player object intersects with the fire object
  private boolean collision() {
		return this.panel2.player2.getBounds().intersects(getBounds());//so when rectangle intersects, it is a collision
	}
  //This constructor does not return because it is void, but it is the condition of whether the collision
  //occurs and if the boolean burn is true. If it collides, then it will call the method chaos() from
  //gamePanel and then burn will be set to false so it player does not infinitely collide with fire
  void move() {
		if (collision() && burn){
      this.panel2.chaos();//only true if collision and boolean is true
      burn = false; //if it is false, then you cannot collide again
		}
	}
}
