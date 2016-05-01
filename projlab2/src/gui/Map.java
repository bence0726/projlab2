package gui;

import java.awt.Component;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Map extends JPanel {

	/**
	 * Create the panel.
	 */
	public Map() {
		setLayout(null);
		setSize(800,600);
	}
	/**
	 * A kapott komponensListát felrajzolja a térképre.
	 * @param componentList
	 */
	public void refreshMap(List<Component> componentList){
		Iterator<Component> it = componentList.iterator();
		removeAll();//letörlünk mindent
		while(it.hasNext())	
			add(it.next());								//hozzáadjuk a térképhez őket
														//FIXME jó helyre kerülnek?
	}

}
