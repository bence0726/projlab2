package projlab2;
import java.util.*;

/**
 * 
 */
public abstract class Moveable extends Elem{
    protected Vektor moveDir;
    protected Labirintus lab ;
    
	public Moveable(Terulet pos) {
		super(pos);
		// TODO Auto-generated constructor stub
	}

	/**
     * @param dir
     */
    public void move() {
	}
    
    /**
     * Továbblépés.
     */
    public void step(){
    	addDirToArea(moveDir);
    }
    
    /**
     * TODO: a dir-ből csináljon irányvektort!!
     * @param dir
     */
    public void setDir(Vektor dir){
    	moveDir = dir;
    }
}