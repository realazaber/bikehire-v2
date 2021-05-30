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
		
		Customer customer_1 = new Customer("Ben", "Ten", "bten@gmail.com", "69420", "My basement");
		Customer customer_2 = new Customer("Norman", "Reedus", "reedus@norman.com", "42069", "My attic");
		Customer customer_3 = new Customer("Fred", "Summerton", "smithjohn@yahoo.com", "2142069", "My house");
		Customer customer_4 = new Customer("George", "Baba", "curiousgeorge@gmail.com", "24394", "My door");
		
		RentRecord rentRecord_1 = new RentRecord(1, 1, 4, 4, 2021, 23);
		RentRecord rentRecord_2 = new RentRecord(2, 4, 3, 3, 2020, 21);
		RentRecord rentRecord_3 = new RentRecord(3, 4, 5, 5, 2021, 12);

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
	
		customerRecords.add(customer_1);
		customerRecords.add(customer_2);
		customerRecords.add(customer_3);
		customerRecords.add(customer_4);
	
		rentRecords.add(rentRecord_1);
		rentRecords.add(rentRecord_2);
		rentRecords.add(rentRecord_3);
	}
	
	public void addBike(String type, String name, double pricePerDay, boolean rented, String power, int maxDistance) {
				
		switch (type) {
		case "BMX":
			BMX bmx = new BMX(rented, name, type, 40.00);
			bikeRecords.add(bmx);
			break;
		case "Road":
		case "Road Bike:":
			Road_Bike roadBike = new Road_Bike(rented, name, type, 30.00);
			bikeRecords.add(roadBike);
			break;
		case "Mountain":
		case "Mountain Bike":
			Mountain_Bike mtnBike = new Mountain_Bike(rented, name, type, 25.00);
			bikeRecords.add(mtnBike);
			break;
		case "City":
		case "City Bike":
			City_Bike cityBike = new City_Bike(rented, name, type, 30.00);
			bikeRecords.add(cityBike);
			break;
		case "Ebike":
			EBike eBike = new EBike(rented, name, type, 25.00, power, maxDistance);
			bikeRecords.add(eBike);
			break;
		default:
			Bike bike = new Bike(name, type, rented, pricePerDay);
			bikeRecords.add(bike);
			break;
		}
	}
	
	public String displayAvailableBikes(){ //Shows all AVAILABLE BIKES
		int bikeNum = 0; //Starts the counter of bikes
		String output = "<html>";
		try{
			for(Bike bike: bikeRecords){
				if(bike.getIsRented() == false){
					
					output += bike.GUItoString();
					bikeNum++;

				}
			}
			if(bikeNum < 1){
				throw new Exception("No bikes available.");
			}
		}
		catch(Exception error){
			System.err.println("Error: " + error.getMessage());
		}

		return output;
	}
	 
	public void addCustomer(String firstName, String lastName, String email, String phone, String address){
		try{
			//create customer
			Customer newCustomer = new Customer(firstName, lastName, email, phone, address);
			//add to ArrayList
			customerRecords.add(newCustomer);
			System.out.println("Customer added");
		}
		catch(Exception error){
			System.err.println("Error: " + error.getMessage());
		}
	}
	
	public void addRent(int customerID, int bikeID, int rentDay, int rentMonth, int rentYear, double duration) {
		try {
			RentRecord newRent = new RentRecord(customerID, bikeID, rentDay, rentMonth, rentYear, duration);
			rentRecords.add(newRent);
			System.out.println("Rent added");
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	public void clearRecords(int chosenRecords) {
		switch(chosenRecords) {
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
	

	
	public String[] searchRecords(int chosenRecords, int id) {
		String[] array = new String[6];
		
		if (chosenRecords == 1) {
			for (Customer customer: customerRecords) {
				if (id == customer.custID) {
					String strID = String.valueOf(id);
					array[0] = strID;
					array[1] = customer.getFirstName();
					array[2] = customer.getLastName();
					array[3] = customer.getPhone();
					array[4] = customer.getEmail();
					array[5] = customer.getAddress();			
					
				}
			}
		}
		
		if (chosenRecords == 2) {
			for (Bike bike: bikeRecords) {
				if (id == bike.bikeID) {
					
					String bikeId = Integer.toString(bike.getBikeID());
					
					array[0] = bikeId;
					array[1] = bike.getName();
					
					if (bike.getIsRented() == true) {
						array[2] = "true";
					}
					else {
						array[2] = "false";
					}
					array[3] = bike.bikeType;
					String price = Double.toString(bike.pricePerDay);
					array[4] = price;	
					
				}
			}
		}
		
		else if (chosenRecords == 3) {
			for (RentRecord rent : rentRecords) {
				if (id == rent.getRentID()) {
					
				
				
				String rentId = String.valueOf(rent.getRentID());
				String custId = String.valueOf(rent.getCustID());
				String bikeId = String.valueOf(rent.getBikeID());
				String duration = String.valueOf(rent.getDuration());
				
				array[0] = rentId;
				array[1] = custId;
				array[2] = bikeId;
				array[3] = rent.getDateString();
				array[4] = duration;
				}
			}
		}	
		return array;
	}

	public String displayRecords(int category){

		//category 1 = Customers
		//category 2 = Bikes
		//category 3 = rentals
		String output = "";
		int rentCount = 0;
		String lineBreaker = "";
		try{
			System.out.println("==========");

			output += "<html>";
			
			if (category == 1) {
				int custCount = 0;
				try{
					for(Customer customer: customerRecords){
						custCount++;
						output += "<br />";
						output += customer.GUItoString();
						output += "<br />";
					}
					if(custCount < 1){
						throw new Exception("No customers registered.");
					}
				}
				catch(Exception e){
					System.err.println("Error: " + e.getMessage());
				}
			}
			else if (category == 2) {
				int bikeNum = 0; //Starts the counter of bikes
				try{
					for(Bike bike: bikeRecords){

						if(bike.getIsRented() == false){
							
							output += bike.GUItoString();
							output += bike.toString();
							bikeNum++;
		
						}
					}
					if(bikeNum < 1){
						throw new Exception("No bikes available.");
					}
				}
				catch(Exception e){
					System.err.println("Error: " + e.getMessage());
				}
			}
			else if (category == 3) {
				for(RentRecord rent: rentRecords){
					if (currentDateValue - rent.getDateValue() >= 30) {
						output += lineBreaker;
						output += "<br/>OVERDUE";
						output += lineBreaker;
						output += rent.GUItoString();
						output += lineBreaker;
						output += "==========";
						output += lineBreaker;
					}
					else {
						output += "<br/>";
						output += lineBreaker;
						output += rent.GUItoString();
						output += "==========";
						output += lineBreaker;
					}
					rentCount++;
				}
				if(rentCount < 1){
					throw new Exception("No rentals found.");
				}
			}

		}
		catch(Exception error){
			System.err.println("Error: " + error.getMessage());
		}

		return output;
	}
	 
	public void clearFile(int fileChosen) {
		//1 Customer
		//2 Bike
		//3 Rental

		String path = "";

		if (fileChosen == 1) {
			path = "customers.dat";
		}
		else if (fileChosen == 2) {
			path = "bikes.dat";
		}
		else if (fileChosen == 3) {
			path = "rentals.dat";
		}

		try {
			File file = new File(path); //Selects file and prepares it for writing
			FileWriter fileWriter = new FileWriter(file, false);

			fileWriter.write("<html>");
			fileWriter.close();
		} 
		
		catch (Exception error) {
			System.err.println("Error: " + error.getMessage());
		}
	}

	public void saveFile(int fileChosen) {
		//1 Customer
		//2 Bike
		//3 Rental

		String path = "";

		if (fileChosen == 1) {
			path = "customers.dat";
		}
		else if (fileChosen == 2) {
			path = "bikes.dat";
		}
		else if (fileChosen == 3) {
			path = "rentals.dat";
		}

		try {
			File file = new File(path); //Selects file and prepares it for writing
			FileWriter fileWriter = new FileWriter(file, true);
			BufferedWriter buffWriter = new BufferedWriter(fileWriter);
			PrintWriter printWriter = new PrintWriter(buffWriter);
	
			String text = ""; //All rentals are added to the string then added to the file
			text += "<html>";

			if (fileChosen == 1) {
				for (Customer customer : customerRecords) {
					text += "<br />Customer ID: ";
					text += customer.getCustID();
					text += "<br />";
					text += "Customer First Name: ";
					text += customer.getFirstName();
					text += "<br />";
					text += "Customer Last Name: ";
					text += customer.getLastName();
					text += "<br />";
					text += "Customer Phone: ";
					text += customer.getPhone();
					text += "<br />";
					text += "Customer Email: ";
					text += customer.getEmail();
					text += "<br />";
;					text += "Customer Address: ";
					text += customer.getAddress();
					text += "<br /><br />";
				}
			}

			else if (fileChosen == 2) {
				for (Bike bike : bikeRecords) {
					text += "<br />";
					text += "Bike ID: ";
					text += bike.getBikeID();
					text += "<br />";
					text += "Bike Name: ";
					text += bike.getName();
					text += "<br />";
					text += "Bike Rent Status: ";
					text += bike.getIsRented();
					text += "<br />";
					text += bike.toString();
					text += "<br />";
				}
			}

			else if (fileChosen == 3) {
				for (var rent : rentRecords) {
					text += "<br />";
					text += "Rent ID: ";
					text += rent.getRentID();
					text += "<br />";
					text += "Customer ID: ";
					text += rent.getCustID();
					text += "<br />";
					text += "Bike ID: ";
					text += rent.getBikeID();
					text += "<br />";
					text += "Date: ";
					text += rent.getDay();
					text += "/";
					text += rent.getMonth();
					text += "/";
					text += rent.getYear();
					text += "<br />";
					text += "Duration (in days): ";
					text += rent.getDuration();
					text += "<br />";
				}
			}

			printWriter.print(text); //appends to file
			printWriter.close();	
		} 
		
		catch (Exception error) {
			System.err.println("Error: " + error.getMessage());
		}
	}

	public void returnRent(int rentId){
		
		try {
			for (RentRecord rent : rentRecords) {
				if (rentId == rent.getRentID()) {
					rentRecords.remove(rent);
					System.out.println("Bike returned.");
				}
				else {
					System.out.println("Bike not currently rented.");
				}
			} 
		} catch (Exception error) {
			System.err.println("Error returning bike");
		}

	}
	
	public String readFile(int fileChosen){
		//1 customers
		//2 bikes
		//3 rents
		String path = "";
		if (fileChosen == 1) {
			path = "customers.dat";
		}
		else if(fileChosen == 2) {
			path = "bikes.dat";
		}
		else if (fileChosen == 3) {
			path = "rentals.dat";
		}

		FileInputStream fileInput = null;
		ObjectInputStream objectInput = null;
	  
		String output = "";
		try{
			File file = new File(path); //Gets the file
			Scanner scanner = new Scanner(file);
	
			while (scanner.hasNextLine()) { //Goes through each line and prints it out
				output += scanner.nextLine();
			}
			scanner.close();
		}
		catch(Exception error){
			System.err.println("Error: " + error.getMessage());
		}
		finally{
			try{
				fileInput.close();
				objectInput.close();
			}
			catch(Exception fe){
			
			}
		}

		return output;
	}	
}
