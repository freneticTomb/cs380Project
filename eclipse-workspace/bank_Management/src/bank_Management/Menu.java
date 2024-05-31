package bank_Management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu {

	
	private JFrame frame;
	private JButton btnDeposit;
	private JButton btnWithdraw;
	private JButton btnTransactionHistory;
	private JButton btnTransactionHistory_1;
	private JButton btnChecking;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//use(username);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Login login = new Login();
		login.getUsername();
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(25, 25, 25));
		frame.setBounds(100, 100, 549, 409);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDeposit = new JLabel("Menu");
		lblDeposit.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeposit.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblDeposit.setForeground(new Color(255, 255, 255));
		lblDeposit.setBackground(new Color(255, 255, 255));
		lblDeposit.setBounds(177, 0, 178, 61);
		frame.getContentPane().add(lblDeposit);
		
		btnDeposit = new JButton("deposit");
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Deposit deposit = new Deposit();
				deposit.main(null);
				
			}
		});
		btnDeposit.setFont(new Font("Tahoma", Font.PLAIN, 33));
		btnDeposit.setBounds(51, 105, 159, 35);
		frame.getContentPane().add(btnDeposit);
		
		btnWithdraw = new JButton("withdraw");
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Withdraw withdraw = new Withdraw();
				withdraw.main(null);
			}
		});
		btnWithdraw.setFont(new Font("Tahoma", Font.PLAIN, 33));
		btnWithdraw.setBounds(280, 105, 184, 35);
		frame.getContentPane().add(btnWithdraw);
		
		btnTransactionHistory = new JButton("transaction \r\nhistory");
		btnTransactionHistory.setVerticalAlignment(SwingConstants.TOP);
		btnTransactionHistory.setFont(new Font("Tahoma", Font.PLAIN, 33));
		btnTransactionHistory.setBounds(51, 164, 301, 49);
		frame.getContentPane().add(btnTransactionHistory);
		
		
		//Write/Deposit a check
		btnChecking = new JButton("check");
		btnChecking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnChecking.setFont(new Font("Tahoma", Font.PLAIN, 33));
		btnChecking.setBounds(51, 239, 159, 35);
		frame.getContentPane().add(btnChecking);
		
		
		// Exit to login
		JButton btnNewButton = new JButton("exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Login login = new Login();
				login.main(null);
			}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setForeground(new Color(128, 255, 255));
		btnNewButton.setBackground(new Color(240, 240, 240));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnNewButton.setBounds(199, 311, 130, 35);
		frame.getContentPane().add(btnNewButton);
		
		
	}

	public String use(String username) {
		System.out.println(username);
		return username;
		
	}
	
}