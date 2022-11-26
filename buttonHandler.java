import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
//class in order to handle buttons that we will implement into our fight JPanel
//actionlistener is implemented in order to make buttons functionable
public class buttonHandler implements ActionListener{

  public boolean attackOne, attackTwo, attackThree;
  JButton punchButton, kickButton, specButt;
  //this method initializes the different butons that we will use
  public buttonHandler(JButton punchButton, JButton kickButton, JButton specButt){
    this.punchButton = punchButton;
    this.kickButton = kickButton;
    this.specButt = specButt;


  }
  //if each button is pressed, their according attack will be set as true
  public void actionPerformed(ActionEvent e){
    if (e.getSource() == punchButton){
      attackOne = true;
      // System.out.println("detected");
    }
    if (e.getSource() == kickButton){
      attackTwo = true;
    }
    if (e.getSource() == specButt){
      attackThree = true;
    }
  }

}
