package model;
import java.util.*;

/**
 * A mozgó elemek közös ősosztálya.
 * Absztrakt osztály, a leszármazó osztályokban
 * egyes metódusok felül lettek írva, de vannak
 * közös kódrészek is.
 */
public abstract class Moveable extends Elem{
    protected Vektor moveDir = new Vektor(0,0);
    protected Labirintus lab;
    protected int suly = 0;
    
    /**
     * Létrehoz egy moveable objektumot a közepét a 
     * megadott vektorra illesztve.
     * Default mérettel jön létre 10*10 pixel méretben.
     * 
     * FIXME: Egyelőre cska a golyó használja, lehet értelmesebb lenne oda átrakni, a defaultsize-al ami
     * ráadásul az elemben van.
     */
	public Moveable(Labirintus labirintus,Vektor locMiddleofArea) {
		Vektor diagonal = new Vektor(defaultsize);
    	diagonal = Vektor.getHalfOf(diagonal);
    	pos =new Terulet();
    	pos.setVeg(Vektor.addVecToVec(locMiddleofArea, diagonal));
    	diagonal.invertThisVec();
    	pos.setKezd(Vektor.addVecToVec(locMiddleofArea, diagonal));
		lab = labirintus;
	}
	
	/**
     * Létrehoz egy Moveable elemet, a bal felső sarkát locUpLeftCorner
     * vektorra illesztve. A második paraméter az elem mérete.
     */
    public Moveable(Labirintus labirintus, Vektor locUpLeftCorner,Vektor diagonal){
    	super(locUpLeftCorner,diagonal);
    	lab = labirintus;
    }

	/**
	 * Replikátor ráléphet karakterre, golyóra, replikátorra, dobozra is.
	 */
	public boolean steppedon(Moveable x){
		if(x.getSuly() == 0){
			x.step();
			//isChanged = true;
			return true;
		}			
		else
			return false;			
	}
	
	/**
     * Mozgáskor ez a move függvény hívódik meg, ha a 
     * leszármazott osztály nem definiálja fölül.
     */
    public void move() {
    	/*
    	 * Magyarázat
    	 * MEgnézzük, hogy ahol állunk ott mi van. (Set A)
    	 * Utána megnézzük,hogy ahova menni akarunk ott mi van. (Set B)
    	 * Azokra az elemekre hivjuk az isAccessable-t, ahová lépni fogunk,
    	 * Ha B-ben lévő összes elem true-val tér vissza, mindenkin steppedon-t hívunk.
    	 * Miután ezek léptettek(avagy nem), megint megnézzük, hogy hol vagyunk (Set C)
    	 * Ezután összehasonlítjuk A-t és C-t , ami nincs benn C-ben arra hívjuk a steppedoff-ot.
    	 */
    	Vektor v1 = new Vektor(this.pos.getKezd().getVx(),this.pos.getKezd().getVy());
    	Vektor v2 = new Vektor(this.pos.getVeg().getVx(),this.pos.getVeg().getVy());
    	Terulet t = new Terulet(v1,v2);
    	t.addDirToArea(moveDir); 
    	    	
    	Set<Elem> itemsHere = lab.whatsThere(this.pos); 			//lépés előtt itt állunk
    	Set<Elem> itemsThere = lab.whatsThere(t);					//ahová lépünk, ott ezek vannak
    	
    	Iterator<Elem> iteratorHere = itemsHere.iterator();
    	
    	if(itemsThere.size() == 1){									//ha nincs ott semmi... ez megtalálja magát? Igen!
    		step();													//lépés
    		if(itemsHere.size() != 1){
    			Set<Elem> itemsNewPlace = lab.whatsThere(this.pos);	//megnézzük, kimindenkin vagyunk rajta most    			
    			while(iteratorHere.hasNext()){
    	    		Elem temp = iteratorHere.next();
    	    		if(!itemsNewPlace.contains(temp))
    	    			temp.steppedoff(this);						//ami nincs benne, arról leléptünk
    	    	}
    		}
    		moveDir = Vektor.EnumToDirVec(MoveDirections.Stay);		//lépés után (0,0)-a állítjuk a mozgásvektort
    		return;
    	}    	
    	Iterator<Elem> iteratorThere = itemsThere.iterator();    	
    	while(iteratorThere.hasNext()){
    		if(!iteratorThere.next().isAccessable()) 				// ha nem elérhető az a terület, ahová lépni szeretnénk,
    			return;												// akkor visszatérünk.
    	}
    	
    	itemsThere.removeAll(itemsHere);	//FIXME: kitörlöm azokat a jövbeli lepes helyeről amiken már állun igy nem hivodik a steppedonjuk
    	iteratorThere = itemsThere.iterator(); 						// létrejön új iterátor, vagy a végigpörgetettet kapjuk meg??
    	
    	while(iteratorThere.hasNext()){
    			if(iteratorThere.next().steppedon(this)){
    				moveDir = Vektor.EnumToDirVec(MoveDirections.Stay);                                         
    		}
    	}
    	
    	Set<Elem> itemsNewPlace = lab.whatsThere(t);
    	iteratorHere = itemsHere.iterator(); //FIXME JAVITAS
    	
    	while(iteratorHere.hasNext()){
    		Elem temp = iteratorHere.next();
    		if(!itemsNewPlace.contains(temp))
    			temp.steppedoff(this);								//ami nincs benne, arról leléptünk
    	}    
    	
    	//megnézzük, hogy van-e különbség aközött, hogy hová szerettünk volna
    	//lépni és aközött, hogy most hol vagyunk (magyarán volt-e teleportálás)
    	Terulet temp1 = new Terulet(this.getPos().getKezd(),this.getPos().getVeg());
    	temp1.addDirToArea(moveDir);   //FIXME valtoztatas: valamiért az előző this.getpos() hoz nem voll még hozzáadva a moveDir igy a 
    	if(temp1.isEqualTo(t)){			// FIXME feltétel: this.getpos().isEqualto(t) soha nem volt egyenlő így most jonak tünik
    		moveDir = Vektor.EnumToDirVec(MoveDirections.Stay);		//lépés után (0,0)-a állítjuk a mozgásvektort
    		isChanged = true;
    		return;													//ha megegyezik, nincs további teendő.
    	}
    		
    	
    	//ha még itt járunk, volt teleportálás.
    	//megnézzük, hogy a másik oldalon mire léptünk rá. Ezeken steppedon()-t hívjuk    	
    	Iterator<Elem> iteratorItemsNewPlace = itemsNewPlace.iterator();
    	
    	while(iteratorItemsNewPlace.hasNext()){
    		Elem temp = iteratorItemsNewPlace.next();
    		if(temp.steppedon(this)){
    			moveDir = Vektor.EnumToDirVec(MoveDirections.Stay);
    		}    		
    	}
    	isChanged = true;
    	moveDir = Vektor.EnumToDirVec(MoveDirections.Stay);//lépés után (0,0)-a állítjuk a mozgásvektort
	}
    
    /**
     * Továbblépés.
     */
    public void step(){
    	elemShiftWithVec(moveDir);
    	//isChanged = true;
    }
    
    /**
     * Beallítja, hogy merre mozogjon az objektum.
     * Irányvektort kap.
     * @param dir - az irányvektor, amerre a karakter mozogni fog.
     */
    public void setDir(Vektor dir){
    	moveDir = dir;
    }    

    public void kill(Elem e){
    	this.alive = false;
    	lab.refreshList();
    	//isChanged = true;
    }
    /**
     * Megadja az objektum súlyát.
     */
    public int getSuly() {
		return suly;
	}
    
    public boolean isAccessable(){
    	return true;
    }
}