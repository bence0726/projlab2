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
    private boolean aktiv;

    /**
     * 
     */
    private Fal ajto;

    /**
     * 
     */
    public int sulyRajta;


    /**
     * @param E 
     * @param ajto
     */
    public Merleg(Elem ajto,Terulet area) {
        super(area);
    }

    /**
     * 
     */
    public void deActivate() {
        // TODO implement here
    }

    /**
     * @param e
     */
    public void steppedon(Elem e) {
        // TODO implement here
    }

}