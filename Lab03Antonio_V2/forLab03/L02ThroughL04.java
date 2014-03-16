//Antonio Saavedra
//CS64
//Lab 03
//18 February 2014

package forLab03;

public class L02ThroughL04 {

	// reference to an array to hold some numbers
	private static int myInts[];
	
	//constant maximum number of elements in the array
	private static final int MAXNUMS = 100;
	
	private static void insertionSortMyInts(){
		for(int indexOfItemToBeInserted = 1; 
				indexOfItemToBeInserted < myInts.length;
				indexOfItemToBeInserted++){
			int temp = myInts[indexOfItemToBeInserted];
			int indexOfItemToBeCompared = indexOfItemToBeInserted - 1;
			while(indexOfItemToBeCompared > -1 &&
					myInts[indexOfItemToBeCompared] > temp){
				myInts[indexOfItemToBeCompared + 1] 
						= myInts[indexOfItemToBeCompared];
				indexOfItemToBeCompared--;
			}//while loop
			myInts[indexOfItemToBeCompared + 1] = temp;
		}//for loop
	}//insertionSortMyInts
	
	private static void displayMyInts(String msg) {
		System.out.println(msg);
		for (int i = 0; i < myInts.length; i++) {
			System.out.print(myInts[i] + "\t");//tabs between values
			if( i % 10 == 9) {//10 values will be displayed per line
				System.out.println();
			}//if
		}//for
		System.out.println();//makes a blank line at the end
	}//displayMyNumbers
		
	private static void swap (int firstPos, int otherPos) {
		int temp = myInts[firstPos];
		myInts[firstPos] = myInts[otherPos];
		myInts[otherPos] = temp;
	}//swap


	public static void bubbleSortMyInts() {
		for(int passNum = 1; passNum < myInts.length; passNum++) {
		 	for (int j = 0; j < myInts.length - passNum; j++) {
				if(myInts[j+1] < myInts[j]) {
					swap(j, j+1);
				}//if
			}//inner for loop for one pass
		}//for loop that controls passes over the data
	}//bubbleSort
	
	public static int findMax(){
		int maxValue = 0;
		for (int i=0; i< myInts.length; i++){
			if (myInts[i] > maxValue){
				maxValue = myInts[i];
			}//if
		}//for loop
		return maxValue;
	}//findMax
	
	public static int findMin(){
		int minValue = 49;
		for (int i=0; i< myInts.length; i++){
			if (myInts[i] < minValue){
				minValue = myInts[i];
			}//if
		}//for loop
		return minValue;
	}//findMind
	
	public static void greater(int theInt){
		System.out.println("The ints greater than " + theInt + " are listed below: ");
		for (int i=0; i<myInts.length; i++){
			if(myInts[i] > theInt){
				System.out.print(myInts[i] + "\t");//tabs between values
			}//if
			if( i % 10 == 9) {//10 values will be displayed per line
				System.out.println();
			}//if
		}//for loop
	}//greater
	
	public static void even(String msg){
		System.out.println(msg);
		int lineBreak = 0;
		for (int i=0; i<myInts.length; i++){
			if(myInts[i]%2 == 0){
				System.out.print(myInts[i] + "\t");
				lineBreak++;
				if( lineBreak % 10 == 9) {//10 values will be displayed per line
					System.out.println();
				}//if
			}//if
		}//for
		System.out.println();
	}//even
	
	public static void totalEven(){
		int totalEven = 0;
		for (int i=0; i<myInts.length; i++){
			if(myInts[i]%2 == 0){
				totalEven++;
			}//if
		}//for loop
		System.out.println("The total number of even integers in the array is: " + totalEven);
	}//totalEven
	
	public static void backwards(String msg){
		System.out.println(msg);
		for (int i=99; i>-1; i--){
			System.out.print(myInts[i] + "\t");
			if( i % 10 == 9) {//10 values will be displayed per line
				System.out.println();
				}//if
		}//for
		System.out.println();//makes a blank line at the end
	}//backwards
	
	public static void everyOther(){
		System.out.println("Every other int in the array is: ");
		for (int i=0; i<myInts.length; i++){
			if(myInts[i]%2 == 0){
				System.out.print(myInts[i] + "\t");
			}//if
			if( i % 20 == 19) {//10 values will be displayed per line
				System.out.println();
			}//if
		}//for
	}//everyOther
	
	public static int totalSum(){
		int sum = 0;
		for (int i=0; i<myInts.length; i++){
			sum += myInts[i];
		}//for
		return sum;
	}//totalSum
	
	public static void sumGreaterThan(int theInt){
		int greater = 0;
		for(int i=0; i<myInts.length; i++){
			if(myInts[i]>theInt){
				greater+=myInts[i];
			}//if
		}//for
		System.out.println("\nThe sum of all the ints greater than "
				+ theInt + " is: " + greater + "\n");
	}//sumGreaterThan
	
