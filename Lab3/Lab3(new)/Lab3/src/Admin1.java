import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JEditorPane;
import java.awt.TextArea;


@SuppressWarnings({ "serial", "unused" })
public class Admin1 extends JFrame {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/login?autoReconnect=true&useSSL=false";
    static final String USER = "root";
	static final String PASS = "student";
	static Connection conn = null;
	PreparedStatement stmt = null;
	String un, pwd, xyz=null, username, password, date;
	int balance;
	private JPanel contentPane;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin1 frame = new Admin1();
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
	@SuppressWarnings({ })
	public Admin1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		String[] columnNames = {"Username", "Password", "Balance in Rs.", "Last transaction date"};
	    DefaultTableModel model = new DefaultTableModel(columnNames, 0);
	    
		table_1 = new JTable();
		contentPane.add(table_1, BorderLayout.CENTER);
			try{			
			Class.forName("com.mysql.jdbc.Driver");
		    System.out.println("Connecting to database");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			String sql="SELECT * FROM Bank";
			stmt = conn.prepareStatement(sql);
		    ResultSet rs = stmt.executeQuery();
		    
		     while (rs.next()) {
		    	 
		            username = rs.getString("username");
		            password = rs.getString("password");
		            balance= rs.getInt("balance");
		            date= rs.getString("udate");
		            model.addRow(new Object[]{username, password, balance, date});
		    	}
		           table_1.setModel(model);
		      }
			
		      catch(SQLException e){
		         System.out.println("SQL exception occured" + e);
		      } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			add(new JScrollPane(table_1));
	}

}
