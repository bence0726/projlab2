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
			jaffaslastkey = keycode;			
			return;
		case KeyEvent.VK_S:
			jaffaslastkey = keycode;	
			return;
		case KeyEvent.VK_A:
			jaffaslastkey = keycode;	
			return;
		case KeyEvent.VK_D:
			jaffaslastkey = keycode;	
			return;
		case KeyEvent.VK_UP:
			oneilslastkey = keycode;	
			return;
		case KeyEvent.VK_DOWN:
			oneilslastkey = keycode;	
			return;
		case KeyEvent.VK_LEFT:
			oneilslastkey = keycode;	
			return;
		case KeyEvent.VK_RIGHT:
			oneilslastkey = keycode;	
			return;
		case KeyEvent.VK_CAPS_LOCK:
			jaffaslastkey = keycode;	
			return;
		case KeyEvent.VK_L:
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
			jaffaslastkey = -1;			
			return;
		case KeyEvent.VK_S:
			jaffaslastkey = -1;	
			return;
		case KeyEvent.VK_A:
			jaffaslastkey = -1;	
			return;
		case KeyEvent.VK_D:
			jaffaslastkey = -1;	
			return;
		case KeyEvent.VK_UP:
			oneilslastkey = -1;	
			return;
		case KeyEvent.VK_DOWN:
			oneilslastkey = -1;	
			return;
		case KeyEvent.VK_LEFT:
			oneilslastkey = -1;	
			return;
		case KeyEvent.VK_RIGHT:
			oneilslastkey = -1;	
			return;
		case KeyEvent.VK_CAPS_LOCK:
			jaffaslastkey = -1;	
			return;
		case KeyEvent.VK_L:
			oneilslastkey = -1;
			return;
		default:
			break;
		}
	}
	public void keyTyped(KeyEvent e) {
		// nothing to do here
	}

}
