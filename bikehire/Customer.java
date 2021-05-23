

public class Customer {
	private int _custID;
	private String _fname;
	private String _lname;
	private String _address;
	private int _phone;
	private static int _newID = 1;
	
	public Customer(){
	}
	
	public Customer(String _fname, String _lname, String _address, int _phone){
		this._custID = _newID++;
		this._fname = _fname;
		this._lname = _lname;
		this._address = _address;
		this._phone = _phone;
	}
	
	public int getCustID(){
		return _custID;
	}
	
	public String getFirstName(){
		return _fname;
	}
	
	public String getLastName(){
		return _lname;
	}
	
	public String getAddress(){
		return _address;
	}
	
	public int getPhone(){
		return _phone;
	}
	
	public String toString(){
		return "\nCustomer ID: " + _custID + 
				"\nCustomer First name: " + _fname + 
				"\nCustomer Last name: " + _lname + 
				"\nCustomer Phone: " + _phone +
				"\nCustomer Address: " + _address; 
				
	}
}
