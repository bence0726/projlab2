package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import controller.KarakterController;
import controller.MapBuilder;
import model.Elem;
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
	List<String> AllTestsOutput = new ArrayList<>();
	ArrayList<String> OneTestOutput = newArrayList<>();
	
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
		String command;
		
		while((command = TO.nextCommand()) != null){
			String[] pieces = command.split(" ");
			switch(pieces[0]){
			case "ADD":
				switch (pieces[1]) {
				case "FAL":
					List<Elem> list = jm.getLab().getList();
					int beforeAdd = list.size();
					mb.addFal(Integer.parseInt(pieces[2]),
							Integer.parseInt(pieces[3]),
							Integer.parseInt(pieces[4]),
							Integer.parseInt(pieces[5]));					
					int afterAdd = list.size();
					if(beforeAdd < afterAdd)
						OneTestOutput.add("")
						
					break;
				case "FAL":
	
					break;
				case "FAL":
	
					break;
				case "FAL":
	
					break;
	

				default:
					break;
				}
			}
		}
				
		
		
	}
	/**
	 * Visszaad egy statisztikát a futtatott tesztekről.
	 */
	public List<String>getStatistics(){
		return null;
		
	}
	
	/**
	 * visszaadja, hogy hány db ZPM van a labirintusban.
	 */
	protected int getZPMinLab(){
		return jm.getLab().getOsszZPM();
	}
}
