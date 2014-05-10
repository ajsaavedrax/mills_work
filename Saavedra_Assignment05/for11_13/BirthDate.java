//Antonio Saavedra


package for11_13;

public class BirthDate implements Comparable<BirthDate>{
	private int myMonth;//int in range 1-12 for month
	private int myDay;//in appropriate range for month
	private int myYear;//optional will default to 0
	
	public BirthDate(int theMonth, int theDay, int theYear){
		myMonth = theMonth;
		myDay = theDay;
		myYear = theYear;
	}//3-parameter constructor
	
	public BirthDate(int theMonth, int theDay){
		myMonth = theMonth;
		myDay = theDay;
		myYear = 0;
	}//2-parameter constructor
	
	public BirthDate(){
		myMonth = 0;
		myDay = 0;
		myYear = 0;
	}//0-parameter constructor
	
	public int getMonth(){
		return myMonth;
	}//getMonth
	
	public int getDay(){
		return myDay;
	}//getDay
	
	public int getYear(){
		return myYear;
	}//getYear
	
	public static final int[ ] MAX_DAYS_IN_MONTH = 
		{0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public static final String[] MONTH_NAMES =
		{"", "January", "February", "March", "April", "May", "June",
		"July", "August", "September", "October", "November", "December"};
	
	public void setMonth(int theMonth){
		if (theMonth < 1 || theMonth > 12) {
			System.out.println(theMonth + " is not in range 1-12. No Change.");
		}else{
			myMonth = theMonth;
			if(myDay > MAX_DAYS_IN_MONTH[myMonth]){
				myDay = MAX_DAYS_IN_MONTH[myMonth];
			}//if
		}//else
	}//setMonth
	
	public void setDay(int theDay){
		if (theDay < 1 || theDay > 31) {
			System.out.println(theDay + " is not in range with"
					+ " its appropriate month.");
		}else{
			myDay = theDay;
			if(myDay > MAX_DAYS_IN_MONTH[myMonth]){
				myDay = MAX_DAYS_IN_MONTH[myMonth];
			}//if
		}//else
	}//setDay
	
	public void setYear(int theYear){
		if (theYear > 2014) {
			System.out.println(theYear + " is not in range."
					+ " The current year is 2014.");
		}else{
			myYear = theYear;
		}//else
	}//setYear
	
	public boolean equals(Object theOther) {
		BirthDate theBD = (BirthDate) theOther;
		return myDay == theBD.myDay
		&& myMonth == theBD.myMonth
		&& myYear == theBD.myYear;
	}//equals
	
	public boolean before(BirthDate theBD) {
		return compareTo(theBD) < 0;
	}//before
	
	public int compareTo(BirthDate theBD) {
		int compareMonth = myMonth - theBD.myMonth;
		if (compareMonth != 0) {
			return compareMonth;
		}//if months were different
		int compareDay = myDay - theBD.myDay;
		if (compareDay != 0) {
			return compareDay;
		}//if days were different
		return myYear - theBD.myYear;
		}//compareTo
	
	public String toString(){
		return MONTH_NAMES[myMonth] + " " + myDay + (myYear != 0? ", "
															+ myYear : "");
	}//toString	
}//BirthDate