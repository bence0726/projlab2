/**
 * 
 */
package model;

/**
 * Ajtót reprezentáló osztály.
 * Plusz funkciója nincs a falhoz képest, de a GUI
 * factory osztályainak fontos, hogy ez egy külön típus legyen.
 * 
 * @author zsigatibor
 */
public class Ajto extends Fal {
	public Ajto(Terulet area) {
		super(area);
	}
	public Ajto(Vektor locUpLeftCorner, Vektor diagonal) {
		super(locUpLeftCorner, diagonal);
	}
}