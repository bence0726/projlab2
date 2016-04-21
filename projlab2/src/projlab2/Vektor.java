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
    
    public Vektor addDirVec(Vektor dirVec){
    	int x=0;
    	int y=0;
    	return new Vektor(x,y);
    }
}