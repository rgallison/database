package forDatabase;

import java.io.*;

public class AddressInfo implements Serializable, Comparable<AddressInfo>{
	
	private Name myName;//reference to a name object
	private Phone myPhone;//reference to a phone object
	private Address myAddress;//reference to an address object
	
	public AddressInfo(String theFirst, String theLast, String thePhone, String theStreet, String theOptional, 
						String theCity, Object theState, String theZip){
		myName = new Name(theFirst, theLast);
		myPhone = new Phone(thePhone);
		myAddress = new Address(theStreet, theOptional, theCity, 
				(String) theState, theZip);
	}//8 parameter constructor
	
	public AddressInfo(String theFirst, String theLast, String theStreet, 
						String theOptional, String theCity, Object theState, String theZip){
		myName = new Name(theFirst, theLast);
		myPhone = new Phone();
		myAddress = new Address(theStreet, theOptional, theCity, 
								(String) theState, theZip);
	}//7 parameter constructor
	
	public AddressInfo(String theFirst, String theLast, String thePhone, String theStreet, 
						String theCity, String theState, String theZip){
		myName = new Name(theFirst, theLast);
		myPhone = new Phone(thePhone);
		myAddress = new Address(theStreet, theCity, theState, theZip);
	}//7 parameter constructor
	
	public AddressInfo(String theFirst, String theLast, String theStreet, 
						String theCity, String theState, String theZip){
		myName = new Name(theFirst, theLast);
		myPhone = new Phone();
		myAddress = new Address(theStreet, theCity, theState, theZip);
	}//6 parameter constructor
	
	public AddressInfo(String theFirst, String theLast, String thePhone){
		myName = new Name(theFirst, theLast);
		myPhone = new Phone(thePhone);
		myAddress = new Address();
	}//2 parameter constructor
	
	public AddressInfo(String theFirst, String theLast){
		myName = new Name(theFirst, theLast);
		myPhone = new Phone();
		myAddress = new Address();
	}//2 parameter constructor
	
	public void setName(Name theName){
		myName = theName;
	}//setName
	
	public void setPhone(Phone thePhone){
		myPhone = thePhone;
	}//setPhone
	
	public void setAddress(Address theAddress){
		myAddress = theAddress;
	}//setAddress
	
	public String getName(){
		return myName + "";
	}//getName
	
	public String getPhone(){
		return myPhone + "";
	}//getPhone
	
	public String getAddress(){
		return myAddress + "";
	}//getAddress
	
	public String getStreet(){
		return myAddress.getStreet();
	}//getStreet
	
	public String getCity(){
		return myAddress.getCity();
	}//getCity
	
	public String getState(){
		return myAddress.getState();
	}//getState
	
	public String getZip(){
		return myAddress.getZip();
	}//getZip
	
	public String getSpecific(String theSpecific){
		if(theSpecific.equals("Street")){
			return getStreet();
		}//if user is searching for street
		if(theSpecific.equals("City")){
			return getCity();
		}//if user is searching for city
		if(theSpecific.equals("State")){
			return getState();
		}//if user is searching for state
		if(theSpecific.equals("Zipcode")){
			return getZip();
		}//if user is searching for zip
		return "That is not a valid entry.";
	}//getSpecific
	
	public int compareTo(AddressInfo theAI){
		return myName.compareTo(theAI.myName);
	}//compareTo
	
	public boolean equals(Object theOther){
		AddressInfo theAI = (AddressInfo) theOther;
		return myName.equals(theAI.myName);
	}//equals
	
	public boolean beforeAlpha(AddressInfo theAI){
		return myName.compareTo(theAI.myName) < 0;
	}//beforeAlpha
	
	public boolean beforeAddress(AddressInfo theAI){
		return myAddress.before(theAI.myAddress)||myAddress.equals(theAI.myAddress)
					&& myName.before(theAI.myName);
	}//beforeAddress
	
	public String toString(){
		Phone emptyPhone = new Phone();
		if(myPhone.equals(emptyPhone)){
			return myName + "" + myAddress;
		}//if no number was provided
		if(myAddress.getStreet().equals("")){
			return myName + "\n" + myPhone;
		}//if no address was provided
		return myName + "\n" + myPhone + "" + myAddress;
	}//toString
}//AddressInfo
