// Subclass of Bike 



public class City_Bike extends Bike{
	private String _make = "City";
	private double _pricePerDay = 30.00;
	
	public City_Bike(){
	}
	
	public City_Bike(boolean _isRented, String _name){
		super(_isRented);
		this._name = _name;
	}
	
	public String getType(){
		return _make;
	}
	
	public double getPrice(){
		return _pricePerDay;
	}
	
	public String toString(){
		return super.toString() + "\nType: " + _make + "\nPrice per day: "+ _pricePerDay;
	}
}
