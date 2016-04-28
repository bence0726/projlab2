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
	ArrayList<String> OneTestOutput = new ArrayList<>();
	
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
			jm = new JatekMotor();
			mb = new MapBuilder(jm);//mindenből új példány, tiszta tesztelés
			kc = new KarakterController(jm);
		}
	}
	/**
	 * A paraméterül kapott tesztet futtatja.
	 */
	private void run(TestObject TO){
		String command;
		int beforeAdd;
		int afterAdd;
		
		while((command = TO.nextCommand()) != null){
			List<Elem> list = jm.getLab().getList();
			String[] pieces = command.split(" ");
			switch(pieces[0]){
			case "ADD":
				switch (pieces[1]) {
				case "FAL":
					beforeAdd = list.size();
					mb.addFal(Integer.parseInt(pieces[2]),
							Integer.parseInt(pieces[3]),
							Integer.parseInt(pieces[4]),
							Integer.parseInt(pieces[5]));					
					afterAdd = list.size();					
					if(beforeAdd < afterAdd)//megvizsgáljuk, hogy nőtt-e a lista mérete
						OneTestOutput.add("FAL ADDED");//(vagyis bekerült-e az elem)
					else
						OneTestOutput.add("ADDING FAL FAILED");
					break;
				case "SPECFAL":
					beforeAdd = list.size();
					mb.addSpecFal(Integer.parseInt(pieces[2]),
							Integer.parseInt(pieces[3]),
							Integer.parseInt(pieces[4]),
							Integer.parseInt(pieces[5]),
							Integer.parseInt(pieces[6]),
							Integer.parseInt(pieces[7]));					
					afterAdd = list.size();
					if(beforeAdd < afterAdd)
						OneTestOutput.add("SPECFAL ADDED");
					else
						OneTestOutput.add("ADDING SPECFAL FAILED");
					break;
				case "STARTELEM":
					beforeAdd = list.size();
					mb.addStartElem(Integer.parseInt(pieces[2]),
							Integer.parseInt(pieces[3]),
							Integer.parseInt(pieces[4]),
							Integer.parseInt(pieces[5]));					
					afterAdd = list.size();
					if(beforeAdd < afterAdd)
						OneTestOutput.add("STARTELEM ADDED");	
					else
						OneTestOutput.add("ADDING STARTELEM FAILED");
					break;
				case "ENDELEM":
					beforeAdd = list.size();
					mb.addEndElem(Integer.parseInt(pieces[2]),
							Integer.parseInt(pieces[3]),
							Integer.parseInt(pieces[4]),
							Integer.parseInt(pieces[5]));					
					afterAdd = list.size();
					if(beforeAdd < afterAdd)
						OneTestOutput.add("ENDELEM ADDED");	
					else
						OneTestOutput.add("ADDING ENDELEM FAILED");
					break;
				case "SZAKADEK":
					beforeAdd = list.size();
					mb.addSzakadek(Integer.parseInt(pieces[2]),
							Integer.parseInt(pieces[3]),
							Integer.parseInt(pieces[4]),
							Integer.parseInt(pieces[5]));					
					afterAdd = list.size();
					if(beforeAdd < afterAdd)
						OneTestOutput.add("SZAKADEK ADDED");
					else
						OneTestOutput.add("ADDING SZAKADEK FAILED");
					break;
				case "ZPM":
					beforeAdd = list.size();
					mb.addZPM(Integer.parseInt(pieces[2]),
							Integer.parseInt(pieces[3]),
							Integer.parseInt(pieces[4]),
							Integer.parseInt(pieces[5]));					
					afterAdd = list.size();
					if(beforeAdd < afterAdd)
						OneTestOutput.add("ZPM ADDED");
					else
						OneTestOutput.add("ADDING ZPM FAILED");
					break;					
				case "REPLIKATOR":
					beforeAdd = list.size();
					mb.addReplikator();					
					afterAdd = list.size();
					if(beforeAdd < afterAdd)
						OneTestOutput.add("REPLIKATOR ADDED");	
					else
						OneTestOutput.add("ADDING REPLIKATOR FAILED");
					break;
				case "DOBOZ":
					beforeAdd = list.size();
					mb.addDoboz(Integer.parseInt(pieces[2]),
							Integer.parseInt(pieces[3]),
							Integer.parseInt(pieces[4]),
							Integer.parseInt(pieces[5]),
							Integer.parseInt(pieces[6]));					
					afterAdd = list.size();
					if(beforeAdd < afterAdd)
						OneTestOutput.add("DOBOZ ADDED");
					else
						OneTestOutput.add("ADDING DOBOZ FAILED");
					break;
				case "MERLEG":
					beforeAdd = list.size();
					mb.addMerleg(Integer.parseInt(pieces[2]),
							Integer.parseInt(pieces[3]),
							Integer.parseInt(pieces[4]),
							Integer.parseInt(pieces[5]),
							Integer.parseInt(pieces[6]),
							Integer.parseInt(pieces[7]),
							Integer.parseInt(pieces[8]),
							Integer.parseInt(pieces[9]),
							Integer.parseInt(pieces[10]));					
					afterAdd = list.size();
					if(beforeAdd < afterAdd)
						OneTestOutput.add("MERLEG ADDED");
					else
						OneTestOutput.add("ADDING MERLEG FAILED");
					break;
				case "JAFFA":
					beforeAdd = list.size();
					mb.addJaffa();					
					afterAdd = list.size();
					if(beforeAdd < afterAdd)
						OneTestOutput.add("JAFFA ADDED");	
					else
						OneTestOutput.add("ADDING JAFFA FAILED");
					break;
				case "ONEIL":
					beforeAdd = list.size();
					mb.addOneil();					
					afterAdd = list.size();
					if(beforeAdd < afterAdd)
						OneTestOutput.add("ONEIL ADDED");	
					else
						OneTestOutput.add("ADDING ONEIL FAILED");
					break;
					
				default:
					break;
				}//térképre elemek rátétele blokk vége.
				//innenstől karakter mozgatása, lövése, stb
			case "MOVE":
				kc.move(pieces[2], pieces[3]);
				OneTestOutput.add(pieces[2] + " MOVED " + pieces[3]);
				break;
			case "FIRE":
				kc.fire(pieces[2], pieces[3]);
				OneTestOutput.add(pieces[2] + " FIRED");
				break;
			case "ROTATEGUN":
				kc.rotateGun(pieces[2], Double.parseDouble(pieces[3]));
				OneTestOutput.add("GUN ROTATED WITH " + pieces[3]);
				break;
			case "PICK":
				kc.pick(pieces[2]);
				OneTestOutput.add("PICKED BY  " + pieces[2]);
				break;
			case "DROP":
				kc.drop(pieces[2]);
				OneTestOutput.add("BOX DROPPED BY " + pieces[2]);
				break;
			case "GETPOS":				
				OneTestOutput.add(pieces[2] + kc.getpos(pieces[2]));
				break;
			case "GETZPMS":
				OneTestOutput.add("ZPMS IN LAB " +
						String.valueOf(jm.getLab().getOsszZPM()));
				break;
			case "GETNUMBEROFELEMS":
				OneTestOutput.add(jm.getLab().getList().size()
						+ " ELEM IN LAB");
				break;
			default:
					break;
				}
			}
		}
