import java.util.*;
import java.io.*;
//class to show credits after game is over if player chooses to view credits

public class Credits {
  //constructor for credit class
  //this class will read the credits as an ArrayList
  //credits are written in a text file and will be displayed on the terminal
  public Credits() throws FileNotFoundException{
  ArrayList<String> allWords = new ArrayList<String>();
  Scanner input = new Scanner(new File("Credits.txt"));
    while (input.hasNextLine()) {
      String line = input.nextLine();
      allWords.add(line);
    }
    System.out.println(allWords);
  }
}
