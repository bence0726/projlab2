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
    private Labirintus lab;

    /**
     * @param lab 
     * @param img
     */
    public Karakter(Labirintus lab, File img) {
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
    	lab.addMoveable(new Golyo(dir,pos ));
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
    	Terulet t = new Terulet(pos.getKezd(),pos.getVeg());
    	t.setKezd(dir);
    	t.setVeg(dir);
    	Elem elemThere = lab.WhatsThere(t);
    	Elem elemHere = lab.WhatsThere(pos);
    	
    	
    	
    	if(elemThere != elemHere)
    	if(elemThere == null){				//ha nincs ott semmi, odalépünk
    		step();
    		return;
    	}
    	
    	
    	
    	
    	
    	elemThere.steppedon(this); 			//ha van ott valami, steppedon-t hívjuk
    }

}