package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FireKeysListener implements KeyListener {
	int jaffaslastkey = -1;
	int oneilslastkey = -1;
	
	public void keyPressed(KeyEvent e) {
		int keycode = e.getKeyCode();
		switch(keycode){
		case KeyEvent.VK_Q:
			jaffaslastkey = keycode;		
			return;
		case KeyEvent.VK_E:
			jaffaslastkey = keycode;				
			return;
		case KeyEvent.VK_O:
			oneilslastkey = keycode;			
			return;
		case KeyEvent.VK_P:
			oneilslastkey = keycode;				
			return;
//		case KeyEvent.VK_CAPS_LOCK:
//			jaffaslastkey = keycode;	
//			return;
//		case KeyEvent.VK_L:
//			oneilslastkey = keycode;
//			return;		
		}
	}
	
	public void keyReleased(KeyEvent e) {//az elengedett billentyűt kivesszük a halmazból
		int keycode = e.getKeyCode();
		switch(keycode){
		case KeyEvent.VK_Q:
			jaffaslastkey = -1;		
			return;
		case KeyEvent.VK_E:
			jaffaslastkey  = -1;				
			return;
		case KeyEvent.VK_O:
			oneilslastkey  = -1;			
			return;
		case KeyEvent.VK_P:
			oneilslastkey  = -1;				
			return;
		case KeyEvent.VK_CAPS_LOCK:
			jaffaslastkey = -1;	
			return;
		case KeyEvent.VK_L:
			oneilslastkey = -1;
			return;
		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// nothing to do here

	}

}
