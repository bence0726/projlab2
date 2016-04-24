package projlab2;
import java.util.*;

/**
 * Nyerés feltételei: nincs több ZPM a labirintusban ÉS annál a karakternél van több ZPM, aki a VégeElemre lép
 * TODO befejezni!
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
   public void moveEverything(){
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
     * Lövés Jaffával a paraméterül kapott színnel.
     * @param szin - ilyen színűt fogunk lőni.
     */
    public void jaffaFire(Szin szin){
    	lab.getJaffa().Fire(szin);
    }
    /**
    * Lövés Oneillel a paraméterül kapott színnel.
    * @param szin - ilyen színűt fogunk lőni.
    */
   public void OneilFire(Szin szin){
	   lab.getOneil().Fire(szin);
   }
   /**
    * Tárgy felvétele Jaffával.
    */
   public void jaffaPick(){
	   lab.getJaffa().Pick();
   }
   /**
    * Tárgy felvétele Oneillel.
    */
   public void oneilPick(){
	   lab.getOneil().Pick();
   }
   /**
    * Doboz lerakása Jaffával.
    */
   public void jaffaDrop(){
	   lab.getJaffa().Drop();
   }

   /**
    * Doboz lerakása Oneillel.
    */
   public void oneilDrop(){
	   lab.getOneil().Drop();
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