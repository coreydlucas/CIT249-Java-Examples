/***************
class ExceptionTester
	Trying the basics of exception handling
	Author: Corey Lucas
	Last Modified: October 28, 2015
	clucas0044@kctcs.edu
******************/

public class ExceptionTester {
	
	public static void main(String[] args){
			
		int i;
		int j;
		double k;
		
		i = 4;
		j = 2;
		k = 0;
		
		try {
			
			k = i/j;
			System.out.println("\nk = " + k);
				
		}
		catch(ArithmeticException ae) {
			
			System.out.println("\nAn error occurred!");
				
		}
		finally {
			i = 0;
			j = 0;
			k = 0;	
		}
		
		System.out.println("\ni = " + i);
		System.out.println("\nj = " + i);
		System.out.println("\nk = " + i);
		
	} //end of main method
		
} // end of class
