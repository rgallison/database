package forDatabase;

import java.io.*;

//Renee Gallison
//CS 64

public class Name implements Serializable, Comparable<Name>{
	private String myFirst;//reference to the first name
	private String myLast;//reference to the last name
	
	public Name(String theFirst, String theLast){
		myFirst = theFirst;
		myLast = theLast;
	}//2-parameter constructor
	
	public void setFirst(String theFirst){
		myFirst = theFirst;
	}//setFirst
	
	public void setLast(String theLast){
		myLast = theLast;
	}//setLast
	
	public String getFirst(){
		return myFirst;
	}//getFirst
	
	public String getLast(){
		return myLast;
	}//getLast
	
	public int compareTo(Name theName){
		int compareLastName = myLast.compareTo(theName.myLast);
		if(compareLastName!=0){
			return compareLastName;
		}//if
		return myFirst.compareTo(theName.myFirst);
	}//compareTo
	
	public boolean equals(Object theOther){
		Name theName = (Name) theOther;
		return compareTo(theName) == 0;
	}//equals
	
	public String toString(){
		return myLast + ", " + myFirst;
	}//toString
	
	public boolean before(Name theName){
		return compareTo(theName) < 0;
	}//before
	
}//Name
