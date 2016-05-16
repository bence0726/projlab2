/**
 * 
 */
package model;

/**
 * A labirintus indulási pontját reprezentáló osztály.
 * Plusz funkciója nincs a falhoz képest, de a GUI
 * factory osztályainak fontos, hogy ez egy külön típus legyen.
 * 
 * @author zsigatibor
 */
public class StartElem extends Fal {
	public StartElem(Terulet area) {
		super(area);
	}
	public StartElem(Vektor locUpLeftCorner, Vektor diagonal) {
		super(locUpLeftCorner, diagonal);
	}
}