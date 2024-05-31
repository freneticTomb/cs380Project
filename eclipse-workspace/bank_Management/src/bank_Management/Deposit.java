package bank_Management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Deposit {

	
	
	
	Connection conn = null;
	Statement stmt = null;
	public String url = "jdbc:mysql://127.0.0.2:3306/bank_management";
	public String userName = "root";
	public String pass = "password1";

	private JFrame frame;
	private JButton btnCash;
	private JButton btnCheck;
	private JButton btnExit;
	private JTextField txtUser;
	private JTextField txtCashAmount;
	private JTextField txtCash;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deposit window = new Deposit();
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
	public Deposit() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(25, 25, 25));
		frame.setBounds(100, 100, 549, 434);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblDeposit = new JLabel("deposit");
		lblDeposit.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lblDeposit.setForeground(new Color(255, 255, 255));
		lblDeposit.setBackground(new Color(255, 255, 255));
		lblDeposit.setBounds(190, 11, 153, 61);
		frame.getContentPane().add(lblDeposit);

		btnCheck = new JButton("check");
		btnCheck.setFont(new Font("Tahoma", Font.PLAIN, 33));
		btnCheck.setBounds(317, 141, 159, 35);
		frame.getContentPane().add(btnCheck);

		JButton btnMainMenu = new JButton("main menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Menu menu = new Menu();
				menu.main(null);
			}
		});
		btnMainMenu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMainMenu.setForeground(new Color(128, 255, 255));
		btnMainMenu.setBackground(new Color(240, 240, 240));
		btnMainMenu.setContentAreaFilled(false);
		btnMainMenu.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnMainMenu.setBounds(201, 267, 130, 35);
		frame.getContentPane().add(btnMainMenu);

		btnExit = new JButton("exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Login login = new Login();
				login.main(null);
			}
		});
		btnExit.setForeground(new Color(128, 255, 255));
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnExit.setContentAreaFilled(false);
		btnExit.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnExit.setBackground(UIManager.getColor("Button.background"));
		btnExit.setBounds(201, 328, 130, 35);
		frame.getContentPane().add(btnExit);

		Login log = new Login();

		txtUser = new JTextField();
		txtUser.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtUser.getText().equals("username")) {
					txtUser.setText(null);

					log.removePlaceholder(txtUser);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtUser.getText().length() == 0) {

					log.addPlaceholder(txtUser);
					txtUser.setText("username");
				}
			}
		});

		txtUser.setFont(new Font("Tahoma", Font.PLAIN, 29));
		txtUser.setText("username");
		txtUser.setBounds(184, 87, 159, 43);
		frame.getContentPane().add(txtUser);
		txtUser.setColumns(10);

		txtCashAmount = new JTextField();
		txtCashAmount.setFont(new Font("Tahoma", Font.PLAIN, 35));
		txtCashAmount.setText("cash");
		txtCashAmount.setColumns(10);
		txtCashAmount.setBounds(23, 137, 159, 43);
		frame.getContentPane().add(txtCashAmount);

		txtCashAmount.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtCashAmount.getText().equals("cash")) {
					txtCashAmount.setText(null);

					log.removePlaceholder(txtCashAmount);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtCashAmount.getText().length() == 0) {

					log.addPlaceholder(txtCashAmount);
					txtCashAmount.setText("cash");
				}
			}
		});

		// Submit payment
		btnCash = new JButton("submit");
		btnCash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String user = txtUser.getText();
				String cash = txtCashAmount.getText();
				int cash1 = Integer.valueOf(cash);
				
				boolean error = false;
				// add user
				try {
					/*
					String sql = "UPDATE transactions SET transfers = transfers + "+cash1+ 
							"WHERE user = '"+user+"'";
							*/
					String user = txtUser.getText();
					System.out.println(user);
					String sql = "UPDATE transactions SET transfers = transfers + "+cash1;
					
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
					Deposit deposit = new Deposit();
					deposit.main(null);

				}

				else {
					JOptionPane.showInputDialog(this, "successful transfer");
				}

			}
		});

		btnCash.setFont(new Font("Tahoma", Font.PLAIN, 33));
		btnCash.setBounds(23, 191, 159, 35);
		frame.getContentPane().add(btnCash);

	}
}