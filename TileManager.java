import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
//draws background
public class TileManager{

  GamePanel panel;
  Tile[] tile; //create tile as array from the Tile.java

  public TileManager(GamePanel panel) {
    this.panel = panel;
    tile = new Tile[10]; //we will create 10 tiles
    getTileImage(); //call method here
  }
  public void getTileImage(){
    try{
      tile[0] = new Tile();
      tile[0].image = ImageIO.read(new File("/Users/kalie_chang/Documents/Project/HouseTile.jpg"));

    }catch(IOException e){
      e.printStackTrace();
    }
  }
//draw tiles
  public void draw(Graphics2D g2) { //draw a tile
    int column = 0;
    int row = 0;
    int x = 0;
    int y = 0;

    while(column<panel.maxScreenColumn && row<panel.maxScreenRow){
      g2.drawImage(tile[0].image, x, y, panel.tileSize, panel.tileSize, null); //x and y will be 0,0, color is null
      column++;
      x += panel.tileSize;

      if(column == panel.maxScreenColumn) { //when column reaches max screen
        column = 0;
        x = 0; //the tiles will stop
        row++; //the rows will start to add
        y += panel.tileSize; //until y axis equals tileSize
      }
    }
  }
}
