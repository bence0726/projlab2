package controller;

import model.JatekMotor;
import model.MoveDirections;
import model.Szin;
import model.Vektor;

/**
 * Az osztály segítségével tudja a tesztelő 
 * elérni a modellt, azon változtatásokat végrehajtani.
 * @author zsigatibor *
 */
public class KarakterController {
	
	private JatekMotor jm;
	
	
	public KarakterController(JatekMotor gameEngine){
		jm = gameEngine;
	}
	
	/**
	 * A karaktert kikeresi neve alapján majd a kapott vektorral
	 * eltolja azt, ha nem ütközik olyan pályaelembe, amelyre
	 * a rálépés nem megengedett.
	 */
	public void setKarDir(String karakternev, MoveDirections moveDir){
		if(karakternev.equals("ONEIL") && jm.getLab().getOneil().isAlive()){
			jm.setOneilMoveDir(moveDir);
			return;
		}
		if(karakternev.equals("JAFFA") && jm.getLab().getJaffa().isAlive()){
			jm.setJaffaMoveDir(moveDir);
		}
	}
	
	/**
	 * Adott karakterrel adott színű golyót lő.
	 * A fegyver irányát nem ez a függvény állítja be,
	 * ez csupán a lövésért felel.
	 */
	public void fire(String karakternev, Szin szin){
		if(karakternev.equals("ONEIL")&& jm.getLab().getOneil().isAlive()){
			jm.OneilFire(szin);
			return;
		}
		if(karakternev.equals("JAFFA")&& jm.getLab().getJaffa().isAlive())
			jm.jaffaFire(szin);
	}	
	
	/**
	 * Elfordítja a hivatkozott karakter fegyverét a 
	 * paraméterül kapott szöggel.
	 */
	public void rotateGun(String karakternev, double angle) {
		if(karakternev.equals("ONEIL")){
			jm.setOneilGunDir(angle);
			return;
		}			
		if(karakternev.equals("JAFFA"))
			jm.setJaffaGunDir(angle);	
	}
	
	/**
	 * Meghívja a karakter pick metódusát.
	 */
	public void pick(String karakternev) {
		if(karakternev.equals("ONEIL") && jm.getLab().getOneil().isAlive()){
			jm.oneilPick();
			return;
		}			
		if(karakternev.equals("JAFFA"))
			jm.jaffaPick();
	}
	
	/**
	 * Meghívja a karakter drop metódusát.
	 */
	public void drop(String karakternev) {
		if(karakternev.equals("ONEIL")&& jm.getLab().getOneil().isAlive()){
			jm.oneilDrop();
			return;
		}			
		if(karakternev.equals("JAFFA")&& jm.getLab().getJaffa().isAlive())
			jm.jaffaDrop();
	}
	
	/**
	 * Stringgé parsolva visszaadja a karakter koordinátáit.
	 */
	public String getpos(String karakternev) {
		Vektor v = new Vektor(0,0);
		if(karakternev.equals("ONEIL"))
			v = jm.getLab().getOneil().getPos().getKezd();
		if(karakternev.equals("JAFFA"))
			v = jm.getLab().getJaffa().getPos().getKezd();
		double x = v.getVx();
		double y = v.getVy();		
		return String.valueOf(Math.round(x) + " " + Math.round(y));//kerekítjük, így pl 50.0 helyett 50-et ír ki
	}
}
