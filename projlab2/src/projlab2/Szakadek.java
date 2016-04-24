package projlab2;
import java.util.*;

/**
 * 
 */
public class Szakadek extends Elem {

    /**
     * Default constructor
     */
    public Szakadek(Terulet area) {
    	super(area);
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