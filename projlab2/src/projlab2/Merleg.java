package projlab2;

/**
 * 
 */
public class Merleg extends Elem {

	/**
     * 
     */
    private Fal ajto;

    /**
     * A mérlegen lévő súly.
     */    
    public int massOnTheScale;
    
    /**
     * A limit ami felett az ajtó kinyílik.
     */    
    private int massLimit= 100;
    
    /**
     * A megadott területre létrejön egy mérleg elem.
     */
    public Merleg(Terulet area,Fal ajto) {
    	super(area);
    	this.ajto = ajto;
    	image = "merleg.jpg";
    }
    
    /**
     * Létrehoz egy mérleget, a bal felső sarkát locUpLeftCorner
     * vektorra illesztve. A második paraméter az elem mérete.
     * Kötelező összekapcsolni egy ajtóval amit nyit.
     * @param locUpLeftCorner
     * @param diagonal
     * @param ajto
     */
    public Merleg(Vektor locUpLeftCorner,Vektor diagonal,Fal ajto) {
    	super(locUpLeftCorner,diagonal);
    	this.ajto = ajto;
    	image = "merleg.jpg";
    }

    /**
     * Rélépés a mérlegre.
     * @param m :Moveable
     */
    public void steppedon(Moveable m) {
    	massOnTheScale+=m.getSuly();
    	if (massOnTheScale >= massLimit)
    		ajto.setReachable(true);
    }
    /**
     * Lelépés a mérlegről
     * @param m :Moveable
     */
    public void steppedoff(Moveable m){
    	massOnTheScale-=m.getSuly();
    	if (massOnTheScale < massLimit)
    		ajto.setReachable(false);
    }

}