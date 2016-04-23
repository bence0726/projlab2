package projlab2;
import java.util.*;

/**
 * 
 */
public abstract class Moveable extends Elem{
    protected Vektor moveDir;
    protected Labirintus lab;
    
	public Moveable(Terulet pos) {
		super(pos);
		
		// TODO Auto-generated constructor stub
	}

	/**
	 * Hívására az objektum elmozdul moveDir irányába.
	 */
	public void move(){//Leszármazottakban felüldefiniáljuk
	}
    
    /**
     * Továbblépés.
     */
    public void step(){
    	elemShiftWithVec(moveDir);
    }
    
    /**
     * Beallítja, hogy merre mozogjon a az objektum.
     * Irányvektort kap.
     * @param dir
     */
    public void setDir(Vektor dir){
    	moveDir = dir;
    }
    
}