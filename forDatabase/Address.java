package forDatabase;

import java.io.*;

public class Address implements Serializable, Comparable<Address>{
	public static final String[] 
	                           STATE_ABBREVIATIONS  = {"--","AK","AL","AR","AZ","CA","CO","CT","DE","FL",
		"GA","HI","IA","ID","IL","IN","KS","KY","LA","MA",
		"MD","ME","MI","MN","MO","MS","MT","NC","ND","NE",
		"NH","NJ","NM","NV","NY","OH","OK","OR","PA","RI",
		"SC","SD","TN","TX","UT","VT","VA","WA","WI","WV",
	"WY"};
	private String myStreet;//reference to the street address
	private String myOptional;//reference to suite or apartment number
	private String myCity;//reference to the city
	private String myState;//reference to the state
	private int myZip;//reference to the zipcode

	public Address(String theStreet, String theOptional, String theCity, 
			String theState, String theZip){
		myStreet = theStreet;
		myOptional = theOptional;
		myCity = theCity;
		myState = theState;
		myZip = getZipcode(theZip);
	}//5 parameter constructor

	public Address(String theStreet, String theCity, String theState, 
			String theZip){
		myStreet = theStreet;
		myOptional = "";
		myCity = theCity;
		myState = theState;
		myZip = getZipcode(theZip);
	}//4 parameter constructor

	public Address(){
		myStreet = "";
		myOptional = "";
		myCity = "";
		myState = "";
		myZip = Integer.parseInt("");
	}//0 parameter constructor

	public static int getZipcode(String theZip){
		try{
			int theZipcode = Integer.parseInt(theZip);
			if(theZipcode > 9999 && theZipcode < 100000 || theZipcode > 9999999 && theZipcode <= 999999999 ){
				return theZipcode;
			}else{
				AddressBook.displayTA.append("\nYou must enter a valid zip code.\n");

			}//else zipcode is not valid
			return -99999;
		}//try
		catch (NumberFormatException nFE){
			AddressBook.displayTA.append("\nYou must enter a valid zip code.\n");
			return -99999;
		}//catch
	}//getZipcode

	public void setStreet(String theStreet){
		myStreet = theStreet;
	}//getStreet

	public void setOptional(String theOptional){
		myOptional = theOptional;
	}//getOptional

	public void setCity(String theCity){
		myCity = theCity;
	}//getCity

	public void setState(String theState){
		myState = theState;
	}//getState

	public void setZip(String theZip){
		myZip = getZipcode(theZip);
	}//getZip

	public String getStreet(){
		return myStreet;
	}//getStreet

	public String getOptional(){
		return myOptional;
	}//getStreet

	public String getCity(){
		return myCity;
	}//getStreet

	public String getState(){
		return myState;
	}//getStreet

	public String getZip(){
		return myZip + "";
	}//getStreet

	public boolean equals(Object theOther){
		Address theAddress = (Address) theOther;
		return myStreet.equals(theAddress.myStreet)&&
		myOptional.equals(theAddress.myOptional)&&
		myCity.equals(theAddress.myCity)&&
		myState.equals(theAddress.myState)&&
		(myZip + "").equals(theAddress.myZip + "");
	}//equals

	public boolean before(Address theAddress){
		return compareTo(theAddress) < 0;
	}//before

	public int compareTo(Address theAddress){
		int compareValue = myState.compareTo(theAddress.myState);
		if(compareValue!=0){
			return compareValue;
		}//if states were different
		compareValue = myCity.compareTo(theAddress.myCity);
		if(compareValue!=0){
			return compareValue;
		}//if cities were different
		compareValue = myStreet.compareTo(theAddress.myStreet);
		if(compareValue!=0){
			return compareValue;
		}//if streets were different
		compareValue = (myZip + "").compareTo(theAddress.myZip + "");
		if(compareValue!=0){
			return compareValue;
		}//if zipcodes were different
		return myOptional.compareTo(theAddress.myOptional);
	}//compareTo

	public String toString(){
		if(!myOptional.equals("")){
			return "\n" + myStreet + "\n" + myOptional + "\n" + myCity + ", " 
			+ myState + " " + myZip;
		}//if there is not optional line
		return "\n" + myStreet + "\n" + myCity + ", " + myState + " " + myZip;
	}//toString 

}//Address
