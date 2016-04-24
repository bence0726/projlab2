package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TestManager {
	
	public static void main(String[] args) {
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
	
	public static void runCommand(String command){
		ArrayList<String> args = new ArrayList<String>();
        
		StringTokenizer st = new StringTokenizer(command," ");
		while (st.hasMoreElements()) args.add(st.nextToken());
		
		switch(args.get(0).toUpperCase()){
	    case "FIRE":
	    	if(args.size()==4)
	    		System.out.println("TEST.FIRE(ki,koord,tipus)");
	    	else 
	    		System.out.println("no such command");
	    	break; //
	    case "MOVE":
	    	if(args.size()==4){
	    		System.out.println("TEST.MOVE(ki,merre,mennyit)");
	    		System.out.println("MOVED" + args.get(1)+ args.get(2)+ args.get(3));
	    	}
	    	else 
	    		System.out.println("no such command");
	       break; //
	    case "ADD":
	    	if(args.get(1).equalsIgnoreCase("MERLEG") && args.size()==4)
	    		System.out.println("TEST.ADD(merleg,coord,coord)");
	    	else{
		    	if(args.size()==3)
		    		System.out.println("TEST.ADD(valami,coord)");
		    	else 
		    		System.out.println("no such command");
	    	}
	    break; 
	    case "MAKE":
	    	System.out.println("0. MAKE");
	    	//TODO MAKE NEW TEST
	    break;
	    case "DO":
	    	System.out.println("0. DO");
	    	//TODO DO NEW TEST(GET RESULT)
	    break;
	    case "GET":
	    	if(args.get(1).equalsIgnoreCase("ZPM") && args.get(2).equalsIgnoreCase("IN") && args.get(3).equalsIgnoreCase("LAB"))
	    		System.out.println("TEST.MENNYIZPM()");
	    	else 
	    		System.out.println("no such command");
	    break;
	    case "LISTKAR":
	    	if(args.size()==2){
	    		System.out.println("TEST.LISTCHAR()");
	    		System.out.println("<listázott neve> x:<szám> y:<szám> ZPM:<szám> GOTBOX:<bool>");
	    	}
	    	else 
	    		System.out.println("no such command");
	    break;
	    case "LISTLAB":
	    	if(args.size()==1){
	    		System.out.println("TEST.LISTLAB()");
	    		System.out.println("<sorszám> <ELEM> <x1>,<y1> <x2>,<y2>");
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
	    
	    try {
	         in = new FileInputStream("input"+testname+".txt");
	         out = new FileOutputStream("output"+testname+".txt");
	         
	        //TODO: beolvassa sorra az inputot és... valahogy tesztel
	         
	      }finally {
	         if (in != null) {
	            in.close();
	         }
	         if (out != null) {
	            out.close();
	         }
	      }
	   }

	public static void makeTest(String testname) throws IOException{
		FileOutputStream out = null;
		
		try {
			out = new FileOutputStream("input"+testname+".txt");
			
			//TODO saját teszeset kreálása 
			
		}finally {
			if (out != null) {
	            out.close();
	        }
	    }
	}
	
	
}
