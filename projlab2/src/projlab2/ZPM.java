package projlab2;
import java.util.*;

/**
 * 
 */
public class ZPM extends Elem {

    /**
     * Default constructor
     */
    public ZPM(Terulet area) {
    	super(area);
    }

    /**
     * Növeli egyel a karakter ZPM számlálóját,
     * majd megöli magát.
     * @param k - a karakter, aki felveszi
     * @return true - mert történt felvétel
     */
    public boolean picked(Karakter k) {
        k.addZPM();
        this.kill();
        return true;
    }

}