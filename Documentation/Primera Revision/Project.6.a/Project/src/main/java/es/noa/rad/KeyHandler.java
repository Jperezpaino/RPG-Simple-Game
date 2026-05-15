package es.noa.rad;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

  public boolean upPressed;
  public boolean downPressed;
  public boolean leftPressed;
  public boolean rightPressed;
	
  @Override
  public final void keyTyped(
         final KeyEvent keyEvent) {

  }

  @Override
  public final void keyPressed(
         final KeyEvent keyEvent) {
    int code = keyEvent.getKeyCode();

    if(code == KeyEvent.VK_W) {
      upPressed = true;	
    }
    if(code == KeyEvent.VK_S) {
      downPressed = true;	
    }
    if(code == KeyEvent.VK_A) {
      leftPressed = true;	
    }
    if(code == KeyEvent.VK_D) {
      rightPressed = true;	
    }
  }

  @Override
  public final void keyReleased(
		 final KeyEvent keyEvent) {
    int code = keyEvent.getKeyCode();

    if(code == KeyEvent.VK_W) {
      upPressed = false;
    }
    if(code == KeyEvent.VK_S) {
      downPressed = false;
    }
    if(code == KeyEvent.VK_A) {
      leftPressed = false;
    }
    if(code == KeyEvent.VK_D) {
      rightPressed = false;
    } 
  }

}
