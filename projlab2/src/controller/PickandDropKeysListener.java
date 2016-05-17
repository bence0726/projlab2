package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class PickandDropKeysListener implements KeyListener {
	Set<Integer> jaffaslastkey = new HashSet<>();
	Set<Integer> oneilslastkey = new HashSet<>();
	
	public void keyPressed(KeyEvent e) {
		int keycode = e.getKeyCode();
		switch(keycode){		
		case KeyEvent.VK_0:
			jaffaslastkey.add(keycode);		
			return;
		case KeyEvent.VK_1:
			jaffaslastkey.add(keycode);			
			return;
		case KeyEvent.VK_U:
			oneilslastkey.add(keycode);				
			return;
		case KeyEvent.VK_I:
			oneilslastkey.add(keycode);		
			return;	
		}
	}
//	public void keyPressed(KeyEvent e) {
//		switch(e.getKeyCode()){
//		case KeyEvent.VK_0:
//			ctrl.pick("JAFFA");			
//			return;
//		case KeyEvent.VK_1:
//			ctrl.drop("JAFFA");			
//			return;
//		case KeyEvent.VK_U:
//			ctrl.pick("ONEIL");			
//			return;
//		case KeyEvent.VK_I:
//			ctrl.drop("ONEIL");			
//			return;	
//		}
//	}

	public void keyReleased(KeyEvent e) {
		int keycode = e.getKeyCode();
		switch(keycode){		
		case KeyEvent.VK_0:
			jaffaslastkey.remove(keycode);		
			return;
		case KeyEvent.VK_1:
			jaffaslastkey.remove(keycode);			
			return;
		case KeyEvent.VK_U:
			oneilslastkey.remove(keycode);				
			return;
		case KeyEvent.VK_I:
			oneilslastkey.remove(keycode);		
			return;	
		}
	}

	public void keyTyped(KeyEvent e) {
		// nothing to do here
	}
}
