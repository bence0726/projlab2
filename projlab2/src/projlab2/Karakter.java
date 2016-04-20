package projlab2;
import java.io.File;
import java.util.*;

/**
 * 
 */
public class Karakter implements Moveable {
    /**
     * 
     */
    private int ZPM;

    /**
     * 
     */
    private int PickRange;

    /**
     * 
     */
    private Elem box;

    /**
     * 
     */
    private Vektor fegyverirany;






    /**
     * 
     */
    private Labirintus lab;

    /**
     * @param lab 
     * @param img
     */
    public Karakter(Labirintus lab, File img) {
        // TODO implement here
    }

    /**
     * Amikor felveszünk egy ZPM-et, a ZPM ezt a metódust hívja meg.
     * Növeli a karakter ZPM-számlálóját.
     */
    public void addZPM() {
        ZPM++;
    }

    /**
     * @return
     */
    public int getZPM() {
        // TODO implement here
        return 0;
    }

    /**
     * 
     */
    public void changeBoxVal() {
        // TODO implement here
    }

    /**
     * @param dir
     */
    public void Pick(Vektor dir) {
        // TODO implement here
    }

    /**
     * @param dir
     */
    public void Drop(Vektor dir) {
        // TODO implement here
    }

    /**
     * @param szin
     */
    public void Fire(Szin szin) {
        // TODO implement here
    	lab.addMoveable(new Golyo());
    }

    /**
     * @param double Szog
     */
    public void changeFegyverirany(double Szog) {
        // TODO implement here
    }

    /**
     * @param dir
     */
    public void move(Vektor dir) {
        // TODO implement here
    }

}