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

	JPanel _tab_manual = new JPanel();
	JPanel _tab_customers = new JPanel();
	JPanel _tab_bikes = new JPanel();
	JPanel _tab_rentals = new JPanel();

	//Universal buttons
	JButton _button_quit = new JButton("Quit");
	///////////////////////////////////////////
	
	//Manual buttons
	
	///////////////////////////////////////////

	//Customer buttons
	JButton _save_customers = new JButton("Save");
	///////////////////////////////////////////

	//Bike buttons
	///////////////////////////////////////////

	//Rentals buttons
	///////////////////////////////////////////


	JTabbedPane tabbedPane = new JTabbedPane();

	
		//Labels for each page

		//Manual labels
		JLabel _manual_text = new JLabel("<html>Manual<br/><br /> You can also run this program in the command line. <br /> Just type the corresponding number and press enter and follow the prompts. <br /></html>");
		///////////////////////////////////////////

		//Customer labels
		JLabel _customers_heading = new JLabel("Manage Customers");

		JLabel _customer_records = new JLabel("Arabic");
		JLabel _customer_file = new JLabel();
		///////////////////////////////////////////

		//Bike labels
		JLabel _bikes_heading = new JLabel("Manage Bikes");
		///////////////////////////////////////////

		//Rentals labels
		JLabel _rentals_heading = new JLabel("Manage Rentals");
		///////////////////////////////////////////


	public void preparePanels() {
		_tab_manual.setLayout(new GridBagLayout());
		GridBagConstraints _manual_gbc = new GridBagConstraints();

		//Adding GUI elements to the manual tab
		_manual_gbc.gridx = 1;
		_manual_gbc.gridy = 1;
		_manual_gbc.gridwidth = 3;
		_manual_gbc.gridheight = 1;
		_tab_manual.add(_manual_text, _manual_gbc);

		_manual_gbc.gridx = 2;
		_manual_gbc.gridy = 3;
		_manual_gbc.gridwidth = 2;
		_manual_gbc.gridheight = 1;
		_manual_gbc.fill = GridBagConstraints.HORIZONTAL;
		_tab_manual.add(_button_quit, _manual_gbc);

		//Adding GUI elements to the customers tab
		_tab_customers.setLayout(new GridBagLayout());
		GridBagConstraints _customer_gbc = new GridBagConstraints();
		
		_customer_gbc.gridx = 1;
		_customer_gbc.gridy = 0;
		_customer_gbc.gridwidth = 3;
		_customer_gbc.gridheight = 3;
		_tab_customers.add(_customers_heading, _customer_gbc);
		_customer_gbc.gridx = 1;
		_customer_gbc.gridy = 3;
		_customer_gbc.gridwidth = 1;
		_customer_gbc.gridheight = 1;
		_tab_customers.add(_customer_records, _customer_gbc);
		_customer_gbc.gridx = 2;
		_customer_gbc.gridy = 5;
		_customer_gbc.gridwidth = 3;
		_customer_gbc.gridheight = 1;
		_customer_gbc.fill = GridBagConstraints.HORIZONTAL;
		_tab_customers.add(_button_quit, _customer_gbc);

		///////////////////////////////////////////

	}

	public void prepareButtonActions() {

		_button_quit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("QUIT");
				System.exit(1);
			}
		});
	}

	public GUI(){		
		
		preparePanels();
		prepareButtonActions();
		//Tab names
		
		_tab_bikes.add(_bikes_heading);
		_tab_rentals.add(_rentals_heading);


		///////////////////////////////////////////

		
		//Tab text for each menu
		tabbedPane.add("Manual", _tab_manual);
		tabbedPane.add("Customers",_tab_customers);
		tabbedPane.add("Bikes",_tab_bikes);
		tabbedPane.add("Rentals",_tab_rentals);
		
		add(tabbedPane);
		///////////////////////////////////////////
	}



	public static void main(String[] args) throws IOException {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} 
		catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException _exception) {
			_exception.printStackTrace();
		}

		BikeHire _shop = new BikeHire();

		GUI _gui = new GUI();
		_gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_gui.setSize(800,600);
		_gui.setVisible(true);

		_shop.run();
	}


}
