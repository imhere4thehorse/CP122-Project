import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

  public boolean attackOne, attackTwo, attackThree;

  @Override
  public void keyTyped(KeyEvent e){

  }
  
  @Override
  public void keyPressed(KeyEvent e) {
    int key = e.getKeyCode();
    if (key == KeyEvent.VK_1){
      attackOne = true;
    }
    if (key == KeyEvent.VK_2){
      attackTwo = true;
    }
    if (key == KeyEvent.VK_3){
      attackThree = true;
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {
    int key = e.getKeyCode();
    if (key == KeyEvent.VK_1){
      attackOne = false;
    }
    if (key == KeyEvent.VK_2){
      attackTwo = false;
    }
    if (key == KeyEvent.VK_3){
      attackThree = false;
    }
  }

}
