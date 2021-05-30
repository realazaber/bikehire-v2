// Subclass of Bike 

public class BMX extends Bike{
	private String make = "BMX";
	private double pricePerDay = 40.00;

	
	public BMX(boolean isRented, String name, String make, double pricePerDay){
		super(name, make, isRented, pricePerDay);
		this.bikeName = name;
	}
	
	public String getType(){
		return make;
	}
	
	public double getPrice(){
		return pricePerDay;
	}
	
	public String toString(){
		return  "Category: " + make;
	}
}
