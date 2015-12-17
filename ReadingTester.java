/***************
class ReadingTester
	Trying the basics of reading text files
	Author: Corey Lucas
	Last Modified: October 28, 2015
	clucas0044@kctcs.edu
******************/

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class ReadingTester {
	
	public static void main(String[] args) {
		
		Scanner fileReader;
		File file;
		int someNumber;
		
		fileReader = null;
		file = null;
		someNumber = 0;
		
		try{
			file = new File("D:/misc/TestFle.txt");
			
			//testing if the path exists before attempting to open a file for reading
			//if(file.exists()){
				fileReader = new Scanner(file);
				
				if(fileReader.hasNextInt()) {
					someNumber = fileReader.nextInt();
					System.out.println("\nA number from the file: " + someNumber);	
				}
				while (fileReader.hasNextLine()) {
					System.out.println("\n" + fileReader.nextLine());	
				}	
			//}
		
			
		}
		catch (FileNotFoundException fnfe) {
			System.out.println("\nFile could not be opened.");
			System.out.println("\nEmbedded message: " + fnfe.getMessage());
			fnfe.printStackTrace();
			System.out.println(fnfe.toString());	
		}
		finally {
			
			if (fileReader != null) {
				fileReader.close();
			}
			
			
		}
	} // end of main method
	
	static void openFile() throws FileNotFoundException {
		
		
		
		
			
	}
} // end of class
