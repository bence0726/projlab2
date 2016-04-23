package projlab2;
import java.util.*;

/**
 * 
 */
public class Merleg extends Elem {

    /**
     * Ezt itt ki kéne törölni
     */
    public Merleg(Terulet area) {
    	super(area);
    }

    /**
     * 
     */
    private boolean aktiv;        //Szerintem ez nem kell

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
     * @param E 
     * @param ajto
     */
    public Merleg(Fal ajto,Terulet area) {
        super(area);
        this.ajto = ajto;
    }

    /**
     * Szerintem ez már nem kell.
     */
    public void deActivate() {     //Szerintem ez nem kell
        // TODO implement here
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