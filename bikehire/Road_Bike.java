public class Road_Bike extends Bike{
	private String make = "Road";
	private double pricePerDay = 69.00;
	
	public Road_Bike(){

	}
	
	public Road_Bike(boolean isRented, String name, String make, double pricePerDay){
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
