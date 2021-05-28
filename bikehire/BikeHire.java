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
/************************************************/

public class BikeHire {

	public ArrayList<Bike> _bikes;
	public ArrayList<Customer> _customers;
	public ArrayList<RentRecord> _rents;

	/****************************************************************************************/
	//Gets the date and prints it to screen
	Date _currentDate = new Date();

	//Changes the format of the date, converts it to string and prints it to screen
	SimpleDateFormat _year = new SimpleDateFormat("yyyy");
	SimpleDateFormat _month = new SimpleDateFormat("MM");
	SimpleDateFormat _day = new SimpleDateFormat("dd");
	
	String _strDay = _day.format(_currentDate);
	String _strYear = _year.format(_currentDate);
	String _strMonth = _month.format(_currentDate);
	
	//Converts to int and prints to screen
	int _intYear = Integer.parseInt(_strYear);
	int _intMonth = Integer.parseInt(_strMonth);
	int _intDay = Integer.parseInt(_strDay);
	
	// System.out.println("Int " + _intDay + _intMonth + _intYear);
	//Stores the total number of days of the current date
	int _currentDateValue = _intDay + _intMonth * 30 + _intYear * 365;
	/****************************************************************************************/

	Scanner _input = new Scanner(System.in);

	public BikeHire(){

		//Makes lists of Bikes, Customers and Rentals.
		_bikes = new ArrayList<Bike>();
		_customers = new ArrayList<Customer>();
		_rents = new ArrayList<RentRecord>();
		
		//create twelve bikes
		BMX _trickMaster = new BMX(false, "Trick Master");
		Road_Bike _offRoad = new Road_Bike(false, "Off Road");
		Mountain_Bike _mountainMaster = new Mountain_Bike(false, "Mountain Master");
		City_Bike _citySlicker = new City_Bike(false, "City Slicker");
		BMX _coolKid = new BMX(false, "Cool Kid");
		Road_Bike _epicKid = new Road_Bike(false, "Epic Kid");
		Mountain_Bike _dirtyKid = new Mountain_Bike(false, "Dirty Kid");
		City_Bike _theSoy = new City_Bike(false, "The Soy");
		EBike _ecoFriend = new EBike(false, "Eco Friend", "Full power", 100);
		EBike _electricPowa = new EBike(false, "Electric Powa", "Power assist", 150);
		EBike _Tesla = new EBike(false, "Tesla", "Full power", 200);
		EBike _ScootScoot = new EBike(false, "Scooter", "Power assist", 400);
		
		Customer _Customer_1 = new Customer("Ben", "Ten", "bten@gmail.com", "69420", "My basement");
		Customer _Customer_2 = new Customer("Norman", "Reedus", "reedus@norman.com", "42069", "My attic");
		Customer _Customer_3 = new Customer("Fred", "Summerton", "smithjohn@yahoo.com", "2142069", "My house");
		Customer _Customer_4 = new Customer("George", "Baba", "curiousgeorge@gmail.com", "24394", "My door");
		
		RentRecord _rentRecord_1 = new RentRecord(1, 1, 4, 4, 2021, 23);
		RentRecord _rentRecord_2 = new RentRecord(2, 4, 3, 3, 2020, 21);

		//add bikes to bikes ArrayList
		_bikes.add(_trickMaster);
		_bikes.add(_offRoad);
		_bikes.add(_mountainMaster);
		_bikes.add(_citySlicker);
		_bikes.add(_coolKid);
		_bikes.add(_epicKid);
		_bikes.add(_dirtyKid);
		_bikes.add(_theSoy);
		_bikes.add(_ecoFriend);
		_bikes.add(_electricPowa);
		_bikes.add(_Tesla);
		_bikes.add(_ScootScoot);
	
		_customers.add(_Customer_1);
		_customers.add(_Customer_2);
		_customers.add(_Customer_3);
		_customers.add(_Customer_4);
	
		_rents.add(_rentRecord_1);
		_rents.add(_rentRecord_2);
	}
	
