public class Road_Bike extends Bike{
	private String _make = "Road";
	private double _pricePerDay = 69.00;
	
	public Road_Bike(){

	}
	
	public Road_Bike(boolean _isRented, String _name){
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
