package forDatabase;

public class TestAddressInfo {


	public static void main(String[] args) {
		AddressInfo aI1, aI2, aI3, aI4;
		aI1 = new AddressInfo("Renee", "Gallison","5000 MacArthur Blvd.","Prospect Hills Aparmetn 4c","Oakland","CA","94613");
		aI2 = new AddressInfo("Amanda", "Clark"," 5000 MacArthur Blvd.", "Oakland", "CA", "94613");
		aI3 = new AddressInfo("Madeline", "Geopp");
		aI4 = new AddressInfo("Daniel", "Gallison");
		System.out.println(aI1 + " is: " + aI1);
		System.out.println(aI2 + " is: " + aI2);
		System.out.println(aI3 + " is: " + aI3);
		System.out.println(aI4 + " is: " + aI4);
		aI4.setName(new Name("Danie'l","Gallison"));
		System.out.println("The name of " + aI4 + " was changed to: " + aI4.getName());
		aI4.setAddress(new Address("2435 Coyne St.","Honolulu","HI","96826"));
		System.out.println("The address of " + aI4 + " was changed to: " + aI4);
		System.out.println("The result of compareTo as " + aI1 + " as the invoking object and " + aI2 + " as the parameter object is: " + aI1.compareTo(aI2));
		System.out.println("The result of compareTo as " + aI2 + " as the invoking object and " + aI1 + " as the parameter object is: " +aI2.compareTo(aI1));
		System.out.println("The result of compareTo as " + aI1 + " as the invoking object and " + aI1 + " as the parameter object is: " +aI1.compareTo(aI1));
		System.out.println("The result of equating " + aI1 + " and " + aI2 + " is: " + aI1.equals(aI2));
		System.out.println("The result of equating " + aI1 + " and " + aI2 + " is: " + aI1.equals(aI1));
		if(aI2.beforeAlpha(aI1)){
			System.out.println(aI2 + " comes before " + aI1);
		}//if
		if(aI4.beforeAlpha(aI1)){
			System.out.println(aI4 + " comes before " + aI1);
		}//if
		if(aI1.beforeAlpha(aI2)){
			System.out.println(aI1 + " comes before " + aI2);
		}else{ 
			System.out.println(aI2 + " does not come before " + aI1);
		}//else
		if(aI3.beforeAddress(aI1)){
			System.out.println(aI3 + " comes before " + aI1);
		}//if
		if(aI3.beforeAddress(aI4)){
			System.out.println(aI3 + " comes before " + aI4);
		}//if
		aI3.setAddress(new Address("","","HI",""));
		if(aI3.beforeAddress(aI4)){
			System.out.println(aI3 + " comes before " + aI4);
		}//if
		aI3.setAddress(new Address("","Honolulu", "HI",""));
		if(aI3.beforeAddress(aI4)){
			System.out.println(aI3 + " comes before " + aI4);
		}//if
		aI3.setAddress(new Address("","Honolulu", "HI","96826"));
		if(aI3.beforeAddress(aI4)){
			System.out.println(aI3 + " comes before " + aI4);
		}//if
		aI3.setAddress(new Address("2435 Coyne St.","Honolulu", "HI","96826"));
		if(aI3.beforeAddress(aI4)){
			System.out.println(aI3 + " comes before " + aI4);
		}else{
			System.out.println(aI3 + " does not come before " + aI4);
		}//else
	}//main

}//TestAddressInfo
