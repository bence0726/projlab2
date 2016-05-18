package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class PickandDropKeysListener implements KeyListener {
	int jaffaslastkey = -1;
	int oneilslastkey = -1;
	
	public void keyPressed(KeyEvent e) {
		int keycode = e.getKeyCode();
		switch(keycode){		
		case KeyEvent.VK_0://ez egy nulla
			jaffaslastkey = keycode;		
			return;
		case KeyEvent.VK_1:
			jaffaslastkey = keycode;			
			return;
		case KeyEvent.VK_U:
			oneilslastkey = keycode;				
			return;
		case KeyEvent.VK_I:
			oneilslastkey = keycode;		
			return;	
		}
	}

	public void keyReleased(KeyEvent e) {
		int keycode = e.getKeyCode();
		switch(keycode){		
		case KeyEvent.VK_0:
			jaffaslastkey = -1;		
			return;
		case KeyEvent.VK_1:
			jaffaslastkey = -1;			
			return;
		case KeyEvent.VK_U:
			oneilslastkey = -1;				
			return;
		case KeyEvent.VK_I:
			oneilslastkey = -1;		
			return;	
		}
	}

	public void keyTyped(KeyEvent e) {
		// nothing to do here
	}
}
