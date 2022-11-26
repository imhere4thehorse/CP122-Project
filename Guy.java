import java.io.*;//for throws IOException
import java.awt.Rectangle;

public class Guy extends SuperObject2{
  private static final int WIDTH = 40;
  private static final int HEIGHT = 40;
  boolean gentlemen = true;

  public Guy(GamePanel2 panel2, String fileName, Player2 player2) throws IOException{
    super(panel2, fileName, player2);

  }
  public Rectangle getBounds() {
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
  private boolean collision() {
		return this.panel2.player2.getBounds().intersects(getBounds());
	}
  void move() {
		if (collision() && gentlemen){
      this.panel2.Men();
      gentlemen = false;
		}
	}
}
//refer to DoorObject for explanations on object subclass code
