package test;

import java.io.BufferedReader;
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
            	  StringTokenizer st = new StringTokenizer(line,",");
            	  while (st.hasMoreElements()) commandArray.add(st.nextToken()); 
              }
         }
         catch(IOException e){
        	 e.printStackTrace();
         }
         
         for(String command : commandArray){
        	 System.out.print(command+"\n");
         }
	}

}
