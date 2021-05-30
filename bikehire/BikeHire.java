//For input and other key features
import java.io.*;
import java.util.*;
/************************************************/

//For the GUI
import java.awt.Font;
import javax.swing.*;
/************************************************/
import javax.swing.plaf.TreeUI;

//libraries to get the date and change the format
import java.text.DateFormat;
import java.text.SimpleDateFormat;
/************************************************/

//For writing to the files
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;
/**********************************/

public class BikeHire {

	public ArrayList<Bike> bikeRecords;
	public ArrayList<Customer> customerRecords;
	public ArrayList<RentRecord> rentRecords;

	/****************************************************************************************/
	//Gets the date and prints it to screen
	Date currentDate = new Date();

	//Changes the format of the date, converts it to string and prints it to screen
	SimpleDateFormat year = new SimpleDateFormat("yyyy");
	SimpleDateFormat month = new SimpleDateFormat("MM");
	SimpleDateFormat day = new SimpleDateFormat("dd");
	
	String strDay = day.format(currentDate);
	String strMonth = month.format(currentDate);
	String strYear = year.format(currentDate);
	
	
	//Converts to int and prints to screen
	int intDay = Integer.parseInt(strDay);
	int intMonth = Integer.parseInt(strMonth);
	int intYear = Integer.parseInt(strYear);

	
	// System.out.println("Int " + _intDay + _intMonth + _intYear);
	//Stores the total number of days of the current date
	int currentDateValue = intDay + intMonth * 30 + intYear * 365;
	/****************************************************************************************/

	Scanner input = new Scanner(System.in);

	public BikeHire(){

		//Makes lists of Bikes, Customers and Rentals.
		bikeRecords = new ArrayList<Bike>();
		customerRecords = new ArrayList<Customer>();
		rentRecords = new ArrayList<RentRecord>();
		
		//create twelve bikes
		BMX trickMaster = new BMX(false, "Trick Master", "BMX", 40.00);
		Road_Bike offRoad_Bike = new Road_Bike(false, "Off Road", "Road", 25.00);
		Mountain_Bike mountainMaster = new Mountain_Bike(false, "Mountain Master" , "Mountain", 25.00);
		City_Bike citySlicker = new City_Bike(false, "City Slicker", "City", 30.00);
		BMX coolKid = new BMX(false, "Cool Kid", "BMX", 40.00);
		Road_Bike epicKid = new Road_Bike(false, "Epic Kid", "Road", 25.00);
		Mountain_Bike dirtyKid = new Mountain_Bike(false, "Dirty Kid", "Mountain", 25.00);
		City_Bike theSoy = new City_Bike(false, "The Soy", "City", 30.00);
		EBike ecoFriend = new EBike(false, "Eco Friend", "Ebike", 25.00, "Full power", 100);
		EBike electricPowa = new EBike(false, "Electric Powa", "Ebike", 25.00,  "Power assist", 150);
		EBike theTesla = new EBike(false, "Tesla", "Ebike", 25.00, "Full power",  200);
		EBike scootScoot = new EBike(false, "Scooter", "Ebike", 25.00, "Power assist", 400);
		
		Customer _Customer_1 = new Customer("Ben", "Ten", "bten@gmail.com", "69420", "My basement");
		Customer _Customer_2 = new Customer("Norman", "Reedus", "reedus@norman.com", "42069", "My attic");
		Customer _Customer_3 = new Customer("Fred", "Summerton", "smithjohn@yahoo.com", "2142069", "My house");
		Customer _Customer_4 = new Customer("George", "Baba", "curiousgeorge@gmail.com", "24394", "My door");
		
		RentRecord _rentRecord_1 = new RentRecord(1, 1, 4, 4, 2021, 23);
		RentRecord _rentRecord_2 = new RentRecord(2, 4, 3, 3, 2020, 21);
		RentRecord _rentRecord_3 = new RentRecord(3, 4, 5, 5, 2021, 12);

		//add bikes to bikes ArrayList		
		bikeRecords.add(trickMaster);
		bikeRecords.add(offRoad_Bike);
		bikeRecords.add(mountainMaster);
		bikeRecords.add(citySlicker);
		bikeRecords.add(coolKid);
		bikeRecords.add(epicKid);
		bikeRecords.add(dirtyKid);
		bikeRecords.add(theSoy);
		bikeRecords.add(ecoFriend);
		bikeRecords.add(electricPowa);
		bikeRecords.add(theTesla);
		bikeRecords.add(scootScoot);
	
		customerRecords.add(_Customer_1);
		customerRecords.add(_Customer_2);
		customerRecords.add(_Customer_3);
		customerRecords.add(_Customer_4);
	
		rentRecords.add(_rentRecord_1);
		rentRecords.add(_rentRecord_2);
		rentRecords.add(_rentRecord_3);
	}
	
