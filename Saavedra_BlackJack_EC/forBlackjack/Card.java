package forBlackjack;

public class Card {
	// Instance variables - Each Card object needs its own set 
	// of these variables.
	private String myRank;// string representation of the rank
	private String mySuit;// string representation of the suit
	private int myValue;// depends on the game, also used in sorting cards 
	// into order
	private boolean myFaceUp; // true if the card is face up, 
	//false if face down

	public Card( String theRank, String theSuit, int theValue) {
		// assign parameters to appropriate instance variables
		myRank= theRank;
		mySuit= theSuit;
		myValue = theValue;
		myFaceUp = false;
	}//3 parameter Card constructor

	public Card( String theRank, String theSuit) {
		// assign parameters to appropriate instance variables
		myRank= theRank;
		mySuit= theSuit;
		myValue = 0;
		myFaceUp = false;
	}//2 parameter Card constructor

	public String toString() { //returns string designation of card	
		return "My rank is " + myRank + "\n" 
		+ "My suit is " + mySuit + "\n"
		+ "My face up value is " + myFaceUp + "\n"
		+ "My value is " + myValue + ".\n";
	}//toString

	public String displayCard() { //returns string of card for display
		if (myFaceUp) {
			return myRank + " of " + mySuit;
		}//if
		return "************";
	}//displayCard

	public String getSuit() {// access method, returns suit of the Card
		return mySuit;
	}//getSuit

	public String getRank() {// access method, returns rank of the Card
		return myRank;
	}//getRank

	public int getValue() {// access method, returns value of the Card
		return myValue;
	}//getValue

	public boolean isFaceUp() {  // access method, returns face up 
		// status of the Card
		return myFaceUp;
	}//isFaceUp

	public void setValue(int theValue) {//modifier method, sets myValue
		myValue = theValue;
	}//setValue

	public void setFaceUp(boolean theFaceUp) {//modifier method, sets myFaceUp 
		myFaceUp = theFaceUp;
	}//setFaceUp

}//Card
