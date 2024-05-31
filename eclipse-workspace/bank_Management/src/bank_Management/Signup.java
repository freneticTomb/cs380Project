package bank_Management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import java.awt.Font;
import java.awt.Window;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Component;

public class Signup extends JFrame{
	
	
	//SQL
	Connection conn = null;
	Statement stmt = null;
	public String url = "jdbc:mysql://127.0.0.2:3306/bank_management";
	public String userName = "root";
	public String pass = "password1";

	
	//JFrame
	private JFrame frame;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup window = new Signup();
					
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
	public Signup() {
		initialize();
	}

	Login log = new Login();
	private JTextField textField;
	private JButton btnLogin;

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(25, 25, 25));
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("signup");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setBounds(205, 0, 112, 43);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("enter first and last name, \r\nthen");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(15, 41, 493, 43);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("new username and password");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(15, 74, 493, 43);
		frame.getContentPane().add(lblNewLabel_1_1);

		// First name
		txtFirstName = new JTextField();
		// First name focus
		txtFirstName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtFirstName.getText().equals("first name")) {
					txtFirstName.setText(null);
					txtFirstName.requestFocus();

					log.removePlaceholder(txtFirstName);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtFirstName.getText().length() == 0) {

					log.addPlaceholder(txtFirstName);
					txtFirstName.setText("first name");
				}
			}
		});

		txtFirstName.setHorizontalAlignment(SwingConstants.CENTER);
		txtFirstName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtFirstName.setText("first name");
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(118, 123, 287, 43);
		frame.getContentPane().add(txtFirstName);

		// Last name
		txtLastName = new JTextField();
		// Last name focus
		txtLastName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtLastName.getText().equals("last name")) {
					txtLastName.setText(null);
					txtLastName.requestFocus();

					log.removePlaceholder(txtLastName);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtLastName.getText().length() == 0) {

					log.addPlaceholder(txtLastName);
					txtLastName.setText("last name");
				}
			}
		});

		txtLastName.setText("last name");
		txtLastName.setHorizontalAlignment(SwingConstants.CENTER);
		txtLastName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtLastName.setColumns(10);
		txtLastName.setBounds(118, 177, 287, 43);
		frame.getContentPane().add(txtLastName);

		//Username
		txtUsername = new JTextField();
		// Username focus
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtUsername.getText().equals("username")) {
					txtUsername.setText(null);
					txtUsername.requestFocus();

					log.removePlaceholder(txtUsername);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtUsername.getText().length() == 0) {

					log.addPlaceholder(txtUsername);
					txtUsername.setText("username");
				}
			}
		});

		txtUsername.setText("username");
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtUsername.setColumns(10);
		txtUsername.setBounds(118, 235, 287, 43);
		frame.getContentPane().add(txtUsername);

		
		//Password
		JPasswordField	txtPassword = new JPasswordField();
		//Password Focus
		txtPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtPassword.getText().equals("password")) {
					txtPassword.setText(null);
					txtPassword.requestFocus();
					txtPassword.setEchoChar('●');
					
					log.removePlaceholder(txtPassword);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtPassword.getText().length() == 0) {

					log.addPlaceholder(txtPassword);
					txtPassword.setText("password");
					txtPassword.setEchoChar('\u0000');
					
				}
			}
		});
		
		txtPassword.setText("password");
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 22));
		txtPassword.setColumns(10);
		txtPassword.setBounds(118, 289, 287, 43);
		frame.getContentPane().add(txtPassword);

		
		lblNewLabel_2 = new JLabel("will be saved automatically on");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(15, 353, 493, 43);
		frame.getContentPane().add(lblNewLabel_2);
		
		
		
		
		//Login page redirect button
		btnLogin = new JButton("login page");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

		        String fname = txtFirstName.getText();
		        String lname = txtLastName.getText();
		        String user = txtUsername.getText();
		        String password = txtPassword.getText();
				
				
				
		        boolean error = false;
		        //add user
                try {
                	String sql = "INSERT INTO customer "+
                    		"VALUES('"+user+ "', '" +fname+ "', '" +lname+ "', '" +password + "')";
                	conn = DriverManager.getConnection(url, userName, pass);
					stmt = conn.createStatement();
					stmt.executeUpdate(sql);
					System.out.println("Insert confirmed");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
					error = true;
					
				}			 	
                
                if (error) {
                	frame.dispose();
                	Signup signup = new Signup();
					signup.main(null);
                	
                }
			
                else {
				//redirect
				Login login = new Login();
				login.main(null);
				frame.dispose();
                }
				
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLogin.setForeground(new Color(128, 255, 255));
		btnLogin.setBackground(new Color(240, 240, 240));
		btnLogin.setContentAreaFilled(false);
		btnLogin.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnLogin.setBounds(118, 389, 287, 43);
		frame.getContentPane().add(btnLogin);
		
		
		
		
		
		//frame.getContentPane().add(textField);
		frame.setBounds(100, 100, 539, 482);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}