//Antonio Saavedra
//CS64
//Assignment 05
package for11_13;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

import javax.swing.*;

public class BirthdayDatabase extends JFrame{
	private JButton addB, displayB, alphaB, chronB, searchB, deleteB;
	private JLabel firstL, middleL, lastL, birthL, yearL;
	private JTextField firstTF, middleTF, lastTF, yearTF;
	private JTextArea messageTA;
	private JScrollPane messageSP;
	private JComboBox monthCB, dayCB;
	private Container myCP;
	BirthInfo found;
	BirthInfoList bIL = new BirthInfoList();
	private static final String[] MONTH_CHOICES = 
		{"Choose Month", "January", "February", "March", "April", "May",
		"June", "July", "August", "September", "October", "November", "December"};
	
	private static final String[] DAY_CHOICES = 
		{"Choose Day", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11","12",
		"13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25",
		"26", "27", "28", "29", "30", "31"};
	
	
	public BirthdayDatabase(){
		super("Birthday Database");
		setSize(900, 600);
		setLocation(100, 100);
		setBackground(new Color(255,105,180));
		myCP = getContentPane();
		myCP.setLayout(null);
		
		addB = makeButton("Add", 50, 20, 700, 105, new AddBHandler());
		displayB = makeButton("Display All", 100, 20, 100, 500, new DisplayBHandler());
		alphaB = makeButton("Display Alphabetically", 200, 20, 300, 500, new AlphaBHandler());
		chronB = makeButton("Display Chronologically", 200, 20, 600, 500, new ChronBHandler());
		searchB = makeButton("Search", 50, 20, 640, 105, new SearchBHandler());
		deleteB = makeButton("Delete", 50, 20, 760, 105, new DeleteBHandler());
		
		firstL = makeLabel("First Name: ", 80, 20, 10, 50);
		middleL = makeLabel("Middle Name: ", 100, 20, 280, 50);
		lastL = makeLabel("Last Name: ", 100, 20, 560, 50);
		birthL = makeLabel("Birth Info: ", 100, 20, 10, 105);
		yearL = makeLabel("Birth Year: ", 100, 20, 430, 105);
		
		firstTF = makeTextField(180, 20, 90, 50, new FirstTFHandler());
		middleTF = makeTextField(180, 20, 370, 50, new MiddleTFHandler());
		middleTF.setEditable(false);
		lastTF = makeTextField(180, 20, 630, 50, new LastTFHandler());
		lastTF.setEditable(false);
		yearTF = makeTextField(100, 20, 500, 105, new YearTFHandler());
		yearTF.setEditable(false);
		
		messageTA = new JTextArea("Welcome to the Birthday Database! Please start by entering a first"
				+ " name and hit the return key.\n");
		messageTA.setEnabled(false);
		
		messageSP = new JScrollPane(messageTA);
		messageSP.setSize(700, 300);
		messageSP.setLocation(100, 170);
		myCP.add(messageSP);
		
		monthCB = new JComboBox(MONTH_CHOICES);
		monthCB.setSize(150, 30);
		monthCB.setLocation(90, 100);
		monthCB.addActionListener(new MonthCBHandler());
		monthCB.setEnabled(false);
		myCP.add(monthCB);
		
		dayCB = new JComboBox(DAY_CHOICES);
		dayCB.setSize(150, 30);
		dayCB.setLocation(260, 100);
		dayCB.addActionListener(new DayCBHandler());
		dayCB.setEnabled(false);
		myCP.add(dayCB);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}//windowClosing
		}); //end of definition of WindowAdapter and semicolon to end the line
		 
		setVisible(true); // make frame visible
	}//BirthdayDatabase constructor
	
	private JButton makeButton(String theText,int theWidth, int theHeight,
			int theX, int theY, ActionListener theHandler){
		JButton buttonToReturn = new JButton(theText);
		buttonToReturn.setSize(theWidth, theHeight);
		buttonToReturn.setLocation(theX, theY);
		myCP.add(buttonToReturn);
		buttonToReturn.addActionListener(theHandler);
		return buttonToReturn;
	}//makeButton
	
	private JTextField makeTextField(int theWidth, int theHeight, int theX,
			int theY, ActionListener theHandler){
	JTextField textFieldToReturn = new JTextField("");
	textFieldToReturn.setSize(theWidth, theHeight);
	textFieldToReturn.setLocation(theX, theY);
	myCP.add(textFieldToReturn);
	textFieldToReturn.addActionListener(theHandler);
	return textFieldToReturn;
	}//makeTextField
	
	private JLabel makeLabel(String theText, int theWidth, int theHeight,
			int theX, int theY){
		JLabel labelToReturn = new JLabel(theText);
		labelToReturn.setSize(theWidth, theHeight);
		labelToReturn.setLocation(theX, theY);
		myCP.add(labelToReturn);
		return labelToReturn;
	}//makeLabel
		
	public class AddBHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String first = firstTF.getText();
			String middle = middleTF.getText();
			String last = lastTF.getText();
			int month = monthCB.getSelectedIndex();
			int day = dayCB.getSelectedIndex();
			String userInput = yearTF.getText();
			int year = Integer.parseInt(userInput);
			
			BirthInfo bI1 = new BirthInfo(first, middle, last, month, day, year);
			BirthInfo bI2 = new BirthInfo(first, middle, last, month, day, year);
			
			if(bIL.add(bI1)){
				messageTA.append(bI1.getName() + " has been successfully added.\n"
						+ "The list is now:\n"
						+ bIL);
			}//if
			
			if(bIL.add(bI2)){
				messageTA.append(bI2.getName() + " has been successfully added.\n"
						+ "The list is now:\n"
						+ bIL);
			}//if
			
			if(bIL.isFull()){
				messageTA.append("The list is now full.\n");
			}//if
			
		}//actionPerformed
	}//AddBHandler
	
	public class DisplayBHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			messageTA.append("The Display button has been clicked.\n");
		}//actionPerformed
	}//DisplayBHandler
	
	public class AlphaBHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			bIL.alphaSort();
			messageTA.append("The list has been alphabetized:\n"
					+ bIL);
		}//actionPerformed
	}//AlphaBHandler
	
	public class ChronBHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			bIL.chronSort();
			messageTA.append("The list has been sorted chronologically:\n"
					+ bIL);
		}//actionPerformed
	}//ChronBHandler
	
	public class SearchBHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			messageTA.append("The Search button has been clicked.\n");
		}//actionPerformed
	}//SearchBHandler
	
	public class DeleteBHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			messageTA.append("The Delete button has been clicked.\n");
			
		}//actionPerformed
	}//DeleteBHandler
	
	public class FirstTFHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			messageTA.append("The First Name textfield has been filled.\n"
					+ "Optional: if known, enter a middle name and hit return.\n"
					+ "Otherwise, a last name is required.\n");
			middleTF.setEditable(true);
			lastTF.setEditable(true);
		}//actionPerformed
	}//FirstTFHandler
	
	public class MiddleTFHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			messageTA.append("The Middle Name textfield has been filled.\n"
					+ "Enter a last name and hit return.\n");
		}//actionPerformed
	}//MiddleTFHandler
	
	public class LastTFHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			messageTA.append("The Last Name textfield has been filled.\n" 
						+ "Please enter the birth month.\n");
			monthCB.setEnabled(true);
		}//actionPerformed
	}//LastTFHandler
	
	public class YearTFHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			messageTA.append("The Birth Year textfield has been utilized.\n"
					+"Click the Add button.\n");
		}//actionPerformed
	}//YearTFHandler
	
	public class MonthCBHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			messageTA.append("A month has been selected.\n"
					+ "A birth day is required.\n");
			dayCB.setEnabled(true);
			int current = dayCB.getItemCount()-1;
			int desired = BirthDate.MAX_DAYS_IN_MONTH[monthCB.getSelectedIndex()];
			if(current<desired){
				for(int i=current+1; i<=desired; i++){
					dayCB.addItem(i+"");
				}//for
			}else if(current>desired){
				for(int i=current; i>desired; i--){
					dayCB.removeItem(i+"");
				}//for
			}//else if
		}//actionPerformed
	}//MonthCBHandler
	
	public class DayCBHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
			messageTA.append("A day has been selected.\n"
					+ "Optional: if know, enter a birth year.\n"
					+ "Otherwise, click the Add button.\n");
			yearTF.setEditable(true);
		}//actionPerformed
	}//DayCBHandler
	
	public static void main (String args[]){
		BirthdayDatabase myAppF = new BirthdayDatabase();
	}//main
}//BirthdayDatabase
