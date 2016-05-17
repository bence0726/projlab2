package model;
import java.util.*;

/**
 * A lövedék modellbeli reprezentációjáért
 * felelős osztály.
 */
public class Golyo extends Moveable {
	/**
    * A golyó színe
    */
    private Szin colour;
        
    public Golyo(Labirintus lab, Vektor middleofArea, Vektor direction,Szin color){
    	super(lab,middleofArea);
    	colour = color;
    	moveDir = new Vektor(direction);
    }
    
	public void move() {
    	/*
    	 * Magyarázat
    	 * Kicsit egyszerűbb, mint a karakter és a replikátor mozgása.
    	 * megnézzük, hogy ahová lépnénk, van-e ott valami, és amik ott vannak
    	 * azok közül az első olyan elemen, ami nem a golyó maga, azon
    	 * meghívjuk a shot() függvényt.
    	 */
    	Terulet t = new Terulet(new Vektor(this.pos.getKezd()),new Vektor(this.pos.getVeg()));
    	t.addDirToArea(moveDir);     	    	
    	
    	Set<Elem> itemsThere = lab.whatsThere(t);		//ahová lépünk, ott ezek vannak
    	
    	if(itemsThere.size() == 1){						//ha nincs ott semmi...
    		step();										//...akkor lépés 
    		isChanged = true;
    		return;
    	}    										   		    		
    	    	
    	Iterator<Elem> iteratorThere = itemsThere.iterator();    	
    	while(iteratorThere.hasNext()){
    		Elem temp = iteratorThere.next();
    		if(temp != this){							//magát nem lövi meg a golyó
    			temp.shot(this);
    			isChanged = true;
    			return;									//csak egyvalamit találunk el vele
    		}    			
    	}   	
    }    
    
    public Szin getSzin() {
		return colour;
	}
}