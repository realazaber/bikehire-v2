// Subclass of Bike 

public class BMX extends Bike{
	private String _make = "BMX";
	private double _pricePerDay = 40.00;

	
	public BMX(boolean _isRented, String _name, String _make, double _pricePerDay){
		super(_name, _make, _isRented, _pricePerDay);
		this._bikeName = _name;
	}
	
	public String getType(){
		return _make;
	}
	
	public double getPrice(){
		return _pricePerDay;
	}
	
	public String toString(){
		return  "Type: " + _make + "<br/>Price per day: "+ _pricePerDay;
	}
}
