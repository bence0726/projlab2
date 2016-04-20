package projlab2;
import java.io.File;
import java.util.*;

/**
 * 
 */
public class Elem implements Interakcio {

    /**
     * Default constructor
     */
    public Elem() {
    }

    /**
     * 
     */
    private File image;

    /**
     * 
     */
    private int suly;


    /**
     * 
     */
    private Terulet pos;

    public void setPos(Terulet pos) {
		this.pos = pos;
	}

	/**
     * @param val
     */
    public void setReachable(boolean val) {
        // TODO implement here
    }

    /**
     * @return
     */
    public boolean getReachable() {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public Terulet getPos() {
        // TODO implement here
        return null;
    }

    /**
     * @param val
     */
    public void setImage(File val) {
        // TODO implement here
    }

    /**
     * @return
     */
    public File getImage() {
        // TODO implement here
        return null;
    }

    /**
     * @param e
     */
    public void steppedon(Elem e) {
        // TODO implement here
    }

    /**
     * 
     */
    public void steppedoff() {
        // TODO implement here
    }

    /**
     * 
     */
    public void kill() {
        // TODO implement here
    }

    /**
     * @param bullet
     */
    public void shot(Elem bullet) {
        // TODO implement here
    }

    /**
     * 
     */
    public void getSuly() {
        // TODO implement here
    }

    /**
     * 
     */
    public void picked(Karakter k) {
        // TODO implement here
    }
}