package forDatabase;

public class TestAddressInfoList {
	
	public static void main(String[] args) {
			AddressInfoList myList = new AddressInfoList();
			if(myList.insert(new AddressInfo("Susan", "Mills","5000 MacArthur","Oakland","CA","94613"))){
				System.out.println("Susan added.");
			}else{
				System.out.println("Susan not added");
			}//else
			
			if(myList.isFull()){
				System.out.println("Array is full");
			}else{
				System.out.println("Array is not full");
			}//else
			
			if(myList.insert(new AddressInfo("Susan", "Mills","5000 MacArthur","Oakland","CA","94613"))){
				System.out.println("Susan added.");
			}else{
				System.out.println("Susan not added");
			}//else
			
			if(myList.insert(new AddressInfo("Barbara", "Li Santi","7930 Patterson Ave.","Oakland","CA","94619"))){
				System.out.println("Barbara added.");
			}else{
				System.out.println("Barbara not added");
			}//else
			
			if(myList.insert(new AddressInfo("Cyrus", "Mills","5000 MacArthur","Oakland","CA","94613"))){
				System.out.println("Cyrus added.");
			}else{
				System.out.println("Cyrus not added");
			}//else
			
			if(myList.isFull()){
				System.out.println("Array is full");
			}else{
				System.out.println("Array is not full");
			}//else
			
			System.out.println("Here is the list:\n" + myList);
			
			myList.alphaSort();
			System.out.println("Here is the list sorted by name:\n" + myList);
			
			myList.addressSort();
			System.out.println("Here is the list sorted bt address:\n" + myList);
			
			if(myList.search(new AddressInfo("Barbara", "Li Santi")) == null){
				System.out.println("not in list");
			}else{
				System.out.println("in list");
			}//else
			
			if(myList.search(new AddressInfo("Lauren", "Li Santi")) == null){
				System.out.println("not in list");
			}else{
				System.out.println("in list");
			}//else
			
			if(myList.delete(new AddressInfo("Barbara", "Li Santi"))){
				System.out.println("Deletion Successful");
			}else{
				System.out.println("Deletion Failed");
			}//else
			
			System.out.println("Here is the list:\n" + myList);
			
			if(myList.search(new AddressInfo("Barbara", "Li Santi")) == null){
				System.out.println("not in list");
			}else{
				System.out.println("in list");
			}//else
			
			if(myList.delete(new AddressInfo("Barbara", "Li Santi"))){
				System.out.println("Deletion Successful");
			}else{
				System.out.println("Deletion Failed");
			}//else
	}//main
}//TestAddressInfoList
