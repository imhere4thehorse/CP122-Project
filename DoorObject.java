import java.io.*; //for throws IOException
import java.awt.Rectangle;

public class DoorObject extends SuperObject{
  private static final int WIDTH = 40;
  private static final int HEIGHT = 40;
  boolean door = true; //prevents player from colliding infinitely with DoorObject
  //DoorObject has the same parameters as the abstract class SuperObject because it is a subclass of SuperObject
  public DoorObject(GamePanel panel, String fileName, Player player) throws IOException{
    super(panel, fileName, player); //refers to abstract class SuperObject
  }
  //This constructor gets the x and y position and the width and height of the rectangle
  public Rectangle getBounds() { //collisions use rectangles
		return new Rectangle(x, y, WIDTH, HEIGHT); //size of rectangle and x and y axis
	}
//This constructor returns either true or false whether the player object intersects with the door object
  private boolean collision() {
		return this.panel.player.getBounds().intersects(getBounds()); //so when rectangle intersects, it is a collision
	}
  //This constructor does not return because it is void, but it is the condition of whether the collision
  //occurs and if the boolean sleep is true. If it collides, then it will call the method openDoor() from
  //gamePanel and then sleep will be set to false so it player does not infinitely collide with door
  void move() {
		if (collision() && door){
      this.panel.openDoor(); //only true if collision and boolean is true
      door = false; //if it is false, then you cannot collide again
		}
	}
}
