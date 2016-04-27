package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestObject {
	/**
	 * Ha a teszt sikeres, true-ra billentjük.
	 */
	boolean succeeded = false;
	/**
	 * Futtatandó parancsok listája.
	 */
	List<String> commandList = new ArrayList<>();
	/**
	 * Elvárt sorok a kimenetben. Ezeknek meg KELL jelenniük
	 * a sorok között.
	 */
	List<String> expectedResults = new ArrayList<>();
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
	 * Azokat a sorokat tesszük bele, amelyek az
	 * expected vagy excluded sorok közt vannak, 
	 * de a tényleges kimenetben(resultrows) nincs benne.
	 */
	List<String> wrongTests = new ArrayList<>();
	/**
	 * Teszteset neve. Lehet akár a fájlnévvel megegyező is.
	 */
	String testCaseName = "SampleTest";
	
	TestObject(String name){
		testCaseName = name;
	}
	/**
	 * A teszthez hozzáad egy új parancsot annak attribútumaival együtt.
	 * @param command
	 */
	public void addCommandRow(String command){
		commandList.add(commandList.size(), command);
	}
	/**
	 * Elvárt kimenetet adhatunk meg a teszt-objektumnak.
	 * @param excepted
	 */
	public void AddExpectedResultRow(String excepted){
		expectedResults.add(excepted);
	}
	/**
	 * Olyan sorokat adhatunk hozzá, amelyeknek TILOS
	 * megjelennie a kimenetben.
	 */
	public void AddExcludedResultRow(String excluded){
		excludedResults.add(excluded);
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
	 * Egyúttal törli is a listáról.
	 * @return null, ha nincs több parancs.
	 */
	public String nextCommand(){		
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
		testExpectedRows();
		testExcludedRows();
		if(getNumberOfWrongLines() == 0)
			succeeded = true;
	}
	/**
	 * Privát metódus. Megmondja, hogy az ExpectedRows elemei
	 * Benne vannak-e a tényleges kimenetben. Ha nincsenek,
	 * a wrongTests listába beteszi a hibás tesztsorokat.
	 */
	private void testExpectedRows(){
		Iterator<String> iterator = expectedResults.iterator();
		
		while(iterator.hasNext()){
			boolean included = false;
			String expectedrow = iterator.next();
			Iterator<String> iterator2 = resultrows.iterator();
			while(iterator2.hasNext()){
				String resultrow = iterator2.next();
				if(expectedrow.equals(resultrow))
					included = true;			
			}
			if(!included)
				wrongTests.add(expectedrow);			
		}
	}
	/**
	 * Privát metódus. Megmondja, hogy az ExcludedRows elemei
	 * Benne vannak-e a tényleges kimenetben. Ha nincsenek,
	 * a wrongTests listába beteszi a hibás tesztsorokat.
	 */
	private void testExcludedRows(){
		Iterator<String> iterator = excludedResults.iterator();
		
		while(iterator.hasNext()){
			boolean excluded = true;
			String excludedrow = iterator.next();
			Iterator<String> iterator2 = resultrows.iterator();
			while(iterator2.hasNext()){
				String resultrow = iterator2.next();
				if(excludedrow.equals(resultrow))
					excluded = false;			
			}
			if(!excluded)
				wrongTests.add(excludedrow);			
		}
	}
	public List<String> getWrongLines(){
		return wrongTests;
	}
	/**
	 * Visszaadja a rossz sorok számát.
	 */
	public int getNumberOfWrongLines(){
		return wrongTests.size();
	}
	/**
	 * @return A teszt összes sorainak száma(excepted és excluded is)
	 */
	public int getNumberOfTests() {
		return expectedResults.size() + excludedResults.size();
	}
	/**
	 * Megadja, hogy a teszt sikeresen lefutott-e.
	 * @return true - ha a teszt sikeresen lefutott.
	 */
	public boolean isSucceeded(){
		return succeeded;
	}
}
