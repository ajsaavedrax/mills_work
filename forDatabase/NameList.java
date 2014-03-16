package forDatabase;

public class NameList {
	private Name myArray[]; //refers to the array of Names
	private int myCount; // holds the current count of Names in the list

	public NameList () {
		myArray = new Name[100];
		myCount = 0;
	}// 0 parameter constructor

	public NameList (int theMax) {
		myArray = new Name[theMax];
		myCount = 0;
	}// 1 parameter constructor

	public boolean add(Name theName) {
		if (myCount < myArray.length ) {
			myArray[myCount++] = theName;
			return true;
		} // add was successful
		System.out.println("Attempting to add to full array");
		return false;
	}//add

	public boolean isFull() {
		return myCount == myArray.length;
	}//isFull

	public String toString() {
		String stringToReturn = "";
		for (int i = 0; i < myCount; i++) {
			stringToReturn = stringToReturn  + 
					myArray [i].toString() + "\n"; //"\n" for the new line character
		}//for
		return stringToReturn;
	}//toString

	public Name search (Name theName) {
		int i = 0;
		while ( i < myCount && !(myArray[i].equals(theName))){
			i++;
		}//while
		return (i < myCount ? myArray[i] : null); 
	}//search

	private void swap (int firstPos, int otherPos) {
		Name temp = myArray[firstPos];
		myArray[firstPos] = myArray[otherPos];
		myArray[otherPos] = temp;
	}//swap

	public void bubbleSort() {
		for(int passNum = 1; passNum < myCount; passNum++) {
			for (int j = 0; j < myCount - passNum; j++) {
				if(myArray[j+1].before(myArray[j])) {
					swap(j, j+1);
				}//if
			}//inner for loop for one pass
		}//for loop that controls passes over the data
	}//bubbleSort


	public Name binarySearch(Name nameToFind) {
		int low = 0;
		int high = myCount - 1;
		int middle = (low + high)/2;
		while (low <= high && ! (myArray[middle].equals(nameToFind)) ) {
			if ( nameToFind.before (myArray[middle])) {
				high = middle - 1;
			} else {
				low = middle + 1;
			}//else
			middle = (low + high)/2;
		}//while
		return (myArray[middle].equals(nameToFind) ? myArray[middle] : null);
	}//binarySearch

	//solution to 11.6
	public void selectionSort() {
		for (int fixPos = 0; fixPos< myCount-1; fixPos++) {
			int posOfSmallest = fixPos;
			for (int posToCompare = fixPos + 1; posToCompare < myCount; posToCompare++){
				if (myArray[posToCompare].before(myArray[posOfSmallest])) {
					posOfSmallest = posToCompare;
				}//if
			} //inner for
			if (posOfSmallest != fixPos) {
				swap(posOfSmallest, fixPos);
			}  //if
		} //outer for
	} //selectionSort

	//solution to 11.7
	public void insertionSort() {
		for (int indexOfItemBeingInserted = 1; indexOfItemBeingInserted< myCount; indexOfItemBeingInserted++) {
			Name temp = myArray[indexOfItemBeingInserted];
			int indexOfItemBeingCompared = indexOfItemBeingInserted - 1;
			while (indexOfItemBeingCompared > -1
					&& temp.before(myArray[indexOfItemBeingCompared])){
				myArray[indexOfItemBeingCompared + 1] = myArray[indexOfItemBeingCompared];
				indexOfItemBeingCompared--;
			} //while to move down items for which temp is "before"
			myArray[indexOfItemBeingCompared] = temp;
		} // for
	} //insertionSort
	
	//solution to 11.8
	public Name searchSorted(Name findMe){
		int i = 0;
		while ( i < myCount && (myArray[i].before(findMe))){
			i++;
		}//while
		return (i == myCount ? null : ( myArray[i].equals(findMe) ? myArray[i] : null)); 
	}//searchSorted




}//NameList
