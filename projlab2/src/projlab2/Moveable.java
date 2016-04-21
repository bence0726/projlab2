package projlab2;
import java.util.*;

/**
 * 
 */
public abstract class Moveable extends Elem{
    protected Vektor moveDir;
    protected Labirintus lab ;
    
	public Moveable(Terulet pos) {
		super(pos);
		// TODO Auto-generated constructor stub
	}

	/**
     * @param dir
     */
    public void move() {
    	/*
    	 * Magyarázat
    	 * MEgnézzük, hogy ahol állunk ott mi van. (Set A)
    	 * Utána megnézzük,hogy ahova menni akarunk ott mi van. (Set B)
    	 * Azokra az elemekre hivjuk a steppedon-t ahová lépni fogunk
    	 * Miután ezek léptettek(avagy nem) , megint megnézzük, hogy hol vagyunk (Set C)
    	 * Ezután összehasonlítjuk A-t és C-t , ami nincs benn C-ben arra hívjuk a steppedoff-ot.
    	 */
    	Terulet t = new Terulet(this.pos.getKezd(),this.pos.getVeg());
    	t.setKezd(moveDir);
    	t.setVeg(moveDir);
    	    	
    	Set<Elem> itemsHere = lab.whatsThere(this.pos); //lépés előtt itt állunk
    	Set<Elem> itemsThere = lab.whatsThere(t);		//ahová lépünk, ott ezek vannak
    	
    	Iterator<Elem> iteratorHere = itemsHere.iterator();
    	
    	if(itemsThere.size() == 0){						//ha nincs ott semmi...
    		step();										//lépés
    		
    		if(itemsHere.size() != 0){
    			Set<Elem> itemsNewPlace = lab.whatsThere(this.pos);//megnézzük, kimindenkin vagyunk rajta most    			
    			while(iteratorHere.hasNext()){
    	    		Elem temp = iteratorHere.next();
    	    		if(!itemsNewPlace.contains(temp))
    	    			temp.steppedoff(this);					//ami nincs benne, arról leléptünk
    	    	}
    		}
    		return;
    	}    	
    	Iterator<Elem> iteratorThere = itemsThere.iterator();
    	
    	while(iteratorThere.hasNext()){
    		iteratorThere.next().steppedon(this);
    	}
    	
    	Set<Elem> itemsNewPlace = lab.whatsThere(this.pos);
    	
    	while(iteratorHere.hasNext()){
    		Elem temp = iteratorHere.next();
    		if(!itemsNewPlace.contains(temp))
    			temp.steppedoff(this);					//ami nincs benne, arról leléptünk
    	}    	
	}
    
    /**
     * Továbblépés.
     */
    public void step(){
    	addDirToArea(moveDir);
    }
    
    /**
     * TODO: a dir-ből csináljon irányvektort!!
     * @param dir
     */
    public void setDir(Vektor dir){
    	moveDir = dir;
    }
    /**
     * Leszedi az objektumot a mapról.
     * Ehhez le kell szedni a moveableListről
     * és az elemek listájáról is.
     */
    public void kill(){
    	lab.removeElem(this);
    	lab.removeMoveable(this);
    }
}