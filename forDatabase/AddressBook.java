//Renee Gallison
//CS 64
//Assignment 3
//2/11/2011

package forDatabase;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class AddressBook extends JFrame{

	private static JComboBox stateCB;//Declares a reference for a combo box containing 50
	//states for user to pick from.
	private JButton insertB, searchB, deleteB, saveB, loadB, alphaDisplayB, addressDisplayB;//Declares a reference for buttons, so user can 
	//manipulate database.
	private static JTextField firstTF, lastTF, phoneTF, streetTF, optionalTF, cityTF, zipTF;
	//Declares a reference for text field, so user can provide information.
	private static JLabel firstL, lastL, phoneL, streetL, optionalL, cityL, stateL, zipL;
	//Declares a reference for labels, to indicate purpose of text fields.
	static JTextArea displayTA;//Declares a reference for a text area, which 
	//displays information in database
	private JScrollPane displaySP;
	//Declares a reference for a scroll pane for displayTA.
	private Container myCP;
	//handy reference to the content pane.
	static AddressInfoList myList = new AddressInfoList();

	public AddressBook(){
		super("My Address Book");
		setUpJFrame();
		constructLabels();
		constructTextFields();
		constructButtons();
		stateCB = UtilityMethods.makeComboBox(Address.STATE_ABBREVIATIONS, 75, 20,
				290, 160, myCP);
		displayTA = UtilityMethods.makeTextArea(false, myCP);
		displaySP = UtilityMethods.makeScrollPane(displayTA, 350, 270, 30, 290, 
				myCP);
		UtilityMethods.closeToQuit(this);
		setVisible(true);
	}//constructor for AddressBook

	private void setUpJFrame(){
		setSize(415,600);
		setBackground(new Color(32,178,170));
		myCP = getContentPane();
		myCP.setLayout(null);
	}//setUpJFrame

	private void constructTextFields(){
		firstTF = UtilityMethods.makeTextField(200, 20, 140, 10, myCP);		
		lastTF = UtilityMethods.makeTextField(200, 20, 140, 40, myCP);
		phoneTF = UtilityMethods.makeTextField(200, 20, 140, 70, myCP);
		streetTF = UtilityMethods.makeTextField(200, 20, 140, 100, myCP);
		optionalTF = UtilityMethods.makeTextField(200, 20, 140, 130, myCP);
		cityTF = UtilityMethods.makeTextField(150, 20, 70, 160, myCP);
		zipTF = UtilityMethods.makeTextField(100, 20, 110, 190, myCP);
	}//allTextFields

	public void constructLabels(){
		firstL = UtilityMethods.makeLabel("First Name:", 100, 15, 20, 15, myCP);
		lastL = UtilityMethods.makeLabel("Last Name:", 100, 15, 20, 45, myCP);
		phoneL = UtilityMethods.makeLabel("Phone Number:", 150, 15, 20, 75, myCP);
		streetL = UtilityMethods.makeLabel("Street:", 100, 15, 20, 105, myCP);
		optionalL = UtilityMethods.makeLabel("2nd Line:", 100, 15, 20, 135, myCP);	
		cityL = UtilityMethods.makeLabel("City:", 50, 15, 20, 165, myCP);
		stateL = UtilityMethods.makeLabel("State:", 50, 15, 240, 165, myCP);
		zipL = UtilityMethods.makeLabel("Zipcode:", 100, 15, 20, 195, myCP);
	}//constructLabels

	public void constructButtons(){
		insertB = UtilityMethods.makeButton("Insert", 90, 20, 260, 195, new InsertBHandler(), myCP);
		searchB = UtilityMethods.makeButton("Search", 90, 20, 15, 225, new SearchBHandler(), myCP);
		deleteB = UtilityMethods.makeButton("Delete", 90, 20, 110, 225, new DeleteBHandler(), myCP);
		saveB = UtilityMethods.makeButton("Save", 90, 20, 205, 225, new SaveBHandler(), myCP);
//		loadB = UtilityMethods.makeButton("Load", 90, 20, 300, 225, new LoadBHandler(), myCP);
		alphaDisplayB = UtilityMethods.makeButton("Alphabetical Display", 160, 20, 15, 255, new AlphaDisplayBHandler(), myCP);
		addressDisplayB = UtilityMethods.makeButton("Address Display", 130, 20, 180, 255,new AddressDisplayBHandler(), myCP);
	}//constructButtons

	private void clear(){
		firstTF.setText("");
		lastTF.setText("");
		phoneTF.setText("");
		streetTF.setText("");
		optionalTF.setText("");
		cityTF.setText("");
		stateCB.setSelectedItem("--");
		zipTF.setText("");		
	}//clear

	//goes in private AIAndErrorString processUserInput(){
	//	private String errorMsg = "";
	//	private AddressInfo found = null;
	//	private String processInputTF(JTextField theTF, String forErrorMsg){
	//		String toReturn = theTF.getText();
	//		if(toReturn.equals("")){
	//			errorMsg += "You need to enter a " + forErrorMsg + "\n";
	//		}//if text field is left blank
	//		return toReturn;
	//	}//processInputTF

	public class InsertBHandler implements ActionListener {
		public void actionPerformed(ActionEvent e){
			String first = firstTF.getText();
			String last = lastTF.getText();
			String phone = phoneTF.getText();
			String street = streetTF.getText();
			String optional = optionalTF.getText();
			String city = cityTF.getText();
			String state = (String) stateCB.getSelectedItem();
			int zip = Address.getZipcode(zipTF.getText());
			if(!(first.equals("") && last.equals("")) && !(street.equals("") && city.equals("")  && state.equals("--")) && zip != -99999 
																				|| !(phone.equals(""))){
				AddressInfo newItem = new AddressInfo(firstTF.getText(), lastTF.getText(), phoneTF.getText(), streetTF.getText(), 
														optionalTF.getText(), cityTF.getText(),	stateCB.getSelectedItem(), zipTF.getText());
				firstL.setForeground(Color.BLACK);
				lastL.setForeground(Color.BLACK);
				streetL.setForeground(Color.BLACK);
				cityL.setForeground(Color.BLACK);
				stateL.setForeground(Color.BLACK);
				zipL.setForeground(Color.BLACK);
				if(myList.insert(newItem)){
					displayTA.setText("Add of " + newItem.toString() + " was successful.\n\n" );
					firstTF.requestFocus();
					clear();
				}else{
					displayTA.setText("Add not successful.\n");
					String[] args = null;
					Replace.main(args);
					firstTF.requestFocus();
				}//else add not successful
			}else{
				displayTA.append("Please provide the nessecary data.\n");
				if(first.equals("")){
					firstL.setForeground(Color.RED);
				}//if there is no first name
				if(last.equals("")){
					lastL.setForeground(Color.RED);
				}//if there is no last name
				
				if(street.equals("")){
					streetL.setForeground(Color.RED);
				}//if there is no street
				if(city.equals("")){
					cityL.setForeground(Color.RED);
				}//if there is no city
				if(state.equals("--")){
					stateL.setForeground(Color.RED);
				}//if there is no state
				if(zip == -99999){
					zipL.setForeground(Color.RED);
				}//if there is no zipcode
			}//else user didn't provide all information
			
		}//actionPerformed
	}//InsertBHandler

	public class SearchBHandler implements ActionListener {
		public void actionPerformed(ActionEvent e){
			String[] args = null;
			Search.main(args);
		}//actionPerformed
	}//SearchBHandler

	public class DeleteBHandler implements ActionListener {
		public void actionPerformed(ActionEvent e){
			String[] args = null;
			Delete.main(args);
		}//actionPerformed
	}//DeleteBHandler
	
	public class LoadBHandler implements ActionListener {
		public void actionPerformed(ActionEvent e){
			String[] args = null;
			Load.main(args);
		}//actionPerformed
	}//LoadBHandler

	public class AlphaDisplayBHandler implements ActionListener {
		public void actionPerformed(ActionEvent e){
			myList.alphaSort();
		}//actionPerformed
	}//AlphaSortBHandler

	public class AddressDisplayBHandler implements ActionListener {
		public void actionPerformed(ActionEvent e){
			myList.addressSort();
		}//actionPerformed
	}//AddressSortHandler

	public class SaveBHandler implements ActionListener {
		public void actionPerformed(ActionEvent e){
			String[] args = null;
			Save.main(args);
		}//actionPerformed
	}//SaveBHandler

	public class StateCBHandler implements ActionListener { 
		public void actionPerformed(ActionEvent e){
		}//actionPerformed
	}//StateCBHandler

	public static void main(String[] args) {
		AddressBook myAppF = new AddressBook();

	}//main

	public static class Search extends JFrame{
		private JLabel searchL, firstL, lastL, infoL;
		//Declares a reference to a label
		private JComboBox methodCB;//Declares a reference to a combo box
		private JButton okB, cancelB;//Declares a reference to buttons
		private JTextField firstTF, lastTF, infoTF;
		//Declares a reference to a text field 
		public final String[] SearchMethods = {"Name","Street","City","State","Zipcode"};			
		private Container myCP;//Declares a reference to a content pane

		public Search(){
			super("Search");
			setUpJFrame();
			searchL = UtilityMethods.makeLabel("Which method would you like to use?", 300,20, 25,15,myCP);
			methodCB = UtilityMethods.makeComboBox(SearchMethods,100,20,100,45, myCP);
			methodCB.addActionListener(new MethodsCBHandler());
			firstL = UtilityMethods.makeLabel("First Name",100,20,55,75,myCP);
			lastL = UtilityMethods.makeLabel("Last Name",100,20,165,75,myCP);
			infoL = UtilityMethods.makeLabel("Street",100,20,55,75,false,myCP);
			firstTF = UtilityMethods.makeTextField(100,20,50,95,myCP);
			lastTF = UtilityMethods.makeTextField(100,20,160,95,myCP);
			infoTF = UtilityMethods.makeTextField(200,20,55,95, false, myCP);
			okB = UtilityMethods.makeButton("Ok",100,20,50,125,new OkBHandler(), myCP);
			cancelB = UtilityMethods.makeButton("Cancel",100,20,160,125, new CancelBHandler(),myCP);
			setVisible(true);
		}//constructor for search window

		private void setUpJFrame(){
			setSize(320,195);
			setLocation(75,175);
			setBackground(new Color(20,85,200));
			myCP = getContentPane();
			myCP.setLayout(null);
		}//setUpJFrame
		
		public class MethodsCBHandler implements ActionListener {
			public void actionPerformed(ActionEvent e){
				String theMethod = (String) methodCB.getSelectedItem();
				if(theMethod.equals("Name")){
					firstL.setVisible(true);
					firstTF.setVisible(true);
					firstL.setVisible(true);
					lastL.setVisible(true);
					lastTF.setVisible(true);
					infoL.setVisible(false);
					infoTF.setVisible(false);
					firstTF.requestFocus();
				}//if Name method is selected
				if(theMethod.equals("Street")){
					firstL.setVisible(false);
					firstTF.setVisible(false);
					lastL.setVisible(false);
					lastTF.setVisible(false);
					infoL.setVisible(true);
					infoTF.setVisible(true);
					infoTF.requestFocus();
				}//if Street method is selected
				if(theMethod.equals("City")){
					firstL.setVisible(false);
					firstTF.setVisible(false);
					lastL.setVisible(false);
					lastTF.setVisible(false);
					infoL.setText("City");
					infoL.setVisible(true);
					infoTF.setVisible(true);
					infoTF.requestFocus();
				}//if City method is selected
				if(theMethod.equals("State")){
					firstL.setVisible(false);
					firstTF.setVisible(false);
					lastL.setVisible(false);
					lastTF.setVisible(false);
					infoL.setText("State");
					infoL.setVisible(true);
					infoTF.setSize(30,20);
					infoTF.setVisible(true);
					infoTF.requestFocus();
				}//if the State method is selected
				if(theMethod.equals("Zipcode")){
					firstL.setVisible(false);
					firstTF.setVisible(false);
					lastL.setVisible(false);
					lastTF.setVisible(false);
					infoL.setText("Zipcode");
					infoL.setVisible(true);
					infoTF.setVisible(true);
					infoTF.requestFocus();
				}//if Zipcode method is selected
			}//actionPerformed
		}//MethodCBHandler

		public class OkBHandler implements ActionListener {
			public void actionPerformed(ActionEvent e){
				String theMethod = (String) methodCB.getSelectedItem();
				if(theMethod.equals("Name") && !(firstTF.getText().equals("")) && !(lastTF.getText().equals(""))){
					AddressInfo theName = new AddressInfo(firstTF.getText(), lastTF.getText());
					displayTA.append("Results of search:\n" + myList.search(theName) + "\n");
					if(myList.search(theName) == null){
						displayTA.append("Name cannot be found.\n");
					}//if search returns null
					setVisible(false);
					firstTF.setText("");
					lastTF.setText("");
				}else{
					firstL.setForeground(Color.RED);
					lastL.setForeground(Color.RED);
				}//else there is no name entered
				if(theMethod.equals("Street") && !(infoTF.getText().equals(""))){
					String theStreet = infoTF.getText();
					displayTA.append("Results of search:\n" + myList.searchStreet(theStreet) + "\n");
					if(myList.searchStreet(theStreet) == null){
						displayTA.append("Street cannot be found.\n");
					}//if search returns null
					setVisible(false);
					infoTF.setText("");
				}else{
					infoL.setForeground(Color.RED);
				}//else there is no street entered
				if(theMethod.equals("City") && !(infoTF.getText().equals(""))){
					String theCity = infoTF.getText();
					displayTA.append("Results of search:\n" + myList.searchCity(theCity) + "\n");
					if(myList.searchCity(theCity) == null){
						displayTA.append("City cannot be found.\n");
					}//if search returns null
					setVisible(false);
					infoTF.setText("");
					infoTF.requestFocus();
				}else{
					infoL.setForeground(Color.RED);
				}//else there is no city entered
				if(theMethod.equals("State") && !(infoTF.getText().equals(""))){
					String theState = infoTF.getText();
					displayTA.append("Results of search:\n" + myList.searchState(theState) + "\n");
					if(myList.searchState(theState) == null){
						displayTA.append("State cannot be found.\n");
					}//if search returns null
					setVisible(false);
					infoTF.setText("");
					
				}else{
					infoL.setForeground(Color.RED);
				}//else there is no state entered
				if(theMethod.equals("Zipcode") && !(infoTF.getText().equals(""))){
					String theZip = infoTF.getText();
					displayTA.append("Results of search:\n" + myList.searchZip(theZip) + "\n");
					if(myList.searchZip(theZip) == null){
						displayTA.append("Zipcode cannot be found.\n");
					}//if search returns null
					setVisible(false);
					infoTF.setText("");
				}else{
					infoL.setForeground(Color.RED);
				}//else there is no state entered
			}//actionPerformed
		}//OkBHandler

		public class CancelBHandler implements ActionListener {
			public void actionPerformed(ActionEvent e){
				setVisible(false);
			}//actionPerformed
		}//SaveBHandler

		public static void main(String[] args) {
			Search myAppF = new Search();
		}//main
	}//search
	public static class Delete extends JFrame{
		private JLabel deleteL, firstL, lastL;//Declares a reference to a label
		private JTextField firstTF, lastTF;//Declares references to text fields
		private JTextArea infoTA;//Declares a reference to a text area
		private JButton okB, cancelB, deleteAllB;//Declares references to buttons
		private int buttonClicksCount = 0;//Declares an int to keep track of button clicks
		private AddressInfo toBeDeleted;//Declares a reference to an object to be deleted
		private Container myCP;//handy reference to the content pane.

		public Delete(){
			super("Delete");
			setUpJFrame();
			deleteL = UtilityMethods.makeLabel("Who do you want to delete?",240,
					20, 25, 15, myCP);
			firstL = UtilityMethods.makeLabel("First Name", 100, 20, 35, 45, myCP);
			lastL = UtilityMethods.makeLabel("Last Name", 100, 20, 145, 45, myCP);
			firstTF = UtilityMethods.makeTextField(100, 20, 35, 70, myCP);
			lastTF = UtilityMethods.makeTextField(100, 20, 145, 70, myCP);
			infoTA = UtilityMethods.makeTextArea(false, 190, 75, 50, 100, myCP);
			okB = UtilityMethods.makeButton("Ok", 100, 20, 35, 195, new OkBHandler(), myCP);
			cancelB = UtilityMethods.makeButton("Cancel", 100, 20, 145, 195, new CancelBHandler(), myCP);
			deleteAllB = UtilityMethods.makeButton("Delete All", 150, 20, 70, 225, new DeleteAllBHandler(), myCP);
			setVisible(true);
		}//constructor for delete window

		private void setUpJFrame(){
			setSize(290,290);
			setLocation(75,175);
			setBackground(new Color(20,85,200));
			myCP = getContentPane();
			myCP.setLayout(null);
		}//setUpJFrame

		public class OkBHandler implements ActionListener {
			public void actionPerformed(ActionEvent e){
				buttonClicksCount++;
				if(buttonClicksCount%2 == 1){
					if(firstTF.getText().equals("") || lastTF.getText().equals("")){
						infoTA.append("Please enter a name.\n");
						buttonClicksCount--;
						firstL.setForeground(Color.RED);
						lastL.setForeground(Color.RED);
					}else{
						AddressInfo theName = new AddressInfo(firstTF.getText(), lastTF.getText());
						toBeDeleted = myList.search(theName);
						if(toBeDeleted != null){
							infoTA.append("Is this the address you wish to delete?");
							infoTA.append(toBeDeleted.toString() + "\n");
							firstTF.setText("");
							lastTF.setText("");
							firstL.setForeground(Color.BLACK);
							lastL.setForeground(Color.BLACK);
						}else{
							infoTA.setText("Name is not in Address Book./n");
							firstTF.setText("");
							lastTF.setText("");
						}//if name is not in database
					}//else fields have been filled
				}else{
					if(myList.delete(toBeDeleted)){
						infoTA.append("Deletion was successful.");
					}else{
						infoTA.append("Deletion failed.");
					}//else
				}//else on second click
			}//actionPerformed
		}//OkBHandler

		public class CancelBHandler implements ActionListener {
			public void actionPerformed(ActionEvent e){
				setVisible(false);
			}//actionPerformed
		}//CancelBHandler
		
		public class DeleteAllBHandler implements ActionListener{
			public void actionPerformed(ActionEvent e){
				if(myList.deleteAll()){
					displayTA.append("All Entries have been deleted\n");
				}else{
					displayTA.append("All Entries have not been deleted\n");
				}//else deleteAll failed
				setVisible(false);
			}//actionPerformed
		}//DeleteAllBHandler

		public static void main(String[] args) {
			Delete myAppF = new Delete();
		}//main
	}//Delete
	
	public static class Load extends JFrame{
		private JLabel fileNameL;//Declares a reference to a label
		private JTextField fileNameTF;//Declares a reference to a text field
		private JButton okB, cancelB;//Declares a reference to a button
		private JTextArea outputTA;//Declares a reference to a text area
		private JScrollPane outputSP;//Declares a reference to a scroll pane for outputTA
		private String fileName;//Declares a reference to file name user chooses
		private Container myCP;//Declares a reference to the content pane
		
		public Load(){
			super("Load");
			setUpJFrame();
			fileNameL = UtilityMethods.makeLabel("File Name:",240, 20, 35, 15, myCP);
			fileNameTF = UtilityMethods.makeTextField(150, 20, 35, 40, myCP);
			okB = UtilityMethods.makeButton("Ok", 100, 20, 35, 70, new OkBHandler(), myCP);
			cancelB = UtilityMethods.makeButton("Cancel", 100, 20, 145, 70, new CancelBHandler(), myCP);
			outputTA = UtilityMethods.makeTextArea(false, myCP);
			outputSP = UtilityMethods.makeScrollPane(outputTA, 210, 100, 35, 100, myCP);
			setVisible(true);
		}//constructor for Load window
		
		private void setUpJFrame(){
			setSize(290,245);
			setLocation(75,175);
			setBackground(new Color(215,20,100));
			myCP = getContentPane();
			myCP.setLayout(null);
		}//setUpJFrame
		
		public class OkBHandler implements ActionListener{
			public void actionPerformed(ActionEvent e){
				fileName = fileNameTF.getText();
				if(fileName.compareTo("") > 0){
					File theFile = new File(fileName);
					if(!theFile.exists()){
						outputTA.setText(fileName + " does not exist - cannot load data.\n");
					}else if(!theFile.canRead()){
						outputTA.setText("Cannot read from " + fileName + ".\n");
					}else{
						String fromLoad = myList.loadFromFile(fileName);
						outputTA.setText("Data loaded from " + fileName + ":\n" + fromLoad + "\n"); 
					}//else file loaded successfully
					fileNameTF.setText("");
				}else{
					outputTA.setText("You must enter a file name in order to load file");
				}//else fileNameTF was left blank
			}//actionPerformed
		}//OkBHandler
		
		public class CancelBHandler implements ActionListener{
			public void actionPerformed(ActionEvent e){
				setVisible(false);
			}//actionPerformed
		}//CancelBHandler
		
		public static void main(String[] args) {
			Load myAppF = new Load();
		}//main
	}//Load

	public static class Save extends JFrame{
		private JLabel fileNameL;//Declares a reference to a label
		private JTextField fileNameTF;// Declares a reference to a text field
		private JButton okB, cancelB;//Declares a reference to buttons
		private JTextArea outputTA;// Declares a reference to a text area
		private JScrollPane outputSP;//Declares a reference to a scroll pane for outputTA
		//private AddressInfo currentAIRecord, found;//Declares a reference to a record currently being entered 
													//and a record found in the list in memory
		private boolean processingSave;//Set as true when awaiting ok or cancel during save operation
		private String fileName;//Declares a reference to name user wishes to call file
		private String errorMsg, first, last;//To pass said String from valipdNameInput method
		private Container myCP;//handy reference to the content pane.

		public Save(){
			super("Save");
			setUpJFrame();
			fileNameL = UtilityMethods.makeLabel("File Name:",240, 20, 35, 15, myCP);
			fileNameTF = UtilityMethods.makeTextField(150, 20, 35, 40, myCP);
			okB = UtilityMethods.makeButton("Ok", 100, 20, 35, 70, new OkBHandler(), myCP);
			cancelB = UtilityMethods.makeButton("Cancel", 100, 20, 145, 70, new CancelBHandler(), myCP);
			outputTA = UtilityMethods.makeTextArea(false, myCP);
			outputSP = UtilityMethods.makeScrollPane(outputTA, 210, 100, 35, 100, myCP);
			processingSave = false;
			setVisible(true);
		}//constructor for save window

		private void setUpJFrame(){
			setSize(290,245);
			setLocation(75,175);
			setBackground(new Color(215,20,100));
			myCP = getContentPane();
			myCP.setLayout(null);
		}//setUpJFrame
				
		public class OkBHandler implements ActionListener {
			public void actionPerformed(ActionEvent e){
				String message = "";
				fileName = fileNameTF.getText();
				if(fileName.compareTo("") != 0){
					File theFile = new File (fileName);
					if(!theFile.exists()){
						message = myList.saveToFile(fileName);
						outputTA.setText("Data saved to file " + fileName + ".\n" + message + "\n");
						processingSave = false;
					}else if(!theFile.canWrite()){
						outputTA.setText("Cannot write data to " + fileName + ".\n");
						fileNameTF.setText("");
					}else{
						outputTA.setText("File already exists.\nClick Ok to overwrite.\nClick cancel to quit.\n");
						processingSave = true;
					}//else
					fileNameTF.setText("");
				} else if(processingSave){
					message = myList.saveToFile(fileName);
					outputTA.setText("Data saved to file " + fileName + ".\n" + message + "\n");
					processingSave = false;
				}else{
					outputTA.setText("You must enter a fileName.\n");
				}//else
			}//actionPerformed
		}//SaveBHandler

		public class CancelBHandler implements ActionListener {
			public void actionPerformed(ActionEvent e){
				if(!processingSave){
					setVisible(false);
				}//if user doesn't wish to save
				if(processingSave){
					outputTA.append(fileName + " was not overwritten.\nPlease enter another filename.");
				}//if user doesn't wish to overwrite
				
				
			}//actionPerformed
		}//SaveBHandler

		public static void main(String[] args) {
			Save myAppF = new Save();
		}//main
	}//Save

	public static class Replace extends JFrame{
		private JLabel messageL;//Declares a reference to a label
		private JTextArea addressTA, address2TA;//Declares a reference to a Text area containing existing address
		private JLabel message2L;//Declares a reference to a label
		private JButton okB, cancelB;//Declares reference to buttons
		private Container myCP;//Declares a reference to a Content Pane

		public Replace(){
			super("File Already Exists");
			setUpJFrame();
			messageL = UtilityMethods.makeLabel("Address already exists:", 200, 20, 30, 15, myCP);
			addressTA = UtilityMethods.makeTextArea(false, 150, 85, 40, 40, myCP);
			addressTA.setText(oldAddress + "");
			message2L = UtilityMethods.makeLabel("Do you wish to replace it with:", 240, 20, 30, 130, myCP);
			addressTA = UtilityMethods.makeTextArea(false, 150, 85, 40, 155, myCP);
			addressTA.setText(newAddress + "");
			okB = UtilityMethods.makeButton("Ok", 100, 20, 35, 250, new OkBHandler(), myCP);
			cancelB = UtilityMethods.makeButton("Cancel", 100, 20, 140, 250, new CancelBHandler(), myCP);
			setVisible(true);
		}//constructor

		AddressInfo oldAddress = myList.search(new AddressInfo(firstTF.getText(), lastTF.getText()));
		AddressInfo newAddress = new AddressInfo(firstTF.getText(), lastTF.getText(), 
				streetTF.getText(), optionalTF.getText(), cityTF.getText(),
				stateCB.getSelectedItem(), zipTF.getText());

		private void setUpJFrame(){
			setSize(280,320);
			setLocation(75,175);
			setBackground(new Color(215,20,100));
			myCP = getContentPane();
			myCP.setLayout(null);
		}//setUpJFrame

		public class OkBHandler implements ActionListener{
			public void actionPerformed(ActionEvent e){
				myList.delete(oldAddress);
				myList.insert(newAddress);
				setVisible(false);
				displayTA.setText("Add was successful.");
			}//actionPerformed
		}//OkBHandler

		public class CancelBHandler implements ActionListener{
			public void actionPerformed(ActionEvent e){
				setVisible(false);
			}//actionPerformed
		}//CancelBHandler

		public static void main(String[] args){
			Replace myAppF = new Replace();
		}//main
	}//Replace

}//AddressBook