//	}
	/**
	 * Visszaad egy statisztikát a futtatott tesztekről.
	 */
	public List<String>getStatistics(){
		ArrayList<String> text = new ArrayList<>();
		text.add("Automatizált tesztelés\n");
		text.add("Összegzés:");
		int listSize = TOList.size();
		text.add("Összes teszteset száma: " + listSize);
		
		Iterator<TestObject> it = TOList.iterator();
		int counter = 0;
		while(it.hasNext()){
			TestObject TO = it.next();
			String testName = TO.getTestCaseName();
			if(TO.isSucceeded())
				counter++;
			text.add("Teszteset: " + testName);
			
			text.add("A teszt lefutása során létrejött kimenet:");
				text.addAll(TO.getResultrows());
			int wronglines = TO.getNumberOfWrongLines();
				text.add("Hibás sorok száma: " + wronglines);
			if(wronglines > 0){
				text.add("A teszt során a következő elvárt kimenetek nem teljesültek:");
				text.addAll(TO.getWrongLines());
			}
			int numberoftests = TO.getNumberOfTests();
			text.add("A teszt során " + numberoftests +
					" feltételből " + (numberoftests - wronglines) +
					" darab feltétel teljesült.");
			text.add(testName +" teszteset eredménye: "
					+ (TO.isSucceeded()? "SUCCESSFUL" : "UNSUCCESSFUL"));
			text.add("-----------------");//elválasztó
		}
		text.add("-----------------");//elválasztó
		text.add("\n");
		text.add("A teszt végleges eredménye:\n");
		text.add("\tEbből sikeres: " + counter);
		text.add("\tEbből sikertelen: " + (listSize - counter));
		text.add("Tehát a teszt " + 
				((listSize == counter)? 
						"sikeresen lezárult.":
							"hibával zárult le."));
		return text;
	}
	
	/**
	 * visszaadja, hogy hány db ZPM van a labirintusban.
	 */
	protected int getZPMinLab(){
		return jm.getLab().getOsszZPM();
	}
}
