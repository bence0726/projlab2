package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class FireKeysListener implements KeyListener {
	Set<Integer> jaffaslastkey = new HashSet<>();
	Set<Integer> oneilslastkey = new HashSet<>();
	
	public void keyPressed(KeyEvent e) {
		int keycode = e.getKeyCode();
		switch(keycode){
		case KeyEvent.VK_Q:
			jaffaslastkey.add(keycode);		
			return;
		case KeyEvent.VK_E:
			jaffaslastkey.add(keycode);				
			return;
		case KeyEvent.VK_O:
			oneilslastkey.add(keycode);			
			return;
		case KeyEvent.VK_P:
			oneilslastkey.add(keycode);				
			return;
		}
	}
//	public void keyPressed(KeyEvent e) {
//		switch(e.getKeyCode()){
//		case KeyEvent.VK_Q:
//			ctrl.fire("JAFFA", "RED");			
//			return;
//		case KeyEvent.VK_E:
//			ctrl.fire("JAFFA", "GREEN");			
//			return;
//		case KeyEvent.VK_O:
//			ctrl.fire("ONEIL", "BLUE");			
//			return;
//		case KeyEvent.VK_P:
//			ctrl.fire("ONEIL", "YELLOW");			
//			return;
//		}
//	}
	
	public void keyReleased(KeyEvent e) {//az elengedett billentyűt kivesszük a halmazból
		int keycode = e.getKeyCode();
		switch(keycode){
		case KeyEvent.VK_Q:
			jaffaslastkey.remove(keycode);		
			return;
		case KeyEvent.VK_E:
			jaffaslastkey.remove(keycode);				
			return;
		case KeyEvent.VK_O:
			oneilslastkey.remove(keycode);			
			return;
		case KeyEvent.VK_P:
			oneilslastkey.remove(keycode);				
			return;
		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// nothing to do here

	}

}
