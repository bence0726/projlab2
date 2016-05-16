package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PickandDropKeysListener implements KeyListener {
	KarakterController ctrl;
	
	public PickandDropKeysListener(KarakterController kc){
		ctrl = kc;
	}	

	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_0:
			ctrl.pick("JAFFA");			
			return;
		case KeyEvent.VK_1:
			ctrl.drop("JAFFA");			
			return;
		case KeyEvent.VK_U:
			ctrl.pick("ONEIL");			
			return;
		case KeyEvent.VK_I:
			ctrl.drop("ONEIL");			
			return;	
		}
	}

	public void keyReleased(KeyEvent e) {
		// nothing to do here
	}

	public void keyTyped(KeyEvent e) {
		// nothing to do here
	}
}
