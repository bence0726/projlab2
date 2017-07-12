package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class RotateKeyListener implements KeyListener{
	private boolean doesOneilRotated = false;
	private boolean doesJaffaRotated = false;
	
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_L:
			doesOneilRotated = true;
			return;	
		case KeyEvent.VK_CAPS_LOCK:
			doesJaffaRotated = true;
			return;
		default:
			return;
		}			
	}		
	
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_L:
			doesOneilRotated = false;
			return;
		case KeyEvent.VK_CAPS_LOCK:
			doesJaffaRotated = false;
			return;
		default:
			return;
		}	
	}
	
	public void keyTyped(KeyEvent e) {
		// nothing to do here
	}

	public boolean DoesOneilRotated() {
		return doesOneilRotated;
	}

	public boolean DoesJaffaRotated() {
		return doesJaffaRotated;
	}
}