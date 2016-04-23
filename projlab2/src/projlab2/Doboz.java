package projlab2;
import java.util.*;

/**
 * 
 */
public class Doboz extends Moveable {

    /**
     * Default constructor
     */
    public Doboz(Terulet area) {
    	super(area);
    }

    /**
     * 
     */
    public void shot() {
        // ide nem kerül semmi, hacsaknem a doboz megállítja a lövedéket
    }

    /**
     * Ha a karakter felveszi, hozzáadja
     * magát a karakterhez.
     */
    public void picked(Karakter k) {
        k.addBox(this);
    }

}