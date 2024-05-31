package bank_Management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowFocusListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.WindowEvent;

import java.awt.Component;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;

public class Login extends JFrame {
	
	public String username;

	public String url = "jdbc:mysql://127.0.0.2:3306/bank_management";
	public String userName = "root";
	public String pass = "password1";

	JFrame frame;

	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JLabel login_instructions;
	// private JTextField txtUsername1;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
		addPlaceholder(txtUsername);
		addPlaceholder(txtPassword);
		

		// Get username and password
		


		// Login button
		// Login attempt
		JButton btnNewButton = new JButton("login");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {

				username = txtUsername.getText();
	
				try {
					Connection con = DriverManager.getConnection(url, userName, pass);
					Statement statement = con.createStatement();

					username = txtUsername.getText();
					String password = txtPassword.getText();
					String sql = "SELECT * FROM customer WHERE username ='" + username + "' AND password = '" + password
							+ "'";

					
					ResultSet rs = statement.executeQuery(sql);

					// Correct username and password
					if (rs.next()) {
						
						frame.dispose();

						Menu menu = new Menu();
						String saved = menu.use(username);
						
						menu.main(null);
					}
					// Wrong username or password
					else {
						JOptionPane.showInputDialog(this, "false credentials");
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setForeground(new Color(128, 255, 255));
		btnNewButton.setBackground(new Color(240, 240, 240));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton.setBounds(201, 267, 130, 35);
		frame.getContentPane().add(btnNewButton);

		// Signup button
		JButton btnSignUpInstead = new JButton("sign up instead");
		btnSignUpInstead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Signup sign = new Signup();
				sign.main(null);
				frame.dispose();

			}
		});
		btnSignUpInstead.setForeground(new Color(128, 255, 255));
		btnSignUpInstead.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSignUpInstead.setContentAreaFilled(false);
		btnSignUpInstead.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnSignUpInstead.setBackground(UIManager.getColor("Button.background"));
		btnSignUpInstead.setBounds(187, 323, 159, 35);
		frame.getContentPane().add(btnSignUpInstead);
		
		login_instructions = new JLabel("enter username and password");
		login_instructions.setForeground(Color.WHITE);
		login_instructions.setFont(new Font("Tahoma", Font.PLAIN, 30));
		login_instructions.setBackground(Color.WHITE);
		login_instructions.setBounds(65, 72, 403, 37);
		frame.getContentPane().add(login_instructions);

	}

	// Placeholder text add and remove
	public void addPlaceholder(JTextField textField) {
		Font font = textField.getFont();
		font = font.deriveFont(Font.ITALIC);
		textField.setFont(font);
		textField.setForeground(Color.gray);

	}

	public void removePlaceholder(JTextField textField) {
		Font font = textField.getFont();
		font = font.deriveFont(Font.PLAIN);
		textField.setFont(font);
		textField.setForeground(Color.black);

	}

	

	// Username getter
	public String getUsername() {
		
		System.out.println(username);
	
		return txtUsername.getText();
	}
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		

		frame.getContentPane().setBackground(new Color(25, 25, 25));
		frame.setBounds(100, 100, 549, 408);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setBounds(201, 0, 130, 61);
		frame.getContentPane().add(lblNewLabel);

		txtUsername = new JTextField();

		// Username focus
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtUsername.getText().equals("username")) {
					txtUsername.setText(null);
				//	txtUsername.requestFocus();

					removePlaceholder(txtUsername);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtUsername.getText().length() == 0) {

					addPlaceholder(txtUsername);
					txtUsername.setText("username");
				}
			}
		});

		txtUsername.setDisabledTextColor(new Color(192, 192, 192));
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsername.setText("username");
		txtUsername.setBounds(187, 120, 159, 43);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);

		txtPassword = new JPasswordField();
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 30));

		// Password Focus
		txtPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtPassword.getText().equals("password")) {
					txtPassword.setText(null);
					txtPassword.requestFocus();

					txtPassword.setEchoChar('●');
					removePlaceholder(txtPassword);
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtPassword.getText().length() == 0) {

					addPlaceholder(txtPassword);
					txtPassword.setText("password");
					txtPassword.setEchoChar('\u0000');

				}
			}
		});

		txtPassword.setEchoChar('\u0000');
		txtPassword.setText("password");
		txtPassword.setBounds(187, 188, 159, 43);
		frame.getContentPane().add(txtPassword);
	}
}