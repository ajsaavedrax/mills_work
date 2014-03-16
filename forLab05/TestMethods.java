package forLab05;

public class TestMethods {
	public static void main(String[] args) {
		//array of Integer references
		Integer[] myIntegers = new Integer [100];
		System.out.println("Array will contain " + myIntegers.length + 
				" random Integers in the range 0-99");
		// generate random ints
		for (int i=0; i<  myIntegers.length; i++) {
			//random ints will be in range 0-99
			//auto-boxing the int on the right to assign
			//to the Integer on the left
			myIntegers[i] = (int) (Math.random() * 100);
		}//for
		UtilityMethods.display("\nThe Integers in the array are: \n", myIntegers, 100);
		System.out.println("The maximum Integer is: " + UtilityMethods.maximum(myIntegers,100));
		UtilityMethods.bubbleSort(myIntegers,100);
		UtilityMethods.display("\nThe Integers in the array after sorting are: \n", myIntegers, 100);

		//array of String references
		String[] myStrings = new String[20];
		myStrings[0] = "Hi";
		myStrings[1] = "Hello";
		myStrings[2] = "Good-bye";
		myStrings[3] = "Bye";
		myStrings[4] = "Aardvark";
		myStrings[5] = "Dog";
		myStrings[6] = "Cat";
		myStrings[7] = "Mills";
		myStrings[8] = "College";
		myStrings[9] = "March";
		UtilityMethods.display("\nThe Strings in the array are: \n", myStrings,10);
		System.out.println("The maximum String is: " + UtilityMethods.maximum(myStrings,10));
		UtilityMethods.bubbleSort(myStrings,10);
		UtilityMethods.display("\nThe Strings in the array after sorting are: \n", myStrings,10);
	}//main
}//TestMethods
