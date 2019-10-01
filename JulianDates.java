package csc402;
import java.util.*;


public class JulianDates {

	private static Scanner dateInput;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		dateInput = new Scanner(System.in);
		System.out.println("Enter a month: \n");
		int month = dateInput.nextInt(); 
		System.out.println("Enter a day: \n");
		int day = dateInput.nextInt(); 
		System.out.println("Enter a year: \n");
		int year = dateInput.nextInt(); 
		A3Date target = new A3Date(month,day,year);
		System.out.println("The Julian Date is: "+target.julianDate());

	}

}
