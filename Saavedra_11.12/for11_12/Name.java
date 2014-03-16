package for11_12;

public class Name {
	private String myFirst;
	private String myMiddle;
	private String myFamily;
	
	public Name(String theFirst, String theMiddle, String theFamily){
		myFirst = theFirst;
		myMiddle = theMiddle;
		myFamily = theFamily;
	}//3-parameter constructor
	
	public Name(String theFirst, String theFamily){
		myFirst = theFirst;
		myMiddle = "";
		myFamily = theFamily;
	}//2-parameter constructor
	
	public String getFirst(){
		return myFirst;
	}//getFirst
	
	public String getMiddle(){
		return myMiddle;
	}//getMiddle
	
	public String getFamily(){
		return myFamily;
	}//getFamily
	
	public void setFirst(String theFirst){
		myFirst = theFirst;
	}//setFirst
	
	public void setMiddle(String theMiddle){
		myMiddle = theMiddle;
	}//setMiddle
	
	public void setFamily(String theFamily){
		myFamily = theFamily;
	}//setFamily
	
	public int compareTo(Name theName) {
		int compareFamily = myFamily.compareTo(theName.myFamily);
		if(compareFamily != 0) {
			return compareFamily;
		}//family names were different
		int compareFirst = myFirst.compareTo(theName.myFirst);
		if(compareFirst != 0 ) {
			return compareFirst;
		}//first names were different with identical family names
		return myMiddle.compareTo(theName.myMiddle);
		}//compareTo
	
	public boolean before(Name theFamily){
		return compareTo(theFamily) < 0;
	}//before
	
	public boolean after(Name theFamily){
		return compareTo(theFamily) > 0;
	}//after
	
	public String toString(){
		return myFamily + ", " + myFirst + " " + myMiddle;
	}//toString method returns full name

}//Name
