package projlab2;
import java.util.*;

/**
 * 
 */
public class Labirintus {

    /**
     * Default constructor
     */
    public Labirintus() {
    }

    /**
     * 
     */
    private int osszZPM;

    /**
     * 
     */
    private Vektor KezdoPont;

    /**
     * 
     */
    private Elem VegeElem;



    /**
     * 
     */
    private ArrayList<Elem> list;
    
    /**
     * 
     */
    private ArrayList<Moveable> moveableList;
    
    /**
     * 
     */
    public void labirintus() {
        // TODO implement here
    }

    /**
     * @param kar
     */
    public void addKar(Karakter kar) {
        // TODO implement here
    }

    /**
     * @param param
     */
    public void addElem(Elem param) {
        // TODO implement here
    }

    /**
     * @param param
     */
    public void removeElem(Elem param) {
        // TODO implement here
    }

    /**
     * @param ter 
     * @return
     */
    public Elem whatsThere(Terulet ter) {
        // TODO térjen vissza SET-tel!
        return null;
    }

    /**
     * @return
     */
    public int getZPM() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public Elem getVegeElem() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Vektor getKezdoPont() {
        // TODO implement here
        return null;
    }
    
    public void addMoveable(Moveable x) {
    	moveableList.add(x);
    }

}