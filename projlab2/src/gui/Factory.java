package gui;

import java.awt.Component;

import model.Elem;

/**
 * Komponensgyártók közös ősosztálya.
 * @author zsigatibor
 *
 */
public interface Factory {
	public Component ComponentFactory(Elem e);
}
