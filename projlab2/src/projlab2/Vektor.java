package projlab2;
import java.util.*;

/**
 * 
 */
public class Vektor {

    /**
     * 
     */
    private double vx;

    /**
     * 
     */
    private double vy;

    /**
     * @param x 
     * @param y
     */
    
//    public Vektor(){} - szerintem ez nem kell.
    public Vektor(double x, double y) {
        // TODO implement here
    	vx=x;
    	vy=y;
    }

    public Vektor(Vektor vec) {
		vx = vec.getVx();
		vy = vec.getVy();
	}

	/**
     * @param val
     */
    public void setVx(double val) {
    	vx=val; 
    }

    /**
     * @param val
     */
    public void setVy(double val) {
        vy =val;
    	
    }

    /**
     * @return
     */
    public double getVx() {
        return vx;
    }

    /**
     * @return
     */
    public double getVy() {
        return vy;
    }
    /**
     * Hozzáadja a vektorhoz(A) paraméterként kapott vektort(B).
     * @param dirVec
     * @return
     */
    public void addVec(Vektor vec){
    	this.vx=this.vx+vec.getVx();
    	this.vy=this.vy+vec.getVy();
    	//return this;
    }
    /**
     * Kivonja a vektorból(A) a paraméterül kapott vektort(B).Így az eredményvektor
     * az A vektor végébe fog mutatni.
     * @param vec
     * @return
     */
    public void subVec(Vektor vec){
    	this.vx=this.vx-vec.getVx();
    	this.vy=this.vy-vec.getVy();
    	//return this;
    }
    
    public static Vektor getHalfOf(Vektor vec){
    	Vektor temp = new Vektor(vec);
    	temp.vx= temp.vx/2;
    	temp.vy=temp.vy/2;
    	return temp;
    }
    /**
     * A vektort egyenlővé teszi a paraméterül kapott vektorral.
     * @param vec
     * @return
     */
    public void beEqualWith(Vektor vec){
    	this.vx = vec.getVx();
    	this.vy = vec.getVy();
    }
    /**
     * Összeadja a 2 paraméterül kapott vektort és visszatér
     * az eredménnyel anélkül hogy 2 paraméterül kapott vektoron
     * vagy azon ami hívja a függvényt változtatna.
     * @param vec1
     * @param vec2
     * @return newvec
     */
    public static Vektor addVecToVec(Vektor vec1,Vektor vec2){
    	Vektor newvec = new Vektor(vec1);
    	newvec.addVec(vec2);
    	return newvec;
    }
   /**
    * Visszaadja a vektor inverzét.
    * @param vec
    * @return newvec
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
    	this.vx=this.vx*-1;
    	this.vy=this.vy*-1;
    }
    /**
     * Visszatér egy Random vektorral.
     * @param justFourDir :True-Csak 4 irány ; False-bármennyi irány.
     * @return
     */
    public static Vektor randomDir(boolean justFourDir){
    	Random rand = new Random();
    	Vektor temp = null;
    	if (!justFourDir)
    		//randomizálunk egy double 0 és 1 között majd megszorozzunk egy random számmal -1 és 1 között hogy
    		//mind a 4 irányba randomizáljon
    		temp = new Vektor(rand.nextDouble()*(double)rand.nextInt(2)-1,rand.nextDouble()*(double)rand.nextInt(2)-1);
    	else
    		temp = new Vektor((double)rand.nextInt(2)-1,(double)rand.nextInt(2)-1);
    	return temp;
    }
    
    public boolean isEqualTo(Vektor v){
    	Double d1= new Double(this.vx);
    	Double d2= new Double(this.vy);
    	Double d3= new Double(v.getVx());
    	Double d4= new Double(v.getVy());
    	return ((d1.compareTo(d3)==0) && (d2.compareTo(d4)==0));
    }
    
    /**
     * A kapott enum értéke szerint készít egy 1 hosszú irányvektort.
     * Ha az enum értéke Stay, helyben maradunk, 0,0 helyvektort ad át.
     * @param direnum
     * @return a kívánt irányvektor
     */
    public static Vektor EnumToDirVec(MoveDirections direnum){
    	switch(direnum){
    	case MoveUp:
    		return new Vektor(0,1);
    	case MoveDown:
    		return new Vektor(0,-1);
    	case MoveRight:
    		return new Vektor(1,0);
    	case MoveLeft:
    		return new Vektor(-1,0);
    	case Stay:
    		return new Vektor(0,0);
    	default:
    		return new Vektor(0,0);
    	}
    }
}