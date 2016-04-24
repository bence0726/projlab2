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
	    default :
	    	System.out.println("Invalid command");
	}
     
	}
	
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
	         }
	         
	        //TODO: beolvassa sorra az inputot ésss... valahogy tesztel
	         //esetleg új parancsok felvétele TEST DO string (1 teszteset futtatása)
	         								//TEST DO ALL (összesteset futtatása)
	         								//TEST MAKE string (új teszteset létrehozása)
	         								//TEST INC string (string megléte az output fájlban)
	         								//TEST EXC string (string nem megléte az output fájlban)
	         
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
	
	