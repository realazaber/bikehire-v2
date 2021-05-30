

// Subclass of Bike 

public class City_Bike extends Bike{
	private String make = "City";
	private double pricePerDay = 30.00;
	
	public City_Bike(){
	}
	
	public City_Bike(boolean isRented, String name, String make, double pricePerDay){
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
		return "Category: " + make;
	}
}
