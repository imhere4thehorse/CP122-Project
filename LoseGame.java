//package start;
import javax.swing.JFrame;

public class LoseGame{

  //treat this like leave door //if your health = 0, then LoseGame youLose = new LoseGame(){
  public LoseGame(){
    JFrame window = new JFrame(); //declare JFrame as window
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //means if we hit the close button on the top then the frame will close
    window.setResizable(false); //the frame cannot be resizable, the size stays how it is
    window.setTitle("Gettin' to a Street Fight!"); //title of the game at the top white bar
    window.getContentPane().add(new Lose(window));//getting main menu class
    window.pack(); //sets the frame so that the content within it is at preferred size
    window.setSize(1000,600); //set size to this many pixels (width and height)
    window.setVisible(true); //makes the MainMenu visible
  }
}
