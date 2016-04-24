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