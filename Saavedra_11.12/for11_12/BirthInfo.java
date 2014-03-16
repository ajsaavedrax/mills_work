package for11_12;

public class BirthInfo implements Comparable<BirthInfo> {
	private Name myName;
	private BirthDate myBD;
	
	public BirthInfo(String theFirst, String theMiddle, String theFamily,
			int theMonth, int theDay, int theYear){
		myName = new Name(theFirst, theMiddle, theFamily);
		myBD = new BirthDate(theMonth, theDay, theYear);
	}//6-parameter constructor
	
	public BirthInfo(String theFirst, String theMiddle, String theFamily,
			int theMonth, int theDay){
		myName = new Name(theFirst, theMiddle, theFamily);
		myBD = new BirthDate(theMonth, theDay);
	}//5-parameter constructor
	
	public BirthInfo(String theFirst, String theFamily,
			int theMonth, int theDay, int theYear){
		myName = new Name(theFirst, theFamily);
		myBD = new BirthDate(theMonth, theDay, theYear);
	}//5-parameter constructor
	
	public BirthInfo(String theFirst, String theMiddle, String theFamily){
		myName = new Name(theFirst, theMiddle, theFamily);
	}//3-parameter constructor
	
	public String getName(){
		return myName + "";
	}//getName
	
	public String getBirthDate(){
		return myBD + "";
	}//getBirthDate
	
	public void setName(Name theName){
		myName = theName;
	}//setName
	
	public void setBirthDate(BirthDate theBD){
		myBD = theBD;
	}//setBirthDate
	
	public String toString(){
		if (myBD == null){
			return myName + " ";			
		}else{
			return myName + " " + myBD;
		}
	}//toString
	
	public boolean equals(Object theOther){
		BirthInfo theBI = (BirthInfo) theOther;
		return myName.equals(theBI.myName);
	}//equals

	public boolean beforeAlpha(BirthInfo theBI){
		return myName.before(theBI.myName);
	}//beforeAlpha
	
	public boolean beforeChron(BirthInfo theBI){
		return myBD.before(theBI.myBD)
				|| (myBD.equals(theBI.myBD) &&
						beforeAlpha(theBI));
	}//beforeChron
	
	public int compareTo(BirthInfo theBI){
		int compareName = myName.compareTo(theBI.myName);
		if (compareName != 0){
			return compareName;
		}//if BI names were different
		return myBD.compareTo(theBI.myBD);
	}//compareTo
	
}//BirthInfo