	public void addBike(String _type, String _name, double _pricePerDay, boolean _rented, String _fullPower, int _maxDistance) {
				
		switch (_type) {
		case "BMX":
			BMX _bmx = new BMX(_rented, _name, _type, 40.00);
			bikeRecords.add(_bmx);
			break;
		case "Road":
		case "Road Bike:":
			Road_Bike _road_bike = new Road_Bike(_rented, _name, _type, 30.00);
			bikeRecords.add(_road_bike);
			break;
		case "Mountain":
		case "Mountain Bike":
			Mountain_Bike _mtn_bike = new Mountain_Bike(_rented, _name, _type, 25.00);
			bikeRecords.add(_mtn_bike);
			break;
		case "City":
		case "City Bike":
			City_Bike _city_bike = new City_Bike(_rented, _name, _type, 30.00);
			bikeRecords.add(_city_bike);
			break;
		case "Ebike":
			EBike _ebike = new EBike(_rented, _name, _type, 25.00, _fullPower, _maxDistance);
			bikeRecords.add(_ebike);
			break;
		default:
			Bike _bike = new Bike(_name, _type, _rented, _pricePerDay);
			bikeRecords.add(_bike);
			break;
		}
	}
	
	public String displayAvailableBikes(){ //Shows all AVAILABLE BIKES
		int _bikeNum = 0; //Starts the counter of bikes
		String _output = "<html>";
		try{
			for(Bike _bike: bikeRecords){
				if(_bike.getIsRented() == false){
					
					_output += _bike.GUItoString();
					_bikeNum++;

				}
			}
			if(_bikeNum < 1){
				throw new Exception("No bikes available.");
			}
		}
		catch(Exception e){
			System.err.println("Error: " + e.getMessage());
		}
		//_output += "</html>";

		return _output;
	}
	 
