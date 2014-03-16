package forLab05;

import java.util.*;

public class UtilityMethods {
	public static <E> void display(String msg, E [] theArray, int theCount) {
		System.out.println(msg);
		for (int i = 0; i < theCount; i++) {
			System.out.print(theArray[i] + "\t");//tabs between  values
			if( i % 10 == 9) {//10 values will be displayed per line
				System.out.println();
			}//if
		}//for
		System.out.println();// blank line at the end
	}//display


	public static <E extends Comparable<E>> void bubbleSort(E[] theArray, int theCount){
		for (int passNum = 1; passNum < theCount; passNum++) {
			for(int j = 0; j < theCount - passNum; j++) {
				if(theArray[j + 1].compareTo( theArray[j]) < 0 ){
					swap(theArray, j, j + 1);
				}//if
			}//inner for
		}//outer for
	}//bubbleSort

	public static <E > void bubbleSort(E[] theArray, int theCount, Comparator<E> theComparator){
		for (int passNum = 1; passNum < theCount; passNum++) {
			for(int j = 0; j < theCount - passNum; j++) {
				if(theComparator.compare(theArray[j + 1], theArray[j]) < 0 ){
					swap(theArray, j, j + 1);
				}//if
			}//inner for
		}//outer for
	}//bubbleSort

	private static <E> void swap (E[] theArray, int firstPos, int secondPos){
		E temp = theArray[firstPos];
		theArray[firstPos] = theArray[secondPos];
		theArray[secondPos] = temp;
	}//swap

	public static <E extends Comparable <E>> E maximum(E[] theArray, int theCount){
		E maxNow = theArray[0];
		for (int i = 1; i < theCount; i++) {
			if(maxNow.compareTo(theArray[i]) < 0){
				maxNow = theArray[i];
			}//if
		}//for
		return maxNow;
	}//maximum



}
