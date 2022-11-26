import java.io.*; //for throw IOException
import java.awt.Rectangle;

public class LivingRoom extends SuperObject{
  private static final int WIDTH = 40;
  private static final int HEIGHT = 40;
  boolean live = true;

  public LivingRoom(GamePanel panel, String fileName, Player player) throws IOException{
    super(panel, fileName, player);

  }
  public Rectangle getBounds() {
    return new Rectangle(x, y, WIDTH, HEIGHT);
  }
  private boolean collision() {
    return this.panel.player.getBounds().intersects(getBounds());
  }
  void move() {
    if (collision() && live){
      this.panel.tvWatch();
      live = false;
    }
  }
}
//refer to DoorObject for explanations on object subclass code
