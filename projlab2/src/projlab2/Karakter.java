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
        return ZPM;
    }

    /**
     * Amerre a puskacső áll, arról vesz fel
     * valamit, ha van ott valami
     */
    public void Pick() {
    	Terulet T = new Terulet(pos.getMiddleOfArea(),gundir);
        Set<Elem> items = lab.whatsThere(T);
        
        Iterator<Elem> iterator = items.iterator();
        
        while(iterator.hasNext()){
        	if(iterator.next().picked(this)){
        		lab.refreshList();			//frissítjük a labirintus listáját
        		return;        	
        	}
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
        box.alive = true;			//felélesztjük. :D
        lab.addElem(box);			//hozzáadjuk a dobozt a listához
        box.setDir(this.gundir);	//beállítjuk a doboz "lépési irányát"
        box.move();					//ezzel letesszük a dobozt.
        							//ha van ott valami, ahova lépne, és nem 
        							//léphet oda, az objektumok lerendezik, 
        							//max marad a karakter pozíciójában.
        box = null;					//nincs nálunk doboz, legyen null az értéke.
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
    	if(box != null){
    		Drop(); 		//ha van nálunk doboz, lerakjuk, mielőtt felvennénk egy másikat
    	}
    	this.box = Box;
    }
}