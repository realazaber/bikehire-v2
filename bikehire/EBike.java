// Subclass of Bike

public class EBike extends Bike{
	private String _make = "EBike";
	private double _pricePerDay = 25.00;
	private String _motorStrength = ""; //Can be either “Full power” and “Power assist”.
	private int _maxDistance = 1;
	


	public EBike(boolean _isRented, String _name, String _make, String _motorStrength, int _maxDistance){
		super(_name, _make, _isRented);
		this._bikeName = _name;
		this._motorStrength = _motorStrength;
		this._maxDistance = _maxDistance;

		if (_motorStrength == "Full power") {
			_pricePerDay *= 2;
		}
	}
	
	public String getType(){
		return _make;
	}
	
	public double getPrice(){		
		return _pricePerDay;
	}

	public String getMotor(){
		return _motorStrength;
	}

	public int getMaxDistance(){
		return _maxDistance;
	}
	
	public String toString(){
		return "Type: " + _make + "<br/>Price per day: "+ _pricePerDay + "<br/> Power mode: " + getMotor();
	}
}
