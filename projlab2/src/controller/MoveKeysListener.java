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
//	public void keyPressed(KeyEvent e) {
//		switch(e.getKeyCode()){
//		case KeyEvent.VK_W:
//			ctrl.setKarDir("JAFFA", "UP");			
//			return;
//		case KeyEvent.VK_S:
//			ctrl.setKarDir("JAFFA", "DOWN");
//			return;
//		case KeyEvent.VK_A:
//			if(e.getKeyLocation() == KeyEvent.KEY_LOCATION_LEFT && e.isShiftDown()){
//				ctrl.rotateGun("JAFFA", 30);//Ha a shift le van nyomva, forgatjuk a fegyvert
//				return;
//			}
//			ctrl.setKarDir("JAFFA", "LEFT");
//			return;
//		case KeyEvent.VK_D:
//			if(e.getKeyLocation() == KeyEvent.KEY_LOCATION_LEFT && e.isShiftDown()){
//				ctrl.rotateGun("JAFFA", -30);//Ha a shift le van nyomva, forgatjuk a fegyvert
//				return;
//			}
//			ctrl.setKarDir("JAFFA", "RIGHT");
//			return;
//		case KeyEvent.VK_UP:
//			ctrl.setKarDir("ONEIL", "UP");
//			return;
//		case KeyEvent.VK_DOWN:
//			ctrl.setKarDir("ONEIL", "DOWN");
//			return;
//		case KeyEvent.VK_LEFT:
//			if(e.getKeyLocation() == KeyEvent.KEY_LOCATION_RIGHT && e.isShiftDown()){
//				ctrl.rotateGun("ONEIL", 30);//Ha a shift le van nyomva, forgatjuk a fegyvert
//				return;
//			}
//			ctrl.setKarDir("ONEIL", "LEFT");
//			return;
//		case KeyEvent.VK_RIGHT:
//			if(e.getKeyLocation() == KeyEvent.KEY_LOCATION_RIGHT && e.isShiftDown()){
//				ctrl.rotateGun("ONEIL", -30);//Ha a shift le van nyomva, forgatjuk a fegyvert
//				return;
//			}
//			ctrl.setKarDir("ONEIL", "RIGHT");
//			return;
//		default:
//			break;
//		}
//	}
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
