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
    public void steppedon(Moveable x);

    /**
     * 
     */
    public void picked(Karakter k);

    /**
     * 
     */
    public void steppedoff(Moveable x);

    public void kill();
}