package projlab2;
import java.io.File;
import java.util.*;

/**
 * 
 */
public class Oneil extends Karakter {
    
	public Oneil(Labirintus lab, File img,Terulet pos) {
		super(lab, img,pos);
		// TODO Auto-generated constructor stub
	}

	/**
     * 
     */
    public void addZPM() {
        ZPM++;

        Terulet T = new Terulet();
        T.randomArea(new Vektor(6,6),100);
        
        //amíg nem sorsol olyan területet, 
        //ahol nincs semmi, addig hívogatjuk.
        while(lab.whatsThere(T) != null) 
        	T.randomArea(new Vektor(6,6),100);
        lab.addElem(new ZPM(T)); //hozzáadjuk a labirintushoz
    }

}