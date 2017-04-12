import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

@SuppressWarnings({ "serial" })
public class UserControls extends JFrame {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/login?autoReconnect=true&useSSL=false";
    static final String USER = "root";
	static final String PASS = "student";
	static Connection conn = null;
	PreparedStatement stmt = null;
	String un, date=null;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtDdmmyyyy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserControls frame = new UserControls();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserControls() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 313, 195);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(97, 8, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(24, 41, 46, 14);
		contentPane.add(lblDate);
		
		txtDdmmyyyy = new JTextField();
		txtDdmmyyyy.setText("dd-mm-yyyy");
		txtDdmmyyyy.setBounds(97, 39, 86, 20);
		contentPane.add(txtDdmmyyyy);
		txtDdmmyyyy.setColumns(10);
		
		date=txtDdmmyyyy.getText();
		JButton btnCredit = new JButton("Credit");
		btnCredit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username=Bank1.un;
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
				    System.out.println("Connecting to database");
					conn = DriverManager.getConnection(DB_URL, USER, PASS);
					String sql= "UPDATE Bank SET balance=balance+ ?, udate=? where username = ?";
					int numb=Integer.parseInt(textField.getText());
					stmt = conn.prepareStatement(sql);
					stmt.setInt(1, numb);
					stmt.setString(2, date);
					stmt.setString(3, username);
					stmt.execute();
					JOptionPane.showMessageDialog(null, "Money has been credited to your account. You're a miser. ", "Transaction successful!", 1);
										
			}
			     	catch(SQLException e1){
			         System.out.println("SQL exception occured" + e1);
			      } catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnCredit.setBounds(24, 88, 89, 23);
		contentPane.add(btnCredit);
		
		JButton btnDebit = new JButton("Debit");
		btnDebit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username=Bank1.un;
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
				    System.out.println("Connecting to database");
					conn = DriverManager.getConnection(DB_URL, USER, PASS);
					String sql= "UPDATE Bank SET balance=balance- ?, udate=? where username = ?";
					int numb=Integer.parseInt(textField.getText());
					stmt = conn.prepareStatement(sql);
					stmt.setInt(1, numb);
					stmt.setString(2, date);
					stmt.setString(3, username);
					stmt.execute();
					JOptionPane.showMessageDialog(null, "Money has been debited from your account. Spend wisely!", "Transaction successful", 1);
										
			}
			     	catch(SQLException e1){
			         System.out.println("SQL exception occured" + e1);
			      } catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDebit.setBounds(160, 88, 89, 23);
		contentPane.add(btnDebit);
		
		JLabel lblTransaction = new JLabel("Transaction");
		lblTransaction.setBounds(24, 11, 86, 14);
		contentPane.add(lblTransaction);

		
		JButton btnHome = new JButton("Logout");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				Bank1 frame = new Bank1();
				frame.setVisible(true);
			}
		});
		btnHome.setBounds(160, 122, 89, 23);
		contentPane.add(btnHome);
		
		JButton btnViewBalance = new JButton("View Balance");
		
		btnViewBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
				    System.out.println("Connecting to database");
					conn = DriverManager.getConnection(DB_URL, USER, PASS);
					un=textField.getText();
					String sql= "SELECT Balance FROM Bank WHERE USERNAME = ?";
					stmt = conn.prepareStatement(sql);	
					un=textField.getText();
					stmt.setString(1, un);
					ResultSet rs=stmt.executeQuery();
					if(rs != null)
					{
						while(rs.next())
						{
					        int bal=rs.getInt("Balance");
							JOptionPane.showMessageDialog(null, "Your balance is Rs."+ bal);
						}
					}
				}
					catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
			
		btnViewBalance.setBounds(24, 122, 121, 23);
		contentPane.add(btnViewBalance);
		
	}
}


