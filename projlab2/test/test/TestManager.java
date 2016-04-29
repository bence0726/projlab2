package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import controller.KarakterController;
import controller.MapBuilder;
import model.Elem;
import model.JatekMotor;
import model.SpecFal;
import model.Szin;
import model.Terulet;
import model.Vektor;

/**
 * Ez az osztály tartalmazza a teszt-objektumokat. Ezeket
 * futtatja, majd kérésre statisztikát készít a futásukról.
 * @author zsigatibor
 *
 */
public class TestManager {
	
	JatekMotor jm;
	MapBuilder mb;
	KarakterController kc;
	
	List<TestObject> TOList = new ArrayList<>();
	
	public TestManager(JatekMotor gameEngine){
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
		String command = "";
		int beforeAdd = 0;
		int afterAdd = 0;
		
		while((command = TO.nextCommand()) != null){
			List<Elem> list = jm.getLab().getList();
			String[] pieces = command.split(" ");
			switch(pieces[0]){
			case "SETKARDIR":
				kc.setKarDir(pieces[1], pieces[2]);
				TO.AddResultRow(pieces[1] + " MOVED " + pieces[2]);
				break;
			case "FIRE":
				kc.fire(pieces[1], pieces[2]);
				TO.AddResultRow(pieces[2] + " FIRED");
				break;
			case "ROTATEGUN":
				kc.rotateGun(pieces[1], Double.parseDouble(pieces[2]));
				TO.AddResultRow("GUN ROTATED WITH " + pieces[2]);
				break;
			case "PICK":
				kc.pick(pieces[2]);
				TO.AddResultRow("PICKED BY  " + pieces[2]);
				break;
			case "DROP":
				kc.drop(pieces[2]);
				TO.AddResultRow("BOX DROPPED BY " + pieces[2]);
				break;
			case "GETPOS":
				
				TO.AddResultRow(pieces[1] + " " + kc.getpos(pieces[1]));
				break;
			case "GETZPMS":
				TO.AddResultRow("ZPMS IN LAB " +
						String.valueOf(jm.getLab().getOsszZPM()));
				break;
			case "GETNUMBEROFELEMS":
				TO.AddResultRow(jm.getLab().getList().size()
						+ " ELEM IN LAB");
				break;
			case "PORTALPOS":
				SpecFal sp = null;
				String specfalText = "";
				if(pieces[1].equals("YELLOW")){
					sp = jm.pm.getPortalOfThisColor(Szin.Sarga);
					if(sp == null)//ha null a referencia, akkor ez a szöveg kell
					{
						specfalText = "NO" + pieces[1];
						TO.AddResultRow(specfalText);
						break;
					}
					Vektor tempMidleOfArea = sp.getPos().getMiddleOfArea();
/*FIXME*/			specfalText = "YELLOWPORTAL "
							+Math.round(tempMidleOfArea.getVx())//nem kéne hozzáadni azt az eltolást is?
							+" "
							+ Math.round(tempMidleOfArea.getVy());//teleportáláskor nem a specfalra kerül, onnan eltoljuk.. szóval?
				}					
				else{
					sp = jm.pm.getPortalOfThisColor(Szin.Kek);
					if(sp == null)//ha null a referencia, akkor ez a szöveg kell
					{
						specfalText = "NO" + pieces[1];
						TO.AddResultRow(specfalText);
						break;
					}
					Vektor tempMidleOfArea = sp.getPos().getMiddleOfArea();
					specfalText = "BLUEPORTAL "
							+tempMidleOfArea.getVx()
							+" " 
							+ tempMidleOfArea.getVy();
				}
				TO.AddResultRow(specfalText);
				break;
			case "MOVEALL":
				jm.moveEverything();
				break;
			case "ISENDGAME":
				jm.isEndGame();
				break;
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
						TO.AddResultRow("FAL ADDED");//(vagyis bekerült-e az elem)
					else
						TO.AddResultRow("ADDING FAL FAILED");
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
						TO.AddResultRow("SPECFAL ADDED");
					else
						TO.AddResultRow("ADDING SPECFAL FAILED");
					break;
				case "STARTELEM":
					beforeAdd = list.size();
					mb.addStartElem(Integer.parseInt(pieces[2]),
							Integer.parseInt(pieces[3]),
							Integer.parseInt(pieces[4]),
							Integer.parseInt(pieces[5]));					
					afterAdd = list.size();
					if(beforeAdd < afterAdd)
						TO.AddResultRow("STARTELEM ADDED");	
					else
						TO.AddResultRow("ADDING STARTELEM FAILED");
					break;
				case "ENDELEM":
					beforeAdd = list.size();
					mb.addEndElem(Integer.parseInt(pieces[2]),
							Integer.parseInt(pieces[3]),
							Integer.parseInt(pieces[4]),
							Integer.parseInt(pieces[5]));					
					afterAdd = list.size();
					if(beforeAdd < afterAdd)
						TO.AddResultRow("ENDELEM ADDED");	
					else
						TO.AddResultRow("ADDING ENDELEM FAILED");
					break;
				case "SZAKADEK":
					beforeAdd = list.size();
					mb.addSzakadek(Integer.parseInt(pieces[2]),
							Integer.parseInt(pieces[3]),
							Integer.parseInt(pieces[4]),
							Integer.parseInt(pieces[5]));					
					afterAdd = list.size();
					if(beforeAdd < afterAdd)
						TO.AddResultRow("SZAKADEK ADDED");
					else
						TO.AddResultRow("ADDING SZAKADEK FAILED");
					break;
				case "ZPM":
					beforeAdd = list.size();
					mb.addZPM(Integer.parseInt(pieces[2]),
							Integer.parseInt(pieces[3]),
							Integer.parseInt(pieces[4]),
							Integer.parseInt(pieces[5]));					
					afterAdd = list.size();
					if(beforeAdd < afterAdd)
						TO.AddResultRow("ZPM ADDED");
					else
						TO.AddResultRow("ADDING ZPM FAILED");
					break;					
				case "REPLIKATOR":
					beforeAdd = list.size();
					mb.addReplikator();					
					afterAdd = list.size();
					if(beforeAdd < afterAdd)
						TO.AddResultRow("REPLIKATOR ADDED");	
					else
						TO.AddResultRow("ADDING REPLIKATOR FAILED");
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
						TO.AddResultRow("DOBOZ ADDED");
					else
						TO.AddResultRow("ADDING DOBOZ FAILED");
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
						TO.AddResultRow("MERLEG ADDED");
					else
						TO.AddResultRow("ADDING MERLEG FAILED");
					break;
				case "JAFFA":
					beforeAdd = list.size();
					mb.addJaffa();					
					afterAdd = list.size();
					if(beforeAdd < afterAdd)
						TO.AddResultRow("JAFFA ADDED");	
					else
						TO.AddResultRow("ADDING JAFFA FAILED");
					break;
				case "ONEIL":
					beforeAdd = list.size();
					mb.addOneil();					
					afterAdd = list.size();
					if(beforeAdd < afterAdd)
						TO.AddResultRow("ONEIL ADDED");	
					else
						TO.AddResultRow("ADDING ONEIL FAILED");
					break;
				default:
					break;
				}
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
		
		Iterator<TestObject> it = TOList.iterator();
		int counter = 0;
		while(it.hasNext()){
			TestObject TO = it.next();
			TO.checkTest();							//teszt ellenőrzése
			String testName = TO.getTestCaseName();
			if(TO.isSucceeded())					//ha sikeres volt a teszt, növeljük a számlálót
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
		text.add("Összegzés:");
		int listSize = TOList.size();
		text.add("Összes teszteset száma: " + listSize);
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
