package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * A tesztelés főosztálya, ez tartalmazza a main metódust.
 * Konzolról nem olvas, csupán fájlból. A parancssori argumentumként
 * kapott fájlt fogja megnyitni, futtatni.
 * @author zsigatibor
 *
 */
public class MainTesterClass {

	public static void main(String[] args) {
		try{
				runTest(args[0]);	//TODO nem jó, a TestObject-hez át kell írni.
									//ha hazaértem, este megírom. @author zsigatibor
		}catch(IOException e){
			e.printStackTrace();
		}
		
		
		try {
			File fp = new File("src/testfiles",args[0]);
			BufferedReader brr = new BufferedReader(new FileReader(fp));
			String line = brr.readLine();
			while(line != null){
//				String[] darabok = line.split(" ");
				System.out.println(TestManager.runCommand(line) + "\n");
				line = brr.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error while reading file.");
			e.printStackTrace();
		}
		System.out.println("Tesztek lefuttatva.");

	}
	
	/**
	 * az előre megírt testfájl alapján fog futni
	 * soronként a bemeneti nyelvnek megfelelő parancsokat vár,
	 * runCommand kapja meg a fájl tartalmát soronként, 
	 * üres sorig olvas
	 * 
	 * erősen béta, a TEST AA bb parancsokkal szeretnénk valamit kezdeni,
	 * hogy pontosan a bemenet alapján tudjuk, hogy mire akarunk tesztelni
	 */
	public static void runTest(String testname)throws IOException{
		FileInputStream in = null;
	    FileOutputStream out = null;
	    BufferedReader reader = null;
	    String line = null;
	    String testresult = null;
	    
	    try {
	         in = new FileInputStream("testfiles/"+testname+".txt");
	         out = new FileOutputStream("testfiles/"+testname+".txt");
	         reader = new BufferedReader(new InputStreamReader(in));
	         ArrayList<String> args = new ArrayList<String>();
	         
	         line = reader.readLine();
	         while (line != "TEST"){
	        	 testresult = TestManager.runCommand(line);
	        	 line = reader.readLine();
	        	 if (testresult != null)
	        	 {
	        		 byte[] contentInBytes = testresult.getBytes();				
	        		 out.write(contentInBytes);
	        		 out.write(System.getProperty("line.separator").getBytes());
	        		 out.flush();
				 }
	        	 
	         }
	         while (line != null){
	        	StringTokenizer st = new StringTokenizer(line," ");
	     		while (st.hasMoreElements()) args.add(st.nextToken());
	     		
	     		switch(args.get(0).toUpperCase()){
	     			case "TEST":
	     			if(args.size()==3) {
	     				switch(args.get(1).toUpperCase()){
	     				case "DO":
	     					if(args.get(2)=="ALL"){	//minden meglévő tesztesetet lefuttat
	 	    				//kérdés: mit takar a minden teszteset? minden testfile a könyvtáron belül,
	 	    				//vagy egy fájlon belül több dologra akarunk tesztelni? nem igazán látom át
	 	    				
	     					}
	     					else{		//stringet kap, az adott tesztesetet hajtjuk végre
	 	    				//ugyanaz, mint feljebb, milyen teszteket nézünk?
	     					}
	     					break;
	     				case "MAKE":	//string, teszteset létrehozása
	 	    				//same problem
	     					break;
	     				case "INC":		//string megkeresése az output fájlban/labirintusban whatsthere alapján
	 	    			
	     					break;
	     				case "EXC":		//string keresése INC-hez hasonlóan,
	 	    						//akkor sikeres a teszt, ha az adott string nem létezik (pl megsemmisült doboz/karakter)	 	    			
	     					break;
	 	    		}
	 	    	}
	 	    	else
	 	    		System.out.println("no such command");
	 	    		
	 	    break;
	     		}
	        	 
	        	 line = reader.readLine();
	         }
	         
	        //TODO: beolvassa sorra az inputot �sss... valahogy tesztel
	         /**
	          * Kimenet mentése ötlet:
	          * a legtöbb parancs a runCommandon belül stringgel tér vissza, ezeket a
	          * stringeket a runCommandon belül (vagy akár minden egyes runCmd után az tér vissza stringgel), 
	          * és akkor a runTest során) mentjük el egy új txt-be, így azonnal tudunk ellenőrizni
	          */
	         /*
	          * Felmerülő kérdések és megoldandó problémák:
	          * -a switchcase szépen fog pörögni a bemenet alapján, de
	          * minden egyes kimenetet fájlba kell írni, nem konzolba, különben 
	          * nem látom, hogy hogyan tudnánk összevetni az elvárt kimenetünkkel, 
	          * amennyiben nem a consolon akarjuk ellenőrizni, hogy pl MOVED ki mit merre
	          * ha consoleről olvassuk le, akkor manuálisan látjuk, de a program nem tudja
	          * összevetni automatikusan, amennyiben így szeretnénk (azt írtuk, hogy valós és elvárt eredmények összehasonlítása)
	          * 
	          * -ha bemenet végén definiált értékeket szeretnénk a kimenettel összevetni, amennyiben
	          * az külön fájlba kerül, akkor a runtest while(line != null) helyett kell egy elválasztó sor,
	          * és az utána lévő sorokat kell soronként egyeztetni a kimeneti fájlunkkal
	          * 
	          * -ha új parancsokat akarunk, melyekket tudjuk kezelni, hogy mit akarunk
	          * pontosan tesztelni, akkor azoknál is az output fájlt a switchcase folyamán
	          * kell szépen feltölteni
	          */
	         //esetleg �j parancsok felv�tele TEST DO string (1 teszteset futtat�sa)
	         								//TEST DO ALL (�sszesteset futtat�sa)
	         								//TEST MAKE string (�j teszteset l�trehoz�sa)
	         								//TEST INC string (string megl�te az output f�jlban)
	         								//TEST EXC string (string nem megl�te az output f�jlban)
	         
	      }finally {
	         if (in != null) {
	            in.close();
	         }
	         if (out != null) {
	            out.close();
	         }
	         reader.close();
	      }
	   }

}
