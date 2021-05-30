public class Customer {
	int custID;
	private String fname;
	private String lname;
	private String email;
	private String phone;
	private String address;
	private static int newID = 1;
	
	public Customer(){
	}
	
	public Customer(String fname, String lname, String email, String phone, String address){
		this.custID = newID++;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}
	
	public int getCustID(){
		return custID;
	}
	
	public String getFirstName(){
		return fname;
	}
	
	public String getLastName(){
		return lname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPhone(){
		return phone;
	}
	
	public String getAddress(){
		return address;
	}
	
	
	public String GUItoString(){
		return  "Customer ID: " + custID + 
				"<br />Customer First name: " + fname + 
				"<br />Customer Last name: " + lname + 
				"<br />Customer Phone: " + phone +
				"<br />Customer Email: " + email +
				"<br />Customer Address: " + address; 
				
	}
}
