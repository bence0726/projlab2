package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FireKeysListener implements KeyListener {
	KarakterController ctrl;
	
	public FireKeysListener(KarakterController kc){
		ctrl = kc;
	}
	
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_Q:
			ctrl.fire("JAFFA", "RED");			
			return;
		case KeyEvent.VK_E:
			ctrl.fire("JAFFA", "GREEN");			
			return;
		case KeyEvent.VK_O:
			ctrl.fire("ONEIL", "BLUE");			
			return;
		case KeyEvent.VK_P:
			ctrl.fire("ONEIL", "YELLOW");			
			return;
		}
	}
	
	public void keyReleased(KeyEvent arg0) {
		// nothing to do here

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// nothing to do here

	}

}
