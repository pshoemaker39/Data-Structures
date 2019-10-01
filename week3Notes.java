package csc402;

import stdlib.*;


public class week3Notes {
	
	public static int iterativeSearch(int[] a, int key) {
		for (int i = 0; i <a.length; i++) {
			if(key==a[i]) {
				return i;
			}
		}
		return -1;
	}
	
	public static int recursiveSearch(int[] a, int key, int i) {
		if (i == a.length) { // base case
			return -1;
		}
		if (key==a[i]) {
			return i;
		}
		return recursiveSearch(a, key, i+1);
	}
	
	public static int search(int[] a, int key) {
		
		return recursiveSearch(a, key, 0);
		
	}
	
	//Java Classes
	// - Program class: contains a "main" method
	// - Library class: contains all static methods, but not a main method (Math, StdIn, StdOut) "Application"
	// - Reference class: contains new data types (adds to primitive types) (ex: String)
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float v = 1.39993980997f;
		//StdOut.printf("%4.3f\n", v);
		//first number is field width
		//second number is the count of digits to right decimal places
		//string = %10s
		//decimal = %field-width decimal
		
		int[] a = new int[] {1,2,4,5,6};
		
		int iResult;
		int rResult;
		
		
		iResult = iterativeSearch(a, 2);
		
		rResult = recursiveSearch(a, 6, 0);
		
		StdOut.print(iResult);
		
		StdOut.print("\n");
		
		StdOut.print(rResult);
		
		
		

	}

}
