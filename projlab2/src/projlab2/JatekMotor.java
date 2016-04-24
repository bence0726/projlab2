package projlab2;
import java.util.*;

/**
 * Nyerés feltételei: nincs több ZPM a labirintusban ÉS annál a karakternél van több ZPM, aki a VégeElemre lép
 * 
 */
public class JatekMotor {

    /**
     * JM konstruktor. Létrehoz egy labirintust.
     */
    public JatekMotor() {
    	lab = new Labirintus();
    }

    /**
     * 
     */
    private Labirintus lab;
    
   /**
    * A labirintus moveable listáján lévő objektumokat
    * megmozgatja mind. 
    */
   public void MoveEverything(){
	   Iterator<Moveable> iterator = lab.getMoveableList().iterator();
	   while(iterator.hasNext())
		   iterator.next().move();
   }

    /**
     * 
     */
    public boolean isEndGame() {
    	Elem e=lab.getEndElem();
    	if (e.isCoveredByThis(lab.getOneil()) && (lab.getOneil().getZPM() > lab.getJaffa().getZPM()) && lab.getOsszZPM()==0)
    			return true;
    	if (e.isCoveredByThis(lab.getJaffa()) && (lab.getOneil().getZPM() < lab.getJaffa().getZPM()) && lab.getOsszZPM()==0)
			return true;
    	return false;
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