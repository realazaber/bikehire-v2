public class Customer {
	int _custID;
	private String _fname;
	private String _lname;
	private String _email;
	private String _phone;
	private String _address;
	private static int _newID = 1;
	
	public Customer(){
	}
	
	public Customer(String _fname, String _lname, String _email, String _phone, String _address){
		this._custID = _newID++;
		this._fname = _fname;
		this._lname = _lname;
		this._email = _email;
		this._phone = _phone;
		this._address = _address;
		
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
	
	public String getEmail() {
		return _email;
	}
	
	public String getPhone(){
		return _phone;
	}
	
	public String getAddress(){
		return _address;
	}
	
	
	public String GUItoString(){
		return  "Customer ID: " + _custID + 
				"<br />Customer First name: " + _fname + 
				"<br />Customer Last name: " + _lname + 
				"<br />Customer Phone: " + _phone +
				"<br />Customer email: " + _email +
				"<br />Customer Address: " + _address; 
				
	}
}
