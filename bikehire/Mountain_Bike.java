// Subclass of Bike

public class Mountain_Bike extends Bike{
	private String _make = "Mountain";
	private double _pricePerDay = 25.00;
	
	public Mountain_Bike(){
	}
	
	public Mountain_Bike(boolean _isRented, String _name){
		super(_isRented);
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
