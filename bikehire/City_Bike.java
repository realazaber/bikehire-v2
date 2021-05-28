

// Subclass of Bike 

public class City_Bike extends Bike{
	private String _make = "City";
	private double _pricePerDay = 30.00;
	
	public City_Bike(){
	}
	
	public City_Bike(boolean _isRented, String _name, String _make){
		super(_name, _make, _isRented);
		this._bikeName = _name;
	}
	
	public String getType(){
		return _make;
	}
	
	public double getPrice(){
		return _pricePerDay;
	}
	
	public String toString(){
		return "Type: " + _make + "<br/>Price per day: "+ _pricePerDay;
	}
}
