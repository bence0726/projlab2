package model;
import java.util.*;

/**
 * Jaffa reprezentációja a modellben.
 */
public class Karakter extends Moveable{
    /**
     * A karakternél lévő ZPM-ek száma.
     */
    protected int ZPM = 0;

    /**
     * A karakternél levő dobozt tároljuk itt.
     */
    protected Doboz box; 

    /**
     * A karakter fegyverének irányvektora.
     */
    protected Vektor gundir = new Vektor(1,0);
    
    protected double currentAngle = 0.0;

    /**
     * Létrehoz egy karakter(jaffa) objektumot
     * @param leftcorn - ide illeszti az objektum bal
     * felső sarkát
     * @param diagonal - a bal felső sarokból ezzel a vektorral
     * eltolva hozza létre az objektum bal alsó pontját.
     */
    public Karakter(Labirintus lab,Vektor leftcorn, Vektor diagonal){
    	super(lab,leftcorn, diagonal);
    	gundir.beEqualWith(new Vektor(1,0));
    	suly = 10;
    }
    
    /**
     * Amerre a puskacső áll, arról vesz fel
     * valamit, ha van ott valami
     */
    public void Pick() {
    	Terulet T = new Terulet(new Vektor(this.pos.getKezd()),new Vektor(this.pos.getVeg()));
    	T.addDirToArea(Vektor.VektorMultiplication(gundir, 50));
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
     * A karakternél lévő dobozt leteszi a puskacső irányába,
     * ha van nála doboz.
     */
    public void Drop(){
    	if(box == null){
    		return;
    	}
    	Terulet t = new Terulet(new Vektor(this.pos.getKezd()),new Vektor(this.pos.getVeg()));
    	Double szam = Math.sqrt((this.pos.getHeight()*this.pos.getHeight() + this.pos.getWidth()*this.pos.getWidth()));
    	t.addDirToArea(Vektor.VektorMultiplication(gundir, (int) (Math.round(szam + 1))));
    	
    	Set<Elem> items = lab.whatsThere(t);
    	Iterator<Elem> it = items.iterator();
    	
    	while(it.hasNext()){
    		if(!it.next().isAccessable()) 	//ha nem elérhető, nem tudunk erre a területre lépni.
    			return;
    	}
    	it = items.iterator();
    	
    	box.alive = true;
    	lab.addMoveable(box);
    	box.pos = t;
    	while(it.hasNext()){
    		it.next().steppedon(box);
    	}
    	
    	box = null;
    }

    /**
     * A paraméterül kapott színnel elindít egy golyót.
     */
    public void Fire(Szin szin) {
    	lab.addMoveable(new Golyo(
    			this.lab,Vektor.addVecToVec(pos.getMiddleOfArea(), gundir),gundir, szin));
    }

    /**
     * A megadott szöggel elforgatja a 
     * @param double Szog //fokban
     */
    public void rotateGunDir(double addAngle) {
//        double currentAngle = Math.atan(gundir.getVy()/gundir.getVx()); //szöggel szemközti per átfogó arkuszszinusza. az érték radiánban
//        addAngle = (addAngle*Math.PI) / 180.0; 								//fokokat lenormáljuk radiánná
//        currentAngle+=addAngle; 										//összeadjuk a 2 szöget.
//        gundir.setVx((Math.round(Math.cos(currentAngle)*5)));
//        gundir.setVy((Math.round(Math.sin(currentAngle)*5)));
    	
//        
    	currentAngle += addAngle;
      gundir.setVx(Math.toRadians(Math.cos(currentAngle))*20.0);
      gundir.setVy(Math.toRadians(Math.sin(currentAngle))*20.0);
      if(currentAngle >= 360)
    	  currentAngle = 0; //túlcsordulásvédelem
    	
    }
    
    /**
     * Ezzel a függvénnyel a doboz hozzá tudja magát adni
     * a karakterhez. Ha már van a karakternél doboz, akkor
     * nem történik dobozfelvétel.
     * @param newBox - a doboz, amit fel akarunk venni.
     */
    public void addBox(Doboz newBox){
    	if(box == null)
    		this.box = newBox;
    }
    
    /**
     * Növeli a karakter ZPM-számlálóját.
     */
    public void addZPM() {
        ZPM++;
    }

    /**
     * @return A karakternél lévő ZPM-ek számát adja vissza.
     */
    public int getZPM() {
        return ZPM;
    }
    public double getrotategundir(){
    	return  (Math.atan(gundir.getVy()/gundir.getVx())*180)/Math.PI;
    }
}