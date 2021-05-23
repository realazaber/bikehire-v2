
//For input and other key features
import java.io.*;
import java.util.*;
/************************************************/

//For the GUI
import java.awt.Font;
import javax.swing.*;
/************************************************/

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

	private JFrame _frame = new JFrame(); //Creates the window
	private JPanel _panel = new JPanel(); //The stuff that goes in the window
	private JTextField _guiInput = new JTextField(); //Takes in user input via text typing

	private ArrayList<Bike> _bikes;
	private ArrayList<Customer> _customers;
	private ArrayList<RentRecord> _rents;

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
		EBike _ScootScoot = new EBike(false, "Scoot", "Power assist", 400);
		
		Customer _Customer_1 = new Customer("Ben", "Ten", "My basement", 69420);
		Customer _Customer_2 = new Customer("Norman", "Reedus", "My attic", 42069);
		Customer _Customer_3 = new Customer("Bred", "Summerton", "My house", 2142069);
		
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
	
		_rents.add(_rentRecord_1);
		_rents.add(_rentRecord_2);
	}
	
	private void displayAvailableBikes(){ //Shows all AVAILABLE BIKES
		int _bikeNum = 0; //Starts the counter of bikes
		try{
			for(Bike _bike: _bikes){
				if(_bike.getIsRented() == false){
					System.out.println("\nBike ID: " + _bike.getBikeID());
					System.out.println("Bike name: " + _bike.getName());
					System.out.println("Rent status: " + _bike.getIsRented());
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
	 
	private void addCustomer(){
		try{
			System.out.println("First name: ");
			String _fname = _input.nextLine();
			System.out.println("Last name: ");
			String _lname = _input.nextLine();
			System.out.println("Customer address: ");
			String _address = _input.nextLine();
			System.out.println("Customer phone: ##########");
			int _phone = _input.nextInt();
	   
			//create customer
			Customer c = new Customer(_fname, _lname, _address, _phone);
			//add to ArrayList
			_customers.add(c);
		}
		catch(Exception e){
			System.err.println("Error: " + e.getMessage());
		}
	}
	 
	private void displayCustomers(){
		int _custCount = 0;
		try{
			for(Customer _customer: _customers){
				System.out.println(_customer);
				_custCount++;
			}
			if(_custCount < 1){
				throw new Exception("No customers registered.");
			}
		}
		catch(Exception e){
			System.err.println("Error: " + e.getMessage());
		}
	}
	 
	private int searchForCustomer(String _fname, String _lname){
		int _id = 0;
		for(Customer _customer: _customers){
			if(_fname.equalsIgnoreCase(_customer.getFirstName()) && _lname.equalsIgnoreCase(_customer.getLastName())){
				_id = _customer.getCustID();
			}
		}
		return _id;
	}
	 
	private int searchForBikeByType(int _type){
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
	 
	private void addRent(){
		try{
			int _custID = 0;
			System.out.println("Customer details");
			System.out.println("Enter first name: ");
			String _fname = _input.next();
			System.out.println("Enter last name: ");
			String _lname = _input.next();
			
			_custID = searchForCustomer(_fname, _lname);
			if(_custID != 0){
				System.out.println("Enter day in number form: ");
				int _day = _input.nextInt();
				System.out.println("Enter month in number form: ");
				int _month = _input.nextInt();
				System.out.println("Enter year in number form: ");
				int _year = _input.nextInt();
				System.out.println("Enter duration: ");
				double _duration = _input.nextDouble();
				if(_duration > 30){
					throw new Exception("Duration cannot exceed 30 days.");
				}
				else if(_duration < 1){
					throw new Exception("Duration must be at least 1 day.");
				}
				else{
					System.out.println("CustID selected: " + _custID);
					
					boolean _flag = true;
					
					while(_flag){
						System.out.println("Enter ID of bike: ");


						int _type = _input.nextInt();

						for (var _bike : _bikes) {
							if (_bike.getBikeID() == _type) {
															//set bike to isRented
								_bike.setIsRented(true);

								//create rent
								RentRecord _r = new RentRecord(_custID, _bike.getBikeID(), _day, _month, _year, _duration);
						
								_rents.add(_r);
				
								_input.nextLine();
								System.out.println("Press 'C' to complete order or 'Enter' to add another bike to order.");
								String loopAgain = _input.nextLine();
								
								if(loopAgain.equals("C") || loopAgain.equals("c")){
									_flag = false;
									break;
								}
							}
							else {
								System.out.println("Bike ID invalid");
							}
						}
					}
				}
			}
			else{
				throw new Exception("Customer not found.");
			}
		}
		catch(Exception e){
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	private void displayRents(){


		int _rentCount = 0;
		try{
			System.out.println("==========");
			for(RentRecord _rent: _rents){
				if (_currentDateValue - _rent.getDateValue() >= 30) {
					System.out.println("OVERDUE");
					System.out.println(_rent);
					System.out.println("==========");
				}
				else {
					System.out.println(_rent);
					System.out.println("==========");
				}
				_rentCount++;
			}
			if(_rentCount < 1){
				throw new Exception("No rentals found.");
			}
		}
		catch(Exception e){
			System.err.println("Error: " + e.getMessage());
		}
	}
	 
	private void SearchRentalsByCustID(){
		Scanner _input = null;
		try{
			System.out.println("\nSearch options: " + 
								"\n1. I want to find a customer ID." +
								"\n2. I already have a customer ID.");
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
				_custID = searchForCustomer(_fname, _lname);
	    
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
	
	private void saveRentals(){

		try {
			File _file = new File("rentals.dat"); //Selects file and prepares it for writing
			FileWriter _fileWriter = new FileWriter(_file, true);
			BufferedWriter _buffWriter = new BufferedWriter(_fileWriter);
			PrintWriter _printWriter = new PrintWriter(_buffWriter);
	
			String _text = ""; //All rentals are added to the string then added to the file

			for (var _rent : _rents) {
				_text += _rent.toString();
			}

			_printWriter.print("\n" + _text); //appends to file
			_printWriter.close();	
		} 
		
		catch (Exception _error) {
			System.err.println("Error: " + _error.getMessage());
		}
	}

	private void saveCustomers(){
		try {
			File _file = new File("customers.dat"); //Selects file and prepares it for writing
			FileWriter _fileWriter = new FileWriter(_file, true);
			BufferedWriter _buffWriter = new BufferedWriter(_fileWriter);
			PrintWriter _printWriter = new PrintWriter(_buffWriter);
	
			String _text = ""; //All rentals are added to the string then added to the file

			for (var _customer : _customers) {
				_text += _customer.toString();
			}

			_printWriter.print("\n" + _text); //appends to file
			_printWriter.close();	
		} 
		
		catch (Exception _error) {
			System.err.println("Error: " + _error.getMessage());
		}
	}

	private void saveBikes(){
		try {
			File _file = new File("bikes.dat"); //Selects file and prepares it for writing
			FileWriter _fileWriter = new FileWriter(_file, true);
			BufferedWriter _buffWriter = new BufferedWriter(_fileWriter);
			PrintWriter _printWriter = new PrintWriter(_buffWriter);
	
			String _text = ""; //All rentals are added to the string then added to the file

			for (var _bike : _bikes) {
				_text += _bike.toString();
			}

			_printWriter.print("\n" + _text); //appends to file
			_printWriter.close();	
		} 
		
		catch (Exception _error) {
			System.err.println("Error: " + _error.getMessage());
		}
	}
	 
	private void displayOverdueRents(){

        /////////////////////////////////////////////////////////////

		for (var _rent : _rents) {
			if ((_currentDateValue - _rent.getDateValue()) >= 30) {
				System.out.println("==========");
				System.out.println("OVERDUE");
				System.out.println(_rent.toString());
				System.out.println("Date: " + _rent.getDay() + "/" + _rent.getMonth() + "/" + _rent.getYear());
				System.out.println("CURRENT DATE VALUE: " + _currentDateValue);
				System.out.println("BIKE DATE VALUE: " + _rent.getDateValue());
				System.out.println("==========");
			}
		}


	}

	private void addBike(){
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
				addBike();
				break;
		}
	}

	private void addEBike(String _name){
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



	private void returnBike(){
		System.out.println("Input bike ID to return: ");
		int _bikeID = _input.nextInt();
		for (var _bike : _rents) {
			if (_bike.getBikeID() == _bikeID) {
				_rents.remove(_bike);
				System.out.println("Bike returned.");
				run();
			}
			else {
				System.out.println("Bike not currently rented.");
				
			}
		} 

	}
	
	private void readRentals(){
		FileInputStream _fileInput = null;
		ObjectInputStream _objectInput = null;
	  
		try{
			_fileInput = new FileInputStream("rentals.dat");
			_objectInput = new ObjectInputStream(_fileInput);
	   
			RentRecord _r = null;
			while(true){
				try{
					Object obj = _objectInput.readObject();
					_r = (RentRecord)obj;
					System.out.println(_r);
				}
				catch(EOFException eofe){
					break;
				}
			}
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
				System.err.println("Error: " + fe.getMessage());
			}
		}
	}

	private void readCustomers(){
		FileInputStream _fileInput = null;
		ObjectInputStream _objectInput = null;
	  
		try{
			_fileInput = new FileInputStream("customers.dat");
			_objectInput = new ObjectInputStream(_fileInput);
	   
			RentRecord _r = null;
			while(true){
				try{
					Object obj = _objectInput.readObject();
					_r = (RentRecord)obj;
					System.out.println(_r);
				}
				catch(EOFException eofe){
					break;
				}
			}
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
				System.err.println("Error: " + fe.getMessage());
			}
		}
	}

	private void readBikes(){
		FileInputStream _fileInput = null;
		ObjectInputStream _objectInput = null;
	  
		try{
			_fileInput = new FileInputStream("bikes.dat");
			_objectInput = new ObjectInputStream(_fileInput);
	   
			RentRecord _r = null;
			while(true){
				try{
					Object _obj = _objectInput.readObject();
					_r = (RentRecord)_obj;
					System.out.println(_r);
				}
				catch(EOFException _eofe){
					break;
				}
			}
		}
		catch(Exception _exception){
			System.err.println("Error: " + _exception.getMessage());
		}
		finally{
			try{
				_fileInput.close();
				_objectInput.close();
			}
			catch(Exception fe){
				System.err.println("Error: " + fe.getMessage());
			}
		}
	}
		 
	public void run(){
		try{
			boolean _flag = true;
			int _choice = 0;
   
			while(_flag){
				System.out.println( "\n" +
									"============Menu============\n" +
									"1. View rentals\n" +
									"2. View customers\n" +
									"3. View available bikes\n" +
									"4. Show rentals by customer ID\n" +

									"===========================\n" +
									"5. Read rent records from file\n" +
									"6. Read customers from file\n" +
									"7. Read bikes from file\n" + 

									"===========================\n" +
									"8. Add a rent record\n" +
									"9. Add new customer\n" + 
									"10. Add bike\n" +

									"===========================\n" +
									"11. Save rent records to file\n" +
									"12. Save customers to file\n" +
									"13. Save bikes to file\n" +
									
									"===========================\n" +
									"14. Display overdue rents\n" +
									"15. Search for customer by ID\n" +
									"16. Return a bike\n" +

									"===========================\n" +
									"17. Quit"); 

   
				System.out.println("Enter your choice (1 - 17): ");
				_choice = _input.nextInt();
	
				switch(_choice){
				case 1:
					displayRents();
					break;
				case 2:
					displayCustomers();
					break;
				case 3:
					displayAvailableBikes();
					break;
				case 4:
					SearchRentalsByCustID();
					break;
				case 5:
					readRentals();
					break;
				case 6:
					readCustomers();
					break;
				case 7:
					readBikes();
					break;
				case 8:
					addRent();
					break;
				case 9:
					addCustomer();
					break;
				case 10:
					addBike();
					break;
				case 11:
					saveRentals();
					break;
				case 12:
					saveCustomers();
					break;
				case 13:
					saveBikes();
					break;
				case 14:
					displayOverdueRents();
					break;
				case 15:
					_input.nextLine();
					System.out.println("Search will return customer details. \n0 means no customer found.");
					System.out.println("Please input customer ID: ");
					int _custID = _input.nextInt();
					for (var _customer : _customers) {
						if (_custID == _customer.getCustID()) {
							System.out.println("Customer ID: " + _customer.getCustID());
							System.out.println("First name: " + _customer.getFirstName());
							System.out.println("Last name: " + _customer.getLastName());
							System.out.println("Phone number: " + _customer.getPhone());
							System.out.println("Address: " + _customer.getAddress());
						}
					}
					break;
				case 16:
					returnBike();
					break;
				case 17:
					_flag = false;
					break;
				default:
					System.out.println("Incorrect input. Please enter a number between 1 and 13.");
				}
			}
		}
		catch(Exception _exception){
			System.out.println("Error: " + _exception.getMessage());
		}
		finally{
			if(_input != null){
				_input.close();
			}
		}
	}
}
