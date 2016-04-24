package projlab2;

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
    }
    
    /**
     * Megöli az elemet ami rálép.
     * @param e
     */
    public void steppedon(Moveable m) {
        m.kill();
    }
    

}