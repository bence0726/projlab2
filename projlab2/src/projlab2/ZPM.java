package projlab2;
import java.util.*;

/**
 * 
 */
public class ZPM extends Elem {

    /**
     * A megadott területre létrejön egy ZPM elem.
     */
    public ZPM(Terulet area) {
    	super(area);
    	image = "zpm";
    }
    
    /**
     * Létrehoz egy ZPM-t, a bal felső sarkát locUpLeftCorner
     * vektorra illesztve. A második paraméter az elem mérete.
     * @param locUpLeftCorner
     * @param diagonal
     */
    public ZPM(Vektor locUpLeftCorner,Vektor diagonal) {
    	super(locUpLeftCorner,diagonal);
    	image = "zpm.jpg";
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