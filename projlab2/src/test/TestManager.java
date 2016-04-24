package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TestManager {	
	static Test test = new Test();
	
	public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        ArrayList<String> commandArray = new ArrayList<String>();

         try {
              String line = null;
              while (!(line = br.readLine()).equals("")){
            	  commandArray.add(line); 
              }
         }
         catch(IOException e){
        	 e.printStackTrace();
         }
         
         for(String command : commandArray){
        	 runCommand(command);
         }
	}
	
	public static void runCommand(String command) throws IOException{
		ArrayList<String> args = new ArrayList<String>();
        
		StringTokenizer st = new StringTokenizer(command," ");
		while (st.hasMoreElements()) args.add(st.nextToken());
		
		switch(args.get(0).toUpperCase()){
	    case "FIRE":
	    	if(args.size()==5)
	    		test.fire(args.get(1), Integer.parseInt(args.get(2)), Integer.parseInt(args.get(3)), args.get(4));
	    	else 
	    		System.out.println("no such command");
	    	break; //
	    case "MOVE":
	    	if(args.size()==4){
	    		test.move(args.get(1), args.get(2), Integer.parseInt(args.get(3)));
	    	}
	    	else 
	    		System.out.println("no such command");
	       break; //
	    case "ADD":
	    	if(args.size()==10){
	    		test.addMerleg(Integer.parseInt(args.get(2)),Integer.parseInt(args.get(3)),Integer.parseInt(args.get(4)),Integer.parseInt(args.get(5)),Integer.parseInt(args.get(6)),Integer.parseInt(args.get(7)),Integer.parseInt(args.get(8)),Integer.parseInt(args.get(9)));
	    	}
	    	else if(args.size()==6){
	    		switch(args.get(1).toUpperCase()){
	    		case "FAL":
	    			test.addFal(Integer.parseInt(args.get(2)),Integer.parseInt(args.get(3)),Integer.parseInt(args.get(4)),Integer.parseInt(args.get(5)));
	    			break;
	    		case "SPECFAL":
	    			test.addSpecFal(Integer.parseInt(args.get(2)),Integer.parseInt(args.get(3)),Integer.parseInt(args.get(4)),Integer.parseInt(args.get(5)));
	    			break;
	    		case "SZAKADEK":
	    			test.addSzakadek(Integer.parseInt(args.get(2)),Integer.parseInt(args.get(3)),Integer.parseInt(args.get(4)),Integer.parseInt(args.get(5)));
	    			break;
	    		case "VEGEELEM":
	    			test.addVegeElem(Integer.parseInt(args.get(2)),Integer.parseInt(args.get(3)),Integer.parseInt(args.get(4)),Integer.parseInt(args.get(5)));
	    			break;
	    		case "ZPM":
	    			test.addZPM(Integer.parseInt(args.get(2)),Integer.parseInt(args.get(3)),Integer.parseInt(args.get(4)),Integer.parseInt(args.get(5)));
	    			break;
	    		}
	    	}
	    	else if(args.size()==5){
	    		test.addDoboz(Integer.parseInt(args.get(2)),Integer.parseInt(args.get(3)),Integer.parseInt(args.get(4)));
	    	}
	    	else if(args.size()==4){
	    		switch(args.get(1).toUpperCase()){
	    		case "KEDOPONT":
	    			test.addKezdoPont(Integer.parseInt(args.get(2)),Integer.parseInt(args.get(3)));
	    			break;
	    		case "REPLIKATOR":
	    			test.addReplikator(Integer.parseInt(args.get(2)),Integer.parseInt(args.get(3)));
	    			break;
	    		}
	    	}
	    	else
	    		System.out.println("no such command");
	    	break;
	    case "MAKE":
	    	makeTest("testtest");
	    	//TODO MAKE NEW TEST
	    break;
	    case "DO":
	    	System.out.println("0. DO");
	    	//TODO DO NEW TEST(GET RESULT)
	    break;
	    case "GET":
	    	if(args.get(1).equalsIgnoreCase("ZPM") && args.get(2).equalsIgnoreCase("IN") && args.get(3).equalsIgnoreCase("LAB"))
	    		test.getZPMinLab();
	    	else 
	    		System.out.println("no such command");
	    break;
	    case "LISTKAR":
	    	if(args.size()==2){
	    		test.listKar(args.get(1));
	    	}
	    	else 
	    		System.out.println("no such command");
	    break;
	    case "LISTLAB":
	    	if(args.size()==1){
	    		test.listLab();
	    	}
	    	else 
	    		System.out.println("no such command");
	    break;
	    case "PICK":
	    	if(args.size()==3)
	    		System.out.println("TEST.PICK(ki,merre)");
	    	else 
	    		System.out.println("no such command");
	    break;
	    case "DROP":
	    	if(args.size()==3)
	    		System.out.println("TEST.DROP(ki,merre)");
	    	else 
	    		System.out.println("no such command");
	    break;
	    /*case "TEST":
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
	    		}*/
	    	}
	    	else
	    		System.out.println("no such command");
	    		
	    break;
	    	
	    default :
	    	System.out.println("Invalid command");
	}
     
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
	    
	    try {
	         in = new FileInputStream("test/input"+testname+".txt");
	         out = new FileOutputStream("test/output"+testname+".txt");
	         reader = new BufferedReader(new InputStreamReader(in));
	         
	         line = reader.readLine();
	         while (line != null){
	        	 runCommand(line);
	        	 line = reader.readLine();
	         }
	         
	        //TODO: beolvassa sorra az inputot �sss... valahogy tesztel
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
	/**
	 *ennek segítségével tudunk saját további teszteseteket létrehozni, 
	 *console-on sorokat vár, amíg nem adunk meg neki üres sort, addig olvas
	 *az új testfájl az eddig definiált bemeneti nyelv esetén fog helyesen 
	 *működni 
	 */
	public static void makeTest(String testname) throws IOException{
		FileOutputStream out = null;
		BufferedReader br = null;
		Reader r = new InputStreamReader(System.in);
		br = new BufferedReader (r);
		String str = null;		
		
		System.out.println("Enter commands, end to quit.");
		out = new FileOutputStream("test/input"+testname+".txt");
		
		try {
			do {			
				str = br.readLine();
				byte[] contentInBytes = str.getBytes();
				
				out.write(contentInBytes);
				out.write(System.getProperty("line.separator").getBytes());
				out.flush();
				
			} while (!(str.equals("")));			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
		}
			if (out != null) {
	            out.close();
			}
	}
}
	
	