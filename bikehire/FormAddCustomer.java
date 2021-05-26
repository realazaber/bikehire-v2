import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class FormAddCustomer {
	
	MainWindow _shop = new MainWindow();


	private JFrame frmAddCustomer;
	private JTextField tfFirstName;
	private JTextField tfLastName;
	private JTextField tfEmail;
	private JTextField tfPhone;

	/**
	 * Launch the application.
	 */
	public static void AddCustomer() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormAddCustomer window = new FormAddCustomer();
					window.frmAddCustomer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FormAddCustomer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddCustomer = new JFrame();
		frmAddCustomer.setTitle("Add Customer");
		frmAddCustomer.setBounds(100, 100, 450, 300);
		frmAddCustomer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAddCustomer.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 10, 10);
		frmAddCustomer.getContentPane().add(panel);
		
		JLabel lblAddCustomer = new JLabel("<html><h2>Add Customer</html>");
		lblAddCustomer.setBounds(152, 28, 157, 26);
		frmAddCustomer.getContentPane().add(lblAddCustomer);
		
		JLabel lblFirstName = new JLabel("First Name: ");
		lblFirstName.setBounds(12, 61, 113, 15);
		frmAddCustomer.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name: ");
		lblLastName.setBounds(12, 83, 113, 15);
		frmAddCustomer.getContentPane().add(lblLastName);
		
		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setBounds(12, 105, 113, 15);
		frmAddCustomer.getContentPane().add(lblEmail);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number: ");
		lblPhoneNumber.setBounds(12, 127, 113, 15);
		frmAddCustomer.getContentPane().add(lblPhoneNumber);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmAddCustomer.dispose();
			}
		});
		btnBack.setBounds(75, 210, 120, 25);
		frmAddCustomer.getContentPane().add(btnBack);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainWindow._shop.addCustomer(tfFirstName.getText(), tfLastName.getText(), tfLastName.getText(), tfPhone.getText());
				
			}
		});
		btnAdd.setBounds(250, 210, 120, 25);
		frmAddCustomer.getContentPane().add(btnAdd);
		
		tfFirstName = new JTextField();
		tfFirstName.setBounds(152, 57, 114, 19);
		frmAddCustomer.getContentPane().add(tfFirstName);
		tfFirstName.setColumns(10);
		
		tfLastName = new JTextField();
		tfLastName.setBounds(152, 79, 114, 19);
		frmAddCustomer.getContentPane().add(tfLastName);
		tfLastName.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(152, 101, 114, 19);
		frmAddCustomer.getContentPane().add(tfEmail);
		tfEmail.setColumns(10);
		
		tfPhone = new JTextField();
		tfPhone.setBounds(152, 125, 114, 19);
		frmAddCustomer.getContentPane().add(tfPhone);
		tfPhone.setColumns(10);
	}
}
