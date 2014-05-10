/*
 * CS 64
 * A GUI provided to test a Queue class
 */

	 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class QueueTest extends JFrame {
	
	private JButton enterQB, dequeueB, peekB;//buttons for the usual queue operations
	private JTextArea queueTA;//where the contents of the queue are displayed
	private JScrollPane queueSP;//controls the queue text area
	private JTextField inputTF, messageTF;//where user enters input for the queue
									//and where messages to the user are displayed
	private JLabel inputL, queueL;//labels for the text fields
	private Container myCP;//reference to the content pane
	private CS64Queue<String> myQueue;//reference to the queue object whose methods
								//must work with this class
	
	
	public QueueTest() {
		super("The Queue Tester");
		setLocation(100, 100);
		setSize(600, 450);
		myCP = getContentPane();
		myCP.setLayout(null);
		
		enterQB = makeButton("Enter Queue", 50, 10, 150, 30, new EnterQBHandler());
		dequeueB = makeButton("Dequeue", 225, 10, 150, 30, new DequeueBHandler());
		peekB = makeButton("Peek", 400, 10, 150, 30, new PeekBHandler());
		
		inputL = makeLabel("Input", 200, 60, 200, 20 );
		queueL = makeLabel("The Queue", 200, 310, 200, 30 );
		
		inputTF = makeTextField("", 200, 80, 200, 30);
		messageTF = makeTextField("", 50, 370, 500, 30);
				
		queueTA = new JTextArea();
		
		queueSP = new JScrollPane(queueTA,
						JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
						JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		queueSP.setSize(400,200);
		queueSP.setLocation(100, 120);
		myCP.add(queueSP); 
 		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}//windowClosing
		}); //end of definition of WindowAdapter and semicolon to end the line 
		
		setVisible(true);
		myQueue = new CS64Queue<String>();
		
	} //constructor QueueTest
	
	private JButton makeButton(String text, int x, int y, int w, int h,
								ActionListener theListener){
		JButton buttonToReturn = new JButton(text);
		buttonToReturn.setLocation(x, y);
		buttonToReturn.setSize(w, h);
		buttonToReturn.addActionListener(theListener);
		myCP.add(buttonToReturn);
		return buttonToReturn;
	}//makeButton
	
	private JLabel makeLabel(String text, int x, int y, int w, int h){
		JLabel labelToReturn = new JLabel(text, JLabel.CENTER);
		labelToReturn.setLocation(x, y);
		labelToReturn.setSize(w, h);
		myCP.add(labelToReturn);
		return labelToReturn;
	}//makeLabel
		
	private JTextField makeTextField(String text, int x, int y, int w, int h){
		JTextField textFieldToReturn = new JTextField(text);
		textFieldToReturn.setLocation(x, y);
		textFieldToReturn.setSize(w, h);
		myCP.add(textFieldToReturn);
		return textFieldToReturn;
	}//makeTextField
		
		
	public class EnterQBHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String userInput = inputTF.getText();
			if(userInput.equals("")){
				messageTF.setText("Nothing to enter the queue.");
			} else {
				if (myQueue.enter(userInput)) {
					messageTF.setText(userInput + " has entered the queue.");
				} else {
					messageTF.setText("Error in " + userInput +
						" trying to enter the queue.");
				}//else
			}//outer else
			queueTA.setText(myQueue.toString());
			inputTF.setText("");
			inputTF.requestFocus();
		}//actionPerformed
	}//EnterQBHandler
	
	public class DequeueBHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String fromQueue;
			if(!myQueue.isEmpty() ) {
				fromQueue = myQueue.dequeue();
				messageTF.setText("The item at the head of the queue, " + fromQueue +
					" has left the queue.");
				queueTA.setText(myQueue.toString());
			} else {
				messageTF.setText("The queue is empty.");
			}//else
			inputTF.requestFocus();
		}//actionPerformed
	}//DequeueBHandler
	
	public class PeekBHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(!myQueue.isEmpty()) {
				messageTF.setText(myQueue.peek() + " is at the head of the queue.");
			} else {
				messageTF.setText("The Queue is empty.");
			}//else
			inputTF.requestFocus();
		}//actionPerformed
	}//PeekBHandler
	
	
	public static void main (String args[]) {
		QueueTest myApp = new QueueTest();
	} //main
} //QueueTest
			

