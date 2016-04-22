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
     * 
     * @param vecKezd :A terület bal felső sarka 
     * @param vecVeg :A terület jobb also sarka
     */
    public Terulet(Vektor vecKezd, Vektor vecVeg) {
        // TODO implement here
    	kezd = vecKezd;
    	veg = vecVeg;
    }
    
    /**
     * A megadott mapon belülre véletlenszerű helyre generál
     * egy területet a megadott mérettel.
     * @param size :size of the object
     * @param mapsize : size of the map
     */
    public Terulet randomArea(Vektor size,int mapsize){
    	Random rand = new Random();
    	Vektor vecKezd = new Vektor(rand.nextInt(mapsize-1)+1,rand.nextInt(mapsize-1)+1) ; //bal felső sarok random helyre
    	Vektor vecVeg = new Vektor(vecKezd); // A jobb also sarok 
    	vecVeg.addVec(size);
    	Terulet t = new Terulet(vecKezd,vecVeg); 
    	while (this.isCoveredBy(t)) {
    		vecKezd.setVx(rand.nextInt(mapsize-1)+1);
    		vecKezd.setVy(rand.nextInt(mapsize-1)+1);
    		vecVeg.beEqual(vecKezd);
    		vecVeg.addVec(size);
    	}
    	return t;
    }
    /**
     * Megnézi, hogy a kapott terület (T2) fedésben van-e
     * azzal a területtel(T1) ami hívta a függvényt.
     * @param t : A terulet amivel a fedést vizsgáljuk
     * @return
     */
    public boolean isCoveredBy(Terulet t){
    	if (this.kezd.getVx() < t.veg.getVx() && 
    		this.veg.getVx() > t.kezd.getVx() &&
    		this.kezd.getVy() < t.veg.getVy() &&
    		this.veg.getVy() > t.kezd.getVy() )
    		return true;
    			
    	return false;
    }
    
    public Vektor getMiddleOfArea(Terulet t){
    	return new Vektor();
    }

    
    /**
     * A kezdő és végponthoz hozzáadja a kapott irányvektort,
     * így eltolva azt a vektor irányába.
     * @param dirVec : A vektor amivel eltoljuk a területet
     */
    public void addDirToArea(Vektor dirVec) {
    	this.kezd.addVec(dirVec);
    	this.veg.addVec(dirVec);
	}

    
    /**
     * Beállítja a terület kezdopontjába mutató vektort.
     * @param val
     */
    public void setKezd(Vektor vec) { 
    	kezd=vec;
    }
    
    
    /**
     * Beállítja a terület végpontjába mutató vektort.
     * @param vec
     */
    public void setVeg(Vektor vec) {
    	veg=vec;
    }
    
    /**
     * @return
     */
    public Vektor getKezd() {
        return kezd;
    }
    

    /**
     * @return
     */
    public Vektor getVeg() {
        return veg;
    }
    
    
    
    
}