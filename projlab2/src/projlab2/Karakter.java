package projlab2;
import java.io.File;
import java.util.*;
import java.util.function.ToIntFunction;

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
    protected Doboz box; 

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
     *  Szerintem ez nem kell.
     */
    public void changeBoxVal() {
        // Szerintem ez nem kell.
    }
    
	/**
     * @param dir
     */
    public void move() {
    	/*
    	 * Magyarázat
    	 * MEgnézzük, hogy ahol állunk ott mi van. (Set A)
    	 * Utána megnézzük,hogy ahova menni akarunk ott mi van. (Set B)
    	 * Azokra az elemekre hivjuk a steppedon-t ahová lépni fogunk
    	 * Miután ezek léptettek(avagy nem) , megint megnézzük, hogy hol vagyunk (Set C)
    	 * Ezután összehasonlítjuk A-t és C-t , ami nincs benn C-ben arra hívjuk a steppedoff-ot.
    	 */
    	Terulet t = new Terulet(this.pos.getKezd(),this.pos.getVeg());
    	t.addDirToArea(moveDir); 
    	    	
    	Set<Elem> itemsHere = lab.whatsThere(this.pos); //lépés előtt itt állunk
    	Set<Elem> itemsThere = lab.whatsThere(t);		//ahová lépünk, ott ezek vannak
    	
    	Iterator<Elem> iteratorHere = itemsHere.iterator();
    	
    	if(itemsThere.size() == 0){						//ha nincs ott semmi...
    		step();										//lépés
    		if(itemsHere.size() != 0){
    			Set<Elem> itemsNewPlace = lab.whatsThere(this.pos);//megnézzük, kimindenkin vagyunk rajta most    			
    			while(iteratorHere.hasNext()){
    	    		Elem temp = iteratorHere.next();
    	    		if(!itemsNewPlace.contains(temp))
    	    			temp.steppedoff(this);					//ami nincs benne, arról leléptünk
    	    	}
    		}
    		return;
    	}    	
    	Iterator<Elem> iteratorThere = itemsThere.iterator();
    	
    	while(iteratorThere.hasNext()){
    		iteratorThere.next().steppedon(this);
    	}
    	
    	Set<Elem> itemsNewPlace = lab.whatsThere(this.pos);
    	
    	while(iteratorHere.hasNext()){
    		Elem temp = iteratorHere.next();
    		if(!itemsNewPlace.contains(temp))
    			temp.steppedoff(this);					//ami nincs benne, arról leléptünk
    	}    
    	
    	//megnézzük, hogy a másik oldalon mire léptünk rá. Ezeken steppedon()-t hívjuk
    	
    	Iterator<Elem> iteratorItemsNewPlace = itemsNewPlace.iterator();
    	
    	while(iteratorItemsNewPlace.hasNext()){
    		Elem temp = iteratorItemsNewPlace.next();
    		temp.steppedon(this);
    	}
	}

    /**
     * Amerre a puskacső áll, arról vesz fel
     * valamit, ha van ott valami
     */
    public void Pick() {
    	if(box != null) //ha már van nálunk doboz, semmi dolgunk!
    		return;    	
    	Terulet T = new Terulet(pos.getMiddleOfArea(),gundir);
        Set<Elem> items = lab.whatsThere(T);
        
        Iterator<Elem> iterator = items.iterator();
        
        while(iterator.hasNext()){
        	iterator.next().picked(this);
        	if(box != null) //ha felvettünk valamit, visszatérünk.
        		return;
        	
        }
    }

    /**
     * Amerre a puskacső áll, arra 
     * fogja letenni a dobozt.
     */
    public void Drop() {
        if(box == null) 			//ha nincs nálunk doboz, nincs feladat
        	return;
        box.pos.setNewCornerLocation(this.pos.getKezd());//TODO: elkészült ez a függvény a Terulet osztályban? jó a paraméterezés?
        lab.addElem(box);			//hozzáadjuk a dobozt a listához
        box.setDir(this.gundir);	//beállítjuk a doboz "lépési irányát"
        box.move();					//ezzel letesszük a dobozt.
        							//ha van ott valami, ahova lépne, és nem 
        							//léphet oda, az objektumok lerendezik, 
        							//max marad a karakter pozíciójában.
        
    }

    /**
     * @param szin
     */
    public void Fire(Szin szin) {
        // TODO implement here
    	lab.addMoveable(new Golyo(gundir,pos,szin));
    }

    /**
     * A megadott szöggel elforgatja a 
     * @param double Szog //fokban
     */
    public void changeFegyverirany(double addAngle) {
        double currentAngle = Math.asin(gundir.getVy()/gundir.getVx()); //szöggel szemközti per átfogó arkuszszinusza. az érték radiánban
        addAngle = addAngle*Math.PI / 180; //fokokat lenormáljuk radiánná
        currentAngle+=addAngle; //összeadjuk a 2 szöget.
        gundir.setVx((int)(Math.round(Math.cos(currentAngle))*100));
        gundir.setVy((int)(Math.round(Math.sin(currentAngle))*100));
        //ALERT a vektorok parametereit floatban kellett volna tarolni nem int... most mindenhol átkéne irni.
        
    }
    /**
     * Ezzel a függvénnyel a doboz hozzá tudja magát adni
     * a karakterhez fájdalommentesen.
     * @param Box
     */
    public void addBox(Doboz Box){
    	this.box = Box;
    }
}