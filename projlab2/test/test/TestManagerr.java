package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import controller.KarakterController;
import controller.MapBuilder;
import model.JatekMotor;

/**
 * Ez az osztály fogja tartalmazni a teszt-objektumokat,
 * azokat futtatni, illetve a statisztikájukat elkészíteni.
 * @author zsigatibor
 *
 */
public class TestManagerr {
	
	JatekMotor jm;
	MapBuilder mb;
	KarakterController kc;
	
	List<TestObject> TOList = new ArrayList<>();
	
	public TestManagerr(JatekMotor gameEngine){
		jm = gameEngine;
		mb = new MapBuilder(jm);
		kc = new KarakterController(jm);
	}
	
	/**
	 * Hozzáadja a paraméterül kapott objektumot a listához.
	 */
	public void addTestObject(TestObject TO){
		TOList.add(TO);
	}
	/**
	 * Az összes tesztobjektum futtatása.
	 */
	public void runAll(){
		Iterator<TestObject> it = TOList.iterator();
		while(it.hasNext()){
			run(it.next());
		}
	}
	/**
	 * A paraméterül kapott tesztet futtatja.
	 */
	private void run(TestObject TO){
		
	}
	
	
}
