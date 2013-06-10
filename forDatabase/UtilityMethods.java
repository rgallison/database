package forDatabase;

import javax.swing.*;

import forDatabase.AddressBook.InsertBHandler;
import forDatabase.AddressBook.StateCBHandler;

import java.awt.*;
import java.awt.event.*;

public class UtilityMethods {

	public static JLabel makeLabel(String theS, int theW, int theH, int theX, 
			int theY, Container theCP){
		JLabel theL = new JLabel(theS);
		theL.setSize(theW,theH);
		theL.setLocation(theX,theY);
		theCP.add(theL);
		return theL;
	}//makeLabel
	
	public static JLabel makeLabel(String theS, int theW, int theH, int theX, 
			int theY, boolean theB, Container theCP){
		JLabel theL = new JLabel(theS);
		theL.setSize(theW,theH);
		theL.setLocation(theX,theY);
		theL.setVisible(theB);
		theCP.add(theL);
		return theL;
	}//makeLabel

	public static JTextField makeTextField(int theW, int theH, int theX, int theY, 
			Container theCP){
		JTextField theTF = new JTextField();
		theTF.setSize(theW,theH);
		theTF.setLocation(theX,theY);
		theCP.add(theTF);
		return theTF;
	}//makeTextField

	public static JTextField makeTextField(int theW, int theH, int theX, int theY, 
			Boolean TorF, Container theCP){
		JTextField theTF = new JTextField();
		theTF.setSize(theW,theH);
		theTF.setLocation(theX,theY);
		theTF.setVisible(TorF);
		theCP.add(theTF);
		return theTF;
	}//makeTextField

	public static JComboBox makeComboBox(String[] theChoices, int theW, int theH, 
			int theX, int theY, Container theCP){
		JComboBox theCB = new JComboBox(theChoices);
		theCB.setSize(theW,theH);
		theCB.setLocation(theX,theY);
		theCP.add(theCB);
		return theCB;
	}//makeComboBox

	public static JButton makeButton(String theS, int theW, int theH, int theX, 
			int theY, ActionListener theHandler,
			Container theCP){
		JButton theB = new JButton(theS);
		theB.setSize(theW,theH);
		theB.setLocation(theX,theY);
		theB.addActionListener(theHandler);
		theCP.add(theB);
		return theB;
	}//makeButton

	public static JTextArea makeTextArea(Boolean theB, Container theCP){
		JTextArea theTA = new JTextArea();
		theTA.setEditable(theB);
		theCP.add(theTA);
		return theTA;
	}//makeTextArea
	
	public static JTextArea makeTextArea(Boolean theB, int theW, int theH, int theX, 
											int theY, Container theCP){
		JTextArea theTA = new JTextArea();
		theTA.setEditable(theB);
		theTA.setSize(theW, theH);
		theTA.setLocation(theX, theY);
		theCP.add(theTA);
		return theTA;
	}//makeTextArea

	public static JScrollPane makeScrollPane(JTextArea theTA, int theW, int theH, 
												int theX, int theY, Container theCP){
		JScrollPane theSP = new JScrollPane(theTA,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		theSP.setSize(theW,theH);
		theSP.setLocation(theX,theY);
		theCP.add(theSP);
		return theSP;
	}//makeScrollPane

	public static void closeToQuit(JFrame theWindow){
		theWindow.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}//windowClosing
		}); //end of definition of WindowAdapter and semicolon to end the line 
	}//closeToQuit
}//UtilityMethods
