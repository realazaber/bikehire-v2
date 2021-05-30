// Subclass of Bike

public class EBike extends Bike{
	private String make = "EBike";
	private double pricePerDay = 25.00;
	private String motorStrength = ""; //Can be either “Full power” and “Power assist”.
	private int maxDistance = 1;
	


	public EBike(boolean isRented, String name, String make, double pricePerDay, String motorStrength, int maxDistance){
		super(name, make, isRented, pricePerDay);
		this.bikeName = name;
		this.motorStrength = motorStrength;
		this.maxDistance = maxDistance;

		if (motorStrength == "Full power") {
			pricePerDay *= 2;
		}
	}
	
	public String getType(){
		return make;
	}
	
	public double getPrice(){		
		return pricePerDay;
	}

	public String getMotor(){
		return motorStrength;
	}

	public int getMaxDistance(){
		return maxDistance;
	}
	
	public String toString(){
		return "Power mode: " + getMotor() + "<br/> Max distance: " + getMaxDistance();
	}
}
