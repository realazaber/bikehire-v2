public class Customer {
	private int _custID;
	private String _fname;
	private String _lname;
	private String _address;
	private String _phone;
	private static int _newID = 1;
	
	public Customer(){
	}
	
	public Customer(String _fname, String _lname, String _address, String _phone){
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
	
	public String getPhone(){
		return _phone;
	}
	
	public String GUItoString(){
		return  "Customer ID: " + _custID + 
				"<br />Customer First name: " + _fname + 
				"<br />Customer Last name: " + _lname + 
				"<br />Customer Phone: " + _phone +
				"<br />Customer Address: " + _address; 
				
	}
}
