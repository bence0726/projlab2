package model;
import java.util.*;

/**
 * 
 */
public abstract class Moveable extends Elem{
    protected Vektor moveDir;
    protected Labirintus lab;
    protected int suly;
    public String name;
    
    /**
     * Létrehoz egy moveable objektumot a közepét a 
     * megadott vektorra illesztve.
     * Default mérettel jön létre 10*10 pixel méretben.
     * @param lab
     * @param kezdLocVec
     */
	public Moveable(Labirintus lab,Vektor locMiddleofArea) {
		Vektor diagonal = defaultsize ;
    	diagonal = Vektor.getHalfOf(diagonal);
    	pos.setKezd(Vektor.addVecToVec(locMiddleofArea, diagonal));
    	diagonal.invertThisVec();
    	pos.setVeg(Vektor.addVecToVec(locMiddleofArea, diagonal));
		this.lab = lab;
		moveDir = pos.getMiddleOfArea(); //csak inicializálás, később felülíródik
		
	}

	
    /**
     * Létrehoz egy moveable objektumot az elem 
     * közepére illesztve a moveable objektumot.
     * Default mérettel jön létre 10*10 pixel méretben.
     * @param lab
     * @param startElem
     */
	public Moveable(Labirintus lab,Elem startElem){
		Vektor locMiddleofArea = startElem.pos.getMiddleOfArea();
		Vektor diagonal = defaultsize ;
    	diagonal = Vektor.getHalfOf(diagonal);
    	pos.setKezd(Vektor.addVecToVec(locMiddleofArea, diagonal));
    	diagonal.invertThisVec();
    	pos.setVeg(Vektor.addVecToVec(locMiddleofArea, diagonal));
		this.lab = lab;
		moveDir = pos.getMiddleOfArea(); //csak inicializálás, később felülíródik
	}
	
	public Moveable(){}

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
    	
    	//megnézzük, hogy van-e különbség aközött, hogy hová szerettünk volna
    	//lépni és aközött, hogy most hol vagyunk (magyarán volt-e teleportálás)
    	if(this.getPos().equals(t))	
    		return;										//ha megegyezik, nincs további teendő.
    	
    	//ha még itt járunk, volt teleportálás.
    	//megnézzük, hogy a másik oldalon mire léptünk rá. Ezeken steppedon()-t hívjuk    	
    	Iterator<Elem> iteratorItemsNewPlace = itemsNewPlace.iterator();
    	
    	while(iteratorItemsNewPlace.hasNext()){
    		Elem temp = iteratorItemsNewPlace.next();
    		temp.steppedon(this);
    	}
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

    public void kill(){
    	this.alive = false;
    	lab.refreshList();
    }    
    public int getSuly() {
		return suly;
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