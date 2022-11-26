//package start;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;

//functions similarly to TileManager, but for the background of the fight portion
public class TileManagerFight{

  enemyPanel ep;
  Tile[] tile; //create tile as array

  public TileManagerFight(enemyPanel ep) {
    this.ep = ep;
    tile = new Tile[10]; //we will create 10 tiles
    getTileImage(); //call method here
  }
  public void getTileImage(){
    try{
      tile[0] = new Tile();
      tile[0].image = ImageIO.read(new File("/Users/kalie_chang/Documents/Project/FightBackground.jpg"));

    }catch(IOException e){
      e.printStackTrace();
    }
  }

  public void draw(Graphics2D g2) { //draw a tile
    int column = 0;
    int row = 0;
    int x = 0;
    int y = 0;

    while(column<ep.maxScreenColumn && row<ep.maxScreenRow){
      g2.drawImage(tile[0].image, x, y, ep.tileSize, ep.tileSize, null); //x and y will be 0,0, color is null
      column++;
      x += ep.tileSize;

      if(column == ep.maxScreenColumn) { //when column reaches max screen
        column = 0;
        x = 0; //the tiles will stop
        row++; //the rows will start to add
        y += ep.tileSize; //until y axis equals tileSize
      }
    }
  }
}
