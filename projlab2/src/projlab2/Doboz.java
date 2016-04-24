package projlab2;
import java.util.*;

/**
 * 
 */
public class Doboz extends Moveable {

    
    /**
     * Létrehoz egy dobozt a közepét a megadott
     * vektorra illesztve, default mérettel.
     * 
     * @param lab
     * @param kezdLocVec
     * @param mass
     */
    public Doboz(Labirintus lab,Vektor kezdLocVec,int mass) {
    	super(lab,kezdLocVec);
    	suly = mass;
    	image = "doboz.jpg";
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