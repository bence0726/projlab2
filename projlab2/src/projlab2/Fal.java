package projlab2;
import java.util.*;

/**
 * 
 */
public class Fal extends Elem {

    /**
     * Default constructor
     */
    public Fal(Terulet area) {
    	super(area);
    }

    /**
     * 
     */
    private boolean reachable;

    /**
     * 
     */
    public void shot(Golyo bullet ) {
        bullet.kill();
    }

    /**
     * @param e
     */
    public void steppedon(Moveable X) {
        if(!reachable)
        	return;
        X.step();
    }


	public void setReachable(boolean reachable) {
		this.reachable = reachable;
	}
    
    

}