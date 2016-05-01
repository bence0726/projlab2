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
	
	JatekMotor jm;
	
	
	public KarakterController(JatekMotor gameEngine){
		jm = gameEngine;
	}
	
	/**
	 * A karaktert kikeresi neve alapján majd a kapott vektorral
	 * eltolja azt, ha nem ütközik olyan pályaelembe, amelyre
	 * a rálépés nem megengedett.
	 */
	public void setKarDir(String karakternev, String irany){
		if(karakternev.equals("ONEIL")){
			switch(irany){
				case "UP": jm.setOneilMoveDir(MoveDirections.MoveUp);
				break;
				case "DOWN": jm.setOneilMoveDir(MoveDirections.MoveDown);
				break;
				case "RIGHT": jm.setOneilMoveDir(MoveDirections.MoveRight);
				break;
				case "LEFT": jm.setOneilMoveDir(MoveDirections.MoveLeft);
			}
		}
		else if(karakternev.equals("JAFFA")){
			switch(irany){
				case "UP": jm.setJaffaMoveDir(MoveDirections.MoveUp);
				break;
				case "DOWN": jm.setJaffaMoveDir(MoveDirections.MoveDown);
				break;
				case "RIGHT": jm.setJaffaMoveDir(MoveDirections.MoveRight);
				break;
				case "LEFT": jm.setJaffaMoveDir(MoveDirections.MoveLeft);
			}
		}
	}
	
	/**
	 * Adott karakterrel adott színű golyót lő.
	 * A fegyver irányát nem ez a függvény állítja be,
	 * ez csupán a lövésért felel.
	 */
	public void fire(String karakternev, String szin){
		if(karakternev.equals("ONEIL")){
			switch (szin) {
			case "BLUE":
				jm.OneilFire(Szin.Kek);
				break;
			case "RED":
				jm.OneilFire(Szin.Piros);
				break;
			case "GREEN":
				jm.OneilFire(Szin.Zold);
				break;
			case "YELLOW":
				jm.OneilFire(Szin.Sarga);
				break;
			default:
				break;
			}
			return;
		}
		if(karakternev.equals("JAFFA")){
			switch (szin) {
			case "BLUE":
				jm.jaffaFire(Szin.Kek);
				break;
			case "RED":
				jm.jaffaFire(Szin.Piros);
				break;
			case "GREEN":
				jm.jaffaFire(Szin.Zold);
				break;
			case "YELLOW":
				jm.jaffaFire(Szin.Sarga);
				break;
			default:
				break;
			}
		}
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
		if(karakternev.equals("ONEIL")){
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
		if(karakternev.equals("ONEIL")){
			jm.oneilDrop();
			return;
		}			
		if(karakternev.equals("JAFFA"))
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
