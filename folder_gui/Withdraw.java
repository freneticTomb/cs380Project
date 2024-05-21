package bankManagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import java.awt.ComponentOrientation;
import java.awt.Component;
import javax.swing.border.BevelBorder;
import java.awt.Dimension;
import javax.swing.border.MatteBorder;

public class Withdraw {

	private JFrame frame;
	private JLabel lblMain_menu;
	private JButton btn$10;
	private JTextField txtCustom;
	private JButton btn$20;
	private JButton btn$50;
	private JButton btn$100;
	private JLabel lblAmount;

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
		frame.setBounds(100, 100, 549, 365);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWithdraw = new JLabel("withdraw");
		lblWithdraw.setHorizontalAlignment(SwingConstants.CENTER);
		lblWithdraw.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lblWithdraw.setForeground(new Color(255, 255, 255));
		lblWithdraw.setBackground(new Color(255, 255, 255));
		lblWithdraw.setBounds(143, 11, 246, 61);
		frame.getContentPane().add(lblWithdraw);
		
		lblMain_menu = new JLabel("main menu");
		lblMain_menu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMain_menu.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblMain_menu.setForeground(new Color(255, 255, 255));
		lblMain_menu.setBounds(165, 280, 203, 35);
		frame.getContentPane().add(lblMain_menu);
		
		btn$10 = new JButton("$10");
		btn$10.setBorderPainted(false);
		btn$10.setForeground(new Color(255, 255, 255));
		btn$10.setBackground(new Color(0, 0, 0));
		btn$10.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		btn$10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btn$10.setFont(new Font("Tahoma", Font.PLAIN, 33));
		btn$10.setBounds(287, 130, 129, 29);
		frame.getContentPane().add(btn$10);
		
		txtCustom = new JTextField();
		txtCustom.setFont(new Font("Tahoma", Font.PLAIN, 27));
		txtCustom.setText("custom:");
		txtCustom.setBounds(254, 84, 191, 35);
		frame.getContentPane().add(txtCustom);
		txtCustom.setColumns(10);
		
		btn$20 = new JButton("$20");
		btn$20.setForeground(new Color(255, 255, 255));
		btn$20.setBorderPainted(false);
		btn$20.setBackground(new Color(0, 0, 0));
		btn$20.setFont(new Font("Tahoma", Font.PLAIN, 33));
		btn$20.setBounds(287, 170, 129, 29);
		frame.getContentPane().add(btn$20);
		
		btn$50 = new JButton("$50");
		btn$50.setForeground(new Color(255, 255, 255));
		btn$50.setBackground(new Color(0, 0, 0));
		btn$50.setBorderPainted(false);
		btn$50.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn$50.setFont(new Font("Tahoma", Font.PLAIN, 33));
		btn$50.setBounds(287, 210, 129, 29);
		frame.getContentPane().add(btn$50);
		
		btn$100 = new JButton("$100");
		btn$100.setBorderPainted(false);
		btn$100.setForeground(new Color(255, 255, 255));
		btn$100.setBackground(new Color(0, 0, 0));
		btn$100.setFont(new Font("Tahoma", Font.PLAIN, 33));
		btn$100.setBounds(287, 250, 129, 29);
		frame.getContentPane().add(btn$100);
		
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
	}
}