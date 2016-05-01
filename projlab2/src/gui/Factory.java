package gui;


import javax.swing.JComponent;

import model.Elem;

/**
 * Komponensgyártók közös ősosztálya.
 * @author zsigatibor
 *
 */
public interface Factory {
	public JComponent ComponentFactory(Elem e);
}
