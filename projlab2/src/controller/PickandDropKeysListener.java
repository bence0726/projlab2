package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import enums.PickAndDrop;

public class PickandDropKeysListener implements KeyListener {
	private PickAndDrop oneilsLast;
	private PickAndDrop jaffasLast;
	
	private Map<Integer, PickAndDrop> oneilsKeys;
	private Map<Integer, PickAndDrop> jaffasKeys;
	
	public PickandDropKeysListener(){
		oneilsLast = PickAndDrop.NOACTION;
		jaffasLast = PickAndDrop.NOACTION;
		
		oneilsKeys = new HashMap<>();
		jaffasKeys = new HashMap<>();
		
		oneilsKeys.put(KeyEvent.VK_U, PickAndDrop.PICKED);
		oneilsKeys.put(KeyEvent.VK_I, PickAndDrop.DROPPED);
		
		jaffasKeys.put(KeyEvent.VK_0, PickAndDrop.PICKED);
		jaffasKeys.put(KeyEvent.VK_1, PickAndDrop.DROPPED);
	}
	
	public void keyPressed(KeyEvent e) {
		int keycode = e.getKeyCode();
		if(oneilsKeys.containsKey(keycode))
			oneilsLast = oneilsKeys.get(keycode);
		else if(jaffasKeys.containsKey(keycode))
			jaffasLast = jaffasKeys.get(keycode);
	}

	public void keyReleased(KeyEvent e) {
		int keycode = e.getKeyCode();
		if(oneilsKeys.containsKey(keycode))
			oneilsLast = PickAndDrop.NOACTION;
		else if(jaffasKeys.containsKey(keycode))
			jaffasLast = PickAndDrop.NOACTION;

	}

	public void keyTyped(KeyEvent e) {
		// nothing to do here
	}

	public PickAndDrop getOneilsLast() {
		return oneilsLast;
	}

	public PickAndDrop getJaffasLast() {
		return jaffasLast;
	}
}
