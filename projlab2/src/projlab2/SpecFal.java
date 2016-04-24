package projlab2;
import java.util.*;

/**
 * 
 */
public class SpecFal extends Elem {
	/**
	 * A megadott területre létrejön egy SpecFal elem.
	 * Minden SpecFal elemnek ugyanazt a PortalManagert kell megkapnia.
	 * @param area
	 * @param pm
	 */
	public SpecFal(Terulet area, PortalManager portalmanager){
		super(area);
		reachable =false;
		image = "specfal.jpg";
		pm = portalmanager;		
	}
	
	/**
     * Létrehoz egy Specfalat, a bal felső sarkát locUpLeftCorner
     * vektorra illesztve. A második paraméter az elem mérete.
     * @param locUpLeftCorner
     * @param diagonal
     * @param pm
     */
    public SpecFal(Vektor locUpLeftCorner,Vektor diagonal,PortalManager pm) {
    	super(locUpLeftCorner,diagonal);
    	reachable =false;
		this.pm=pm;
    	image = "specfal.jpg";
    }
    
     /**
     * Megadja, hogy a SpecFal elemre rá lehet-e lépni.
     */
    private boolean reachable;

    /**
     * A SpecFalon nyitott portál színét tárolja
     */
    private Szin colour;
	
	/**
     * Megadja, hogy hol kell kirakni a karaktert, ha ide teleportál.
     */
    private Vektor direction;
    
    /**
     * Ugyanarra a PM-re lesz beállítva az összes SpecFal.
     */
    private PortalManager pm;

    /**
     * @param bullet
     */
    public void shot(Golyo bullet) {
    	Szin colour = bullet.getSzin();
    	if(this == pm.getPortalOfThisColor(this.colour))
    		pm.close(this.colour);
    	pm.close(colour);
    	pm.open(this,colour);
    	bullet.kill();
    }

    /**
     * 
     * @param elem
     */
    public void steppedon(Moveable m) {
        if(!reachable || (m.getSuly() == 0))//ha 0 a súlya, nem teleportál. így replikátor nem tud teleportálni.
        	return;
        
        SpecFal otherSide = pm.getOtherSide(this);
        if(otherSide == null)			//ennek nem kéne teljesülnie, de ha mégis, visszatérünk
        	return;
        otherSide.teleport(m);		//a rálépett elemet teleportáljuk      
    }

    /**
     *  A falat elérhetetlenné teszi.
     */
    public void bezar() {
    	reachable = false;
    }

    /**
     * A falat elérhetővé teszi és beállítja a színét.
     */
    public void kinyit(Szin colour) {
        reachable = true;
        this.colour=colour;
        
    }
    /**
     * Az irany attribútum által kijelölt pontra állítjuk
     * az elem új helyét. Ez legyen valahol a portál előtt!
     */
    public void teleport(Moveable m){
    	// a teleportálando elemet középpontját a másik kapu középpontjára illeszti
    	m.pos.setNewMiddleLocation(this.pos.getMiddleOfArea());
    	//eztuán az elemet kitolja a kapubol a megadott irányban
    	m.elemShiftWithVec(direction);
    }
    
    public Szin getSzin() {
		return colour;
	}

	public void setSzin(Szin colour) {
		this.colour = colour;
	}
}