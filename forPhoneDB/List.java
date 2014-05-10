package forPhoneDB;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import javax.swing.*;

public class List <E extends Comparable<E>> {
	
	private E myArray[]; // array of Objects
	private int myCount;// current count of Objects in List
	private Comparator<E> myComparator;// comparator for alternate ordering scheme
	private static final int THE_MAX = 5;
	
	public List () {
		myArray = (E []) new Comparable[THE_MAX];
		myCount = 0;
		myComparator = null;
	}//0 parameter constructor
	
	public List (int theSize) {
		myArray = (E []) new Comparable[theSize];
		myCount = 0;
		myComparator = null;
	}//1 parameter constructor
	
	public List (Comparator<E> theComparator) {
		myArray = (E []) new Comparable[THE_MAX];
		myCount = 0;
		myComparator = theComparator;
	}//0 parameter constructor
	
	public List (int theSize, Comparator<E> theComparator) {
		myArray = (E []) new Comparable[theSize];
		myCount = 0;
		myComparator = theComparator;
	}//1 parameter constructor
	
	private int myCompare (E firstE, E secondE){
		if(myComparator == null) {
			return firstE.compareTo(secondE);
		}//no comparator
		return myComparator.compare(firstE, secondE);
	}//myCompare
	
	public boolean isFull(){
		return myCount == myArray.length;
	}//isFull
	
	public boolean add(E addMe) {
		if (!isFull()){
			myArray[myCount++] = addMe;
			return true;
		}//add was successful
		System.out.println("Attempting to add to full array");
		return false;
	}//add
	
	public E search (E findMe){
		int i = 0;
		while (i < myCount && !(myArray[i].equals(findMe))){
			i++;
		}//while
		return (i < myCount ? myArray[i] : null);
	}//search
	
	private void swap (int firstPos, int otherPos){
		E temp = myArray[firstPos];
		myArray[firstPos] = myArray[otherPos];
		myArray[otherPos] = temp;
	}//swap
	
	public boolean delete (E deleteMe){
		int i = 0;
		while (i < myCount && !(myArray[i].equals(deleteMe))){
			i++;
		}//while
		if(i < myCount ) {
			moveUp(i);
			return true;
		}//if
		return false;
	}//search
	
	private void moveUp(int posToDelete){
		for(int i = posToDelete; i < myCount -1; i++){
			myArray[i] = myArray[i + 1];
		}//for
		myCount--;
	}//moveUp
	
	
	public void bubbleSort(){
		for (int passNum = 1; passNum < myCount; passNum++) {
			for(int j = 0; j < myCount - passNum; j++) {
				if(myCompare(myArray[j + 1],myArray[j]) < 0 ){
					swap(j, j + 1);
				}//if
			}//inner for
		}//outer for
	}//bubbleSort
	
	public String toString(){
		String toReturn = "";
		for (int i = 0; i < myCount; i++){
			toReturn += myArray[i].toString() + "\n";
		}//for
		return toReturn;
	}//toString
	
	public String saveToFile(String fileName) {
		String messageFromSave = "";
		try{
			ObjectOutputStream oOS = new ObjectOutputStream(new	FileOutputStream(fileName));
			for(int i = 0; i < myCount  ; i++) {
				oOS.writeObject(myArray[i]);
			}//for
			oOS.flush();
			oOS.close();
		}//try
		catch(Exception e) {
			messageFromSave = e.toString();
		}//catch
		return messageFromSave;
	}//saveToFile			
	
	public String loadFromFile(String fileName) {
		String toReturn = "";
		try {
			ObjectInputStream oIS = 
				new ObjectInputStream(new FileInputStream(fileName));
			while(true) {
				E fromFile = (E)(oIS.readObject());
				E found = (E)search(fromFile);
				if( found == null) { //person not already in DB
					if (add(fromFile)) {
						toReturn += fromFile + " successfully added to DB.\n";
					}else {
						toReturn += fromFile + " not successfully added to DB.\n";
					}//inner else
				}else {
					toReturn += found + " already in DB.\n"
								+ "record not added from file!\n";
				}//else
			}//while
		}//try
		catch(EOFException eOF) {
		}//catch
		catch(Exception e) {
			toReturn += e;
		}//catch
		return toReturn;
	}//loadFromFile

}
