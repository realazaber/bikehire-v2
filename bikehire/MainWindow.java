import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JList;
import java.awt.Label;
import java.awt.Scrollbar;

public class MainWindow {
	
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
	JButton _search_bike = new JButton("Search for bike by ID");
	JButton _bikes_quit = new JButton("Quit");

	//Rentals buttons
	JButton _rentals_save = new JButton("Save");
	JButton _rentals_search = new JButton("Search");
	JButton _rentals_add = new JButton("Add new Rental");
	JButton _rentals_return = new JButton("Return");
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

	JScrollPane _scrolling = new JScrollPane();
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

	private JFrame frame;
	private final Action action = new SwingAction();
	private JTable customer_records_table;
	private JTable customer_records_file;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		frame.getContentPane().add(tabbedPane, gbc_tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("<html><h4>Manual</html>", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblManual = new JLabel("<html><h1>Manual</html>");
		lblManual.setBounds(350, 10, 95, 15);
		panel.add(lblManual);
		
		JLabel lblNavigateToOther = new JLabel("<html><h1>Navigate to the corresponding tabs <br/>to manage operations.</html>");
		lblNavigateToOther.setBounds(276, 76, 319, 174);
		panel.add(lblNavigateToOther);
		
		JButton manualQuit = new JButton("Quit");
		manualQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(1);
			}
		});
		manualQuit.setBounds(300, 400, 230, 35);
		panel.add(manualQuit);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("<html><h4>Customers</html>", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblCustomers = new JLabel("<html><h1>Customers</html>");
		lblCustomers.setBounds(350, 10, 150, 20);
		panel_1.add(lblCustomers);
		
		JLabel lblCustomerRecords = new JLabel("<html><h2>Customer Records</html>");
		lblCustomerRecords.setBounds(90, 50, 170, 50);
		panel_1.add(lblCustomerRecords);
		
		JLabel lblCustomerRecordsIn = new JLabel("<html><h2>Customer Records in file</html>");
		lblCustomerRecordsIn.setBounds(570, 35, 200, 70);
		panel_1.add(lblCustomerRecordsIn);
		
		JButton custQuit = new JButton("Quit");
		custQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(1);
			}
		});
		custQuit.setBounds(300, 400, 230, 35);
		panel_1.add(custQuit);
		
		JButton btnSaveToFile = new JButton("Save to file");
		btnSaveToFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				_shop.saveFile(1);
			}
		});
		btnSaveToFile.setBounds(350, 53, 140, 47);
		panel_1.add(btnSaveToFile);
		
		customer_records_table = new JTable();
		customer_records_table.setBounds(12, 112, 330, 180);
		panel_1.add(customer_records_table);
		
		customer_records_file = new JTable();
		customer_records_file.setBounds(498, 112, 330, 180);
		panel_1.add(customer_records_file);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("<html><h4>Rentals</html>", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblRentals = new JLabel("<html><h1>Rentals</html>");
		lblRentals.setBounds(350, 0, 110, 40);
		panel_3.add(lblRentals);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("<html><h4>Bikes</html>", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblBikes = new JLabel("<html><h1>Bikes</html>");
		lblBikes.setBounds(350, 10, 90, 20);
		panel_2.add(lblBikes);
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

		_customer_add.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.out.println("added");
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
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
