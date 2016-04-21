package projlab2;
import java.util.*;

/**
 * 
 */
public class Replikator extends Moveable {

    /**
     * Default constructor
     */
    public Replikator(Terulet area) {
    	super(area);
    }

    /**
     * 
     */
    public void shot() {
        // TODO implement here
    }

    /**
     * @param dir
     */
    public void move(Vektor dir) {
        // TODO implement here
    }

    /**
     * Ha megölik a replikátort, akkor csak szakadékba
     * léphetett. Ekkor megkeressük a mapon a rá mutató
     * referenciát és kinyírjuk őt is.
     */
    public void kill() {
        alive = false;
        Set<Elem> items = lab.whatsThere(pos);
        
        Iterator<Elem> iterator = items.iterator();
        while(iterator.hasNext()){
        	Elem temp = iterator.next();
        	if(temp != this){
        		temp.kill();
        		return;
        	}
        		
        }
    }
}