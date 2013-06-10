package forDatabase;

public class TestName {

	public static void main(String[] args) {
		Name n1, n2, n3;
		n1 = new Name("Madeline", "Geopp");
		n2 = new Name("Amanda", "Clark");
		n3 = new Name("Danie'l", "Gallison");
		System.out.println("the first Name object is: " + n1);
		System.out.println("the second Name object is: " + n2);
		n1.setFirst("Renee");
		System.out.println("the first name of " + n1 + " was changed to: " + n1.getFirst());
		n1.setLast("Gallison");
		System.out.println("the last name of " + n1 + " was changed to: " + n1.getLast());
		System.out.println("The result of compareTo as " + n1 + " as the invoking object and " + n2 + " as the parameter object is: " + n1.compareTo(n2));
		System.out.println("The result of compareTo as " + n2 + " as the invoking object and " + n1 + " as the parameter object is: " +n2.compareTo(n1));
		System.out.println("The result of compareTo as " + n1 + " as the invoking object and " + n1 + " as the parameter object is: " +n1.compareTo(n1));
		System.out.println("The result of compareTo as " + n1 + " as the invoking object and " + n3 + " as the parameter object is: " +n1.compareTo(n3));
		System.out.println("The result of compareTo as " + n3 + " as the invoking object and " + n2 + " as the parameter object is: " +n3.compareTo(n1));
		System.out.println("The result of equating " + n1 + " and " + n2 + " is: " + n1.equals(n2));
		System.out.println("The result of equating " + n1 + " and " + n1 + " is: " + n1.equals(n1));
		System.out.println("The result of toString for " + n1 + " is: " + n1);
		if(n2.before(n1)){
			System.out.println(n1 + " comes before " + n2);
		}//if 
		if(n1.before(n2)){
			System.out.println(n1 + " comes before " + n2);
		}else{
			System.out.println(n1 + " does not come before " + n2);
		}//else
		if(n3.before(n1)){
			System.out.println(n3 + " comes before " + n1);
		}//if
		if(n3.before(n1)){
			System.out.println(n3 + " comes before " + n1);
		}else{
			System.out.println(n3 + " does not come before " + n1);
		}//else
	}//Main

}//TestName
