package for11_13;

public class BirthInfoList {
	private BirthInfo myArray[];//refers to the array of BirthInfo
	private BirthInfo tempArray[];
	private int myCount;//hold the count of BI
	private static final int DEFAULT_MAX = 3;//default capacity
	
	public BirthInfoList() {
		myArray = new BirthInfo[DEFAULT_MAX];
		myCount = 0;
	}//0 parameter constructor
	
	public boolean add(BirthInfo theBirthInfo){
		if(myCount<myArray.length && search(theBirthInfo)==null){
			myArray[myCount++] = theBirthInfo;
			return true;
		}//if item not in list
		return false;
	}//add
	
	public String toString() {
		String stringToReturn = "";
		for (int i = 0; i < myCount; i++) {
			stringToReturn = stringToReturn  + 
					myArray [i].toString() + "\n"; //"\n" for the new line character
		}//for
		return stringToReturn;
	}//toString
	
	public void alphaSort() {
		for (int indexOfItemBeingInserted = 1; indexOfItemBeingInserted< myCount; indexOfItemBeingInserted++) {
			BirthInfo temp = myArray[indexOfItemBeingInserted];
			int indexOfItemBeingCompared = indexOfItemBeingInserted - 1;
			while (indexOfItemBeingCompared > -1
					&& temp.beforeAlpha(myArray[indexOfItemBeingCompared])){
				myArray[indexOfItemBeingCompared + 1] = myArray[indexOfItemBeingCompared];
				indexOfItemBeingCompared--;
			} //while to move down items for which temp is "before"
			myArray[indexOfItemBeingCompared +1 ] = temp;
		} // for
	} //alphaSort
	
	public void chronSort() {
		for (int indexOfItemBeingInserted = 1; indexOfItemBeingInserted< myCount; indexOfItemBeingInserted++) {
			BirthInfo temp = myArray[indexOfItemBeingInserted];
			int indexOfItemBeingCompared = indexOfItemBeingInserted - 1;
			while (indexOfItemBeingCompared > -1
					&& temp.beforeChron(myArray[indexOfItemBeingCompared])){
				myArray[indexOfItemBeingCompared + 1] = myArray[indexOfItemBeingCompared];
				indexOfItemBeingCompared--;
			} //while to move down items for which temp is "before"
			myArray[indexOfItemBeingCompared + 1] = temp;
		} // for
	} //chronSort
	
	public BirthInfo search (BirthInfo theBirthInfo) {
		int i = 0;
		while ( i < myCount && !(myArray[i].equals(theBirthInfo))){
			i++;
		}//while
		return (i < myCount ? myArray[i] : null); 
	}//search
	
	public BirthInfo delete (BirthInfo theBirthInfo){
		int i=0;
		while (i< myCount && !(myArray[i].equals(theBirthInfo))){
			i++;
		}//while
		if(i<myCount){
			myArray[i]=null;
		}//if
		return null;
	}//delete
	
	public boolean isFull(){
		return myCount == myArray.length;
	}//isFull
}
