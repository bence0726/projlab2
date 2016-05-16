package model;

/**
 * Ebben az osztályban található a mérleg 
 * modellbeli reprezentációja.
 */
public class Merleg extends Elem {

	/**
     * Tárol egy referenciát a hozzá tartozó ajtóra.
     */
    private Fal ajto;

    /**
     * A mérlegen lévő súly ennyi.
     */    
    public int massOnTheScale = 0;
    
    /**
     * A limit, ami felett az ajtó kinyílik.
     */    
    private int massLimit = 100;
    
    /**
     * A megadott területre létrejön egy mérleg elem.
     */
    public Merleg(Terulet area,Fal ajto, int masslimit) {
    	super(area);
    	massLimit = masslimit;
    	this.ajto = ajto;
    }
    
    /**
     * Létrehoz egy mérleget, a bal felső sarkát locUpLeftCorner
     * vektorra illesztve. A második paraméter megadja, hogy
     * a jobb alsó sarok a bal felsőhöz képest mennyivel van eltolva.
     * Kötelező összekapcsolni egy ajtóval amit nyit.
     */
    public Merleg(Vektor locUpLeftCorner,Vektor diagonal,Fal ajto, int limit) {
    	super(locUpLeftCorner,diagonal);
    	this.ajto = ajto;
    	massLimit = limit;
    }

    /**
     * Rélépés a mérlegre.
     */
    public boolean steppedon(Moveable m) {
    	massOnTheScale+=m.getSuly();
    	if (massOnTheScale >= massLimit)
    		ajto.setReachable(true);
    		//isChanged = true;
    	return true;
    }
    
    /**
     * Lelépés a mérlegről
     */
    public void steppedoff(Moveable m){
    	massOnTheScale -= m.getSuly();
    	if (massOnTheScale < massLimit){
    		ajto.setReachable(false);
    		//isChanged = true;
    	}
    }
    
    public boolean isAccessable(){
    	return true;
    }
}