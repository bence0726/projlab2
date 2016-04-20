package projlab2;
import java.io.File;
import java.util.*;

/**
 * 
 */
public class Oneil extends Karakter {
    
	public Oneil(Labirintus lab, File img) {
		super(lab, img);
		// TODO Auto-generated constructor stub
	}

	/**
     * 
     */
    public void addZPM() {
        ZPM++;

        Terulet T = new Terulet();
        T.randomArea(6);
        
        //amíg nem sorsol olyan területet, 
        //ahol nincs semmi, addig hívogatjuk.
        while(lab.whatsThere(T) != null) 
        	T.randomArea(6);
        lab.addElem(new ZPM(T)); //hozzáadjuk a labirintushoz
    }

}