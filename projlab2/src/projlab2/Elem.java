package projlab2;
import java.io.File;
import java.util.*;

import javafx.scene.control.Alert;

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
     * Él az elem? Ha igen, true, egyébként false.
     */
    protected boolean alive = true;
    /**
     * 
     */
    protected File image;

    /**
     * 
     */
    protected int suly = 0;


    /**
     * 
     */
    protected Terulet pos;

    /**
     * Az elemet a megadott vektorral eltolja.
     * TODO: have a fresh look!
     * @param dir
     */
    public void elemShiftWithVec(Vektor dirVec) {
    	pos.addDirToArea(dirVec);
	}


    /**
     * @return
     */
    public Terulet getPos() {
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
        return image;
    }

    /**
     * @param e
     */
    public void steppedon(Moveable x) {
       //return egyből, nem lépünk ide.
    }

    
    /**
     * Elegánsan false-ra állítja az alive flag-jét.
     */
    public void kill(){
    	alive = false;
    }

    /**
     * 
     */
    public int getSuly() {
    	return suly;
    }

    /**
     * 
     */
    public void picked(Karakter k) {
    }


    /**
     * Default implementációjában továbbengedi a golyót.
     * 
     */
    public void shot(Golyo bullet) {
		bullet.step();
	}

    /**
     * Alap implementációjában nem csinál semmit.
     * Ha igen, alosztályban specifikáljuk.
     */
    public void steppedoff(Moveable x) {
	}
	public boolean isAlive(){
		return alive;
	}
}