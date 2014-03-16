
package forDatabase;


public class BirthDate implements Comparable<BirthDate>{

	private int myMonth;//month of birth date in range 1-12
	private int myDay;//day in month of birth date in appropritate range
	private int myYear;//optional year of birth

	public static final String NAMES_OF_MONTHS[] =
		{" ", "January", "February", "March", "April", "May", "June", 
		"July", "August", "September", "October", "November", "December"};

	public static final int MAX_DAYS_IN_MONTHS[] =
		{0,31,29,31,30,31,30,31,31,30,31,30,31};

	public BirthDate(int theMonth, int theDay, int theYear) {
		myMonth = theMonth;
		myDay = theDay;
		myYear = theYear;
	}// 3 parameter constructor

	public BirthDate(int theMonth, int theDay) {
		myMonth = theMonth;
		myDay = theDay;
		myYear = 0;
	}// 2 parameter constructor

	public BirthDate() {
		myMonth = 0;
		myDay = 0;
		myYear = 0;
	}// 0 parameter constructor

	public int getMonth() {  
		return myMonth;
	}// getMonth method

	public void setMonth(int theMonth) {  // sets birth month
		if((theMonth >= 1) && (theMonth <= 12)) {
			myMonth = theMonth;
			if(myDay > MAX_DAYS_IN_MONTHS[myMonth]){
				myDay = MAX_DAYS_IN_MONTHS[myMonth];
			}//inner if
		} else {
			System.out.println("The month entered was not valid." + 
					"It should be a number between 1 and 12 inclusive");
		}// else
	}//setMonth method

	public int getDay() {  // gets date of birth month
		return myDay;
	}// getMonth  method

	public void setDay(int theDay) { // sets date of birth month
		if ((theDay <= MAX_DAYS_IN_MONTHS[myMonth]) && (theDay >= 1)) {
			myDay = theDay;
		} else {
			System.out.println("Attempt to set day to " + theDay + " with month " +
					NAMES_OF_MONTHS[myMonth]);
		}// else
	}//setDay method

	public int getYear() {  // returns year of birth
		return myYear;
	}// getYear method

	public void setYear(int theYear){  // sets year of birth
		myYear = theYear;
	}// setYear method

	public boolean equals(Object theOther){
		BirthDate theBD = (BirthDate)theOther;
		return myMonth == theBD.myMonth
				&& myDay == theBD.myDay
				&& myYear == theBD.myYear;
	}//equals

	public boolean before(BirthDate theBD){
		return compareTo(theBD) < 0;
	}//before


	//	 to determine if object comes before or after
	public int compareTo(BirthDate theBirthDate) { 
		int compareMonth = myMonth - theBirthDate.myMonth;
		if(compareMonth != 0 ) {
			return compareMonth;
		}//months were different

		int compareDay = myDay - theBirthDate.myDay;
		if(compareDay != 0 ) {
			return compareDay;
		}//months the same, days were different

		return myYear - theBirthDate.myYear;
	}// compareTo method

	public String toString() {
		if(myMonth == 0) {
			return "";
		}// if
		return NAMES_OF_MONTHS[myMonth] + " " + myDay + (myYear == 0 ? "" : ", " + myYear);
	}// toString method

}//BirthDate
