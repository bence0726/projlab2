package model;
import java.util.*;

/**
 * 
 */
public class Karakter extends Moveable{
    /**
     * 
     */
    protected int ZPM = 0;

    /**
     * 
     */
    protected Doboz box; 

    /**
     * 
     */
    protected Vektor gundir = new Vektor(1,0);

    /**
     * Létrehoz egy karakter(jaffa) objektumot az elem 
     * közepére illesztve a moveable objektumot.
     * Default mérettel jön létre 10*10 pixel méretben.
     * @param lab
     * @param kezdLocVec
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
    	T.addDirToArea(Vektor.VektorMultiplication(gundir, 5));
        Set<Elem> items = lab.whatsThere(T);
        
        Iterator<Elem> iterator = items.iterator();
        
        while(iterator.hasNext()){
        	if(iterator.next().picked(this)){
        		lab.refreshList();			//frissítjük a labirintus listáját
        		
        		return;        	
        	}
        }
    }

//    /**
//     * Amerre a puskacső áll, arra 
//     * fogja letenni a dobozt.
//     */
//    public void Drop() {
//        if(box == null) 			//ha nincs nálunk doboz, nincs feladat
//        	return;
//        box.pos.setNewCornerLocation(this.pos.getKezd());
//        box.alive = true;			//felélesztjük. :D
//        lab.addElem(box);			//hozzáadjuk a dobozt a listához
//        box.setDir(this.gundir);	//beállítjuk a doboz "lépési irányát"
//        box.move();					//ezzel letesszük a dobozt.
//        							//ha van ott valami, ahova lépne, és nem 
//        							//léphet oda, az objektumok lerendezik, 
//        							//max marad a karakter pozíciójában.
//        box = null;					//nincs nálunk doboz, legyen null az értéke.
//    }
    
    public void Drop(){
    	if(box == null){
    		return;
    	}
    	Terulet t = new Terulet(this.pos.getKezd(),this.pos.getVeg());
    	Double szam = Math.sqrt((this.pos.getHeight()*this.pos.getHeight() + this.pos.getWidth()*this.pos.getWidth()));
    	t.addDirToArea(Vektor.VektorMultiplication(gundir, (int) (Math.round(szam + 1))));
    	
    	Set<Elem> items = lab.whatsThere(t);
    	Iterator<Elem> it = items.iterator();
    	
    	while(it.hasNext()){
    		if(!it.next().isAccessable())
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
     * @param szin
     * FIXME pos.getkezd átírva getmiddleofareara
     */
    public void Fire(Szin szin) {
//    	lab.addMoveable(new Golyo(lab,gundir,pos,szin));
    	lab.addMoveable(new Golyo(
    			this.lab,Vektor.addVecToVec(pos.getMiddleOfArea(), gundir),gundir, szin));
    }

    /**
     * A megadott szöggel elforgatja a 
     * @param double Szog //fokban
     */
    public void rotateGunDir(double addAngle) {
        double currentAngle = Math.asin(gundir.getVy()/gundir.getVx()); //szöggel szemközti per átfogó arkuszszinusza. az érték radiánban
        addAngle = addAngle*Math.PI / 180; //fokokat lenormáljuk radiánná
        currentAngle+=addAngle; //összeadjuk a 2 szöget.
        gundir.setVx((Math.round(Math.cos(currentAngle))));
        gundir.setVy((Math.round(Math.sin(currentAngle))*-1));
        //ALERT a vektorok parametereit floatban kellett volna tarolni nem int... most mindenhol átkéne irni.
    }
    /**
     * Ezzel a függvénnyel a doboz hozzá tudja magát adni
     * a karakterhez. Ha már van a karakternél doboz, akkor
     * a nála lévőt leteszi.
     * @param newBox - a doboz, amit fel akarunk venni.
     */
    public void addBox(Doboz newBox){
//    	if(box != null){
//    		Drop(); 		//ha van nálunk doboz, lerakjuk, mielőtt felvennénk egy másikat
//    	}
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


    
//  /**
//  * Létrehoz egy Karakter objektumot(jaffa) a megadott vektorral.
//  * A terület bal felső sarkát illeszti a vektorra.
//  * Default mérettel jön létre 10*10 pixel méretben.
//  * @param lab
//  * @param kezdLocVec
//  */
// public Karakter(Labirintus lab,Vektor kezdLocVec) {
// 	super(lab,kezdLocVec);
// 	image = "jaffa.jpg";
//     // TODO implement here
// }
}