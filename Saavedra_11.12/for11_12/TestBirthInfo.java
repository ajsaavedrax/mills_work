package for11_12;

public class TestBirthInfo{
	public static void main (String args[]){
		BirthInfo firstBirth, secondBirth, thirdBirth, fourthBirth;
		//test 6 parameter constructor
		firstBirth = new BirthInfo("Antonio", "Jaime", "Saavedra",
				7, 3, 1991);
		//test 5 parameter constructor
		secondBirth = new BirthInfo("Thuy", "Nguyen", "Pham",
				3, 2);
		//test 5 parameter constructor
		thirdBirth = new BirthInfo("Cristina", "Alquisira",
				8, 5, 1991);
		//test 3 parameter constructor
		fourthBirth = new BirthInfo("Antonio", "Jaime", "Saavedra");
		
		System.out.println("The first birth info is: " + firstBirth.toString());
		System.out.println("The second birth info is: " + secondBirth.toString());
		System.out.println("The third birth info is: " + thirdBirth.toString());
		System.out.println("The fourth birth info is: " + fourthBirth.toString());
		System.out.println();
		//check getName
		System.out.println("The first birth info has the name: " + firstBirth.getName());
		System.out.println();
		//check setName
		firstBirth.setName(new Name("Tony", "Saavedra"));
		System.out.println("The first birth info name has been changed to: "
				+ firstBirth.toString());
		System.out.println();
		//check getBD
		System.out.println("The first birth date info is: " + firstBirth.getBirthDate());
		System.out.println();
		//check setBD
		firstBirth.setBirthDate(new BirthDate(2, 14, 1939));
		System.out.println("The first birth date info has been changed to: "
				+ firstBirth.toString());
		System.out.println();
		//check beforeAlpha
		System.out.println(firstBirth.beforeAlpha(firstBirth));
		System.out.println(firstBirth.beforeAlpha(secondBirth));
		System.out.println(firstBirth.beforeAlpha(thirdBirth));
		System.out.println(secondBirth.beforeAlpha(firstBirth));
		System.out.println(secondBirth.beforeAlpha(secondBirth));
		System.out.println(secondBirth.beforeAlpha(thirdBirth));
		System.out.println(thirdBirth.beforeAlpha(thirdBirth));
		System.out.println(thirdBirth.beforeAlpha(firstBirth));
		System.out.println(thirdBirth.beforeAlpha(secondBirth));
		System.out.println();
		//check equals
		System.out.println(firstBirth.equals(firstBirth));
		System.out.println(firstBirth.equals(thirdBirth));
		System.out.println();
		//check beforeChron
		System.out.println(firstBirth.beforeChron(secondBirth));
		System.out.println(secondBirth.beforeChron(firstBirth));
		System.out.println();
		//check compareTo
		System.out.println(firstBirth.compareTo(firstBirth));
		System.out.println(firstBirth.compareTo(secondBirth));
		System.out.println(firstBirth.compareTo(thirdBirth));
		System.out.println(secondBirth.compareTo(thirdBirth));
		System.out.println(secondBirth.compareTo(firstBirth));
		System.out.println(secondBirth.compareTo(secondBirth));
		System.out.println(thirdBirth.compareTo(firstBirth));
		System.out.println(thirdBirth.compareTo(thirdBirth));
		System.out.println(thirdBirth.compareTo(secondBirth));
		
	}//main
}//TestBirthInfo