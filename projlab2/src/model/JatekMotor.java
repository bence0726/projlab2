package model;
import java.util.*;

/**
 * a játék futásáért, szabályainak betartásáért felel.
 * Ő lépteti a mozgatható karaktereket is.
 */
public class JatekMotor {
    private Labirintus lab;    
    public PortalManager pm;
    public String nyertes = "nincs.";
    
    /**
     * JM konstruktor. Létrehoz egy labirintust
     * és egy portalmanagert.
     */
    public JatekMotor() {    	
    	pm = new PortalManager();
    	lab = new Labirintus();    	
    }
    
   /**
    * A labirintus moveable listáján lévő objektumokat
    * megmozgatja mind. 
    */
   public void moveEverything(){
	   ArrayList<Moveable> list = lab.getMoveableList();
	   for(int i = 0; i < list.size(); i++){
		   list.get(i).move();
	   }
   }

    /**
     * Megnézi, hogy teljesültek-e a nyerés feltételei.
     */
    public boolean isEndGame() {
    	Elem e=lab.getEndElem();
    	if (e.isCoveredByThis(lab.getOneil()) && (lab.getOneil().getZPM() > lab.getJaffa().getZPM()) && lab.getOsszZPM() == 0){
    		nyertes = "O'neill";
    		return true;
    	}
    			
    	if (e.isCoveredByThis(lab.getJaffa()) && (lab.getOneil().getZPM() < lab.getJaffa().getZPM()) && lab.getOsszZPM()== 0){
    		nyertes = "Jaffa";
    		return true;
    	}
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
     * Lövés Jaffával a paraméterül kapott színnel.
     * @param colour - ilyen színűt fogunk lőni.
     */
    public void jaffaFire(Szin colour){
    	lab.getJaffa().Fire(colour);
    }
    /**
    * Lövés Oneillel a paraméterül kapott színnel.
    * @param colour - ilyen színűt fogunk lőni.
    */
   public void OneilFire(Szin colour){
	   lab.getOneil().Fire(colour);
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
    /**
     * Specfal létrehozásakor ezt kell hívni
     */
    public PortalManager getPortalManager(){
    	return pm;
    }
}