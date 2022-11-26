import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
//functions similarly to TileManager, but for the background of the second room
public class Tiles2{

  GamePanel2 panel2;
  Tile[] tile; //create tile as array from Tile.java

  public Tiles2(GamePanel2 panel2) {
    this.panel2 = panel2;
    tile = new Tile[10];
    getTileImage();
  }
  public void getTileImage(){
    try{
      tile[0] = new Tile();
      tile[0].image = ImageIO.read(new File("/Users/kalie_chang/Documents/Project/townBackground.jpg"));

    }catch(IOException e){
      e.printStackTrace();
    }
  }

  public void draw(Graphics2D g2) {
    int column = 0;
    int row = 0;
    int x = 0;
    int y = 0;

    while(column<panel2.maxScreenColumn && row<panel2.maxScreenRow){
      g2.drawImage(tile[0].image, x, y, panel2.tileSize, panel2.tileSize, null); //x and y will be 0,0, color is null
      column++;
      x += panel2.tileSize;

      if(column == panel2.maxScreenColumn) { //when column reaches max screen
        column = 0;
        x = 0; //the tiles will stop
        row++; //the rows will start to add
        y += panel2.tileSize; //until y axis equals tileSize
      }
    }
  }
}
