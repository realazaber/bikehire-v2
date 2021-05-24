import java.io.*;
import java.util.*;

@SuppressWarnings("serial")
public class RentRecord implements Serializable{
	private int _rentID;
	private int _custID;
	private int _bikeID;
	private int _rentDay;
	private int _rentMonth;
	private int _rentYear; 
	private double _duration;
	private static int _newID = 1;
	/* Assignment specifications unclear on this ArrayList. */
	private ArrayList<Integer> _bikesID;
	
	public RentRecord(){
		
	}
	
	public RentRecord(int _custID, int _bikeID, int _rentDay, int _rentMonth, int _rentYear, double _duration){
		_rentID = _newID++;
		this._custID = _custID;
		this._bikeID = _bikeID;
		this._rentDay = _rentDay;
		this._rentMonth = _rentMonth;
		this._rentYear = _rentYear;
		this._duration = _duration;
		/* Assignment specifications unclear on this ArrayList. */
		_bikesID = new ArrayList<Integer>();
	}

	public int getDateValue(){
		return _rentDay * 1 + _rentMonth * 30 + _rentYear * 365;
	}

	public int getDay(){
		return _rentDay;
	}

	public int getMonth(){
		return _rentMonth;
	}

	public int getYear(){
		return _rentYear;
	}
	
	public int getRentRecordID(){
		return _rentID;
	}
	
	public int getCustID(){
		return _custID;
	}
	public int getBikeID(){
		return _bikeID;
	}
	
	public void addBike(int _bikeID){
		_bikesID.add(_bikeID);
	}
	
	public int getDate(){
		return _rentDay;
	}

	public int getRentID(){
		return _rentID;
	}
	
	public double getDuration(){
		return _duration;
	}
	
	public String toString(){
		return "Rent ID: " + _rentID + 
			   "\nCustomer ID: " + _custID +
			   "\nBike ID: " + _bikeID + 
			   "\nDate: " + _rentDay + 
			   "\nDuration: " + _duration;
	}
}
