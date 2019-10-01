package csc402;


public class A3Date {
	
	private int month, day, year; //Instance variables
	//private enables these vars cannot be changed outside of this class
	
	public A3Date(int m, int d, int y) {
		// constructors use same name
		if(!isValid(m,d,y)) {
			throw new IllegalArgumentException();
		}
		month = m;
		day = d;
		year = y;
	}
	
	private boolean isValid(int m, int d, int y) {
		if (m > 12 || m < 1) return false;
		if (y < 1) return false;
		if (d > 32 || d < 1) return false;
		if (m == 4 || m == 6 || m == 9 || m == 11)
			if(d == 31) return false;
		if (m == 2) {
			if(y % 4 == 0) {
				if (d > 29) return false;
			} else {
				if (d >28) return false;
			}
		}
		return true;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getDay() {
		return day;
	}
	
	public int getYear() {
		return year;
	}
	
	public String toString() {
		return month+"/"+day+"/"+year;
	}
	
	public int julianDate() {
		
		int days = 0;
		
		int[] monthDays;
		
		int[] monthDaysLeap = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		int[] monthDaysReg = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		if (
				(getYear() % 4 != 0) &&
				((getYear() % 400 != 0) ||
				(getYear() % 100 == 0))
			) {
			 monthDays = monthDaysReg;
			
		} else {
			monthDays = monthDaysLeap;
		}
		
		for (int i = 0; i < getMonth()-1; i++) {
			days += monthDays[i];
		}

		
		return days+getDay();
		
	}
	
}
