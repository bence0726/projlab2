
import java.util.*;

/**
 * 
 */
public interface Interakcio {

    /**
     * @param bullet
     */
    public void shot(Elem bullet);

    /**
     * @param e
     */
    public void steppedon(Elem e);

    /**
     * 
     */
    public void picked();

    /**
     * 
     */
    public void steppedoff();

}