package forBlackjack;

import javax.swing.*;

public class BJHand extends Hand {
	private int myPointCount;
	private boolean hasAce;

	public BJHand(JLabel [] theLabels, int theMaxCards){
		super(theLabels, theMaxCards);
		myPointCount = 0;
		hasAce = false;
	}//two parameter constructor

	public void resetHand(){
		super.resetHand();
		myPointCount = 0;
		hasAce = false;
	}//resetHand

	public int calcPointCount(){
		int sum = 0;
		for(int i=0; i < myNumOfCards; i++){
			sum = sum + myCards[i].getValue();
		}// for
		if(hasAce && sum <= 11) {
			return sum + 10;
		}// if
		return sum;
	}//calcPointCount


	public void acceptCard(CardWithImage theCard){
		super.acceptCard(theCard);
		if(theCard.getValue() == 1) {
			hasAce = true;
		}// if
		myPointCount = calcPointCount();

	}//acceptCard

	public void turnFirstUp(){
		myCards[0].setFaceUp(true);
		myLabels[0].setIcon(myCards[0].getImage());
		myLabels[0].repaint();
	}//turnFirstUp
}//BJHand