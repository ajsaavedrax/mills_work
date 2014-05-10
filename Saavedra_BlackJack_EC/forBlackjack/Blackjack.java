//Antonio Saavedra
//cards edited by Jason Gallagher
//CS64 Extra Credit
//13 February 2014

package forBlackjack;


import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Blackjack extends JFrame {
	private JPanel houseP, playerP;
	private JLabel myCardsL[], houseCardsL[], houseL, playerL;
	private JButton shuffleB, hitB, standB, newB, quitB;
	private JTextField messageTF;
	private Deck myDeck;
	private BJHand myHand, houseHand;
	private Container myCP;
	private static final int MAX_CARDS_IN_HAND = 5;
	
	public Blackjack(){
		super("Blackjack");
		setSize(600, 600);
		setLocation(100, 100);
		setBackground(Color.LIGHT_GRAY);
		myCP = getContentPane();
		myCP.setLayout(null);
		
		Font funFont = new Font("Geneva", 0, 12);
		
		shuffleB = makeButton("Shuffle", 50, 20, 100, 500, funFont, new Color(0, 100, 0), new ShuffleBHandler());
		hitB = makeButton("Hit", 50, 20, 160, 500, funFont, new Color(0, 100, 0), new HitBHandler());
		hitB.setEnabled(false);
		standB = makeButton("Stand", 50, 20, 220, 500, funFont, new Color(0, 100, 0), new StandBHandler());
		standB.setEnabled(false);
		newB = makeButton("New Game", 90, 20, 280, 500, funFont, new Color (0, 100, 0), new NewBHandler());
		newB.setEnabled(false);
		quitB = makeButton("Quit Game", 90, 20, 380, 500, funFont, new Color(0, 100, 0), new QuitBHandler());
		quitB.setEnabled(false);
		
		houseL = new JLabel("House Cards");
		houseL.setSize(100, 20);
		houseL.setLocation(20, 25);
		myCP.add(houseL);
		
		playerL = new JLabel("Player Cards");
		playerL.setSize(100, 20);
		playerL.setLocation(20, 280);
		myCP.add(playerL);
		
		houseP = makePanel(MAX_CARDS_IN_HAND * 105, 150, 20, 45, Color.RED);
		playerP = makePanel(MAX_CARDS_IN_HAND * 105, 150, 20, 300, Color.RED);
		
		messageTF = makeTextField( "To begin, press the Shuffle button.", 400, 25, 95, 525, funFont, false);

		//now construct each JLabel and add it to the JPanel
				
				myCardsL = new JLabel [5];
				houseCardsL = new JLabel [5];
				
				//construct the player cards
				for (int i = 0; i < MAX_CARDS_IN_HAND; i++) {
					myCardsL[i] = new JLabel();
					
					playerP.add(myCardsL[i]);
				
				//construct the house cards
					houseCardsL[i] = new JLabel();
					houseP.add(houseCardsL[i]);
				}//for lop to construct array of cards
				
				myHand = new BJHand(myCardsL, MAX_CARDS_IN_HAND);
				houseHand = new BJHand(houseCardsL, MAX_CARDS_IN_HAND);
				
				myDeck = new Deck(); //construct a deck of cards and make the reference myDeck point to it.
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}//windowClosing
		}); //end of definition of WindowAdapter and semicolon to end the line
		 
		setVisible(true); // make frame visible
	}//Blackjack constructor
	
	private JButton makeButton(String theText, int theWidth, int theHeight, int theX, int theY, Font thefont,
			Color theForeground, ActionListener theHandler){
		JButton buttonToReturn = new JButton(theText);
		buttonToReturn.setSize(theWidth, theHeight);
		buttonToReturn.setLocation(theX, theY);
		buttonToReturn.setFont(thefont);
		buttonToReturn.setForeground(theForeground);
		myCP.add(buttonToReturn);
		buttonToReturn.addActionListener(theHandler);
		return buttonToReturn;
	}//makeButton
	
	private JTextField makeTextField(String theText, int theWidth, int theHeight, int theX, int theY,
			 Font thefont, boolean editability){
		JTextField textFieldToReturn = new JTextField(theText);
		textFieldToReturn.setSize(theWidth, theHeight);
		textFieldToReturn.setLocation(theX, theY);
		textFieldToReturn.setFont(thefont);
		textFieldToReturn.setEditable(editability);
		myCP.add(textFieldToReturn);
		return textFieldToReturn;
	}//makeTextField
	
	private JPanel makePanel(int theWidth, int theHeight, int theX, int theY,
			Color theBackground){
		JPanel panelToReturn = new JPanel();
		panelToReturn.setLayout(new GridLayout(1, MAX_CARDS_IN_HAND));
		panelToReturn.setSize(theWidth, theHeight);
		panelToReturn.setLocation(theX, theY);
		panelToReturn.setBackground(theBackground);
		myCP.add(panelToReturn);
		return panelToReturn;
	}//makePanel
	
	public class ShuffleBHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			myHand.resetHand();//get ready for a new hand of cards
			houseHand.resetHand();
			myDeck.shuffle();//shuffle the deck
			myDeck.setNextCard(0); //start dealing at the top of the deck by initializing the
				 //instance variable myNextCard of the Deck class.
			shuffleB.setEnabled(false);
			newB.setEnabled(true);// enable the game buttons
			hitB.setEnabled(false);
			quitB.setEnabled(true);
			messageTF.setText("The entire deck has been shuffled. Press New Game to start.");
		}//actionPerformed
	}//ShuffleBHandler
	
	public class HitBHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			standB.setEnabled(true);
			
			if(myHand.getNumOfCards()>=2){// deal first card face down
					CardWithImage c = myDeck.dealOne(true);// ask the deck to deal a card face up
					CardWithImage d = myDeck.dealOne(true);
					myHand.acceptCard(c);//command the GenericHand object to accept the card that was dealt
					messageTF.setText(c.displayCard() + " has been dealt. Your hand point value is: "
						+ myHand.calcPointCount());
			} else {
				messageTF.setText ("There are no cards left. You must shuffle." );
				shuffleB.setEnabled(true);
				hitB.setEnabled(false);// disable the deal button
				standB.setEnabled(false);
			}// else
			
			if (myHand.calcPointCount()>21){
				hitB.setEnabled(false);
				standB.setEnabled(false);
				houseHand.turnFirstUp();
				messageTF.setText("Player bust! House wins. Try again?");
			}else if(houseHand.calcPointCount()==21){
				hitB.setEnabled(false);
				standB.setEnabled(false);
				houseHand.turnFirstUp();
				messageTF.setText("House wins. Try again?");
			}else if (myHand.calcPointCount()<=21 && myHand.getNumOfCards()==5){
				hitB.setEnabled(false);
				standB.setEnabled(false);
				houseHand.turnFirstUp();
				messageTF.setText("Congratulations! You win! Play again?");
			}//if player gets 5 cards and doesn't bust
		}//actionPerformed
	}//HitBHandler
	
	public class StandBHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			hitB.setEnabled(false);
			standB.setEnabled(false);
			houseHand.turnFirstUp();
			if(houseHand.calcPointCount()<17){
				while(houseHand.calcPointCount( ) < 17 &&
						houseHand.getNumOfCards( ) < 5 ){
						houseHand.acceptCard(myDeck.dealOne(true)); 
					}// while loop
			}//if house has less than 17 points
			if(houseHand.calcPointCount()>=17 && houseHand.calcPointCount()<=20){
				if(myHand.calcPointCount()>houseHand.calcPointCount()){
					messageTF.setText("Congratulations! You win! Play Again?");
				}else{
					messageTF.setText("House wins. Try again?");
				}//else
				if(myHand.calcPointCount()==houseHand.calcPointCount()){
					messageTF.setText("It's a draw! Play again?");
				}//if the point count for both are the same
			}//else
			if(houseHand.calcPointCount()==21){
				messageTF.setText("House wins. Try again?");
			}else if(houseHand.calcPointCount()>21){
					messageTF.setText("House bust. You win! Play again?");
			}else if(houseHand.calcPointCount()<21&&houseHand.getNumOfCards()==5){
					messageTF.setText("House wins by default. Try again?");
			}//else if
		}//actionPerformed
	}//StandBHandler
	
	public class NewBHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			myHand.resetHand();
			houseHand.resetHand();
			messageTF.setText("");
			if (myDeck.cardsLeft() >  9) {// determine if there are cards left to deal
				if(myHand.getNumOfCards() == MAX_CARDS_IN_HAND){
					myHand.resetHand();
				}// start a new hand of 5 cards
				if(houseHand.getNumOfCards() == MAX_CARDS_IN_HAND){
					houseHand.resetHand();
				}//if
				if(myHand.getNumOfCards()==0){
				CardWithImage card1 = myDeck.dealOne(true);// ask the deck to deal a card face up
				CardWithImage card2 = myDeck.dealOne(false);
				CardWithImage card3 = myDeck.dealOne(true);
				CardWithImage card4 = myDeck.dealOne(true);
				myHand.acceptCard(card1);//command the GenericHand object to accept the card that was dealt
				houseHand.acceptCard(card2);
				myHand.acceptCard(card3);
				houseHand.acceptCard(card4);
				messageTF.setText(card3.displayCard() + " has been dealt. Your hand point value is: "
						+ myHand.calcPointCount());
				}//if
			}//if
			if(myHand.calcPointCount()==21){
				hitB.setEnabled(false);
				standB.setEnabled(false);
				houseHand.turnFirstUp();
				messageTF.setText("You win! Play again?");
			}else{
				hitB.setEnabled(true);
				standB.setEnabled(true);
			}//else
		}//actionPerformed
	}//NewBHandler
	
	public class QuitBHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			myHand.resetHand();
			houseHand.resetHand();
			messageTF.setText("To restart the game, click the Shuffle button.");
			quitB.setEnabled(false);
			newB.setEnabled(false);
			hitB.setEnabled(false);
			standB.setEnabled(false);
			shuffleB.setEnabled(true);
		}//actionPerformed
	}//QuitBHandler
	
	public static void main (String args[]) {
		Blackjack myAppF = new Blackjack();
	}//main
}//Blackjack