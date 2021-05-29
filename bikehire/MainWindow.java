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
import javax.swing.border.LineBorder;
import javax.swing.JCheckBox;


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
	private JTextField tfCustId;
	private JTextField tfAddress;
	private JTextField tfBikeID;
	private JTextField tfBikeName;
	private JTextField tfRentStatus;
	private JTextField tfBikeType;
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
		
		JPanel pCustomerSearchResult = new JPanel();
		pCustomerSearchResult.setBorder(new LineBorder(Color.BLACK));
		pCustomerSearchResult.setBounds(40, 500, 300, 139);
		pCustomer.add(pCustomerSearchResult);

		pCustomerSearchResult.setLayout(null);
		
		JLabel lblFirstName_1 = new JLabel("First Name: ");
		lblFirstName_1.setBounds(0, 0, 0, 0);
		pCustomerSearchResult.add(lblFirstName_1);
		
		JLabel lblLastName_1 = new JLabel("Last Name: ");
		lblLastName_1.setBounds(0, 0, 0, 0);
		pCustomerSearchResult.add(lblLastName_1);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number: ");
		lblPhoneNumber.setBounds(0, 0, 0, 0);
		pCustomerSearchResult.add(lblPhoneNumber);
		
		JLabel lblEmail_1 = new JLabel("Email: ");
		lblEmail_1.setBounds(0, 0, 0, 0);
		pCustomerSearchResult.add(lblEmail_1);
		
		JLabel lblAddress = new JLabel("Address: ");
		lblAddress.setBounds(0, 0, 0, 0);
		pCustomerSearchResult.add(lblAddress);
		
		JLabel lblCustomerName = new JLabel("Customer Name:");
		lblCustomerName.setBounds(12, 25, 130, 15);
		pCustomerSearchResult.add(lblCustomerName);
		
		JLabel lblCustomerPhone = new JLabel("Customer Phone: ");
		lblCustomerPhone.setBounds(12, 50, 130, 15);
		pCustomerSearchResult.add(lblCustomerPhone);
		
		JLabel lblCustomerEmail = new JLabel("Customer Email: ");
		lblCustomerEmail.setBounds(12, 80, 130, 15);
		pCustomerSearchResult.add(lblCustomerEmail);
		
		JLabel lblCustomerAddress = new JLabel("Customer Address: ");
		lblCustomerAddress.setBounds(12, 110, 150, 15);
		pCustomerSearchResult.add(lblCustomerAddress);
		
		JLabel lblCustNameOutPut = new JLabel("");
		lblCustNameOutPut.setBounds(149, 25, 130, 15);
		pCustomerSearchResult.add(lblCustNameOutPut);
		
		JLabel lblCustPhoneOutPut = new JLabel("");
		lblCustPhoneOutPut.setBounds(150, 50, 130, 15);
		pCustomerSearchResult.add(lblCustPhoneOutPut);
		
		JLabel lblCustEmailOutput = new JLabel("");
		lblCustEmailOutput.setBounds(149, 80, 130, 15);
		pCustomerSearchResult.add(lblCustEmailOutput);
		
		JLabel lblCustAddressOutput = new JLabel("");
		lblCustAddressOutput.setBounds(149, 110, 130, 15);
		pCustomerSearchResult.add(lblCustAddressOutput);
		
		JLabel lblSearchCustomerId = new JLabel("Customer ID: ");
		lblSearchCustomerId.setBounds(12, 0, 100, 15);
		pCustomerSearchResult.add(lblSearchCustomerId);
		
		JLabel lblCustomerIDOutput = new JLabel("");
		lblCustomerIDOutput.setBounds(124, 0, 70, 15);
		pCustomerSearchResult.add(lblCustomerIDOutput);
		
		JPanel pCustomerSearch = new JPanel();
		pCustomerSearch.setBorder(new LineBorder(Color.BLACK));
		pCustomerSearch.setBounds(40, 404, 300, 204);
		pCustomer.add(pCustomerSearch);
		pCustomerSearch.setLayout(null);
		
		JLabel lblSearchForCustomer = new JLabel("Search for Customer");
		lblSearchForCustomer.setBounds(60, 10, 160, 15);
		pCustomerSearch.add(lblSearchForCustomer);
		
		JLabel lblCustomerId = new JLabel("Customer ID:");
		lblCustomerId.setBounds(12, 40, 100, 20);
		pCustomerSearch.add(lblCustomerId);
		
		tfCustId = new JTextField();
		tfCustId.setBounds(105, 40, 40, 19);
		pCustomerSearch.add(tfCustId);
		tfCustId.setColumns(10);
		
		JButton btnCustomerSearch = new JButton("Search");
		btnCustomerSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int _id = Integer.parseInt(tfCustId.getText());
	
				//String custFirstName = _shop.searchForCustomer(_id);
				String[] _array = _shop.searchRecords(1, _id);
				lblCustomerIDOutput.setText(_array[0]);
				lblCustNameOutPut.setText(_array[1] + " " + _array[2]);
				lblCustPhoneOutPut.setText(_array[3]);
				lblCustEmailOutput.setText(_array[4]);
				lblCustAddressOutput.setText(_array[5]);
				
				
				
			}
		});
		btnCustomerSearch.setBackground(Color.ORANGE);
		btnCustomerSearch.setBounds(157, 38, 90, 25);
		pCustomerSearch.add(btnCustomerSearch);
		
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
		spCustomerRecords.setBounds(39, 112, 300, 280);
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
		spCustomerFile.setBounds(567, 112, 300, 280);
		pCustomer.add(spCustomerFile);
		
		JLabel lblCustomerFile = new JLabel(_shop.readFile(1));
		spCustomerFile.setViewportView(lblCustomerFile);
		lblCustomerFile.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnSaveToCustomers = new JButton("Save to file");
		btnSaveToCustomers.setBackground(new Color(0, 206, 209));
		btnSaveToCustomers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				_shop.saveFile(1);
				lblCustomerFile.setText(_shop.readFile(1));
				
			}
		});
		btnSaveToCustomers.setBounds(370, 130, 150, 47);
		pCustomer.add(btnSaveToCustomers);
		
		JButton custQuit = new JButton("Quit");
		custQuit.setBackground(new Color(255, 99, 71));
		custQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(1);
			}
		});
		custQuit.setBounds(320, 650, 230, 35);
		pCustomer.add(custQuit);
		
		JPanel pAddCust = new JPanel();
		pAddCust.setBorder(new LineBorder(Color.BLACK));
		pAddCust.setBounds(570, 404, 300, 220);
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
		lblAddCustomer.setBounds(90, 10, 115, 15);
		pAddCust.add(lblAddCustomer);
		
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
		
		JLabel lblAddress_1 = new JLabel("Address: ");
		lblAddress_1.setBounds(12, 132, 70, 15);
		pAddCust.add(lblAddress_1);
		
		tfAddress = new JTextField();
		tfAddress.setBounds(99, 132, 114, 19);
		pAddCust.add(tfAddress);
		tfAddress.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(new Color(0, 255, 127));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tfFirstName.getText() != null && tfLastName.getText() != null && tfEmail.getText() != null && tfPhone.getText() != null && tfAddress.getText() != null) {
						
				_shop.addCustomer(tfFirstName.getText(), tfLastName.getText(), tfEmail.getText(), tfPhone.getText(), tfAddress.getText());
				lblCustomerRecords.setText(_shop.displayRecords(1));
				}
				else {
					System.out.println("fill in all info");
				}
			}
		});
		btnAdd.setBounds(69, 175, 117, 25);
		pAddCust.add(btnAdd);
		
		JButton btnClearCustomerFIle = new JButton("Clear file");
		btnClearCustomerFIle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				_shop.clearFile(1);
				lblCustomerFile.setText(_shop.readFile(1));
				
			}
		});
		btnClearCustomerFIle.setBackground(new Color(250, 128, 114));
		btnClearCustomerFIle.setBounds(450, 250, 100, 47);
		pCustomer.add(btnClearCustomerFIle);
		
		JButton btnClearCustomerRecords = new JButton("<html>Clear<br/> Records</html>");
		btnClearCustomerRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				_shop.clearRecords(1);
				lblCustomerRecords.setText(_shop.displayRecords(1));
			}
		});
		btnClearCustomerRecords.setBackground(new Color(250, 128, 114));
		btnClearCustomerRecords.setBounds(345, 250, 100, 47);
		pCustomer.add(btnClearCustomerRecords);
		
		

		
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
		spBikeRecords.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		spBikeRecords.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		spBikeRecords.setBounds(39, 112, 282, 280);
		pBikes.add(spBikeRecords);
		
		JLabel lblBikeRecords = new JLabel(_shop.displayRecords(2));
		spBikeRecords.setViewportView(lblBikeRecords);
		
		JScrollPane spBikeFile = new JScrollPane();
		spBikeFile.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		spBikeFile.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		spBikeFile.setBounds(567, 112, 300, 280);
		pBikes.add(spBikeFile);
		
		JLabel lblBikeFile = new JLabel(_shop.readFile(2));
		spBikeFile.setViewportView(lblBikeFile);
		
		JButton btnSaveToBikes = new JButton("Save to file");
		btnSaveToBikes.setBackground(new Color(0, 206, 209));
		btnSaveToBikes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				_shop.saveFile(2);
				lblBikeFile.setText(_shop.readFile(2));
			}
			
		});
		btnSaveToBikes.setBounds(370, 130, 150, 47);
		pBikes.add(btnSaveToBikes);
		
		JButton bikesQuit = new JButton("Quit");
		bikesQuit.setBackground(new Color(255, 99, 71));
		bikesQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(1);
			}
		});
		bikesQuit.setBounds(300, 650, 230, 35);
		pBikes.add(bikesQuit);
		
		JButton btnClearBikeRecords = new JButton("<html>Clear<br/>Records</html>");
		btnClearBikeRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				_shop.clearRecords(2);
				lblBikeRecords.setText(_shop.displayRecords(2));
				
			}
		});
		btnClearBikeRecords.setBackground(new Color(250, 128, 114));
		btnClearBikeRecords.setBounds(345, 250, 100, 47);
		pBikes.add(btnClearBikeRecords);
		
		JButton btnClearBikeFile = new JButton("Clear file");
		btnClearBikeFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				_shop.clearFile(2);
				lblBikeFile.setText(_shop.readFile(2));
				
			}
		});
		btnClearBikeFile.setBackground(new Color(250, 128, 114));
		btnClearBikeFile.setBounds(450, 250, 100, 47);
		pBikes.add(btnClearBikeFile);
		
		JPanel pSearchBikes = new JPanel();
		pSearchBikes.setBorder(new LineBorder(new Color(0, 0, 0)));
		pSearchBikes.setBounds(39, 404, 280, 223);
		pBikes.add(pSearchBikes);
		pSearchBikes.setLayout(null);
		
		JPanel pBikeSearchResult = new JPanel();
		pBikeSearchResult.setBorder(new LineBorder(Color.BLACK));
		pBikeSearchResult.setBounds(0, 73, 280, 150);
		pSearchBikes.add(pBikeSearchResult);
		pBikeSearchResult.setLayout(null);
		
		JLabel lblBikeID = new JLabel("Bike ID: ");
		lblBikeID.setBounds(12, 12, 80, 20);
		pBikeSearchResult.add(lblBikeID);
		
		JLabel lblBikeName = new JLabel("Bike Name: ");
		lblBikeName.setBounds(12, 39, 100, 15);
		pBikeSearchResult.add(lblBikeName);
		
		JLabel lblRentStatus = new JLabel("Rent Status: ");
		lblRentStatus.setBounds(12, 60, 130, 20);
		pBikeSearchResult.add(lblRentStatus);
		
		JLabel lblBikeIDOutput = new JLabel("");
		lblBikeIDOutput.setBounds(104, 15, 70, 15);
		pBikeSearchResult.add(lblBikeIDOutput);
		
		JLabel lblBikeNameOutput = new JLabel("");
		lblBikeNameOutput.setBounds(104, 39, 120, 15);
		pBikeSearchResult.add(lblBikeNameOutput);
		
		JLabel lblBikeRentStatusOutput = new JLabel("");
		lblBikeRentStatusOutput.setBounds(104, 63, 70, 15);
		pBikeSearchResult.add(lblBikeRentStatusOutput);
		
		JLabel lblTypeBike = new JLabel("Bike Type: ");
		lblTypeBike.setBounds(12, 85, 100, 20);
		pBikeSearchResult.add(lblTypeBike);
		
		JLabel lblBikeTypeOutput = new JLabel("");
		lblBikeTypeOutput.setBounds(104, 88, 70, 15);
		pBikeSearchResult.add(lblBikeTypeOutput);
		
		JLabel lblSearchBikePrice = new JLabel("Price per day");
		lblSearchBikePrice.setBounds(12, 117, 100, 20);
		pBikeSearchResult.add(lblSearchBikePrice);
		
		JLabel lblBikePriceOutput = new JLabel("");
		lblBikePriceOutput.setBounds(114, 122, 70, 15);
		pBikeSearchResult.add(lblBikePriceOutput);
		
		JLabel lblSearchForBike = new JLabel("Search for bike");
		lblSearchForBike.setBounds(70, 10, 160, 15);
		pSearchBikes.add(lblSearchForBike);
		
		JLabel lblBikeId = new JLabel("Bike ID: ");
		lblBikeId.setBounds(10, 38, 70, 20);
		pSearchBikes.add(lblBikeId);
		
		tfBikeID = new JTextField();
		tfBikeID.setBounds(70, 40, 40, 19);
		pSearchBikes.add(tfBikeID);
		tfBikeID.setColumns(10);
		
		JButton btnSearchBike = new JButton("Search");
		btnSearchBike.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int _id = Integer.parseInt(tfBikeID.getText());
				String[] _array = _shop.searchRecords(2, _id);
				lblBikeIDOutput.setText(_array[0]);
				lblBikeNameOutput.setText(_array[1]);
				lblBikeRentStatusOutput.setText(_array[2]);
				lblBikeTypeOutput.setText(_array[3]);
				lblBikePriceOutput.setText(_array[4]);
			}
		});
		btnSearchBike.setBackground(Color.ORANGE);
		btnSearchBike.setBounds(120, 36, 90, 25);
		pSearchBikes.add(btnSearchBike);
		
		JPanel pAddBike = new JPanel();
		pAddBike.setBorder(new LineBorder(Color.BLACK));
		pAddBike.setBounds(570, 404, 300, 220);
		pBikes.add(pAddBike);
		pAddBike.setLayout(null);
		
		JLabel lblAddBike = new JLabel("Add Bike");
		lblAddBike.setBounds(100, 10, 115, 15);
		pAddBike.add(lblAddBike);
		
		JLabel lblBikeName_1 = new JLabel("Bike Name: ");
		lblBikeName_1.setBounds(40, 39, 90, 15);
		pAddBike.add(lblBikeName_1);
		
		JLabel lblRentStatus_1 = new JLabel("Rent Status: ");
		lblRentStatus_1.setBounds(40, 87, 100, 20);
		pAddBike.add(lblRentStatus_1);
		
		JButton btnAddBike = new JButton("Add");
		btnAddBike.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (tfBikeName != null && tfBikeType != null && tfRentStatus != null) {
					boolean _rentStatus;
					if (tfRentStatus.getText() == "true") {
						_rentStatus = true;
					}
					else {
						_rentStatus = false;
					}
				_shop.addBike(tfBikeType.getText(), tfBikeName.getText(), _rentStatus, "Full Power", 10);
				lblBikeRecords.setText(_shop.displayRecords(2));
				}
				else {
					System.out.println("fill in all info");
				}
			}
		});
		btnAddBike.setBackground(new Color(0, 255, 127));
		btnAddBike.setBounds(60, 175, 117, 25);
		pAddBike.add(btnAddBike);
		
		tfBikeName = new JTextField();
		tfBikeName.setBounds(140, 37, 114, 19);
		pAddBike.add(tfBikeName);
		tfBikeName.setColumns(10);
		
		tfRentStatus = new JTextField();
		tfRentStatus.setBounds(140, 90, 114, 19);
		pAddBike.add(tfRentStatus);
		tfRentStatus.setColumns(10);
		
		JLabel lblBikeType = new JLabel("Bike Type: ");
		lblBikeType.setBounds(40, 60, 100, 15);
		pAddBike.add(lblBikeType);
		
		tfBikeType = new JTextField();
		tfBikeType.setBounds(140, 58, 114, 19);
		pAddBike.add(tfBikeType);
		tfBikeType.setColumns(10);
		
		JCheckBox cbFullPower = new JCheckBox("");
		cbFullPower.setBounds(140, 121, 30, 23);
		pAddBike.add(cbFullPower);
		
		JLabel lblFullPowered = new JLabel("Full powered: ");
		lblFullPowered.setBounds(40, 125, 110, 15);
		pAddBike.add(lblFullPowered);
		
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
