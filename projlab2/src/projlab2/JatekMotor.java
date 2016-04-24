package projlab2;
import java.util.*;

/**
 * Nyerés feltételei: nincs több ZPM a labirintusban ÉS annál a karakternél van több ZPM, aki a VégeElemre lép
 * 
 */
public class JatekMotor {

    /**
     * Default constructor
     */
    public JatekMotor() {
    }



    /**
     * 
     */
    private Labirintus lab;




    /**
     * 
     */
    public ArrayList<Moveable> mozgatandok;

    /**
     * A játék indításakor hívjuk. Új labirintus objektumot hoz létre.
     */    
    public void startGame() {
        lab = new Labirintus();        
    }

    /**
     * 
     */
    public void Reset() {
        // TODO implement here
    }

    /**
     * 
     */
    public boolean isEndGame() {
        // TODO implement here
    	lab.getZPM();
    	Elem e=lab.getVegeElem();
    	Terulet t = e.getPos();
//    	if ()
    	return false; //TODO FIXME folytatni
    }
    
    public void setJaffaMoveDir(){
    	
    }
    public void setJaffaGunDir(){
	
    }
    public void setOneilMoveDir(){
	
    }
    public void setOneilGunDir(){
	
	}
}