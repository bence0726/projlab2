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
        
        double randomX1 = Math.random();
        double randomY1 = Math.random();
        
        
        Terulet T = new Terulet(new Vektor(randomX1,randomY1));
        
        while(lab.whatsThere() == null)
        labb.addElem(new ZPM)
    }

}