	public String displayAvailableBikes(){ //Shows all AVAILABLE BIKES
		int _bikeNum = 0; //Starts the counter of bikes
		String _output = "<html>";
		try{
			for(Bike _bike: _bikes){
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
			Customer c = new Customer(_firstName, _lastName, _email, _phone, _address);
			//add to ArrayList
			_customers.add(c);
			System.out.println("Customer added");
		}
		catch(Exception e){
			System.err.println("Error: " + e.getMessage());
		}
	}
	 
	public int searchForCustomerTerminal(String _fname, String _lname){
		int _id = 0;
		for(Customer _customer: _customers){
			if(_fname.equalsIgnoreCase(_customer.getFirstName()) && _lname.equalsIgnoreCase(_customer.getLastName())){
				_id = _customer.getCustID();
			}
		}
		return _id;
	}
	
	public void clearRecords(int _chosenArray) {
		switch(_chosenArray) {
		case 1:
			_customers.clear();
			break;
		
		case 2:
			_bikes.clear();
			break;
		case 3:
			_rents.clear();
			break;
		default:
			System.out.println("");
		}
			
	}
	

	
	public Vector searchForCustomer(int _id) {
		Vector _v = new Vector();
		for (Customer _customer: _customers) {
			if (_id == _customer._custID) {
				
				_v.add(_customer.getFirstName());
				_v.add(_customer.getLastName());
				_v.add(_customer.getPhone());
				_v.add(_customer.getEmail());
				_v.add(_customer.getAddress());
				
				
			}
		}
		return _v;
		
		
	}
	 
	public int searchForBikeByType(int _type){
		int _id = 0;
		try{
			switch(_type){
			case 1:
				for(Bike _bike: _bikes){
					if(_bike instanceof City_Bike && _bike.getIsRented() == false){
						_id = _bike.getBikeID();
						break;
					}
				}
				break;
			case 2:
				for(Bike _bike: _bikes){
					if(_bike instanceof Road_Bike && _bike.getIsRented() == false){
						_id = _bike.getBikeID();
						break;
					}
				}
				break;
			case 3:
				for(Bike _bike: _bikes){
					if(_bike instanceof Mountain_Bike && _bike.getIsRented() == false){
						_id = _bike.getBikeID();
						break;
					}
				}
				break;
			case 4:
				for(Bike _bike: _bikes){
					if(_bike instanceof EBike && _bike.getIsRented() == false){
						_id = _bike.getBikeID();
						break;
					}
				}
				break;
			case 5:
				for(Bike _bike: _bikes){
					if(_bike instanceof BMX && _bike.getIsRented() == false){
						_id = _bike.getBikeID();
						break;
					}
				}
				break;
			default:
				System.out.println("Invalid selection. Select a number between 1 and 5.");
			}
		}
		catch(Exception e){
			System.err.println("Error: " + e.getMessage());
		}
		return _id;
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
					for(Customer _customer: _customers){
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
					for(Bike _bike: _bikes){
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
			}
			else if (_category == 3) {
				for(RentRecord _rent: _rents){
					if (_currentDateValue - _rent.getDateValue() >= 30) {
						_output += _lineBreaker;
						_output += "<br/>OVERDUE";
						_output += _lineBreaker;
						_output += _rent.GUItoString();
						_output += _lineBreaker;
						_output += "==========";
						_output += _lineBreaker;
					}
					else {
						_output += _lineBreaker;
						_output += _rent;
						_output += "==========";
						_output += _lineBreaker;
	
					}
					_rentCount++;
				}
				if(_rentCount < 1){
					throw new Exception("No rentals found.");
				}
			}

			//_output += "</html>";
		}
		catch(Exception e){
			System.err.println("Error: " + e.getMessage());
		}

		return _output;
	}
	 
	public void SearchRentalsByCustID(){
		Scanner _input = null;
		try{
			System.out.println("<br />Search options: " + 
								"<br />1. I want to find a customer ID." +
								"<br />2. I already have a customer ID.");
			int _choice = _input.nextInt();
			
			if(_choice < 1 || _choice > 2){
				throw new Exception("Invalid selection.");
			}
			
			int _custID = 0;
	   
			switch(_choice){
			case 1:
				_input.nextLine();
				System.out.println("Enter first name: ");
				String _fname = _input.nextLine();
				System.out.println("Enter last name: ");
				String _lname = _input.nextLine();
	    
				//call searchForCustomer
				_custID = searchForCustomerTerminal(_fname, _lname);
	    
				if(_custID == 0){
					throw new Exception("Customer not found.");
				}
				break;
			case 2:
				System.out.println("Enter customer ID: ");
				_custID = _input.nextInt();
				if(_custID < 1){
					throw new Exception("Customer ID cannot be below one.");
				}
				break;
			default:
				System.out.println("Incorrect input. Please enter either 1 or 2."); 
			}
	   
			if(_custID != 0){
				int _numRentals = 0;
	    
				for(RentRecord _rent: _rents){
					if(_custID == _rent.getCustID()){
						System.out.println(_rent);
						_numRentals++;
					}
				}
	    
				if(_numRentals < 1){
					throw new Exception("No rentals found for that customer.");
				}
			}
		}
		catch(Exception e){
			System.err.println("Error: " + e.getMessage());
		}
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
				for (var _customer : _customers) {
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
				for (var _bike : _bikes) {
					_text += "<br />";
					_text += "Bike ID: ";
					_text += _bike.getBikeID();
					_text += "<br />";
					_text += "Bike Name: ";
					_text += _bike.getName();
					_text += "<br />";
					_text += "Bike rent status: ";
					_text += _bike.getIsRented();
					_text += "<br />";
				}
			}

			else if (_fileChosen == 3) {
				for (var _rent : _rents) {
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
			//_printWriter.print("</html>");
			_printWriter.close();	
		} 
		
		catch (Exception _error) {
			System.err.println("Error: " + _error.getMessage());
		}
	}

	public void addBikeForm(){
		System.out.println("Add new bike.");
		
		System.out.println("Bike name: ");
		String _name = _input.next();

		System.out.println("Bike make: ");
		System.out.println("1. BMX");
		System.out.println("2. Mountain Bike");
		System.out.println("3. City Bike");
		System.out.println("4. Road Bike");
		System.out.println("5. Ebike");
		
		int _make = _input.nextInt();
		switch (_make) {
			case 1:
				BMX _newBMX = new BMX(false, _name);
				_bikes.add(_newBMX);
				System.out.println("Bike " + _name + " added to bikes.");
				break;
			case 2:
				Mountain_Bike _newMB = new Mountain_Bike(false, _name);
				_bikes.add(_newMB);
				System.out.println("Bike " + _name + " added to bikes.");
				break;
			case 3:
				City_Bike _newCityBike = new City_Bike(false, _name);
				_bikes.add(_newCityBike);
				System.out.println("Bike " + _name + " added to bikes.");
				break;
			case 4:
				Road_Bike _newRoadBike = new Road_Bike(false, _name);
				_bikes.add(_newRoadBike);
				System.out.println("Bike " + _name + " added to bikes.");
				break;
			case 5:
				addEBike(_name);
				break;
			default:
				addBikeForm();
				break;
		}
	}

	public void addEBike(String _name){
		System.out.println("Motor strength");
		System.out.println("1. Full power");
		System.out.println("2. Power assist");
		int _powerMode = _input.nextInt();
		String _motorStrength = "";

		if (_powerMode == 1) {
			_motorStrength = "Full power";
		}
		else if (_powerMode == 2) {
			_motorStrength = "Power assist";
		}
		else {
			addEBike(_name);
		}
		System.out.println("Max distance (in meters): ");
		int _maxDistance = _input.nextInt();
		
		EBike _newEBike = new EBike(false, _name, _motorStrength, _maxDistance);
		_bikes.add(_newEBike);

		System.out.println("Bike " + _name + " added to bikes.");
	}

	public void returnBike(){
		System.out.println("Input bike ID to return: ");
		int _bikeID = _input.nextInt();
		for (var _bike : _rents) {
			if (_bike.getBikeID() == _bikeID) {
				_rents.remove(_bike);
				System.out.println("Bike returned.");
			}
			else {
				System.out.println("Bike not currently rented.");
			}
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
