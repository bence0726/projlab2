package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class RotateKeyListener implements KeyListener{
	int oneilangle = 0;
	int jaffaangle = 0;
	
	public void keyPressed(KeyEvent e) {
		int keycode = e.getKeyCode();
		switch (keycode) {
		case KeyEvent.VK_CAPS_LOCK:
			jaffaangle = keycode;	
			return;
		case KeyEvent.VK_L:
			oneilangle = keycode;
			return;	
		default:
		break;
		}			
	}		
	
	public void keyReleased(KeyEvent e) {
		int keycode = e.getKeyCode();
		switch (keycode) {
		case KeyEvent.VK_CAPS_LOCK:
			jaffaangle = -1;	
			return;
		case KeyEvent.VK_L:
			oneilangle = -1;
			return;	
		default:
		break;
		}	
	}
	
	public void keyTyped(KeyEvent e) {
		// nothing to do here
	}
}