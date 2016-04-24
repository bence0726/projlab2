package projlab2;
import java.io.File;
import java.util.*;

/**
 * 
 */
public class Oneil extends Karakter {
    
	public Oneil(Labirintus lab, Terulet pos) {
		super(lab, pos);
		image = "oneil.jpg";
	}

	/**
     *  Növeli az ezredes ZPM számlálóját, továbbá
     *  Valahol máshol generálódik egy új ZPM.
     */
    public void addZPM() {
        ZPM++;
        if((ZPM % 2) != 0) //csak minden másodikra kell random ZPM-et generálni.
        	return;
        Terulet T = new Terulet();
        T.randomArea(new Vektor(6,6),100);
        //amíg nem sorsol olyan területet, 
        //ahol nincs semmi, addig hívogatjuk.
        while(lab.whatsThere(T) != null) 
        	T.randomArea(new Vektor(6,6),100);
        lab.addElem(new ZPM(T)); //hozzáadjuk a labirintushoz
    }

}