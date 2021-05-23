
import java.io.IOException;

import javax.swing.*;

public class GUI extends JFrame{

	JPanel tab_customers = new JPanel();
	JPanel tab_bikes = new JPanel();
	JPanel tab_rentals = new JPanel();
	JPanel tab_manual = new JPanel();
	
	//Title texts for each tab
	JLabel _customers_heading = new JLabel("Manage Customers");
	JLabel _bikes_heading = new JLabel("Manage Bikes");
	JLabel _rentals_heading = new JLabel("Manage Rentals");

	JLabel _manual_text = new JLabel("<html>Manual<br/><br /> You can also run this program in the command line. <br /> Just type the corresponding number and press enter and follow the prompts.</html>");
	///////////////////////////////////////////

	JTabbedPane tabbedPane = new JTabbedPane();
	
	public GUI(){

		//Tab names
		tab_customers.add(_customers_heading);
		tab_bikes.add(_bikes_heading);
		tab_rentals.add(_rentals_heading);

		tab_manual.add(_manual_text);
		
		tabbedPane.add("Manual", tab_manual);
		tabbedPane.add("Customers",tab_customers);
		tabbedPane.add("Bikes",tab_bikes);
		tabbedPane.add("Rentals",tab_rentals);
		
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

		GUI _gui = new GUI();
		_gui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		_gui.setSize(800,600);
		_gui.setVisible(true);

		BikeHire _shop = new BikeHire();
		_shop.run();
	}

}
