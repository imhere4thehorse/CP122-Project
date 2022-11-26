/*abstract class is similar to SuperObject, but is used for the second
area the player goes to
*/
import javax.swing.*; //everything within swing
import java.awt.*; //everything within awt
import java.awt.image.BufferedImage; //for some reason, error pops up if I don't specifically import this
import javax.imageio.ImageIO; //for some reason, error pops up if I don't specifically import this
import java.io.*; //everything within io

//functions like SuperObject only this is for all the objects in the second room
public abstract class SuperObject2 {
  protected BufferedImage image;
  protected GamePanel2 panel2;
  int x;
  int y;
  int width;
  int height;
  protected Player2 player2;

    public SuperObject2(GamePanel2 panel2, String fileName, Player2 player2) throws IOException {
      this.panel2 = panel2;
      this.image = ImageIO.read(new File(fileName));
      this.player2 = player2;
    }

    public void draw(Graphics2D g2, int x, int y) {
      this.x = x;
      this.y = y;
      g2.drawImage(this.image, x, y, panel2.tileSize, panel2.tileSize, null); //x and y will be 0,0
    }
   }

//functions similarly to SuperObject
