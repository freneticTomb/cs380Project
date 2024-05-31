package bank_Management;

import java.awt.EventQueue;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;


public class Start {
public String url = "jdbc:mysql://127.0.0.2:3306/bank_management";
public String userName = "root";
public String pass = "password1";


	public void connect() {
		//url outline:
			//jdbc:mysql: who knows what that's doing
			//127.0.0.2:3306/ this shows up on the connections list. 
			//it's not the actual name of the project
			//cs380lab3 name of the schema
		/*
		String url = "jdbc:mysql://127.0.0.2:3306/cs380lab3";
		String userName = "root";
		String pass = "password1";
		*/
		
		try {
			//Connect to database
			Connection con = DriverManager.getConnection(url, userName, pass);
			System.out.println("connected");
			
			//Select statement
			String query = "select * from customer";
			
			
			Statement statement = con.createStatement();
			
			ResultSet result = statement.executeQuery(query);
			
			//grab first name example
			/*
			while(result.next()) {
				System.out.println(result.getString("firstName"));
			}
			*/
			
			/*
			String sql = "INSERT INTO 380_grades "+
            		"VALUES(800, 'john', 'adams', 90)";
			statement.executeUpdate(sql);
			*/
			
			JFrame frame;
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

	
	        //Print table
	         while (result.next()) {
	            
	        	//grab variables
	        	String user = result.getString("username");
	            String fname = result.getString("Fname");
	            String lname = result.getString("Lname");
	            String password = result.getString("password");
	      
	          //print and format
	            String format = "%-20s %-20s %-20s %-20s \n";
	            System.out.printf(format, "user", "fname", "lname", "password");
	            System.out.printf(format, user, fname, lname, password);
	         }
	      } catch(SQLException e) {
	         System.out.println("exception " + e.getMessage());
			
	      }
		//	System.out.println("e2 test");
		
				
	
	}
	
	public static void main(String[] args) {
		
		//test
	//	System.out.println("e1 test");
		Start con = new Start();
		
		con.connect();
		
		/*
		JFrame frame;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		*/
		
		
	}
}
