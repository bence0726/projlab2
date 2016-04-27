package test;

import controller.KarakterController;
import controller.MapBuilder;
import model.JatekMotor;

/**
 * Ez az osztály fogja tartalmazni a teszt-objektumokat,
 * azokat futtatni, illetve a statisztikájukat elkészíteni.
 * @author zsigatibor
 *
 */
public class TestManager {
	
	JatekMotor jm;
	MapBuilder mb;
	KarakterController kc;
	
	public TestManager(JatekMotor gameEngine){
		jm = gameEngine;
		mb = new MapBuilder(jm);
		kc = new KarakterController(jm);
	}
	
	
}
