package projlab2;
import java.util.*;

/**
 * 
 */
public class Elem implements Interakcio {

	public Elem(){}
	
    /**
     * Adott területen létrehoz egy elemet.
     */
    public Elem(Terulet pos) {
    	this.pos.setKezd(pos.getKezd());
    	this.pos.setVeg(pos.getVeg());
    }
    
    /**
     * Adott helyre(bal felső sarkát illesztve), 
     * default mérettel létrehoz egy elemet
     * @param locUpLeftCorner
     * @param diagonal
     */
    public Elem(Vektor locUpLeftCorner){
    	Vektor diagonal = defaultsize;
    	pos.setKezd(locUpLeftCorner);
    	pos.setVeg(Vektor.addVecToVec(locUpLeftCorner, diagonal));
    }
    
    
    
    /**
     * Létrehoz egy elemet, a bal felső sarkát locUpLeftCorner
     * vektorra illesztve. A második paraméter az elem mérete.
     * @param locUpLeftCorner
     * @param diagonal
     */
    public Elem(Vektor locUpLeftCorner,Vektor diagonal){
    	pos.setKezd(locUpLeftCorner);
    	pos.setVeg(Vektor.addVecToVec(locUpLeftCorner, diagonal));
    }
    
    /**
     * Él az elem? Ha igen, true, egyébként false.
     */
    protected boolean alive = true;
    /**
     * 
     */
    protected String image = "";

    /**
     * 
     */
    protected Terulet pos;
    
    protected Vektor defaultsize = new Vektor(10,10);

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
     * @param locUpLeftCorner
     */
    public void newLocationByCorner(Vektor locUpLeftCorner){
    	pos.setNewCornerLocation(locUpLeftCorner);
    }
    
    /**
     * A paraméterül kapott vektorhoz illeszti az elem
     * közepét.
     * @param locUpLeftCorner
     */
    public void newLocationByMiddle(Vektor locMiddleofArea){
    	pos.setNewCornerLocation(locMiddleofArea);
    }
    
    public boolean isCoveredByThis(Elem e){
    	return this.pos.isCoveredBy(e.pos);
    }


    /**
     * @return pos - az a terület, amelyet az objektum lefed.
     */
    public Terulet getPos() {
        return pos;
    }

    /**
     * @return
     */
    public String getImage() {
        return image;
    }

    /**
     * @param e
     */
    public void steppedon(Moveable x) {
       //return egyből, nem lépünk ide.
    }
  
    public void kill(){
    	alive = false;
    }

    /**
     * Alap implementációban nem történik semmi, ha fel akarjuk venni,
     * így false értéket ad vissza (nem történt felvétel)
     */
    public boolean picked(Karakter k) {
    	return false;
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