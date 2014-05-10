package forBlackjack;

import java.awt.*;
import javax.swing.*;

public class Hand {

	protected CardWithImage myCards[];//reference to array of CardWithImage
	protected int myNumOfCards;//number of cards currently in the hand
	protected JLabel myLabels[];//labels where card images will be displayed
	private int myMaxCards;//maximum number of cards this hand can hold
	
	public Hand(JLabel[] theLabels, int theMaxCards){
		myCards = new CardWithImage[theMaxCards];
		myMaxCards = theMaxCards;
		myNumOfCards = 0;
		myLabels = theLabels;
	}//constructor
		
	public int getNumOfCards () {	//access method
		return myNumOfCards;
	}//getNumOfCards

	public int getMaxCards () {	//access method
		return myMaxCards;
	}//getMaxCards

	public void setNumOfCards (int theNumOfCards) {	//modifier method
		myNumOfCards = theNumOfCards;
	}//setNumOfCards

	
	public void resetHand () {	
		for (int i = 0; i < myNumOfCards; i++) {
			myLabels[i].setIcon(null);
		}//for loop
		myNumOfCards = 0;
	}//resetHand
	
	public String toString() {
		String tempS = "";
		for (int i = 0; i < myNumOfCards; i++) {
			tempS += myCards[i].toString()+"\n";
		}//for
		return tempS;
	}//toString
	
	
	public void acceptCard (CardWithImage theCard) {
		if (myNumOfCards > myMaxCards - 1) {
			System.out.println("Error, hand cannot accept more cards!");
		}else {
			myLabels[myNumOfCards].setIcon(theCard.getImage());
			myLabels[myNumOfCards].repaint();
			myCards[myNumOfCards++] = theCard;
		}//else
	}//acceptCard
}//Hand
