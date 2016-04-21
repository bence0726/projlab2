package projlab2;
import java.util.*;

/**
 * 
 */
public class Terulet {

    /**
     * Default constructor
     */
	
    public Terulet() {
    }

    /**
     * 
     */
    
    private Vektor kezd;

    /**
     * 
     */
    private Vektor veg;



    /**
     * TODO: új terület létrehozásakor nem lenne elég
     * egy kezdőpozíció? A 
     * @param k 
     * @param v
     */
    public Terulet(Vektor k, Vektor v) {
        // TODO implement here
    	kezd = k;
    	veg = v;
    }

    /**
     * A kezdőponthoz hozzáadja a kapott vektort.
     * TODO: Biztos jó ez?
     * @param val
     */
    public void setKezd(Vektor val) {
    	kezd.setVx(kezd.getVx()+val.getVx());
    	kezd.setVy(kezd.getVy()+val.getVy());
    }

    /**
     * @return
     */
    public Vektor getKezd() {
        return new Vektor(kezd.getVx(),kezd.getVy());
    }

    /**
     * @param val
     */
    public void setVeg(Vektor val) {
    	veg.setVx(veg.getVx()+val.getVx());
    	veg.setVy(veg.getVy()+val.getVy());
    }

    /**
     * @return
     */
    public Vektor getVeg() {
        return new Vektor(veg.getVx(),veg.getVy());
    }
    
    /**
     * TODO: meg kell valósítani!
     */
    public Terulet randomArea(Vektor size){
    	return new Terulet();
    }
}