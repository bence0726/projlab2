package projlab2;
import java.util.*;

/**
 * 
 */
public class Fal extends Elem {

    /**
     * A megadott területre létrejön egy fal elem.
     */
    public Fal(Terulet area) {
    	super(area);
    	image = "fal.jpg";
    }

    /**
     * Létrehoz egy falat, a bal felső sarkát locUpLeftCorner
     * vektorra illesztve. A második paraméter az elem mérete.
     * @param locUpLeftCorner
     * @param diagonal
     */
    public Fal(Vektor locUpLeftCorner,Vektor diagonal) {
    	super(locUpLeftCorner,diagonal);
    	image = "fal.jpg";
    }
    
    /**
     * 
     */
    private boolean reachable;

    /**
     * 
     */
    public void shot(Golyo bullet ) {
    	if(reachable)
    		bullet.step(); //ha rá lehet lépni, akkor a golyó elmegy felette
    	else
    		bullet.kill(); //egyébként beleütközik.
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