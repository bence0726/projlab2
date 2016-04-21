package projlab2;
import java.util.*;

/**
 * 
 */
public class Golyo extends Moveable {

    /**
     * Default constructor
     */
	
	Vektor dir;
    public Golyo(Vektor dir,Terulet area) {
    	super(area);
    	this.dir = dir;
    }

    /**
     * 
     */
    private Szin szin;

    /**
     * @param dir
     */
    public void move(Vektor dir) {
    	/*
    	 * Magyarázat
    	 * Kicsit egyszerűbb, mint a karakter és a replikátor mozgása.
    	 * megnézzük, hogy ahová lépnénk, van-e ott valami, és amik ott vannak
    	 * azok közül az első olyan elemen, ami nem a golyó maga, azon
    	 * meghívjuk a shot függvényt.
    	 */
    	Terulet t = new Terulet(this.pos.getKezd(),this.pos.getVeg());
    	t.setKezd(moveDir);
    	t.setVeg(moveDir);
    	    	
    	
    	Set<Elem> itemsThere = lab.whatsThere(t);		//ahová lépünk, ott ezek vannak
    	
    	if(itemsThere.size() == 0)						//ha nincs ott semmi...
    		step();										//...lépés    		    		
    	    	
    	Iterator<Elem> iteratorThere = itemsThere.iterator();
    	
    	while(iteratorThere.hasNext()){
    		Elem temp = iteratorThere.next();
    		if(temp != this){							//magát nem lövi meg a golyó
    			shot(this);
    			return;									//csak egyvalamit találunk el vele
    		}    			
    	}   	
    }    
}