package model;
import java.util.*;

/**
 * Ez a segédosztály pont-párok tárolására
 * lett megalkotva.
 */
public class Vektor {

	/**
	 * X koordináta
	 */
    private double vx;
    
    /**
     * Y koordináta
     */
    private double vy;

    public Vektor(double x, double y) {
    	vx=x;
    	vy=y;
    }

    /**
     * A paraméterül kapott vektorból készít új vektort.
     */
    public Vektor(Vektor vec) {
		vx = vec.getVx();
		vy = vec.getVy();
	}
    
    /**
     * Hozzáadja a vektorhoz(A) paraméterként kapott vektort(B).
     */
    public void addVec(Vektor vec){
    	this.vx = this.vx+vec.getVx();
    	this.vy = this.vy+vec.getVy();
    }
    /**
     * Kivonja a vektorból(A) a paraméterül kapott vektort(B).Így az eredményvektor
     * az A vektor végébe fog mutatni.
     */
    public void subVec(Vektor vec){
    	this.vx = this.vx - vec.getVx();
    	this.vy = this.vy - vec.getVy();
    }    
    
    /**
     * A vektort egyenlővé teszi a paraméterül kapott vektorral.
     */
    public void beEqualWith(Vektor vec){
    	this.vx = vec.getVx();
    	this.vy = vec.getVy();
    }
    
   /**
    * Visszaadja a vektor inverzét.
    */
    public Vektor getInverseVec(){
    	Vektor newvec = new Vektor(this);
    	newvec.setVx(newvec.getVx()*-1);
    	newvec.setVy(newvec.getVy()*-1);
    	return newvec;
    }
    
    /**
     * Invertálja a vektort.
     */
    public void invertThisVec(){
    	this.vx = this.vx * (-1);
    	this.vy = this.vy * (-1);
    }    
    
    /**
     * Megnézi, hogy a hívó objektum koordinátái
     * megegyeznek-e a paraméterül kapott vektor
     * koordinátáival.
     */
    public boolean isEqualTo(Vektor v){
    	Double d1= new Double(this.vx);
    	Double d2= new Double(this.vy);
    	Double d3= new Double(v.getVx());
    	Double d4= new Double(v.getVy());
    	return ((d1.compareTo(d3)==0) && (d2.compareTo(d4)==0));
    }
    
    /**
     * @return Egy olyan vektor, ami a paraméterül kapott
     * vektor irányába mutat, hossza pedig fele akkora.
     */
    public static Vektor getHalfOf(Vektor vec){
    	Vektor temp = new Vektor(vec);
    	temp.vx = temp.vx/2;
    	temp.vy = temp.vy/2;
    	return temp;
    }
    
    /**
     * Összeadja a 2 paraméterül kapott vektort és visszatér
     * az eredménnyel anélkül, hogy 2 paraméterül kapott vektoron
     * vagy azon ami hívja a függvényt változtatna.
     */
    public static Vektor addVecToVec(Vektor vec1,Vektor vec2){
    	Vektor newvec = new Vektor(vec1);
    	newvec.addVec(vec2);
    	return newvec;
    }
    
    /**
     * Visszatér egy Random vektorral.
     * @param justFourDir :True-Csak 4 irány ; False-bármennyi irány.
     */
    public static Vektor randomDir(boolean justFourDir){
    	Random rand = new Random();
    	Vektor temp = null;
    	if (!justFourDir)
    		//randomizálunk egy double 0 és 1 között majd megszorozzunk egy random számmal -1 és 1 között hogy
    		//mind a 4 irányba randomizáljon
    		temp = new Vektor(rand.nextDouble()*(double)rand.nextInt(2)-1,rand.nextDouble()*(double)rand.nextInt(2)-1);
    	else
    		temp = new Vektor((double)rand.nextInt(7)-3,(double)rand.nextInt(7)-3);
    	return temp;
    }
    
    /**
     * A kapott enum értéke szerint készít egy 1 hosszú irányvektort.
     * Ha az enum értéke Stay, helyben maradunk, (0,0) helyvektort ad át.
     * @return a kívánt irányvektor
     */
    public static Vektor EnumToDirVec(MoveDirections direnum){
    	switch(direnum){
    	case MoveUp:
    		return new Vektor(0,-2);
    	case MoveDown:
    		return new Vektor(0,2);
    	case MoveRight:
    		return new Vektor(2,0);
    	case MoveLeft:
    		return new Vektor(-2,0);
    	case Stay:
    		return new Vektor(0,0);
    	default:
    		return new Vektor(0,0);
    	}
    }
    
    /**
     * Ezzel a függvénnyel a kapott vektorból létrehoz egy 
     * skálázott vektort.
     * @param vec1 - a vektor, amelyből új vektort állítunk elő
     * @param i - a vektor skálázásának mértéke.
     * @return - egy új Vektor objektum, mely a paraméterül kapott
     * vektort i-szeresére nyújtotta. 
     */
    public static Vektor VektorMultiplication(Vektor vec1,int i){
    	Vektor newvec = new Vektor(vec1);
    	newvec.vx = newvec.vx*i;
    	newvec.vy = newvec.vy*i;
    	return newvec;
    }
    
    public static Vektor VektorMultiplicationWithDouble(Vektor vec1,double i){
    	Vektor newvec = new Vektor(vec1);
    	newvec.vx = Math.round(newvec.vx*i);
    	newvec.vy = Math.round(newvec.vy*i);
    	return newvec;
    }
    
    /*
     * getterek, setterek:
     */
    
    public void setVx(double val) {
    	vx = val; 
    }

    public void setVy(double val) {
        vy = val;
    }

    public double getVx() {
        return vx;
    }

    public double getVy() {
        return vy;
    }
}