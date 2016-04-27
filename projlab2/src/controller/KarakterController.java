package controller;

import model.JatekMotor;
import model.MoveDirections;
import model.Szin;

public class KarakterController {
	JatekMotor jm;
	
	public KarakterController(JatekMotor gameEngine){
		jm = gameEngine;
	}
	/**
	 * A karaktert kikeresi neve alapján majd a kapott vektorral
	 * eltolja azt, ha nem ütközik olyan pályaelembe, amelyre
	 * a rálépés nem megengedett.
	 * A kész programban külön lesz a setmovedir és a move, de
	 * ez a teszteléshez így jobb lesz.
	 */
	public void move(String karakternev, String irany){
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
		else if(karakternev.equals("ONEIL")){
			switch(irany){
				case "UP": jm.setJaffaMoveDir(MoveDirections.MoveUp);
				break;
				case "DOWN": jm.setJaffaMoveDir(MoveDirections.MoveDown);
				break;
				case "RIGHT": jm.setJaffaMoveDir(MoveDirections.MoveRight);
				break;
				case "LEFT": jm.setJaffaMoveDir(MoveDirections.MoveLeft);
			}
			jm.moveEverything();			
		}
	}
	
	/**
	 * A karaktert neve alapján kikeresi a mozgatandók
	 * listáról és az adott irányba adott színnel elindít egy golyót.
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
			jm.setOneilGunDir(angle);	
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
}
