import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings({ "serial", "unused" })
public class DeleteAccount extends JFrame {

	private JPanel contentPane;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/login?autoReconnect=true&useSSL=false";
    static final String USER = "root";
	static final String PASS = "student";
	static Connection conn = null;
	PreparedStatement stmt = null;
	String un, pwd, xyz=null, username, password;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteAccount frame = new DeleteAccount();
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
	public DeleteAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 302, 216);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(43, 71, 71, 14);
		contentPane.add(lblUsername);
		
		JLabel lblBlockAStupid = new JLabel("Block a stupid user");
		lblBlockAStupid.setBounds(78, 21, 150, 14);
		contentPane.add(lblBlockAStupid);
		
		textField = new JTextField();
		textField.setBounds(126, 68, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Block");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
				    System.out.println("Connecting to database");
					conn = DriverManager.getConnection(DB_URL, USER, PASS);
					un=textField.getText();
					String sql= "DELETE from Bank where username = ?";
					stmt = conn.prepareStatement(sql);	
					un=textField.getText();
					stmt.setString(1, un);
					stmt.execute();
					JOptionPane.showMessageDialog(null, "Stupid user blocked!");
			        }
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
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
		
		btnNewButton.setBounds(46, 116, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminControls frame = new AdminControls();
				frame.setVisible(true);
			}
		});
		btnHome.setBounds(165, 116, 89, 23);
		contentPane.add(btnHome);
	}

}
