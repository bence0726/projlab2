/**
 * 
 */
package model;

/**
 * A labirintus befejező elemét reprezentáló osztály.
 * Plusz funkciója nincs a falhoz képest, de a GUI
 * factory osztályainak fontos, hogy ez egy külön típus legyen.
 * 
 * @author zsigatibor
 */
public class EndElem extends Fal {
	public EndElem(Terulet area) {
		super(area);		
	}
	public EndElem(Vektor locUpLeftCorner, Vektor diagonal) {
		super(locUpLeftCorner, diagonal);
	}
}