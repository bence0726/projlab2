/**
 * 
 */
package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.MoveDirections;

/**
 * A mozgáshoz szükséges billentyűket figyelő 
 * KeyListener osztály megvalósítása.
 * 
 * @author zsigatibor
 */
public class MoveKeysListener implements KeyListener {
	KarakterController ctrl;
	
	public MoveKeysListener(KarakterController kc){
		ctrl = kc;
	}
	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_W:
			ctrl.setKarDir("JAFFA", "UP");
			
			return;
		case KeyEvent.VK_S:
			ctrl.setKarDir("JAFFA", "DOWN");
			return;
		case KeyEvent.VK_A:
			if(e.getKeyLocation() == KeyEvent.KEY_LOCATION_LEFT && e.isShiftDown()){
				ctrl.rotateGun("JAFFA", 30);//Ha a shift le van nyomva, forgatjuk a fegyvert
				return;
			}
			ctrl.setKarDir("JAFFA", "LEFT");
			return;
		case KeyEvent.VK_D:
			if(e.getKeyLocation() == KeyEvent.KEY_LOCATION_LEFT && e.isShiftDown()){
				ctrl.rotateGun("JAFFA", -30);//Ha a shift le van nyomva, forgatjuk a fegyvert
				return;
			}
			ctrl.setKarDir("JAFFA", "RIGHT");
			return;
		case KeyEvent.VK_UP:
			ctrl.setKarDir("ONEIL", "UP");
			return;
		case KeyEvent.VK_DOWN:
			ctrl.setKarDir("ONEIL", "DOWN");
			return;
		case KeyEvent.VK_LEFT:
			ctrl.setKarDir("ONEIL", "LEFT");
			return;
		case KeyEvent.VK_RIGHT:
			ctrl.setKarDir("ONEIL", "RIGHT");
			return;
			
			break;

		default:
			break;
		}
		
			ctrl.setKarDir("JAFFA", "UP");
			return;
		}
		if(e.getKeyChar() == 'w'){
			ctrl.setKarDir("JAFFA", "UP");
			return;
		}
		if(e.getKeyChar() == 'w'){
			ctrl.setKarDir("JAFFA", "UP");
			return;
		}
		if(e.getKeyChar() == 'w'){
			ctrl.setKarDir("JAFFA", "UP");
			return;
		}
			

	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
