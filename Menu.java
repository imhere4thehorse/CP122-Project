//where we will call all methods and objects to run our game.
//this is our main method!
import javax.swing.JFrame; //Jframe is part of swing, which allows us to create a Gui.
//the JFrame provides a window on the screen
//CLASS THAT STARTS THE WHOLE GAME
public class Menu{
  public static void main(String[] args){ //main method
    //creating a new jframe that will have the mainmenu on import junit.framework.TestCase;
    //once on main menu you can either start a new game or quit
    JFrame window = new JFrame(); //declare JFrame as window
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //means if we hit the close button on the top then the frame will close
    window.setResizable(false); //the frame cannot be resizable, the size stays how it is
    window.setTitle("Gettin' to a Street Fight!"); //title of the game at the top white bar
    window.getContentPane().add(new MainMenu(window));//getting main menu class
    window.pack(); //sets the frame so that the content within it is at preferred size
    window.setSize(1000,600); //set size to this many pixels (width and height)
    window.setVisible(true); //makes the MainMenu visible
  }
}
