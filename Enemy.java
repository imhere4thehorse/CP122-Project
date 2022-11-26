import java.io.*;//for throws IOException
import java.awt.Rectangle;
//enemy class for the second window after player leaves house
public class Enemy extends SuperObject2{
  private static final int WIDTH = 40;
  private static final int HEIGHT = 40;
  boolean bad = true;
//Enemy has the same parameters as the abstract class SuperObject2 because it is a subclass of SuperObject2
  public Enemy(GamePanel2 panel2, String fileName, Player2 player2) throws IOException{
    super(panel2, fileName, player2); //refers to abstract class SuperObject
  }
//This constructor gets the x and y position and the width and height of the rectangle
  public Rectangle getBounds() { //collisions use rectangles
		return new Rectangle(x, y, WIDTH, HEIGHT); //size of rectangle and x and y axis
	}
//This constructor returns either true or false whether the player object intersects with the enemy object
  private boolean collision() {
		return this.panel2.player2.getBounds().intersects(getBounds());//so when rectangle intersects, it is a collision
	}
  //This constructor does not return because it is void, but it is the condition of whether the collision
  //occurs and if the boolean sleep is true. If it collides, then it will call the method Akuma() from
  //gamePanel and then sleep will be set to false so it player does not infinitely collide with enemy
  void move() {
		if (collision() && bad){
      this.panel2.Akuma(); //only true if collision and boolean is true
      bad = false;
		}
	}
}
