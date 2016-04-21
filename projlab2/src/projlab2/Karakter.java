package projlab2;
import java.io.File;
import java.util.*;

/**
 * 
 */
public class Karakter extends Moveable{
    /**
     * 
     */
    protected int ZPM;

    /**
     * 
     */
    protected int PickRange;

    /**
     * 
     */
    protected Elem box;

    /**
     * 
     */
    protected Vektor gundir;

    /**
     * 
     */

    /**
     * @param lab 
     * @param img
     */
    public Karakter(Labirintus lab, File img,Terulet pos) {
    	super(pos);
        // TODO implement here
    }

    /**
     * Amikor felveszünk egy ZPM-et, a ZPM ezt a metódust hívja meg.
     * Növeli a karakter ZPM-számlálóját.
     */
    public void addZPM() {
        ZPM++;
    }

    /**
     * @return
     */
    public int getZPM() {
        // TODO implement here
        return 0;
    }

    /**
     * 
     */
    public void changeBoxVal() {
        // TODO implement here
    }

    /**
     * @param dir
     */
    public void Pick(Vektor dir) {
        // TODO implement here
    }

    /**
     * @param dir
     */
    public void Drop(Vektor dir) {
        // TODO implement here
    }

    /**
     * @param szin
     */
    public void Fire(Szin szin) {
        // TODO implement here
    	lab.addMoveable(new Golyo(gundir,pos ));
    }

    /**
     * @param double Szog
     */
    public void changeFegyverirany(double Szog) {
        // TODO implement here
    }

    /**
     * 
     * @param dir
     */
    public void move(Vektor dir) {
        ///TODO: vázlatos!!
    	/*
    	 * MEgnézzük, hogy ahol állunk ott mi van. (Set A)
    	 * Utána megnézzük,hogy ahova menni akarunk ott mi van. (Set B)
    	 * Azokra az elemekre hivjuk a steppedon-t ahová lépni fogunk
    	 * Miután ezek léptettek(avagy nem) , megint megnézzük, hogy hol vagyunk (Set C)
    	 * Ezután összehasonlítjuk A-t és C-t , ami nincs benn C-ben arra hívjuk a steppedoff-ot.
    	 */
    	Terulet t = new Terulet(pos.getKezd(),pos.getVeg());
    	t.setKezd(dir);
    	t.setVeg(dir);
    	Elem elemThere = lab.whatsThere(t);
    	Elem elemHere = lab.whatsThere(pos);
    	
    		
    	
    	if(elemThere != elemHere)
    	if(elemThere == null){				//ha nincs ott semmi, odalépünk
    		step();
    		return;
    	}
    	
    	
    	
    	
    	
    	elemThere.steppedon(this); 			//ha van ott valami, steppedon-t hívjuk
    }

}