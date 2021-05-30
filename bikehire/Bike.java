//Bike class

public class Bike {
	protected int bikeID;
	protected String bikeName;
	protected String bikeType;
	protected double pricePerDay;
	protected boolean isRented;
	protected static int newID = 1;
	protected boolean isAvailable = true;
	
	public Bike(){

	}
	
	public Bike(String bikeName, String bikeType, boolean isRented, double pricePerDay){
		this.bikeID = newID++;
		this.bikeName = bikeName;
		this.bikeType = bikeType;
		this.isRented = isRented;
		this.pricePerDay = pricePerDay;
	}

	public String getName(){
		return bikeName;
	}

	
	public int getBikeID(){
		return bikeID;
	}
	
	public boolean getIsRented(){
		return isRented;
	}
	
	public void setIsRented(boolean isRented){
		this.isRented = isRented;
	}
	
	public String GUItoString(){
		return 
			   "<br /><br />Bike ID: " + bikeID + 
			   "<br />Bike Name: " + bikeName + 
			   "<br />Bike Type: " + bikeType +
			   "<br />Bike Rent Status: " + isRented + 
			   "<br />Price per day: " + pricePerDay + "<br />";
	}
}
