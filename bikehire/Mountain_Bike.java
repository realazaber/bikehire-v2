// Subclass of Bike

public class Mountain_Bike extends Bike{
	private String make = "Mountain";
	private double pricePerDay = 25.00;
	
	public Mountain_Bike(){
	}
	
	public Mountain_Bike(boolean isRented, String name, String make, double pricePerDay){
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