	public void addCustomer(String _firstName, String _lastName, String _email, String _phone, String _address){
		try{
			//create customer
			Customer _c = new Customer(_firstName, _lastName, _email, _phone, _address);
			//add to ArrayList
			customerRecords.add(_c);
			System.out.println("Customer added");
		}
		catch(Exception e){
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	public void addRent(int _customerID, int _bikeID, int _rentDay, int _rentMonth, int _rentYear, double _duration) {
		try {
			RentRecord _r = new RentRecord(_customerID, _bikeID, _rentDay, _rentMonth, _rentYear, _duration);
			rentRecords.add(_r);
			System.out.println("Rent added");
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
	

	 
	public int searchForCustomerTerminal(String _fname, String _lname){
		int _id = 0;
		for(Customer _customer: customerRecords){
			if(_fname.equalsIgnoreCase(_customer.getFirstName()) && _lname.equalsIgnoreCase(_customer.getLastName())){
				_id = _customer.getCustID();
			}
		}
		return _id;
	}
	
	public void clearRecords(int _chosenArray) {
		switch(_chosenArray) {
		case 1:
			customerRecords.clear();
			break;
		
		case 2:
			bikeRecords.clear();
			break;
		case 3:
			rentRecords.clear();
			break;
		default:
			System.out.println("");
		}
			
	}
	

	
	public String[] searchRecords(int _record, int _id) {
		String[] _array = new String[6];
		
		if (_record == 1) {
			for (Customer _customer: customerRecords) {
				if (_id == _customer._custID) {
					String _strID = String.valueOf(_id);
					_array[0] = _strID;
					_array[1] = _customer.getFirstName();
					_array[2] = _customer.getLastName();
					_array[3] = _customer.getPhone();
					_array[4] = _customer.getEmail();
					_array[5] = _customer.getAddress();			
					
				}
			}
		}
		
		if (_record == 2) {
			
		
			
			for (Bike _bike: bikeRecords) {
				if (_id == _bike._bikeID) {
					
					String _bikeId = Integer.toString(_bike.getBikeID());
					
					_array[0] = _bikeId;
					_array[1] = _bike.getName();
					
					if (_bike.getIsRented() == true) {
						_array[2] = "true";
					}
					else {
						_array[2] = "false";
					}
					_array[3] = _bike._bikeType;
					String _price = Double.toString(_bike._pricePerDay);
					_array[4] = _price;	
					
				}
			}
		}
		
		else if (_record == 3) {
			for (var _rent : rentRecords) {
				if (_id == _rent.getRentID()) {
					
				
				
				String _rentId = String.valueOf(_rent.getRentID());
				String _custId = String.valueOf(_rent.getCustID());
				String _bikeId = String.valueOf(_rent.getBikeID());
				String _duration = String.valueOf(_rent.getDuration());
				
				_array[0] = _rentId;
				_array[1] = _custId;
				_array[2] = _bikeId;
				_array[3] = _rent.getDateString();
				_array[4] = _duration;
				}
			}
		}
				
		return _array;
	}

	public String displayRecords(int _category){

		//_category 1 = Customers
		//_category 2 = Bikes
		//_category 3 = rentals
		String _output = "";
		int _rentCount = 0;
		String _lineBreaker = "";
		try{
			System.out.println("==========");

			_output += "<html>";
			
			if (_category == 1) {
				int _custCount = 0;
				try{
					for(Customer _customer: customerRecords){
						_custCount++;
						_output += "<br />";
						_output += _customer.GUItoString();
						_output += "<br />";
					}
					if(_custCount < 1){
						throw new Exception("No customers registered.");
					}
				}
				catch(Exception e){
					System.err.println("Error: " + e.getMessage());
				}
			}
			else if (_category == 2) {
				int _bikeNum = 0; //Starts the counter of bikes
				try{
					for(Bike _bike: bikeRecords){

						if(_bike.getIsRented() == false){
							
							_output += _bike.GUItoString();
							_output += _bike.toString();
							_bikeNum++;
		
						}
					}
					if(_bikeNum < 1){
						throw new Exception("No bikes available.");
					}
				}
				catch(Exception e){
					System.err.println("Error: " + e.getMessage());
				}
			}
			else if (_category == 3) {
				for(RentRecord _rent: rentRecords){
					if (currentDateValue - _rent.getDateValue() >= 30) {
						_output += _lineBreaker;
						_output += "<br/>OVERDUE";
						_output += _lineBreaker;
						_output += _rent.GUItoString();
						_output += _lineBreaker;
						_output += "==========";
						_output += _lineBreaker;
					}
					else {
						_output += "<br/>";
						_output += _lineBreaker;
						_output += _rent.GUItoString();
						_output += "==========";
						_output += _lineBreaker;
	
					}
					_rentCount++;
				}
				if(_rentCount < 1){
					throw new Exception("No rentals found.");
				}
			}

		}
		catch(Exception e){
			System.err.println("Error: " + e.getMessage());
		}

		return _output;
	}
	 
	public void clearFile(int _fileChosen) {
		//1 Customer
		//2 Bike
		//3 Rental

		String _path = "";

		if (_fileChosen == 1) {
			_path = "customers.dat";
		}
		else if (_fileChosen == 2) {
			_path = "bikes.dat";
		}
		else if (_fileChosen == 3) {
			_path = "rentals.dat";
		}

		try {
			File _file = new File(_path); //Selects file and prepares it for writing
			FileWriter _fileWriter = new FileWriter(_file, false);

			_fileWriter.write("<html>");
			_fileWriter.close();
		} 
		
		catch (Exception _error) {
			System.err.println("Error: " + _error.getMessage());
		}
	}

	public void saveFile(int _fileChosen) {
		//1 Customer
		//2 Bike
		//3 Rental

		String _path = "";

		if (_fileChosen == 1) {
			_path = "customers.dat";
		}
		else if (_fileChosen == 2) {
			_path = "bikes.dat";
		}
		else if (_fileChosen == 3) {
			_path = "rentals.dat";
		}

		try {
			File _file = new File(_path); //Selects file and prepares it for writing
			FileWriter _fileWriter = new FileWriter(_file, true);
			BufferedWriter _buffWriter = new BufferedWriter(_fileWriter);
			PrintWriter _printWriter = new PrintWriter(_buffWriter);
	
			String _text = ""; //All rentals are added to the string then added to the file
			_text += "<html>";

			if (_fileChosen == 1) {
				for (var _customer : customerRecords) {
					_text += "<br />Customer ID: ";
					_text += _customer.getCustID();
					_text += "<br />";
					_text += "Customer First Name: ";
					_text += _customer.getFirstName();
					_text += "<br />";
					_text += "Customer Last Name: ";
					_text += _customer.getLastName();
					_text += "<br />";
					_text += "Customer Phone: ";
					_text += _customer.getPhone();
					_text += "<br />";
					_text += "Customer Email: ";
					_text += _customer.getEmail();
					_text += "<br />";
;					_text += "Customer Address: ";
					_text += _customer.getAddress();
					_text += "<br /><br />";
				}
			}

			else if (_fileChosen == 2) {
				for (var _bike : bikeRecords) {
					_text += "<br />";
					_text += "Bike ID: ";
					_text += _bike.getBikeID();
					_text += "<br />";
					_text += "Bike Name: ";
					_text += _bike.getName();
					_text += "<br />";
					_text += "Bike Rent Status: ";
					_text += _bike.getIsRented();
					_text += "<br />";
					_text += _bike.toString();
					_text += "<br />";
				}
			}

			else if (_fileChosen == 3) {
				for (var _rent : rentRecords) {
					_text += "<br />";
					_text += "Rent ID: ";
					_text += _rent.getRentID();
					_text += "<br />";
					_text += "Customer ID: ";
					_text += _rent.getCustID();
					_text += "<br />";
					_text += "Bike ID: ";
					_text += _rent.getBikeID();
					_text += "<br />";
					_text += "Date: ";
					_text += _rent.getDay();
					_text += "/";
					_text += _rent.getMonth();
					_text += "/";
					_text += _rent.getYear();
					_text += "<br />";
					_text += "Duration (in days): ";
					_text += _rent.getDuration();
					_text += "<br />";
				}
			}

			_printWriter.print(_text); //appends to file
			_printWriter.close();	
		} 
		
		catch (Exception _error) {
			System.err.println("Error: " + _error.getMessage());
		}
	}

	public void returnRent(int _rentID){
		
		try {
			for (var _rent : rentRecords) {
				if (_rentID == _rent.getRentID()) {
					rentRecords.remove(_rent);
					System.out.println("Bike returned.");
				}
				else {
					System.out.println("Bike not currently rented.");
				}
			} 
		} catch (Exception e) {
			System.err.println("Error returning bike");
		}

	}
	
	public String readFile(int _fileChosen){
		//1 customers
		//2 bikes
		//3 rents
		String _path = "";
		if (_fileChosen == 1) {
			_path = "customers.dat";
		}
		else if(_fileChosen == 2) {
			_path = "bikes.dat";
		}
		else if (_fileChosen == 3) {
			_path = "rentals.dat";
		}

		FileInputStream _fileInput = null;
		ObjectInputStream _objectInput = null;
	  
		String _output = "";
		try{
			File _file = new File(_path); //Gets the file
			Scanner _scanner = new Scanner(_file);
	
			while (_scanner.hasNextLine()) { //Goes through each line and prints it out
				_output += _scanner.nextLine();
			}
			_scanner.close();
		}
		catch(Exception e){
			System.err.println("Error: " + e.getMessage());
		}
		finally{
			try{
				_fileInput.close();
				_objectInput.close();
			}
			catch(Exception fe){
				
			}
		}

		return _output;
	}	
}
