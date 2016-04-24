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
		Test test = new Test();
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
        	 runCommand(command,test);
         }
	}
	
	public static void runCommand(String command, Test test){
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
	    	if(args.size()==4){
	    		switch(args.get(1)){
	    		case "DOBOZ":
	    			StringTokenizer param = new StringTokenizer(args.get(2),",");
	    			int cord[] = new int[4];
	    			int suly = Integer.parseInt(args.get(3));
	    			int i = 0;
	    			while(param.hasMoreTokens())
	    				cord[i++] = Integer.parseInt(param.nextToken());
	    			test.addDoboz(cord[0], cord[1], cord[2], cord[3], suly);
	    		break;		    
	    		case "MERLEG":
	    			//TODO
	    		break;
	    		}
	    	}
	    		
	    	else{
		    	if(args.size()==3)
		    		switch(args.get(1)){	    
		    		case "FAL":
		    			//TODO
		    		break;
		    		case "KEZDOPONT":
		    			//TODO
		    		break;
		    		case "REPLIKATOR":
		    			//TODO
		    		break;
		    		case "SPECFAL":
		    			//TODO
		    		break;
		    		case "SZAKADEK":
		    			//TODO
		    		break;
		    		case "VEGEELEM":
		    			//TODO
		    		break;
		    		case "ZPM":
		    			//TODO
		    		break;
		    		}
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
	    		System.out.println("<list�zott neve> x:<sz�m> y:<sz�m> ZPM:<sz�m> GOTBOX:<bool>");
	    	}
	    	else 
	    		System.out.println("no such command");
	    break;
	    case "LISTLAB":
	    	if(args.size()==1){
	    		System.out.println("TEST.LISTLAB()");
	    		System.out.println("<sorsz�m> <ELEM> <x1>,<y1> <x2>,<y2>");
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
	         
	        //TODO: beolvassa sorra az inputot �s... valahogy tesztel
	         
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
			
			//TODO saj�t teszeset kre�l�sa 
			
		}finally {
			if (out != null) {
	            out.close();
	        }
	    }
	}
	
	
}
