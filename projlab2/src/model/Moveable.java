package model;
import java.util.*;

/**
 * 
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


//    /**
//     * Létrehoz egy moveable objektumot az elem 
//     * közepére illesztve a moveable objektumot.
//     * Default mérettel jön létre 10*10 pixel méretben.
//     * @param lab
//     * @param startElem
//     */
//	public Moveable(Labirintus lab,Elem startElem){
//		Vektor locMiddleofArea = startElem.pos.getMiddleOfArea();
//		Vektor diagonal = defaultsize ;
//    	diagonal = Vektor.getHalfOf(diagonal);
//    	pos = new Terulet();
//    	pos.setKezd(Vektor.addVecToVec(locMiddleofArea, diagonal));
//    	diagonal.invertThisVec();
//    	pos.setVeg(Vektor.addVecToVec(locMiddleofArea, diagonal));
//		this.lab = lab;
//		moveDir = pos.getMiddleOfArea(); //csak inicializálás, később felülíródik
//	}
	
	/**
     * Létrehoz egy Moveable elemet, a bal felső sarkát locUpLeftCorner
     * vektorra illesztve. A második paraméter az elem mérete.
     */
    public Moveable(Labirintus labirintus, Vektor locUpLeftCorner,Vektor diagonal){
    	super(locUpLeftCorner,diagonal);
    	lab = labirintus;
    }
	
	public Moveable(){}

	/**
	 * Replikátor ráléphet karakterre, golyóra, replikátorra, dobozra is.
	 */
	public boolean steppedon(Moveable x){
		if(x.getSuly() == 0){
			x.step();
			return true;
		}			
		else
			return false;
			
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
    	Vektor v1 = new Vektor(this.pos.getKezd().getVx(),this.pos.getKezd().getVy());
    	Vektor v2 = new Vektor(this.pos.getVeg().getVx(),this.pos.getVeg().getVy());
    	Terulet t = new Terulet(v1,v2);
    	t.addDirToArea(moveDir); 
    	    	
    	Set<Elem> itemsHere = lab.whatsThere(this.pos); //lépés előtt itt állunk
    	Set<Elem> itemsThere = lab.whatsThere(t);		//ahová lépünk, ott ezek vannak
    	
    	Iterator<Elem> iteratorHere = itemsHere.iterator();
    	
    	if(itemsThere.size() == 1){						//ha nincs ott semmi... ez megtalálja magát? Igen!
    		step();										//lépés
    		if(itemsHere.size() != 1){
    			Set<Elem> itemsNewPlace = lab.whatsThere(this.pos);//megnézzük, kimindenkin vagyunk rajta most    			
    			while(iteratorHere.hasNext()){
    	    		Elem temp = iteratorHere.next();
    	    		if(!itemsNewPlace.contains(temp))
    	    			temp.steppedoff(this);	//ami nincs benne, arról leléptünk
    	    	}
    		}
    		moveDir = Vektor.EnumToDirVec(MoveDirections.Stay);//lépés után (0,0)-a állítjuk a mozgásvektort
    		return;
    	}    	
    	Iterator<Elem> iteratorThere = itemsThere.iterator();    	
    	while(iteratorThere.hasNext()){
    		if(!iteratorThere.next().isAccessable()) // ha nem elérhető az a terület, ahová lépni szeretnénk,
    			return;								// akkor visszatérünk.
    	}
    	iteratorThere = itemsThere.iterator(); // létrejön új iterátor, vagy a végigpörgetettet kapjuk meg??
    	
    	while(iteratorThere.hasNext()){    		
    		if(iteratorThere.next().steppedon(this)){
    			moveDir = Vektor.EnumToDirVec(MoveDirections.Stay);
    		}
    	}
    	
    	Set<Elem> itemsNewPlace = lab.whatsThere(this.pos);
    	
    	while(iteratorHere.hasNext()){
    		Elem temp = iteratorHere.next();
    		if(!itemsNewPlace.contains(temp))
    			temp.steppedoff(this);					//ami nincs benne, arról leléptünk
    	}    
    	
    	//megnézzük, hogy van-e különbség aközött, hogy hová szerettünk volna
    	//lépni és aközött, hogy most hol vagyunk (magyarán volt-e teleportálás)
    	if(this.getPos().isEqualTo(t)){
    		moveDir = Vektor.EnumToDirVec(MoveDirections.Stay);//lépés után (0,0)-a állítjuk a mozgásvektort
    		return;										//ha megegyezik, nincs további teendő.
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
    	moveDir = Vektor.EnumToDirVec(MoveDirections.Stay);//lépés után (0,0)-a állítjuk a mozgásvektort
	}
    
    /**
     * Továbblépés.
     */
    public void step(){
    	elemShiftWithVec(moveDir);
    }
    
    /**
     * Beallítja, hogy merre mozogjon a az objektum.
     * Irányvektort kap.
     * @param dir
     */
    public void setDir(Vektor dir){
    	moveDir = dir;
    }    

    public void kill(Elem e){
    	this.alive = false;
    	lab.refreshList();
    }    
    public int getSuly() {
		return suly;
	}
    public boolean isAccessable(){
    	return true;
    }
    
    //--------------------------------------------------------------------
//	
//	 /**
//    * Létrehoz egy moveable objektumot a megadott vektorral.
//    * A terület bal felső sarkát illeszti a vektorra.
//    * A diagonalban megadott mérettel jön létre.
//    * @param lab
//    * @param kezdLocVec
//    * @param diagonal
//    */
//	public Moveable(Labirintus lab,Vektor kezdLocVec,Vektor diagonal) {
//		super(kezdLocVec,diagonal);
//		moveDir = pos.getMiddleOfArea(); //csak inicializálás, később felülíródik
//	}
}