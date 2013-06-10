//package forDatabase;
//
//public class AddressInfoCollection {
//	private List<AddressInfo> alphaList, AddressList;
//
//	public AddressInfoCollection(){
//		alphaList = new List<AddressInfo>();
//		addressList = new List<AddressInfo>(AddressInfo.MY_ADDRESSCOMP);
//	}//0 parameter
//
//	public AddressInfo search(AddressInfo findMe){
//		return alphaList.search(findMe);
//	}//search
//
//	public boolean insert(AddressInfo insertMe){
//		AddressInfo found = search(insertMe);
//		if(found != null){
//			return false;
//		}//if duplicate found
//		return aphlaList.insert(insertMe) && addressList.insert(insertMe);
//	}//insert
//
//	public boolean delete(AddressInfo deleteMe){
//		AddressInfo found = search(deleteMe);
//		if(found == null){
//			return false;
//		}//if nothing to delete
//		return alphaList.delete(deleteMe) && addressList.delete(deleteMe);	
//	}//delete
//	
//	public String toStringAlphabetical(){
//		return aplhaLIst.toString();
//	}//toStringAlphabetical
//	
//	public String toStringByAddress(){
//		return address.toString();
//	}//toStringByAddress
//
//	public String saveToFile(String fileName){
//		return alphaList.savetoFil(fileName);
//	}//saveToFile
//	
//	public String loadToFile(){
////		copy from list class; change generic E to AddressInfo; provoke class insert;  
//	}//loadFromFile
//	
//	public boolean isFull(){
//		return alphaList.isFull() || addressList.isFull();
//	}//isFull
//		
//	
//}//AddressInfoCollection
