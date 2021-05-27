import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;
import javax.swing.JTextField;

public class MainWindow {
	
	public static BikeHire _shop = new BikeHire();

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
	private JTextField tfFirstName;
	private JTextField tfLastName;
	private JTextField tfEmail;
	private JTextField tfPhone;
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
		frame.setBounds(200, 100, 900, 800);
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
		
		JPanel pManual = new JPanel();
		pManual.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("<html><h4>Manual</html>", null, pManual, null);
		pManual.setLayout(null);
		
		JLabel lblManual = new JLabel("<html><h1>Manual</html>");
		lblManual.setBounds(350, 10, 95, 15);
		pManual.add(lblManual);
		
		JLabel lblNavigateToOther = new JLabel("<html><h1>Navigate to the corresponding tabs <br/>to manage operations.</html>");
		lblNavigateToOther.setBounds(276, 76, 319, 174);
		pManual.add(lblNavigateToOther);
		
		JButton manualQuit = new JButton("Quit");
		manualQuit.setBackground(new Color(255, 99, 71));
		manualQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(1);
			}
		});
		manualQuit.setBounds(300, 650, 230, 35);
		pManual.add(manualQuit);
		
		JPanel pCustomer = new JPanel();
		pCustomer.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("<html><h4>Customers</html>", null, pCustomer, null);
		pCustomer.setLayout(null);
		
		JLabel lblCustomers = new JLabel("<html><h1>Customers</html>");
		lblCustomers.setBounds(350, 10, 150, 20);
		pCustomer.add(lblCustomers);
		
		JLabel lblCustomerRecordsTitle = new JLabel("<html><h2>Customer Records</html>");
		lblCustomerRecordsTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerRecordsTitle.setBounds(90, 50, 170, 50);
		pCustomer.add(lblCustomerRecordsTitle);
		
		JScrollPane spCustomerRecords = new JScrollPane();
		spCustomerRecords.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		spCustomerRecords.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		spCustomerRecords.setBounds(39, 112, 260, 280);
		pCustomer.add(spCustomerRecords);
		
		JLabel lblCustomerRecords = new JLabel(_shop.displayRecords(1));
		spCustomerRecords.setViewportView(lblCustomerRecords);
		lblCustomerRecords.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblCustomerFileTitle = new JLabel("<html><h2>Customer Records in file</html>");
		lblCustomerFileTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerFileTitle.setBounds(570, 35, 200, 70);
		pCustomer.add(lblCustomerFileTitle);
		
		JScrollPane spCustomerFile = new JScrollPane();
		spCustomerFile.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		spCustomerFile.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		spCustomerFile.setBounds(567, 112, 260, 280);
		pCustomer.add(spCustomerFile);
		
		JLabel lblCustomerFile = new JLabel(_shop.readFile(1));
		spCustomerFile.setViewportView(lblCustomerFile);
		lblCustomerFile.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnSaveToFile = new JButton("Save to file");
		btnSaveToFile.setBackground(new Color(0, 206, 209));
		btnSaveToFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				_shop.saveFile(1);
			}
		});
		btnSaveToFile.setBounds(350, 217, 150, 47);
		pCustomer.add(btnSaveToFile);
		
		JButton custQuit = new JButton("Quit");
		custQuit.setBackground(new Color(255, 99, 71));
		custQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(1);
			}
		});
		custQuit.setBounds(300, 650, 230, 35);
		pCustomer.add(custQuit);
		
		JPanel pAddCust = new JPanel();
		pAddCust.setBounds(39, 404, 260, 204);
		pCustomer.add(pAddCust);
		pAddCust.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First name: ");
		lblFirstName.setBounds(12, 39, 130, 15);
		pAddCust.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last name: ");
		lblLastName.setBounds(12, 61, 130, 15);
		pAddCust.add(lblLastName);
		
		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setBounds(12, 83, 130, 15);
		pAddCust.add(lblEmail);
		
		JLabel lblPhone = new JLabel("Phone: ");
		lblPhone.setBounds(12, 105, 130, 15);
		pAddCust.add(lblPhone);
		
		JLabel lblAddCustomer = new JLabel("Add Customer");
		lblAddCustomer.setBounds(89, 12, 114, 15);
		pAddCust.add(lblAddCustomer);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				_shop.addCustomer(tfFirstName.getText(), tfLastName.getText(), tfEmail.getText(), tfPhone.getText());
			}
		});
		btnAdd.setBounds(69, 155, 117, 25);
		pAddCust.add(btnAdd);
		
		tfFirstName = new JTextField();
		tfFirstName.setBounds(99, 37, 110, 20);
		pAddCust.add(tfFirstName);
		tfFirstName.setColumns(10);
		
		tfLastName = new JTextField();
		tfLastName.setBounds(99, 66, 110, 20);
		pAddCust.add(tfLastName);
		tfLastName.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(99, 88, 110, 20);
		pAddCust.add(tfEmail);
		tfEmail.setColumns(10);
		
		tfPhone = new JTextField();
		tfPhone.setBounds(99, 110, 110, 20);
		pAddCust.add(tfPhone);
		tfPhone.setColumns(10);
		
		JPanel pBikes = new JPanel();
		pBikes.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("<html><h4>Bikes</html>", null, pBikes, null);
		pBikes.setLayout(null);
		
		JLabel lblBikes = new JLabel("<html><h1>Bikes</html>");
		lblBikes.setBounds(350, 10, 90, 20);
		pBikes.add(lblBikes);
		
		JLabel lblBikeRecordsTitle = new JLabel("<html><h2>Bike Records</html>");
		lblBikeRecordsTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblBikeRecordsTitle.setBounds(90, 50, 170, 50);
		pBikes.add(lblBikeRecordsTitle);
		
		JLabel lblBikesFile = new JLabel("<html><h2>Bike Records in file</html>");
		lblBikesFile.setHorizontalAlignment(SwingConstants.CENTER);
		lblBikesFile.setBounds(590, 30, 200, 70);
		pBikes.add(lblBikesFile);
		
		JScrollPane spBikeRecords = new JScrollPane();
		spBikeRecords.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		spBikeRecords.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		spBikeRecords.setBounds(39, 112, 260, 280);
		pBikes.add(spBikeRecords);
		
		JLabel lblBikeRecords = new JLabel(_shop.displayAvailableBikes());
		spBikeRecords.setViewportView(lblBikeRecords);
		
		JScrollPane spBikeFile = new JScrollPane();
		spBikeFile.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		spBikeFile.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		spBikeFile.setBounds(567, 112, 260, 280);
		pBikes.add(spBikeFile);
		
		JLabel lblBikeFile = new JLabel(_shop.readFile(2));
		spBikeFile.setViewportView(lblBikeFile);
		
		JButton button = new JButton("Save to file");
		button.setBackground(new Color(0, 206, 209));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				_shop.saveFile(2);
			}
			
		});
		button.setBounds(350, 220, 150, 47);
		pBikes.add(button);
		
		JButton bikesQuit = new JButton("Quit");
		bikesQuit.setBackground(new Color(255, 99, 71));
		bikesQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(1);
			}
		});
		bikesQuit.setBounds(300, 650, 230, 35);
		pBikes.add(bikesQuit);
		
		JPanel pRentals = new JPanel();
		pRentals.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("<html><h4>Rentals</html>", null, pRentals, null);
		pRentals.setLayout(null);
		
		JLabel lblRentals = new JLabel("<html><h1>Rentals</html>");
		lblRentals.setBounds(350, 0, 110, 40);
		pRentals.add(lblRentals);
		
		JLabel lblRentRecordsTitle = new JLabel("<html><h2>Rent Records</html>");
		lblRentRecordsTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblRentRecordsTitle.setBounds(90, 50, 170, 50);
		pRentals.add(lblRentRecordsTitle);
		
		JLabel lblRentFileTitle = new JLabel("<html><h2>Rent File</html>");
		lblRentFileTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblRentFileTitle.setBounds(600, 52, 170, 50);
		pRentals.add(lblRentFileTitle);
		
		JScrollPane spRentRecords = new JScrollPane();
		spRentRecords.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		spRentRecords.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		spRentRecords.setBounds(39, 112, 260, 280);
		pRentals.add(spRentRecords);
		
		JLabel RentRecords = new JLabel(_shop.displayRecords(3));
		spRentRecords.setViewportView(RentRecords);
		
		JScrollPane spRentFile = new JScrollPane();
		spRentFile.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		spRentFile.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		spRentFile.setBounds(567, 110, 260, 280);
		pRentals.add(spRentFile);
		
		JLabel RentFile = new JLabel(_shop.readFile(3));
		RentFile.setBackground(Color.WHITE);
		spRentFile.setViewportView(RentFile);
		
		JButton btnRentsSave = new JButton("Save to file");
		btnRentsSave.setBackground(new Color(0, 206, 209));
		btnRentsSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				_shop.saveFile(3);
			}
		});
		btnRentsSave.setBounds(350, 220, 150, 47);
		pRentals.add(btnRentsSave);
		
		JButton rentsQuit = new JButton("Quit");
		rentsQuit.setBackground(new Color(255, 99, 71));
		rentsQuit.setForeground(new Color(51, 51, 51));
		rentsQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(1);
			}
		});
		rentsQuit.setBounds(300, 650, 230, 35);
		pRentals.add(rentsQuit);
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
}
