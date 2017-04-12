import java.sql.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class test extends Applet implements ActionListener{
	  
       static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/login";
	   static final String USER = "root";
	   static final String PASS = "student";
	   TextField username;
	   TextField password;
	   Button login;
	   Button register;
	   
public void init()
{
	username=new TextField("Username");
	password=new TextField("Password");
	password.setEchoChar('*');
	login= new Button("Login");
	register= new Button("Register");
	add(username);
	add(password);
	add(login);
	add(register);
	login.addActionListener(this);
	register.addActionListener(this);
}

 

//public static void main(String[] args) {

public void actionPerformed(ActionEvent e) {
		   String un, pwd;
		   Connection conn = null;
		   PreparedStatement stmt = null;
		   try{
			   Class.forName("com.mysql.jdbc.Driver");
			   System.out.println("Connecting to database");
			   conn = DriverManager.getConnection(DB_URL, USER, PASS);
			   if (e.getSource() == register) 
			      {
			      String sql = "INSERT INTO DETAILS VALUES(?, ?)";
			      stmt = conn.prepareStatement(sql);
			      un=username.getText();
			      pwd=password.getText();
			      stmt.setString(1, un);
			      stmt.setString(2, pwd);
			      stmt.execute();
			      System.out.println(un+ '\t'+ pwd);
			      System.out.println("Inserted successfully");
			      }
			   if (e.getSource() == login) 
			   {
				un=username.getText();
				pwd=password.getText();
				String sql= "SELECT PASSWORD FROM DETAILS WHERE USERNAME = ?";
				stmt = conn.prepareStatement(sql);	
				un=username.getText();
				stmt.setString(1, un);
				ResultSet rs=stmt.executeQuery();
				String xyz=rs.getString("password");
				System.out.println(xyz);
				if(pwd.equals(xyz)==true)
				{
					System.out.println("Success");
				}
				else 
					{
					System.out.println("Failed login");
					}
			
				
			   }
			   }catch(SQLException se){
				   se.printStackTrace();
			   }catch(Exception evt){
			      evt.printStackTrace();
			   }finally{
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
			   System.out.println("Exiting");
			}

}



