package model;

/**
 * 
 */
public class Fal extends Elem {

	/**
     * 
     */
    private boolean reachable = false;
    
    /**
     * A megadott területre létrejön egy fal elem.
     */
    public Fal(Terulet area) {
    	super(area);
    	image = "fal.jpg";
    	name="Fal";
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
    	name="Fal";
    }
    
    public void shot(Golyo bullet ) {
    	if(reachable)
    		bullet.step(); //ha rá lehet lépni, akkor a golyó elmegy felette
    	else
    		bullet.kill(); //egyébként beleütközik.
    }

    public void steppedon(Moveable X) {
        if(!reachable)
        	return;
        X.step();
    }

	public void setReachable(boolean reachable) {
		this.reachable = reachable;
	}
    
    

}