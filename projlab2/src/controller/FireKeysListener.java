package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

import model.Szin;

public class FireKeysListener implements KeyListener {
	private Szin oneilsLastSzin;
	private Szin jaffasLastSzin;
	
	/**
	 * Kulcs: billentyűt reprezentáló számkód
	 * Érték: billentyűhöz tartozó szín
	 */
	private Map<Integer, Szin> oneilsKeys;
	private Map<Integer, Szin> jaffasKeys;
	
	public FireKeysListener(){
		oneilsLastSzin = null;
		jaffasLastSzin = null;
		
		oneilsKeys = new HashMap<>();
		jaffasKeys = new HashMap<>();
		
		oneilsKeys.put(KeyEvent.VK_O, Szin.Kek);
		oneilsKeys.put(KeyEvent.VK_P, Szin.Sarga);
		
		jaffasKeys.put(KeyEvent.VK_Q, Szin.Piros);
		jaffasKeys.put(KeyEvent.VK_E, Szin.Zold);
	}
	
	public void keyPressed(KeyEvent e) {
		int keycode = e.getKeyCode();
		if(oneilsKeys.containsKey(keycode))
			oneilsLastSzin = oneilsKeys.get(keycode);
		else if(jaffasKeys.containsKey(keycode))
			jaffasLastSzin = jaffasKeys.get(keycode);
	}
	
	public void keyReleased(KeyEvent e) {
		int keycode = e.getKeyCode();
		if(oneilsKeys.containsKey(keycode))
			oneilsLastSzin = null;
		else if(jaffasKeys.containsKey(keycode))
			jaffasLastSzin = null;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// nothing to do here
	}

	public Szin getOneilsLastSzin() {
		return oneilsLastSzin;
	}

	public Szin getJaffasLastSzin(){
		return jaffasLastSzin;
	}
}