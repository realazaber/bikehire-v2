//Bike class

public class Bike {
	protected int _bikeID;
	protected String _bikeName;
	protected String _bikeType;
	protected boolean _isRented;
	protected static int _newID = 1;
	protected boolean _isAvailable = true;
	
	public Bike(){

	}
	
	public Bike(String _bikeName, String _bikeType, boolean isRented){
		this._bikeID = _newID++;
		this._bikeName = _bikeName;
		this._bikeType = _bikeType;
		this._isRented = isRented;
	}

	public String getName(){
		return _bikeName;
	}
	
	public int getBikeID(){
		return _bikeID;
	}
	
	public boolean getIsRented(){
		return _isRented;
	}
	
	public void setIsRented(boolean _isRented){
		this._isRented = _isRented;
	}
	
	public String GUItoString(){
		return 
			   "<br /><br />Bike ID: " + _bikeID + 
			   "<br />Bike Name: " + _bikeName +
			   "<br />Bike Rent Status: " + _isRented + 
			   "<br />";
	}
}
