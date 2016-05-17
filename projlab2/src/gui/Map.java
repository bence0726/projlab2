package gui;

import java.awt.Color;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.JComponent;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Map extends JPanel {

	final int mapwidth = 800;
	final int mapheight = 600;
	/**
	 * Create the panel.
	 */
	public Map() {
		setLayout(null);
		setSize(mapwidth,mapheight);
		setBackground(Color.WHITE);
//		setBounds(0, 0, 800, 729);
	}
	/**
	 * A kapott komponensListát felrajzolja a térképre.
	 * @param componentList
	 */
	public void refreshMap(Set<JComponent> componentList){
		Iterator<JComponent> it = componentList.iterator();
		removeAll();//letörlünk mindent
		while(it.hasNext())	
			add(it.next());//hozzáadjuk a térképhez őket
														//FIXME jó helyre kerülnek?
//		repaint();
		updateUI();
	}

}
