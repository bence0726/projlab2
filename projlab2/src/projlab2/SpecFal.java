package projlab2;
import java.util.*;

/**
 * 
 */
public class SpecFal extends Elem {

     /**
     * Megadja, hogy a SpecFal elemre rá lehet-e lépni.
     */
    private boolean reachable;

    /**
     * A SpecFalon nyitott portál színét tárolja
     */
    private Szin szin;

    public Szin getSzin() {
		return szin;
	}

	public void setSzin(Szin szin) {
		this.szin = szin;
	}
	/**
     * Megadja, hogy hol kell kirakni a karaktert, ha ide teleportál.
     */
    private Vektor irany;
    
    /**
     * Ugyanarra a PM-re lesz beállítva az összes SpecFal.
     */
    private PortalManager pm;

    /**
     * @param bullet
     */
    public void shot(Golyo bullet) {
        // TODO implement here
    }

    /**
     * 
     * @param elem
     */
    public void steppedon(Elem elem) {
        if(reachable == false)
        	return;
        SpecFal otherSide = pm.getOtherSide(this);
        if(otherSide == null)			//ennek nem kéne teljesülnie, de ha mégis, visszatérünk
        	return;
        otherSide.teleport(elem);		//a rálépett elemet teleportáljuk      
        	
    }

    /**
     * 
     */
    public void bezar() {
        // TODO implement here
    }

    /**
     * 
     */
    public void kinyit() {
        // TODO implement here
    }
    /**
     * Az irany attribútum által kijelölt pontra állítjuk
     * az elem új helyét. Ez legyen valahol a portál előtt!
     */
    public void teleport(Elem e){
    	e.setPos(irany);
    }
}