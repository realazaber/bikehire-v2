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

	JPanel _tab_manual = new JPanel();
	JPanel _tab_customers = new JPanel();
	JPanel _tab_bikes = new JPanel();
	JPanel _tab_rentals = new JPanel();

	//Manual buttons
	JButton _manual_quit = new JButton("Quit");
	///////////////////////////////////////////

	//Customer buttons
	JButton _customer_save = new JButton("Save");
	JButton _customer_quit = new JButton("Quit");
	///////////////////////////////////////////

	//Bike buttons
	///////////////////////////////////////////
	JButton _bikes_save = new JButton("Save");
	JButton _bikes_quit = new JButton("Quit");

	//Rentals buttons
	JButton _rentals_quit = new JButton("Quit");
	///////////////////////////////////////////

	JTabbedPane tabbedPane = new JTabbedPane();

	//Labels for each page

	//Manual labels
	JLabel _manual_text = new JLabel("<html>Manual<br/><br /> You can also run this program in the command line. <br /> Just type the corresponding number and press enter and follow the prompts. <br /></html>");
	///////////////////////////////////////////

	//Customer labels
	JLabel _customers_heading = new JLabel("Manage Customers");

	JLabel _customer_records = new JLabel(_shop.displayCustomers());
	JLabel _customer_file = new JLabel(_shop.readCustomers());
	///////////////////////////////////////////

	//Bike labels
	JLabel _bikes_heading = new JLabel("Manage Bikes");
	JLabel _bikes_records = new JLabel(_shop.displayAvailableBikes());
	JLabel _bikes_file = new JLabel(_shop.readBikes());
	///////////////////////////////////////////

	//Rentals labels
	JLabel _rentals_heading = new JLabel("Manage Rentals");
	JLabel _rent_records_title = new JLabel("Rent Records");
	JLabel _rents_records = new JLabel(_shop.displayRents());
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
		_gui.setSize(800,600);
		_gui.setVisible(true);
		
	}

	public void preparePanels() {

		//Adding GUI elements to the manual tab
		_tab_manual.setLayout(new GridLayout(3, 1));
		
		_tab_manual.add(_manual_text);
		
		
		_tab_manual.add(_manual_quit);
		

		//Adding GUI elements to the customers tab
		_tab_customers.setLayout(new GridLayout(5, 3));
		_tab_customers.add(new JPanel());
		_tab_customers.add(_customers_heading);
		

		_tab_customers.add(_customer_records);
		_tab_customers.add(_customer_save);
		_tab_customers.add(_customer_file);
		_tab_customers.add(_customer_quit);

		///////////////////////////////////////////

		//Adding GUI elements to the bikes tab
		_tab_bikes.setLayout(new GridLayout(5, 3));
		_tab_bikes.add(_bikes_heading);
		_tab_bikes.add(_bikes_records);
		_tab_bikes.add(_bikes_save);
		_tab_bikes.add(_bikes_file);
		_tab_bikes.add(_bikes_quit);
		
		///////////////////////////////////////////

		//Adding GUI elements to the rentals tab
		_tab_rentals.setLayout(new GridLayout(6, 3));
		_tab_rentals.add(_rentals_heading);
		_tab_rentals.add(_rent_records_title);
		_tab_rentals.add(_rents_records);
		_tab_rentals.add(_rentals_quit);

		///////////////////////////////////////////
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
				_shop.saveCustomers();
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
				_shop.saveBikes();
			}
		});

		_bikes_quit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("QUIT");
				System.exit(1);
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