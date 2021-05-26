//For the windows and layout
import javax.swing.*; //For GUI to work
import java.awt.*;
import java.awt.event.*;

import java.io.IOException; //Error handling

import java.awt.event.ActionEvent; //Event listeners
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;

public class GUI extends JFrame {	

	BikeHire _shop = new BikeHire();

	//Main tabs
	JPanel _tab_manual = new JPanel();
	JPanel _tab_customers = new JPanel();
	JPanel _tab_bikes = new JPanel();
	JPanel _tab_rentals = new JPanel();

	//Forms
	
	//Customer forms
	JPanel _add_customer = new JPanel();
	JPanel _search_customer = new JPanel();

	//Bike forms
	JPanel _add_bike = new JPanel();
	JPanel _add_ebike = new JPanel();

	//Rentals forms
	JPanel _search_rental = new JPanel();
	JPanel _add_rent = new JPanel();


	//Manual buttons
	JButton _manual_quit = new JButton("Quit");
	///////////////////////////////////////////

	//Customer buttons
	JButton _customer_save = new JButton("Save");
	JButton _customer_search = new JButton("Search for Customer");
	JButton _customer_add = new JButton("Add New Customer");
	JButton _customer_quit = new JButton("Quit");
	///////////////////////////////////////////

	//Bike buttons
	///////////////////////////////////////////
	JButton _bikes_save = new JButton("Save");
	JButton _new_bike = new JButton("Add new bike");
	JButton _add_e_bike = new JButton("Add new EBike");
	JButton _bikes_quit = new JButton("Quit");

	//Rentals buttons
	JButton _rentals_save = new JButton("Save");
	JButton _rentals_search = new JButton("Search");
	JButton _rentals_add = new JButton("Add new Rental");
	JButton _rentals_quit = new JButton("Quit");
	///////////////////////////////////////////

	JTabbedPane tabbedPane = new JTabbedPane();

	//Labels for each page

	//Manual labels
	JLabel _manual_heading = new JLabel("<html><h1>Manual</html>");
	JLabel _manual_text = new JLabel("<html><h2>To conduct certain operations you need to navigate to the other tabs.</html>");
	///////////////////////////////////////////

	//Customer labels
	JLabel _customers_heading = new JLabel("<html><h1>Manage Customers</html>");

	JLabel _customer_records = new JLabel(_shop.displayRecords(1));
	JLabel _customer_file = new JLabel(_shop.readFile(1));

//	JScrollPane _scrolling = new JScrollPane(_customer_records, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	///////////////////////////////////////////

	//Bike labels
	JLabel _bikes_heading = new JLabel("<html><h1>Manage Bikes</html>");
	JLabel _bikes_records = new JLabel(_shop.displayRecords(2));
	JLabel _bikes_file = new JLabel(_shop.readFile(2));
	///////////////////////////////////////////

