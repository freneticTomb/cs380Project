package bankManagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class Deposit {

	private JFrame frame;
	private JLabel lblMain_menu;
	private JButton btnCash;
	private JButton btnCheck;

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
		frame.setBounds(100, 100, 549, 365);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDeposit = new JLabel("deposit");
		lblDeposit.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lblDeposit.setForeground(new Color(255, 255, 255));
		lblDeposit.setBackground(new Color(255, 255, 255));
		lblDeposit.setBounds(177, 11, 178, 61);
		frame.getContentPane().add(lblDeposit);
		
		lblMain_menu = new JLabel("main menu");
		lblMain_menu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMain_menu.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblMain_menu.setForeground(new Color(255, 255, 255));
		lblMain_menu.setBounds(147, 280, 203, 35);
		frame.getContentPane().add(lblMain_menu);
		
		btnCash = new JButton("cash");
		btnCash.setFont(new Font("Tahoma", Font.PLAIN, 33));
		btnCash.setBounds(54, 141, 159, 35);
		frame.getContentPane().add(btnCash);
		
		btnCheck = new JButton("check");
		btnCheck.setFont(new Font("Tahoma", Font.PLAIN, 33));
		btnCheck.setBounds(280, 141, 159, 35);
		frame.getContentPane().add(btnCheck);
	}
}