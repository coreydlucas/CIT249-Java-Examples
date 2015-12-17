/***************
class WritingTester
	Trying the basics of reading text files
	Author: Corey Lucas
	Last Modified: October 28, 2015
	clucas0044@kctcs.edu
******************/
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class WritingTester {
	
	public static void main(String[] args) {
		
		PrintWriter out;
		File file;
		
		out = null;
		file = null;
		
		try  {
			
			//open (or create) a file for writing
			file = new File("D:/misc/output.txt");
			
			if(file.exists()) {
				out = new PrintWriter(
						new BufferedWriter(
							new FileWriter(file, true)));	
				//write lines of output to the file
				out.println("I am writing a line of text.");
				out.println("\nAnother line of text.");
				out.println("\nTO BE CONTINUED AS;DLKFJAOWEIRULKAJSDFLKJ");
			}	
		}
		catch (FileNotFoundException fnfe) {
			System.out.println("\nCould not open file for writing.");
		}
		catch (IOException ioe) {
			System.out.println("\nError opening file for writing.");
		}
		finally {
			if(out != null) {
				out.close();	
			}	
		}
		
		
	}//end of main method
}//end of class
