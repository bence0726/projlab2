package model;

/**
 * Az összes objektum ebből a közös ősből származik.
 * Az Interakcio interfész metódusaira ad egy alap
 * implementációt, ezáltal a kódduplikációt el tudtuk
 * kerülni nagyon sok helyen. A játék különböző
 * elemei ebből származnak és igény szerint felülírják
 * ezen függvényeket.
 */
public abstract class Elem implements Interakcio {

	 /**
     * Él az elem? Ha igen, true, egyébként false.
     */
    protected boolean alive = true;
    
    /**
     * Az elem pozíciója.
     */
    protected Terulet pos;
    
    /**
     * Az elem basic mérete.
     */
    protected Vektor defaultsize = new Vektor(10,10);
    		
    /**
     * Adott területen létrehoz egy elemet.
     */
    public Elem(Terulet pos) {
    	this.pos = pos;
    }
    
    /**
     * Létrehoz egy elemet, a bal felső sarkát locUpLeftCorner
     * vektorra illesztve. A második paraméter az elem mérete.
     * @param locUpLeftCorner
     * @param diagonal
     */
    public Elem(Vektor locUpLeftCorner,Vektor diagonal){
    	pos = new Terulet();
    	pos.setKezd(new Vektor(locUpLeftCorner));
    	pos.setVeg(Vektor.addVecToVec(locUpLeftCorner, diagonal));
    }
    
    public Elem(){}
    
    /**
     * Az elemet a megadott vektorral eltolja.
     * TODO: have a fresh look!
     * @param dir
     */
    public void elemShiftWithVec(Vektor dirVec) {
    	pos.addDirToArea(dirVec);
	}
    
    /**
     * A paraméterül kapott vektorhoz illeszti az elem
     * bal felső sarkát.
     */
    public void newLocationByCorner(Vektor locUpLeftCorner){
    	pos.setNewCornerLocation(locUpLeftCorner);
    }
    
    /**
     * A paraméterül kapott vektorhoz illeszti az elem
     * közepét.
     */
    public void newLocationByMiddle(Vektor locMiddleofArea){
    	pos.setNewCornerLocation(locMiddleofArea);
    }
    
    /**
     * Megvizsgálja, hogy a paraméterül kapott objektum
     * takarásban van-e a hívó objektummal.
     * @param e - amivel összehasonlítjuk
     * @return true - ha takarásban, fedésben vannak.
     */
    public boolean isCoveredByThis(Elem e){
    	return this.pos.isCoveredBy(e.pos);
    }
        
    public boolean steppedon(Moveable x) {
    	return false;
    }
    public void steppedoff(Moveable x) {
	//Alap implementációjában nem csinál semmit.
    //Ha igen, alosztályban specifikáljuk.
    }
  
    public void kill(Elem e){
    	alive = false;
    }

    public boolean picked(Karakter k) {
    //Alap implementációban nem történik semmi ha fel akarjuk venni,
    //így false értéket ad vissza (nem történt felvétel)
    	return false;
    }
         
    public void shot(Golyo bullet) {
		bullet.step();//Default implementációjában továbbengedi a golyót.
	}
    
    /**
     * Megadja, hogy az objektum él-e még.
     * @return true - ha még él
     * @return false - egyébként
     */
	public boolean isAlive(){
		return alive;
	}	
	
	public boolean isAccessable(){
		return false;
	}
	
	/**
     * @return pos - az a terület, amelyet az objektum lefed.
     */
    public Terulet getPos() {
        return pos;
    }
}