	//Rentals labels
	JLabel _rentals_heading = new JLabel("<html><h1>Manage Rentals</html>");
	JLabel _rent_records_title = new JLabel("<html><h2>Rent Records</html>");
	JLabel _rents_records = new JLabel(_shop.displayRecords(3));
	JLabel _rents_file = new JLabel(_shop.readFile(3));
	///////////////////////////////////////////
	public static void main(String[] args) throws IOException {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} 
		catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException _exception) {
			_exception.printStackTrace();
		}

		GUI _gui = new GUI();
		_gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_gui.setSize(800,950);
		_gui.setVisible(true);		
	}

	public void preparePanels() {

		//Adding GUI elements to the manual tab
		_tab_manual.setLayout(new GridLayout(4, 3));
		
		_tab_manual.add(new JLabel("EMPTY"));
		_tab_manual.add(_manual_heading);
		_tab_manual.add(new JLabel("EMPTY"));

		_tab_manual.add(new JLabel("EMPTY"));
		_tab_manual.add(_manual_text);
		_tab_manual.add(new JLabel("EMPTY"));

		_tab_manual.add(new JLabel("EMPTY"));
		_tab_manual.add(new JLabel("EMPTY"));
		_tab_manual.add(new JLabel("EMPTY"));

		_tab_manual.add(new JLabel("EMPTY"));
		_tab_manual.add(_manual_quit);
		_tab_manual.add(new JLabel("EMPTY"));
		
		

		//Adding GUI elements to the customers tab
		_tab_customers.setLayout(new GridLayout(4, 3));
		_tab_customers.add(new JLabel("EMPTY"));
		_tab_customers.add(_customers_heading);
		_tab_customers.add(new JLabel("EMPTY"));

		_tab_customers.add(new JLabel("<html><h2>Customer Records</html>"));
		_tab_customers.add(new JLabel("EMPTY"));
		_tab_customers.add(new JLabel("<html><h2>Customer Records in File</html>"));
		_tab_customers.add(_customer_records);
		_tab_customers.add(_customer_save);
		_tab_customers.add(_customer_file);
		_tab_customers.add(new JLabel("EMPTY"));
		_tab_customers.add(_customer_quit);
		_tab_customers.add(new JLabel("EMPTY"));

		///////////////////////////////////////////

		//Adding GUI elements to the bikes tab
		_tab_bikes.setLayout(new GridLayout(4, 3));
		_tab_bikes.add(new JLabel("EMPTY"));
		_tab_bikes.add(_bikes_heading);
		_tab_bikes.add(new JLabel("EMPTY"));
		_tab_bikes.add(new JLabel("<html><h2>Bike Records</html>"));
		_tab_bikes.add(new JLabel("EMPTY"));
		_tab_bikes.add(new JLabel("<html><h2>Bike File</html>"));
		_tab_bikes.add(_bikes_records);
		_tab_bikes.add(_bikes_save);
		_tab_bikes.add(_bikes_file);
		_tab_bikes.add(new JLabel("EMPTY"));
		_tab_bikes.add(_bikes_quit);
		_tab_bikes.add(new JLabel("EMPTY"));

		
		///////////////////////////////////////////

		//Adding GUI elements to the rentals tab
		_tab_rentals.setLayout(new GridLayout(4, 3));
		_tab_rentals.add(new JLabel("EMPTY"));
		_tab_rentals.add(_rentals_heading);
		_tab_rentals.add(new JLabel("EMPTY"));
		_tab_rentals.add(new JLabel("<html><h2>Rent Records</html>"));
		_tab_rentals.add(new JLabel("EMPTY"));
		_tab_rentals.add(new JLabel("<html><h2>Rent files</html>"));
		_tab_rentals.add(_rents_records);
		_tab_rentals.add(_rentals_save);
		_tab_rentals.add(_rents_file);
		_tab_rentals.add(new JLabel("EMPTY"));
		_tab_rentals.add(_rentals_quit);
		_tab_rentals.add(new JLabel("EMPTY"));

		///////////////////////////////////////////
		
		
		_rentals_quit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("QUIT");
				System.exit(1);
			}
		});
	}



	public void prepareButtonActions() {

		_manual_quit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("QUIT");
				System.exit(1);
			}
		});



		_customer_save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				_shop.saveFile(1);
			}
		});

		_customer_quit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("QUIT");
				System.exit(1);
			}
		});



		_bikes_save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				_shop.saveFile(2);
			}
		});

		_bikes_quit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("QUIT");
				System.exit(1);
			}
		});
		
		
		_rentals_save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				_shop.saveFile(3);
			}
		});
		
		_rentals_quit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("QUIT");
				System.exit(1);
			}
		});
	}

	public GUI(){		
		
		preparePanels();
		prepareButtonActions();
	
		//Tab text for each menu
		tabbedPane.add("Manual", _tab_manual);
		tabbedPane.add("Customers",_tab_customers);
		tabbedPane.add("Bikes",_tab_bikes);
		tabbedPane.add("Rentals",_tab_rentals);
		
		add(tabbedPane);
		///////////////////////////////////////////
	}
}