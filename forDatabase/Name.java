package forDatabase;

public class Name implements Comparable<Name>{
	private String myFirst,//given first name
					myMiddle, // optional middle name
					myFamily;//family name
	public Name (String theFirst,  String theMiddle, String theFamily) {
		myFirst = theFirst;
		myMiddle = theMiddle;
		myFamily = theFamily;
	}//2 parameter constructor
	
	public Name (String theFirst,  String theFamily) {
		myFirst = theFirst;
		myMiddle = "";
		myFamily = theFamily;
	}//2 parameter constructor
	
	public String getFirst() {
		return myFirst;
	}//getFirst
	
	public void setFirst(String theFirst) {
		myFirst = theFirst;
	}//setFirst

	public String getMiddle() {
		return myMiddle;
	}//getMiddle
	
	public void setMiddle(String theMiddle) {
		myMiddle = theMiddle;
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
				&&myMiddle.equals(theName.myMiddle)
			&& myFamily.equals(theName.myFamily);
	}//equals
	
	public int compareTo(Name theName){
		int compareFamily = myFamily.compareTo(theName.myFamily);
		if(compareFamily != 0) {
			return compareFamily;
		}//family names were different
		int compareFirst = myFirst.compareTo(theName.myFirst);
		if(compareFirst != 0) {
			return compareFirst;
		}//family names were different
		return myMiddle.compareTo(theName.myMiddle);
	}//compareTo
	
	public boolean before(Name theOther){
		return compareTo(theOther) < 0;
	}//before
	
	public boolean after(Name theOther){
		return compareTo(theOther) > 0;
	}//after
	
	public String toString() {
		return myFamily + ", " + myFirst + (myMiddle.equals("")? "" : " "+ myMiddle) ;
	}//toString

}//Name
