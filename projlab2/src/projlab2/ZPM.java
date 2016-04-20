package projlab2;
import java.util.*;

/**
 * 
 */
public class ZPM extends Elem {

    /**
     * Default constructor
     */
    public ZPM() {
    }

    /**
     * @param e
     */
    public void picked(Karakter k) {
        k.addZPM();
        this.kill();        
    }

}