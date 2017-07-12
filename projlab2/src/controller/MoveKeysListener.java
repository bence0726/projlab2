/**
 * 
 */
package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * A mozgáshoz szükséges billentyűket figyelő 
 * KeyListener osztály megvalósítása.
 * 
 * @author zsigatibor
 */
public class MoveKeysListener implements KeyListener {
	int jaffaslastkey = -1;
	int oneilslastkey = -1;
	
	public void keyPressed(KeyEvent e) {
		int keycode = e.getKeyCode();
		switch(keycode){
		case KeyEvent.VK_W:
		case KeyEvent.VK_S:
		case KeyEvent.VK_A:
		case KeyEvent.VK_D:
			jaffaslastkey = keycode;	
			return;
		case KeyEvent.VK_UP:
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_RIGHT:
			oneilslastkey = keycode;	
			return;
		default:
			return;
		}
	}
	public void keyReleased(KeyEvent e) {
		int keycode = e.getKeyCode();
		switch(keycode){
		case KeyEvent.VK_W:
		case KeyEvent.VK_S:
		case KeyEvent.VK_A:
		case KeyEvent.VK_D:
		case KeyEvent.VK_CAPS_LOCK:
			jaffaslastkey = -1;	
			return;
		case KeyEvent.VK_UP:
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_L:
			oneilslastkey = -1;
			return;	
		default:
			return;
		}
	}
	public void keyTyped(KeyEvent e) {
		// nothing to do here
	}

}
