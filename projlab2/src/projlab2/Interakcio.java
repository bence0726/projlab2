package projlab2;
import java.util.*;

/**
 * 
 */
public interface Interakcio {

    /**
     * @param bullet
     */
    public void shot(Golyo bullet);

    /**
     * @param e
     */
    public void steppedon(Elem e);

    /**
     * 
     */
    public void picked(Karakter k);

    /**
     * 
     */
    public void steppedoff(Elem e);

    public void kill();
}