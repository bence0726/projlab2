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
    	image = "szakadek.jpg";
    	name="szakadék";
    }
    
    /**
     * Létrehoz egy szakadékot, a bal felső sarkát locUpLeftCorner
     * vektorra illesztve. A második paraméter az elem mérete.
     * @param locUpLeftCorner
     * @param diagonal
     */
    public Szakadek(Vektor locUpLeftCorner,Vektor diagonal) {
    	super(locUpLeftCorner,diagonal);
    	image = "szakadek.jpg";
    	name="szakadék";
    }
    
    /**
     * Megöli az elemet ami rálép.
     * @param e
     */
    public void steppedon(Moveable m) {
        m.kill();
    }
    

}