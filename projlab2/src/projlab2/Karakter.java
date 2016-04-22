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
        box.changeLoc(this.pos.getKezd());//TODO: elkészült ez a függvény a Terulet osztályban? jó a paraméterezés?
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
     * @param double Szog
     */
    public void changeFegyverirany(double Szog) {
        // TODO implement here
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