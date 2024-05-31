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
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import java.awt.ComponentOrientation;
import java.awt.Component;
import javax.swing.border.BevelBorder;
import java.awt.Dimension;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;

public class Withdraw {


	Connection conn = null;
	Statement stmt = null;
	public String url = "jdbc:mysql://127.0.0.2:3306/bank_management";
	public String userName = "root";
	public String pass = "password1";
	
	
	private JFrame frame;
	private JTextField txtCustom;
	private JLabel lblAmount;
	private JButton btnMenu;
	private JButton btnExit;
	private JButton btnSubmit;
	private JTextField txtUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Withdraw window = new Withdraw();
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
	public Withdraw() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(25, 25, 25));
		frame.setBounds(100, 100, 549, 427);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		
		btnSubmit = new JButton("submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cash = txtCustom.getText();
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
					String sql = "UPDATE transactions SET transfers = transfers - "+cash1;
					
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
		btnSubmit.setForeground(new Color(128, 255, 255));
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSubmit.setContentAreaFilled(false);
		btnSubmit.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnSubmit.setBackground(UIManager.getColor("Button.background"));
		btnSubmit.setBounds(182, 236, 130, 35);
		frame.getContentPane().add(btnSubmit);
		
		txtUser = new JTextField();
		Login log = new Login();
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
		txtUser.setText("username");
		txtUser.setFont(new Font("Tahoma", Font.PLAIN, 29));
		txtUser.setColumns(10);
		txtUser.setBounds(172, 175, 159, 43);
		frame.getContentPane().add(txtUser);
		
		
		
		JLabel lblWithdraw = new JLabel("withdraw");
		lblWithdraw.setHorizontalAlignment(SwingConstants.CENTER);
		lblWithdraw.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lblWithdraw.setForeground(new Color(255, 255, 255));
		lblWithdraw.setBackground(new Color(255, 255, 255));
		lblWithdraw.setBounds(143, 11, 246, 61);
		frame.getContentPane().add(lblWithdraw);
		
		txtCustom = new JTextField();
		txtCustom.setFont(new Font("Tahoma", Font.PLAIN, 27));
		txtCustom.setBounds(182, 75, 191, 35);
		frame.getContentPane().add(txtCustom);
		txtCustom.setColumns(10);
		
		lblAmount = new JLabel("amount:");
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblAmount.setVerticalAlignment(SwingConstants.TOP);
		lblAmount.setVerticalTextPosition(SwingConstants.TOP);
		lblAmount.setHorizontalAlignment(SwingConstants.LEFT);
		lblAmount.setAlignmentY(Component.TOP_ALIGNMENT);
		lblAmount.setOpaque(true);
		lblAmount.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblAmount.setBounds(new Rectangle(10, 12, 12, 12));
		lblAmount.setForeground(new Color(255, 255, 255));
		lblAmount.setBackground(new Color(45, 45, 45));
		lblAmount.setBounds(78, 67, 367, 216);
		frame.getContentPane().add(lblAmount);
		
		
		
		btnMenu = new JButton("menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Menu menu = new Menu();
				menu.main(null);
			}
		});
		btnMenu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnMenu.setForeground(new Color(128, 255, 255));
		btnMenu.setBackground(new Color(240, 240, 240));
		btnMenu.setContentAreaFilled(false);
		btnMenu.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnMenu.setBounds(201, 296, 130, 35);
		frame.getContentPane().add(btnMenu);
		
		btnExit = new JButton("exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Login login = new Login();
				login.main(null);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnExit.setForeground(new Color(128, 255, 255));
		btnExit.setBackground(new Color(240, 240, 240));
		btnExit.setContentAreaFilled(false);
		btnExit.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnExit.setBounds(201, 342, 130, 35);
		frame.getContentPane().add(btnExit);
	}
}