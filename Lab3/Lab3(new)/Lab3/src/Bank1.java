import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@SuppressWarnings({ "serial", "unused" })
public class Bank1 extends JFrame {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/login?autoReconnect=true&useSSL=false";
    static final String USER = "root";
	static final String PASS = "student";
	static Connection conn = null;
	PreparedStatement stmt = null;
	static Connection conn1 = null;
	PreparedStatement stmt1 = null;
	static String un;
	String pwd;
	String xyz=null;
	SimpleDateFormat date1 = new SimpleDateFormat("dd-MM-yyyy");
	int x=0;
	
	private JPanel contentPane;
	public static JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bank1 frame = new Bank1();
					frame.setVisible(true);
					
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
	public Bank1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 225);
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
				  Date date = new Date();
				  String date2=date1.format(date);			 
				  String sql = "INSERT INTO Bank VALUES(?, ?, 0, ?)";
			      Class.forName("com.mysql.jdbc.Driver");
			      System.out.println("Connecting to database");
				  conn = DriverManager.getConnection(DB_URL, USER, PASS);
				  stmt = conn.prepareStatement(sql);
				  un=textField.getText();
			      pwd=passwordField.getText();
			      stmt.setString(1, un);
			      stmt.setString(2, pwd);
			      stmt.setString(3, date2);
			      //stmt.setString(3, un);
			      String sql1 = "SELECT username from Bank where username = ?";
			      stmt1 = conn.prepareStatement(sql1);
			      stmt1.setString(1, un);
			      ResultSet rs= stmt1.executeQuery();
			      if(rs !=null)
			      {
			    	  while(rs.next())
			    	  {
			    		  xyz=rs.getString("username");
			    		  if(xyz.equals(un))
			    		  {
			    		     JOptionPane.showMessageDialog(null, "The admin disapproves your application. Too bad you can't even be a part of this stupid bank.");  
			    	         x=1;
			    	         break;
			    		  }
			    	  
			      }
			
			if(x!=1)
			      {
				   stmt.execute();
				   JOptionPane.showMessageDialog(null, "The admin approves your registration. Feel privileged.");
			       JOptionPane.showMessageDialog(null, "You're now a stupid Bank user! ");
		          }
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
				if (un.equals("prahlad")!=true)
				{
				if(pwd.equals(xyz)==true)
				{
					JOptionPane.showMessageDialog(null, "Login successful");
					UserControls frame = new UserControls();
					frame.setVisible(true);
				}
				}
				else JOptionPane.showMessageDialog(null, "Failed login");	
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
		
		
		
		JButton btnAdminLogin = new JButton("Admin Login");
		btnAdminLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				if (textField.getText().equals("prahlad") && passwordField.getText().equals("12345678"))
					{
					JOptionPane.showMessageDialog(null, "You're the boss. Admin access granted.");
					dispose();
					AdminControls frame = new AdminControls();
					frame.setVisible(true);
					
					}
				else
					JOptionPane.showMessageDialog(null, "Stop trying. You're not an admin.");
			}
		});
		
		
		GridBagConstraints gbc_btnAdminLogin = new GridBagConstraints();
		gbc_btnAdminLogin.insets = new Insets(0, 0, 5, 5);
		gbc_btnAdminLogin.gridx = 4;
		gbc_btnAdminLogin.gridy = 4;
		contentPane.add(btnAdminLogin, gbc_btnAdminLogin);
			
		
		
		
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.insets = new Insets(0, 0, 5, 5);
		gbc_btnLogin.gridx = 5;
		gbc_btnLogin.gridy = 4;
		contentPane.add(btnLogin, gbc_btnLogin);
	}

}

	
