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
     * Hozzáadja a paraméterként kapott vektort(A)
     * ahhoz a vektorhoz amin hívtuk a függvényt.
     * @param dirVec
     * @return
     */
    public Vektor addVec(Vektor vec){
    	this.vx=this.vx+vec.getVx();
    	this.vy=this.vy+vec.getVy();
    	return this;
    }
    /**
     * Kivonja a paraméterül kapott vektort(B) abból
     * amin hívjuk a függvényt(A).Így az eredményvektor
     * az A vektor végébe fog mutatni.
     * @param vec
     * @return
     */
    public Vektor subVec(Vektor vec){
    	this.vx=this.vx-vec.getVx();
    	this.vy=this.vy-vec.getVy();
    	return this;
    }	
    public Vektor beEqual(Vektor vec){
    	this.vx = vec.getVx();
    	this.vy = vec.getVy();
    	return this;
    }
}