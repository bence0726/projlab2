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
    
    /**
     * Jaffa mozgás-vektorát állítja a kívánt értékre.
     * UP: felfelé,
     * DOWN: lefelé,
     * RIGHT: jobbra,
     * LEFT: balra,
     * STAY: helyben marad.
     */
    public void setJaffaMoveDir(MoveDirections direction){
    	lab.getJaffa().setDir(Vektor.EnumToDirVec(direction));
    }
    
    /**
     * Jaffa fegyverét forgatja a kívánt szöggel
     * @param angle
     */
    public void setJaffaGunDir(double angle){
    	lab.getJaffa().rotateGunDir(angle);
    }
    /**
     * Oneil mozgás-vektorát állítja a kívánt értékre.
     * UP: felfelé,
     * DOWN: lefelé,
     * RIGHT: jobbra,
     * LEFT: balra,
     * STAY: helyben marad.
     */
    public void setOneilMoveDir(MoveDirections direction){
    	lab.getOneil().setDir(Vektor.EnumToDirVec(direction));
    }
    /**
     * Oneil fegyverét forgatja a kívánt szöggel
     * @param angle
     */
    public void setOneilGunDir(double angle){
    	lab.getOneil().rotateGunDir(angle);
	}
    /**
     * Ahhoz kell, hogy a pályaelemeket egy másik osztály rá tudja pakolni.
     * Így nem a JátékMotorban kell legyen a sok okosság.
     * @return
     */
    public Labirintus getLab(){
    	return lab;
    }
}