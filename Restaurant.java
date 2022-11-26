import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionListener;
import java.util.Random;
import java.lang.Thread;

//functions the same as Player.java, but PlayerFight.java is meant for the second room
//and corresponds with enemyPanel.java
 // in order to generate random values for attacks and damage
public class PlayerFight extends Character{

  private static final int WIDTH = 60;
  private static final int HEIGHT = 10;

  enemyPanel ep;
  buttonHandler buttH;

  public PlayerFight(enemyPanel ep, buttonHandler buttH) {
		this.ep = ep;
    this.buttH = buttH;

    getPlayerImage();
    setDefaultValues();
	}

  public void setDefaultValues() {
    //setting spawn location of player
    x = 200;
    y = 150;
  }

  public void getPlayerImage(){
    try{
      //loading player images
      character = ImageIO.read(new File("/Users/kalie_chang/Documents/Project/character.png"));
      attack = ImageIO.read(new File("/Users/kalie_chang/Documents/Project/attack.png"));
      kick = ImageIO.read(new File("/Users/kalie_chang/Documents/Project/kick.png"));
      special = ImageIO.read(new File("/Users/kalie_chang/Documents/Project/special.png"));
      //loading enemy images
      opp = ImageIO.read(new File("/Users/kalie_chang/Documents/Project/Enemy.png"));
      attack1 = ImageIO.read(new File("/Users/kalie_chang/Documents/Project/enemyAttack.png"));
      kick1 = ImageIO.read(new File("/Users/kalie_chang/Documents/Project/AKUMAA.png"));
      special1 = ImageIO.read(new File("/Users/kalie_chang/Documents/Project/enemyCrit.png"));

    }catch(IOException e){
      e.printStackTrace();
    }
  }

  public void randomAttack(){
    generateDmg = new Random();
    generateAttack = generateDmg.nextInt(3);
    if(generateAttack == 0){
        combat1 = "punch1";
        enemyAttk = true;
        punchAttk = 10;
        playerHealth -= punchAttk;
        x1 = 700;
        y1 = 150;

        System.out.println("PUNCHED: player health: " + playerHealth);
    }else if(generateAttack == 1){
        combat1 = "kick1";
        enemyAttk = true;
        kickAttk = 12;
        playerHealth -= kickAttk;
        x1 = 700;
        y1 = 150;

        System.out.println("KICKED: player health: " + playerHealth);
      }else if (generateAttack == 2){
        combat1 = "special1";
        enemyAttk = true;
        specAttk = 20;
        playerHealth -= specAttk;
        x1 = 700;
        y1 = 150;

        System.out.println("SPECIAL: player health: " + playerHealth);
      }else if (enemyAttk = false){
        combat1 = "nothing1";
      }
   }

 public void update(){
   try{
    if(enemyHealth > 0){
     if (buttH.attackOne == true){
       playerAttack = true;
       combat = "punch";
       x = 300;
       y = 200;
       punch();
       randomAttack();
       // buttH.attackOne = false;
     } else if (buttH.attackTwo == true){
       playerAttack = true;
       combat = "kick";
       x = 300;
       y = 200;
       kick();
       randomAttack();
     } else if (buttH.attackThree == true){
       playerAttack = true;
       combat = "special";
       x = 300;
       y = 200;
       special();
       randomAttack();
     } else{
       combat = "nothing";
       x = 100;
       y = 100;
     }
   }

 }catch(Exception e){
  e.printStackTrace();
  }
}

  public void punch(){
    punchAttk = 10;
    enemyHealth -= punchAttk;
      //System.out.println(enemyHealth);
    System.out.println("YOU PUNCHED! Enemy Health: " + enemyHealth);
  }
  public void kick(){
    kickAttk = 12;
    enemyHealth -= kickAttk;
    System.out.println("YOU KICKED! Enemy Health: " + enemyHealth);
  }
  public void special(){
    specAttk = 20;
    enemyHealth -= specAttk;
    System.out.println("YOU DID A SPECIAL ATTACK! Enemy Health: " + enemyHealth);
  }

  public void draw(Graphics2D g2){
    BufferedImage image = null;
    BufferedImage eimage = null;
    //PLAYER IMAGES
      if (combat.equals("punch")){
        image = attack;
        buttH.attackOne = false;
      }else if (combat.equals("kick")){
        image = kick;
        buttH.attackTwo = false;
      }else if (combat.equals("special")){
        image = special;
        buttH.attackThree = false;
      }else {
        image = character;
      }

      //ENEMY IMAGES
      if (combat1.equals("punch1")){
        eimage = attack1;
        buttH.attackOne = false;
      }else if (combat1.equals("kick1")){
        eimage = kick1;
        buttH.attackTwo = false;
      }else if (combat1.equals("special1")){
        eimage = special1;
        buttH.attackThree = false;
      }else{
        eimage = opp;
        x1 = 700;
        y1 = 150;
      }

      g2.drawImage(image, x, y, 500, 500, null);
      g2.drawImage(eimage, x1, y1, 480, 480, null);
  }
}
