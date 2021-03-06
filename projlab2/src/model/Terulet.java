package model;
import java.util.*;

/**
 * Ez az osztály segít az elemek területének,
 *  pozíciójának menedzselésében.
 */
public class Terulet {

	/**
	 * bal felső sarka
	 */
	private Vektor kezd = new Vektor(0,0);//alap inicializálások nullptrexception elkerülése végett
	/**
	 * jobb alsó sarka
	 */
    private Vektor veg = new Vektor(0,0);
    
    /**
     * Default, param nélküli constructor
     */	
    public Terulet() {}
    
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
    	Vektor vecKezd = new Vektor(rand.nextInt(mapsize+1),rand.nextInt(mapsize+1)) ; 	//bal felső sarok random helyre
    	Vektor vecVeg = new Vektor(vecKezd); 											// A jobb also sarok létrehozasa vecKezd koordinatakkal
    	vecVeg.addVec(size); 															// hozzáadjuk a méretét , átló vektor
    	this.setKezd(vecKezd);
    	this.setVeg(vecVeg);															//FIXME visszatérés mellett ennek is be kell állítani mert nem a visszatérési értéket használtuk
    	return this;
    }
    /**
     * Megnézi, hogy a kapott terület (T2) fedésben van-e
     * azzal a területtel(T1) ami hívta a függvényt.
     * @param t : A terulet amivel a fedést vizsgáljuk
     * @return true, ha fedésben vannak.
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
     */
    public Vektor getDiagonal(){
    	Vektor temp = new Vektor(veg);
    	temp.subVec(kezd);
    	return temp;
    }
    
    /**
     * Visszatér egy helyvektorral mely a Terület középpontjába mutat.
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
    	kezd.addVec(dirVec);
    	veg.addVec(dirVec);
	}
    
    /**
     * A paraméterül kapott vektorhoz illeszti a terület
     * bal felső sarkát.
     * @param vec
     */
    public void setNewCornerLocation(Vektor vec){
    	Vektor temp=this.getDiagonal();	//Lekérdezzük az átlóját
    	kezd = vec; 					// a bal felső sarkat beallitjuk oda ahova mutatunk
    	temp.addVec(kezd); 				//összeadjuk a kezdopont helyvektrát az átlóval
    	veg=temp; 						//ezt a vektort beállítjuk a jobb also saroknak.
    }
    
    /**
     * A paraméterül kapott vektorhoz illeszti
     *  a terület közepét.
     */
    public void setNewMiddleLocation(Vektor middle){
    	Vektor temp = new Vektor(this.getDiagonal()); 	//lekérdezzük at átlóját
    	temp.setVx(temp.getVx()/2);  					//elfelezzük
    	temp.setVy(temp.getVy()/2);
    	veg = Vektor.addVecToVec(middle, temp); 		//összadjuk a közép vektort és az átló felét
    	temp.invertThisVec(); 							//megforditjuk az átló felét hogy a középpontból a bal felső sarokba mutasson
    	kezd = Vektor.addVecToVec(middle, temp);		//összeadjuk(az inverz miatt lényegében kivonjuk) a
    										   			//középből az átló felének forditottját
    }
    
    /**
     * Megadja, hogy a hívó objektum megegyezik-e
     * a paraméterül kapott területtel
     * @return true, ha a kezdő- és végkoordináták megegyeznek.
     */
    public boolean isEqualTo(Terulet t){
    	return ((this.kezd.isEqualTo(t.getKezd())) && (this.veg.isEqualTo(t.getVeg())));	
    }
    
    /**
     * Megadja a terület magasságát.
     */
    public double getHeight(){
    	return this.getVeg().getVy() - this.getKezd().getVy();
    }
    /**
     * Megadja a terület szélességét.
     */
    public double getWidth(){
    	return this.getVeg().getVx() - this.getKezd().getVx();
    }
    
    /**
     * Beállítja a terület kezdőpontjába mutató helyvektort.
     */
    public void setKezd(Vektor vec) { 
    	kezd=vec;
    }
    
    /**
     * Beállítja a terület végpontjába mutató helyvektort.
     */
    public void setVeg(Vektor vec) {
    	veg=vec;
    }
   
    public Vektor getKezd() {
        return kezd;
    }
    
    public Vektor getVeg() {
        return veg;
    }    
}