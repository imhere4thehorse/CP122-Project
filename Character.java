//character class that player and main opponent will extend from
//where all combat moves are stored and can be called
/* kick, attack, crit hit
    HP = 100
    cooldown time 2 seconds between each move
*/
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;
//class that stores variables that will be used in player fight (which made it easier to organize variables)
public class Character {
  int x, y,x1, y1;
  int speed;

  int enemyHealth = 100;
  int playerHealth = 100;

  BufferedImage character, attack, kick, special, opp, attack1, kick1, special1;
  String combat = "nothing";
  String combat1 = "nothing1";

  Random generateDmg;
  int generateAttack;
  int punchAttk;
  int kickAttk;
  int specAttk;

  boolean playerAttack = false;
  boolean enemyAttk;
}