	public static void replaceWithNeg1(int theInt){
		for(int i=0; i<myInts.length; i++){
			if(theInt == myInts[i]){
				myInts[i] = -1;
			}//if
		}//for
		System.out.println("\nEvery int of value " + theInt + " has been replaced"
				+ " by a -1.\n");
	}//replaceWithNeg1
	
	public static void reverseTheOrder(){
		System.out.println("\nThe order of elements stored in the array has been reversed: \n");
		for(int i=0; i<myInts.length; i++){
			int temp = myInts[i];
			myInts[i] = myInts.length-(i+1);
			myInts[myInts.length-(i+1)] = temp;
			System.out.print(myInts[i] + "\t");//tabs between values
			if( i % 10 == 9) {//10 values will be displayed per line
				System.out.println();
			}//if
		}//for
	}//reverseTheOrder
	
	public static void rotateByOne(){
		int temp = myInts[99];
		for(int i=0; i<myInts.length; i++){
			myInts[i+1] = myInts[i];
			temp = myInts[0];
		}//for
	}//rotateByOne
	
	public static void rotateByTwo(){
		System.out.println("\nThe order of elements stored in the array have been rotated by two: \n");
		int temp1 = myInts[98];
		int temp2 = myInts[99];
		for(int i=0; i<myInts.length; i++){
			myInts[i+2] = myInts[i];
			temp1 = myInts[0];
			temp2 = myInts[1];
		}//for loop
	}//rotateByTwo
	
	public static void rotateBy(int theInt){
		theInt = theInt%myInts.length;
		int temp[] = new int[theInt];
		//for loop to copy last num entries into temp
		for(int i=0; i<theInt; i++){
			temp[i] = myInts[myInts.length-theInt+i];
		}
		//for loop to move items in the array down by theInt position
		for(int i=0; i<myInts.length; i++){
			myInts[i + theInt] = myInts[i];
		}
		//for loop to copy items in temp back into myInts
		for(int i=0; i<theInt; i++){
			myInts[i] = temp[i];
		}
	}//rotateBy
	
	public static void multOfFive(){
		System.out.println("\nThe elements in the array that are in positions"
				+ " that are multiples of 5 are: \n");
		for(int i=0; i<myInts.length; i++){
			if(i % 5 == 0){
				System.out.print(myInts[i] + "\t");
			}//if
			if( i % 10 == 9) {//10 values will be displayed per line
				System.out.println();
			}//if
		}//for
		System.out.println();//makes a blank line at the end
	}//multOfFive
	
	public static void multOfFour(){
		System.out.println("\nThe elements in the array that are in positions"
				+ " that are multiples of 4 are: \n");
		for(int i=0; i<myInts.length; i++){
			if(i % 4 == 0){
				System.out.print(myInts[i] + "\t");
			}//if
			if( i % 10 == 9) {//10 values will be displayed per line
				System.out.println();
			}//if
		}//for
		System.out.println();//makes a blank line at the end
	}//multOfFour
	
	public static void multOfInt(int theInt){
		System.out.println("\nThe elements in the array that are in positions"
				+ " that are multiples of " + theInt + " are: \n");
		for(int i=0; i<myInts.length; i++){
			if(i % theInt == 0){
				System.out.print(myInts[i] + "\t");
			}//if
			if( i % 10 == 9) {//10 values will be displayed per line
				System.out.println();
			}//if
		}//for
		System.out.println();
	}//multOfInt
	
	public static void main (String args[]) {
		System.out.println("CS 64 Lab 02 Antonio Saavedra");
		//allocate array to hold the ints
		myInts = new int [MAXNUMS];
		
		System.out.println("Array will contain " + myInts.length + 
							" random integers in the range 0-49");
		
		// generate random ints
		for (int i=0; i<  myInts.length; i++) {
			//random ints will be in range 0-49
			myInts[i]=(int) (Math.random() * 50);
		}//for
		
		// display values in the array with message
		displayMyInts("\nThe ints in the array are: \n");
		
		bubbleSortMyInts();
		
		displayMyInts("\nThe ints in the array after sorting are: \n");

		findMax();
		
		findMin();
		
		greater(15);
		
		greater(-1);
		
		greater(49);
		
		even("\nThe ints that are even are listed below: \n");
		
		totalEven();
		
		backwards("\nThe array listed backwards: \n");
		
		everyOther();
		
		System.out.println("\nThe sum of all the ints is: " + totalSum() +"\n");
		
		sumGreaterThan(-1);
		
		sumGreaterThan(32);
		
		reverseTheOrder();
		
		replaceWithNeg1(4);
		
		multOfFive();
		
		multOfFour();
		
		multOfInt(3);

	}  //main
	
}  //Lab03