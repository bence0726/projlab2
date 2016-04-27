package controller;

import model.JatekMotor;
import model.MoveDirections;

public class KarakterController {
	JatekMotor jm;
	
	public KarakterController(JatekMotor gameEngine){
		jm = gameEngine;
	}
	/*
	 * a karaktert kikeresi neve alapján majd a kapott vektorral
	 * eltolja azt, ha nem ütközik olyan pályaelembe, amelyre
	 * a rálépés nem megengedett.
	 * A parancs eredményét visszatérési értékként adja meg. (pl MOVED oneil right 42 42)
	 */
	protected String move(String karakternev, String irany, int mennyi)
	{
		if(karakternev.equals("oneil"))
		{
			switch(irany)
			{
				case "up": jm.setOneilMoveDir(MoveDirections.MoveUp);
				break;
				case "down": jm.setOneilMoveDir(MoveDirections.MoveDown);
				break;
				case "right": jm.setOneilMoveDir(MoveDirections.MoveRight);
				break;
				case "left": jm.setOneilMoveDir(MoveDirections.MoveLeft);
			}
			for(int i=0;i<mennyi;i++)
				jm.moveEverything();
			
			return karakternev+" MOVED "+irany+" "+mennyi;
			
		}
		else if(karakternev.equals("jaffa"))
		{
			switch(irany)
			{
				case "up": jm.setJaffaMoveDir(MoveDirections.MoveUp);
				break;
				case "down": jm.setJaffaMoveDir(MoveDirections.MoveDown);
				break;
				case "right": jm.setJaffaMoveDir(MoveDirections.MoveRight);
				break;
				case "left": jm.setJaffaMoveDir(MoveDirections.MoveLeft);
			}
			for(int i=0;i<mennyi;i++)
				jm.moveEverything();		//ennek nem így kéne lennie szerintem, mert csk külön akarjuk mozgatni a karaktert sokszor
			
			return karakternev+" MOVED "+irany+" "+mennyi;
			
				
		}
		return "Hiba";
		
	}
	
	
	/*
	 * a karaktert neve alapján kikeresi a mozgatandok
	 * listáról és az adott irányba adott színnel elindít egy golyót.
	 */
	protected String fire(String karaternev, int x, int y, String szin)
	{
		return "Még nincs kész";//TODO FIXME csináld meg!
	}
}
