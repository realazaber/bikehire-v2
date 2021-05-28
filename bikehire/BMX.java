// Subclass of Bike 

public class BMX extends Bike{
	private String _make = "BMX";
	private double _pricePerDay = 40.00;

	
	public BMX(boolean _isRented, String _name){
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
		return  "Type: " + _make + "<br/>Price per day: "+ _pricePerDay;
	}
}
