import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.FlowLayout;

import javax.swing.JTextField;
import javax.swing.BoxLayout;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPasswordField;


@SuppressWarnings({ "serial", "unused" })
public class Bank extends JFrame {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/login";
    static final String USER = "root";
	static final String PASS = "student";
	static Connection conn = null;
	PreparedStatement stmt = null;
	String un, pwd, xyz=null;
	
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bank frame = new Bank();
					frame.setVisible(true);
					
					
					//Class.forName("com.mysql.jdbc.Driver");
					//System.out.println("Connecting to database");
					//conn = DriverManager.getConnection(DB_URL, USER, PASS);
				}
				
				
				
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	
	
	
	
	
	/**
	 * Create the frame.
	 */
	public Bank() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblUsername = new JLabel("Username");
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.anchor = GridBagConstraints.WEST;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 3;
		gbc_lblUsername.gridy = 1;
		contentPane.add(lblUsername, gbc_lblUsername);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 4;
		gbc_textField.gridy = 1;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.WEST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 3;
		gbc_lblPassword.gridy = 2;
		contentPane.add(lblPassword, gbc_lblPassword);
		
		
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
			try {
				  String sql = "INSERT INTO Bank VALUES(?, ?)";
			      Class.forName("com.mysql.jdbc.Driver");
			      System.out.println("Connecting to database");
				  conn = DriverManager.getConnection(DB_URL, USER, PASS);
				  stmt = conn.prepareStatement(sql);
				  un=textField.getText();
			      pwd=passwordField.getText();
			      stmt.setString(1, un);
			      stmt.setString(2, pwd);
			      stmt.execute();
			      System.out.println("The admin approves your registration. Feel privileged.");
			      System.out.print(un+ '\t'+ pwd+ " ");
			      System.out.println("is now a stupid bank user! ");
		       }
			
			     catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			     finally{
				      try{
				         if(stmt!=null)
				            stmt.close();
				      }catch(SQLException se2){
				      }
				      try{
				         if(conn!=null)
				            conn.close();
				      }catch(SQLException se){
				         se.printStackTrace();
				      }
				   }
				
			}
			
		});
		

		
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.BOTH;
		gbc_passwordField.gridx = 4;
		gbc_passwordField.gridy = 2;
		contentPane.add(passwordField, gbc_passwordField);
		GridBagConstraints gbc_btnRegister = new GridBagConstraints();
		gbc_btnRegister.insets = new Insets(0, 0, 5, 5);
		gbc_btnRegister.gridx = 3;
		gbc_btnRegister.gridy = 4;
		contentPane.add(btnRegister, gbc_btnRegister);
		
		
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
		try {
				
				Class.forName("com.mysql.jdbc.Driver");
			    System.out.println("Connecting to database");
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
				un=textField.getText();
				pwd=passwordField.getText();
				String sql= "SELECT PASSWORD FROM Bank WHERE USERNAME = ?";
				stmt = conn.prepareStatement(sql);	
				un=textField.getText();
				stmt.setString(1, un);
				ResultSet rs=stmt.executeQuery();
				if(rs != null)
				{
					
				while(rs.next())
					xyz=rs.getString("password");
				
				if(pwd.equals(xyz)==true)
				{
					System.out.println("Success");
				}
				else System.out.println("Failed login");	
			    }
		   }
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
     finally{
	      try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	      }
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }
	   }
			}
		});
			
		
		
		
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.insets = new Insets(0, 0, 5, 5);
		gbc_btnLogin.gridx = 5;
		gbc_btnLogin.gridy = 4;
		contentPane.add(btnLogin, gbc_btnLogin);
		
		
		
		JButton btnAdminLogin = new JButton("Admin Login");
		btnAdminLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				if (textField.getText().equals("prahlad") && passwordField.getText().equals("12345678"))
					{
					System.out.println("Admin access granted");
					dispose();
					Admin frame1=new Admin();
					frame1.setVisible(true);
					}
				else
				 System.out.println("Stop trying. You're not an admin.");
			}
		});
		
		
		GridBagConstraints gbc_btnAdminLogin = new GridBagConstraints();
		gbc_btnAdminLogin.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdminLogin.gridx = 4;
		gbc_btnAdminLogin.gridy = 5;
		contentPane.add(btnAdminLogin, gbc_btnAdminLogin);
	}

}

	
