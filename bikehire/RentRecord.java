import java.io.*;
import java.util.*;

@SuppressWarnings("serial")
public class RentRecord implements Serializable{
	private int rentID;
	private int custID;
	private int bikeID;
	private int rentDay;
	private int rentMonth;
	private int rentYear; 
	private double duration;
	private static int newID = 1;
	/* Assignment specifications unclear on this ArrayList. */
	private ArrayList<Integer> bikesID;
	
	public RentRecord(){
		
	}
	
	public RentRecord(int custID, int bikeID, int rentDay, int rentMonth, int rentYear, double duration){
		this.rentID = newID++;
		this.custID = custID;
		this.bikeID = bikeID;
		this.rentDay = rentDay;
		this.rentMonth = rentMonth;
		this.rentYear = rentYear;
		this.duration = duration;
		/* Assignment specifications unclear on this ArrayList. */
		bikesID = new ArrayList<Integer>();
	}

	public int getDateValue(){
		return rentDay * 1 + rentMonth * 30 + rentYear * 365;
	}

	public int getDay(){
		return rentDay;
	}

	public int getMonth(){
		return rentMonth;
	}

	public int getYear(){
		return rentYear;
	}
	
	public int getRentRecordID(){
		return rentID;
	}
	
	public int getCustID(){
		return custID;
	}
	public int getBikeID(){
		return bikeID;
	}
	
	public void addBike(int _bikeID){
		bikesID.add(_bikeID);
	}
	
	public int getDate(){
		return rentDay;
	}
	
	public String getDateString() {
		return rentDay + "/" + rentMonth + "/" + rentYear;
	}

	public int getRentID(){
		return rentID;
	}
	
	public double getDuration(){
		return duration;
	}

	public String GUItoString() {
		return "<br /><br/>Rent ID: " + rentID + 
			"<br />Customer ID: " + custID +
			"<br />Bike ID: " + bikeID + 
			"<br />Date: " + rentDay + "/" +  rentMonth + "/"  + rentYear +
			"<br />Duration: " + duration + " in days" +
			"<br />";
	}
}
