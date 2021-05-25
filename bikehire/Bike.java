//Bike class

public class Bike {
	protected int _bikeID;
	protected boolean _isRented;
	protected static int _newID = 1;
	protected boolean _isAvailable = true;
	protected String _name = "";
	
	public Bike(){

	}
	
	public Bike(boolean isRented){
		this._bikeID = _newID++;
		this._isRented = isRented;
	}

	public String getName(){
		return _name;
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
		return "<br />" +
			   "<br />ID: " + _bikeID + 
			   "<br />Rent status: " + _isRented + 
			   "<br />Bike name: " + _name +
			   "<br />";
	}
}
