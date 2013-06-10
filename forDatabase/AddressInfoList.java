package forDatabase;

import java.io.*;

public class AddressInfoList implements Serializable{
	private AddressInfo myArray[];//Declares a reference to an array of AddressInfo objects
	private int myCount;//Declares a reference to an int representing the number of objects in array
	public static final int THE_MAX = 100;

	public AddressInfoList (){
		myArray = new AddressInfo[THE_MAX];
		myCount = 0;
	}// no parameter constructor

	public boolean insert(AddressInfo theAI){
		if(myCount < myArray.length){
			if(search(theAI)==null){
				myArray[myCount++] = theAI;
				return true;
			}//if theAI is not in list
			AddressBook.displayTA.append("Attempting to add to duplicate name");
			return false;
		}//if there is space in the array
		AddressBook.displayTA.append("Attempting to add to a full array");
		return false;
	}//if

	public boolean delete(AddressInfo theAI){
		for(int i = 0;i < myCount; i++){
			if(myArray[i].equals(theAI)){
				for(int j = i; j < myCount-1; j++){
					myArray[j] = myArray[j+1];
				}//for each index
				myCount--;
				return true;
			}//if
		}//for each index
		return false;
	}//delete
	
	public boolean deleteAll(){
		while(!isEmpty()){	
			delete(myArray[0]);
		}//while array is not empty
		return isEmpty();
	}//deleteAll

	public AddressInfo search(AddressInfo theAI){
		int i = 0;
		while(i < myCount && !myArray[i].equals(theAI)){
			i++;
		}//while
		return ( i < myCount? myArray[i]: null);
	}//search
	
	public boolean isFull(){
		return myCount == myArray.length;
	}//isFull
	
	public boolean isEmpty(){
		return myCount == 0;
	}//isEmpty
	
	public String searchStreet(String theStreet){
		String toReturn = "";
		for(int i = 0; i < myCount; i++){
			if(myArray[i].getStreet().equals(theStreet)){
				toReturn += myArray[i] + "\n\n";
			}//if street is found
		}//for each index, search
		return (!(toReturn.equals(""))? toReturn: null);
	}//searchStreet

	public String searchCity(String theCity){
		String toReturn = "";
		for(int i = 0; i < myCount; i++){
			if(myArray[i].getCity().equals(theCity)){
				toReturn += myArray[i] + "\n\n";
			}//if city is found
		}//for each index, search
		return (!(toReturn.equals(""))? toReturn: null);
	}//searchCity

	public String searchState(String theState){
		String toReturn = "";
		for(int i = 0; i < myCount; i++){
			if(myArray[i].getState().equals(theState)){
				toReturn += myArray[i] + "\n\n";
			}//if state is found
		}//for each index, search
		return (!(toReturn.equals(""))? toReturn: null);
	}//searchState
	
	public String searchZip(String theZip){
		String toReturn = "";
		for(int i = 0; i < myCount; i++){
			if(myArray[i].getZip().equals(theZip)){
				toReturn += myArray[i] + "\n\n";
			}//if zip is found
		}//for each index, search
		return (!(toReturn.equals(""))? toReturn: null);
	}//searchStreet
	
	public void swap(int firstPos, int lastPos){
		AddressInfo temp = myArray[firstPos];
		myArray[firstPos] = myArray[lastPos];
		myArray[lastPos] = temp;
	}//swap
	
	public void alphaSort() {
		for (int i = 1; i < myArray.length; i++) {
			for(int j = 0; j < myCount-i; j++){
				if(myArray[j+1].beforeAlpha(myArray[j])){
					swap(j, j+1);
				}//if the next element is greater than current element, swap
			}//for first pass through array
		}//for consecutive passes, until  array is sorted
	} //insertionSortMyInts

	public void addressSort() {
		for (int i = 1; i < myArray.length; i++) {
			for(int j = 0; j < myCount-i; j++){
				if(myArray[j+1].beforeAddress(myArray[j])){
					swap(j, j+1);
				}//if the next element is greater than current element, swap
			}//for first pass through array
		}//for consecutive passes, until  array is sorted
	} //insertionSortMyInts

	public String toString(){
		String toReturn = "";
		for(int i = 0;i < myCount;i++){
			toReturn += myArray[i] + "\n\n";
		}//for each index
		return toReturn;
	}//toString
	
	public String saveToFile(String fileName){
		String messageFromSave = "";
		try{
			ObjectOutputStream oOS = new ObjectOutputStream(new FileOutputStream(fileName));
			for(int i = 0; i < myCount ; i++){
				oOS.writeObject(myArray[i]);
			}//for each element
			oOS.flush();
			oOS.close();
		}//try
		catch(Exception e){
			messageFromSave = e.toString();
		}//catch
		return messageFromSave;
	}//saveToFile
	
	public String loadFromFile(String fileName){
		String toReturn = "";
		try{
			ObjectInputStream oIS = new ObjectInputStream(new FileInputStream(fileName));
			while(true){
				AddressInfo fromFile = (AddressInfo)(oIS.readObject());
				AddressInfo found = (AddressInfo)search(fromFile);
				if(found == null){
					if(insert(fromFile)){
						toReturn += fromFile + " successfully added to Book.\n";
					}else{
						toReturn += fromFile + " not successfully added to Book.\n";
					}//else file failed to add
				}else{
					toReturn += found + " already in Book.\n" + "record not added from file";
				}//else file already exists in Book
			}//while
		}//try
		catch(EOFException eOF){
		}//catch
		catch(Exception e){
			toReturn += e;
		}//catch
		return toReturn;
	}//loadFromFile
	
}//AddressInfoList
