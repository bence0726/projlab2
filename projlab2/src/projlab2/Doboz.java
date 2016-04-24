package projlab2;
import java.util.*;

/**
 * 
 */
public class Doboz extends Moveable {

    /**
     * Default constructor
     */
    public Doboz(Terulet area, int mass) {
    	this.pos = area;
    	suly = mass;
    	
    }

    /**
     * Ha a karakter felveszi, hozzáadja
     * magát a karakterhez.
     * @return true - mert történt felvétel
     */
    public boolean picked(Karakter k) {
    	this.kill();  //meg kell ölni, hogy  a labirintusbol kikerüljön és igy ne rajzolja fel a pályára
        k.addBox(this);
        
        Set<Elem> here = lab.whatsThere(this.getPos()); 
        Iterator<Elem> itElem = here.iterator();
        while(itElem.hasNext()){ //ha volt alatta valami, akkor azokról leléptetjük a dobozt
        	Elem temp = itElem.next();
        	temp.steppedoff(this);
        }	
        return true;
    }
}