package model;
import java.util.*;

/**
 * A Doboz modellbeli reprezentációjáért felelős osztály.
 */
public class Doboz extends Moveable {
    /**
     * Létrehoz egy dobozt a közepét a megadott
     * vektorra illesztve, default mérettel.
     */
    public Doboz(Labirintus lab,Vektor leftcorn, Vektor diagonal,int mass) {
    	super(lab,leftcorn, diagonal);
    	suly = mass;
    }

    /**
     * Ha a karakter felveszi, hozzáadja
     * magát a karakterhez.
     * @return true - mert történt felvétel
     */
    public boolean picked(Karakter k) {
    	if (k.box == null){
    		this.kill(null);  //meg kell ölni, hogy  a labirintusból kikerüljön és igy ne rajzolja fel a pályára
    		k.addBox(this);
        
    		Set<Elem> here = lab.whatsThere(this.getPos()); 
    		Iterator<Elem> itElem = here.iterator();
    		while(itElem.hasNext()){ //ha volt alatta valami, akkor azokról leléptetjük a dobozt
    			Elem temp = itElem.next();
    			temp.steppedoff(this);
    		}
    		isChanged = true;
    		return true;
    	}
    	return false;
    }
    
    /**
     * Accessable = true, így tudunk rátenni dobozt,
     * de a steppedon() megvalósítása nem engedi, hogy rálépjünk.
     * Így dobozokat tudunk egymásra pakolni,ahogy a 
     * specifikáció kéri, de nem tudunk rálépni.
     */
    public boolean isAccessable(){
    	return true;
    }
}