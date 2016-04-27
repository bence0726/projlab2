package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Tester {

	public static void main(String[] args) {
		
		
		
		
		
		
		
		
		
		
		
		
		
		
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

}
