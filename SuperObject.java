/*abstract class SuperObject, which formats the code for all the other objects
all objects need an image, player, and coordinates for which they will exist in the game
*/
import javax.swing.*; //everything within swing
import java.awt.*; //everything within awt
import java.awt.image.BufferedImage; //for some reason, error pops up if I don't specifically import this
import javax.imageio.ImageIO; //for some reason, error pops up if I don't specifically import this
import java.io.*; //everything within io

public abstract class SuperObject {
  protected BufferedImage image; //protected means it can be accessed by any class
  protected GamePanel panel;
  int x;
  int y;
  int width;
  int height;
  protected Player player;

    public SuperObject(GamePanel panel, String fileName, Player player) throws IOException {
      this.panel = panel;
      this.image = ImageIO.read(new File(fileName));
      this.player = player;
    }

    public void draw(Graphics2D g2, int x, int y) { //draw a tile
      this.x = x;
      this.y = y;
      g2.drawImage(this.image, x, y, panel.tileSize, panel.tileSize, null); //x and y will be 0,0
    }
   }
