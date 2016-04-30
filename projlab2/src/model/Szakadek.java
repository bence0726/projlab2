package model;

/**
 * 
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
    
    /**
     * Megöli az elemet ami rálép.
     * @param e
     */
    public boolean steppedon(Moveable m) {
        m.kill(this);
        return true;
    }
    public boolean isAccessable(){
    	return true;
    }
    

}