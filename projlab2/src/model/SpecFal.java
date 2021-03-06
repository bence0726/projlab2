package model;

import enums.Szin;

/**
 * SpecFal modellbeli reprezentációja.
 */
public class SpecFal extends Elem {
	
    /**
    * Megadja, hogy a SpecFal elemre rá lehet-e lépni.
    */
   private boolean reachable;

   /**
    * A SpecFalon nyitott portál színét tárolja
    */
   private Szin colour;
	
	/**
    * Megadja, hogy milyen irányba kell eltolni a karakter arról a portálról
    * ahová tettük.
    */
   private Vektor direction;
   
   /**
    * Ugyanarra a PM-re lesz beállítva az összes SpecFal.
    */
   private PortalManager pm;
	
	/**
     * Létrehoz egy Specfalat, a bal felső sarkát locUpLeftCorner
     * vektorra illesztve. A második paraméter az elem mérete.
     * @param locUpLeftCorner
     * @param diagonal
     * @param pm
     */
    public SpecFal(Vektor locUpLeftCorner,Vektor diagonal,Vektor dir,PortalManager pm) {
    	super(locUpLeftCorner,diagonal);
    	reachable = false;
		this.pm = pm;
		direction = dir;
    }
    
    public void shot(Golyo bullet) {
    	Szin colour = bullet.getSzin();
    	SpecFal sf = null;
    	if (this.colour != null){ //megnézzük, hogy van-e színe a falnak
    		sf = pm.getPortalOfThisColor(this.colour); //ha igen, megkérdezzük, hogy az adott színnel van e portál nyitva 
    		if(sf != null && sf == this )//ha van és ez a portál ezen a falon van nyitva
    			pm.close(this.colour); //bezárjuk
    	}
    	if(pm.getPortalOfThisColor(colour) != null) //ha a lőtt szín valahol máshol letezik
    		pm.close(colour); //bezárjuk
    	pm.open(this,colour);
    	bullet.kill(null);
    	isChanged = true;
    }

    public boolean steppedon(Moveable m) {
        if(!reachable || (m.getSuly() == 0))//ha 0 a súlya, nem teleportál. így replikátor nem tud teleportálni.
        	return false;
        
        SpecFal otherSide = pm.getOtherSide(this);
        if(otherSide == null)			//ennek nem kéne teljesülnie, de ha mégis, visszatérünk
        	return false;
        otherSide.teleport(m);		//a rálépett elemet teleportáljuk
        isChanged = true;
        return true;
    }

    /**
     *  A falat elérhetetlenné teszi.
     */
    public void bezar() {
    	reachable = false;
    	isChanged = true;
    }

    /**
     * A falat elérhetővé teszi és beállítja a színét.
     */
    public void kinyit(Szin colour) {
        reachable = true;
        this.colour=colour;        
        isChanged = true;
    }
    
    /**
     * Az irany attribútum által kijelölt pontra állítjuk
     * az elem új helyét. Ez legyen valahol a portál előtt!
     */
    public void teleport(Moveable m){
    	// a teleportálando elemet középpontját a másik kapu középpontjára illeszti
    	m.pos.setNewMiddleLocation(this.pos.getMiddleOfArea());
    	//eztuán az elemet kitolja a kapubol a megadott irányban
    	m.elemShiftWithVec(Vektor.VektorMultiplication(direction, 20));
    }
    
    public Szin getSzin() {
		return colour;
	}

	public boolean isAccessable(){
		return reachable;
	}
}