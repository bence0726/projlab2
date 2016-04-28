package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import model.JatekMotor;

/**
 * A tesztelés főosztálya, ez tartalmazza a main metódust.
 * Konzolról nem olvas, csupán fájlból. A parancssori argumentumként
 * kapott fájlt fogja megnyitni, futtatni. 
 * Ha nem kap parancssori argumentumként semmit, akkor
 * a test/testfiles mappa összes .txt fájlján végig fog menni 
 * és azokat fogja beolvasni.
 * @author zsigatibor
 *
 */
public class MainTesterClass {
	public static File workingDirectory = new File("test/testfiles/");
	
	
	public static void main(String[] args) {
		JatekMotor jm = new JatekMotor();
		TestManager TM = new TestManager(jm);
		/*
		 * Ez az if-ág akkor fog lefutni, ha parancssori
		 * argumentumként megadtunk fájlnevet.
		 */
		if(args.length != 0)			
		try{
			File fp = new File(workingDirectory,args[0]);
			String[] name = args[0].split(".txt");
			TM.addTestObject(readin(fp));		//odaadjuk a TestObject-et a TestManagernek
		}			
		catch(IOException e){
			e.printStackTrace();
		}
		else{
			try {
				for (File file : workingDirectory.listFiles()) {
					TM.addTestObject(readin(file));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		TM.runAll();//TODO ezt majd a legeslegvégén elég meghívni 1x.
		List<String> statistics = TM.getStatistics();
		
		Iterator<String> stat = statistics.iterator();
		String outputfilename = "Testresults.txt";			
		
		try {
			BufferedWriter bw = new BufferedWriter(
					new	FileWriter(
					new File(workingDirectory,outputfilename)));
		
			while(stat.hasNext()){
				String text = stat.next();
				System.out.println(text); 			//kiírjuk a statisztikát, a tesztek eredményét
				bw.write(text);		
				bw.newLine();
			}
			bw.close();
			System.out.println("\n\n\nJelen teszt eredménye /test/testfiles helyen "
					+ outputfilename + " néven szintén megtekinthető.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Beolvassa a fájl tartalmát és TestObjectet csinál belőle.
	 */
	private static TestObject readin(File fp) throws IOException{
		BufferedReader brrrr = new BufferedReader(
					new FileReader(fp));
		String testName = fp.getName();
		String[] piece = testName.split(".txt");		
		TestObject TO = new TestObject(piece[0]);		//pl "test1.txt" esetén "test1" lesz a neve
		String line;				
		while((line = brrrr.readLine()) != null){		//beolvassuk a fájl sorait				
			String[] pieces = line.split(" ");
			switch(pieces[0]){
			case "INCLUDE":								//ha elvárt kimenetet adunk meg,
				String[] includeLine = line.split("INCLUDE ");
				TO.AddExpectedResultRow(includeLine[1]);//akkor a megfelelő listájához adjuk hozzá a sort
				break;
			case "EXCLUDE":								//ha olyan sort szeretnénk megadni, aminek
				String[] excludeLine = line.split("EXCLUDE ");
				TO.AddExcludedResultRow(excludeLine[1]);
				break;									//TILOS szerepelnie a kimenetben, ezt hívjuk
			default:
				TO.addCommandRow(line);	
				break;
			}
		}
		brrrr.close();									//bezárjuk a fájlt
		return TO;
	}    
}
