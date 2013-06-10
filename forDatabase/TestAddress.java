package forDatabase;

public class TestAddress {

	public static void main(String[] args) {
		Address a1, a2, a3;
		a1 = new Address ("5000 MacArthur Blvd.", "Prospect Hills Apartment 4c", "Oakland", "CA", "94613");
		a2 = new Address ("83-5562 Rabbit Hill rd.", "Captain Cook", "HI", "96704");
		a3 = new Address();
		System.out.println("The first Address object is: " + a1);
		System.out.println("The second Address object is: " + a2);
		System.out.println("The third Address object is: " + a3);
		if(a3.before(a2)){
			System.out.println(a3 + " comes before " + a2);
		}//if
		a3.setState("HI");
		System.out.println("The state of address " + a3 + " was changed to: " + a3.getState());
		if(a3.before(a2)){
			System.out.println(a3 + " comes before " + a2);
		}//if
		a3.setCity("Captain Cook");
		System.out.println("The city of address " + a3 + " was changed to: " + a3.getCity());
		if(a3.before(a2)){
			System.out.println(a3 + " comes before " + a2);
		}//if
		a3.setZip("96704");
		System.out.println("The zip was of address " + a3 + " changed to: " + a3.getZip());
		if(a3.before(a2)){
			System.out.println(a3 + " comes before " + a2);
		}//if
		a3.setStreet("83-5562 Rabbit Hill Rd.");
		System.out.println("The street of address " + a3 + " was changed to: " + a3.getStreet());
		if(a3.before(a2)){
			System.out.println(a3 + " comes before " + a2);
		}//if
		a3.setOptional("Apartment 4");
		System.out.println("The optional line of address " + a3 + " was changed to: " + a3.getOptional());
		if(a3.before(a2)){
			System.out.println(a3 + " comes before " + a2);
		}//if
		System.out.println("The result of equating " + a1 + " and " + a2 + " is: " + a1.equals(a2));
		System.out.println("The result of equating " + a1 + " and " + a1 + " is: " + a1.equals(a1));
		if(a1.before(a2)){
			System.out.println(a1 + " comes before " + a2);
		}//if
		if(a2.before(a1)){
			System.out.println(a2 + " comes before " + a1);
		}else{
			System.out.println(a2 + " does not come before " + a1);
		}//else
		System.out.println("The result of compareTo as " + a1 + " as the invoking object and " + a2 + " as the parameter object is: " + a1.compareTo(a2));
		System.out.println("The result of compareTo as " + a1 + " as the invoking object and " + a2 + " as the parameter object is: " +a2.compareTo(a1));
		System.out.println("The result of compareTo as " + a1 + " as the invoking object and " + a2 + " as the parameter object is: " +a1.compareTo(a1));
		System.out.println("The result of toString for " + a1 + " is: " + a1);
		System.out.println("The result of toString for " + a2 + " is: " + a2);
	}//main

}//TestAddress
