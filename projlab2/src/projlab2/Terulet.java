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
    	Vektor vecVeg = new Vektor(vecKezd); // A jobb also sarok létrehozasa vecKezd koordinatakkal
    	vecVeg.addVec(size); // hozzáadjuk a méretét , átló vektor
    	Terulet t = new Terulet(vecKezd,vecVeg); //létrehozzuk a 2 vektorból a területet
    	return t; //visszatérünk vele.
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
    
    /**
     * Visszatér a Terulet átlójával.
     * Ami a bal felső sarokból mutat a jobb alsóba.
     * @return
     */
    private Vektor getDiagonal(){
    	Vektor temp = new Vektor(veg);
    	temp.subVec(kezd);
    	return temp;
    }
    
    /**
     * Visszatér egy helyvektorral mely a Terület középpontjába mutat.
     * @return
     */
    public Vektor getMiddleOfArea(){
    	Vektor temp = new Vektor(this.getDiagonal()); //lekérdezzük a terület átlóját
    	temp.setVx(temp.getVx()/2);  //elfelezzük
    	temp.setVy(temp.getVy()/2);
    	temp.addVec(kezd); //hozzáadjuka  kezdőhöz
    	return temp;
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
     * A paraméterül kapott vektorhoz illeszti a terület
     * bal felső sarkát.
     * @param vec
     */
    public void setNewCornerLocation(Vektor vec){
    	Vektor temp=this.getDiagonal(); //Lekérdezzük az átlóját
    	kezd = vec; // a bal felső sarkat beallitjuk oda ahova mutatunk
    	temp.addVec(kezd); //összeadjuk a kezdopont helyvektrát az átlóval
    	veg=temp; //ezt a vektort beállítjuk a jobb also saroknak.
    }
    /**
     * A paraméterül kapott vektorhoz illeszti a terület
     * közepét
     * @param vec
     */
    public void setNewMiddleLocation(Vektor middle){
    	Vektor temp = new Vektor(this.getDiagonal()); //lekérdezzük at átlóját
    	temp.setVx(temp.getVx()/2);  //elfelezzük
    	temp.setVy(temp.getVy()/2);
    	veg = veg.addVecToVec(middle, temp); //összadjuk a közép vektort és az átló felét
    	temp.inverseVec(); //megforditjuk az átló felét hogy a középpontból a bal felső sarokba mutasson
    	kezd = kezd.addVecToVec(middle, temp); //összeadjuk(az inverz miatt lényegében kivonjuk) a
    										   //középből az átló felének forditottját
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