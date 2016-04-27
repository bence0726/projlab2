package test;

import java.util.ArrayList;
import java.util.List;

public class TestObject {
	/**
	 * Ha a teszt sikeres, true-ra billentjük.
	 */
	boolean succeeded = false;
	/**
	 * Futtatandó parancsok listája.
	 */
	List<String[]> commandList = new ArrayList<>();
	/**
	 * Elvárt sorok a kimenetben. Ezeknek meg KELL jelenniük
	 * a sorok között.
	 */
	List<String> exceptedResults = new ArrayList<>();
	/**
	 * olyan sorok,amelyek TILOS, hogy benne 
	 * legyenek a kimenetben.
	 */
	List<String> excludedResults = new ArrayList<>();
	/**
	 * A tényleges eredmény sorait tároljuk benne.
	 */
	List<String> resultrows = new ArrayList<>();
	/**
	 * Teszteset neve. Lehet akár a fájlnévvel megegyező is.
	 */
	String testCaseName = "SampleTest";
	
	TestObject(String name){
		testCaseName = name;
	}
	/**
	 * A teszthez hozzáad egy új parancsot annak attribútumaival együtt.
	 * A parancsot String tömbként, darabokban kéri.
	 * @param command
	 */
	public void addCommandRow(String[] command){
		commandList.add(commandList.size(), command);
	}
	/**
	 * Elvárt kimenetet adhatunk meg a teszt-objektumnak.
	 * @param excepted
	 */
	public void AddExceptedResultRow(String excepted){
		exceptedResults.add(excepted);
	}
	/**
	 * A tesztelés után kiírt sorokat adhatjuk át neki.
	 * @param result
	 */
	public void AddResultRow(String result){
		resultrows.add(result);
	}
	/**
	 * Az Teszt következő parancsát adja vissza.
	 * @return null, ha nincs több parancs.
	 */
	public String[] nextCommand(){		
		if (commandList.size() == 0)			
			return null;
		return commandList.remove(0);
	}
	/**
	 * Ellenőrzi, hogy az elvárt kimenet sorait tartalmazza-e
	 * A tényleges kimenet. Átállítja a test success változóját.
	 * Ha success = false, akkor meg kell hívni a getwrongLines()
	 * metódust azok kiírásához.
	 */
	public void checkTest(){
		
	}
	public int numberOfWrongLines(){
		return 
	}
	/**
	 * Megadja, hogy a teszt sikeresen lefutott-e.
	 * @return true - ha a teszt sikeresen lefutott.
	 */
	public boolean isSucceeded(){
		return succeeded;
	}
}
