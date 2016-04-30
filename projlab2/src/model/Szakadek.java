package model;

/**
 * A szakadék modellbeli reprezentációja.
 */
public class Szakadek extends Elem {
    /**
     * A megadott területre létrejön egy szakadék elem.
     */
    public Szakadek(Terulet area) {
    	super(area);
    }
    
    /**
     * Létrehoz egy szakadékot, a bal felső sarkát locUpLeftCorner
     * vektorra illesztve. A második paraméter az elem mérete.
     * @param locUpLeftCorner
     * @param diagonal
     */
    public Szakadek(Vektor locUpLeftCorner,Vektor diagonal) {
    	super(locUpLeftCorner,diagonal);
    }

    public boolean steppedon(Moveable m) {
        m.kill(this);//Megöli az elemet ami rálép.
        return true;
    }
    public boolean isAccessable(){
    	return true;
    }
}