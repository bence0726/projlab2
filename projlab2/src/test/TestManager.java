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
	
	public static void main(String[] args) throws IOException { //FIXME ezt az exceptiont ki kezeli leee?? a konzol?
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        ArrayList<String> commandArray = new ArrayList<String>();
        String line = null;
         try {
              while ((line = br.readLine()) != null){
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
	/*
	 * átírtam a visszatérési értékét stringre, lejjebb a runTesten belül van egy kis
	 * magyarázat hozzá, tl;dr kimeneti fájl
	 */
	public static String runCommand(String command) throws IOException{
		ArrayList<String> args = new ArrayList<String>();
		String result = null;
        
		StringTokenizer st = new StringTokenizer(command," ");
		while (st.hasMoreElements()) args.add(st.nextToken());
		
		switch(args.get(0).toUpperCase()){
		case "TEST":
			runTest(args.get(2));
	    case "FIRE":
	    	if(args.size()==5)
	    		result = test.fire(args.get(1), Integer.parseInt(args.get(2)), Integer.parseInt(args.get(3)), args.get(4));
	    	else 
	    		System.out.println("no such command");
	    	break; //
	    case "MOVE":
	    	if(args.size()==4){
	    		result = test.move(args.get(1), args.get(2), Integer.parseInt(args.get(3)));
	    	}
	    	else 
	    		System.out.println("no such command");
	       break; //
	    case "ADD":
	    	if(args.size()==10){
	    		result = test.addMerleg(Integer.parseInt(args.get(2)),Integer.parseInt(args.get(3)),Integer.parseInt(args.get(4)),Integer.parseInt(args.get(5)),Integer.parseInt(args.get(6)),Integer.parseInt(args.get(7)),Integer.parseInt(args.get(8)),Integer.parseInt(args.get(9)));
	    	}
	    	else if(args.size()==6){
	    		switch(args.get(1).toUpperCase()){
	    		case "FAL":
	    			
	    			test.addFal(Integer.parseInt(args.get(2)),Integer.parseInt(args.get(3)),Integer.parseInt(args.get(4)),Integer.parseInt(args.get(5)));
	    			result = "FAL hozzáadva.";
	    			break;
	    		case "SPECFAL":
	    			test.addSpecFal(Integer.parseInt(args.get(2)),Integer.parseInt(args.get(3)),Integer.parseInt(args.get(4)),Integer.parseInt(args.get(5)));
	    			result = "SPECFAL hozzáadva.";
	    			break;
	    		case "SZAKADEK":
	    			test.addSzakadek(Integer.parseInt(args.get(2)),Integer.parseInt(args.get(3)),Integer.parseInt(args.get(4)),Integer.parseInt(args.get(5)));
	    			result = "SZAKADÉK hozzáadva.";
	    			break;
	    		case "VEGEELEM":
	    			test.addEndElem(Integer.parseInt(args.get(2)),Integer.parseInt(args.get(3)),Integer.parseInt(args.get(4)),Integer.parseInt(args.get(5)));
	    			result = "VEGEELEM hozzáadva.";
	    			break;
	    		case "ZPM":
	    			test.addZPM(Integer.parseInt(args.get(2)),Integer.parseInt(args.get(3)),Integer.parseInt(args.get(4)),Integer.parseInt(args.get(5)));
	    			result = "ZPM hozzáadva.";
	    			break;
	    		}
	    	}
	    	else if(args.size()==5){
	    		result = test.addDoboz(Integer.parseInt(args.get(2)),Integer.parseInt(args.get(3)),Integer.parseInt(args.get(4)));
	    	}
	    	else if(args.size()==4){
	    		switch(args.get(1).toUpperCase()){
	    		case "KEZDOPONT":
	    			test.addKezdoPont(Integer.parseInt(args.get(2)),Integer.parseInt(args.get(3)));
	    			result = "KEZDOPONT hozzáadva.";
	    			break;
	    		case "REPLIKATOR":
	    			test.addReplikator(Integer.parseInt(args.get(2)),Integer.parseInt(args.get(3)));
	    			result = "REPLIKATOR hozzáadva.";
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
	    		result = String.valueOf(test.getZPMinLab());
	    	else 
	    		System.out.println("no such command");
	    break;
	    case "LISTKAR":
	    	if(args.size()==2){
	    		result = test.listKar(args.get(1));
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
	    	
	    default :
	    	System.out.println("Invalid command");
		}
		return result + "\n";
     
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
	
	