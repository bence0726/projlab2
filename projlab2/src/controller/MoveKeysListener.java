/**
 * 
 */
package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

import enums.MoveDirections;

/**
 * A mozgáshoz szükséges billentyűket figyelő 
 * KeyListener osztály megvalósítása.
 * 
 * @author zsigatibor
 */
public class MoveKeysListener implements KeyListener {
	private MoveDirections oneilsLastDir;
	private MoveDirections jaffasLastDir;
	
	/**
	 * Kulcs: billentyű szám-reprezentációja
	 * Érték: hozzá tartozó moveDirections enum
	 */
	private Map<Integer, MoveDirections> oneilsKeys;
	private Map<Integer, MoveDirections> jaffasKeys;
	
	/**
	 * Konstruktor, amiben összeköttetik a billentyű
	 * az enum értékével
	 */
	public MoveKeysListener(){
		oneilsLastDir = MoveDirections.Stay;
		jaffasLastDir = MoveDirections.Stay;
		
		oneilsKeys = new HashMap<>();
		jaffasKeys = new HashMap<>();
		
		//Oneil's keys:
		oneilsKeys.put(KeyEvent.VK_UP, MoveDirections.MoveUp);
		oneilsKeys.put(KeyEvent.VK_DOWN, MoveDirections.MoveDown);
		oneilsKeys.put(KeyEvent.VK_LEFT, MoveDirections.MoveLeft);
		oneilsKeys.put(KeyEvent.VK_RIGHT, MoveDirections.MoveRight);
		
		//Jaffa's keys:
		jaffasKeys.put(KeyEvent.VK_W, MoveDirections.MoveUp);
		jaffasKeys.put(KeyEvent.VK_S, MoveDirections.MoveDown);
		jaffasKeys.put(KeyEvent.VK_A, MoveDirections.MoveLeft);
		jaffasKeys.put(KeyEvent.VK_D, MoveDirections.MoveRight);
	}
	
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(oneilsKeys.containsKey(keyCode))
			oneilsLastDir = oneilsKeys.get(keyCode);
		
		else if(jaffasKeys.containsKey(keyCode))
			jaffasLastDir = jaffasKeys.get(keyCode);
	}
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(oneilsKeys.containsKey(keyCode))
			oneilsLastDir = MoveDirections.Stay;
		
		else if(jaffasKeys.containsKey(keyCode))
			jaffasLastDir = MoveDirections.Stay;
	}
	public void keyTyped(KeyEvent e) {
		// nothing to do here
	}

	public MoveDirections getOneilsLastDir() {
		return oneilsLastDir;
	}

	public MoveDirections getJaffasLastDir() {
		return jaffasLastDir;
	}

}
