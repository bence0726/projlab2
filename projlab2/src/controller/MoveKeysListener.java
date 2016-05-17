/**
 * 
 */
package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

import model.MoveDirections;

/**
 * A mozgáshoz szükséges billentyűket figyelő 
 * KeyListener osztály megvalósítása.
 * 
 * @author zsigatibor
 */
public class MoveKeysListener implements KeyListener {
	Set<Integer> jaffaslastkey = new HashSet<>();
	Set<Integer> oneilslastkey = new HashSet<>();
	public void keyPressed(KeyEvent e) {
		int keycode = e.getKeyCode();
		switch(keycode){
		case KeyEvent.VK_W:
			jaffaslastkey.add(keycode);			
			return;
		case KeyEvent.VK_S:
			jaffaslastkey.add(keycode);	
			return;
		case KeyEvent.VK_A:
			jaffaslastkey.add(keycode);	
			return;
		case KeyEvent.VK_D:
			jaffaslastkey.add(keycode);	
			return;
		case KeyEvent.VK_UP:
			oneilslastkey.add(keycode);	
			return;
		case KeyEvent.VK_DOWN:
			oneilslastkey.add(keycode);	
			return;
		case KeyEvent.VK_LEFT:
			oneilslastkey.add(keycode);	
			return;
		case KeyEvent.VK_RIGHT:
			oneilslastkey.add(keycode);	
			return;
		case KeyEvent.VK_CAPS_LOCK:
			jaffaslastkey.add(keycode);
			return;
		case KeyEvent.VK_SHIFT:
			oneilslastkey.add(keycode);
			return;
		default:
			break;
		}
	}
	public void keyReleased(KeyEvent e) {
		int keycode = e.getKeyCode();
		switch(keycode){
		case KeyEvent.VK_W:
			jaffaslastkey.remove(keycode);			
			return;
		case KeyEvent.VK_S:
			jaffaslastkey.remove(keycode);	
			return;
		case KeyEvent.VK_A:
			jaffaslastkey.remove(keycode);	
			return;
		case KeyEvent.VK_D:
			jaffaslastkey.remove(keycode);	
			return;
		case KeyEvent.VK_UP:
			oneilslastkey.remove(keycode);	
			return;
		case KeyEvent.VK_DOWN:
			oneilslastkey.remove(keycode);	
			return;
		case KeyEvent.VK_LEFT:
			oneilslastkey.remove(keycode);	
			return;
		case KeyEvent.VK_RIGHT:
			oneilslastkey.remove(keycode);	
			return;
		case KeyEvent.VK_CAPS_LOCK:
			jaffaslastkey.remove(keycode);
			return;
		case KeyEvent.VK_SHIFT:
			oneilslastkey.remove(keycode);
			return;
		default:
			break;
		}
	}
	public void keyTyped(KeyEvent e) {
		// nothing to do here
	}

}
