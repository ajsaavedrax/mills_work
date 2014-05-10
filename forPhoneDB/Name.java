package forPhoneDB;

public class Name implements Comparable<Name>, java.io.Serializable{
	private String myFirst,  myFamily;
	
	public Name (String theFirst,  String theFamily) {
		myFirst = theFirst;
		myFamily = theFamily;
	}//2 parameter constructor
	
	public String getFirst() {
		return myFirst;
	}//getFirst
	
	public void setFirst(String theFirst) {
		myFirst = theFirst;
	}//setFirst

	public String getFamily() {
		return myFamily;
	}//getFamily
	
	public void setFamily(String theFamily) {
		myFamily = theFamily;
	}//setFamily
	
	public boolean equals(Object theOther){
		Name theName = (Name)theOther;
		return myFirst.equals(theName.myFirst)
			&& myFamily.equals(theName.myFamily);
	}//equals
	
	public int compareTo(Name theName){
		int compareFamily = myFamily.compareTo(theName.myFamily);
		if(compareFamily != 0) {
			return compareFamily;
		}//family names were different
		return myFirst.compareTo(theName.myFirst);
	}//compareTo
	
	public boolean before(Name theOther){
		int compareFamily = myFamily.compareTo(theOther.myFamily);
		if (compareFamily < 0) {
			return true;
		}//if
		if(compareFamily > 0){
			return false;
		}//if
		return myFirst.compareTo(theOther.myFirst) < 0;
	}//before
	
	public String toString() {
		return myFamily + ", " + myFirst ;
	}//toString

}//Name
