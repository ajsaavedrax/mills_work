package for11_13;

public class BirthInfo implements Comparable<BirthInfo>{

	private Name myName;//first, possibly middle, and family names
	private BirthDate myBirthDate;//month, day, and possibly year

	public BirthInfo(String theFirst, String theMiddle, String theFamily,
			int theMonth, int theDay, int theYear) {
		myName = new Name(theFirst, theMiddle, theFamily);
		myBirthDate = new BirthDate(theMonth, theDay, theYear);
	}//6 parameter BirthInfo constructor
	
	public BirthInfo(String theFirst,  String theFamily,
			int theMonth, int theDay, int theYear) {
		myName = new Name(theFirst,  theFamily);
		myBirthDate = new BirthDate(theMonth, theDay, theYear);
	}//5 parameter BirthInfo constructor - no middle name
	
	public BirthInfo(String theFirst, String theMiddle, String theFamily,
			int theMonth, int theDay) {
		myName = new Name(theFirst, theMiddle, theFamily);
		myBirthDate = new BirthDate(theMonth, theDay);
	}//5 parameter BirthInfo constructor - no year of birth

	public BirthInfo(String theFirst, String theFamily,
			int theMonth, int theDay){
		myName = new Name(theFirst, theFamily);
		myBirthDate = new BirthDate(theMonth, theDay);
	}//4-parameter constructor - no middle name or year of birth
	
	public BirthInfo(String theFirst, String theMiddle, String theFamily) {
		myName = new Name(theFirst, theMiddle, theFamily);
		myBirthDate = new BirthDate();
	}// 3 parameter BirthInfo constructor

	public Name getName() {// access method, returns the name
		return myName;
	}//getName

	public BirthDate getBirthDate() {// access method, returns the birth date
		return myBirthDate;
	}//getBirthDate

	public void setName(Name theName) {
		myName = theName;
	}//setMyName - name parameter

	public void setBirthDate(BirthDate theBD) {//modifier method, sets myName
		myBirthDate = theBD;
	}//setBirthDate
	
	public String toString() { //returns string designation of BirthInfo
		return myName + " " + myBirthDate;
	}//toString

	public boolean equals(Object theOther){
		return myName.equals(((BirthInfo)theOther).myName);
	}//override equals in class Object

	public boolean beforeAlpha(BirthInfo theBI) {
		return myName.compareTo(theBI.myName) < 0;
	}//beforeAlpha

	public boolean beforeChron(BirthInfo theBI) {
		return myBirthDate.compareTo(theBI.myBirthDate) < 0
				||(myBirthDate.equals(theBI.myBirthDate)
						&& beforeAlpha(theBI));
	}//beforeChron

	public int compareTo(BirthInfo theBirthInfo) {
		return myName.compareTo(theBirthInfo.myName);
	} //compareTo

}//class BirthInfo

