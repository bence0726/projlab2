package projlab2;
import java.util.*;

/**
 * 
 */
public class Vektor {

    /**
     * 
     */
    private int vx;

    /**
     * 
     */
    private int vy;

    /**
     * @param x 
     * @param y
     */
    
    public Vektor(){}
    public Vektor(int x, int y) {
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
    public void setVx(int val) {
    	vx=val; 
    }

    /**
     * @param val
     */
    public void setVy(int val) {
        vy =val;
    	
    }

    /**
     * @return
     */
    public int getVx() {
        return vx;
    }

    /**
     * @return
     */
    public int getVy() {
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
    public Vektor addVecToVec(Vektor vec1,Vektor vec2){
    	Vektor newvec = new Vektor(vec1);
    	newvec.addVec(vec2);
    	return newvec;
    }
   /**
    * Visszaadja a paraméterül kapott vektor inverzét.
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
    public void inverseVec(){
    	this.vx=this.vx*-1;
    	this.vy=this.vy*-1;
    }
}