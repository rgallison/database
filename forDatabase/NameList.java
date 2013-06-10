package forDatabase;

public class NameList {
	private static Name myArray[];//reference to the array of name objects
	private static int myCount;//reference to number of name objects

	//Exercise 11.5
	public static void selectionSort(){
		int smallest = 0;
		for(int i = 1; i < myCount - 1; i++){
			if(myArray[i].before(myArray[smallest])){
				swap(i, smallest);
			}//if
		}//for
	}//selectionSort

	//Exercise 11.7
	public static Name searchSorted(Name theName){
		int i = 0;
		while(i < myCount && (myArray[i].before(theName))){
			i++;
		}//while
		return (myArray[i].equals(theName)?myArray[1]:null);
	}//searchSorted

	private static void swap(int firstPos, int otherPos){
		Name temp = myArray[firstPos];
		myArray[firstPos] = myArray[otherPos];
		myArray[otherPos] = temp;
	}//swap

	private static void displayMyArray(String msg) {
		System.out.println(msg);
		for (int i = 0; i < myArray.length; i++) {
			System.out.println(myArray[i] + "\n");
		}//for
		System.out.println();//makes a blank line at the end
	}//displayMyArray

	

	private int findSmallestPos(int beginSearch, int endSearch){
		int indexOfSmallest = beginSearch;
		for(int i = beginSearch + 1; i <= endSearch;i++){
			if(myArray[i].before(myArray[indexOfSmallest])){
				indexOfSmallest = i;
			}//if
		}//for
		return indexOfSmallest;
	}//findSmallestPos


	public static void main (String args[]) {
		Name n1, n2, n3, n4, n5;//reference to name objects
		n1 = new Name("Renee", "Gallison");
		n2 = new Name("Marshall", "Adams");
		n3 = new Name("Paola", "Barcenas");
		n4 = new Name("Alyssa", "Ilves");
		n5 = new Name("Dani", "Gallison");
		selectionSort();
		displayMyArray("\nThe Names are \n");



	}//main

}//NameList