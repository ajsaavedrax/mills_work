package forDatabase;

public class TestBirthInfo {

	public static void main(String[] args) {
		Name n1 = new Name ("George", "Michael", "Jones");
		Name n2 = new Name ("Randall", "Smith");
		System.out.println("Name n1 is: " + n1);
		System.out.println("Name n2 is: " + n2);
		System.out.println("The first name of n1 is: " + n1.getFirst());
		System.out.println("The middle name of n1 is: " + n1.getMiddle());
		System.out.println("The family name of n1 is: " + n1.getFamily());
		System.out.println("The first name of n2 is: " + n2.getFirst());
		System.out.println("The middle name of n2 is: " + n2.getMiddle());
		System.out.println("The family name of n2 is: " + n2.getFamily());

		n1.setFirst("Richard");
		System.out.println("After changing the first name to Richard, n1 is: " + n1);
		n1.setMiddle("John");
		System.out.println("After changing the middle name to John, n1 is: " + n1);
		n1.setFamily("Brown");
		System.out.println("After changing the family name to Brown, n1 is: " + n1);

		if (n1.equals(n2)){
			System.out.println(n1 + " is equal to "+ n2);
		}else {
			System.out.println(n1 + " is not equal to "+ n2);
		}//else 

		if (n1.equals(n1)){
			System.out.println(n1 + " is equal to "+ n1);
		}else {
			System.out.println(n1 + " is not equal to "+ n1);
		}//else 

		int compareNameValue = n1.compareTo(n2);

		if(compareNameValue < 0){
			System.out.println("by compareTo method: " + n1 + " is before "+ n2);
		}else if (compareNameValue > 0){
			System.out.println("by compareTo method: " +n1 + " is after "+ n2);
		}else {
			System.out.println("by compareTo method: " +n1 + " is equal to "+ n2);
		}//else

		compareNameValue = n2.compareTo(n2);

		if(compareNameValue < 0){
			System.out.println("by compareTo method: " +n2 + " is before "+ n2);
		}else if (compareNameValue > 0){
			System.out.println("by compareTo method: " +n2 + " is after "+ n2);
		}else {
			System.out.println("by compareTo method: " +n2 + " is equal to "+ n2);
		}//else

		if(n1.before(n2)){
			System.out.println("by before method: " +n1 + " is before "+ n2);
		}else {
			System.out.println("by before method: " +n1 + " is not before "+ n2);
		}//else

		if(n1.after(n2)){
			System.out.println("by after method: " +n1 + " is after "+ n2);
		}else {
			System.out.println("by after method: " +n1 + " is not after "+ n2);
		}//else

		BirthDate b1 = new BirthDate(2,6,2014);
		BirthDate b2 = new BirthDate(3,1);
		BirthDate b3 = new BirthDate();
		System.out.println("BirthDate b1 is: " + b1);
		System.out.println("BirthDate b2 is: " + b2);
		System.out.println("BirthDate b3 is: " + b3);
		System.out.println("The month of b1 is " + b1.getMonth());
		System.out.println("The day of b2 is " + b2.getDay());
		System.out.println("The year of b3 is " + b3.getYear());

		b1.setMonth(13);
		System.out.println("After failed attempt to set month to 13, BirthDate b1 is: " + b1);
		b1.setMonth(4);
		System.out.println("After month changed to 4, BirthDate b1 is: " + b1);
		b1.setDay(30);
		System.out.println("After day changed to 30, BirthDate b1 is: " + b1);
		b1.setMonth(2);
		System.out.println("After month changed to 2, day should also change: BirthDate b1 is: " + b1);

		b1.setDay(13);
		System.out.println("After day changed to 13, BirthDate b1 is: " + b1);
		b1.setDay(-1);
		System.out.println("After failed attempt to change day to -1, BirthDate b1 is: " + b1);
		b1.setDay(31);
		System.out.println("After failed attempt to change day to 31, BirthDate b1 is: " + b1);

		b3.setYear(1999);
		System.out.println("Result of getYear on b3 after change to 1999 is " +b3.getYear());
		System.out.println("Since month of b3 is still " + 
				b3.getMonth()+ ", toString on b3 still yields: " +b3);
		
		if (b1.equals(b2)){
			System.out.println(b1 + " is equal to "+ b2);
		}else {
			System.out.println(b1 + " is not equal to "+ b2);
		}//else 

		if (b1.equals(b1)){
			System.out.println(b1 + " is equal to "+ b1);
		}else {
			System.out.println(b1 + " is not equal to "+ b1);
		}//else 

		 int compareBDValue = b1.compareTo(b2);

		if(compareBDValue < 0){
			System.out.println("by compareTo method: " + b1 + " is before "+ b2);
		}else if (compareBDValue > 0){
			System.out.println("by compareTo method: " +b1 + " is after "+ b2);
		}else {
			System.out.println("by compareTo method: " +b1 + " is equal to "+ b2);
		}//else

		compareBDValue = b2.compareTo(b2);

		if(compareBDValue < 0){
			System.out.println("by compareTo method: " +b2 + " is before "+ b2);
		}else if (compareBDValue > 0){
			System.out.println("by compareTo method: " +b2 + " is after "+ b2);
		}else {
			System.out.println("by compareTo method: " +b2 + " is equal to "+ b2);
		}//else

		if(b1.before(b2)){
			System.out.println("by before method: " +b1 + " is before "+ b2);
		}else {
			System.out.println("by before method: " +b1 + " is not before "+ b2);
		}//else

		BirthInfo bI1 = new BirthInfo("Alice", "Mary", "Smithers", 5, 8, 1980);
		BirthInfo bI2 = new BirthInfo("Stephanie", "Nickelby", 5, 8, 1980);
		BirthInfo bI3 = new BirthInfo("Katherine", "Zelda", "Abbot", 5, 8);
		BirthInfo bI4 = new BirthInfo("Denise", "Molly", "Reynolds");
		System.out.println("BirthInfo bI1 is: " + bI1);
		System.out.println("BirthInfo bI2 is: " + bI2);
		System.out.println("BirthInfo bI3 is: " + bI3);
		System.out.println("BirthInfo bI4 is: " + bI4);
		System.out.println("The name of bI1 is: " + bI1.getName());
		System.out.println("The birth date of bI2 is: " + bI2.getBirthDate());
		
		bI1.setName(new Name ("Abraham", "Lincoln"));
		System.out.println("After changing name to Abraham Lincoln, bI1 is " + bI1);
		bI1.setBirthDate(new BirthDate (7,4,1776));
		System.out.println("After changing birth date to July 4, 1776, bI1 is " + bI1);
		
		//just for fun
		Name ofBI3 = bI3.getName();
		ofBI3.setFamily("Boxer");
		System.out.println("After changing family name to Boxer, bI3 is " + bI3);
		
		if (bI1.equals(bI2)){
			System.out.println(bI1 + " is equal to "+ bI2);
		}else {
			System.out.println(bI1 + " is not equal to "+ bI2);
		}//else 

		if (bI1.equals(bI1)){
			System.out.println(bI1 + " is equal to "+ bI1);
		}else {
			System.out.println(bI1 + " is not equal to "+ bI1);
		}//else 

		bI2.setName(new Name ("Abraham", "Lincoln"));
		System.out.println("After changing name to Abraham Lincoln, bI2 is " + bI2);
		
		if (bI1.equals(bI2)){
			System.out.println(bI1 + " is equal to "+ bI2 + " because only names are used for equals.");
		}else {
			System.out.println(bI1 + " is not equal to "+ bI2);
		}//else 
		
		if(bI1.beforeAlpha(bI2)){
			System.out.println("by beforeAlpha method: " +bI1 + " is before "+ bI2);
		}else {
			System.out.println("by beforeAlpha method: " +bI1 + " is not before "+ bI2);
		}//else

		if(bI2.beforeChron(bI1)){
			System.out.println("by beforeChron method: " +bI2 + " is before "+ bI1);
		}else {
			System.out.println("by beforeChron method: " +bI2 + " is not before "+ bI1);
		}//else

		int compareBI = bI1.compareTo(bI3);

		if(compareBI < 0){
			System.out.println("by compareTo method of BirthInfo: " + bI1 + " is before "+ bI3);
		}else if (compareBI > 0){
			System.out.println("by compareTo method of BirthInfo: " +bI1 + " is after "+ bI3);
		}else {
			System.out.println("by compareTo method of BirthInfo: " +bI1 + " is equal to "+ bI3);
		}//else

		compareBI = bI1.compareTo(bI2);

		if(compareBI < 0){
			System.out.println("by compareTo method of BirthInfo: " +bI1 + " is before "+ bI2);
		}else if (compareBI > 0){
			System.out.println("by compareTo method of BirthInfo: " +bI1 + " is after "+ bI2);
		}else {
			System.out.println("by compareTo method of BirthInfo: " +bI1 + " is equal to "+ bI2);
		}//else

	}//main

}//TestBirthInfo
