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
    public Elem(Terulet pos) {
    	this.pos.setKezd(pos.getKezd());
    	this.pos.setVeg(pos.getVeg());
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

    public void setPos(Vektor dir) {
		pos.setKezd(dir);
		pos.setVeg(dir);
	}


    /**
     * @return
     */
    public Terulet getPos() {
        // TODO implement here
        return pos;
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