package forDatabase;

import java.io.*;

public class Phone implements Serializable, Comparable <Phone>{
	private String myPhone;//Declares a reference to a String containing the number
	
	public Phone(String thePhone){
		myPhone = thePhone;
	}//1 parameter constructor
	
	public Phone(){
		myPhone = "";
	}//0 parameter constructor
	
	public String getPhone(){
		return myPhone;
	}//getPhone
	
	public void setPhone(String thePhone){
		myPhone = thePhone;
	}//setPhone
	
	public String fixFormat(String thePhone){
		String newPhone = "";
		if(thePhone.length() == 9)
			 newPhone = "(";
			for(int i = 0; i < thePhone.length(); i++){
				newPhone += thePhone.charAt(i);
				if(i == 3){
					newPhone += ")";
				}//if time to add right parenthesis
				if(i == 6){
					newPhone += "-";
				}//if time to add dash
			}//for each index, construct new number
		return newPhone;
	}//fixFormat
	
	public int compareTo(Phone thePhone){
		int comparePhone = myPhone.compareTo(thePhone.myPhone);
		return comparePhone;
	}//compareTo
	
	public boolean equals(Object theOther){
		Phone thePhone = (Phone) theOther;
		return compareTo(thePhone) == 0;
	}//equals
	
	public String toString(){
		return myPhone;
	}//toString
	
	public boolean before(Phone thePhone){
		return compareTo(thePhone) < 0;
	}//before
	
}//Phone
