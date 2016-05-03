package gui;

import java.awt.Color;
import java.util.Iterator;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Map extends JPanel {

	/**
	 * Create the panel.
	 */
	public Map() {
		setLayout(null);
		setSize(800,600);
		setBackground(Color.WHITE);
//		setBounds(0, 0, 800, 729);
	}
	/**
	 * A kapott komponensListát felrajzolja a térképre.
	 * @param componentList
	 */
	public void refreshMap(List<JComponent> componentList){
		Iterator<JComponent> it = componentList.iterator();
		removeAll();//letörlünk mindent
		while(it.hasNext())	
			add(it.next());//hozzáadjuk a térképhez őket
														//FIXME jó helyre kerülnek?
		repaint();
		updateUI();
	}

}
