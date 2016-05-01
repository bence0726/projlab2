package model;

/**
 * Fal, startelem, végeelem modellbeli reprezentációja.
 */
public class Fal extends Elem {

	/**
     * Rá lehet lépni az elemre? dinamikusan változhat.
     */
    private boolean reachable = false;
    
    /**
     * A megadott területre létrejön egy fal elem.
     */
    public Fal(Terulet area) {
    	super(area);
    }

    /**
     * Létrehoz egy falat, a bal felső sarkát locUpLeftCorner
     * vektorra illesztve. A második paraméter az elem mérete.
     * @param locUpLeftCorner
     * @param diagonal
     */
    public Fal(Vektor locUpLeftCorner,Vektor diagonal) {
    	super(locUpLeftCorner,diagonal);
    }
    
    public void shot(Golyo bullet ) {
    	if(reachable)
    		bullet.step(); //ha rá lehet lépni, akkor a golyó elmegy felette
    	else
    		bullet.kill(null); //egyébként beleütközik.
    }

    public boolean steppedon(Moveable X) {
        if(!reachable)
        	return false;
        X.step();
        return true;
    }

	public void setReachable(boolean reachable) {
		this.reachable = reachable;
	}
	public boolean isAccessable(){
		return reachable;
	}
    
    

}