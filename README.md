COMPUTER SCIENCE 1 FINAL PROJECT: Gettin’ to a Street Fight
<br>
By Kalie Chang and Grace Mun

Gettin’ to a Street Fight is a highly realistic fighting game where the player needs to start at the beginning of the fighter’s day and go through their day to day life before finding the opponent that they will have a street fight with. This game is based off of a scene from Rick and Morty. 

(Click to view inspiration video)
https://www.youtube.com/watch?v=XWgDCpn-eAg

<br>
We were given 1.5 weeks to work on this project. The Computer Science 1 course was taught in 3.5 weeks.
Installation 
<br>
Download the final project zip file that contains all the .java files, the images, and the other files. Please adjust the code that reads the images with the proper location on your computer in order to have all the images run properly on your computer. The images are located in the following classes:
GamePanel.java
GamePanel2.java
Lose.java
MainMenu.java
Player.java
Player2.java
PlayerFight.java
TileManager.java
TileManagerFight.java
Tiles2.java
Win.java

To run the game, please go to your terminal, find the proper folder the game is in, and type javac *.java to compile the game. This will compile all the classes within the game. To run the game, type in java Menu.java. (Menu is where the main is).

Here are some things to keep in mind. When you enter the first room with the dog and the bed, if there are objects that do not exist, please extend the window until you reach the desired object. This is due to the dimensions we set on the code that fit 16" screens, but may not be an exact fit on the screens of computers smaller than 16". This also applies to the second room with the fire and the enemy.
 
Controls
<br>
ROOM 1
<br>
Use the WASD controls (W = forward, A = left, D = right, S = down) to move through the screen and collide with objects you want to interact with. A small window will pop up that will tell you about your interaction with the objects. Please press OK to exit the window. Do not press the red X button at the top left. To leave this room, collide with the door at the right. Do not collide with the door unless you are sure you want to leave the room. A window will pop up to prompt you to leave the room. Please press “Leave Room” and do not press the red X button at the top left. You will not be able to return to this room after you leave. You will then be taken to the second room.

ROOM 2
<br>
Use the WASD controls (W = forward, A = left, D = right, S = down) to move through the screen and collide with objects you want to interact with. A small window will pop up that will tell you about your interaction with the objects. Please press OK to exit the window. Do not press the red X button at the top left. To engage in a fight with the villain, collide with the villain at the right. Do not collide with the villain unless you are sure you want to fight the villain. A window will pop up to prompt you to fight the villain. Please press “Fight Enemy” and do not press the red X button at the top left. You will not be able to return to this room after you leave. You will then be taken to the fight.

STREET FIGHT
<br>
Press the designated buttons on the bottom of the screen in order to perform an attack to the enemy!
Punch = 10 damage
Kick = 12 damage
Special = 20 damage
Every time you do an attack, the enemy will attack you back with either a punch, kick, or special ability (which all do the same damage as your abilities).

If you get the enemy to 0 health you WIN!
If the enemy gets you to 0 health you LOSE!

ENDING WINDOW
<br>
Once you complete the fight portion, you will have the option to quit the game or click on the credits button. If you quit the game, it exits out of the system. If you click on the credits button, please go to the terminal to see the printed text from the file Credits.txt
 
PROJECT REQUIREMENTS
<br>
1) Project contains more than 4 classes. There are 2 abstract classes, SuperObject.java and SuperObject2.java, which implements the base for the object subclasses in GamePanel.java (Room 1) and GamePanel2.java (Room 2). Our PlayerFight.java class inherits the variables of class Character.java.
2) The file Credits.txt is read and printed out as an ArrayList on the Win window and the Lose window
3) Project reads file Credits.txt in Credits.java and writes the text in Credits.txt in the terminal when you press “Credits” on either the Win window or the Lose window after you complete the fighting portion of the game
4) An interactive GUI allows user interaction
5) Our custom extension includes the object collision and the use of threads in GamePanel.java, GamePanel2.java, and enemyPanel.java, which goes beyond what we have learned in class.

<br>
This game utilized Atom.
