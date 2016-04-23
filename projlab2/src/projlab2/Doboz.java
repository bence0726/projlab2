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
     * Ha a karakter felveszi, hozzáadja
     * magát a karakterhez.
     */
    public void picked(Karakter k) {
    	this.kill();  //meg kell ölni, hogy  alabirintusbol kikerüljön és igy ne rajzolja fel a pályára
        k.addBox(this);
    }
}